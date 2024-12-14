package com.eziby.eziby_android_app.screens;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.eziby.eziby_android_app.Classes.MySharedPreferences;
import com.eziby.eziby_android_app.MainActivity;
import com.eziby.eziby_android_app.Models.MyUser;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private SignInClient oneTapClient;
    private BeginSignInRequest signInRequest;
    private static final int REQ_ONE_TAP = 200;
    Button btn_signIn;
    ProgressBar progressBar_signIn;
    MySharedPreferences mySharedPreferences;
    Context mContext;
    TextView textViewSignInAs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        btn_signIn = findViewById(R.id.btn_signIn);
        progressBar_signIn = findViewById(R.id.progressBar_signIn);
        textViewSignInAs = findViewById(R.id.textViewSignInAs);
        textViewSignInAs.setText("");
        textViewSignInAs.setVisibility(View.INVISIBLE);
        mContext = this.getApplicationContext();
        mySharedPreferences = new MySharedPreferences(mContext);

//        String email = mySharedPreferences.retrieveString("EMAIL");
//        UserTableHelper userTableHelper = new UserTableHelper(mContext);
//        MyUser myUser = userTableHelper.getUser(email);

        String idToken = null;// myUser.getToken();
        btn_signIn.setEnabled(false);
        progressBar_signIn.setVisibility(View.VISIBLE);
        idTokenSignIn(idToken);
    }

    private void idTokenSignIn(String idToken) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if (idToken != null) {
            String email = mySharedPreferences.getEmail();
            textViewSignInAs.setText(String.format("As " + email));
            textViewSignInAs.setVisibility(View.VISIBLE);
            AuthCredential firebaseCredential = GoogleAuthProvider.getCredential(idToken, null);
            mAuth.signInWithCredential(firebaseCredential)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithCredential:success");
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        } else {
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            textViewSignInAs.setVisibility(View.INVISIBLE);
                            textViewSignInAs.setText("");
                            progressBar_signIn.setVisibility(View.INVISIBLE);
                            btn_signIn.setEnabled(true);
                        }
                    });
        } else {
            textViewSignInAs.setVisibility(View.INVISIBLE);
            textViewSignInAs.setText("");
            progressBar_signIn.setVisibility(View.INVISIBLE);
            btn_signIn.setEnabled(true);
        }

        oneTapClient = Identity.getSignInClient(this);
        signInRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        .setServerClientId(getString(R.string.GoogleClientID))
                        .setFilterByAuthorizedAccounts(false)
                        .build())
                .setAutoSelectEnabled(false)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
    }

    public void buttonGoogleSignIn_onClick(View view) {
        oneTapClient.beginSignIn(signInRequest)
                .addOnSuccessListener(this, result -> {
                    try {
                        startIntentSenderForResult(
                                result.getPendingIntent().getIntentSender(), REQ_ONE_TAP,
                                null, 0, 0, 0);
                    } catch (IntentSender.SendIntentException e) {
                        Log.e(TAG, "Couldn't start One Tap UI: " + e.getLocalizedMessage());
                    }
                })
                .addOnFailureListener(this, e -> Log.d(TAG, Objects.requireNonNull(e.getLocalizedMessage())));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_ONE_TAP) {
            try {
                SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(data);
                String idToken = credential.getGoogleIdToken();
                String emailAddress = credential.getId();
                String displayName = credential.getDisplayName();
                assert credential.getProfilePictureUri() != null;
                String profilePictureUri = credential.getProfilePictureUri().toString();

                MyUser myUser = new MyUser();
                myUser.setToken(idToken);
                myUser.setEmailAddress(emailAddress);
                myUser.setDisplayName(displayName);
                myUser.setProfilePictureUri(profilePictureUri);
                myUser.setSubscribedToNewsLetter(false);
                myUser.setBackgroundMusic(false);
                myUser.setContribution(String.valueOf(0));
                myUser.setMemberSince(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                myUser.setRatings(String.valueOf(3));

                //saving the user details if not found
                try (DbHelper dbHelper = new DbHelper(this.mContext)) {
                    if (!dbHelper.hasUser(myUser.getEmailAddress())) {
                        boolean userInserted = dbHelper.insertUser(myUser);
                        if (userInserted) Log.d(TAG, "User Added" + myUser.getEmailAddress());
                    }
                }

                if (idToken != null) {
                    mySharedPreferences.saveEmail(emailAddress);
                    Log.d(TAG, "Email - " + emailAddress + ", ID token - " + idToken);
                }
                Toast.makeText(this, emailAddress + " Logged-In.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            } catch (ApiException e) {
                Toast.makeText(this, "Not Logged-In.", Toast.LENGTH_SHORT).show();
                Log.d(TAG, Objects.requireNonNull(e.getMessage()));
            }
        }
    }
}
