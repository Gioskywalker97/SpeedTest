package com.gio.speedtest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button testButton = (Button) findViewById(R.id.testButton);
        TextView textView = findViewById(R.id.infoText);
        ToggleButton lightSwitch = findViewById(R.id.lightSwitch);
        View layout = findViewById(R.id.layoutConstraint);
        ImageView sunImage = findViewById(R.id.sunImage);
        ImageView moonImage = findViewById(R.id.moonImage);
        ImageView whiteBolt = findViewById(R.id.whiteBolt);
        ImageView blackBolt = findViewById(R.id.blackBolt);
        ImageView networkWhite = findViewById(R.id.networkCheckWhite);
        ImageView networkBlack = findViewById(R.id.networkCheckBlack);
        TextView upSpeedNum = findViewById(R.id.upSpeedNumber);
        TextView upSpeedText = findViewById(R.id.upSpeedText);
        TextView downSpeedNum = findViewById(R.id.downSpeedNumber);
        TextView downSpeedText = findViewById(R.id.downSpeedText);
        TextView infoTexts = findViewById(R.id.infoText);
        TextView attribute = findViewById(R.id.attribute);
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkCapabilities capabilities = manager.getNetworkCapabilities(manager.getActiveNetwork());
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();

        attribute.setMovementMethod(LinkMovementMethod.getInstance());

        testButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (isNetworkAvailable()) {
                    //testWifiTime();
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        int downSpeeds = capabilities.getLinkDownstreamBandwidthKbps();
                        int upSpeeds = capabilities.getLinkUpstreamBandwidthKbps();
                        downSpeedNum.setText(size(downSpeeds) + "");
                        upSpeedNum.setText(size(upSpeeds) + "");
                        testButton.setText("Test Again?");
                        textView.setVisibility(View.VISIBLE);
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                            int downWifi = wifiInfo.getRxLinkSpeedMbps();
                            int upWifi = wifiInfo.getTxLinkSpeedMbps();
                            downSpeedNum.setText(size(downWifi) + "");
                            upSpeedNum.setText(size(upWifi) + "");
                            testButton.setText("Test Again?");
                            textView.setVisibility(View.VISIBLE);
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, R.string.network_unavailable_message, Toast.LENGTH_LONG).show();
                }
            }
        });

        lightSwitch.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                    if (lightSwitch.isChecked() == false) {
                        layout.setBackgroundColor(Color.BLACK);
                        sunImage.setVisibility(View.INVISIBLE);
                        moonImage.setVisibility(View.VISIBLE);
                        whiteBolt.setVisibility(View.VISIBLE);
                        blackBolt.setVisibility(View.INVISIBLE);
                        upSpeedNum.setTextColor(Color.WHITE);
                        upSpeedText.setTextColor(Color.WHITE);
                        downSpeedNum.setTextColor(Color.WHITE);
                        downSpeedText.setTextColor(Color.WHITE);
                        infoTexts.setTextColor(Color.WHITE);
                        attribute.setTextColor(Color.WHITE);
                        networkWhite.setVisibility(View.VISIBLE);
                        networkBlack.setVisibility(View.INVISIBLE);
                        testButton.setTextColor(Color.WHITE);
                        lightSwitch.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                        lightSwitch.setTextColor(Color.WHITE);
                    } else {
                        moonImage.setVisibility(View.INVISIBLE);
                        sunImage.setVisibility(View.VISIBLE);
                        whiteBolt.setVisibility(View.INVISIBLE);
                        blackBolt.setVisibility(View.VISIBLE);
                        layout.setBackgroundColor(Color.WHITE);
                        upSpeedNum.setTextColor(Color.BLACK);
                        upSpeedText.setTextColor(Color.BLACK);
                        downSpeedNum.setTextColor(Color.BLACK);
                        downSpeedText.setTextColor(Color.BLACK);
                        infoTexts.setTextColor(Color.BLACK);
                        attribute.setTextColor(Color.BLACK);
                        networkWhite.setVisibility(View.INVISIBLE);
                        networkBlack.setVisibility(View.VISIBLE);
                        testButton.setTextColor(Color.BLACK);
                        lightSwitch.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                        lightSwitch.setTextColor(Color.BLACK);
                    }
                }
        });


    }

//    private void testWifiTime() {
//        ProgressBar progressUpdateBar = findViewById(R.id.progressBar2);
//        long endTime = System.currentTimeMillis() + 5 * 1000;
//        while (System.currentTimeMillis() < endTime) {
//            progressUpdateBar.setVisibility(View.VISIBLE);
//        }
//        Log.d(TAG, "Tested Speed!");
//    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkCapabilities capabilities = manager.getNetworkCapabilities(manager.getActiveNetwork());

        boolean isAvailable = false;

        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Toast.makeText(this, R.string.cellular_network,
                        Toast.LENGTH_LONG).show();
                isAvailable = true;
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Toast.makeText(this, R.string.wifi,
                        Toast.LENGTH_LONG).show();
                isAvailable = true;
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Toast.makeText(this, R.string.ethernet_network,
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, R.string.network_unavailable_message,
                        Toast.LENGTH_LONG).show();
            }
        }
        return isAvailable;
    }

    public String size(int size){
        String hrSize = "";
        int k = size;
        double m = size/1024.0;
        double g = size/1048576.0;
        double t = size/1073741824.0;

        DecimalFormat dec = new DecimalFormat("00.0");

        if (t > 1) {
            hrSize = dec.format(t);
        } else if (g > 1) {
            hrSize = dec.format(g);
        } else if (m > 1) {
            hrSize = dec.format(m);
        } else {
            hrSize = dec.format(size);
        }

        return hrSize;
    }


}
