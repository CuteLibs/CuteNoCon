package io.github.cutelibs.cutenocon;

import static android.view.View.VISIBLE;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import io.github.cutelibs.cutenocon.databinding.CuteNoConMainBinding;

public class CuteNoCon extends Dialog implements ConCallback, WifiCallback, AirplaneCallback {

    private final Context context;
    private final CuteNoConMainBinding binding;
    NetworkReceiver networkReceiver;
    WifiReceiver wifiReceiver;
    WifiCallback wifiCallback;
    AirplaneReceiver airplaneReceiver;
    AirplaneCallback airplaneCallback;
    private ConCallback conCallback;

    public CuteNoCon(Context context) {
        super(context);
        this.context = context;
        binding = CuteNoConMainBinding.inflate(getLayoutInflater());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getWindow().setLayout(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        setContentView(binding.getRoot());

        initReceiver();
        initUI();
        setUpClicks();


    }

    @Override
    public void hasConnection(boolean hasConnection) {
        if (conCallback != null) {
            conCallback.hasConnection(hasConnection);
        }
        if (!hasConnection) {
            showHideAirplaneMode();
            show();
        } else {
            binding.progressBar.setVisibility(View.GONE);
            Log.e("TAG", "hasConnection: dismissed");
            new Handler().postDelayed(this::dismiss, 500);
        }

    }

    @Override
    public void hasWifiConnection(boolean isConnected) {
        if (wifiCallback != null) {
            wifiCallback.hasWifiConnection(isConnected);
        }
        if (isConnected) {
            binding.progressBar.setVisibility(View.GONE);
        }

    }

    private void setUpClicks() {

        binding.airplaneButton.setOnClickListener(v -> {

            NetUtils.turnOffAirplaneMode(context);
            binding.progressBar.setVisibility(VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    showHideAirplaneMode();
                    binding.progressBar.setVisibility(View.GONE);
                }
            }, 500);

        });

        binding.wifiButton.setOnClickListener(v -> {
            if (!NetUtils.isWifiConnected(context)) {
                NetUtils.turnOnWifi(context);
                binding.progressBar.setVisibility(VISIBLE);
            }

        });

        binding.dataButton.setOnClickListener(v -> {

            if (!NetUtils.isMobileConnected(context)) {
                NetUtils.turnOnMobileData(context);
            }
        });

    }


    private void initReceiver() {
        networkReceiver = new NetworkReceiver();
        context.registerReceiver(networkReceiver, new android.content.IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
        networkReceiver.setConnectionCallback(this);

        wifiReceiver = new WifiReceiver();
        context.registerReceiver(wifiReceiver, new android.content.IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
        wifiReceiver.setConnectionCallback(this);

        airplaneReceiver = new AirplaneReceiver();
        context.registerReceiver(airplaneReceiver, new android.content.IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
        airplaneReceiver.setAirplaneCallback(this);

    }

    private void initUI() {

        getWindow().setGravity(android.view.Gravity.CENTER);
        setCancelable(false);


    }

    public void setConnectionCallback(ConCallback conCallback) {
        this.conCallback = conCallback;
    }

    private void showHideAirplaneMode() {
        if (NetUtils.isAirplaneModeOn(context)) {
            binding.airplaneLayout.setVisibility(VISIBLE);
            binding.dataWifiLayout.setVisibility(android.view.View.GONE);
        } else {
            binding.airplaneLayout.setVisibility(android.view.View.GONE);
            binding.dataWifiLayout.setVisibility(VISIBLE);
        }
    }


    @Override
    public void hasAirplaneMode(boolean hasAirplaneMode) {
        if (airplaneCallback != null) {
            airplaneCallback.hasAirplaneMode(hasAirplaneMode);
        }
        if (hasAirplaneMode) {
            binding.airplaneLayout.setVisibility(VISIBLE);
            binding.dataWifiLayout.setVisibility(android.view.View.GONE);
        } else {
            binding.airplaneLayout.setVisibility(android.view.View.GONE);
            binding.dataWifiLayout.setVisibility(VISIBLE);
        }

    }
}
