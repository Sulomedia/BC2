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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "de.sclean", "de.sclean.main");
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (supp.mostCurrent != null);
vis = vis | (option.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (supp.previousOne != null) {
				__a = supp.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(supp.mostCurrent == null ? null : supp.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (option.previousOne != null) {
				__a = option.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(option.mostCurrent == null ? null : option.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, info.class));
BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, widget.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static com.rootsoft.oslibrary.OSLibrary _os = null;
public static String _date = "";
public static String _time = "";
public static anywheresoftware.b4a.keywords.constants.TypefaceWrapper _rfont = null;
public static String _package = "";
public static anywheresoftware.b4a.objects.Timer _t1 = null;
public static anywheresoftware.b4a.objects.Timer _t2 = null;
public static String _utext = "";
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
public circleprogressmasterwrapper.donutProgressMasterWrapper _ss = null;
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
public anywheresoftware.b4a.objects.ProgressBarWrapper _sr = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ready = null;
public de.amberhome.objects.appcompat.ACFlatButtonWrapper _prb = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.info _info = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;
public static String  _about_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "about_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "about_click", null);
anywheresoftware.b4a.objects.LabelWrapper _l1 = null;
anywheresoftware.b4a.objects.LabelWrapper _l2 = null;
anywheresoftware.b4a.objects.CSBuilder _cs = null;
de.amberhome.materialdialogs.MaterialDialogWrapper _infodia = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _inf = null;
de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _builder = null;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub about_click";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Dim l1,l2 As Label";
_l1 = new anywheresoftware.b4a.objects.LabelWrapper();
_l2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="l1.Initialize(\"\")";
_l1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="l2.Initialize(\"\")";
_l2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="l2.TextSize=15";
_l2.setTextSize((float) (15));
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="l1.TextSize=13";
_l1.setTextSize((float) (13));
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="l1.textcolor=mcl.md_white_1000";
_l1.setTextColor(mostCurrent._mcl.getmd_white_1000());
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="l2.textcolor=mcl.md_white_1000";
_l2.setTextColor(mostCurrent._mcl.getmd_white_1000());
RDebugUtils.currentLine=2621448;
 //BA.debugLineNum = 2621448;BA.debugLine="l1.Gravity=Gravity.TOP";
_l1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="l1.Typeface=rfont";
_l1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=2621450;
 //BA.debugLineNum = 2621450;BA.debugLine="l2.Typeface=rfont";
_l2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=2621451;
 //BA.debugLineNum = 2621451;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=2621452;
 //BA.debugLineNum = 2621452;BA.debugLine="cs.Initialize.Append(\"App Ver: \"&pack.GetVersionN";
_cs.Initialize().Append(BA.ObjectToCharSequence("App Ver: "+mostCurrent._pack.GetVersionName(_package)+anywheresoftware.b4a.keywords.Common.CRLF+"Build Nr: "+BA.NumberToString(mostCurrent._pack.GetVersionCode(_package))+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Code: D.Trojan"+anywheresoftware.b4a.keywords.Common.CRLF)).Append(BA.ObjectToCharSequence("Published by Sulomedia"+anywheresoftware.b4a.keywords.Common.CRLF+"© 2017"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF));
RDebugUtils.currentLine=2621453;
 //BA.debugLineNum = 2621453;BA.debugLine="cs.Append(CreateClickableWord(utext)).PopAll";
_cs.Append(BA.ObjectToCharSequence(_createclickableword(_utext).getObject())).PopAll();
RDebugUtils.currentLine=2621454;
 //BA.debugLineNum = 2621454;BA.debugLine="l2.Text=\"About \"&pack.GetApplicationLabel(package";
_l2.setText(BA.ObjectToCharSequence("About "+mostCurrent._pack.GetApplicationLabel(_package)));
RDebugUtils.currentLine=2621455;
 //BA.debugLineNum = 2621455;BA.debugLine="l1.Text=cs";
_l1.setText(BA.ObjectToCharSequence(_cs.getObject()));
RDebugUtils.currentLine=2621456;
 //BA.debugLineNum = 2621456;BA.debugLine="Dim infodia As MaterialDialog";
_infodia = new de.amberhome.materialdialogs.MaterialDialogWrapper();
RDebugUtils.currentLine=2621457;
 //BA.debugLineNum = 2621457;BA.debugLine="Dim inf As BitmapDrawable";
_inf = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=2621458;
 //BA.debugLineNum = 2621458;BA.debugLine="inf.Initialize(LoadBitmap(File.DirAssets,\"smm_sma";
_inf.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"smm_small_logo.png").getObject()));
RDebugUtils.currentLine=2621459;
 //BA.debugLineNum = 2621459;BA.debugLine="Dim Builder As MaterialDialogBuilder";
_builder = new de.amberhome.materialdialogs.MaterialDialogBuilderWrapper();
RDebugUtils.currentLine=2621460;
 //BA.debugLineNum = 2621460;BA.debugLine="Builder.Initialize(\"Dialog3\")";
_builder.Initialize(mostCurrent.activityBA,"Dialog3");
RDebugUtils.currentLine=2621461;
 //BA.debugLineNum = 2621461;BA.debugLine="Builder.Title(l2.Text).TitleColor(mcl.md_black_10";
_builder.Title(BA.ObjectToCharSequence(_l2.getText())).TitleColor(mostCurrent._mcl.getmd_black_1000()).Icon((android.graphics.drawable.Drawable)(_inf.getObject())).LimitIconToDefaultSize().Theme(_builder.THEME_DARK).Content(BA.ObjectToCharSequence(_cs.getObject())).ContentLineSpacing((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))).Typeface((android.graphics.Typeface)(_rfont.getObject()),(android.graphics.Typeface)(_rfont.getObject())).Cancelable(anywheresoftware.b4a.keywords.Common.True).NeutralText(BA.ObjectToCharSequence("close")).NeutralColor(mostCurrent._mcl.getmd_grey_400()).ContentGravity(_builder.GRAVITY_START).ContentLineSpacing((float) (2));
RDebugUtils.currentLine=2621462;
 //BA.debugLineNum = 2621462;BA.debugLine="infodia=Builder.Show";
_infodia = _builder.Show();
RDebugUtils.currentLine=2621463;
 //BA.debugLineNum = 2621463;BA.debugLine="infodia.Show";
_infodia.Show();
RDebugUtils.currentLine=2621464;
 //BA.debugLineNum = 2621464;BA.debugLine="cs.EnableClickEvents(l1)";
_cs.EnableClickEvents((android.widget.TextView)(_l1.getObject()));
RDebugUtils.currentLine=2621465;
 //BA.debugLineNum = 2621465;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.CSBuilder  _createclickableword(String _text) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createclickableword"))
	return (anywheresoftware.b4a.objects.CSBuilder) Debug.delegate(mostCurrent.activityBA, "createclickableword", new Object[] {_text});
anywheresoftware.b4a.objects.CSBuilder _cs = null;
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub CreateClickableWord(Text As String) As CSBuild";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Return cs.Initialize.Underline.Color(0xFF00D0FF).";
if (true) return _cs.Initialize().Underline().Color((int) (0xff00d0ff)).Clickable(processBA,"Word",(Object)(_text)).Append(BA.ObjectToCharSequence(_text)).PopAll();
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="End Sub";
return null;
}
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
anywheresoftware.b4a.objects.PanelWrapper _lftmenu = null;
int _offset = 0;
anywheresoftware.b4a.objects.LabelWrapper _la1 = null;
anywheresoftware.b4a.objects.LabelWrapper _la2 = null;
MLfiles.Fileslib.MLfiles _ml = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Activity.TitleColor=mcl.md_black_1000";
mostCurrent._activity.setTitleColor(mostCurrent._mcl.getmd_black_1000());
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.Title=pack.GetApplicationLabel(package)";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence(mostCurrent._pack.GetApplicationLabel(_package)));
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Activity.Color=Colors.ARGB(255,65,66,67)";
mostCurrent._activity.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (65),(int) (66),(int) (67)));
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="ABHelper.Initialize";
mostCurrent._abhelper.Initialize(mostCurrent.activityBA);
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="toolbar.SetAsActionBar";
mostCurrent._toolbar.SetAsActionBar(mostCurrent.activityBA);
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="toolbar.InitMenuListener";
mostCurrent._toolbar.InitMenuListener();
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="toolbar.PopupTheme=toolbar.THEME_DARK";
mostCurrent._toolbar.setPopupTheme(mostCurrent._toolbar.THEME_DARK);
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="toolbar.SubTitle=\"V\"&pack.GetVersionName(package)";
mostCurrent._toolbar.setSubTitle(BA.ObjectToCharSequence("V"+mostCurrent._pack.GetVersionName(_package)));
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="ABHelper.ShowUpIndicator = True";
mostCurrent._abhelper.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="ABHelper.HomeVisible=True";
mostCurrent._abhelper.setHomeVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="DateTime.TimeFormat=\"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="DateTime.DateFormat=\"dd-MM-yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd-MM-yyyy");
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="date=DateTime.Date(DateTime.Now)";
_date = anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="time=DateTime.Time(DateTime.Now)";
_time = anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="xOSStats.Initialize(400, 50, Me, \"Stats\")";
mostCurrent._xosstats._initialize(mostCurrent.activityBA,(int) (400),(int) (50),main.getObject(),"Stats");
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="im1.Initialize(\"im1\")";
mostCurrent._im1.Initialize(mostCurrent.activityBA,"im1");
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="os.Initialize(\"os\")";
_os.Initialize(processBA,"os");
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="sm.Initialize(\"sm\")";
mostCurrent._sm.Initialize(mostCurrent.activityBA,"sm");
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="t1.Initialize(\"t1\",1000)";
_t1.Initialize(processBA,"t1",(long) (1000));
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="t2.Initialize(\"t2\",1000)";
_t2.Initialize(processBA,"t2",(long) (1000));
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="sr.Initialize(\"sr\")";
mostCurrent._sr.Initialize(mostCurrent.activityBA,"sr");
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="ldim.Initialize(\"ldim\")";
mostCurrent._ldim.Initialize(mostCurrent.activityBA,"ldim");
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="pdim.Initialize(\"pdim\")";
mostCurrent._pdim.Initialize(mostCurrent.activityBA,"pdim");
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="ready.Initialize(\"ready\")";
mostCurrent._ready.Initialize(mostCurrent.activityBA,"ready");
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="ldim.Visible=False";
mostCurrent._ldim.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="pdim.Visible=False";
mostCurrent._pdim.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="lolist.Initialize(\"lolist\")";
mostCurrent._lolist.Initialize(mostCurrent.activityBA,"lolist");
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="pdim.AddView(lolist,1%x,1%y,99%x,70%y)";
mostCurrent._pdim.AddView((android.view.View)(mostCurrent._lolist.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (99),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="counter=0";
_counter = (int) (0);
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="t1.Enabled=False";
_t1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131107;
 //BA.debugLineNum = 131107;BA.debugLine="t2.Enabled=False";
_t2.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="Dim lftMenu As Panel";
_lftmenu = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="lftMenu.Initialize(\"\")";
_lftmenu.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131110;
 //BA.debugLineNum = 131110;BA.debugLine="lftMenu.LoadLayout(\"left\")";
_lftmenu.LoadLayout("left",mostCurrent.activityBA);
RDebugUtils.currentLine=131111;
 //BA.debugLineNum = 131111;BA.debugLine="Dim offset As Int = 20%x";
_offset = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA);
RDebugUtils.currentLine=131112;
 //BA.debugLineNum = 131112;BA.debugLine="sm.BehindOffset = offset";
mostCurrent._sm.setBehindOffset(_offset);
RDebugUtils.currentLine=131113;
 //BA.debugLineNum = 131113;BA.debugLine="sm.Menu.AddView(lftMenu, 0, 0, 100%x-offset, 100%";
mostCurrent._sm.getMenu().AddView((android.view.View)(_lftmenu.getObject()),(int) (0),(int) (0),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-_offset),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131114;
 //BA.debugLineNum = 131114;BA.debugLine="sm.Mode = sm.LEFT";
mostCurrent._sm.setMode(mostCurrent._sm.LEFT);
RDebugUtils.currentLine=131115;
 //BA.debugLineNum = 131115;BA.debugLine="Dim la1,la2 As Label";
_la1 = new anywheresoftware.b4a.objects.LabelWrapper();
_la2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=131116;
 //BA.debugLineNum = 131116;BA.debugLine="la2.Initialize(\"la2\")";
_la2.Initialize(mostCurrent.activityBA,"la2");
RDebugUtils.currentLine=131117;
 //BA.debugLineNum = 131117;BA.debugLine="la1.Initialize(\"la1\")";
_la1.Initialize(mostCurrent.activityBA,"la1");
RDebugUtils.currentLine=131118;
 //BA.debugLineNum = 131118;BA.debugLine="la1=lv1.TwoLinesAndBitmap.Label";
_la1 = mostCurrent._lv1.getTwoLinesAndBitmap().Label;
RDebugUtils.currentLine=131119;
 //BA.debugLineNum = 131119;BA.debugLine="la2=lv1.TwoLinesAndBitmap.SecondLabel";
_la2 = mostCurrent._lv1.getTwoLinesAndBitmap().SecondLabel;
RDebugUtils.currentLine=131120;
 //BA.debugLineNum = 131120;BA.debugLine="la1.TextSize=15";
_la1.setTextSize((float) (15));
RDebugUtils.currentLine=131121;
 //BA.debugLineNum = 131121;BA.debugLine="la2.TextSize=13";
_la2.setTextSize((float) (13));
RDebugUtils.currentLine=131122;
 //BA.debugLineNum = 131122;BA.debugLine="la1.Typeface=rfont";
_la1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=131123;
 //BA.debugLineNum = 131123;BA.debugLine="la2.Typeface=rfont";
_la2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=131124;
 //BA.debugLineNum = 131124;BA.debugLine="la1.TextColor=mcl.md_grey_900";
_la1.setTextColor(mostCurrent._mcl.getmd_grey_900());
RDebugUtils.currentLine=131125;
 //BA.debugLineNum = 131125;BA.debugLine="la2.TextColor=Colors.ARGB(190,255,255,255)";
_la2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (190),(int) (255),(int) (255),(int) (255)));
RDebugUtils.currentLine=131126;
 //BA.debugLineNum = 131126;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Height=32dip";
