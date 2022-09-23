package io.github.cutelibs.cutenocon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

public class WifiOnReceiver extends BroadcastReceiver {

    WifiOnCallback callback;

    @Override
    public void onReceive(Context context, Intent intent) {
        WifiManager wifi = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if (wifi != null) {
            if (wifi.isWifiEnabled()) {
                if (callback != null) {
                    callback.tunedOn(true);
                }
            } else {
                if (callback != null) {
                    callback.tunedOn(false);
                }
            }
        }

    }

    public void setConnectionCallback(WifiOnCallback wifiOnCallback) {
        this.callback = wifiOnCallback;
    }

}
