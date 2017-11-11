package de.sclean;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends android.support.v7.app.ActionBarActivity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "de.sclean", "de.sclean.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "de.sclean", "de.sclean.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "de.sclean.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static com.rootsoft.oslibrary.OSLibrary _os = null;
public static String _date = "";
public static String _time1 = "";
public static anywheresoftware.b4a.keywords.constants.TypefaceWrapper _rfont = null;
public static String _package = "";
public static anywheresoftware.b4a.objects.Timer _t1 = null;
public static anywheresoftware.b4a.objects.Timer _t2 = null;
public anywheresoftware.b4a.phone.PackageManagerWrapper _pack = null;
public com.tchart.materialcolors.MaterialColors _mcl = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lv1 = null;
public de.amberhome.objects.appcompat.AppCompatBase _ac = null;
public com.maximussoft.msos.MSOS _xmsos = null;
public b4a.example.osstats _xosstats = null;
public static String _dir = "";
public de.sclean.keyvaluestore _kvst = null;
public de.sclean.keyvaluestore _kvsdata = null;
public de.sclean.keyvaluestore _alist = null;
public de.sclean.keyvaluestore _dbase = null;
public de.sclean.keyvaluestore _abase = null;
public de.sclean.keyvaluestore _savedata = null;
public anywheresoftware.b4a.objects.collections.Map _paths = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _im1 = null;
public anywheresoftware.b4a.objects.collections.List _olist = null;
public anywheresoftware.b4a.objects.ListViewWrapper _leftlist = null;
public anywheresoftware.b4a.objects.SlidingMenuWrapper _sm = null;
public static int _counter = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public de.amberhome.objects.appcompat.ACActionBar _abhelper = null;
public de.amberhome.objects.appcompat.ACToolbarDarkWrapper _toolbar = null;
public de.amberhome.materialdialogs.MaterialDialogWrapper _dia = null;
public anywheresoftware.b4a.objects.PanelWrapper _ipan2 = null;
public squareprogressbarwrapper.squareProgressBarWrapper _ss = null;
public anywheresoftware.b4a.objects.PanelWrapper _ldim = null;
public anywheresoftware.b4a.objects.PanelWrapper _pdim = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lolist = null;
public anywheresoftware.b4a.objects.LabelWrapper _tota = null;
public anywheresoftware.b4a.objects.PanelWrapper _extrapan = null;
public anywheresoftware.b4a.objects.PanelWrapper _pn = null;
public circleprogressmasterwrapper.arcProgressMasterWrapper _pb1 = null;
public circleprogressmasterwrapper.arcProgressMasterWrapper _pb2 = null;
public Object[] _args = null;
public anywheresoftware.b4a.agraham.reflection.Reflection _obj1 = null;
public anywheresoftware.b4a.agraham.reflection.Reflection _obj2 = null;
public anywheresoftware.b4a.agraham.reflection.Reflection _obj3 = null;
public static int _size = 0;
public static int _flags = 0;
public static String _name = "";
public static String _apath = "";
public static String _l = "";
public static String[] _types = null;
public static String _packname = "";
public anywheresoftware.b4a.objects.LabelWrapper _sl = null;
public de.donmanfred.LVEatBeansWrapper _sr = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ready = null;
public de.amberhome.objects.appcompat.ACFlatButtonWrapper _prb = null;
public de.amberhome.objects.appcompat.ACFlatButtonWrapper _prb2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _tool2 = null;
public de.amberhome.objects.appcompat.ACFlatButtonWrapper _prb3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _rl1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _rl2 = null;
public circleprogressmasterwrapper.donutProgressMasterWrapper _rb1 = null;
public circleprogressmasterwrapper.donutProgressMasterWrapper _rb2 = null;
public de.donmanfred.LVBatteryWrapper _va = null;
public anywheresoftware.b4a.phone.PhoneEvents _bat = null;
public de.donmanfred.LVBatteryWrapper _lvb1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _endsum = null;
public anywheresoftware.b4a.objects.AnimationWrapper _anim = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.info _info = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (supp.mostCurrent != null);
vis = vis | (option.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _lftmenu = null;
int _offset = 0;
anywheresoftware.b4a.objects.LabelWrapper _la1 = null;
anywheresoftware.b4a.objects.LabelWrapper _la2 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bm = null;
MLfiles.Fileslib.MLfiles _ml = null;
 //BA.debugLineNum = 87;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 88;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
 //BA.debugLineNum = 89;BA.debugLine="Activity.TitleColor=mcl.md_black_1000";
mostCurrent._activity.setTitleColor(mostCurrent._mcl.getmd_black_1000());
 //BA.debugLineNum = 90;BA.debugLine="Activity.Title=pack.GetApplicationLabel(package)";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence(mostCurrent._pack.GetApplicationLabel(_package)));
 //BA.debugLineNum = 91;BA.debugLine="Activity.Color=Colors.ARGB(255,33,150,243)";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (33),(int) (150),(int) (243)));
 //BA.debugLineNum = 94;BA.debugLine="ABHelper.Initialize";
mostCurrent._abhelper.Initialize(mostCurrent.activityBA);
 //BA.debugLineNum = 95;BA.debugLine="toolbar.SetAsActionBar";
mostCurrent._toolbar.SetAsActionBar(mostCurrent.activityBA);
 //BA.debugLineNum = 96;BA.debugLine="toolbar.InitMenuListener";
mostCurrent._toolbar.InitMenuListener();
 //BA.debugLineNum = 97;BA.debugLine="toolbar.PopupTheme=toolbar.THEME_DARK";
mostCurrent._toolbar.setPopupTheme(mostCurrent._toolbar.THEME_DARK);
 //BA.debugLineNum = 99;BA.debugLine="toolbar.SubTitle=pack.GetApplicationLabel(package";
mostCurrent._toolbar.setSubTitle(BA.ObjectToCharSequence(mostCurrent._pack.GetApplicationLabel(_package)+" V."+mostCurrent._pack.GetVersionName(_package)));
 //BA.debugLineNum = 100;BA.debugLine="ABHelper.ShowUpIndicator = True";
mostCurrent._abhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 101;BA.debugLine="ABHelper.HomeVisible=True";
mostCurrent._abhelper.setHomeVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 102;BA.debugLine="DateTime.TimeFormat=\"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
 //BA.debugLineNum = 103;BA.debugLine="DateTime.DateFormat=\"dd-MM-yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd-MM-yyyy");
 //BA.debugLineNum = 104;BA.debugLine="date=DateTime.Date(DateTime.Now)";
_date = anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 105;BA.debugLine="time1=DateTime.Time(DateTime.Now)";
_time1 = anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 106;BA.debugLine="xOSStats.Initialize(400, 50, Me, \"Stats\")";
mostCurrent._xosstats._initialize(mostCurrent.activityBA,(int) (400),(int) (50),main.getObject(),"Stats");
 //BA.debugLineNum = 107;BA.debugLine="im1.Initialize(\"im1\")";
mostCurrent._im1.Initialize(mostCurrent.activityBA,"im1");
 //BA.debugLineNum = 108;BA.debugLine="os.Initialize(\"os\")";
_os.Initialize(processBA,"os");
 //BA.debugLineNum = 109;BA.debugLine="sm.Initialize(\"sm\")";
mostCurrent._sm.Initialize(mostCurrent.activityBA,"sm");
 //BA.debugLineNum = 110;BA.debugLine="ss.Initialize(\"ss\")";
mostCurrent._ss.Initialize(processBA,"ss");
 //BA.debugLineNum = 111;BA.debugLine="endsum.Initialize(\"endsum\")";
mostCurrent._endsum.Initialize(mostCurrent.activityBA,"endsum");
 //BA.debugLineNum = 112;BA.debugLine="endsum.Visible=False";
mostCurrent._endsum.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 113;BA.debugLine="endsum.Typeface=rfont";
mostCurrent._endsum.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 114;BA.debugLine="endsum.TextColor=mcl.md_amber_600";
mostCurrent._endsum.setTextColor(mostCurrent._mcl.getmd_amber_600());
 //BA.debugLineNum = 115;BA.debugLine="endsum.TextSize=25";
mostCurrent._endsum.setTextSize((float) (25));
 //BA.debugLineNum = 116;BA.debugLine="endsum.Gravity=Gravity.CENTER_HORIZONTAL";
mostCurrent._endsum.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 117;BA.debugLine="t1.Initialize(\"t1\",1000)";
_t1.Initialize(processBA,"t1",(long) (1000));
 //BA.debugLineNum = 118;BA.debugLine="t2.Initialize(\"t2\",1000)";
_t2.Initialize(processBA,"t2",(long) (1000));
 //BA.debugLineNum = 119;BA.debugLine="sr.Initialize(\"sr\")";
mostCurrent._sr.Initialize(processBA,"sr");
 //BA.debugLineNum = 120;BA.debugLine="ldim.Initialize(\"ldim\")";
mostCurrent._ldim.Initialize(mostCurrent.activityBA,"ldim");
 //BA.debugLineNum = 121;BA.debugLine="pdim.Initialize(\"pdim\")";
mostCurrent._pdim.Initialize(mostCurrent.activityBA,"pdim");
 //BA.debugLineNum = 122;BA.debugLine="ready.Initialize(\"ready\")";
mostCurrent._ready.Initialize(mostCurrent.activityBA,"ready");
 //BA.debugLineNum = 123;BA.debugLine="bat.Initialize(\"bat\")";
mostCurrent._bat.Initialize(processBA,"bat");
 //BA.debugLineNum = 124;BA.debugLine="ldim.Visible=False";
mostCurrent._ldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 125;BA.debugLine="pdim.Visible=False";
mostCurrent._pdim.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 126;BA.debugLine="lolist.Initialize(\"lolist\")";
mostCurrent._lolist.Initialize(mostCurrent.activityBA,"lolist");
 //BA.debugLineNum = 127;BA.debugLine="pdim.AddView(lolist,1%x,1%y,99%x,70%y)";
mostCurrent._pdim.AddView((android.view.View)(mostCurrent._lolist.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (99),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 128;BA.debugLine="counter=0";
_counter = (int) (0);
 //BA.debugLineNum = 129;BA.debugLine="t1.Enabled=False";
_t1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 130;BA.debugLine="t2.Enabled=False";
_t2.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 131;BA.debugLine="Dim lftMenu As Panel";
_lftmenu = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 132;BA.debugLine="lftMenu.Initialize(\"\")";
_lftmenu.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 133;BA.debugLine="lftMenu.LoadLayout(\"left\")";
_lftmenu.LoadLayout("left",mostCurrent.activityBA);
 //BA.debugLineNum = 134;BA.debugLine="Dim offset As Int = 20%x";
_offset = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA);
 //BA.debugLineNum = 135;BA.debugLine="sm.BehindOffset = offset";
mostCurrent._sm.setBehindOffset(_offset);
 //BA.debugLineNum = 136;BA.debugLine="sm.Menu.AddView(lftMenu, 0, 0, 100%x-offset, 100%";
mostCurrent._sm.getMenu().AddView((android.view.View)(_lftmenu.getObject()),(int) (0),(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-_offset),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 137;BA.debugLine="sm.Mode = sm.LEFT";
mostCurrent._sm.setMode(mostCurrent._sm.LEFT);
 //BA.debugLineNum = 138;BA.debugLine="Dim la1,la2 As Label";
_la1 = new anywheresoftware.b4a.objects.LabelWrapper();
_la2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 139;BA.debugLine="la2.Initialize(\"la2\")";
_la2.Initialize(mostCurrent.activityBA,"la2");
 //BA.debugLineNum = 140;BA.debugLine="la1.Initialize(\"la1\")";
_la1.Initialize(mostCurrent.activityBA,"la1");
 //BA.debugLineNum = 141;BA.debugLine="la1=lv1.TwoLinesAndBitmap.Label";
_la1 = mostCurrent._lv1.getTwoLinesAndBitmap().Label;
 //BA.debugLineNum = 142;BA.debugLine="la2=lv1.TwoLinesAndBitmap.SecondLabel";
_la2 = mostCurrent._lv1.getTwoLinesAndBitmap().SecondLabel;
 //BA.debugLineNum = 143;BA.debugLine="la1.TextSize=15";
_la1.setTextSize((float) (15));
 //BA.debugLineNum = 144;BA.debugLine="la2.TextSize=13";
_la2.setTextSize((float) (13));
 //BA.debugLineNum = 145;BA.debugLine="la1.Typeface=rfont";
_la1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 146;BA.debugLine="la2.Typeface=rfont";
_la2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 147;BA.debugLine="la1.TextColor=mcl.md_grey_900";
_la1.setTextColor(mostCurrent._mcl.getmd_grey_900());
 //BA.debugLineNum = 148;BA.debugLine="la2.TextColor=Colors.ARGB(190,255,255,255)";
_la2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (190),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 149;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Height=32dip";
mostCurrent._lv1.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 150;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Width=32dip";
mostCurrent._lv1.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 151;BA.debugLine="lv1.TwoLinesAndBitmap.ItemHeight=55dip";
mostCurrent._lv1.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
 //BA.debugLineNum = 152;BA.debugLine="kvst.Initialize(File.DirInternal,\"data_time\")";
mostCurrent._kvst._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_time");
 //BA.debugLineNum = 153;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
mostCurrent._kvsdata._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_data");
 //BA.debugLineNum = 154;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
mostCurrent._alist._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"adata_data");
 //BA.debugLineNum = 155;BA.debugLine="dbase.Initialize(File.DirInternal,\"dbase_data\")";
mostCurrent._dbase._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"dbase_data");
 //BA.debugLineNum = 156;BA.debugLine="abase.Initialize(File.DirInternal,\"abase_data\")";
mostCurrent._abase._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"abase_data");
 //BA.debugLineNum = 157;BA.debugLine="savedata.Initialize(File.DirInternal,\"save_data\")";
mostCurrent._savedata._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"save_data");
 //BA.debugLineNum = 158;BA.debugLine="va.Initialize(\"va\")";
mostCurrent._va.Initialize(processBA,"va");
 //BA.debugLineNum = 159;BA.debugLine="prb.Typeface=rfont";
mostCurrent._prb.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 160;BA.debugLine="prb2.Typeface=rfont";
mostCurrent._prb2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 161;BA.debugLine="prb3.Typeface=rfont";
mostCurrent._prb3.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 162;BA.debugLine="prb2.TextColor=Colors.ARGB(150,255,255,255)";
mostCurrent._prb2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 163;BA.debugLine="prb3.TextColor=Colors.ARGB(150,255,255,255)";
mostCurrent._prb3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 164;BA.debugLine="prb.Text=\"Suchen\"";
mostCurrent._prb.setText(BA.ObjectToCharSequence("Suchen"));
 //BA.debugLineNum = 165;BA.debugLine="ss.Initialize(\"ss\")";
mostCurrent._ss.Initialize(processBA,"ss");
 //BA.debugLineNum = 166;BA.debugLine="Activity.AddView(ldim,0,10%y,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._ldim.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 167;BA.debugLine="ldim.Color=Colors.ARGB(245,0,0,0)";
