package io.github.cutelibs.cutenocon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AirplaneReceiver extends BroadcastReceiver {

    AirplaneCallback callback;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            if (callback != null) {
                callback.hasAirplaneMode(intent.getBooleanExtra("state", false));
                Log.e("TAG", "onReceive: airplane" + intent.getBooleanExtra("state", false));
            }
        }
    }

    public void setAirplaneCallback(AirplaneCallback airplaneCallback) {
        this.callback = airplaneCallback;
    }

}
