package uk.co.martinpearman.b4a.webkit;

import android.webkit.JavascriptInterface;
import anywheresoftware.b4a.BA;

@BA.ShortName("DefaultJavascriptInterface")
public final class DefaultJavascriptInterface {
    private BA mBA;
    private int mTaskId = 0;

    @JavascriptInterface
    public String CallSub(String str, boolean z) {
        String lowerCase = str.toLowerCase();
        if (!this.mBA.subExists(lowerCase)) {
            return "JavascriptInterface error: " + str + " does not exist";
        }
        if (z) {
            BA ba = this.mBA;
            int i = this.mTaskId;
            this.mTaskId = i + 1;
            return (String) ba.raiseEventFromDifferentThread(this, this, i, lowerCase, false, new Object[0]);
        }
        return (String) this.mBA.raiseEvent(this, lowerCase, new Object[0]);
    }

    @JavascriptInterface
    public String CallSub(String str, boolean z, String str2) {
        String lowerCase = str.toLowerCase();
        if (!this.mBA.subExists(lowerCase)) {
            return "JavascriptInterface error: " + str + " does not exist";
        }
        Object[] objArr = {str2};
        if (z) {
            BA ba = this.mBA;
            int i = this.mTaskId;
            this.mTaskId = i + 1;
            return (String) ba.raiseEventFromDifferentThread(this, this, i, lowerCase, false, objArr);
        }
        return (String) this.mBA.raiseEvent(this, lowerCase, objArr);
    }

    @JavascriptInterface
    public String CallSub(String str, boolean z, String str2, String str3) {
        String lowerCase = str.toLowerCase();
        if (!this.mBA.subExists(lowerCase)) {
            return "JavascriptInterface error: " + str + " does not exist";
        }
        Object[] objArr = {str2, str3};
        if (z) {
            BA ba = this.mBA;
            int i = this.mTaskId;
            this.mTaskId = i + 1;
            return (String) ba.raiseEventFromDifferentThread(this, this, i, lowerCase, false, objArr);
        }
        return (String) this.mBA.raiseEvent(this, lowerCase, objArr);
    }

    @JavascriptInterface
    public String CallSub(String str, boolean z, String str2, String str3, String str4) {
        String lowerCase = str.toLowerCase();
        if (!this.mBA.subExists(lowerCase)) {
            return "JavascriptInterface error: " + str + " does not exist";
        }
        Object[] objArr = {str2, str3, str4};
        if (z) {
            BA ba = this.mBA;
            int i = this.mTaskId;
            this.mTaskId = i + 1;
            return (String) ba.raiseEventFromDifferentThread(this, this, i, lowerCase, false, objArr);
        }
        return (String) this.mBA.raiseEvent(this, lowerCase, objArr);
    }

    public void Initialize(BA ba) {
        this.mBA = ba;
    }
}