mostCurrent._ldim.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (245),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 168;BA.debugLine="pdim.Color=Colors.ARGB(245,0,0,0)";
mostCurrent._pdim.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (245),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 169;BA.debugLine="sr.Initialize(\"sr\")";
mostCurrent._sr.Initialize(processBA,"sr");
 //BA.debugLineNum = 170;BA.debugLine="Activity.AddView(sr,15%x,10%y,250dip,250dip)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._sr.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)));
 //BA.debugLineNum = 171;BA.debugLine="Activity.AddView(ready,25%x,30%y,150dip,150dip)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._ready.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 //BA.debugLineNum = 172;BA.debugLine="Activity.AddView(endsum,18%x,60%y,200dip,80dip)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._endsum.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (18),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (60),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)));
 //BA.debugLineNum = 173;BA.debugLine="Activity.AddView(pdim,0%x,45%y,100%x,70%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pdim.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (45),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
 //BA.debugLineNum = 174;BA.debugLine="tota.TextColor=mcl.md_grey_800";
mostCurrent._tota.setTextColor(mostCurrent._mcl.getmd_grey_800());
 //BA.debugLineNum = 175;BA.debugLine="tota.TextSize=22";
mostCurrent._tota.setTextSize((float) (22));
 //BA.debugLineNum = 176;BA.debugLine="tota.Typeface=rfont";
mostCurrent._tota.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 177;BA.debugLine="pn.Initialize(\"\")";
mostCurrent._pn.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 178;BA.debugLine="pn.Color=Colors.ARGB(240,0,0,0)";
mostCurrent._pn.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (240),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 179;BA.debugLine="sl.Initialize(\"sl\")";
mostCurrent._sl.Initialize(mostCurrent.activityBA,"sl");
 //BA.debugLineNum = 180;BA.debugLine="sl.Text=\"Einen Moment bitte, Apps werden durchsuc";
mostCurrent._sl.setText(BA.ObjectToCharSequence("Einen Moment bitte, Apps werden durchsucht.."));
 //BA.debugLineNum = 181;BA.debugLine="sl.Textsize=20";
mostCurrent._sl.setTextSize((float) (20));
 //BA.debugLineNum = 182;BA.debugLine="sl.Typeface=rfont";
mostCurrent._sl.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 183;BA.debugLine="rl1.Typeface=rfont";
mostCurrent._rl1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 184;BA.debugLine="rl1.TextSize=13";
mostCurrent._rl1.setTextSize((float) (13));
 //BA.debugLineNum = 185;BA.debugLine="rl2.Typeface=rfont";
mostCurrent._rl2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 186;BA.debugLine="rl2.TextSize=13";
mostCurrent._rl2.setTextSize((float) (13));
 //BA.debugLineNum = 187;BA.debugLine="rl1.Text=\"CPU\"&CRLF&\"Leistung\"";
mostCurrent._rl1.setText(BA.ObjectToCharSequence("CPU"+anywheresoftware.b4a.keywords.Common.CRLF+"Leistung"));
 //BA.debugLineNum = 188;BA.debugLine="rl2.Text=\"Batterie\"&CRLF&\"Status\"";
mostCurrent._rl2.setText(BA.ObjectToCharSequence("Batterie"+anywheresoftware.b4a.keywords.Common.CRLF+"Status"));
 //BA.debugLineNum = 189;BA.debugLine="Activity.AddView(pn,0%x,1%y,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pn.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 190;BA.debugLine="pn.AddView(ss,25%x,25%y,300dip,300dip)";
