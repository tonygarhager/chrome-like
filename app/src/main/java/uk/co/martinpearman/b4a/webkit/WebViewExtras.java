package uk.co.martinpearman.b4a.webkit;

import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.WebViewWrapper;
import anywheresoftware.b4a.objects.collections.Map;
import java.util.HashMap;

@BA.Version(2.2f)
@BA.Author("Martin Pearman")
@BA.ShortName("WebViewExtras")
/* loaded from: classes.dex */
public class WebViewExtras extends WebViewWrapper {
    /* JADX WARN: Multi-variable type inference failed */
    public void AddJavascriptInterface(Object obj, String str) {
        ((WebView) getObject()).addJavascriptInterface(obj, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean CanGoback() {
        return ((WebView) getObject()).canGoBack();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean CanGoBackOrForward(int i) {
        return ((WebView) getObject()).canGoBackOrForward(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean CanZoomIn() {
        return ((WebView) getObject()).canZoomIn();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean CanZoomOut() {
        return ((WebView) getObject()).canZoomOut();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ClearCache(boolean z) {
        ((WebView) getObject()).clearCache(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ClearFormData() {
        ((WebView) getObject()).clearFormData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ClearHistory() {
        ((WebView) getObject()).clearHistory();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ClearSslPreferences() {
        ((WebView) getObject()).clearSslPreferences();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebBackForwardList CopyBackForwardList() {
        return new WebBackForwardList(((WebView) getObject()).copyBackForwardList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ExecuteJavascript(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            ((WebView) getObject()).evaluateJavascript(str, null);
            return;
        }
        ((WebView) getObject()).loadUrl("javascript:" + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int FindAll(String str) {
        return ((WebView) getObject()).findAll(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void FindAllAsynch(String str) {
        ((WebView) getObject()).findAllAsync(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void FindNext(boolean z) {
        ((WebView) getObject()).findNext(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void FlingScroll(int i, int i2) {
        ((WebView) getObject()).flingScroll(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void FreeMemory() {
        ((WebView) getObject()).freeMemory();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int GetContentHeight() {
        return ((WebView) getObject()).getContentHeight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bitmap GetFavicon() {
        return ((WebView) getObject()).getFavicon();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String[] GetHttpAuthUsernamePassword(String str, String str2) {
        return ((WebView) getObject()).getHttpAuthUsernamePassword(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String GetOriginalUrl() {
        return ((WebView) getObject()).getOriginalUrl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int GetProgress() {
        return ((WebView) getObject()).getProgress();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float GetScale() {
        return ((WebView) getObject()).getScale();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebSettings GetSettings() {
        return new WebSettings(((WebView) getObject()).getSettings());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String GetTitle() {
        return ((WebView) getObject()).getTitle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void GoBackOrForward(int i) {
        ((WebView) getObject()).goBackOrForward(i);
    }

    public void Initialize(WebView webView) {
        setObject(webView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void InvokeZoomPicker() {
        ((WebView) getObject()).invokeZoomPicker();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean IsPrivateBrowsingEnabled() {
        return ((WebView) getObject()).isPrivateBrowsingEnabled();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void LoadUrl2(String str, Map map) {
        HashMap hashMap = new HashMap();
        int size = map.getSize();
        for (int i = 0; i < size; i++) {
            hashMap.put((String) map.GetKeyAt(i), (String) map.GetValueAt(i));
        }
        ((WebView) getObject()).loadUrl(str, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean OverlayHorizontalScrollbar() {
        return ((WebView) getObject()).overlayHorizontalScrollbar();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean OverlayVerticalScrollbar() {
        return ((WebView) getObject()).overlayVerticalScrollbar();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean PageDown(boolean z) {
        return ((WebView) getObject()).pageDown(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean PageUp(boolean z) {
        return ((WebView) getObject()).pageUp(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void PauseTimers() {
        ((WebView) getObject()).pauseTimers();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void PostUrl(String str, byte[] bArr) {
        ((WebView) getObject()).postUrl(str, bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Reload() {
        ((WebView) getObject()).reload();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void RemoveJavascriptInterface(String str) {
        ((WebView) getObject()).removeJavascriptInterface(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ResumeTimers() {
        ((WebView) getObject()).resumeTimers();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SavePassword(String str, String str2, String str3) {
        ((WebView) getObject()).savePassword(str, str2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SaveWebArchive(String str) {
        ((WebView) getObject()).saveWebArchive(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SetFindListener(WebView.FindListener findListener) {
        ((WebView) getObject()).setFindListener(findListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SetHorizontalScrollbarOverlay(boolean z) {
        ((WebView) getObject()).setHorizontalScrollbarOverlay(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SetHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        ((WebView) getObject()).setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SetInitialScale(int i) {
        ((WebView) getObject()).setInitialScale(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SetNetworkAvailable(boolean z) {
        ((WebView) getObject()).setNetworkAvailable(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SetOverScrollMode(int i) {
        ((WebView) getObject()).setOverScrollMode(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SetScrollBarStyle(int i) {
        ((WebView) getObject()).setScrollBarStyle(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SetVerticalScrollbarOverlay(boolean z) {
        ((WebView) getObject()).setVerticalScrollbarOverlay(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SetWebChromeClient(WebChromeClient webChromeClient) {
        ((WebView) getObject()).setWebChromeClient(webChromeClient);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SetWebViewClient(WebViewClient webViewClient) {
        ((WebView) getObject()).setWebViewClient(webViewClient);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean ShowFindDialog(String str, boolean z) {
        return ((WebView) getObject()).showFindDialog(str, z);
    }
}