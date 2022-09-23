package io.github.cutelibs.cutenocon;

import static android.provider.Settings.Global.AIRPLANE_MODE_ON;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUtils {



    // check active connection using http request
    public static boolean isConnectionActive() {

        try {
            HttpURLConnection con = (HttpURLConnection) (new URL("https://www.google.com").openConnection());
            con.setRequestProperty("User-Agent", "Test");
            con.setRequestProperty("Connection", "close");
            con.setConnectTimeout(1500);
            con.connect();

            Log.e("TAG", "isConnectionActive: " + con.getResponseCode());

            return con.getResponseCode() == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;


    }

    // check for wifi connection
    public static boolean isWifiConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        Log.e("TAG", "isWifiConnected: " + wifiInfo.isConnected());
        return wifiInfo.isConnected();
    }

    // check for mobile connection
    public static boolean isMobileConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobileInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        Log.e("TAG", "isMobileConnected: " + mobileInfo.isConnected());
        return mobileInfo.isConnected();
    }

    // check for airplane mode
    public static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), AIRPLANE_MODE_ON, 0) != 0;
    }

    // turn on wifi
    public static void turnOnWifi(Context context) {
        context.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    // turn on mobile data
    public static void turnOnMobileData(Context context) {
        context.startActivity(new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS));
    }

    // turn off airplane mode
    public static void turnOffAirplaneMode(Context context) {
        context.startActivity(new Intent(android.provider.Settings.ACTION_AIRPLANE_MODE_SETTINGS));

    }


}
