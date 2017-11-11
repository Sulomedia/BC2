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

public class option extends Activity implements B4AActivity{
	public static option mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "de.sclean", "de.sclean.option");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (option).");
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
		activityBA = new BA(this, layout, processBA, "de.sclean", "de.sclean.option");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "de.sclean.option", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (option) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (option) Resume **");
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
		return option.class;
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
        BA.LogInfo("** Activity (option) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (option) Resume **");
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
public static anywheresoftware.b4a.keywords.constants.TypefaceWrapper _rfont = null;
public static String _package = "";
public static String _utext = "";
public de.amberhome.objects.appcompat.ACCheckBoxWrapper _acb1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _ctext = null;
public anywheresoftware.b4a.objects.LabelWrapper _mtext = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lv2 = null;
public com.tchart.materialcolors.MaterialColors _mcl = null;
public de.sclean.keyvaluestore _savedata = null;
public anywheresoftware.b4a.phone.PackageManagerWrapper _pack = null;
public de.amberhome.objects.appcompat.ACFlatButtonWrapper _ab1 = null;
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.starter _starter = null;
public de.sclean.info _info = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _ab1_click() throws Exception{
 //BA.debugLineNum = 145;BA.debugLine="Sub ab1_Click";
 //BA.debugLineNum = 146;BA.debugLine="StateManager.SaveState(Activity,\"option\")";
mostCurrent._statemanager._savestate(mostCurrent.activityBA,mostCurrent._activity,"option");
 //BA.debugLineNum = 147;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 148;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
mostCurrent._animator._setanimati(mostCurrent.activityBA,"extra_in","extra_out");
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public static String  _about_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _l1 = null;
anywheresoftware.b4a.objects.LabelWrapper _l2 = null;
anywheresoftware.b4a.objects.CSBuilder _cs = null;
de.amberhome.materialdialogs.MaterialDialogWrapper _infodia = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _inf = null;
de.amberhome.materialdialogs.MaterialDialogBuilderWrapper _builder = null;
 //BA.debugLineNum = 116;BA.debugLine="Sub about_click";
 //BA.debugLineNum = 117;BA.debugLine="Dim l1,l2 As Label";
_l1 = new anywheresoftware.b4a.objects.LabelWrapper();
_l2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 118;BA.debugLine="l1.Initialize(\"\")";
_l1.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 119;BA.debugLine="l2.Initialize(\"\")";
_l2.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 120;BA.debugLine="l2.TextSize=15";
_l2.setTextSize((float) (15));
 //BA.debugLineNum = 121;BA.debugLine="l1.TextSize=13";
_l1.setTextSize((float) (13));
 //BA.debugLineNum = 122;BA.debugLine="l1.textcolor=mcl.md_black_1000";
_l1.setTextColor(mostCurrent._mcl.getmd_black_1000());
 //BA.debugLineNum = 123;BA.debugLine="l2.textcolor=mcl.md_black_1000";
_l2.setTextColor(mostCurrent._mcl.getmd_black_1000());
 //BA.debugLineNum = 124;BA.debugLine="l1.Gravity=Gravity.TOP";
_l1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
 //BA.debugLineNum = 125;BA.debugLine="l1.Typeface=rfont";
_l1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 126;BA.debugLine="l2.Typeface=rfont";
_l2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 127;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 128;BA.debugLine="cs.Initialize.Append(\"App Ver: \"&pack.GetVersionN";
_cs.Initialize().Append(BA.ObjectToCharSequence("App Ver: "+mostCurrent._pack.GetVersionName(_package)+anywheresoftware.b4a.keywords.Common.CRLF+"Build Nr: "+BA.NumberToString(mostCurrent._pack.GetVersionCode(_package))+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF+"Code: D.Trojan"+anywheresoftware.b4a.keywords.Common.CRLF)).Append(BA.ObjectToCharSequence("Published by Sulomedia"+anywheresoftware.b4a.keywords.Common.CRLF+"© 2017"+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 129;BA.debugLine="cs.Append(CreateClickableWord(utext)).PopAll";
_cs.Append(BA.ObjectToCharSequence(_createclickableword(_utext).getObject())).PopAll();
 //BA.debugLineNum = 130;BA.debugLine="l2.Text=\"About \"&pack.GetApplicationLabel(package";
_l2.setText(BA.ObjectToCharSequence("About "+mostCurrent._pack.GetApplicationLabel(_package)));
 //BA.debugLineNum = 131;BA.debugLine="l1.Text=cs";
_l1.setText(BA.ObjectToCharSequence(_cs.getObject()));
 //BA.debugLineNum = 132;BA.debugLine="Dim infodia As MaterialDialog";
_infodia = new de.amberhome.materialdialogs.MaterialDialogWrapper();
 //BA.debugLineNum = 133;BA.debugLine="Dim inf As BitmapDrawable";
_inf = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 134;BA.debugLine="inf.Initialize(LoadBitmap(File.DirAssets,\"ic_andr";
_inf.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_android_black_36dp.png").getObject()));
 //BA.debugLineNum = 135;BA.debugLine="Dim Builder As MaterialDialogBuilder";
_builder = new de.amberhome.materialdialogs.MaterialDialogBuilderWrapper();
 //BA.debugLineNum = 136;BA.debugLine="Builder.Initialize(\"Dialog3\")";
_builder.Initialize(mostCurrent.activityBA,"Dialog3");
 //BA.debugLineNum = 137;BA.debugLine="Builder.Title(l2.Text).TitleColor(mcl.md_black_10";
_builder.Title(BA.ObjectToCharSequence(_l2.getText())).TitleColor(mostCurrent._mcl.getmd_black_1000()).Icon((android.graphics.drawable.Drawable)(_inf.getObject())).LimitIconToDefaultSize().Theme(_builder.THEME_LIGHT).Content(BA.ObjectToCharSequence(_cs.getObject())).ContentLineSpacing((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))).Typeface((android.graphics.Typeface)(_rfont.getObject()),(android.graphics.Typeface)(_rfont.getObject())).Cancelable(anywheresoftware.b4a.keywords.Common.True).NeutralText(BA.ObjectToCharSequence("close")).NeutralColor(mostCurrent._mcl.getmd_grey_600()).ContentGravity(_builder.GRAVITY_START).ContentLineSpacing((float) (2));
 //BA.debugLineNum = 138;BA.debugLine="infodia=Builder.Show";
_infodia = _builder.Show();
 //BA.debugLineNum = 139;BA.debugLine="infodia.Show";
_infodia.Show();
 //BA.debugLineNum = 140;BA.debugLine="cs.EnableClickEvents(l1)";
_cs.EnableClickEvents((android.widget.TextView)(_l1.getObject()));
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public static String  _acb1_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 67;BA.debugLine="Sub acb1_CheckedChange(Checked As Boolean)";
 //BA.debugLineNum = 68;BA.debugLine="Select Checked";
switch (BA.switchObjectToInt(_checked,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False)) {
case 0: {
 //BA.debugLineNum = 70;BA.debugLine="StartService(info)";
anywheresoftware.b4a.keywords.Common.StartService(processBA,(Object)(mostCurrent._info.getObject()));
 //BA.debugLineNum = 71;BA.debugLine="acb1.Text=\"Service: Aktiviert\"";
mostCurrent._acb1.setText(BA.ObjectToCharSequence("Service: Aktiviert"));
 //BA.debugLineNum = 72;BA.debugLine="save(True)";
_save(anywheresoftware.b4a.keywords.Common.True);
 break; }
case 1: {
 //BA.debugLineNum = 74;BA.debugLine="acb1.Text=\"Service: Deaktiviert\"";
mostCurrent._acb1.setText(BA.ObjectToCharSequence("Service: Deaktiviert"));
 //BA.debugLineNum = 75;BA.debugLine="StopService(info)";
anywheresoftware.b4a.keywords.Common.StopService(processBA,(Object)(mostCurrent._info.getObject()));
 //BA.debugLineNum = 76;BA.debugLine="save(False)";
_save(anywheresoftware.b4a.keywords.Common.False);
 break; }
}
;
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.CSBuilder _cs = null;
 //BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"2\")";
mostCurrent._activity.LoadLayout("2",mostCurrent.activityBA);
 //BA.debugLineNum = 26;BA.debugLine="savedata.Initialize(File.DirInternal,\"save_data\")";
mostCurrent._savedata._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"save_data");
 //BA.debugLineNum = 27;BA.debugLine="Mtext.Typeface=rfont";
mostCurrent._mtext.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 28;BA.debugLine="Ctext.Typeface=rfont";
mostCurrent._ctext.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 29;BA.debugLine="acb1.TextSize=12";
mostCurrent._acb1.setTextSize((float) (12));
 //BA.debugLineNum = 30;BA.debugLine="acb1.Typeface=rfont";
mostCurrent._acb1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 31;BA.debugLine="acb1.Text=\"Service Modul: Deaktiviert\"";
mostCurrent._acb1.setText(BA.ObjectToCharSequence("Service Modul: Deaktiviert"));
 //BA.debugLineNum = 32;BA.debugLine="ab1.Text=\"zurück\"";
mostCurrent._ab1.setText(BA.ObjectToCharSequence("zurück"));
 //BA.debugLineNum = 33;BA.debugLine="ab1.Typeface=rfont";
mostCurrent._ab1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 34;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 35;BA.debugLine="cs.Initialize.Alignment(\"ALIGN_CENTER\").Append(\"E";
_cs.Initialize().Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_CENTER")).Append(BA.ObjectToCharSequence("Einstellungen")).PopAll();
 //BA.debugLineNum = 36;BA.debugLine="Mtext.Text=cs";
mostCurrent._mtext.setText(BA.ObjectToCharSequence(_cs.getObject()));
 //BA.debugLineNum = 37;BA.debugLine="If StateManager.RestoreState(Activity, \"option\",";
if (mostCurrent._statemanager._restorestate(mostCurrent.activityBA,mostCurrent._activity,"option",(int) (0))==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 38;BA.debugLine="acb1.Checked=False";
mostCurrent._acb1.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 40;BA.debugLine="c_text";
_c_text();
 //BA.debugLineNum = 41;BA.debugLine="l_text";
_l_text();
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 53;BA.debugLine="If KeyCode=KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 54;BA.debugLine="StateManager.SaveState(Activity,\"option\")";
mostCurrent._statemanager._savestate(mostCurrent.activityBA,mostCurrent._activity,"option");
 //BA.debugLineNum = 55;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 56;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
mostCurrent._animator._setanimati(mostCurrent.activityBA,"extra_in","extra_out");
 };
 //BA.debugLineNum = 58;BA.debugLine="Return(True)";
if (true) return (anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public static String  _c_text() throws Exception{
anywheresoftware.b4a.objects.CSBuilder _cs = null;
 //BA.debugLineNum = 61;BA.debugLine="Sub c_text";
 //BA.debugLineNum = 62;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 63;BA.debugLine="cs.Initialize.Color(mcl.md_black_1000).Append(\"Hi";
_cs.Initialize().Color(mostCurrent._mcl.getmd_black_1000()).Append(BA.ObjectToCharSequence("Hier wird das 'Cleaner Service Module' Aktiviert oder Deaktiviert")).Pop().PopAll();
 //BA.debugLineNum = 64;BA.debugLine="Ctext.Text=cs";
mostCurrent._ctext.setText(BA.ObjectToCharSequence(_cs.getObject()));
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.CSBuilder  _createclickableword(String _text) throws Exception{
anywheresoftware.b4a.objects.CSBuilder _cs = null;
 //BA.debugLineNum = 152;BA.debugLine="Sub CreateClickableWord(Text As String) As CSBuild";
 //BA.debugLineNum = 153;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 154;BA.debugLine="Return cs.Initialize.Underline.Color(0xFF00D0FF).";
if (true) return _cs.Initialize().Underline().Color((int) (0xff00d0ff)).Clickable(processBA,"Word",(Object)(_text)).Append(BA.ObjectToCharSequence(_text)).PopAll();
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return null;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private acb1 As ACCheckBox";
mostCurrent._acb1 = new de.amberhome.objects.appcompat.ACCheckBoxWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private Ctext As Label";
mostCurrent._ctext = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private Mtext As Label";
mostCurrent._mtext = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private lv2 As ListView";
mostCurrent._lv2 = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private mcl As MaterialColors";
mostCurrent._mcl = new com.tchart.materialcolors.MaterialColors();
 //BA.debugLineNum = 19;BA.debugLine="Private savedata As KeyValueStore";
mostCurrent._savedata = new de.sclean.keyvaluestore();
 //BA.debugLineNum = 20;BA.debugLine="Private pack As PackageManager";
mostCurrent._pack = new anywheresoftware.b4a.phone.PackageManagerWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private ab1 As ACFlatButton";
mostCurrent._ab1 = new de.amberhome.objects.appcompat.ACFlatButtonWrapper();
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _l_text() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _la1 = null;
anywheresoftware.b4a.objects.LabelWrapper _la2 = null;
 //BA.debugLineNum = 89;BA.debugLine="Sub l_text";
 //BA.debugLineNum = 90;BA.debugLine="Dim la1,la2 As Label";
_la1 = new anywheresoftware.b4a.objects.LabelWrapper();
_la2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 91;BA.debugLine="la2.Initialize(\"la2\")";
_la2.Initialize(mostCurrent.activityBA,"la2");
 //BA.debugLineNum = 92;BA.debugLine="la1.Initialize(\"la1\")";
_la1.Initialize(mostCurrent.activityBA,"la1");
 //BA.debugLineNum = 93;BA.debugLine="la1=lv2.TwoLinesAndBitmap.Label";
_la1 = mostCurrent._lv2.getTwoLinesAndBitmap().Label;
 //BA.debugLineNum = 94;BA.debugLine="la2=lv2.TwoLinesAndBitmap.SecondLabel";
_la2 = mostCurrent._lv2.getTwoLinesAndBitmap().SecondLabel;
 //BA.debugLineNum = 95;BA.debugLine="lv2.TwoLinesAndBitmap.ImageView.Height=32dip";
mostCurrent._lv2.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 96;BA.debugLine="lv2.TwoLinesAndBitmap.ImageView.Width=32dip";
mostCurrent._lv2.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 97;BA.debugLine="lv2.TwoLinesAndBitmap.ItemHeight=50dip";
mostCurrent._lv2.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 98;BA.debugLine="la1.TextSize=15";
_la1.setTextSize((float) (15));
 //BA.debugLineNum = 99;BA.debugLine="la2.TextSize=11";
_la2.setTextSize((float) (11));
 //BA.debugLineNum = 100;BA.debugLine="la1.Typeface=rfont";
_la1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 101;BA.debugLine="la2.Typeface=rfont";
_la2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
 //BA.debugLineNum = 102;BA.debugLine="la1.TextColor=Colors.ARGB(255,36,220,238)";
_la1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (36),(int) (220),(int) (238)));
 //BA.debugLineNum = 103;BA.debugLine="la2.TextColor=Colors.ARGB(230,0,0,0)";
_la2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (230),(int) (0),(int) (0),(int) (0)));
 //BA.debugLineNum = 104;BA.debugLine="lv2.Clear";
mostCurrent._lv2.Clear();
 //BA.debugLineNum = 105;BA.debugLine="lv2.AddTwoLinesAndBitmap2(\"About\",\"alles über Scl";
mostCurrent._lv2.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence("About"),BA.ObjectToCharSequence("alles über Scleaner"),(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ic_extension_white_36dp.png").getObject()),(Object)(2));
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public static String  _lv2_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Sub lv2_ItemClick (Position As Int, Value As Objec";
 //BA.debugLineNum = 109;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)(2))) {
case 0: {
 //BA.debugLineNum = 111;BA.debugLine="about_click";
_about_click();
 break; }
}
;
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public static String  _openurl() throws Exception{
String _url = "";
anywheresoftware.b4a.objects.IntentWrapper _i = null;
 //BA.debugLineNum = 161;BA.debugLine="Sub openurl";
 //BA.debugLineNum = 162;BA.debugLine="Dim url As String=\"https://www.sulomedia.de\"";
_url = "https://www.sulomedia.de";
 //BA.debugLineNum = 163;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 164;BA.debugLine="i.Initialize(i.ACTION_VIEW, url)";
_i.Initialize(_i.ACTION_VIEW,_url);
 //BA.debugLineNum = 165;BA.debugLine="i.SetType(\"text/html\")";
_i.SetType("text/html");
 //BA.debugLineNum = 166;BA.debugLine="i.AddCategory(\"android.intent.category.BROWSABLE\"";
_i.AddCategory("android.intent.category.BROWSABLE");
 //BA.debugLineNum = 167;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private rfont As Typeface= rfont.LoadFromAssets(\"";
_rfont = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
_rfont.setObject((android.graphics.Typeface)(_rfont.LoadFromAssets("Aldrich-Regular.ttf")));
 //BA.debugLineNum = 8;BA.debugLine="Private package As String=\"de.sclean\"";
_package = "de.sclean";
 //BA.debugLineNum = 9;BA.debugLine="Dim utext As String=\"www.sulomedia.de\"";
_utext = "www.sulomedia.de";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _save(boolean _sav) throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub save(sav As Boolean)";
 //BA.debugLineNum = 81;BA.debugLine="If sav=True Then";
if (_sav==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 82;BA.debugLine="savedata.Put(\"sv\",sav)";
mostCurrent._savedata._put("sv",(Object)(_sav));
 }else {
 //BA.debugLineNum = 84;BA.debugLine="savedata.Remove(\"sv\")";
mostCurrent._savedata._remove("sv");
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _word_click(Object _tag) throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Sub Word_click(tag As Object)";
 //BA.debugLineNum = 157;BA.debugLine="Log(tag)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(_tag));
 //BA.debugLineNum = 158;BA.debugLine="openurl";
_openurl();
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
}
