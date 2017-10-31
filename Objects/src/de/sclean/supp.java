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

public class supp extends Activity implements B4AActivity{
	public static supp mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "de.sclean", "de.sclean.supp");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (supp).");
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
		activityBA = new BA(this, layout, processBA, "de.sclean", "de.sclean.supp");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "de.sclean.supp", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (supp) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (supp) Resume **");
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
		return supp.class;
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
        BA.LogInfo("** Activity (supp) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (supp) Resume **");
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
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.keywords.constants.TypefaceWrapper _rfont = null;
public de.amberhome.objects.appcompat.ACFlatButtonWrapper _acb1 = null;
public de.amberhome.objects.appcompat.ACEditTextWrapper _ace = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public de.sclean.keyvaluestore _qbase = null;
public de.sclean.main _main = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.info _info = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;
public static String  _acb1_click() throws Exception{
RDebugUtils.currentModule="supp";
if (Debug.shouldDelegate(mostCurrent.activityBA, "acb1_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "acb1_click", null);
anywheresoftware.b4a.phone.Phone.Email _message = null;
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub acb1_Click";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="Dim Message As Email";
_message = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Message.To.Add(\"info@sulomedia.de\")";
_message.To.Add((Object)("info@sulomedia.de"));
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="Message.Body=qbase.Get(\"text\")";
_message.Body = BA.ObjectToString(mostCurrent._qbase._get(null,"text"));
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="StartActivity(Message.GetIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_message.GetIntent()));
RDebugUtils.currentLine=3604487;
 //BA.debugLineNum = 3604487;BA.debugLine="ToastMessageShow(\"Vielen Dank deine Anfrage wird";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Vielen Dank deine Anfrage wird verarbeitet, öffne E-mail Programm.."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="qbase.DeleteAll";
mostCurrent._qbase._deleteall(null);
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=3604490;
 //BA.debugLineNum = 3604490;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
mostCurrent._animator._setanimati(mostCurrent.activityBA,"extra_in","extra_out");
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="End Sub";
return "";
}
public static String  _ace_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="supp";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ace_textchanged"))
	return (String) Debug.delegate(mostCurrent.activityBA, "ace_textchanged", new Object[] {_old,_new});
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub ace_TextChanged (Old As String, New As String)";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="If qbase.ContainsKey(\"text\") Then";
if (mostCurrent._qbase._containskey(null,"text")) { 
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="qbase.Remove(\"text\")";
mostCurrent._qbase._remove(null,"text");
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="qbase.Put(\"text\",New)";
mostCurrent._qbase._put(null,"text",(Object)(_new));
 }else {
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="qbase.Put(\"text\",New)";
mostCurrent._qbase._put(null,"text",(Object)(_new));
 };
RDebugUtils.currentLine=3538951;
 //BA.debugLineNum = 3538951;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="supp";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="Activity.LoadLayout(\"4\")";
mostCurrent._activity.LoadLayout("4",mostCurrent.activityBA);
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="Label1.TextSize=15";
mostCurrent._label1.setTextSize((float) (15));
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="Label1.Typeface=rfont";
mostCurrent._label1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="Label1.Gravity=Gravity.FILL";
mostCurrent._label1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="Label1.Text=\"Teile uns Verbesserungen oder Vorsc";
mostCurrent._label1.setText(BA.ObjectToCharSequence("Teile uns Verbesserungen oder Vorschläge mit um S-cleaner noch besser für dich zu machen! Wir Antworten so schnell wie möglich auf deine Anfrage und freuen uns über jeden neuen Vorschlag oder Hinweis."));
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="EditText1.Hint=\"Name\"";
mostCurrent._edittext1.setHint("Name");
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="EditText1.ForceDoneButton=True";
mostCurrent._edittext1.setForceDoneButton(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3211276;
 //BA.debugLineNum = 3211276;BA.debugLine="EditText2.hint=\"Email Adresse\"";
mostCurrent._edittext2.setHint("Email Adresse");
RDebugUtils.currentLine=3211277;
 //BA.debugLineNum = 3211277;BA.debugLine="EditText2.ForceDoneButton=True";
mostCurrent._edittext2.setForceDoneButton(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3211278;
 //BA.debugLineNum = 3211278;BA.debugLine="EditText1.Typeface=rfont";
mostCurrent._edittext1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=3211279;
 //BA.debugLineNum = 3211279;BA.debugLine="EditText2.Typeface=rfont";
mostCurrent._edittext2.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=3211280;
 //BA.debugLineNum = 3211280;BA.debugLine="acb1.Text=\"Senden\"";
mostCurrent._acb1.setText(BA.ObjectToCharSequence("Senden"));
RDebugUtils.currentLine=3211281;
 //BA.debugLineNum = 3211281;BA.debugLine="acb1.Typeface=rfont";
mostCurrent._acb1.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=3211282;
 //BA.debugLineNum = 3211282;BA.debugLine="acb1.Gravity=Gravity.CENTER";
mostCurrent._acb1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=3211284;
 //BA.debugLineNum = 3211284;BA.debugLine="ace.TextSize=15";
mostCurrent._ace.setTextSize((float) (15));
RDebugUtils.currentLine=3211285;
 //BA.debugLineNum = 3211285;BA.debugLine="ace.Typeface=rfont";
mostCurrent._ace.setTypeface((android.graphics.Typeface)(_rfont.getObject()));
RDebugUtils.currentLine=3211286;
 //BA.debugLineNum = 3211286;BA.debugLine="ace.Gravity=Gravity.TOP";
mostCurrent._ace.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
RDebugUtils.currentLine=3211287;
 //BA.debugLineNum = 3211287;BA.debugLine="ace.Hint=\"Schreibe uns was du denkst..\"";
mostCurrent._ace.setHint("Schreibe uns was du denkst..");
RDebugUtils.currentLine=3211289;
 //BA.debugLineNum = 3211289;BA.debugLine="qbase.Initialize(File.DirInternal,\"qbase_data\")";
mostCurrent._qbase._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"qbase_data");
RDebugUtils.currentLine=3211293;
 //BA.debugLineNum = 3211293;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="supp";
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="supp";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="End Sub";
return "";
}
public static String  _edittext1_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="supp";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edittext1_textchanged"))
	return (String) Debug.delegate(mostCurrent.activityBA, "edittext1_textchanged", new Object[] {_old,_new});
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub EditText1_TextChanged (Old As String, New As S";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="If qbase.ContainsKey(\"mail\") Then";
if (mostCurrent._qbase._containskey(null,"mail")) { 
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="qbase.Remove(\"mail\")";
mostCurrent._qbase._remove(null,"mail");
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="qbase.Put(\"mail\",New)";
mostCurrent._qbase._put(null,"mail",(Object)(_new));
 }else {
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="qbase.Put(\"mail\",New)";
mostCurrent._qbase._put(null,"mail",(Object)(_new));
 };
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="End Sub";
return "";
}
public static String  _edittext2_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="supp";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edittext2_textchanged"))
	return (String) Debug.delegate(mostCurrent.activityBA, "edittext2_textchanged", new Object[] {_old,_new});
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub EditText2_TextChanged (Old As String, New As S";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="If qbase.ContainsKey(\"name\") Then";
if (mostCurrent._qbase._containskey(null,"name")) { 
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="qbase.Remove(\"name\")";
mostCurrent._qbase._remove(null,"name");
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="qbase.Put(\"name\",New)";
mostCurrent._qbase._put(null,"name",(Object)(_new));
 }else {
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="qbase.Put(\"name\",New)";
mostCurrent._qbase._put(null,"name",(Object)(_new));
 };
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="End Sub";
return "";
}
}