package com.com.androidrr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.ReceiverHelper;
import b4a.example.dateutils;

/* loaded from: classes.dex */
public class myreceiver extends BroadcastReceiver {
    private static boolean firstTime = true;
    static myreceiver mostCurrent;
    public static BA processBA;
    private ReceiverHelper _receiver;
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

    public static String _process_globals() throws Exception {
        return "";
    }

    public static Class<?> getObject() {
        return myreceiver.class;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        mostCurrent = this;
        if (processBA == null) {
            BA BA = new BA(context, (BALayout) null, (BA) null, BA.SharedProcessBA.ModuleType.RECEIVER, "com.com.androidrr.myreceiver");
            processBA = BA;
            if (BA.isShellModeRuntimeCheck(BA)) {
                processBA.raiseEvent2(null, true, "SHELL", false, new Object[0]);
            }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals", new Class[0]).invoke(null, null);
                processBA.loadHtSubs(getClass());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        this._receiver = new ReceiverHelper(this);
        if (BA.isShellModeRuntimeCheck(processBA)) {
            BA BA2 = processBA;
            BA2.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.myreceiver", BA2, this._receiver, Float.valueOf(Common.Density));
        }
        processBA.setActivityPaused(false);
        StringBuilder sb = new StringBuilder();
        sb.append("*** Receiver (myreceiver) Receive ");
        sb.append(firstTime ? "(first time)" : "");
        sb.append(" ***");
        BA.LogInfo(sb.toString());
        IntentWrapper intentWrapper = new IntentWrapper();
        intentWrapper.setObject(intent);
        processBA.raiseEvent(null, "receiver_receive", Boolean.valueOf(firstTime), intentWrapper);
        firstTime = false;
    }

    public static String _receiver_receive(boolean z, IntentWrapper intentWrapper) throws Exception {
        Common.LogImpl("620643841", "Receiver_Receive", 0);
        return "";
    }
}