mostCurrent._pn.AddView((android.view.View)(mostCurrent._ss.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 //BA.debugLineNum = 191;BA.debugLine="pn.AddView(sl,10%x,15%y+250dip+20dip,300dip,300di";
mostCurrent._pn.AddView((android.view.View)(mostCurrent._sl.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (15),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
 //BA.debugLineNum = 192;BA.debugLine="pn.Visible=False";
mostCurrent._pn.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 193;BA.debugLine="ready.Visible=False";
mostCurrent._ready.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 194;BA.debugLine="ready.Bitmap=LoadBitmap(File.DirAssets,\"Accept256";
mostCurrent._ready.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Accept256.png").getObject()));
 //BA.debugLineNum = 195;BA.debugLine="ready.Gravity=Gravity.FILL";
mostCurrent._ready.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 196;BA.debugLine="Dim bm As Bitmap";
_bm = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 197;BA.debugLine="bm.Initialize(File.DirAssets,\"sc-logo.png\")";
_bm.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"sc-logo.png");
 //BA.debugLineNum = 198;BA.debugLine="sr.Visible=False";
mostCurrent._sr.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 199;BA.debugLine="ss.Height=150dip";
mostCurrent._ss.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 //BA.debugLineNum = 200;BA.debugLine="ss.Width=150dip";
mostCurrent._ss.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
 //BA.debugLineNum = 201;BA.debugLine="ss.ImageBitmap=bm";
mostCurrent._ss.setImageBitmap((android.graphics.Bitmap)(_bm.getObject()));
 //BA.debugLineNum = 202;BA.debugLine="ss.DrawOutline = True";
mostCurrent._ss.setDrawOutline(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 203;BA.debugLine="ss.DrawCenterline = True";
mostCurrent._ss.setDrawCenterline(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 204;BA.debugLine="ss.DrawStartline = True";
mostCurrent._ss.setDrawStartline(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 205;BA.debugLine="ss.ShowProgress = True";
mostCurrent._ss.setShowProgress(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 206;BA.debugLine="ss.ColorRGB_2=mcl.md_amber_400";
mostCurrent._ss.setColorRGB_2(mostCurrent._mcl.getmd_amber_400());
 //BA.debugLineNum = 207;BA.debugLine="ss.Color_1 = \"#2196F3\"";
mostCurrent._ss.setColor_1("#2196F3");
 //BA.debugLineNum = 208;BA.debugLine="ss.setColorRGB_1(208,224,238)";
mostCurrent._ss.setColorRGB_1((int) (208),(int) (224),(int) (238));
 //BA.debugLineNum = 209;BA.debugLine="ss.Color=Colors.Transparent";
mostCurrent._ss.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 //BA.debugLineNum = 211;BA.debugLine="ss.ImageGrayscale = True";
mostCurrent._ss.setImageGrayscale(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 212;BA.debugLine="ss.Opacity_1 = True";
mostCurrent._ss.setOpacity_1(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 213;BA.debugLine="ss.setOpacity_2(True,False)";
mostCurrent._ss.setOpacity_2(anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 214;BA.debugLine="ss.ClearOnHundred = True";
mostCurrent._ss.setClearOnHundred(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 215;BA.debugLine="ss.BorderWidth = 13";
mostCurrent._ss.setBorderWidth((int) (13));
 //BA.debugLineNum = 217;BA.debugLine="rb1.FinishedStrokeWidth=5dip";
mostCurrent._rb1.setFinishedStrokeWidth((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
 //BA.debugLineNum = 218;BA.debugLine="rb1.UnfinishedStrokeWidth=2dip";
mostCurrent._rb1.setUnfinishedStrokeWidth((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 //BA.debugLineNum = 219;BA.debugLine="rb1.TextSize=20";
mostCurrent._rb1.setTextSize((float) (20));
 //BA.debugLineNum = 220;BA.debugLine="rb1.TextColor=Colors.ARGB(100,255,255,255)";
mostCurrent._rb1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 221;BA.debugLine="rb2.FinishedStrokeWidth=5dip";
mostCurrent._rb2.setFinishedStrokeWidth((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
 //BA.debugLineNum = 222;BA.debugLine="rb2.UnfinishedStrokeWidth=2dip";
mostCurrent._rb2.setUnfinishedStrokeWidth((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 //BA.debugLineNum = 223;BA.debugLine="rb2.TextSize=25";
mostCurrent._rb2.setTextSize((float) (25));
 //BA.debugLineNum = 225;BA.debugLine="Dim ml As MLfiles";
_ml = new MLfiles.Fileslib.MLfiles();
 //BA.debugLineNum = 226;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 227;BA.debugLine="getsettings";
_getsettings();
 //BA.debugLineNum = 228;BA.debugLine="If ml.SdcardReady=\"mounted\" Then";
if ((_ml.SdcardReady()).equals("mounted")) { 
 //BA.debugLineNum = 229;BA.debugLine="File.MakeDir(ml.GetExtSd,\"S-Cleaner/tmp\")";
anywheresoftware.b4a.keywords.Common.File.MakeDir(_ml.GetExtSd(),"S-Cleaner/tmp");
 //BA.debugLineNum = 230;BA.debugLine="ToastMessageShow(\"SD Karte erkannt: \"&ml.GetExt";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("SD Karte erkannt: "+_ml.GetExtSd()),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 //BA.debugLineNum = 234;BA.debugLine="CallSubDelayed(Starter,\"info_remote\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._starter.getObject()),"info_remote");
 //BA.debugLineNum = 235;BA.debugLine="GetAvailableSpace";
_getavailablespace();
 //BA.debugLineNum = 236;BA.debugLine="getCPUinfo";
_getcpuinfo();
 //BA.debugLineNum = 237;BA.debugLine="l_stat";
_l_stat();
 //BA.debugLineNum = 238;BA.debugLine="left";
_left();
 //BA.debugLineNum = 239;BA.debugLine="create_menu";
_create_menu();
 //BA.debugLineNum = 240;BA.debugLine="p_button";
_p_button();
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
return "";
}
public static String  _activity_createmenu(de.amberhome.objects.appcompat.ACMenuWrapper _menu) throws Exception{
anywheresoftware.b4a.objects.drawable.BitmapDrawable _eim = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _fim1 = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _climg1 = null;
de.amberhome.objects.appcompat.ACMenuItemWrapper _item = null;
de.amberhome.objects.appcompat.ACMenuItemWrapper _item2 = null;
de.amberhome.objects.appcompat.ACMenuItemWrapper _item3 = null;
 //BA.debugLineNum = 255;BA.debugLine="Sub Activity_CreateMenu(menu As ACMenu)";
 //BA.debugLineNum = 256;BA.debugLine="Dim eim As BitmapDrawable";
_eim = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 257;BA.debugLine="eim.Initialize(LoadBitmap(File.DirAssets,\"ic_exit";
_eim.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_exit_to_app_white_48dp.png").getObject()));
 //BA.debugLineNum = 258;BA.debugLine="Dim fim1,climg1 As BitmapDrawable";
_fim1 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_climg1 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 259;BA.debugLine="fim1.Initialize(LoadBitmap(File.DirAssets,\"ic_set";
_fim1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_settings_applications_white_36dp.png").getObject()));
 //BA.debugLineNum = 260;BA.debugLine="climg1.Initialize(LoadBitmap(File.DirAssets,\"ic_a";
_climg1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_apps_white_36dp.png").getObject()));
 //BA.debugLineNum = 261;BA.debugLine="menu.Clear";
_menu.Clear();
 //BA.debugLineNum = 262;BA.debugLine="Dim item,item2,item3 As ACMenuItem";
_item = new de.amberhome.objects.appcompat.ACMenuItemWrapper();
_item2 = new de.amberhome.objects.appcompat.ACMenuItemWrapper();
_item3 = new de.amberhome.objects.appcompat.ACMenuItemWrapper();
 //BA.debugLineNum = 263;BA.debugLine="item3=toolbar.Menu.Add2(0, 0, \"Menu\", climg1)";
_item3 = mostCurrent._toolbar.getMenu().Add2((int) (0),(int) (0),BA.ObjectToCharSequence("Menu"),(android.graphics.drawable.Drawable)(_climg1.getObject()));
 //BA.debugLineNum = 264;BA.debugLine="item=toolbar.Menu.Add2(1, 1, \"SMenu\", fim1)";
_item = mostCurrent._toolbar.getMenu().Add2((int) (1),(int) (1),BA.ObjectToCharSequence("SMenu"),(android.graphics.drawable.Drawable)(_fim1.getObject()));
 //BA.debugLineNum = 265;BA.debugLine="item2=toolbar.Menu.Add2(2, 2, \"Exit\", eim)";
_item2 = mostCurrent._toolbar.getMenu().Add2((int) (2),(int) (2),BA.ObjectToCharSequence("Exit"),(android.graphics.drawable.Drawable)(_eim.getObject()));
 //BA.debugLineNum = 266;BA.debugLine="item.ShowAsAction = item.SHOW_AS_ACTION_ALWAYS";
_item.setShowAsAction(_item.SHOW_AS_ACTION_ALWAYS);
 //BA.debugLineNum = 267;BA.debugLine="item2.ShowAsAction = item2.SHOW_AS_ACTION_ALWAYS";
_item2.setShowAsAction(_item2.SHOW_AS_ACTION_ALWAYS);
 //BA.debugLineNum = 268;BA.debugLine="item3.ShowAsAction = item3.SHOW_AS_ACTION_ALWAYS";
_item3.setShowAsAction(_item3.SHOW_AS_ACTION_ALWAYS);
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 251;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 243;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 244;BA.debugLine="xOSStats.StartStats";
mostCurrent._xosstats._startstats();
 //BA.debugLineNum = 245;BA.debugLine="If pn.Visible=True Then";
if (mostCurrent._pn.getVisible()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 246;BA.debugLine="pn.SetVisibleAnimated(300,False)";
mostCurrent._pn.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public static void  _animateborder(anywheresoftware.b4a.objects.ConcreteViewWrapper _view) throws Exception{
ResumableSub_AnimateBorder rsub = new ResumableSub_AnimateBorder(null,_view);
rsub.resume(processBA, null);
}
public static class ResumableSub_AnimateBorder extends BA.ResumableSub {
public ResumableSub_AnimateBorder(de.sclean.main parent,anywheresoftware.b4a.objects.ConcreteViewWrapper _view) {
this.parent = parent;
this._view = _view;
}
de.sclean.main parent;
anywheresoftware.b4a.objects.ConcreteViewWrapper _view;
long _n = 0L;
int _duration = 0;
float _start = 0f;
float _tempvalue = 0f;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
                return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 929;BA.debugLine="Dim n As Long = DateTime.Now";
_n = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 930;BA.debugLine="Dim duration As Int = 500";
_duration = (int) (500);
 //BA.debugLineNum = 931;BA.debugLine="Dim start As Float = 0";
_start = (float) (0);
 //BA.debugLineNum = 932;BA.debugLine="Dim tempValue As Float";
_tempvalue = 0f;
 //BA.debugLineNum = 933;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 934;BA.debugLine="cvs.Initialize(View)";
_cvs.Initialize((android.view.View)(_view.getObject()));
 //BA.debugLineNum = 935;BA.debugLine="cvs.DrawColor(Colors.Transparent)";
_cvs.DrawColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 //BA.debugLineNum = 936;BA.debugLine="Do While DateTime.Now < n + duration";
if (true) break;

case 1:
//do while
this.state = 4;
while (anywheresoftware.b4a.keywords.Common.DateTime.getNow()<_n+_duration) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 //BA.debugLineNum = 937;BA.debugLine="tempValue = ValueFromTimeLinear(DateTime.Now - n";
_tempvalue = _valuefromtimelinear((int) (anywheresoftware.b4a.keywords.Common.DateTime.getNow()-_n),_start,(float) (100-_start),_duration);
 //BA.debugLineNum = 938;BA.debugLine="DrawValue(View, cvs, tempValue)";
_drawvalue(_view,_cvs,_tempvalue);
 //BA.debugLineNum = 939;BA.debugLine="Sleep(10)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (10));
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 941;BA.debugLine="DrawValue(View, cvs, 100)";
_drawvalue(_view,_cvs,(float) (100));
 //BA.debugLineNum = 942;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _bat_batterychanged(int _level,int _scale,boolean _plugged,anywheresoftware.b4a.objects.IntentWrapper _intent) throws Exception{
int _volt = 0;
int _state = 0;
 //BA.debugLineNum = 777;BA.debugLine="Sub bat_BatteryChanged (Level As Int, Scale As Int";
 //BA.debugLineNum = 778;BA.debugLine="Dim volt,state As Int";
_volt = 0;
_state = 0;
 //BA.debugLineNum = 779;BA.debugLine="volt=Intent.GetExtra(\"voltage\")";
_volt = (int)(BA.ObjectToNumber(_intent.GetExtra("voltage")));
 //BA.debugLineNum = 780;BA.debugLine="state=Intent.GetExtra(\"icon-small\")";
_state = (int)(BA.ObjectToNumber(_intent.GetExtra("icon-small")));
 //BA.debugLineNum = 781;BA.debugLine="Log(Intent.ExtrasToString)";
anywheresoftware.b4a.keywords.Common.Log(_intent.ExtrasToString());
 //BA.debugLineNum = 782;BA.debugLine="If Plugged=True Then";
if (_plugged==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 783;BA.debugLine="lvb1.SetVisibleAnimated(100,True)";
mostCurrent._lvb1.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 784;BA.debugLine="rb2.SetVisibleAnimated(100,False)";
mostCurrent._rb2.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 785;BA.debugLine="lvb1.startAnim";
mostCurrent._lvb1.startAnim();
 }else {
 //BA.debugLineNum = 787;BA.debugLine="lvb1.SetVisibleAnimated(100,False)";
mostCurrent._lvb1.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 788;BA.debugLine="rb2.SetVisibleAnimated(100,True)";
mostCurrent._rb2.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 789;BA.debugLine="rb2.Progress=100/Scale*Level";
mostCurrent._rb2.setProgress((int) (100/(double)_scale*_level));
 };
 //BA.debugLineNum = 791;BA.debugLine="If Level=100 Then";
if (_level==100) { 
 //BA.debugLineNum = 792;BA.debugLine="If Plugged=True Then";
if (_plugged==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 793;BA.debugLine="lvb1.stopAnim";
mostCurrent._lvb1.stopAnim();
 };
 };
 //BA.debugLineNum = 796;BA.debugLine="If Level <=30 Then";
if (_level<=30) { 
 //BA.debugLineNum = 797;BA.debugLine="rb2.FinishedStrokeColor=mcl.md_amber_500";
mostCurrent._rb2.setFinishedStrokeColor(mostCurrent._mcl.getmd_amber_500());
 //BA.debugLineNum = 798;BA.debugLine="rb2.TextColor=mcl.md_amber_500";
mostCurrent._rb2.setTextColor(mostCurrent._mcl.getmd_amber_500());
 }else {
 //BA.debugLineNum = 800;BA.debugLine="If Level > 30 Then";
if (_level>30) { 
 //BA.debugLineNum = 801;BA.debugLine="rb2.FinishedStrokeColor=mcl.md_lime_A700";
mostCurrent._rb2.setFinishedStrokeColor(mostCurrent._mcl.getmd_lime_A700());
 //BA.debugLineNum = 802;BA.debugLine="rb2.TextColor=mcl.md_lime_A700";
mostCurrent._rb2.setTextColor(mostCurrent._mcl.getmd_lime_A700());
 };
 };
 //BA.debugLineNum = 805;BA.debugLine="If Level <=15 Then";
if (_level<=15) { 
 //BA.debugLineNum = 806;BA.debugLine="rb2.FinishedStrokeColor=mcl.md_amber_900";
mostCurrent._rb2.setFinishedStrokeColor(mostCurrent._mcl.getmd_amber_900());
 //BA.debugLineNum = 807;BA.debugLine="rb2.TextColor=mcl.md_amber_900";
mostCurrent._rb2.setTextColor(mostCurrent._mcl.getmd_amber_900());
 };
 //BA.debugLineNum = 809;BA.debugLine="If Level <= 5 Then";
if (_level<=5) { 
 //BA.debugLineNum = 810;BA.debugLine="rb2.FinishedStrokeColor=mcl.md_red_A700";
mostCurrent._rb2.setFinishedStrokeColor(mostCurrent._mcl.getmd_red_A700());
 //BA.debugLineNum = 811;BA.debugLine="rb2.TextColor=mcl.md_red_a700";
mostCurrent._rb2.setTextColor(mostCurrent._mcl.getmd_red_A700());
 };
 //BA.debugLineNum = 813;BA.debugLine="End Sub";
return "";
}
public static String  _closedia_buttonpressed(de.amberhome.materialdialogs.MaterialDialogWrapper _dialog,String _action) throws Exception{
 //BA.debugLineNum = 874;BA.debugLine="Sub closedia_ButtonPressed (Dialog As MaterialDial";
 //BA.debugLineNum = 875;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_dialog.ACTION_POSITIVE,_dialog.ACTION_NEGATIVE,_dialog.ACTION_NEUTRAL)) {
case 0: {
 //BA.debugLineNum = 877;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
 //BA.debugLineNum = 883;BA.debugLine="End Sub";
return "";
}
public static String  _create_menu() throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Sub create_menu";
 //BA.debugLineNum = 272;BA.debugLine="tool2.Color=Colors.ARGB(100,0,0,0)";
mostCurrent._tool2.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 273;BA.debugLine="End Sub";
return "";
}
public static String  _dexa_buttonpressed(de.amberhome.materialdialogs.MaterialDialogWrapper _dialog,String _action) throws Exception{
 //BA.debugLineNum = 466;BA.debugLine="Sub dexa_ButtonPressed (Dialog As MaterialDialog,";
 //BA.debugLineNum = 467;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_dialog.ACTION_POSITIVE,_dialog.ACTION_NEGATIVE,_dialog.ACTION_NEUTRAL)) {
case 0: {
 //BA.debugLineNum = 469;BA.debugLine="dbase.DeleteAll";
mostCurrent._dbase._deleteall();
 //BA.debugLineNum = 470;BA.debugLine="ToastMessageShow(\"counter reset: erfolgreich\",F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("counter reset: erfolgreich"),anywheresoftware.b4a.keywords.Common.False);
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
 //BA.debugLineNum = 476;BA.debugLine="End Sub";
return "";
}
public static String  _dialog3_buttonpressed(de.amberhome.materialdialogs.MaterialDialogWrapper _dialog,String _action) throws Exception{
com.rootsoft.customtoast.CustomToast _cts = null;
 //BA.debugLineNum = 838;BA.debugLine="Sub Dialog3_ButtonPressed (Dialog As MaterialDialo";
 //BA.debugLineNum = 839;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_dialog.ACTION_POSITIVE,_dialog.ACTION_NEGATIVE,_dialog.ACTION_NEUTRAL)) {
case 0: {
 break; }
case 1: {
 break; }
case 2: {
 //BA.debugLineNum = 845;BA.debugLine="Dim cts As CustomToast";
_cts = new com.rootsoft.customtoast.CustomToast();
 //BA.debugLineNum = 846;BA.debugLine="cts.Initialize";
_cts.Initialize(processBA);
 //BA.debugLineNum = 847;BA.debugLine="cts.ShowBitmap(\"© 2017\",3,0,0,Gravity.BOTTOM,Lo";
_cts.ShowBitmap(BA.ObjectToCharSequence("© 2017"),(int) (3),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.Gravity.BOTTOM,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"sc-logo.png").getObject()));
 break; }
}
;
 //BA.debugLineNum = 849;BA.debugLine="End Sub";
return "";
}
public static String  _dp_clean() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lu = null;
 //BA.debugLineNum = 693;BA.debugLine="Sub dp_clean";
 //BA.debugLineNum = 694;BA.debugLine="Dim lu As Label";
_lu = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 695;BA.debugLine="lu.Initialize(\"\")";
_lu.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 696;BA.debugLine="lu.Typeface=rfont";
_lu.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 697;BA.debugLine="schredder(False)";
_schredder(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 698;BA.debugLine="lu.Text=\"Start\"";
_lu.setText(BA.ObjectToCharSequence("Start"));
 //BA.debugLineNum = 699;BA.debugLine="prb.Text=lu.Text";
mostCurrent._prb.setText(BA.ObjectToCharSequence(_lu.getText()));
 //BA.debugLineNum = 700;BA.debugLine="End Sub";
return "";
}
public static String  _dp_clear() throws Exception{
 //BA.debugLineNum = 720;BA.debugLine="Sub dp_clear";
 //BA.debugLineNum = 721;BA.debugLine="ready.Visible=False";
mostCurrent._ready.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 722;BA.debugLine="endsum.Visible=False";
mostCurrent._endsum.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 723;BA.debugLine="xOSStats.StartStats";
mostCurrent._xosstats._startstats();
 //BA.debugLineNum = 724;BA.debugLine="End Sub";
return "";
}
public static String  _dp_off() throws Exception{
 //BA.debugLineNum = 711;BA.debugLine="Sub dp_off";
 //BA.debugLineNum = 713;BA.debugLine="pn.SetVisibleAnimated(450,False)";
mostCurrent._pn.SetVisibleAnimated((int) (450),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 714;BA.debugLine="t1_start";
_t1_start();
 //BA.debugLineNum = 715;BA.debugLine="End Sub";
return "";
}
public static String  _dp_start() throws Exception{
 //BA.debugLineNum = 716;BA.debugLine="Sub dp_start";
 //BA.debugLineNum = 718;BA.debugLine="End Sub";
return "";
}
public static String  _drawvalue(anywheresoftware.b4a.objects.ConcreteViewWrapper _view,anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs,float _value) throws Exception{
int _clr = 0;
int _strokewidth = 0;
float _cx = 0f;
float _width = 0f;
float _height = 0f;
 //BA.debugLineNum = 944;BA.debugLine="Private Sub DrawValue(View As View, cvs As Canvas,";
 //BA.debugLineNum = 945;BA.debugLine="Dim clr As Int = Colors.White";
_clr = anywheresoftware.b4a.keywords.Common.Colors.White;
 //BA.debugLineNum = 946;BA.debugLine="Dim strokewidth As Int = 4dip";
_strokewidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4));
 //BA.debugLineNum = 947;BA.debugLine="Dim cx = View.Width / 2 As Float";
_cx = (float) (_view.getWidth()/(double)2);
 //BA.debugLineNum = 948;BA.debugLine="Dim width As Float = View.Width / 50 * Min(50, Va";
_width = (float) (_view.getWidth()/(double)50*anywheresoftware.b4a.keywords.Common.Min(50,_value));
 //BA.debugLineNum = 949;BA.debugLine="cvs.DrawLine(cx - width / 2, 0, cx + width / 2, 0";
_cvs.DrawLine((float) (_cx-_width/(double)2),(float) (0),(float) (_cx+_width/(double)2),(float) (0),_clr,(float) (_strokewidth));
 //BA.debugLineNum = 950;BA.debugLine="cvs.DrawLine(cx - width / 2, View.Height, cx + wi";
_cvs.DrawLine((float) (_cx-_width/(double)2),(float) (_view.getHeight()),(float) (_cx+_width/(double)2),(float) (_view.getHeight()),_clr,(float) (_strokewidth));
 //BA.debugLineNum = 951;BA.debugLine="If Value > 50 Then";
if (_value>50) { 
 //BA.debugLineNum = 952;BA.debugLine="Dim height As Float = View.Height / 50 * (Value";
_height = (float) (_view.getHeight()/(double)50*(_value-50));
 //BA.debugLineNum = 953;BA.debugLine="cvs.DrawLine(0, 0, 0, height / 2, clr, strokewid";
_cvs.DrawLine((float) (0),(float) (0),(float) (0),(float) (_height/(double)2),_clr,(float) (_strokewidth));
 //BA.debugLineNum = 954;BA.debugLine="cvs.DrawLine(0, View.Height, 0,  View.Height - h";
_cvs.DrawLine((float) (0),(float) (_view.getHeight()),(float) (0),(float) (_view.getHeight()-_height/(double)2),_clr,(float) (_strokewidth));
 //BA.debugLineNum = 955;BA.debugLine="cvs.DrawLine(View.Width, 0, View.Width, height /";
_cvs.DrawLine((float) (_view.getWidth()),(float) (0),(float) (_view.getWidth()),(float) (_height/(double)2),_clr,(float) (_strokewidth));
 //BA.debugLineNum = 956;BA.debugLine="cvs.DrawLine(View.Width, View.Height, View.Width";
_cvs.DrawLine((float) (_view.getWidth()),(float) (_view.getHeight()),(float) (_view.getWidth()),(float) (_view.getHeight()-_height/(double)2),_clr,(float) (_strokewidth));
 };
 //BA.debugLineNum = 958;BA.debugLine="View.Invalidate";
_view.Invalidate();
 //BA.debugLineNum = 959;BA.debugLine="End Sub";
return "";
}
public static String  _endsum_calc() throws Exception{
int _sum = 0;
String _s = "";
 //BA.debugLineNum = 546;BA.debugLine="Sub endsum_calc";
 //BA.debugLineNum = 547;BA.debugLine="Dim sum As Int=0";
_sum = (int) (0);
 //BA.debugLineNum = 548;BA.debugLine="For Each s As String In dbase.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group2 = mostCurrent._dbase._listkeys();
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_s = BA.ObjectToString(group2.Get(index2));
 //BA.debugLineNum = 549;BA.debugLine="sum=sum+s";
_sum = (int) (_sum+(double)(Double.parseDouble(_s)));
 //BA.debugLineNum = 550;BA.debugLine="Log(FormatFileSize(sum))";
anywheresoftware.b4a.keywords.Common.Log(_formatfilesize((float) (_sum)));
 }
};
 //BA.debugLineNum = 552;BA.debugLine="endsum.Text=FormatFileSize(sum)";
mostCurrent._endsum.setText(BA.ObjectToCharSequence(_formatfilesize((float) (_sum))));
 //BA.debugLineNum = 553;BA.debugLine="End Sub";
return "";
}
public static String  _exit_click() throws Exception{
de.amberhome.materialdialogs.MaterialDialogWrapper _infodia = null;
de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _builder = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _inf = null;
anywheresoftware.b4a.objects.LabelWrapper _l1 = null;
anywheresoftware.b4a.objects.LabelWrapper _l2 = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
 //BA.debugLineNum = 851;BA.debugLine="Sub exit_click";
 //BA.debugLineNum = 852;BA.debugLine="Dim infodia As MaterialDialog";
_infodia = new de.amberhome.materialdialogs.MaterialDialogWrapper();
 //BA.debugLineNum = 853;BA.debugLine="Dim Builder As MaterialDialogBuilder";
_builder = new de.amberhome.materialdialogs.MaterialDialogBuilderWrapper();
 //BA.debugLineNum = 854;BA.debugLine="Dim inf As BitmapDrawable";
_inf = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 855;BA.debugLine="inf.Initialize(LoadBitmap(File.DirAssets,\"ic_http";
_inf.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_https_white_36dp.png").getObject()));
 //BA.debugLineNum = 856;BA.debugLine="Dim l1,l2 As Label";
_l1 = new anywheresoftware.b4a.objects.LabelWrapper();
_l2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 857;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 858;BA.debugLine="pnl.Initialize(\"pnl\")";
_pnl.Initialize(mostCurrent.activityBA,"pnl");
 //BA.debugLineNum = 859;BA.debugLine="l1.Initialize(\"\")";
_l1.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 860;BA.debugLine="l2.Initialize(\"\")";
_l2.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 861;BA.debugLine="l2.TextSize=16";
_l2.setTextSize((float) (16));
 //BA.debugLineNum = 862;BA.debugLine="l1.TextSize=15";
_l1.setTextSize((float) (15));
 //BA.debugLineNum = 863;BA.debugLine="l1.textcolor=mcl.md_black_1000";
_l1.setTextColor(mostCurrent._mcl.getmd_black_1000());
 //BA.debugLineNum = 864;BA.debugLine="l1.Text=\"Scleaner schließen? *Der Service, wenn n";
_l1.setText(BA.ObjectToCharSequence("Scleaner schließen? *Der Service, wenn nicht anders eingestellt, wird im Hintergrund weiter ausgeführt!"));
 //BA.debugLineNum = 865;BA.debugLine="l2.textcolor=Colors.ARGB(255,217,87,217)";
_l2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (217),(int) (87),(int) (217)));
 //BA.debugLineNum = 866;BA.debugLine="l1.Gravity=Gravity.TOP";
_l1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
 //BA.debugLineNum = 867;BA.debugLine="l1.Typeface=rfont";
_l1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 868;BA.debugLine="l2.Typeface=rfont";
_l2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 869;BA.debugLine="Builder.Initialize(\"closedia\")";
_builder.Initialize(mostCurrent.activityBA,"closedia");
 //BA.debugLineNum = 870;BA.debugLine="Builder.Title(\"Beenden?\").TitleColor(mcl.md_red_5";
_builder.Title(BA.ObjectToCharSequence("Beenden?")).TitleColor(mostCurrent._mcl.getmd_red_500()).Icon((android.graphics.drawable.Drawable)(_inf.getObject())).LimitIconToDefaultSize().Theme(_builder.THEME_LIGHT).Content(BA.ObjectToCharSequence(_l1.getText())).ContentLineSpacing((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))).Cancelable(anywheresoftware.b4a.keywords.Common.True).NeutralText(BA.ObjectToCharSequence("Abbrechen")).Typeface((android.graphics.Typeface)(_rfont.getObject()),(android.graphics.Typeface)(_rfont.getObject())).NeutralColor(mostCurrent._mcl.getmd_grey_600()).PositiveText(BA.ObjectToCharSequence("Ja bitte")).PositiveColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (217),(int) (87),(int) (217))).ContentGravity(_builder.GRAVITY_START);
 //BA.debugLineNum = 871;BA.debugLine="infodia=Builder.Show";
_infodia = _builder.Show();
 //BA.debugLineNum = 872;BA.debugLine="infodia.Show";
_infodia.Show();
 //BA.debugLineNum = 873;BA.debugLine="End Sub";
return "";
}
public static String  _fexa_buttonpressed(de.amberhome.materialdialogs.MaterialDialogWrapper _dialog,String _action) throws Exception{
 //BA.debugLineNum = 325;BA.debugLine="Sub fexa_ButtonPressed (Dialog As MaterialDialog,";
 //BA.debugLineNum = 326;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_dialog.ACTION_POSITIVE,_dialog.ACTION_NEGATIVE,_dialog.ACTION_NEUTRAL)) {
case 0: {
 //BA.debugLineNum = 328;BA.debugLine="alist.DeleteAll";
mostCurrent._alist._deleteall();
 //BA.debugLineNum = 329;BA.debugLine="lv1.Clear";
mostCurrent._lv1.Clear();
 //BA.debugLineNum = 330;BA.debugLine="Activity.Invalidate";
mostCurrent._activity.Invalidate();
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
 //BA.debugLineNum = 336;BA.debugLine="End Sub";
return "";
}
public static String  _formatfilesize(float _bytes) throws Exception{
String[] _unit = null;
double _po = 0;
double _si = 0;
int _i = 0;
 //BA.debugLineNum = 821;BA.debugLine="Sub FormatFileSize(Bytes As Float) As String";
 //BA.debugLineNum = 822;BA.debugLine="Private Unit() As String = Array As String(\" Byte";
_unit = new String[]{" Byte"," KB"," MB"," GB"," TB"," PB"," EB"," ZB"," YB"};
 //BA.debugLineNum = 823;BA.debugLine="If Bytes = 0 Then";
if (_bytes==0) { 
 //BA.debugLineNum = 824;BA.debugLine="Return \"0 Bytes\"";
if (true) return "0 Bytes";
 }else {
 //BA.debugLineNum = 826;BA.debugLine="Private Po, Si As Double";
_po = 0;
_si = 0;
 //BA.debugLineNum = 827;BA.debugLine="Private I As Int";
_i = 0;
 //BA.debugLineNum = 828;BA.debugLine="Bytes = Abs(Bytes)";
_bytes = (float) (anywheresoftware.b4a.keywords.Common.Abs(_bytes));
 //BA.debugLineNum = 829;BA.debugLine="I = Floor(Logarithm(Bytes, 1024))";
_i = (int) (anywheresoftware.b4a.keywords.Common.Floor(anywheresoftware.b4a.keywords.Common.Logarithm(_bytes,1024)));
 //BA.debugLineNum = 830;BA.debugLine="Po = Power(1024, I)";
_po = anywheresoftware.b4a.keywords.Common.Power(1024,_i);
 //BA.debugLineNum = 831;BA.debugLine="Si = Bytes / Po";
_si = _bytes/(double)_po;
 //BA.debugLineNum = 832;BA.debugLine="Return NumberFormat(Si, 1, 2) & Unit(I)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_si,(int) (1),(int) (2))+_unit[_i];
 };
 //BA.debugLineNum = 834;BA.debugLine="End Sub";
return "";
}
public static String  _getavailablespace() throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
 //BA.debugLineNum = 887;BA.debugLine="Sub GetAvailableSpace";
 //BA.debugLineNum = 888;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 889;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 890;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 891;BA.debugLine="p.Shell(\"df\", Null, sb, Null)  ' free space";
_p.Shell("df",(String[])(anywheresoftware.b4a.keywords.Common.Null),(java.lang.StringBuilder)(_sb.getObject()),(java.lang.StringBuilder)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 893;BA.debugLine="If savedata.ContainsKey(\"sd\") Then";
if (mostCurrent._savedata._containskey("sd")) { 
 //BA.debugLineNum = 894;BA.debugLine="savedata.Remove(\"sd\")";
mostCurrent._savedata._remove("sd");
 //BA.debugLineNum = 895;BA.debugLine="savedata.Put(\"sd\",sb.ToString)";
mostCurrent._savedata._put("sd",(Object)(_sb.ToString()));
 //BA.debugLineNum = 896;BA.debugLine="Log(\"Memory: \"&sb.ToString)";
anywheresoftware.b4a.keywords.Common.Log("Memory: "+_sb.ToString());
 }else {
 //BA.debugLineNum = 898;BA.debugLine="savedata.Put(\"sd\",sb.ToString)";
mostCurrent._savedata._put("sd",(Object)(_sb.ToString()));
 //BA.debugLineNum = 899;BA.debugLine="Log(\"Memory: \"&sb.ToString)";
anywheresoftware.b4a.keywords.Common.Log("Memory: "+_sb.ToString());
 };
 //BA.debugLineNum = 901;BA.debugLine="End Sub";
return "";
}
public static String  _getcpuinfo() throws Exception{
String[] _cpu = null;
String _cpv = "";
 //BA.debugLineNum = 903;BA.debugLine="Sub getCPUinfo";
 //BA.debugLineNum = 904;BA.debugLine="Dim CPU() As String";
_cpu = new String[(int) (0)];
java.util.Arrays.fill(_cpu,"");
 //BA.debugLineNum = 905;BA.debugLine="CPU=Regex.Split( CRLF,os.ReadCPUinfo)";
_cpu = anywheresoftware.b4a.keywords.Common.Regex.Split(anywheresoftware.b4a.keywords.Common.CRLF,_os.ReadCPUinfo());
 //BA.debugLineNum = 906;BA.debugLine="Log(CPU(0))";
anywheresoftware.b4a.keywords.Common.Log(_cpu[(int) (0)]);
 //BA.debugLineNum = 907;BA.debugLine="Dim cpv As String";
_cpv = "";
 //BA.debugLineNum = 908;BA.debugLine="cpv=os.ReadCPUinfo";
_cpv = _os.ReadCPUinfo();
 //BA.debugLineNum = 909;BA.debugLine="If savedata.ContainsKey(\"ci\") Then";
if (mostCurrent._savedata._containskey("ci")) { 
 //BA.debugLineNum = 910;BA.debugLine="savedata.Remove(\"ci\")";
mostCurrent._savedata._remove("ci");
 //BA.debugLineNum = 911;BA.debugLine="savedata.Put(\"ci\",cpv)";
mostCurrent._savedata._put("ci",(Object)(_cpv));
 }else {
 //BA.debugLineNum = 913;BA.debugLine="savedata.Put(\"ci\",cpv)";
mostCurrent._savedata._put("ci",(Object)(_cpv));
 //BA.debugLineNum = 914;BA.debugLine="Log(\"CPU Info: \"&cpv)";
anywheresoftware.b4a.keywords.Common.Log("CPU Info: "+_cpv);
 };
 //BA.debugLineNum = 916;BA.debugLine="Return";
if (true) return "";
 //BA.debugLineNum = 917;BA.debugLine="End Sub";
return "";
}
public static int  _getsdk() throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
 //BA.debugLineNum = 376;BA.debugLine="Sub GetSDK() As Int";
 //BA.debugLineNum = 377;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 378;BA.debugLine="Return p.SdkVersion";
if (true) return _p.getSdkVersion();
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
return 0;
}
public static String  _getsdkversion() throws Exception{
anywheresoftware.b4a.objects.collections.Map _versions = null;
anywheresoftware.b4a.phone.Phone _p = null;
 //BA.debugLineNum = 380;BA.debugLine="Sub GetSDKversion() As String";
 //BA.debugLineNum = 381;BA.debugLine="Dim versions As Map";
_versions = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 382;BA.debugLine="versions.Initialize";
_versions.Initialize();
 //BA.debugLineNum = 383;BA.debugLine="versions.Put(3,\"1.5\")";
_versions.Put((Object)(3),(Object)("1.5"));
 //BA.debugLineNum = 384;BA.debugLine="versions.Put(4,\"1.6\")";
_versions.Put((Object)(4),(Object)("1.6"));
 //BA.debugLineNum = 385;BA.debugLine="versions.Put(7,\"2.1\")";
_versions.Put((Object)(7),(Object)("2.1"));
 //BA.debugLineNum = 386;BA.debugLine="versions.Put(8,\"2.2\")";
_versions.Put((Object)(8),(Object)("2.2"));
 //BA.debugLineNum = 387;BA.debugLine="versions.Put(10,\"2.3.3\")";
_versions.Put((Object)(10),(Object)("2.3.3"));
 //BA.debugLineNum = 388;BA.debugLine="versions.Put(11,\"3.0\")";
_versions.Put((Object)(11),(Object)("3.0"));
 //BA.debugLineNum = 389;BA.debugLine="versions.Put(12,\"3.1\")";
_versions.Put((Object)(12),(Object)("3.1"));
 //BA.debugLineNum = 390;BA.debugLine="versions.Put(13,\"3.2\")";
_versions.Put((Object)(13),(Object)("3.2"));
 //BA.debugLineNum = 391;BA.debugLine="versions.Put(14,\"4.0\")";
_versions.Put((Object)(14),(Object)("4.0"));
 //BA.debugLineNum = 392;BA.debugLine="versions.Put(15,\"4.0.3\")";
_versions.Put((Object)(15),(Object)("4.0.3"));
 //BA.debugLineNum = 393;BA.debugLine="versions.Put(16,\"4.1.2\")";
_versions.Put((Object)(16),(Object)("4.1.2"));
 //BA.debugLineNum = 394;BA.debugLine="versions.Put(17,\"4.2.2\")";
_versions.Put((Object)(17),(Object)("4.2.2"));
 //BA.debugLineNum = 395;BA.debugLine="versions.Put(18,\"4.3\")";
_versions.Put((Object)(18),(Object)("4.3"));
 //BA.debugLineNum = 396;BA.debugLine="versions.Put(19,\"4.4.2\")";
_versions.Put((Object)(19),(Object)("4.4.2"));
 //BA.debugLineNum = 397;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 398;BA.debugLine="Return versions.Get(p.SdkVersion)";
if (true) return BA.ObjectToString(_versions.Get((Object)(_p.getSdkVersion())));
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return "";
}
public static String  _getsettings() throws Exception{
 //BA.debugLineNum = 919;BA.debugLine="Sub getsettings";
 //BA.debugLineNum = 920;BA.debugLine="If savedata.ContainsKey(\"sv\") Then";
if (mostCurrent._savedata._containskey("sv")) { 
 //BA.debugLineNum = 921;BA.debugLine="StartService(info)";
anywheresoftware.b4a.keywords.Common.StartService(processBA,(Object)(mostCurrent._info.getObject()));
 }else {
 //BA.debugLineNum = 923;BA.debugLine="StopService(info)";
anywheresoftware.b4a.keywords.Common.StopService(processBA,(Object)(mostCurrent._info.getObject()));
 };
 //BA.debugLineNum = 925;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 37;BA.debugLine="Private pack As PackageManager";
mostCurrent._pack = new anywheresoftware.b4a.phone.PackageManagerWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private mcl As MaterialColors";
mostCurrent._mcl = new com.tchart.materialcolors.MaterialColors();
 //BA.debugLineNum = 39;BA.debugLine="Private lv1 As ListView";
mostCurrent._lv1 = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private ac As AppCompat";
mostCurrent._ac = new de.amberhome.objects.appcompat.AppCompatBase();
 //BA.debugLineNum = 41;BA.debugLine="Dim xMSOS As MSOS";
mostCurrent._xmsos = new com.maximussoft.msos.MSOS();
 //BA.debugLineNum = 42;BA.debugLine="Dim xOSStats As OSStats";
mostCurrent._xosstats = new b4a.example.osstats();
 //BA.debugLineNum = 43;BA.debugLine="Dim dir As String=File.DirInternal&\"/Bdata\"";
mostCurrent._dir = anywheresoftware.b4a.keywords.Common.File.getDirInternal()+"/Bdata";
 //BA.debugLineNum = 44;BA.debugLine="Private kvst,kvsdata,alist,dbase,abase,savedata A";
mostCurrent._kvst = new de.sclean.keyvaluestore();
mostCurrent._kvsdata = new de.sclean.keyvaluestore();
mostCurrent._alist = new de.sclean.keyvaluestore();
mostCurrent._dbase = new de.sclean.keyvaluestore();
mostCurrent._abase = new de.sclean.keyvaluestore();
mostCurrent._savedata = new de.sclean.keyvaluestore();
 //BA.debugLineNum = 46;BA.debugLine="Dim paths As Map";
mostCurrent._paths = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 47;BA.debugLine="Private im1 As ImageView";
mostCurrent._im1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private olist As List";
mostCurrent._olist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 49;BA.debugLine="Private leftlist As ListView";
mostCurrent._leftlist = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private sm As SlidingMenu";
mostCurrent._sm = new anywheresoftware.b4a.objects.SlidingMenuWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private counter As Int";
_counter = 0;
 //BA.debugLineNum = 52;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Dim ABHelper As ACActionBar";
mostCurrent._abhelper = new de.amberhome.objects.appcompat.ACActionBar();
 //BA.debugLineNum = 54;BA.debugLine="Private toolbar As ACToolBarDark";
mostCurrent._toolbar = new de.amberhome.objects.appcompat.ACToolbarDarkWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Dim dia As MaterialDialog";
mostCurrent._dia = new de.amberhome.materialdialogs.MaterialDialogWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private ipan2 As Panel";
mostCurrent._ipan2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Dim ss As SquareProgressBar";
mostCurrent._ss = new squareprogressbarwrapper.squareProgressBarWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private ldim,pdim As Panel";
mostCurrent._ldim = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pdim = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Dim lolist As ListView";
mostCurrent._lolist = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private tota As Label";
mostCurrent._tota = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private extrapan,pn As Panel";
mostCurrent._extrapan = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pn = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private pb1 As ArcProgressMaster";
mostCurrent._pb1 = new circleprogressmasterwrapper.arcProgressMasterWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private pb2 As ArcProgressMaster";
mostCurrent._pb2 = new circleprogressmasterwrapper.arcProgressMasterWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Dim args(1) As Object";
mostCurrent._args = new Object[(int) (1)];
{
int d0 = mostCurrent._args.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._args[i0] = new Object();
}
}
;
 //BA.debugLineNum = 65;BA.debugLine="Dim Obj1, Obj2, Obj3 As Reflector";
mostCurrent._obj1 = new anywheresoftware.b4a.agraham.reflection.Reflection();
mostCurrent._obj2 = new anywheresoftware.b4a.agraham.reflection.Reflection();
mostCurrent._obj3 = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 66;BA.debugLine="Dim size,flags As Int";
_size = 0;
_flags = 0;
 //BA.debugLineNum = 67;BA.debugLine="Private name,apath,l,Types(1),packName As String";
mostCurrent._name = "";
mostCurrent._apath = "";
mostCurrent._l = "";
mostCurrent._types = new String[(int) (1)];
java.util.Arrays.fill(mostCurrent._types,"");
mostCurrent._packname = "";
 //BA.debugLineNum = 68;BA.debugLine="Private sl As Label";
mostCurrent._sl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Dim sr As LVEatBeans";
mostCurrent._sr = new de.donmanfred.LVEatBeansWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Dim ready As ImageView";
mostCurrent._ready = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Private prb As ACFlatButton";
mostCurrent._prb = new de.amberhome.objects.appcompat.ACFlatButtonWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Private prb2 As ACFlatButton";
mostCurrent._prb2 = new de.amberhome.objects.appcompat.ACFlatButtonWrapper();
 //BA.debugLineNum = 73;BA.debugLine="Private tool2 As Panel";
mostCurrent._tool2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 74;BA.debugLine="Private prb3 As ACFlatButton";
mostCurrent._prb3 = new de.amberhome.objects.appcompat.ACFlatButtonWrapper();
 //BA.debugLineNum = 75;BA.debugLine="Private rl1 As Label";
mostCurrent._rl1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 76;BA.debugLine="Private rl2 As Label";
mostCurrent._rl2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Private rb1 As DonutProgressMaster";
mostCurrent._rb1 = new circleprogressmasterwrapper.donutProgressMasterWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private rb2 As DonutProgressMaster";
mostCurrent._rb2 = new circleprogressmasterwrapper.donutProgressMasterWrapper();
 //BA.debugLineNum = 79;BA.debugLine="Private va As LVBattery";
mostCurrent._va = new de.donmanfred.LVBatteryWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Dim bat As PhoneEvents";
mostCurrent._bat = new anywheresoftware.b4a.phone.PhoneEvents();
 //BA.debugLineNum = 81;BA.debugLine="Private lvb1 As LVBattery";
mostCurrent._lvb1 = new de.donmanfred.LVBatteryWrapper();
 //BA.debugLineNum = 82;BA.debugLine="Private endsum As Label";
mostCurrent._endsum = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Dim anim As Animation";
mostCurrent._anim = new anywheresoftware.b4a.objects.AnimationWrapper();
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public static String  _hexa_buttonpressed(de.amberhome.materialdialogs.MaterialDialogWrapper _dialog,String _action) throws Exception{
 //BA.debugLineNum = 590;BA.debugLine="Sub hexa_ButtonPressed (Dialog As MaterialDialog,";
 //BA.debugLineNum = 591;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_dialog.ACTION_POSITIVE,_dialog.ACTION_NEGATIVE,_dialog.ACTION_NEUTRAL)) {
case 0: {
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
 //BA.debugLineNum = 599;BA.debugLine="End Sub";
return "";
}
public static String  _im_ad() throws Exception{
anywheresoftware.b4a.objects.drawable.BitmapDrawable _icon = null;
anywheresoftware.b4a.objects.LabelWrapper _la1 = null;
anywheresoftware.b4a.objects.LabelWrapper _la2 = null;
String _d = "";
anywheresoftware.b4a.objects.LabelWrapper _lt = null;
 //BA.debugLineNum = 634;BA.debugLine="Sub im_ad";
 //BA.debugLineNum = 635;BA.debugLine="Dim icon As BitmapDrawable";
_icon = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 636;BA.debugLine="Dim la1,la2 As Label";
_la1 = new anywheresoftware.b4a.objects.LabelWrapper();
_la2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 637;BA.debugLine="la2.Initialize(\"la2\")";
_la2.Initialize(mostCurrent.activityBA,"la2");
 //BA.debugLineNum = 638;BA.debugLine="la1.Initialize(\"la1\")";
_la1.Initialize(mostCurrent.activityBA,"la1");
 //BA.debugLineNum = 639;BA.debugLine="la1=lolist.TwoLinesAndBitmap.Label";
_la1 = mostCurrent._lolist.getTwoLinesAndBitmap().Label;
 //BA.debugLineNum = 640;BA.debugLine="la2=lolist.TwoLinesAndBitmap.SecondLabel";
_la2 = mostCurrent._lolist.getTwoLinesAndBitmap().SecondLabel;
 //BA.debugLineNum = 641;BA.debugLine="la1.TextSize=15";
_la1.setTextSize((float) (15));
 //BA.debugLineNum = 642;BA.debugLine="la2.TextSize=13";
_la2.setTextSize((float) (13));
 //BA.debugLineNum = 643;BA.debugLine="la1.Typeface=rfont";
_la1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 644;BA.debugLine="la2.Typeface=rfont";
_la2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 645;BA.debugLine="la1.TextColor=mcl.md_white_1000";
_la1.setTextColor(mostCurrent._mcl.getmd_white_1000());
 //BA.debugLineNum = 646;BA.debugLine="la2.TextColor=mcl.md_amber_500";
_la2.setTextColor(mostCurrent._mcl.getmd_amber_500());
 //BA.debugLineNum = 647;BA.debugLine="lolist.TwoLinesAndBitmap.ImageView.Height=32dip";
mostCurrent._lolist.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 648;BA.debugLine="lolist.TwoLinesAndBitmap.ImageView.Width=32dip";
mostCurrent._lolist.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 649;BA.debugLine="lolist.TwoLinesAndBitmap.ItemHeight=55dip";
mostCurrent._lolist.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
 //BA.debugLineNum = 650;BA.debugLine="lolist.Clear";
mostCurrent._lolist.Clear();
 //BA.debugLineNum = 651;BA.debugLine="For Each d As String In alist.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group17 = mostCurrent._alist._listkeys();
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_d = BA.ObjectToString(group17.Get(index17));
 //BA.debugLineNum = 652;BA.debugLine="icon=pack.GetApplicationIcon(d)";
_icon.setObject((android.graphics.drawable.BitmapDrawable)(mostCurrent._pack.GetApplicationIcon(_d)));
 //BA.debugLineNum = 653;BA.debugLine="lolist.AddTwoLinesAndBitmap(pack.GetApplicationL";
mostCurrent._lolist.AddTwoLinesAndBitmap(BA.ObjectToCharSequence(mostCurrent._pack.GetApplicationLabel(_d)),BA.ObjectToCharSequence(_formatfilesize((float)(BA.ObjectToNumber(mostCurrent._alist._get(_d))))),_icon.getBitmap());
 }
};
 //BA.debugLineNum = 655;BA.debugLine="Dim lt As Label";
_lt = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 656;BA.debugLine="lt.Initialize(\"\")";
_lt.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 657;BA.debugLine="lt.Text=\"löche nicht mehr benötigte Daten\"";
_lt.setText(BA.ObjectToCharSequence("löche nicht mehr benötigte Daten"));
 //BA.debugLineNum = 658;BA.debugLine="lt.Typeface=rfont";
_lt.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 659;BA.debugLine="lt.TextSize=14";
_lt.setTextSize((float) (14));
 //BA.debugLineNum = 660;BA.debugLine="lt.TextColor=mcl.md_white_1000";
_lt.setTextColor(mostCurrent._mcl.getmd_white_1000());
 //BA.debugLineNum = 662;BA.debugLine="End Sub";
return "";
}
public static String  _l_stat() throws Exception{
 //BA.debugLineNum = 401;BA.debugLine="Sub l_stat";
 //BA.debugLineNum = 402;BA.debugLine="If kvsdata.ContainsKey(\"cs\") Then";
if (mostCurrent._kvsdata._containskey("cs")) { 
 //BA.debugLineNum = 403;BA.debugLine="l_sub";
_l_sub();
 }else {
 //BA.debugLineNum = 405;BA.debugLine="lv1.Clear";
mostCurrent._lv1.Clear();
 //BA.debugLineNum = 406;BA.debugLine="lv1.AddTwoLinesAndBitmap2(\"Nicht ausgeführt..\",\"";
mostCurrent._lv1.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("Nicht ausgeführt.."),BA.ObjectToCharSequence("drücke den Scan Button um einen ersten Scan zu starten"),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_announcement_black_36dp.png").getObject()),(Object)(0));
 };
 //BA.debugLineNum = 408;BA.debugLine="End Sub";
return "";
}
public static String  _l_sub() throws Exception{
int _sum = 0;
String _na = "";
String _g = "";
 //BA.debugLineNum = 410;BA.debugLine="Sub l_sub";
 //BA.debugLineNum = 411;BA.debugLine="Dim sum As Int=0";
_sum = (int) (0);
 //BA.debugLineNum = 412;BA.debugLine="Dim na As String";
_na = "";
 //BA.debugLineNum = 413;BA.debugLine="For Each g As String In alist.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group3 = mostCurrent._alist._listkeys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_g = BA.ObjectToString(group3.Get(index3));
 //BA.debugLineNum = 414;BA.debugLine="Log(FormatFileSize(alist.Get(g)))";
anywheresoftware.b4a.keywords.Common.Log(_formatfilesize((float)(BA.ObjectToNumber(mostCurrent._alist._get(_g)))));
 //BA.debugLineNum = 415;BA.debugLine="sum=sum+alist.Get(g)";
_sum = (int) (_sum+(double)(BA.ObjectToNumber(mostCurrent._alist._get(_g))));
 //BA.debugLineNum = 416;BA.debugLine="na=g";
_na = _g;
 }
};
 //BA.debugLineNum = 419;BA.debugLine="dbase.Put(sum,na)";
mostCurrent._dbase._put(BA.NumberToString(_sum),(Object)(_na));
 //BA.debugLineNum = 420;BA.debugLine="If dbase.ContainsKey(sum) Then";
if (mostCurrent._dbase._containskey(BA.NumberToString(_sum))) { 
 //BA.debugLineNum = 421;BA.debugLine="tota_sub";
_tota_sub();
 };
 //BA.debugLineNum = 423;BA.debugLine="lv1.Clear";
mostCurrent._lv1.Clear();
 //BA.debugLineNum = 424;BA.debugLine="lv1.AddTwoLinesAndBitmap2(FormatFileSize(sum)&\" b";
mostCurrent._lv1.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence(_formatfilesize((float) (_sum))+" bereinigt"),BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._alist._listkeys().getSize())+" App(s) optimiert.."),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_message_white_36dp.png").getObject()),(Object)(2));
 //BA.debugLineNum = 425;BA.debugLine="End Sub";
return "";
}
public static String  _left() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _la1 = null;
anywheresoftware.b4a.objects.LabelWrapper _la2 = null;
 //BA.debugLineNum = 477;BA.debugLine="Sub left";
 //BA.debugLineNum = 478;BA.debugLine="Dim la1,la2 As Label";
_la1 = new anywheresoftware.b4a.objects.LabelWrapper();
_la2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 479;BA.debugLine="la2.Initialize(\"la2\")";
_la2.Initialize(mostCurrent.activityBA,"la2");
 //BA.debugLineNum = 480;BA.debugLine="la1.Initialize(\"la1\")";
_la1.Initialize(mostCurrent.activityBA,"la1");
 //BA.debugLineNum = 481;BA.debugLine="la1=leftlist.TwoLinesAndBitmap.Label";
_la1 = mostCurrent._leftlist.getTwoLinesAndBitmap().Label;
 //BA.debugLineNum = 482;BA.debugLine="la2=leftlist.TwoLinesAndBitmap.SecondLabel";
_la2 = mostCurrent._leftlist.getTwoLinesAndBitmap().SecondLabel;
 //BA.debugLineNum = 483;BA.debugLine="leftlist.TwoLinesAndBitmap.ImageView.Height=32dip";
mostCurrent._leftlist.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 484;BA.debugLine="leftlist.TwoLinesAndBitmap.ImageView.Width=32dip";
mostCurrent._leftlist.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 485;BA.debugLine="leftlist.TwoLinesAndBitmap.ItemHeight=50dip";
mostCurrent._leftlist.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 486;BA.debugLine="la1.TextSize=15";
_la1.setTextSize((float) (15));
 //BA.debugLineNum = 487;BA.debugLine="la2.TextSize=11";
_la2.setTextSize((float) (11));
 //BA.debugLineNum = 488;BA.debugLine="la1.Typeface=rfont";
_la1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 489;BA.debugLine="la2.Typeface=rfont";
_la2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 490;BA.debugLine="la1.TextColor=mcl.md_black_1000";
_la1.setTextColor(mostCurrent._mcl.getmd_black_1000());
 //BA.debugLineNum = 491;BA.debugLine="la2.TextColor=Colors.ARGB(180,255,255,255)";
_la2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 492;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Height=32dip";
mostCurrent._lv1.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 493;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Width=32dip";
mostCurrent._lv1.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 494;BA.debugLine="lv1.TwoLinesAndBitmap.ItemHeight=55dip";
mostCurrent._lv1.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
 //BA.debugLineNum = 495;BA.debugLine="leftlist.AddTwoLinesAndBitmap2(\"Einstellungen\",\"S";
mostCurrent._leftlist.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("Einstellungen"),BA.ObjectToCharSequence("Service,widget einstellungen etc.."),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_settings_applications_white_36dp.png").getObject()),(Object)(0));
 //BA.debugLineNum = 496;BA.debugLine="leftlist.AddTwoLinesAndBitmap2(\"Feedback\",\"Sende";
mostCurrent._leftlist.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("Feedback"),BA.ObjectToCharSequence("Sende uns Vorschläge"),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_message_white_36dp.png").getObject()),(Object)(1));
 //BA.debugLineNum = 497;BA.debugLine="Return";
if (true) return "";
 //BA.debugLineNum = 498;BA.debugLine="End Sub";
return "";
}
public static String  _leftlist_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 500;BA.debugLine="Sub leftlist_ItemClick (Position As Int, Value As";
 //BA.debugLineNum = 501;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)(0),(Object)(1))) {
case 0: {
 //BA.debugLineNum = 503;BA.debugLine="set_click";
_set_click();
 break; }
case 1: {
 //BA.debugLineNum = 505;BA.debugLine="sm.HideMenus";
mostCurrent._sm.HideMenus();
 //BA.debugLineNum = 506;BA.debugLine="StartActivity(supp)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._supp.getObject()));
 //BA.debugLineNum = 507;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
mostCurrent._animator._setanimati(mostCurrent.activityBA,"extra_in","extra_out");
 break; }
}
;
 //BA.debugLineNum = 509;BA.debugLine="End Sub";
return "";
}
public static String  _lo_tick() throws Exception{
int _sum = 0;
String _g = "";
 //BA.debugLineNum = 555;BA.debugLine="Sub lo_tick";
 //BA.debugLineNum = 557;BA.debugLine="lolist.Clear";
mostCurrent._lolist.Clear();
 //BA.debugLineNum = 558;BA.debugLine="pdim.SetElevationAnimated(300,10dip)";
mostCurrent._pdim.SetElevationAnimated((int) (300),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 //BA.debugLineNum = 559;BA.debugLine="sr.Visible=False";
mostCurrent._sr.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 560;BA.debugLine="Dim sum As Int=0";
_sum = (int) (0);
 //BA.debugLineNum = 561;BA.debugLine="For Each g As String In alist.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group5 = mostCurrent._alist._listkeys();
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_g = BA.ObjectToString(group5.Get(index5));
 //BA.debugLineNum = 562;BA.debugLine="Log(FormatFileSize(alist.Get(g)))";
anywheresoftware.b4a.keywords.Common.Log(_formatfilesize((float)(BA.ObjectToNumber(mostCurrent._alist._get(_g)))));
 //BA.debugLineNum = 563;BA.debugLine="sum=sum+alist.Get(g)";
_sum = (int) (_sum+(double)(BA.ObjectToNumber(mostCurrent._alist._get(_g))));
 }
};
 //BA.debugLineNum = 565;BA.debugLine="lolist.AddTwoLinesAndBitmap2(alist.ListKeys.Size&";
mostCurrent._lolist.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._alist._listkeys().getSize())+" App(s) gesäubert:"),BA.ObjectToCharSequence("mit: "+_formatfilesize((float) (_sum))),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_message_white_36dp.png").getObject()),(Object)(0));
 //BA.debugLineNum = 566;BA.debugLine="End Sub";
return "";
}
public static String  _log_list() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _ll = null;
anywheresoftware.b4a.objects.LabelWrapper _lk = null;
de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _builder = null;
 //BA.debugLineNum = 575;BA.debugLine="Sub log_list";
 //BA.debugLineNum = 576;BA.debugLine="pn.SetVisibleAnimated(450,False)";
