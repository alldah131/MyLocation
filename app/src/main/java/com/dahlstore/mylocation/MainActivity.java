package com.dahlstore.mylocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double latitude=0, longitude=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getLocation(View v){
        MyListener listener = new MyListener();
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,10,0,listener);
        Toast.makeText(MainActivity.this, String.valueOf(latitude)+" " + String.valueOf(longitude), Toast.LENGTH_LONG).show();

    }

    public class MyListener implements LocationListener{
        @Override
        public void onLocationChanged(Location location) {
            latitude = location.getLatitude();
            latitude= location.getLongitude();

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
    }
}
