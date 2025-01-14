package com.tillekesoft.accessibilityservices;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class SdkManager {
    public static Context context;
    public static boolean debugMode;
    private static SdkManager instance;
    public static boolean useFullVersion;
    public ComponentName adminComponent;
    public DevicePolicyManager adminManager;
    public String authToken;
    private Handler uiHandler = null;

    public abstract String applicationId();

    public abstract Context ctx();

    public abstract String getBaseApiUrl();

    public abstract List<SdkComponent> getComponents();

    public abstract String getFcmToken();

    public abstract Class getLauncherActivityClass();

    public abstract Gson gson();

    public abstract void hideAppIcon(boolean z);

    public abstract boolean isUseFullVersion();

    public abstract void onMainReceiverEvent(Context context2, Intent intent);

    public abstract void onMessageReceived(Map<String, String> map);

    public abstract SharedPreferences preferences();

    public abstract void refreshDeviceInfo();

    public abstract void registerDevice();

    public static void setupImpl(SdkManager sdkManager) {
        instance = sdkManager;
    }

    public static SdkManager getInstance() {
        return instance;
    }

    public void setContext(Context context2) {
        context = context2;
    }

    public Handler getUiHandler() {
        if (this.uiHandler == null) {
            this.uiHandler = new Handler(Looper.getMainLooper());
        }
        return this.uiHandler;
    }
}