mostCurrent._lv1.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
RDebugUtils.currentLine=131127;
 //BA.debugLineNum = 131127;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Width=32dip";
mostCurrent._lv1.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
RDebugUtils.currentLine=131128;
 //BA.debugLineNum = 131128;BA.debugLine="lv1.TwoLinesAndBitmap.ItemHeight=55dip";
mostCurrent._lv1.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=131129;
 //BA.debugLineNum = 131129;BA.debugLine="kvst.Initialize(File.DirInternal,\"data_time\")";
mostCurrent._kvst._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_time");
RDebugUtils.currentLine=131130;
 //BA.debugLineNum = 131130;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
mostCurrent._kvsdata._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_data");
RDebugUtils.currentLine=131131;
 //BA.debugLineNum = 131131;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
mostCurrent._alist._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"adata_data");
RDebugUtils.currentLine=131132;
 //BA.debugLineNum = 131132;BA.debugLine="dbase.Initialize(File.DirInternal,\"dbase_data\")";
mostCurrent._dbase._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"dbase_data");
RDebugUtils.currentLine=131133;
 //BA.debugLineNum = 131133;BA.debugLine="abase.Initialize(File.DirInternal,\"abase_data\")";
mostCurrent._abase._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"abase_data");
RDebugUtils.currentLine=131134;
 //BA.debugLineNum = 131134;BA.debugLine="prb.Typeface=rfont";
mostCurrent._prb.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=131135;
 //BA.debugLineNum = 131135;BA.debugLine="prb.Text=\"Scan\"";
mostCurrent._prb.setText(BA.ObjectToCharSequence("Scan"));
RDebugUtils.currentLine=131136;
 //BA.debugLineNum = 131136;BA.debugLine="ss.Initialize(\"ss\")";
mostCurrent._ss.Initialize(processBA,"ss");
RDebugUtils.currentLine=131137;
 //BA.debugLineNum = 131137;BA.debugLine="Activity.AddView(ldim,0,10%y,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._ldim.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131138;
 //BA.debugLineNum = 131138;BA.debugLine="ldim.Color=Colors.ARGB(230,0,0,0)";
mostCurrent._ldim.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (230),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=131139;
 //BA.debugLineNum = 131139;BA.debugLine="pdim.Color=Colors.ARGB(230,0,0,0)";
mostCurrent._pdim.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (230),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=131140;
 //BA.debugLineNum = 131140;BA.debugLine="pdim.Elevation=5dip";
