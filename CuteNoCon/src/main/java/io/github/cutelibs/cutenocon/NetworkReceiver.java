package io.github.cutelibs.cutenocon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkReceiver extends BroadcastReceiver {

    private ConCallback callback;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getExtras() != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = connectivityManager.getActiveNetworkInfo();
            if (ni != null && ni.getState() == NetworkInfo.State.CONNECTED) {
                Log.e("app", "Network " + ni.getTypeName() + " connected");
                if (callback != null) {
                    callback.hasConnection(true);
                }
            }
        }
        if (intent.getExtras().getBoolean(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)) {
            Log.e("app", "There's no network connectivity");
            if (callback != null) {
                callback.hasConnection(false);
            }
        }


    }

    public void setConnectionCallback(ConCallback conCallback) {
        this.callback = conCallback;
    }


}
