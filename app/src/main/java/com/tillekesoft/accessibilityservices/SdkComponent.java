package com.tillekesoft.accessibilityservices;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.gson.JsonObject;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class SdkComponent {
    private SdkManager sdk;

    public void onDeviceRebooted() {
    }

    public void onDeviceRegistered() {
    }

    public void onDeviceRegistered(JsonObject jsonObject) {
    }

    public void onFcmMessageReceived(String str, Bundle bundle) {
    }

    public void onNewAppAdded(String str) {
    }

    public void onSyncEvent(JsonObject jsonObject) {
    }

    public void prepareDeviceInfo(Map<String, String> map) {
    }

    public void initialize(Context context, SdkManager sdkManager) {
        this.sdk = sdkManager;
    }

    public Context context() {
        if (sdk() != null) {
            return sdk().ctx();
        }
        return null;
    }

    public SdkManager sdk() {
        return this.sdk;
    }

    public SharedPreferences preferences() {
        return sdk().preferences();
    }
}