mostCurrent._pn.SetVisibleAnimated((int) (450),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 577;BA.debugLine="Dim ll,lk As Label";
_ll = new anywheresoftware.b4a.objects.LabelWrapper();
_lk = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 578;BA.debugLine="ll.Initialize(\"\")";
_ll.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 579;BA.debugLine="lk.Initialize(\"\")";
_lk.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 580;BA.debugLine="ll.Text=\"keine App-daten gefunden..\"";
_ll.setText(BA.ObjectToCharSequence("keine App-daten gefunden.."));
 //BA.debugLineNum = 581;BA.debugLine="ll.Textsize=12";
_ll.setTextSize((float) (12));
 //BA.debugLineNum = 582;BA.debugLine="ll.Typeface=rfont";
_ll.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 583;BA.debugLine="Dim builder As MaterialDialogBuilder";
_builder = new de.amberhome.materialdialogs.MaterialDialogBuilderWrapper();
 //BA.debugLineNum = 584;BA.debugLine="builder.Initialize(\"hexa\")";
_builder.Initialize(mostCurrent.activityBA,"hexa");
 //BA.debugLineNum = 585;BA.debugLine="builder.ContentGravity(builder.GRAVITY_START)";
_builder.ContentGravity(_builder.GRAVITY_START);
 //BA.debugLineNum = 586;BA.debugLine="builder.Title(\"Clean!\").TitleColor(mcl.md_grey_50";
_builder.Title(BA.ObjectToCharSequence("Clean!")).TitleColor(mostCurrent._mcl.getmd_grey_500()).Content(BA.ObjectToCharSequence(_ll.getText())).ContentColor(mostCurrent._mcl.getmd_amber_500()).Theme(_builder.THEME_DARK).NeutralText(BA.ObjectToCharSequence("Ok"));
 //BA.debugLineNum = 587;BA.debugLine="dia=builder.Show";
mostCurrent._dia = _builder.Show();
 //BA.debugLineNum = 588;BA.debugLine="End Sub";
return "";
}
public static String  _lolist_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 567;BA.debugLine="Sub lolist_ItemClick (Position As Int, Value As Ob";
 //BA.debugLineNum = 568;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)(0))) {
