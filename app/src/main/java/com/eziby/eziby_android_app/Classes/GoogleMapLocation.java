package com.eziby.eziby_android_app.Classes;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.eziby.eziby_android_app.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class GoogleMapLocation extends AppCompatActivity implements OnMapReadyCallback {

    boolean locationPermissionGranted = true    ;
//    MapView mapView;
//
    GoogleMap map;
//    LatLng position = new LatLng(-33.920455, 18.466941);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

//        // Get the SupportMapFragment and request notification when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
//        LatLng sydney = new LatLng(6.98124314524979, 79.89517875034305);
//        googleMap.addMarker(new MarkerOptions()
//                .position(sydney)
//                .title("Marker in Sydney"));


        this.map = map;

        // ...

        // Turn on the My Location layer and the related control on the map.
        updateLocationUI();

    }


    private void updateLocationUI() {
        if (map == null) {
            return;
        }
        try {
            if (locationPermissionGranted) {
                map.setMyLocationEnabled(true);
                map.getUiSettings().setMyLocationButtonEnabled(true);
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
        }
    }


//    @Override
//    public void onLocationChanged(@NonNull Location location) {
//        TextView locationTv = (TextView) findViewById(R.id.abc);
//        double latitude = location.getLatitude();
//        double longitude = location.getLongitude();
//        //LatLng latLng = new LatLng(latitude, longitude);
////        googleMap.addMarker(new MarkerOptions().position(latLng));
////        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
////        googleMap.animateCamera(CameraUpdateFactory.zoomTo(21));
//        String xyz = "Latitude:" + latitude + ", Longitude:" + longitude;
//        locationTv.setText(xyz);

}