mostCurrent._pdim.setElevation((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=131141;
 //BA.debugLineNum = 131141;BA.debugLine="Activity.AddView(sr,25%x,10%y,150dip,150dip)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._sr.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
RDebugUtils.currentLine=131142;
 //BA.debugLineNum = 131142;BA.debugLine="Activity.AddView(ready,25%x,40%y,150dip,150dip)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._ready.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
RDebugUtils.currentLine=131143;
 //BA.debugLineNum = 131143;BA.debugLine="Activity.AddView(pdim,0%x,45%y,100%x,70%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pdim.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (45),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (70),mostCurrent.activityBA));
RDebugUtils.currentLine=131144;
 //BA.debugLineNum = 131144;BA.debugLine="sr.Visible=False";
mostCurrent._sr.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131145;
 //BA.debugLineNum = 131145;BA.debugLine="tota.TextColor=mcl.md_grey_600";
mostCurrent._tota.setTextColor(mostCurrent._mcl.getmd_grey_600());
RDebugUtils.currentLine=131146;
 //BA.debugLineNum = 131146;BA.debugLine="tota.TextSize=22";
mostCurrent._tota.setTextSize((float) (22));
RDebugUtils.currentLine=131147;
 //BA.debugLineNum = 131147;BA.debugLine="tota.Typeface=rfont";
mostCurrent._tota.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=131148;
 //BA.debugLineNum = 131148;BA.debugLine="pn.Initialize(\"\")";
mostCurrent._pn.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131149;
 //BA.debugLineNum = 131149;BA.debugLine="pn.Color=Colors.ARGB(220,0,0,0)";
mostCurrent._pn.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (220),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=131150;
 //BA.debugLineNum = 131150;BA.debugLine="sl.Initialize(\"sl\")";
mostCurrent._sl.Initialize(mostCurrent.activityBA,"sl");
RDebugUtils.currentLine=131151;
 //BA.debugLineNum = 131151;BA.debugLine="sl.Text=\"Einen Moment bitte, Apps werden durchsuc";
mostCurrent._sl.setText(BA.ObjectToCharSequence("Einen Moment bitte, Apps werden durchsucht.."));
RDebugUtils.currentLine=131152;
 //BA.debugLineNum = 131152;BA.debugLine="sl.Textsize=20";
mostCurrent._sl.setTextSize((float) (20));
RDebugUtils.currentLine=131153;
 //BA.debugLineNum = 131153;BA.debugLine="sl.Typeface=rfont";
mostCurrent._sl.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=131155;
 //BA.debugLineNum = 131155;BA.debugLine="Activity.AddView(pn,0%x,1%y,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pn.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131156;
 //BA.debugLineNum = 131156;BA.debugLine="pn.AddView(ss,10%x,15%y,250dip,250dip)";
mostCurrent._pn.AddView((android.view.View)(mostCurrent._ss.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)));
RDebugUtils.currentLine=131157;
 //BA.debugLineNum = 131157;BA.debugLine="pn.AddView(sl,10%x,15%y+250dip+20dip,300dip,300di";
mostCurrent._pn.AddView((android.view.View)(mostCurrent._sl.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (15),mostCurrent.activityBA)+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=131158;
 //BA.debugLineNum = 131158;BA.debugLine="pn.Visible=False";
mostCurrent._pn.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131159;
 //BA.debugLineNum = 131159;BA.debugLine="ready.Visible=False";
mostCurrent._ready.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131160;
 //BA.debugLineNum = 131160;BA.debugLine="ready.Bitmap=LoadBitmap(File.DirAssets,\"Accept256";
mostCurrent._ready.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Accept256.png").getObject()));
RDebugUtils.currentLine=131161;
 //BA.debugLineNum = 131161;BA.debugLine="ready.Gravity=Gravity.FILL";
mostCurrent._ready.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=131162;
 //BA.debugLineNum = 131162;BA.debugLine="sr.Indeterminate=True";
mostCurrent._sr.setIndeterminate(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131163;
 //BA.debugLineNum = 131163;BA.debugLine="ss.PrefixText=\"Scan: \"";
mostCurrent._ss.setPrefixText("Scan: ");
RDebugUtils.currentLine=131164;
 //BA.debugLineNum = 131164;BA.debugLine="ss.SuffixText=\"/ \"&kvst.Get(\"ta\")&\" Apps\"";
mostCurrent._ss.setSuffixText("/ "+BA.ObjectToString(mostCurrent._kvst._get(null,"ta"))+" Apps");
RDebugUtils.currentLine=131165;
 //BA.debugLineNum = 131165;BA.debugLine="ss.FinishedStrokeWidth=15dip";
mostCurrent._ss.setFinishedStrokeWidth((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))));
RDebugUtils.currentLine=131166;
 //BA.debugLineNum = 131166;BA.debugLine="ss.UnfinishedStrokeWidth=10dip";
mostCurrent._ss.setUnfinishedStrokeWidth((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=131167;
 //BA.debugLineNum = 131167;BA.debugLine="ss.FinishedStrokeColor= mcl.md_amber_700";
mostCurrent._ss.setFinishedStrokeColor(mostCurrent._mcl.getmd_amber_700());
RDebugUtils.currentLine=131168;
 //BA.debugLineNum = 131168;BA.debugLine="ss.UnfinishedStrokeColor=mcl.md_grey_600";
mostCurrent._ss.setUnfinishedStrokeColor(mostCurrent._mcl.getmd_grey_600());
RDebugUtils.currentLine=131169;
 //BA.debugLineNum = 131169;BA.debugLine="ss.TextSize=30";
mostCurrent._ss.setTextSize((float) (30));
RDebugUtils.currentLine=131170;
 //BA.debugLineNum = 131170;BA.debugLine="ss.Max=abase.ListKeys.Size";
mostCurrent._ss.setMax(mostCurrent._abase._listkeys(null).getSize());
RDebugUtils.currentLine=131171;
 //BA.debugLineNum = 131171;BA.debugLine="Dim ml As MLfiles";
_ml = new MLfiles.Fileslib.MLfiles();
RDebugUtils.currentLine=131172;
 //BA.debugLineNum = 131172;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=131174;
 //BA.debugLineNum = 131174;BA.debugLine="If ml.SdcardReady=\"mounted\" Then";
if ((_ml.SdcardReady()).equals("mounted")) { 
RDebugUtils.currentLine=131175;
 //BA.debugLineNum = 131175;BA.debugLine="File.MakeDir(ml.GetExtSd,\"S-Cleaner/tmp\")";
anywheresoftware.b4a.keywords.Common.File.MakeDir(_ml.GetExtSd(),"S-Cleaner/tmp");
RDebugUtils.currentLine=131176;
 //BA.debugLineNum = 131176;BA.debugLine="ToastMessageShow(\"SD Karte erkannt: \"&ml.GetExt";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("SD Karte erkannt: "+_ml.GetExtSd()),anywheresoftware.b4a.keywords.Common.False);
 };
 };
RDebugUtils.currentLine=131180;
 //BA.debugLineNum = 131180;BA.debugLine="CallSubDelayed(Starter,\"info_remote\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._starter.getObject()),"info_remote");
RDebugUtils.currentLine=131181;
 //BA.debugLineNum = 131181;BA.debugLine="l_stat";
_l_stat();
RDebugUtils.currentLine=131182;
 //BA.debugLineNum = 131182;BA.debugLine="left";
_left();
RDebugUtils.currentLine=131183;
 //BA.debugLineNum = 131183;BA.debugLine="p_button";
_p_button();
RDebugUtils.currentLine=131184;
 //BA.debugLineNum = 131184;BA.debugLine="End Sub";
return "";
}
public static String  _l_stat() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "l_stat"))
	return (String) Debug.delegate(mostCurrent.activityBA, "l_stat", null);
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub l_stat";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="If kvsdata.ContainsKey(\"cs\") Then";
if (mostCurrent._kvsdata._containskey(null,"cs")) { 
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="l_sub";
_l_sub();
 }else {
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="lv1.Clear";
mostCurrent._lv1.Clear();
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="lv1.AddTwoLinesAndBitmap2(\"Nicht ausgeführt..\",\"";
mostCurrent._lv1.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("Nicht ausgeführt.."),BA.ObjectToCharSequence("drücke den Scan Button um einen ersten Scan zu starten"),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_sms_failed_white_36dp.png").getObject()),(Object)(0));
 };
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="End Sub";
return "";
}
public static String  _left() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "left"))
	return (String) Debug.delegate(mostCurrent.activityBA, "left", null);
anywheresoftware.b4a.objects.LabelWrapper _la1 = null;
anywheresoftware.b4a.objects.LabelWrapper _la2 = null;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub left";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim la1,la2 As Label";
_la1 = new anywheresoftware.b4a.objects.LabelWrapper();
_la2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="la2.Initialize(\"la2\")";
_la2.Initialize(mostCurrent.activityBA,"la2");
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="la1.Initialize(\"la1\")";
_la1.Initialize(mostCurrent.activityBA,"la1");
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="la1=leftlist.TwoLinesAndBitmap.Label";
_la1 = mostCurrent._leftlist.getTwoLinesAndBitmap().Label;
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="la2=leftlist.TwoLinesAndBitmap.SecondLabel";
_la2 = mostCurrent._leftlist.getTwoLinesAndBitmap().SecondLabel;
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="leftlist.TwoLinesAndBitmap.ImageView.Height=32dip";
mostCurrent._leftlist.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="leftlist.TwoLinesAndBitmap.ImageView.Width=32dip";
mostCurrent._leftlist.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="leftlist.TwoLinesAndBitmap.ItemHeight=50dip";
mostCurrent._leftlist.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="la1.TextSize=15";
_la1.setTextSize((float) (15));
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="la2.TextSize=11";
_la2.setTextSize((float) (11));
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="la1.Typeface=rfont";
_la1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=1245196;
 //BA.debugLineNum = 1245196;BA.debugLine="la2.Typeface=rfont";
_la2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=1245197;
 //BA.debugLineNum = 1245197;BA.debugLine="la1.TextColor=mcl.md_black_1000";
_la1.setTextColor(mostCurrent._mcl.getmd_black_1000());
RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="la2.TextColor=Colors.ARGB(180,255,255,255)";
_la2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (180),(int) (255),(int) (255),(int) (255)));
RDebugUtils.currentLine=1245199;
 //BA.debugLineNum = 1245199;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Height=32dip";
mostCurrent._lv1.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
RDebugUtils.currentLine=1245200;
 //BA.debugLineNum = 1245200;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Width=32dip";
mostCurrent._lv1.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="lv1.TwoLinesAndBitmap.ItemHeight=55dip";
mostCurrent._lv1.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=1245202;
 //BA.debugLineNum = 1245202;BA.debugLine="leftlist.AddTwoLinesAndBitmap2(\"Einstellungen\",\"S";
mostCurrent._leftlist.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("Einstellungen"),BA.ObjectToCharSequence("Service,widget einstellungen etc.."),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_settings_applications_white_36dp.png").getObject()),(Object)(0));
RDebugUtils.currentLine=1245203;
 //BA.debugLineNum = 1245203;BA.debugLine="leftlist.AddTwoLinesAndBitmap2(\"Feedback\",\"Sende";
mostCurrent._leftlist.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("Feedback"),BA.ObjectToCharSequence("Sende uns Vorschläge"),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_sms_failed_white_36dp.png").getObject()),(Object)(1));
RDebugUtils.currentLine=1245204;
 //BA.debugLineNum = 1245204;BA.debugLine="leftlist.AddTwoLinesAndBitmap2(\"About\",\"alles übe";
mostCurrent._leftlist.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("About"),BA.ObjectToCharSequence("alles über Scleaner"),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_extension_white_36dp.png").getObject()),(Object)(2));
RDebugUtils.currentLine=1245205;
 //BA.debugLineNum = 1245205;BA.debugLine="Return";
if (true) return "";
RDebugUtils.currentLine=1245206;
 //BA.debugLineNum = 1245206;BA.debugLine="End Sub";
return "";
}
public static String  _p_button() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "p_button"))
	return (String) Debug.delegate(mostCurrent.activityBA, "p_button", null);
MLfiles.Fileslib.MLfiles _ml = null;
long _used1 = 0L;
long _used2 = 0L;
long _summe1 = 0L;
int _total = 0;
int _summ2 = 0;
int _div = 0;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub p_button";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim ml As MLfiles";
_ml = new MLfiles.Fileslib.MLfiles();
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="pb1.BottomTextSize=18";
mostCurrent._pb1.setBottomTextSize((float) (18));
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="pb2.BottomTextSize=18";
mostCurrent._pb2.setBottomTextSize((float) (18));
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="pb1.TextSize=40";
mostCurrent._pb1.setTextSize((float) (40));
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="pb2.TextSize=40";
mostCurrent._pb2.setTextSize((float) (40));
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="pb1.TextColor=Colors.ARGB(150,255,255,255)";
mostCurrent._pb1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="pb2.TextColor=Colors.ARGB(150,255,255,255)";
mostCurrent._pb2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (150),(int) (255),(int) (255),(int) (255)));
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="pb2.SuffixText=\"% SD\"";
mostCurrent._pb2.setSuffixText("% SD");
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="pb1.SuffixText=\"% RAM\"";
mostCurrent._pb1.setSuffixText("% RAM");
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="pb2.SuffixTextSize=15";
mostCurrent._pb2.setSuffixTextSize((float) (15));
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="pb1.SuffixTextSize=15";
mostCurrent._pb1.setSuffixTextSize((float) (15));
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="Dim used1,used2,summe1 As Long";
_used1 = 0L;
_used2 = 0L;
_summe1 = 0L;
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="used1=os.TotalExternalMemorySize-os.AvailableExte";
_used1 = (long) (_os.getTotalExternalMemorySize()-_os.getAvailableExternalMemorySize());
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="used2=os.TotalInternalMemorySize - os.AvailableIn";
_used2 = (long) (_os.getTotalInternalMemorySize()-_os.getAvailableInternalMemorySize());
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="summe1=used1+used2";
_summe1 = (long) (_used1+_used2);
RDebugUtils.currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="Dim total,summ2,div As Int";
_total = 0;
_summ2 = 0;
_div = 0;
RDebugUtils.currentLine=720913;
 //BA.debugLineNum = 720913;BA.debugLine="total=os.TotalExternalMemorySize+os.TotalInternal";
_total = (int) (_os.getTotalExternalMemorySize()+_os.getTotalInternalMemorySize());
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="div=os.AvailableExternalMemorySize+os.AvailableIn";
_div = (int) (_os.getAvailableExternalMemorySize()+_os.getAvailableInternalMemorySize());
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="summ2=total-div";
_summ2 = (int) (_total-_div);
RDebugUtils.currentLine=720916;
 //BA.debugLineNum = 720916;BA.debugLine="pb2.BottomText=FormatFileSize(summe1)&\"/\"&FormatF";
