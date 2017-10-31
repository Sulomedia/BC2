
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

public class widget implements IRemote{
	public static widget mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public widget() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("widget"), "de.sclean.widget");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("de.sclean.widget");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, widget.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _rv = RemoteObject.declareNull("anywheresoftware.b4a.objects.RemoteViewsWrapper");
public static RemoteObject _kvsdata = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _alist = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _cts = RemoteObject.declareNull("com.rootsoft.customtoast.CustomToast");
public static RemoteObject _mcl = RemoteObject.declareNull("com.tchart.materialcolors.MaterialColors");
public static de.sclean.main _main = null;
public static de.sclean.supp _supp = null;
public static de.sclean.option _option = null;
public static de.sclean.starter _starter = null;
public static de.sclean.info _info = null;
public static de.sclean.statemanager _statemanager = null;
public static de.sclean.animator _animator = null;
  public Object[] GetGlobals() {
		return new Object[] {"alist",widget._alist,"Animator",Debug.moduleToString(de.sclean.animator.class),"cts",widget._cts,"info",Debug.moduleToString(de.sclean.info.class),"kvsdata",widget._kvsdata,"Main",Debug.moduleToString(de.sclean.main.class),"mcl",widget._mcl,"option",Debug.moduleToString(de.sclean.option.class),"rv",widget._rv,"Service",widget.mostCurrent._service,"Starter",Debug.moduleToString(de.sclean.starter.class),"StateManager",Debug.moduleToString(de.sclean.statemanager.class),"supp",Debug.moduleToString(de.sclean.supp.class)};
}
}