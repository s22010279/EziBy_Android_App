package com.eziby.eziby_android_app.Classes;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.List;
import java.util.Locale;

public class MyGeoLocation extends AppCompatActivity implements LocationListener {
    public static final String TAG = "LocationValues";

    public Location currentLocation;
    Context mContext;
    Activity mActivity;

    public MyGeoLocation(Context context, Activity activity) {
        this.mContext = context;
        this.mActivity = activity;
        getCurrentLocation();
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        try {
            currentLocation = location;
            Log.e(TAG, "Latitude - " + currentLocation.getLatitude() + ", Longitude - " + currentLocation.getLongitude());
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
            List<Address> addressList = geocoder.getFromLocation(currentLocation.getLatitude(), currentLocation.getLongitude(), 10);
            assert addressList != null;
            Log.e(TAG, "First Address  - " + addressList.get(0).getAddressLine(0));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage() + ".");
        }
    }

    public void getCurrentLocation() {
        LocationManager locationManager = (LocationManager) mContext.getApplicationContext().getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mActivity, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, MyGeoLocation.this);
    }
}
