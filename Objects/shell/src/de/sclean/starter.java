
package de.sclean;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class starter implements IRemote{
	public static starter mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public starter() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("starter"), "de.sclean.starter");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("de.sclean.starter");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, starter.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _cb = RemoteObject.declareNull("anywheresoftware.b4a.cachecleaner.CacheCleaner");
public static RemoteObject _t2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _t3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _name = RemoteObject.createImmutable("");
public static RemoteObject _apath = RemoteObject.createImmutable("");
public static RemoteObject _l = RemoteObject.createImmutable("");
public static RemoteObject _types = null;
public static RemoteObject _packname = RemoteObject.createImmutable("");
public static RemoteObject _app = null;
public static RemoteObject _counter = RemoteObject.createImmutable(0);
public static RemoteObject _cts = RemoteObject.declareNull("com.rootsoft.customtoast.CustomToast");
public static RemoteObject _piclist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _obj = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _date = RemoteObject.createImmutable("");
public static RemoteObject _time = RemoteObject.createImmutable("");
public static RemoteObject _dir = RemoteObject.createImmutable("");
public static RemoteObject _kvst = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _kvsdata = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _alist = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _dbase = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _abase = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _apli = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _pack = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
public static de.sclean.main _main = null;
public static de.sclean.supp _supp = null;
public static de.sclean.option _option = null;
public static de.sclean.info _info = null;
public static de.sclean.widget _widget = null;
public static de.sclean.statemanager _statemanager = null;
public static de.sclean.animator _animator = null;
  public Object[] GetGlobals() {
		return new Object[] {"abase",starter._abase,"alist",starter._alist,"Animator",Debug.moduleToString(de.sclean.animator.class),"apath",starter._apath,"apli",starter._apli,"app",starter._app,"cb",starter._cb,"counter",starter._counter,"cts",starter._cts,"date",starter._date,"dbase",starter._dbase,"dir",starter._dir,"info",Debug.moduleToString(de.sclean.info.class),"kvsdata",starter._kvsdata,"kvst",starter._kvst,"l",starter._l,"Main",Debug.moduleToString(de.sclean.main.class),"name",starter._name,"obj",starter._obj,"option",Debug.moduleToString(de.sclean.option.class),"pack",starter._pack,"packName",starter._packname,"piclist",starter._piclist,"Service",starter.mostCurrent._service,"StateManager",Debug.moduleToString(de.sclean.statemanager.class),"supp",Debug.moduleToString(de.sclean.supp.class),"t2",starter._t2,"t3",starter._t3,"time",starter._time,"Types",starter._types,"Widget",Debug.moduleToString(de.sclean.widget.class)};
}
}