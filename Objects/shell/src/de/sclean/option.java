
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

public class option implements IRemote{
	public static option mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public option() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("option"), "de.sclean.option");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, option.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _rfont = RemoteObject.declareNull("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
public static RemoteObject _acb1 = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACCheckBoxWrapper");
public static RemoteObject _ctext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _mtext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _ab1 = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACButtonWrapper");
public static RemoteObject _lv2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _mcl = RemoteObject.declareNull("com.tchart.materialcolors.MaterialColors");
public static de.sclean.main _main = null;
public static de.sclean.supp _supp = null;
public static de.sclean.starter _starter = null;
public static de.sclean.info _info = null;
public static de.sclean.widget _widget = null;
public static de.sclean.statemanager _statemanager = null;
public static de.sclean.animator _animator = null;
  public Object[] GetGlobals() {
		return new Object[] {"ab1",option.mostCurrent._ab1,"acb1",option.mostCurrent._acb1,"Activity",option.mostCurrent._activity,"Animator",Debug.moduleToString(de.sclean.animator.class),"Ctext",option.mostCurrent._ctext,"info",Debug.moduleToString(de.sclean.info.class),"lv2",option.mostCurrent._lv2,"Main",Debug.moduleToString(de.sclean.main.class),"mcl",option.mostCurrent._mcl,"Mtext",option.mostCurrent._mtext,"Panel1",option.mostCurrent._panel1,"rfont",option._rfont,"Starter",Debug.moduleToString(de.sclean.starter.class),"StateManager",Debug.moduleToString(de.sclean.statemanager.class),"supp",Debug.moduleToString(de.sclean.supp.class),"Widget",Debug.moduleToString(de.sclean.widget.class)};
}
}