mostCurrent._pb2.setBottomText(_formatfilesize((float) (_summe1))+"/"+_formatfilesize((float) (_os.getTotalExternalMemorySize()+_os.getTotalInternalMemorySize())));
RDebugUtils.currentLine=720917;
 //BA.debugLineNum = 720917;BA.debugLine="pb2.Max=os.TotalExternalMemorySize+os.TotalIntern";
mostCurrent._pb2.setMax((int) (_os.getTotalExternalMemorySize()+_os.getTotalInternalMemorySize()));
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="pb2.Progress=100-((summ2)/(total)) * 100";
mostCurrent._pb2.setProgress((int) (100-((_summ2)/(double)(_total))*100));
RDebugUtils.currentLine=720919;
 //BA.debugLineNum = 720919;BA.debugLine="pb1.FinishedStrokeColor=mcl.md_amber_500";
mostCurrent._pb1.setFinishedStrokeColor(mostCurrent._mcl.getmd_amber_500());
RDebugUtils.currentLine=720920;
 //BA.debugLineNum = 720920;BA.debugLine="pb2.FinishedStrokeColor=mcl.md_amber_500";
mostCurrent._pb2.setFinishedStrokeColor(mostCurrent._mcl.getmd_amber_500());
RDebugUtils.currentLine=720921;
 //BA.debugLineNum = 720921;BA.debugLine="pb1.UnfinishedStrokeColor=mcl.md_grey_400";
mostCurrent._pb1.setUnfinishedStrokeColor(mostCurrent._mcl.getmd_grey_400());
RDebugUtils.currentLine=720922;
 //BA.debugLineNum = 720922;BA.debugLine="pb2.UnfinishedStrokeColor=mcl.md_grey_400";
mostCurrent._pb2.setUnfinishedStrokeColor(mostCurrent._mcl.getmd_grey_400());
RDebugUtils.currentLine=720923;
 //BA.debugLineNum = 720923;BA.debugLine="pb1.StrokeWidth=8dip";
mostCurrent._pb1.setStrokeWidth((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8))));
RDebugUtils.currentLine=720924;
 //BA.debugLineNum = 720924;BA.debugLine="pb2.StrokeWidth=8dip";
mostCurrent._pb2.setStrokeWidth((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8))));
RDebugUtils.currentLine=720925;
 //BA.debugLineNum = 720925;BA.debugLine="pb1.ArcAngle=220";
mostCurrent._pb1.setArcAngle((float) (220));
RDebugUtils.currentLine=720926;
 //BA.debugLineNum = 720926;BA.debugLine="pb2.ArcAngle=220";
mostCurrent._pb2.setArcAngle((float) (220));
RDebugUtils.currentLine=720927;
 //BA.debugLineNum = 720927;BA.debugLine="End Sub";
return "";
}
public static String  _activity_createmenu(de.amberhome.objects.appcompat.ACMenuWrapper _menu) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_createmenu"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_createmenu", new Object[] {_menu});
anywheresoftware.b4a.objects.drawable.BitmapDrawable _eim = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _fim1 = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _climg1 = null;
de.amberhome.objects.appcompat.ACMenuItemWrapper _item = null;
de.amberhome.objects.appcompat.ACMenuItemWrapper _item2 = null;
de.amberhome.objects.appcompat.ACMenuItemWrapper _item3 = null;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Activity_CreateMenu(menu As ACMenu)";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Dim eim As BitmapDrawable";
_eim = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="eim.Initialize(LoadBitmap(File.DirAssets,\"ic_exit";
_eim.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_exit_to_app_white_48dp.png").getObject()));
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="Dim fim1,climg1 As BitmapDrawable";
_fim1 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_climg1 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="fim1.Initialize(LoadBitmap(File.DirAssets,\"ic_set";
_fim1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_settings_applications_white_36dp.png").getObject()));
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="climg1.Initialize(LoadBitmap(File.DirAssets,\"ic_a";
_climg1.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_apps_white_36dp.png").getObject()));
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="menu.Clear";
_menu.Clear();
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="Dim item,item2,item3 As ACMenuItem";
_item = new de.amberhome.objects.appcompat.ACMenuItemWrapper();
_item2 = new de.amberhome.objects.appcompat.ACMenuItemWrapper();
_item3 = new de.amberhome.objects.appcompat.ACMenuItemWrapper();
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="item3=toolbar.Menu.Add2(0, 0, \"Menu\", climg1)";
_item3 = mostCurrent._toolbar.getMenu().Add2((int) (0),(int) (0),BA.ObjectToCharSequence("Menu"),(android.graphics.drawable.Drawable)(_climg1.getObject()));
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="item=toolbar.Menu.Add2(1, 1, \"SMenu\", fim1)";
_item = mostCurrent._toolbar.getMenu().Add2((int) (1),(int) (1),BA.ObjectToCharSequence("SMenu"),(android.graphics.drawable.Drawable)(_fim1.getObject()));
RDebugUtils.currentLine=327690;
 //BA.debugLineNum = 327690;BA.debugLine="item2=toolbar.Menu.Add2(2, 2, \"Exit\", eim)";
_item2 = mostCurrent._toolbar.getMenu().Add2((int) (2),(int) (2),BA.ObjectToCharSequence("Exit"),(android.graphics.drawable.Drawable)(_eim.getObject()));
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="item.ShowAsAction = item.SHOW_AS_ACTION_ALWAYS";
_item.setShowAsAction(_item.SHOW_AS_ACTION_ALWAYS);
RDebugUtils.currentLine=327692;
 //BA.debugLineNum = 327692;BA.debugLine="item2.ShowAsAction = item2.SHOW_AS_ACTION_ALWAYS";
_item2.setShowAsAction(_item2.SHOW_AS_ACTION_ALWAYS);
RDebugUtils.currentLine=327693;
 //BA.debugLineNum = 327693;BA.debugLine="item3.ShowAsAction = item3.SHOW_AS_ACTION_ALWAYS";
_item3.setShowAsAction(_item3.SHOW_AS_ACTION_ALWAYS);
RDebugUtils.currentLine=327694;
 //BA.debugLineNum = 327694;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="xOSStats.StartStats";
mostCurrent._xosstats._startstats();
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="If pn.Visible=True Then";
if (mostCurrent._pn.getVisible()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="pn.SetVisibleAnimated(300,False)";
mostCurrent._pn.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="End Sub";
return "";
}
public static String  _closedia_buttonpressed(de.amberhome.materialdialogs.MaterialDialogWrapper _dialog,String _action) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closedia_buttonpressed"))
	return (String) Debug.delegate(mostCurrent.activityBA, "closedia_buttonpressed", new Object[] {_dialog,_action});
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub closedia_ButtonPressed (Dialog As MaterialDial";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_dialog.ACTION_POSITIVE,_dialog.ACTION_NEGATIVE,_dialog.ACTION_NEUTRAL)) {
case 0: {
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
RDebugUtils.currentLine=3014665;
 //BA.debugLineNum = 3014665;BA.debugLine="End Sub";
return "";
}
public static String  _dexa_buttonpressed(de.amberhome.materialdialogs.MaterialDialogWrapper _dialog,String _action) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dexa_buttonpressed"))
	return (String) Debug.delegate(mostCurrent.activityBA, "dexa_buttonpressed", new Object[] {_dialog,_action});
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub dexa_ButtonPressed (Dialog As MaterialDialog,";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_dialog.ACTION_POSITIVE,_dialog.ACTION_NEGATIVE,_dialog.ACTION_NEUTRAL)) {
case 0: {
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="dbase.DeleteAll";
mostCurrent._dbase._deleteall(null);
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="ToastMessageShow(\"counter reset: erfolgreich\",F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("counter reset: erfolgreich"),anywheresoftware.b4a.keywords.Common.False);
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="End Sub";
return "";
}
public static String  _dialog3_buttonpressed(de.amberhome.materialdialogs.MaterialDialogWrapper _dialog,String _action) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dialog3_buttonpressed"))
	return (String) Debug.delegate(mostCurrent.activityBA, "dialog3_buttonpressed", new Object[] {_dialog,_action});
com.rootsoft.customtoast.CustomToast _cts = null;
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub Dialog3_ButtonPressed (Dialog As MaterialDialo";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_dialog.ACTION_POSITIVE,_dialog.ACTION_NEGATIVE,_dialog.ACTION_NEUTRAL)) {
case 0: {
 break; }
case 1: {
 break; }
case 2: {
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="Dim cts As CustomToast";
_cts = new com.rootsoft.customtoast.CustomToast();
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="cts.Initialize";
_cts.Initialize(processBA);
RDebugUtils.currentLine=2883593;
 //BA.debugLineNum = 2883593;BA.debugLine="cts.ShowBitmap(\"© 2017\",3,0,0,Gravity.BOTTOM,Lo";
_cts.ShowBitmap(BA.ObjectToCharSequence("© 2017"),(int) (3),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.Gravity.BOTTOM,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"smm_small_logo.png").getObject()));
 break; }
}
;
RDebugUtils.currentLine=2883595;
 //BA.debugLineNum = 2883595;BA.debugLine="End Sub";
return "";
}
public static String  _dp_clean() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dp_clean"))
	return (String) Debug.delegate(mostCurrent.activityBA, "dp_clean", null);
anywheresoftware.b4a.objects.LabelWrapper _lu = null;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub dp_clean";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Dim lu As Label";
_lu = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="lu.Initialize(\"\")";
_lu.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="lu.Typeface=rfont";
_lu.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="schredder(False)";
_schredder(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="lu.Text=\"Start\"";
_lu.setText(BA.ObjectToCharSequence("Start"));
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="prb.Text=lu.Text";
mostCurrent._prb.setText(BA.ObjectToCharSequence(_lu.getText()));
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="End Sub";
return "";
}
public static String  _schredder(boolean _f) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "schredder"))
	return (String) Debug.delegate(mostCurrent.activityBA, "schredder", new Object[] {_f});
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub schredder (f As Boolean)";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="If f=True Then";
if (_f==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="prb.SetVisibleAnimated(200,False)";
mostCurrent._prb.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="ldim.SetVisibleAnimated(200,True)";
mostCurrent._ldim.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="pdim.SetVisibleAnimated(200,True)";
mostCurrent._pdim.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="sr.SetVisibleAnimated(200,True)";
mostCurrent._sr.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="im_ad";
_im_ad();
 }else {
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="If f=False Then";
if (_f==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="prb.SetVisibleAnimated(200,True)";
mostCurrent._prb.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900554;
 //BA.debugLineNum = 1900554;BA.debugLine="ldim.SetVisibleAnimated(300,False)";
mostCurrent._ldim.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1900555;
 //BA.debugLineNum = 1900555;BA.debugLine="pdim.SetVisibleAnimated(300,False)";
mostCurrent._pdim.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1900556;
 //BA.debugLineNum = 1900556;BA.debugLine="sr.SetVisibleAnimated(300,False)";
mostCurrent._sr.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.False);
 };
 };
