package io.github.cutelibs.cutenocon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class WifiReceiver extends BroadcastReceiver {

    WifiCallback callback;

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = connectivityManager.getActiveNetworkInfo();

        if (ni != null && ni.getType() == ConnectivityManager.TYPE_WIFI) {
            if (callback != null) {
                callback.hasWifiConnection(true);
            }
        } else {
            if (callback != null) {
                callback.hasWifiConnection(false);
            }
        }

    }

    public void setConnectionCallback(WifiCallback wifiCallback) {
        this.callback = wifiCallback;
    }


}
