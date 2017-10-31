
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

public class animator implements IRemote{
	public static animator mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public animator() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, animator.class);
    static {
		mostCurrent = new animator();
        remoteMe = RemoteObject.declareNull("de.sclean.animator");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("animator"), "de.sclean.animator");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("de.sclean.animator"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _setanimat = RemoteObject.createImmutable("");
public static de.sclean.main _main = null;
public static de.sclean.supp _supp = null;
public static de.sclean.option _option = null;
public static de.sclean.starter _starter = null;
public static de.sclean.info _info = null;
public static de.sclean.widget _widget = null;
public static de.sclean.statemanager _statemanager = null;
  public Object[] GetGlobals() {
		return new Object[] {"info",Debug.moduleToString(de.sclean.info.class),"Main",Debug.moduleToString(de.sclean.main.class),"option",Debug.moduleToString(de.sclean.option.class),"setanimat",animator._setanimat,"Starter",Debug.moduleToString(de.sclean.starter.class),"StateManager",Debug.moduleToString(de.sclean.statemanager.class),"supp",Debug.moduleToString(de.sclean.supp.class),"Widget",Debug.moduleToString(de.sclean.widget.class)};
}
}