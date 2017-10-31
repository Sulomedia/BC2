
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "de.sclean.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _os = RemoteObject.declareNull("com.rootsoft.oslibrary.OSLibrary");
public static RemoteObject _date = RemoteObject.createImmutable("");
public static RemoteObject _time = RemoteObject.createImmutable("");
public static RemoteObject _rfont = RemoteObject.declareNull("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
public static RemoteObject _package = RemoteObject.createImmutable("");
public static RemoteObject _t1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _t2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _utext = RemoteObject.createImmutable("");
public static RemoteObject _pack = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
public static RemoteObject _mcl = RemoteObject.declareNull("com.tchart.materialcolors.MaterialColors");
public static RemoteObject _lv1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _ac = RemoteObject.declareNull("de.amberhome.objects.appcompat.AppCompatBase");
public static RemoteObject _xmsos = RemoteObject.declareNull("com.maximussoft.msos.MSOS");
public static RemoteObject _xosstats = RemoteObject.declareNull("b4a.example.osstats");
public static RemoteObject _dir = RemoteObject.createImmutable("");
public static RemoteObject _kvst = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _kvsdata = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _alist = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _dbase = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _abase = RemoteObject.declareNull("de.sclean.keyvaluestore");
public static RemoteObject _paths = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _im1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _olist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _leftlist = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _sm = RemoteObject.declareNull("anywheresoftware.b4a.objects.SlidingMenuWrapper");
public static RemoteObject _counter = RemoteObject.createImmutable(0);
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _abhelper = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACActionBar");
public static RemoteObject _toolbar = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACToolbarDarkWrapper");
public static RemoteObject _dia = RemoteObject.declareNull("de.amberhome.materialdialogs.MaterialDialogWrapper");
public static RemoteObject _ipan2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _ss = RemoteObject.declareNull("circleprogressmasterwrapper.donutProgressMasterWrapper");
public static RemoteObject _ldim = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pdim = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lolist = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _tota = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _extrapan = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pn = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pb1 = RemoteObject.declareNull("circleprogressmasterwrapper.arcProgressMasterWrapper");
public static RemoteObject _pb2 = RemoteObject.declareNull("circleprogressmasterwrapper.arcProgressMasterWrapper");
public static RemoteObject _args = null;
public static RemoteObject _obj1 = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
public static RemoteObject _obj2 = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
public static RemoteObject _obj3 = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
public static RemoteObject _size = RemoteObject.createImmutable(0);
public static RemoteObject _flags = RemoteObject.createImmutable(0);
public static RemoteObject _name = RemoteObject.createImmutable("");
public static RemoteObject _apath = RemoteObject.createImmutable("");
public static RemoteObject _l = RemoteObject.createImmutable("");
public static RemoteObject _types = null;
public static RemoteObject _packname = RemoteObject.createImmutable("");
public static RemoteObject _sl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _sr = RemoteObject.declareNull("anywheresoftware.b4a.objects.ProgressBarWrapper");
public static RemoteObject _ready = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _prb = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACFlatButtonWrapper");
public static de.sclean.supp _supp = null;
public static de.sclean.option _option = null;
public static de.sclean.starter _starter = null;
public static de.sclean.info _info = null;
public static de.sclean.widget _widget = null;
public static de.sclean.statemanager _statemanager = null;
public static de.sclean.animator _animator = null;
  public Object[] GetGlobals() {
		return new Object[] {"abase",main.mostCurrent._abase,"ABHelper",main.mostCurrent._abhelper,"ac",main.mostCurrent._ac,"Activity",main.mostCurrent._activity,"alist",main.mostCurrent._alist,"Animator",Debug.moduleToString(de.sclean.animator.class),"apath",main.mostCurrent._apath,"args",main.mostCurrent._args,"counter",main._counter,"date",main._date,"dbase",main.mostCurrent._dbase,"dia",main.mostCurrent._dia,"dir",main.mostCurrent._dir,"extrapan",main.mostCurrent._extrapan,"flags",main._flags,"im1",main.mostCurrent._im1,"info",Debug.moduleToString(de.sclean.info.class),"ipan2",main.mostCurrent._ipan2,"kvsdata",main.mostCurrent._kvsdata,"kvst",main.mostCurrent._kvst,"l",main.mostCurrent._l,"ldim",main.mostCurrent._ldim,"leftlist",main.mostCurrent._leftlist,"lolist",main.mostCurrent._lolist,"lv1",main.mostCurrent._lv1,"mcl",main.mostCurrent._mcl,"name",main.mostCurrent._name,"Obj1",main.mostCurrent._obj1,"Obj2",main.mostCurrent._obj2,"Obj3",main.mostCurrent._obj3,"olist",main.mostCurrent._olist,"option",Debug.moduleToString(de.sclean.option.class),"os",main._os,"pack",main.mostCurrent._pack,"package",main._package,"packName",main.mostCurrent._packname,"Panel1",main.mostCurrent._panel1,"paths",main.mostCurrent._paths,"pb1",main.mostCurrent._pb1,"pb2",main.mostCurrent._pb2,"pdim",main.mostCurrent._pdim,"pn",main.mostCurrent._pn,"prb",main.mostCurrent._prb,"ready",main.mostCurrent._ready,"rfont",main._rfont,"size",main._size,"sl",main.mostCurrent._sl,"sm",main.mostCurrent._sm,"sr",main.mostCurrent._sr,"ss",main.mostCurrent._ss,"Starter",Debug.moduleToString(de.sclean.starter.class),"StateManager",Debug.moduleToString(de.sclean.statemanager.class),"supp",Debug.moduleToString(de.sclean.supp.class),"t1",main._t1,"t2",main._t2,"time",main._time,"toolbar",main.mostCurrent._toolbar,"tota",main.mostCurrent._tota,"Types",main.mostCurrent._types,"utext",main._utext,"Widget",Debug.moduleToString(de.sclean.widget.class),"xMSOS",main.mostCurrent._xmsos,"xOSStats",main.mostCurrent._xosstats};
}
}