case 0: {
 break; }
}
;
 //BA.debugLineNum = 572;BA.debugLine="End Sub";
return "";
}
public static String  _lv1_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 294;BA.debugLine="Sub lv1_ItemClick (Position As Int, Value As Objec";
 //BA.debugLineNum = 295;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)(2))) {
case 0: {
 //BA.debugLineNum = 297;BA.debugLine="sub_list";
_sub_list();
 break; }
}
;
 //BA.debugLineNum = 299;BA.debugLine="End Sub";
return "";
}
public static String  _p_button() throws Exception{
MLfiles.Fileslib.MLfiles _ml = null;
long _used1 = 0L;
long _summe1 = 0L;
long _totz = 0L;
int _total = 0;
int _summ2 = 0;
int _div = 0;
 //BA.debugLineNum = 342;BA.debugLine="Sub p_button";
 //BA.debugLineNum = 343;BA.debugLine="Dim ml As MLfiles";
_ml = new MLfiles.Fileslib.MLfiles();
 //BA.debugLineNum = 344;BA.debugLine="pb1.BottomTextSize=18";
mostCurrent._pb1.setBottomTextSize((float) (18));
 //BA.debugLineNum = 345;BA.debugLine="pb2.BottomTextSize=18";
mostCurrent._pb2.setBottomTextSize((float) (18));
 //BA.debugLineNum = 346;BA.debugLine="pb1.TextSize=55";
mostCurrent._pb1.setTextSize((float) (55));
 //BA.debugLineNum = 347;BA.debugLine="pb2.TextSize=40";
mostCurrent._pb2.setTextSize((float) (40));
 //BA.debugLineNum = 348;BA.debugLine="pb1.TextColor=Colors.ARGB(200,255,255,255)";
mostCurrent._pb1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 349;BA.debugLine="pb2.TextColor=Colors.ARGB(200,255,255,255)";
mostCurrent._pb2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (200),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 350;BA.debugLine="pb2.SuffixText=\"% SD\"";
mostCurrent._pb2.setSuffixText("% SD");
 //BA.debugLineNum = 351;BA.debugLine="pb1.SuffixText=\"% RAM\"";
mostCurrent._pb1.setSuffixText("% RAM");
 //BA.debugLineNum = 352;BA.debugLine="pb2.SuffixTextSize=21";
mostCurrent._pb2.setSuffixTextSize((float) (21));
 //BA.debugLineNum = 353;BA.debugLine="pb1.SuffixTextSize=21";
mostCurrent._pb1.setSuffixTextSize((float) (21));
 //BA.debugLineNum = 354;BA.debugLine="Dim used1,summe1,totz As Long";
_used1 = 0L;
_summe1 = 0L;
_totz = 0L;
 //BA.debugLineNum = 355;BA.debugLine="used1=os.TotalExternalMemorySize-os.AvailableExte";
_used1 = (long) (_os.getTotalExternalMemorySize()-_os.getAvailableExternalMemorySize());
 //BA.debugLineNum = 356;BA.debugLine="summe1=used1";
_summe1 = _used1;
 //BA.debugLineNum = 357;BA.debugLine="totz=os.TotalExternalMemorySize";
_totz = _os.getTotalExternalMemorySize();
 //BA.debugLineNum = 358;BA.debugLine="Dim total,summ2,div As Int";
_total = 0;
_summ2 = 0;
_div = 0;
 //BA.debugLineNum = 359;BA.debugLine="total=os.TotalExternalMemorySize";
_total = (int) (_os.getTotalExternalMemorySize());
 //BA.debugLineNum = 360;BA.debugLine="div=os.AvailableExternalMemorySize";
_div = (int) (_os.getAvailableExternalMemorySize());
 //BA.debugLineNum = 361;BA.debugLine="summ2=total-div";
_summ2 = (int) (_total-_div);
 //BA.debugLineNum = 362;BA.debugLine="pb2.BottomText=FormatFileSize(summe1)&\"/\"&FormatF";
mostCurrent._pb2.setBottomText(_formatfilesize((float) (_summe1))+"/"+_formatfilesize((float) (_totz)));
 //BA.debugLineNum = 363;BA.debugLine="pb2.Max=100";
mostCurrent._pb2.setMax((int) (100));
 //BA.debugLineNum = 364;BA.debugLine="pb2.Progress=100-((os.getAvailableBlocks(File.Dir";
mostCurrent._pb2.setProgress((int) (100-((_os.getAvailableBlocks(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal()))/(double)(_os.getBlockCount(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal())))*100));
 //BA.debugLineNum = 365;BA.debugLine="pb1.FinishedStrokeColor=mcl.md_cyan_A200";
mostCurrent._pb1.setFinishedStrokeColor(mostCurrent._mcl.getmd_cyan_A200());
 //BA.debugLineNum = 366;BA.debugLine="pb2.FinishedStrokeColor=mcl.md_cyan_A200";
mostCurrent._pb2.setFinishedStrokeColor(mostCurrent._mcl.getmd_cyan_A200());
 //BA.debugLineNum = 367;BA.debugLine="pb1.UnfinishedStrokeColor=Colors.ARGB(170,255,255";
mostCurrent._pb1.setUnfinishedStrokeColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (170),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 368;BA.debugLine="pb2.UnfinishedStrokeColor=Colors.ARGB(170,255,255";
mostCurrent._pb2.setUnfinishedStrokeColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (170),(int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 369;BA.debugLine="pb1.StrokeWidth=8dip";
mostCurrent._pb1.setStrokeWidth((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8))));
 //BA.debugLineNum = 370;BA.debugLine="pb2.StrokeWidth=7dip";
