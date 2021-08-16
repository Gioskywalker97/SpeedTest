package com.gio.speedtest;

import static android.net.ConnectivityManager.*;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class DataSpeed<startTime, TYPE_MOBILE> {

//    NetworkInfo info = Connectivity.getNetworkInfo(context);
//if(info.getType() == TYPE_WIFI){
//        // do something
//    } else if(info.getType() == TYPE_MOBILE){
//        // check NetworkInfo subtype
//        if(info.getSubtype() == TelephonyManager.NETWORK_TYPE_GPRS){
//            // Bandwidth between 100 kbps and below
//        } else if(info.getSubtype() == TelephonyManager.NETWORK_TYPE_EDGE){
//            // Bandwidth between 50-100 kbps
//        } else if(info.getSubtype() == TelephonyManager.NETWORK_TYPE_EVDO_0){
//            // Bandwidth between 400-1000 kbps
//        } else if(info.getSubtype() == TelephonyManager.NETWORK_TYPE_EVDO_A){
//            // Bandwidth between 600-1400 kbps
//        }
//
//    long startTime;
//    long endTime;
//    long fileSize;
//    OkHttpClient client = new OkHttpClient();
//
//    // bandwidth in kbps
//    private int POOR_BANDWIDTH = 150;
//    private int AVERAGE_BANDWIDTH = 550;
//    private int GOOD_BANDWIDTH = 2000;
//
//    Request request = new Request.Builder()
//            .url("IMAGE_URL_HERE")
//            .build();
//
//    startTime = System.currentTimeMillis();
//
//        client.newCall(request)
//
//    void enqueue(new Callback() {
//        @Override
//        public void onFailure(Request request, IOException e) {
//            e.printStackTrace();
//        }
//
//        @Override
//        public void onResponse(Response response) throws IOException {
//            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
//            Headers responseHeaders = response.headers();
//            for (int i = 0, size = responseHeaders.size(); i < size; i++) {
//                Log.d(TAG, responseHeaders.name(i) + ": " + responseHeaders.value(i));
//            }
//
//            InputStream input = response.body().byteStream();
//
//            try {
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                byte[] buffer = new byte[1024];
//
//                while (input.read(buffer) != -1) {
//                    bos.write(buffer);
//                }
//                byte[] docBuffer = bos.toByteArray();
//                fileSize = bos.size();
//
//            } finally {
//                input.close();
//            }
//
//            endTime = System.currentTimeMillis();
//
//
//            // calculate how long it took by subtracting endtime from starttime
//
//            double timeTakenMills = Math.floor(endTime - startTime);  // time taken in milliseconds
//            double timeTakenSecs = timeTakenMills / 1000;  // divide by 1000 to get time in seconds
//            final int kilobytePerSec = (int) Math.round(1024 / timeTakenInSecs);
//
//            if(kilobytePerSec <= POOR_BANDWIDTH){
//                // slow connection
//            }
//
//            // get the download speed by dividing the file size by time taken to download
//            double speed = fileSize / timeTakenMills;
//
//            Log.d(TAG, "Time taken in secs: " + timeTakenSecs);
//            Log.d(TAG, "kilobyte per sec: " + kilobytePerSec);
//            Log.d(TAG, "Download Speed: " + speed);
//            Log.d(TAG, "File size: " + fileSize);
//
//
//        }
//    });
}