RDebugUtils.currentLine=1900560;
 //BA.debugLineNum = 1900560;BA.debugLine="End Sub";
return "";
}
public static String  _dp_clear() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dp_clear"))
	return (String) Debug.delegate(mostCurrent.activityBA, "dp_clear", null);
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub dp_clear";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="ready.Visible=False";
mostCurrent._ready.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="xOSStats.StartStats";
mostCurrent._xosstats._startstats();
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="End Sub";
return "";
}
public static String  _dp_off() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dp_off"))
	return (String) Debug.delegate(mostCurrent.activityBA, "dp_off", null);
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub dp_off";
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="pn.SetVisibleAnimated(450,False)";
mostCurrent._pn.SetVisibleAnimated((int) (450),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="t1_start";
_t1_start();
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="End Sub";
return "";
}
public static String  _t1_start() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "t1_start"))
	return (String) Debug.delegate(mostCurrent.activityBA, "t1_start", null);
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub t1_start";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="t1.Enabled=True";
_t1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="CallSubDelayed(Starter,\"clean_start\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._starter.getObject()),"clean_start");
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="r_schredder";
_r_schredder();
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="End Sub";
return "";
}
public static String  _dp_start() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dp_start"))
	return (String) Debug.delegate(mostCurrent.activityBA, "dp_start", null);
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub dp_start";
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _exit_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "exit_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "exit_click", null);
de.amberhome.materialdialogs.MaterialDialogWrapper _infodia = null;
de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _builder = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _inf = null;
anywheresoftware.b4a.objects.LabelWrapper _l1 = null;
anywheresoftware.b4a.objects.LabelWrapper _l2 = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub exit_click";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Dim infodia As MaterialDialog";
_infodia = new de.amberhome.materialdialogs.MaterialDialogWrapper();
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Dim Builder As MaterialDialogBuilder";
_builder = new de.amberhome.materialdialogs.MaterialDialogBuilderWrapper();
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="Dim inf As BitmapDrawable";
_inf = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="inf.Initialize(LoadBitmap(File.DirAssets,\"ic_sms_";
_inf.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_sms_failed_white_36dp.png").getObject()));
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="Dim l1,l2 As Label";
_l1 = new anywheresoftware.b4a.objects.LabelWrapper();
_l2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2949127;
 //BA.debugLineNum = 2949127;BA.debugLine="pnl.Initialize(\"pnl\")";
_pnl.Initialize(mostCurrent.activityBA,"pnl");
RDebugUtils.currentLine=2949128;
 //BA.debugLineNum = 2949128;BA.debugLine="l1.Initialize(\"\")";
_l1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2949129;
 //BA.debugLineNum = 2949129;BA.debugLine="l2.Initialize(\"\")";
_l2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2949130;
 //BA.debugLineNum = 2949130;BA.debugLine="l2.TextSize=16";
_l2.setTextSize((float) (16));
RDebugUtils.currentLine=2949131;
 //BA.debugLineNum = 2949131;BA.debugLine="l1.TextSize=15";
_l1.setTextSize((float) (15));
RDebugUtils.currentLine=2949132;
 //BA.debugLineNum = 2949132;BA.debugLine="l1.textcolor=mcl.md_white_1000";
_l1.setTextColor(mostCurrent._mcl.getmd_white_1000());
RDebugUtils.currentLine=2949133;
 //BA.debugLineNum = 2949133;BA.debugLine="l1.Text=\"Scleaner schließen? *Der Service, wenn n";
_l1.setText(BA.ObjectToCharSequence("Scleaner schließen? *Der Service, wenn nicht anders eingestellt, wird im Hintergrund weiter ausgeführt!"));
RDebugUtils.currentLine=2949134;
 //BA.debugLineNum = 2949134;BA.debugLine="l2.textcolor=mcl.md_white_1000";
_l2.setTextColor(mostCurrent._mcl.getmd_white_1000());
RDebugUtils.currentLine=2949135;
 //BA.debugLineNum = 2949135;BA.debugLine="l1.Gravity=Gravity.TOP";
_l1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
RDebugUtils.currentLine=2949136;
 //BA.debugLineNum = 2949136;BA.debugLine="l1.Typeface=rfont";
_l1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=2949137;
 //BA.debugLineNum = 2949137;BA.debugLine="l2.Typeface=rfont";
_l2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=2949138;
 //BA.debugLineNum = 2949138;BA.debugLine="Builder.Initialize(\"closedia\")";
_builder.Initialize(mostCurrent.activityBA,"closedia");
RDebugUtils.currentLine=2949139;
 //BA.debugLineNum = 2949139;BA.debugLine="Builder.Title(\"Beenden?\").TitleColor(mcl.md_black";
_builder.Title(BA.ObjectToCharSequence("Beenden?")).TitleColor(mostCurrent._mcl.getmd_black_1000()).Icon((android.graphics.drawable.Drawable)(_inf.getObject())).LimitIconToDefaultSize().Theme(_builder.THEME_DARK).Content(BA.ObjectToCharSequence(_l1.getText())).ContentLineSpacing((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))).Cancelable(anywheresoftware.b4a.keywords.Common.True).NeutralText(BA.ObjectToCharSequence("Abbrechen")).Typeface((android.graphics.Typeface)(_rfont.getObject()),(android.graphics.Typeface)(_rfont.getObject())).NeutralColor(mostCurrent._mcl.getmd_grey_400()).PositiveText(BA.ObjectToCharSequence("Ja bitte")).PositiveColor(mostCurrent._mcl.getmd_amber_300()).ContentGravity(_builder.GRAVITY_START);
RDebugUtils.currentLine=2949140;
 //BA.debugLineNum = 2949140;BA.debugLine="infodia=Builder.Show";
_infodia = _builder.Show();
RDebugUtils.currentLine=2949141;
 //BA.debugLineNum = 2949141;BA.debugLine="infodia.Show";
_infodia.Show();
RDebugUtils.currentLine=2949142;
 //BA.debugLineNum = 2949142;BA.debugLine="End Sub";
return "";
}
public static String  _fexa_buttonpressed(de.amberhome.materialdialogs.MaterialDialogWrapper _dialog,String _action) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fexa_buttonpressed"))
	return (String) Debug.delegate(mostCurrent.activityBA, "fexa_buttonpressed", new Object[] {_dialog,_action});
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub fexa_ButtonPressed (Dialog As MaterialDialog,";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_dialog.ACTION_POSITIVE,_dialog.ACTION_NEGATIVE,_dialog.ACTION_NEUTRAL)) {
case 0: {
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="alist.DeleteAll";
mostCurrent._alist._deleteall(null);
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="lv1.Clear";
mostCurrent._lv1.Clear();
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="Activity.Invalidate";
mostCurrent._activity.Invalidate();
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="End Sub";
return "";
}
public static String  _formatfilesize(float _bytes) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "formatfilesize"))
	return (String) Debug.delegate(mostCurrent.activityBA, "formatfilesize", new Object[] {_bytes});
String[] _unit = null;
double _po = 0;
double _si = 0;
int _i = 0;
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub FormatFileSize(Bytes As Float) As String";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Private Unit() As String = Array As String(\" Byte";
_unit = new String[]{" Byte"," KB"," MB"," GB"," TB"," PB"," EB"," ZB"," YB"};
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="If Bytes = 0 Then";
if (_bytes==0) { 
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Return \"0 Bytes\"";
if (true) return "0 Bytes";
 }else {
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="Private Po, Si As Double";
_po = 0;
_si = 0;
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="Private I As Int";
_i = 0;
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="Bytes = Abs(Bytes)";
_bytes = (float) (anywheresoftware.b4a.keywords.Common.Abs(_bytes));
RDebugUtils.currentLine=2555912;
 //BA.debugLineNum = 2555912;BA.debugLine="I = Floor(Logarithm(Bytes, 1024))";
_i = (int) (anywheresoftware.b4a.keywords.Common.Floor(anywheresoftware.b4a.keywords.Common.Logarithm(_bytes,1024)));
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="Po = Power(1024, I)";
_po = anywheresoftware.b4a.keywords.Common.Power(1024,_i);
RDebugUtils.currentLine=2555914;
 //BA.debugLineNum = 2555914;BA.debugLine="Si = Bytes / Po";
_si = _bytes/(double)_po;
RDebugUtils.currentLine=2555915;
 //BA.debugLineNum = 2555915;BA.debugLine="Return NumberFormat(Si, 1, 2) & Unit(I)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_si,(int) (1),(int) (2))+_unit[_i];
 };
RDebugUtils.currentLine=2555917;
 //BA.debugLineNum = 2555917;BA.debugLine="End Sub";
return "";
}
public static int  _getsdk() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getsdk"))
	return (Integer) Debug.delegate(mostCurrent.activityBA, "getsdk", null);
anywheresoftware.b4a.phone.Phone _p = null;
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub GetSDK() As Int";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Return p.SdkVersion";
if (true) return _p.getSdkVersion();
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="End Sub";
return 0;
}
public static String  _getsdkversion() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getsdkversion"))
	return (String) Debug.delegate(mostCurrent.activityBA, "getsdkversion", null);
