package com.tillekesoft.accessibilityservices;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* loaded from: classes.dex */
public class WriteSettingsHandler {
    public static boolean canWriteSettings(Context context) {
        return Settings.System.canWrite(context);
    }

    public static void requestWriteSettingsPermission(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }

    public static boolean isPermissionGranted(Context context) {
        return canWriteSettings(context);
    }

    public static boolean onAccessibilityEvent(AccessibilityEventsListenerWrapper accessibilityEventsListenerWrapper, AccessibilityEvent accessibilityEvent, String str) {
        AccessibilityNodeInfo findAndGetFirstSimilar;
        AccessibilityNodeInfo findAndGetFirstSimilar2;
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
        if (accessibilityEvent.getSource() != null && accessibilityEvent.getClassName() != null) {
            if (accessibilityEvent.getClassName().equals("com.android.settings.Settings$WriteSettingsActivity")) {
                try {
                    Thread.sleep(2000L);
                } catch (Exception unused) {
                }
                List<AccessibilityNodeInfo> findAndGetAllNode = AccessibilityEventsListenerWrapper.findAndGetAllNode(source, str, false);
                for (AccessibilityNodeInfo accessibilityNodeInfo : findAndGetAllNode) {
                    if (!findAndGetAllNode.isEmpty() && (findAndGetFirstSimilar2 = AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(accessibilityNodeInfo, "android:id/switch_widget", true)) != null && findAndGetFirstSimilar2.isCheckable() && !findAndGetFirstSimilar2.isChecked() && accessibilityEventsListenerWrapper.performClick(findAndGetFirstSimilar2, "switch")) {
                        return true;
                    }
                }
            } else if (accessibilityEvent.getClassName().equals("com.android.settings.Settings$AppWriteSettingsActivity") && (findAndGetFirstSimilar = AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(source, "android:id/switch_widget", true)) != null && findAndGetFirstSimilar.isCheckable() && !findAndGetFirstSimilar.isChecked() && accessibilityEventsListenerWrapper.performClick(findAndGetFirstSimilar, "switch")) {
                return true;
            }
        }
        return false;
    }
}