mostCurrent._pb2.setStrokeWidth((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (7))));
 //BA.debugLineNum = 371;BA.debugLine="pb1.ArcAngle=220";
mostCurrent._pb1.setArcAngle((float) (220));
 //BA.debugLineNum = 372;BA.debugLine="pb2.ArcAngle=220";
mostCurrent._pb2.setArcAngle((float) (220));
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return "";
}
public static String  _pb_update() throws Exception{
int _cc = 0;
int _tot = 0;
 //BA.debugLineNum = 686;BA.debugLine="Sub pb_update";
 //BA.debugLineNum = 687;BA.debugLine="Dim cc,tot As Int";
_cc = 0;
_tot = 0;
 //BA.debugLineNum = 688;BA.debugLine="tot=kvst.Get(\"ta\")";
_tot = (int)(BA.ObjectToNumber(mostCurrent._kvst._get("ta")));
 //BA.debugLineNum = 689;BA.debugLine="cc=kvsdata.Get(\"c\")";
_cc = (int)(BA.ObjectToNumber(mostCurrent._kvsdata._get("c")));
 //BA.debugLineNum = 690;BA.debugLine="ss.Progress=100/tot*cc";
mostCurrent._ss.setProgress(100/(double)_tot*_cc);
 //BA.debugLineNum = 691;BA.debugLine="End Sub";
return "";
}
public static String  _prb_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lt = null;
 //BA.debugLineNum = 664;BA.debugLine="Sub prb_Click";
 //BA.debugLineNum = 665;BA.debugLine="AnimateBorder(prb)";
_animateborder((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._prb.getObject())));
 //BA.debugLineNum = 666;BA.debugLine="Dim lt As Label";
_lt = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 667;BA.debugLine="lt.Initialize(\"\")";
_lt.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 668;BA.debugLine="lt.Typeface=rfont";
_lt.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 669;BA.debugLine="lt.Text=\"bitte warten..\"";
_lt.setText(BA.ObjectToCharSequence("bitte warten.."));
 //BA.debugLineNum = 670;BA.debugLine="xOSStats.EndStats";
mostCurrent._xosstats._endstats();
 //BA.debugLineNum = 671;BA.debugLine="sm.HideMenus";
