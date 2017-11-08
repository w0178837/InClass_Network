package com.example.w0178837.inclass_network;

import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.content.*;
import android.view.*;
import android.view.View;
import android.widget.*;
import android.net.*;

// add the following to your manifest after the </application> tag
// <uses-permission android:name="android.permission.INTERNET"/>
// <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

public class MainActivity extends AppCompatActivity {
    private static boolean wifiConnected = false;
    private static boolean mobileConnected = false;
    Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnect = (Button) findViewById(R.id.btnConnect);

        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkNetworkConnection();
            }
        });
    }// end on create

    public void checkNetworkConnection(){

        ConnectivityManager conManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeInfo = conManager.getActiveNetworkInfo();

        if(activeInfo != null && activeInfo.isConnected())
        {
            wifiConnected = activeInfo.getType() == conManager.TYPE_WIFI;
            mobileConnected = activeInfo.getType() == conManager.TYPE_MOBILE;
        }
        if(wifiConnected)
        {
            Toast.makeText(getBaseContext(), "wifi connected", Toast.LENGTH_LONG).show();
        }else if (mobileConnected){
            Toast.makeText(getBaseContext(), "mobile connected", Toast.LENGTH_LONG).show();
        }

    }// end checkNetworkConnection()

}// end class