anywheresoftware.b4a.objects.collections.Map _versions = null;
anywheresoftware.b4a.phone.Phone _p = null;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub GetSDKversion() As String";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Dim versions As Map";
_versions = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="versions.Initialize";
_versions.Initialize();
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="versions.Put(3,\"1.5\")";
_versions.Put((Object)(3),(Object)("1.5"));
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="versions.Put(4,\"1.6\")";
_versions.Put((Object)(4),(Object)("1.6"));
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="versions.Put(7,\"2.1\")";
_versions.Put((Object)(7),(Object)("2.1"));
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="versions.Put(8,\"2.2\")";
_versions.Put((Object)(8),(Object)("2.2"));
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="versions.Put(10,\"2.3.3\")";
_versions.Put((Object)(10),(Object)("2.3.3"));
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="versions.Put(11,\"3.0\")";
_versions.Put((Object)(11),(Object)("3.0"));
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="versions.Put(12,\"3.1\")";
_versions.Put((Object)(12),(Object)("3.1"));
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="versions.Put(13,\"3.2\")";
_versions.Put((Object)(13),(Object)("3.2"));
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="versions.Put(14,\"4.0\")";
_versions.Put((Object)(14),(Object)("4.0"));
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="versions.Put(15,\"4.0.3\")";
_versions.Put((Object)(15),(Object)("4.0.3"));
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="versions.Put(16,\"4.1.2\")";
_versions.Put((Object)(16),(Object)("4.1.2"));
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="versions.Put(17,\"4.2.2\")";
_versions.Put((Object)(17),(Object)("4.2.2"));
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="versions.Put(18,\"4.3\")";
_versions.Put((Object)(18),(Object)("4.3"));
RDebugUtils.currentLine=851984;
 //BA.debugLineNum = 851984;BA.debugLine="versions.Put(19,\"4.4.2\")";
_versions.Put((Object)(19),(Object)("4.4.2"));
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=851986;
 //BA.debugLineNum = 851986;BA.debugLine="Return versions.Get(p.SdkVersion)";
if (true) return BA.ObjectToString(_versions.Get((Object)(_p.getSdkVersion())));
RDebugUtils.currentLine=851987;
 //BA.debugLineNum = 851987;BA.debugLine="End Sub";
return "";
}
public static String  _hexa_buttonpressed(de.amberhome.materialdialogs.MaterialDialogWrapper _dialog,String _action) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "hexa_buttonpressed"))
	return (String) Debug.delegate(mostCurrent.activityBA, "hexa_buttonpressed", new Object[] {_dialog,_action});
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub hexa_ButtonPressed (Dialog As MaterialDialog,";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_dialog.ACTION_POSITIVE,_dialog.ACTION_NEGATIVE,_dialog.ACTION_NEUTRAL)) {
case 0: {
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
RDebugUtils.currentLine=1769481;
 //BA.debugLineNum = 1769481;BA.debugLine="End Sub";
return "";
}
public static String  _im_ad() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "im_ad"))
	return (String) Debug.delegate(mostCurrent.activityBA, "im_ad", null);
anywheresoftware.b4a.objects.drawable.BitmapDrawable _icon = null;
anywheresoftware.b4a.objects.LabelWrapper _la1 = null;
anywheresoftware.b4a.objects.LabelWrapper _la2 = null;
String _d = "";
anywheresoftware.b4a.objects.LabelWrapper _lt = null;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub im_ad";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Dim icon As BitmapDrawable";
_icon = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="Dim la1,la2 As Label";
_la1 = new anywheresoftware.b4a.objects.LabelWrapper();
_la2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="la2.Initialize(\"la2\")";
_la2.Initialize(mostCurrent.activityBA,"la2");
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="la1.Initialize(\"la1\")";
_la1.Initialize(mostCurrent.activityBA,"la1");
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="la1=lolist.TwoLinesAndBitmap.Label";
_la1 = mostCurrent._lolist.getTwoLinesAndBitmap().Label;
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="la2=lolist.TwoLinesAndBitmap.SecondLabel";
_la2 = mostCurrent._lolist.getTwoLinesAndBitmap().SecondLabel;
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="la1.TextSize=15";
_la1.setTextSize((float) (15));
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="la2.TextSize=13";
_la2.setTextSize((float) (13));
RDebugUtils.currentLine=1966089;
 //BA.debugLineNum = 1966089;BA.debugLine="la1.Typeface=rfont";
_la1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="la2.Typeface=rfont";
_la2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=1966091;
 //BA.debugLineNum = 1966091;BA.debugLine="la1.TextColor=mcl.md_white_1000";
_la1.setTextColor(mostCurrent._mcl.getmd_white_1000());
RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="la2.TextColor=mcl.md_amber_500";
_la2.setTextColor(mostCurrent._mcl.getmd_amber_500());
RDebugUtils.currentLine=1966093;
 //BA.debugLineNum = 1966093;BA.debugLine="lolist.TwoLinesAndBitmap.ImageView.Height=32dip";
mostCurrent._lolist.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
RDebugUtils.currentLine=1966094;
 //BA.debugLineNum = 1966094;BA.debugLine="lolist.TwoLinesAndBitmap.ImageView.Width=32dip";
mostCurrent._lolist.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
RDebugUtils.currentLine=1966095;
 //BA.debugLineNum = 1966095;BA.debugLine="lolist.TwoLinesAndBitmap.ItemHeight=55dip";
mostCurrent._lolist.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (55)));
RDebugUtils.currentLine=1966096;
 //BA.debugLineNum = 1966096;BA.debugLine="lolist.Clear";
mostCurrent._lolist.Clear();
RDebugUtils.currentLine=1966097;
 //BA.debugLineNum = 1966097;BA.debugLine="For Each d As String In alist.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group17 = mostCurrent._alist._listkeys(null);
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_d = BA.ObjectToString(group17.Get(index17));
RDebugUtils.currentLine=1966098;
 //BA.debugLineNum = 1966098;BA.debugLine="icon=pack.GetApplicationIcon(d)";
_icon.setObject((android.graphics.drawable.BitmapDrawable)(mostCurrent._pack.GetApplicationIcon(_d)));
RDebugUtils.currentLine=1966099;
 //BA.debugLineNum = 1966099;BA.debugLine="lolist.AddTwoLinesAndBitmap(pack.GetApplicationL";
mostCurrent._lolist.AddTwoLinesAndBitmap(BA.ObjectToCharSequence(mostCurrent._pack.GetApplicationLabel(_d)),BA.ObjectToCharSequence(_formatfilesize((float)(BA.ObjectToNumber(mostCurrent._alist._get(null,_d))))),_icon.getBitmap());
 }
};
RDebugUtils.currentLine=1966101;
 //BA.debugLineNum = 1966101;BA.debugLine="Dim lt As Label";
_lt = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1966102;
 //BA.debugLineNum = 1966102;BA.debugLine="lt.Initialize(\"\")";
_lt.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1966103;
 //BA.debugLineNum = 1966103;BA.debugLine="lt.Text=\"löche nicht mehr benötigte Daten\"";
_lt.setText(BA.ObjectToCharSequence("löche nicht mehr benötigte Daten"));
RDebugUtils.currentLine=1966104;
 //BA.debugLineNum = 1966104;BA.debugLine="lt.Typeface=rfont";
_lt.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=1966105;
 //BA.debugLineNum = 1966105;BA.debugLine="lt.TextSize=14";
_lt.setTextSize((float) (14));
RDebugUtils.currentLine=1966106;
 //BA.debugLineNum = 1966106;BA.debugLine="lt.TextColor=mcl.md_white_1000";
_lt.setTextColor(mostCurrent._mcl.getmd_white_1000());
RDebugUtils.currentLine=1966108;
 //BA.debugLineNum = 1966108;BA.debugLine="End Sub";
return "";
}
public static String  _l_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "l_sub"))
	return (String) Debug.delegate(mostCurrent.activityBA, "l_sub", null);
int _sum = 0;
String _na = "";
String _g = "";
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub l_sub";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Dim sum As Int=0";
_sum = (int) (0);
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Dim na As String";
_na = "";
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="For Each g As String In alist.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group3 = mostCurrent._alist._listkeys(null);
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_g = BA.ObjectToString(group3.Get(index3));
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="Log(FormatFileSize(alist.Get(g)))";
anywheresoftware.b4a.keywords.Common.Log(_formatfilesize((float)(BA.ObjectToNumber(mostCurrent._alist._get(null,_g)))));
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="sum=sum+alist.Get(g)";
_sum = (int) (_sum+(double)(BA.ObjectToNumber(mostCurrent._alist._get(null,_g))));
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="na=g";
_na = _g;
 }
};
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="dbase.Put(sum,na)";
mostCurrent._dbase._put(null,BA.NumberToString(_sum),(Object)(_na));
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="If dbase.ContainsKey(sum) Then";
if (mostCurrent._dbase._containskey(null,BA.NumberToString(_sum))) { 
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="tota_sub";
_tota_sub();
 };
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="lv1.Clear";
mostCurrent._lv1.Clear();
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="lv1.AddTwoLinesAndBitmap2(FormatFileSize(sum)&\" b";
mostCurrent._lv1.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence(_formatfilesize((float) (_sum))+" bereinigt"),BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._alist._listkeys(null).getSize())+" App(s) optimiert.."),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_sms_failed_white_36dp.png").getObject()),(Object)(2));
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="End Sub";
return "";
}
public static String  _tota_sub() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tota_sub"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tota_sub", null);
anywheresoftware.b4a.objects.LabelWrapper _stext = null;
int _sum = 0;
String _s = "";
anywheresoftware.b4a.objects.CSBuilder _cs = null;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub tota_sub";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Dim Stext As Label";
_stext = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Stext.Initialize(\"\")";
_stext.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="Stext.TextColor=mcl.md_amber_700";
_stext.setTextColor(mostCurrent._mcl.getmd_amber_700());
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="Stext.TextSize=30";
_stext.setTextSize((float) (30));
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="Dim sum As Int=0";
_sum = (int) (0);
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="For Each s As String In dbase.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group6 = mostCurrent._dbase._listkeys(null);
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_s = BA.ObjectToString(group6.Get(index6));
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="sum=sum+s";
_sum = (int) (_sum+(double)(Double.parseDouble(_s)));
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="Log(FormatFileSize(sum))";
anywheresoftware.b4a.keywords.Common.Log(_formatfilesize((float) (_sum)));
 }
};
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
RDebugUtils.currentLine=1048587;
 //BA.debugLineNum = 1048587;BA.debugLine="Stext.text=FormatFileSize(sum)";
_stext.setText(BA.ObjectToCharSequence(_formatfilesize((float) (_sum))));
RDebugUtils.currentLine=1048588;
 //BA.debugLineNum = 1048588;BA.debugLine="cs.Initialize.Color(Colors.ARGB(190,255,255,255))";