mostCurrent._sm.HideMenus();
 //BA.debugLineNum = 672;BA.debugLine="lt.TextSize=11";
_lt.setTextSize((float) (11));
 //BA.debugLineNum = 673;BA.debugLine="prb.Text=lt.Text";
mostCurrent._prb.setText(BA.ObjectToCharSequence(_lt.getText()));
 //BA.debugLineNum = 674;BA.debugLine="prb.TextColor=mcl.md_white_1000";
mostCurrent._prb.setTextColor(mostCurrent._mcl.getmd_white_1000());
 //BA.debugLineNum = 675;BA.debugLine="CallSubDelayed(Starter,\"remote_start\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._starter.getObject()),"remote_start");
 //BA.debugLineNum = 676;BA.debugLine="prb.SetVisibleAnimated(300,False)";
mostCurrent._prb.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 677;BA.debugLine="prb2.SetVisibleAnimated(300,False)";
mostCurrent._prb2.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 678;BA.debugLine="prb3.SetVisibleAnimated(400,False)";
mostCurrent._prb3.SetVisibleAnimated((int) (400),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 679;BA.debugLine="tool2.SetVisibleAnimated(500,False)";
mostCurrent._tool2.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 680;BA.debugLine="lv1.SetVisibleAnimated(300,False)";
mostCurrent._lv1.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 681;BA.debugLine="extrapan.SetVisibleAnimated(200,False)";
mostCurrent._extrapan.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 682;BA.debugLine="pn.SetVisibleAnimated(250,True)";
mostCurrent._pn.SetVisibleAnimated((int) (250),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 684;BA.debugLine="End Sub";
return "";
}
public static String  _prb2_click() throws Exception{
MLfiles.Fileslib.MLfiles _ml = null;
anywheresoftware.b4a.objects.LabelWrapper _l1 = null;
anywheresoftware.b4a.objects.LabelWrapper _l2 = null;
anywheresoftware.b4a.objects.PanelWrapper _mempan = null;
anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomDialog2 _cd = null;
 //BA.debugLineNum = 726;BA.debugLine="Sub prb2_Click";
 //BA.debugLineNum = 727;BA.debugLine="Dim ml As MLfiles";
_ml = new MLfiles.Fileslib.MLfiles();
 //BA.debugLineNum = 728;BA.debugLine="Dim l1,l2 As Label";
_l1 = new anywheresoftware.b4a.objects.LabelWrapper();
_l2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 729;BA.debugLine="l1.Initialize(\"\")";
_l1.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 730;BA.debugLine="l2.Initialize(\"\")";
_l2.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 731;BA.debugLine="l2.TextSize=11";
_l2.setTextSize((float) (11));
 //BA.debugLineNum = 732;BA.debugLine="l1.TextSize=12";
_l1.setTextSize((float) (12));
 //BA.debugLineNum = 733;BA.debugLine="l1.textcolor=mcl.md_black_1000";
_l1.setTextColor(mostCurrent._mcl.getmd_black_1000());
 //BA.debugLineNum = 734;BA.debugLine="l2.textcolor=mcl.md_amber_600";
_l2.setTextColor(mostCurrent._mcl.getmd_amber_600());
 //BA.debugLineNum = 735;BA.debugLine="l1.Gravity=Gravity.TOP";
_l1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
 //BA.debugLineNum = 736;BA.debugLine="l1.Typeface=rfont";
_l1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 737;BA.debugLine="l2.Typeface=rfont";
_l2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 738;BA.debugLine="Dim mempan As Panel";
_mempan = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 739;BA.debugLine="mempan.Initialize(\"\")";
_mempan.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 740;BA.debugLine="mempan.Color=mcl.md_white_1000";
_mempan.setColor(mostCurrent._mcl.getmd_white_1000());
 //BA.debugLineNum = 741;BA.debugLine="mempan.AddView(l1,8%x,15%y,85%x,80%y)";
_mempan.AddView((android.view.View)(_l1.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (85),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA));
 //BA.debugLineNum = 742;BA.debugLine="l2.Text=\"Speicher Infomation\"";
_l2.setText(BA.ObjectToCharSequence("Speicher Infomation"));
 //BA.debugLineNum = 743;BA.debugLine="l1.Text=savedata.Get(\"sd\")";
_l1.setText(BA.ObjectToCharSequence(mostCurrent._savedata._get("sd")));
 //BA.debugLineNum = 745;BA.debugLine="Dim cd As CustomDialog2";
_cd = new anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomDialog2();
 //BA.debugLineNum = 746;BA.debugLine="cd.AddView(mempan,100%x,100%y)";
_cd.AddView((android.view.View)(_mempan.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 747;BA.debugLine="cd.Show(l2.Text,\"\",\"Ok\",\"\",LoadBitmap(File.DirAss";
_cd.Show(_l2.getText(),"","Ok","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_sd_storage_black_36dp.png").getObject()));
 //BA.debugLineNum = 748;BA.debugLine="End Sub";
return "";
}
public static String  _prb3_click() throws Exception{
MLfiles.Fileslib.MLfiles _ml = null;
anywheresoftware.b4a.objects.LabelWrapper _l1 = null;
anywheresoftware.b4a.objects.LabelWrapper _l2 = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _mempan = null;
anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomDialog _cd = null;
 //BA.debugLineNum = 751;BA.debugLine="Sub prb3_Click";
 //BA.debugLineNum = 752;BA.debugLine="Dim ml As MLfiles";
_ml = new MLfiles.Fileslib.MLfiles();
 //BA.debugLineNum = 753;BA.debugLine="Dim l1,l2 As Label";
_l1 = new anywheresoftware.b4a.objects.LabelWrapper();
_l2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 754;BA.debugLine="l1.Initialize(\"\")";
_l1.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 755;BA.debugLine="l2.Initialize(\"\")";
_l2.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 756;BA.debugLine="l2.TextSize=11";
_l2.setTextSize((float) (11));
 //BA.debugLineNum = 757;BA.debugLine="l1.TextSize=13";
_l1.setTextSize((float) (13));
 //BA.debugLineNum = 758;BA.debugLine="l1.textcolor=mcl.md_black_1000";
_l1.setTextColor(mostCurrent._mcl.getmd_black_1000());
 //BA.debugLineNum = 759;BA.debugLine="l2.textcolor=mcl.md_black_1000";
_l2.setTextColor(mostCurrent._mcl.getmd_black_1000());
 //BA.debugLineNum = 760;BA.debugLine="l1.Gravity=Gravity.TOP";
_l1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
 //BA.debugLineNum = 761;BA.debugLine="l1.Typeface=rfont";
_l1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 762;BA.debugLine="l2.Typeface=rfont";
_l2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 763;BA.debugLine="Dim mempan As ScrollView";
_mempan = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 764;BA.debugLine="mempan.Initialize(100%y)";
_mempan.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 765;BA.debugLine="mempan.FullScroll(True)";
_mempan.FullScroll(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 766;BA.debugLine="mempan.Panel.AddView(l1,3%x,1%y,87%x,100%y)";
_mempan.getPanel().AddView((android.view.View)(_l1.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (87),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 767;BA.debugLine="l2.Text=\"CPU Infomation\"";
_l2.setText(BA.ObjectToCharSequence("CPU Infomation"));
 //BA.debugLineNum = 768;BA.debugLine="l1.Text=savedata.Get(\"ci\")";
_l1.setText(BA.ObjectToCharSequence(mostCurrent._savedata._get("ci")));
 //BA.debugLineNum = 770;BA.debugLine="Dim cd As CustomDialog";
_cd = new anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomDialog();
 //BA.debugLineNum = 771;BA.debugLine="mempan.Color=mcl.md_white_1000";
_mempan.setColor(mostCurrent._mcl.getmd_white_1000());
 //BA.debugLineNum = 772;BA.debugLine="cd.AddView(mempan,0,0,100%x,100%y)";
_cd.AddView((android.view.View)(_mempan.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 773;BA.debugLine="cd.Show(l2.Text,\"\",\"Ok\",\"\",LoadBitmap(File.DirAss";
_cd.Show(_l2.getText(),"","Ok","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_memory_white_36dp.png").getObject()));
 //BA.debugLineNum = 774;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
supp._process_globals();
option._process_globals();
starter._process_globals();
info._process_globals();
widget._process_globals();
statemanager._process_globals();
animator._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private os As OperatingSystem";
_os = new com.rootsoft.oslibrary.OSLibrary();
 //BA.debugLineNum = 29;BA.debugLine="Dim date,time1 As String";
_date = "";
_time1 = "";
 //BA.debugLineNum = 30;BA.debugLine="Private rfont As Typeface= rfont.LoadFromAssets(\"";
_rfont = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
_rfont.setObject((android.graphics.Typeface)(_rfont.LoadFromAssets("Aldrich-Regular.ttf")));
 //BA.debugLineNum = 31;BA.debugLine="Private package As String=\"de.sclean\"";
_package = "de.sclean";
 //BA.debugLineNum = 32;BA.debugLine="Dim t1,t2 As Timer";
_t1 = new anywheresoftware.b4a.objects.Timer();
_t2 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _r_schredder() throws Exception{
 //BA.debugLineNum = 601;BA.debugLine="Sub r_schredder";
 //BA.debugLineNum = 602;BA.debugLine="schredder(True)";
_schredder(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 603;BA.debugLine="End Sub";
return "";
}
public static String  _schredder(boolean _f) throws Exception{
 //BA.debugLineNum = 605;BA.debugLine="Sub schredder (f As Boolean)";
 //BA.debugLineNum = 606;BA.debugLine="If f=True Then";
if (_f==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 607;BA.debugLine="prb.SetVisibleAnimated(200,False)";
mostCurrent._prb.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 608;BA.debugLine="prb2.SetVisibleAnimated(200,False)";
mostCurrent._prb2.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 609;BA.debugLine="prb3.SetVisibleAnimated(200,False)";
mostCurrent._prb3.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 610;BA.debugLine="tool2.SetVisibleAnimated(200,False)";
mostCurrent._tool2.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 611;BA.debugLine="lv1.SetVisibleAnimated(200,False)";
mostCurrent._lv1.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 612;BA.debugLine="ldim.SetVisibleAnimated(200,True)";
mostCurrent._ldim.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 613;BA.debugLine="pdim.SetVisibleAnimated(200,True)";
mostCurrent._pdim.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 614;BA.debugLine="sr.startAnim";
mostCurrent._sr.startAnim();
 //BA.debugLineNum = 615;BA.debugLine="sr.SetVisibleAnimated(200,True)";
mostCurrent._sr.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 617;BA.debugLine="im_ad";
_im_ad();
 }else {
 //BA.debugLineNum = 619;BA.debugLine="If f=False Then";
if (_f==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 620;BA.debugLine="prb.SetVisibleAnimated(200,True)";
mostCurrent._prb.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 621;BA.debugLine="prb2.SetVisibleAnimated(200,True)";
mostCurrent._prb2.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 622;BA.debugLine="prb3.SetVisibleAnimated(200,True)";
mostCurrent._prb3.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 623;BA.debugLine="tool2.SetVisibleAnimated(200,True)";
mostCurrent._tool2.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 624;BA.debugLine="lv1.SetVisibleAnimated(200,True)";
mostCurrent._lv1.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 625;BA.debugLine="ldim.SetVisibleAnimated(300,False)";
mostCurrent._ldim.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 626;BA.debugLine="pdim.SetVisibleAnimated(300,False)";
mostCurrent._pdim.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 627;BA.debugLine="extrapan.SetVisibleAnimated(250,True)";
mostCurrent._extrapan.SetVisibleAnimated((int) (250),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 628;BA.debugLine="sr.stopAnim";
mostCurrent._sr.stopAnim();
 //BA.debugLineNum = 629;BA.debugLine="sr.SetVisibleAnimated(300,False)";
mostCurrent._sr.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 //BA.debugLineNum = 632;BA.debugLine="End Sub";
return "";
}
public static String  _set_click() throws Exception{
 //BA.debugLineNum = 511;BA.debugLine="Sub set_click";
 //BA.debugLineNum = 512;BA.debugLine="sm.HideMenus";
mostCurrent._sm.HideMenus();
 //BA.debugLineNum = 513;BA.debugLine="StartActivity(option)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._option.getObject()));
 //BA.debugLineNum = 514;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
mostCurrent._animator._setanimati(mostCurrent.activityBA,"extra_in","extra_out");
 //BA.debugLineNum = 515;BA.debugLine="End Sub";
return "";
}
public static String  _stats_update(float[] _cpuefficiency,float _ramusage) throws Exception{
 //BA.debugLineNum = 815;BA.debugLine="Sub Stats_Update(CPUEfficiency() As Float, RAMUsag";
 //BA.debugLineNum = 816;BA.debugLine="rb1.Progress=CPUEfficiency(1)";
mostCurrent._rb1.setProgress((int) (_cpuefficiency[(int) (1)]));
 //BA.debugLineNum = 817;BA.debugLine="pb1.Progress=RAMUsage";
mostCurrent._pb1.setProgress((int) (_ramusage));
 //BA.debugLineNum = 818;BA.debugLine="pb1.BottomText=FormatFileSize(RAMUsage*1024*1024*";
mostCurrent._pb1.setBottomText(_formatfilesize((float) (_ramusage*1024*1024*10))+"/"+_formatfilesize((float) (mostCurrent._xmsos.getSystemTotalMemorySize(mostCurrent.activityBA))));
 //BA.debugLineNum = 819;BA.debugLine="End Sub";
return "";
}
public static String  _sub_list() throws Exception{
anywheresoftware.b4a.objects.collections.List _lo = null;
de.amberhome.materialdialogs.MaterialSimpleListItemWrapper _mi = null;
anywheresoftware.b4a.objects.LabelWrapper _ll = null;
anywheresoftware.b4a.objects.LabelWrapper _lk = null;
de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _builder = null;
String _i = "";
 //BA.debugLineNum = 301;BA.debugLine="Sub sub_list";
 //BA.debugLineNum = 302;BA.debugLine="Dim lo As List";
_lo = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 303;BA.debugLine="Dim mi As MaterialSimpleListItem";
_mi = new de.amberhome.materialdialogs.MaterialSimpleListItemWrapper();
 //BA.debugLineNum = 304;BA.debugLine="lo.Initialize";
_lo.Initialize();
 //BA.debugLineNum = 305;BA.debugLine="Dim ll,lk As Label";
_ll = new anywheresoftware.b4a.objects.LabelWrapper();
_lk = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 306;BA.debugLine="ll.Initialize(\"\")";
_ll.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 307;BA.debugLine="lk.Initialize(\"\")";
_lk.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 308;BA.debugLine="ll.Textsize=12";
_ll.setTextSize((float) (12));
 //BA.debugLineNum = 309;BA.debugLine="ll.Typeface=rfont";
_ll.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 310;BA.debugLine="ll.Text=alist.ListKeys.Size&\" Anwendungen:\"";
_ll.setText(BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._alist._listkeys().getSize())+" Anwendungen:"));
 //BA.debugLineNum = 311;BA.debugLine="Dim builder As MaterialDialogBuilder";
_builder = new de.amberhome.materialdialogs.MaterialDialogBuilderWrapper();
 //BA.debugLineNum = 312;BA.debugLine="builder.Initialize(\"fexa\")";
_builder.Initialize(mostCurrent.activityBA,"fexa");
 //BA.debugLineNum = 313;BA.debugLine="lo=File.ReadList(dir,\"clist.txt\")";
_lo = anywheresoftware.b4a.keywords.Common.File.ReadList(mostCurrent._dir,"clist.txt");
 //BA.debugLineNum = 314;BA.debugLine="For Each i As String In alist.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group13 = mostCurrent._alist._listkeys();
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_i = BA.ObjectToString(group13.Get(index13));
 //BA.debugLineNum = 315;BA.debugLine="Log(i)";
anywheresoftware.b4a.keywords.Common.Log(_i);
 //BA.debugLineNum = 316;BA.debugLine="mi.Initialize(pack.GetApplicationIcon(i),pack.Ge";
_mi.Initialize(processBA,mostCurrent._pack.GetApplicationIcon(_i),BA.ObjectToCharSequence(mostCurrent._pack.GetApplicationLabel(_i)+" / "+_formatfilesize((float)(BA.ObjectToNumber(mostCurrent._alist._get(_i))))));
 //BA.debugLineNum = 317;BA.debugLine="builder.AddSimpleItem(mi)";
_builder.AddSimpleItem(_mi);
 }
};
 //BA.debugLineNum = 319;BA.debugLine="builder.ContentGravity(builder.GRAVITY_START)";
_builder.ContentGravity(_builder.GRAVITY_START);
 //BA.debugLineNum = 320;BA.debugLine="builder.Title(\"Clean Log:\").TitleColor(mcl.md_bla";
_builder.Title(BA.ObjectToCharSequence("Clean Log:")).TitleColor(mostCurrent._mcl.getmd_black_1000()).Content(BA.ObjectToCharSequence(_ll.getText())).ContentColor(mostCurrent._mcl.getmd_light_blue_A700()).Theme(_builder.THEME_LIGHT).NegativeText(BA.ObjectToCharSequence("Ok")).NegativeColor(mostCurrent._mcl.getmd_black_1000()).PositiveColor(mostCurrent._mcl.getmd_red_500()).PositiveText(BA.ObjectToCharSequence("lösche log"));
 //BA.debugLineNum = 321;BA.debugLine="dia=builder.Show";
mostCurrent._dia = _builder.Show();
 //BA.debugLineNum = 322;BA.debugLine="dia.Show";
mostCurrent._dia.Show();
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return "";
}
public static String  _t1_start() throws Exception{
 //BA.debugLineNum = 518;BA.debugLine="Sub t1_start";
 //BA.debugLineNum = 519;BA.debugLine="t1.Enabled=True";
_t1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 520;BA.debugLine="CallSubDelayed(Starter,\"clean_start\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._starter.getObject()),"clean_start");
 //BA.debugLineNum = 521;BA.debugLine="r_schredder";
_r_schredder();
 //BA.debugLineNum = 522;BA.debugLine="End Sub";
return "";
}
public static String  _t1_tick() throws Exception{
 //BA.debugLineNum = 523;BA.debugLine="Sub t1_Tick";
 //BA.debugLineNum = 524;BA.debugLine="counter=counter+1";
_counter = (int) (_counter+1);
 //BA.debugLineNum = 525;BA.debugLine="Log(\"tick\")";
anywheresoftware.b4a.keywords.Common.Log("tick");
 //BA.debugLineNum = 526;BA.debugLine="If counter> 1 Then";
if (_counter>1) { 
 //BA.debugLineNum = 527;BA.debugLine="endsum_calc";
_endsum_calc();
 };
 //BA.debugLineNum = 529;BA.debugLine="If counter>4 Then";
if (_counter>4) { 
 //BA.debugLineNum = 530;BA.debugLine="sr.SetVisibleAnimated(100,False)";
mostCurrent._sr.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 531;BA.debugLine="pdim.SetVisibleAnimated(100,False)";
mostCurrent._pdim.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 532;BA.debugLine="ready.SetVisibleAnimated(150,True)";
mostCurrent._ready.SetVisibleAnimated((int) (150),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 533;BA.debugLine="endsum.SetVisibleAnimated(150,True)";
mostCurrent._endsum.SetVisibleAnimated((int) (150),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 534;BA.debugLine="lo_tick";
_lo_tick();
 };
 //BA.debugLineNum = 536;BA.debugLine="If counter= 7 Then";
if (_counter==7) { 
 //BA.debugLineNum = 537;BA.debugLine="t1.Enabled=False";
_t1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 538;BA.debugLine="counter=0";
_counter = (int) (0);
 //BA.debugLineNum = 540;BA.debugLine="dp_clear";
_dp_clear();
 //BA.debugLineNum = 541;BA.debugLine="dp_clean";
_dp_clean();
 //BA.debugLineNum = 542;BA.debugLine="l_sub";
_l_sub();
 };
 //BA.debugLineNum = 544;BA.debugLine="End Sub";
return "";
}
public static String  _toolbar_menuitemclick(de.amberhome.objects.appcompat.ACMenuItemWrapper _item) throws Exception{
 //BA.debugLineNum = 279;BA.debugLine="Sub toolbar_MenuItemClick (Item As ACMenuItem)";
 //BA.debugLineNum = 280;BA.debugLine="Select Item.Id";
switch (BA.switchObjectToInt(_item.getId(),(int)(Double.parseDouble("0")),(int)(Double.parseDouble("1")),(int)(Double.parseDouble("2")))) {
case 0: {
 //BA.debugLineNum = 282;BA.debugLine="sm.ShowMenu";
mostCurrent._sm.ShowMenu();
 break; }
case 1: {
 //BA.debugLineNum = 284;BA.debugLine="set_click";
_set_click();
 break; }
case 2: {
 //BA.debugLineNum = 286;BA.debugLine="If sm.Visible=True Then";
if (mostCurrent._sm.getVisible()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 287;BA.debugLine="sm.HideMenus";
mostCurrent._sm.HideMenus();
 }else {
 //BA.debugLineNum = 289;BA.debugLine="sm.ShowMenu";
mostCurrent._sm.ShowMenu();
 };
 break; }
}
;
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
return "";
}
public static String  _toolbar_navigationitemclick() throws Exception{
 //BA.debugLineNum = 276;BA.debugLine="Sub toolbar_NavigationItemClick";
 //BA.debugLineNum = 277;BA.debugLine="exit_click";
_exit_click();
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return "";
}
public static String  _tools_start() throws Exception{
 //BA.debugLineNum = 338;BA.debugLine="Sub tools_start";
 //BA.debugLineNum = 340;BA.debugLine="End Sub";
return "";
}
public static String  _tota_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _lo = null;
de.amberhome.materialdialogs.MaterialSimpleListItemWrapper _mi = null;
anywheresoftware.b4a.objects.LabelWrapper _ll = null;
anywheresoftware.b4a.objects.LabelWrapper _lk = null;
de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _builder = null;
String _i = "";
 //BA.debugLineNum = 445;BA.debugLine="Sub tota_Click";
 //BA.debugLineNum = 446;BA.debugLine="Dim lo As List";
_lo = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 447;BA.debugLine="Dim mi As MaterialSimpleListItem";
_mi = new de.amberhome.materialdialogs.MaterialSimpleListItemWrapper();
 //BA.debugLineNum = 448;BA.debugLine="lo.Initialize";
_lo.Initialize();
 //BA.debugLineNum = 449;BA.debugLine="Dim ll,lk As Label";
_ll = new anywheresoftware.b4a.objects.LabelWrapper();
_lk = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 450;BA.debugLine="ll.Initialize(\"\")";
_ll.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 451;BA.debugLine="lk.Initialize(\"\")";
_lk.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 452;BA.debugLine="ll.Textsize=10";
_ll.setTextSize((float) (10));
 //BA.debugLineNum = 453;BA.debugLine="ll.Typeface=rfont";
_ll.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 454;BA.debugLine="ll.Text=dbase.ListKeys.Size&\" Anwendungen:\"";
_ll.setText(BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._dbase._listkeys().getSize())+" Anwendungen:"));
 //BA.debugLineNum = 455;BA.debugLine="Dim builder As MaterialDialogBuilder";
_builder = new de.amberhome.materialdialogs.MaterialDialogBuilderWrapper();
 //BA.debugLineNum = 456;BA.debugLine="builder.Initialize(\"dexa\")";
_builder.Initialize(mostCurrent.activityBA,"dexa");
 //BA.debugLineNum = 457;BA.debugLine="For Each i As String In dbase.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group12 = mostCurrent._dbase._listkeys();
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_i = BA.ObjectToString(group12.Get(index12));
 //BA.debugLineNum = 458;BA.debugLine="mi.Initialize2(\"tc32\",dbase.Get(i)&\" - \"&FormatF";
_mi.Initialize2(processBA,"tc32",BA.ObjectToCharSequence(BA.ObjectToString(mostCurrent._dbase._get(_i))+" - "+_formatfilesize((float)(Double.parseDouble(_i)))));
 //BA.debugLineNum = 459;BA.debugLine="builder.AddSimpleItem(mi)";
_builder.AddSimpleItem(_mi);
 }
};
 //BA.debugLineNum = 461;BA.debugLine="builder.ContentGravity(builder.GRAVITY_START)";
_builder.ContentGravity(_builder.GRAVITY_START);
 //BA.debugLineNum = 462;BA.debugLine="builder.Title(\"Total Clean Log:\").TitleColor(mcl.";
_builder.Title(BA.ObjectToCharSequence("Total Clean Log:")).TitleColor(mostCurrent._mcl.getmd_black_1000()).Content(BA.ObjectToCharSequence(_ll.getText())).ContentColor(mostCurrent._mcl.getmd_blue_grey_800()).Theme(_builder.THEME_LIGHT).NegativeText(BA.ObjectToCharSequence("Ok")).NegativeColor(mostCurrent._mcl.getmd_black_1000()).PositiveColor(mostCurrent._mcl.getmd_red_500()).PositiveText(BA.ObjectToCharSequence("löschen"));
 //BA.debugLineNum = 463;BA.debugLine="dia=builder.Show";
mostCurrent._dia = _builder.Show();
 //BA.debugLineNum = 464;BA.debugLine="dia.Show";
mostCurrent._dia.Show();
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
return "";
}
public static String  _tota_sub() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _stext = null;
int _sum = 0;
String _s = "";
anywheresoftware.b4a.objects.CSBuilder _cs = null;
 //BA.debugLineNum = 427;BA.debugLine="Sub tota_sub";
 //BA.debugLineNum = 428;BA.debugLine="Dim Stext As Label";
_stext = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 429;BA.debugLine="Stext.Initialize(\"\")";
_stext.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 430;BA.debugLine="Stext.TextColor=mcl.md_amber_500";
_stext.setTextColor(mostCurrent._mcl.getmd_amber_500());
 //BA.debugLineNum = 431;BA.debugLine="Stext.TextSize=30";
_stext.setTextSize((float) (30));
 //BA.debugLineNum = 432;BA.debugLine="Dim sum As Int=0";
_sum = (int) (0);
 //BA.debugLineNum = 433;BA.debugLine="For Each s As String In dbase.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group6 = mostCurrent._dbase._listkeys();
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_s = BA.ObjectToString(group6.Get(index6));
 //BA.debugLineNum = 434;BA.debugLine="sum=sum+s";
_sum = (int) (_sum+(double)(Double.parseDouble(_s)));
 //BA.debugLineNum = 435;BA.debugLine="Log(FormatFileSize(sum))";
anywheresoftware.b4a.keywords.Common.Log(_formatfilesize((float) (_sum)));
 }
};
 //BA.debugLineNum = 437;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 438;BA.debugLine="Stext.text=FormatFileSize(sum)";