_cs.Initialize().Color(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (190),(int) (255),(int) (255),(int) (255))).Append(BA.ObjectToCharSequence("Total "+anywheresoftware.b4a.keywords.Common.CRLF));
RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="cs.Bold.Color(mcl.md_amber_700).Append(Stext.Text";
_cs.Bold().Color(mostCurrent._mcl.getmd_amber_700()).Append(BA.ObjectToCharSequence(_stext.getText()+anywheresoftware.b4a.keywords.Common.CRLF)).Pop().PopAll();
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="tota.SetVisibleAnimated(300,True)";
mostCurrent._tota.SetVisibleAnimated((int) (300),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1048591;
 //BA.debugLineNum = 1048591;BA.debugLine="tota.Text=cs";
mostCurrent._tota.setText(BA.ObjectToCharSequence(_cs.getObject()));
RDebugUtils.currentLine=1048592;
 //BA.debugLineNum = 1048592;BA.debugLine="End Sub";
return "";
}
public static String  _leftlist_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "leftlist_itemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "leftlist_itemclick", new Object[] {_position,_value});
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub leftlist_ItemClick (Position As Int, Value As";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)(0),(Object)(1),(Object)(2))) {
case 0: {
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="set_click";
_set_click();
 break; }
case 1: {
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="sm.HideMenus";
mostCurrent._sm.HideMenus();
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="StartActivity(supp)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._supp.getObject()));
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
mostCurrent._animator._setanimati(mostCurrent.activityBA,"extra_in","extra_out");
 break; }
case 2: {
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="sm.HideMenus";
mostCurrent._sm.HideMenus();
RDebugUtils.currentLine=1310732;
 //BA.debugLineNum = 1310732;BA.debugLine="about_click";
_about_click();
 break; }
}
;
RDebugUtils.currentLine=1310734;
 //BA.debugLineNum = 1310734;BA.debugLine="End Sub";
return "";
}
public static String  _set_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "set_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "set_click", null);
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub set_click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="sm.HideMenus";
mostCurrent._sm.HideMenus();
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="StartActivity(option)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._option.getObject()));
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
mostCurrent._animator._setanimati(mostCurrent.activityBA,"extra_in","extra_out");
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="End Sub";
return "";
}
public static String  _lo_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lo_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "lo_tick", null);
int _sum = 0;
String _g = "";
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub lo_tick";
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="lolist.Clear";
mostCurrent._lolist.Clear();
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="pdim.SetElevationAnimated(300,10dip)";
mostCurrent._pdim.SetElevationAnimated((int) (300),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="sr.Visible=False";
mostCurrent._sr.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="Dim sum As Int=0";
_sum = (int) (0);
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="For Each g As String In alist.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group5 = mostCurrent._alist._listkeys(null);
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_g = BA.ObjectToString(group5.Get(index5));
RDebugUtils.currentLine=1572871;
 //BA.debugLineNum = 1572871;BA.debugLine="Log(FormatFileSize(alist.Get(g)))";
anywheresoftware.b4a.keywords.Common.Log(_formatfilesize((float)(BA.ObjectToNumber(mostCurrent._alist._get(null,_g)))));
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="sum=sum+alist.Get(g)";
_sum = (int) (_sum+(double)(BA.ObjectToNumber(mostCurrent._alist._get(null,_g))));
 }
};
RDebugUtils.currentLine=1572874;
 //BA.debugLineNum = 1572874;BA.debugLine="lolist.AddTwoLinesAndBitmap2(alist.ListKeys.Size&";
mostCurrent._lolist.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._alist._listkeys(null).getSize())+" App(s) gesäubert:"),BA.ObjectToCharSequence("mit: "+_formatfilesize((float) (_sum))),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_sms_failed_white_36dp.png").getObject()),(Object)(0));
RDebugUtils.currentLine=1572875;
 //BA.debugLineNum = 1572875;BA.debugLine="End Sub";
return "";
}
public static String  _log_list() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "log_list"))
	return (String) Debug.delegate(mostCurrent.activityBA, "log_list", null);
anywheresoftware.b4a.objects.LabelWrapper _ll = null;
anywheresoftware.b4a.objects.LabelWrapper _lk = null;
de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _builder = null;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub log_list";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="pn.SetVisibleAnimated(450,False)";
mostCurrent._pn.SetVisibleAnimated((int) (450),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Dim ll,lk As Label";
_ll = new anywheresoftware.b4a.objects.LabelWrapper();
_lk = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="ll.Initialize(\"\")";
_ll.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="lk.Initialize(\"\")";
_lk.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="ll.Text=\"keine App-daten gefunden..\"";
_ll.setText(BA.ObjectToCharSequence("keine App-daten gefunden.."));
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="ll.Textsize=12";
_ll.setTextSize((float) (12));
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="ll.Typeface=rfont";
_ll.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="Dim builder As MaterialDialogBuilder";
_builder = new de.amberhome.materialdialogs.MaterialDialogBuilderWrapper();
RDebugUtils.currentLine=1703945;
 //BA.debugLineNum = 1703945;BA.debugLine="builder.Initialize(\"hexa\")";
_builder.Initialize(mostCurrent.activityBA,"hexa");
RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="builder.ContentGravity(builder.GRAVITY_START)";
_builder.ContentGravity(_builder.GRAVITY_START);
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="builder.Title(\"Clean!\").TitleColor(mcl.md_grey_50";
_builder.Title(BA.ObjectToCharSequence("Clean!")).TitleColor(mostCurrent._mcl.getmd_grey_500()).Content(BA.ObjectToCharSequence(_ll.getText())).ContentColor(mostCurrent._mcl.getmd_amber_500()).Theme(_builder.THEME_DARK).NeutralText(BA.ObjectToCharSequence("Ok"));
RDebugUtils.currentLine=1703948;
 //BA.debugLineNum = 1703948;BA.debugLine="dia=builder.Show";
mostCurrent._dia = _builder.Show();
RDebugUtils.currentLine=1703949;
 //BA.debugLineNum = 1703949;BA.debugLine="End Sub";
return "";
}
public static String  _lolist_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lolist_itemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "lolist_itemclick", new Object[] {_position,_value});
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub lolist_ItemClick (Position As Int, Value As Ob";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)(0))) {
case 0: {
 break; }
}
;
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="End Sub";
return "";
}
public static String  _lv1_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lv1_itemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "lv1_itemclick", new Object[] {_position,_value});
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub lv1_ItemClick (Position As Int, Value As Objec";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)(2))) {
case 0: {
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="sub_list";
_sub_list();
 break; }
}
;
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="End Sub";
return "";
}
public static String  _sub_list() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sub_list"))
	return (String) Debug.delegate(mostCurrent.activityBA, "sub_list", null);
anywheresoftware.b4a.objects.collections.List _lo = null;
de.amberhome.materialdialogs.MaterialSimpleListItemWrapper _mi = null;
anywheresoftware.b4a.objects.LabelWrapper _ll = null;
anywheresoftware.b4a.objects.LabelWrapper _lk = null;
de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _builder = null;
String _i = "";
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub sub_list";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Dim lo As List";
_lo = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Dim mi As MaterialSimpleListItem";
_mi = new de.amberhome.materialdialogs.MaterialSimpleListItemWrapper();
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="lo.Initialize";
_lo.Initialize();
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="Dim ll,lk As Label";
_ll = new anywheresoftware.b4a.objects.LabelWrapper();
_lk = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="ll.Initialize(\"\")";
_ll.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="lk.Initialize(\"\")";
_lk.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="ll.Textsize=12";
_ll.setTextSize((float) (12));
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="ll.Typeface=rfont";
_ll.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="ll.Text=alist.ListKeys.Size&\" Anwendungen:\"";
_ll.setText(BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._alist._listkeys(null).getSize())+" Anwendungen:"));
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="Dim builder As MaterialDialogBuilder";
_builder = new de.amberhome.materialdialogs.MaterialDialogBuilderWrapper();
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="builder.Initialize(\"fexa\")";
_builder.Initialize(mostCurrent.activityBA,"fexa");
RDebugUtils.currentLine=589836;
 //BA.debugLineNum = 589836;BA.debugLine="lo=File.ReadList(dir,\"clist.txt\")";
_lo = anywheresoftware.b4a.keywords.Common.File.ReadList(mostCurrent._dir,"clist.txt");
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="For Each i As String In alist.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group13 = mostCurrent._alist._listkeys(null);
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_i = BA.ObjectToString(group13.Get(index13));
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="Log(i)";
anywheresoftware.b4a.keywords.Common.Log(_i);
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="mi.Initialize(pack.GetApplicationIcon(i),pack.Ge";
_mi.Initialize(processBA,mostCurrent._pack.GetApplicationIcon(_i),BA.ObjectToCharSequence(mostCurrent._pack.GetApplicationLabel(_i)+" / "+_formatfilesize((float)(BA.ObjectToNumber(mostCurrent._alist._get(null,_i))))));
RDebugUtils.currentLine=589840;
 //BA.debugLineNum = 589840;BA.debugLine="builder.AddSimpleItem(mi)";
_builder.AddSimpleItem(_mi);
 }
};
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="builder.ContentGravity(builder.GRAVITY_START)";
_builder.ContentGravity(_builder.GRAVITY_START);
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="builder.Title(\"Clean Log:\").TitleColor(mcl.md_gre";
_builder.Title(BA.ObjectToCharSequence("Clean Log:")).TitleColor(mostCurrent._mcl.getmd_grey_500()).Content(BA.ObjectToCharSequence(_ll.getText())).ContentColor(mostCurrent._mcl.getmd_amber_600()).Theme(_builder.THEME_DARK).NegativeText(BA.ObjectToCharSequence("Ok")).PositiveColor(mostCurrent._mcl.getmd_red_500()).PositiveText(BA.ObjectToCharSequence("Clear log"));
RDebugUtils.currentLine=589844;
 //BA.debugLineNum = 589844;BA.debugLine="dia=builder.Show";
mostCurrent._dia = _builder.Show();
RDebugUtils.currentLine=589845;
 //BA.debugLineNum = 589845;BA.debugLine="dia.Show";
mostCurrent._dia.Show();
RDebugUtils.currentLine=589846;
 //BA.debugLineNum = 589846;BA.debugLine="End Sub";
return "";
}
public static String  _openurl() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "openurl"))
	return (String) Debug.delegate(mostCurrent.activityBA, "openurl", null);
String _url = "";
anywheresoftware.b4a.objects.IntentWrapper _i = null;
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub openurl";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="Dim url As String=\"https://www.sulomedia.de\"";
_url = "https://www.sulomedia.de";
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="i.Initialize(i.ACTION_VIEW, url)";
_i.Initialize(_i.ACTION_VIEW,_url);
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="i.SetType(\"text/html\")";
_i.SetType("text/html");
RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="i.AddCategory(\"android.intent.category.BROWSABLE\"";
_i.AddCategory("android.intent.category.BROWSABLE");
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
RDebugUtils.currentLine=2818055;
 //BA.debugLineNum = 2818055;BA.debugLine="End Sub";
return "";
}
public static String  _pb_update() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pb_update"))
	return (String) Debug.delegate(mostCurrent.activityBA, "pb_update", null);
int _cc = 0;
int _tot = 0;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub pb_update";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="Dim cc,tot As Int";
_cc = 0;
_tot = 0;
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="tot=kvst.Get(\"ta\")";
_tot = (int)(BA.ObjectToNumber(mostCurrent._kvst._get(null,"ta")));
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="cc=kvsdata.Get(\"c\")";
_cc = (int)(BA.ObjectToNumber(mostCurrent._kvsdata._get(null,"c")));
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="ss.Progress=100+((cc)/(tot))*100";
mostCurrent._ss.setProgress((int) (100+((_cc)/(double)(_tot))*100));
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="End Sub";
return "";
}
public static String  _prb_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "prb_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "prb_click", null);
anywheresoftware.b4a.objects.LabelWrapper _lt = null;
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub prb_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Dim lt As Label";
_lt = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="lt.Initialize(\"\")";
_lt.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="lt.Typeface=rfont";
_lt.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="lt.Text=\"bitte warten..\"";
_lt.setText(BA.ObjectToCharSequence("bitte warten.."));
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="xOSStats.EndStats";
mostCurrent._xosstats._endstats();
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="sm.HideMenus";
mostCurrent._sm.HideMenus();
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="lt.TextSize=11";
_lt.setTextSize((float) (11));
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="prb.Text=lt.Text";
mostCurrent._prb.setText(BA.ObjectToCharSequence(_lt.getText()));
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="prb.TextColor=mcl.md_white_1000";
mostCurrent._prb.setTextColor(mostCurrent._mcl.getmd_white_1000());
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="CallSubDelayed(Starter,\"remote_start\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._starter.getObject()),"remote_start");
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="prb.SetVisibleAnimated(200,False)";
mostCurrent._prb.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031628;
 //BA.debugLineNum = 2031628;BA.debugLine="pn.SetVisibleAnimated(250,True)";
mostCurrent._pn.SetVisibleAnimated((int) (250),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031630;
 //BA.debugLineNum = 2031630;BA.debugLine="End Sub";
return "";
}
public static String  _r_schredder() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "r_schredder"))
	return (String) Debug.delegate(mostCurrent.activityBA, "r_schredder", null);
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub r_schredder";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="schredder(True)";
_schredder(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="End Sub";
return "";
}
public static String  _stats_update(float[] _cpuefficiency,float _ramusage) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "stats_update"))
	return (String) Debug.delegate(mostCurrent.activityBA, "stats_update", new Object[] {_cpuefficiency,_ramusage});
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub Stats_Update(CPUEfficiency() As Float, RAMUsag";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="pb1.Progress=RAMUsage";
mostCurrent._pb1.setProgress((int) (_ramusage));
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="pb1.BottomText=FormatFileSize(RAMUsage*1024*1024*";
mostCurrent._pb1.setBottomText(_formatfilesize((float) (_ramusage*1024*1024*10))+"/"+_formatfilesize((float) (mostCurrent._xmsos.getSystemTotalMemorySize(mostCurrent.activityBA))));
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="End Sub";
return "";
}
public static String  _t1_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "t1_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "t1_tick", null);
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub t1_Tick";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="counter=counter+1";
_counter = (int) (_counter+1);
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Log(\"tick\")";
anywheresoftware.b4a.keywords.Common.Log("tick");
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="If counter> 1 Then";
if (_counter>1) { 
 };
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="If counter>3 Then";
if (_counter>3) { 
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="sr.SetVisibleAnimated(100,False)";
mostCurrent._sr.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="pdim.SetVisibleAnimated(200,False)";
mostCurrent._pdim.SetVisibleAnimated((int) (200),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="ready.SetVisibleAnimated(150,True)";
mostCurrent._ready.SetVisibleAnimated((int) (150),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="lo_tick";
_lo_tick();
 };
RDebugUtils.currentLine=1507340;
 //BA.debugLineNum = 1507340;BA.debugLine="If counter= 6 Then";
if (_counter==6) { 
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="t1.Enabled=False";
_t1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507342;
 //BA.debugLineNum = 1507342;BA.debugLine="counter=0";
_counter = (int) (0);
RDebugUtils.currentLine=1507344;
 //BA.debugLineNum = 1507344;BA.debugLine="dp_clear";
_dp_clear();
RDebugUtils.currentLine=1507345;
 //BA.debugLineNum = 1507345;BA.debugLine="dp_clean";
_dp_clean();
RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="l_sub";
_l_sub();
 };
RDebugUtils.currentLine=1507348;
 //BA.debugLineNum = 1507348;BA.debugLine="End Sub";
return "";
}
public static String  _toolbar_menuitemclick(de.amberhome.objects.appcompat.ACMenuItemWrapper _item) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "toolbar_menuitemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "toolbar_menuitemclick", new Object[] {_item});
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub toolbar_MenuItemClick (Item As ACMenuItem)";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Select Item.Id";
switch (BA.switchObjectToInt(_item.getId(),(int)(Double.parseDouble("0")),(int)(Double.parseDouble("1")),(int)(Double.parseDouble("2")))) {
case 0: {
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="sm.ShowMenu";
mostCurrent._sm.ShowMenu();
 break; }
case 1: {
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="set_click";
_set_click();
 break; }
case 2: {
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="If sm.Visible=True Then";
if (mostCurrent._sm.getVisible()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="sm.HideMenus";
mostCurrent._sm.HideMenus();
 }else {
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="sm.ShowMenu";
mostCurrent._sm.ShowMenu();
 };
 break; }
}
;
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="End Sub";
return "";
}
public static String  _toolbar_navigationitemclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "toolbar_navigationitemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "toolbar_navigationitemclick", null);
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub toolbar_NavigationItemClick";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="exit_click";
_exit_click();
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="End Sub";
return "";
}
public static String  _tota_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tota_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tota_click", null);
anywheresoftware.b4a.objects.collections.List _lo = null;
de.amberhome.materialdialogs.MaterialSimpleListItemWrapper _mi = null;
anywheresoftware.b4a.objects.LabelWrapper _ll = null;
anywheresoftware.b4a.objects.LabelWrapper _lk = null;
de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _builder = null;
String _i = "";
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub tota_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Dim lo As List";
_lo = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Dim mi As MaterialSimpleListItem";
_mi = new de.amberhome.materialdialogs.MaterialSimpleListItemWrapper();
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="lo.Initialize";
_lo.Initialize();
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="Dim ll,lk As Label";
_ll = new anywheresoftware.b4a.objects.LabelWrapper();
_lk = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="ll.Initialize(\"\")";
_ll.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="lk.Initialize(\"\")";
_lk.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="ll.Textsize=10";
_ll.setTextSize((float) (10));
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="ll.Typeface=rfont";
_ll.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="ll.Text=dbase.ListKeys.Size&\" Anwendungen:\"";
_ll.setText(BA.ObjectToCharSequence(BA.NumberToString(mostCurrent._dbase._listkeys(null).getSize())+" Anwendungen:"));
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="Dim builder As MaterialDialogBuilder";
_builder = new de.amberhome.materialdialogs.MaterialDialogBuilderWrapper();
RDebugUtils.currentLine=1114123;
 //BA.debugLineNum = 1114123;BA.debugLine="builder.Initialize(\"dexa\")";
_builder.Initialize(mostCurrent.activityBA,"dexa");
RDebugUtils.currentLine=1114124;
 //BA.debugLineNum = 1114124;BA.debugLine="For Each i As String In dbase.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group12 = mostCurrent._dbase._listkeys(null);
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_i = BA.ObjectToString(group12.Get(index12));
RDebugUtils.currentLine=1114125;
 //BA.debugLineNum = 1114125;BA.debugLine="mi.Initialize2(\"tc32\",dbase.Get(i)&\" - \"&FormatF";
_mi.Initialize2(processBA,"tc32",BA.ObjectToCharSequence(BA.ObjectToString(mostCurrent._dbase._get(null,_i))+" - "+_formatfilesize((float)(Double.parseDouble(_i)))));
RDebugUtils.currentLine=1114126;
 //BA.debugLineNum = 1114126;BA.debugLine="builder.AddSimpleItem(mi)";
_builder.AddSimpleItem(_mi);
 }
};
RDebugUtils.currentLine=1114128;
 //BA.debugLineNum = 1114128;BA.debugLine="builder.ContentGravity(builder.GRAVITY_START)";
_builder.ContentGravity(_builder.GRAVITY_START);
RDebugUtils.currentLine=1114129;
 //BA.debugLineNum = 1114129;BA.debugLine="builder.Title(\"Total Clean Log:\").TitleColor(mcl.";
_builder.Title(BA.ObjectToCharSequence("Total Clean Log:")).TitleColor(mostCurrent._mcl.getmd_grey_500()).Content(BA.ObjectToCharSequence(_ll.getText())).ContentColor(mostCurrent._mcl.getmd_amber_600()).Theme(_builder.THEME_DARK).NegativeText(BA.ObjectToCharSequence("Ok")).PositiveColor(mostCurrent._mcl.getmd_red_500()).PositiveText(BA.ObjectToCharSequence("Clear log"));
RDebugUtils.currentLine=1114130;
 //BA.debugLineNum = 1114130;BA.debugLine="dia=builder.Show";
mostCurrent._dia = _builder.Show();
RDebugUtils.currentLine=1114131;
 //BA.debugLineNum = 1114131;BA.debugLine="dia.Show";
mostCurrent._dia.Show();
RDebugUtils.currentLine=1114132;
 //BA.debugLineNum = 1114132;BA.debugLine="End Sub";
return "";
}
public static String  _total_off() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "total_off"))
	return (String) Debug.delegate(mostCurrent.activityBA, "total_off", null);
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub total_off";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="log_list";
_log_list();
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="prb.Text=\"scan\"";
mostCurrent._prb.setText(BA.ObjectToCharSequence("scan"));
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="xOSStats.StartStats";
mostCurrent._xosstats._startstats();
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="End Sub";
return "";
}
public static String  _word_click(Object _tag) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "word_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "word_click", new Object[] {_tag});
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub Word_click(tag As Object)";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="Log(tag)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(_tag));
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="openurl";
_openurl();
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="End Sub";
return "";
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