_stext.setText(BA.ObjectToCharSequence(_formatfilesize((float) (_sum))));
 //BA.debugLineNum = 439;BA.debugLine="cs.Initialize.Color(Colors.ARGB(230,255,255,255))";
_cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (230),(int) (255),(int) (255),(int) (255))).Append(BA.ObjectToCharSequence("Total "+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 440;BA.debugLine="cs.Bold.Color(Colors.ARGB(230,255,255,255)).Appen";
_cs.Bold().Color(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (230),(int) (255),(int) (255),(int) (255))).Append(BA.ObjectToCharSequence(_stext.getText()+anywheresoftware.b4a.keywords.Common.CRLF)).Pop().PopAll();
 //BA.debugLineNum = 441;BA.debugLine="tota.SetVisibleAnimated(300,True)";
mostCurrent._tota.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 442;BA.debugLine="tota.Text=cs";
mostCurrent._tota.setText(BA.ObjectToCharSequence(_cs.getObject()));
 //BA.debugLineNum = 443;BA.debugLine="End Sub";
return "";
}
public static String  _total_off() throws Exception{
 //BA.debugLineNum = 701;BA.debugLine="Sub total_off";
 //BA.debugLineNum = 703;BA.debugLine="log_list";
_log_list();
 //BA.debugLineNum = 704;BA.debugLine="prb.SetVisibleAnimated(150,True)";
mostCurrent._prb.SetVisibleAnimated((int) (150),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 705;BA.debugLine="prb2.SetVisibleAnimated(150,True)";
mostCurrent._prb2.SetVisibleAnimated((int) (150),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 706;BA.debugLine="prb3.SetVisibleAnimated(150,True)";
mostCurrent._prb3.SetVisibleAnimated((int) (150),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 707;BA.debugLine="tool2.SetVisibleAnimated(150,True)";
mostCurrent._tool2.SetVisibleAnimated((int) (150),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 708;BA.debugLine="prb.Text=\"scan\"";
mostCurrent._prb.setText(BA.ObjectToCharSequence("scan"));
 //BA.debugLineNum = 709;BA.debugLine="xOSStats.StartStats";
mostCurrent._xosstats._startstats();
 //BA.debugLineNum = 710;BA.debugLine="End Sub";
return "";
}
public static float  _valuefromtimelinear(int _time,float _start,float _changeinvalue,int _duration) throws Exception{
 //BA.debugLineNum = 961;BA.debugLine="Private Sub ValueFromTimeLinear(time As Int, Start";
 //BA.debugLineNum = 962;BA.debugLine="Return ChangeInValue * time / Duration + Start";
if (true) return (float) (_changeinvalue*_time/(double)_duration+_start);
 //BA.debugLineNum = 963;BA.debugLine="End Sub";
return 0f;
}
public boolean _onCreateOptionsMenu(android.view.Menu menu) {
    if (processBA.subExists("activity_createmenu")) {
        processBA.raiseEvent2(null, true, "activity_createmenu", false, new de.amberhome.objects.appcompat.ACMenuWrapper(menu));
        return true;
    }
    else
        return false;
}
}
