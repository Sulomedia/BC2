package de.sclean;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class option_subs_0 {


public static RemoteObject  _ab1_click() throws Exception{
try {
		Debug.PushSubsStack("ab1_Click (option) ","option",2,option.mostCurrent.activityBA,option.mostCurrent,76);
if (RapidSub.canDelegate("ab1_click")) return de.sclean.option.remoteMe.runUserSub(false, "option","ab1_click");
 BA.debugLineNum = 76;BA.debugLine="Sub ab1_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="StateManager.SaveState(Activity,\"option\")";
Debug.ShouldStop(4096);
option.mostCurrent._statemanager.runVoidMethod ("_savestate",option.mostCurrent.activityBA,(Object)(option.mostCurrent._activity),(Object)(RemoteObject.createImmutable("option")));
 BA.debugLineNum = 78;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8192);
option.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 79;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
Debug.ShouldStop(16384);
option.mostCurrent._animator.runVoidMethod ("_setanimati",option.mostCurrent.activityBA,(Object)(BA.ObjectToString("extra_in")),(Object)(RemoteObject.createImmutable("extra_out")));
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _acb1_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("acb1_CheckedChange (option) ","option",2,option.mostCurrent.activityBA,option.mostCurrent,61);
if (RapidSub.canDelegate("acb1_checkedchange")) return de.sclean.option.remoteMe.runUserSub(false, "option","acb1_checkedchange", _checked);
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 61;BA.debugLine="Sub acb1_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 62;BA.debugLine="Select Checked";
Debug.ShouldStop(536870912);
switch (BA.switchObjectToInt(_checked,option.mostCurrent.__c.getField(true,"True"),option.mostCurrent.__c.getField(true,"False"))) {
case 0: {
 BA.debugLineNum = 64;BA.debugLine="StartService(info)";
Debug.ShouldStop(-2147483648);
option.mostCurrent.__c.runVoidMethod ("StartService",option.processBA,(Object)((option.mostCurrent._info.getObject())));
 BA.debugLineNum = 65;BA.debugLine="acb1.Text=\"Service: Aktiviert\"";
Debug.ShouldStop(1);
option.mostCurrent._acb1.runMethod(true,"setText",BA.ObjectToCharSequence("Service: Aktiviert"));
 break; }
case 1: {
 BA.debugLineNum = 67;BA.debugLine="acb1.Text=\"Service: Deaktiviert\"";
Debug.ShouldStop(4);
option.mostCurrent._acb1.runMethod(true,"setText",BA.ObjectToCharSequence("Service: Deaktiviert"));
 BA.debugLineNum = 68;BA.debugLine="StopService(info)";
Debug.ShouldStop(8);
option.mostCurrent.__c.runVoidMethod ("StopService",option.processBA,(Object)((option.mostCurrent._info.getObject())));
 break; }
}
;
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (option) ","option",2,option.mostCurrent.activityBA,option.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) return de.sclean.option.remoteMe.runUserSub(false, "option","activity_create", _firsttime);
RemoteObject _cs = RemoteObject.declareNull("anywheresoftware.b4a.objects.CSBuilder");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="Activity.LoadLayout(\"2\")";
Debug.ShouldStop(1048576);
option.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("2")),option.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="Mtext.Typeface=rfont";
Debug.ShouldStop(2097152);
option.mostCurrent._mtext.runMethod(false,"setTypeface",(option._rfont.getObject()));
 BA.debugLineNum = 23;BA.debugLine="Ctext.Typeface=rfont";
Debug.ShouldStop(4194304);
option.mostCurrent._ctext.runMethod(false,"setTypeface",(option._rfont.getObject()));
 BA.debugLineNum = 24;BA.debugLine="acb1.TextSize=12";
Debug.ShouldStop(8388608);
option.mostCurrent._acb1.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 25;BA.debugLine="acb1.Typeface=rfont";
Debug.ShouldStop(16777216);
option.mostCurrent._acb1.runMethod(false,"setTypeface",(option._rfont.getObject()));
 BA.debugLineNum = 26;BA.debugLine="acb1.Text=\"Service Modul: Deaktiviert\"";
Debug.ShouldStop(33554432);
option.mostCurrent._acb1.runMethod(true,"setText",BA.ObjectToCharSequence("Service Modul: Deaktiviert"));
 BA.debugLineNum = 27;BA.debugLine="ab1.Text=\"zurück\"";
Debug.ShouldStop(67108864);
option.mostCurrent._ab1.runMethod(true,"setText",BA.ObjectToCharSequence("zurück"));
 BA.debugLineNum = 28;BA.debugLine="ab1.Typeface=rfont";
Debug.ShouldStop(134217728);
option.mostCurrent._ab1.runMethod(false,"setTypeface",(option._rfont.getObject()));
 BA.debugLineNum = 29;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(268435456);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 30;BA.debugLine="cs.Initialize.Alignment(\"ALIGN_CENTER\").Append(\"E";
Debug.ShouldStop(536870912);
_cs.runMethod(false,"Initialize").runMethod(false,"Alignment",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.text.Layout.Alignment"),RemoteObject.createImmutable("ALIGN_CENTER")))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Einstellungen")))).runVoidMethod ("PopAll");
 BA.debugLineNum = 31;BA.debugLine="Mtext.Text=cs";
Debug.ShouldStop(1073741824);
option.mostCurrent._mtext.runMethod(true,"setText",BA.ObjectToCharSequence(_cs.getObject()));
 BA.debugLineNum = 32;BA.debugLine="If StateManager.RestoreState(Activity, \"option\",";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",option.mostCurrent._statemanager.runMethod(true,"_restorestate",option.mostCurrent.activityBA,(Object)(option.mostCurrent._activity),(Object)(BA.ObjectToString("option")),(Object)(BA.numberCast(int.class, 0))),option.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 33;BA.debugLine="acb1.Checked=False";
Debug.ShouldStop(1);
option.mostCurrent._acb1.runMethodAndSync(true,"setChecked",option.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 35;BA.debugLine="c_text";
Debug.ShouldStop(4);
_c_text();
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (option) ","option",2,option.mostCurrent.activityBA,option.mostCurrent,46);
if (RapidSub.canDelegate("activity_keypress")) return de.sclean.option.remoteMe.runUserSub(false, "option","activity_keypress", _keycode);
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="If KeyCode=KeyCodes.KEYCODE_BACK Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, option.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK")))) { 
 BA.debugLineNum = 48;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32768);
option.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 49;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
Debug.ShouldStop(65536);
option.mostCurrent._animator.runVoidMethod ("_setanimati",option.mostCurrent.activityBA,(Object)(BA.ObjectToString("extra_in")),(Object)(RemoteObject.createImmutable("extra_out")));
 };
 BA.debugLineNum = 51;BA.debugLine="Return(True)";
Debug.ShouldStop(262144);
if (true) return (option.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (option) ","option",2,option.mostCurrent.activityBA,option.mostCurrent,42);
if (RapidSub.canDelegate("activity_pause")) return de.sclean.option.remoteMe.runUserSub(false, "option","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (option) ","option",2,option.mostCurrent.activityBA,option.mostCurrent,38);
if (RapidSub.canDelegate("activity_resume")) return de.sclean.option.remoteMe.runUserSub(false, "option","activity_resume");
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32);
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _c_text() throws Exception{
try {
		Debug.PushSubsStack("c_text (option) ","option",2,option.mostCurrent.activityBA,option.mostCurrent,54);
if (RapidSub.canDelegate("c_text")) return de.sclean.option.remoteMe.runUserSub(false, "option","c_text");
RemoteObject _cs = RemoteObject.declareNull("anywheresoftware.b4a.objects.CSBuilder");
 BA.debugLineNum = 54;BA.debugLine="Sub c_text";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(4194304);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 56;BA.debugLine="cs.Initialize.Color(mcl.md_blue_grey_900).Append(";
Debug.ShouldStop(8388608);
_cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(option.mostCurrent._mcl.runMethod(true,"getmd_blue_grey_900"))).runVoidMethod ("Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Hier wird das 'Cleaner Service Module' Aktiviert oder Deaktiviert, Standart: "))));
 BA.debugLineNum = 57;BA.debugLine="cs.Bold.Color(mcl.md_amber_700).Append(\"Deaktivie";
Debug.ShouldStop(16777216);
_cs.runMethod(false,"Bold").runMethod(false,"Color",(Object)(option.mostCurrent._mcl.runMethod(true,"getmd_amber_700"))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Deaktiviert")))).runMethod(false,"Pop").runVoidMethod ("PopAll");
 BA.debugLineNum = 58;BA.debugLine="Ctext.Text=cs";
Debug.ShouldStop(33554432);
option.mostCurrent._ctext.runMethod(true,"setText",BA.ObjectToCharSequence(_cs.getObject()));
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 11;BA.debugLine="Private acb1 As ACCheckBox";
option.mostCurrent._acb1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACCheckBoxWrapper");
 //BA.debugLineNum = 12;BA.debugLine="Private Ctext As Label";
option.mostCurrent._ctext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Private Mtext As Label";
option.mostCurrent._mtext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Private Panel1 As Panel";
option.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private ab1 As ACButton";
option.mostCurrent._ab1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACButtonWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private lv2 As ListView";
option.mostCurrent._lv2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private mcl As MaterialColors";
option.mostCurrent._mcl = RemoteObject.createNew ("com.tchart.materialcolors.MaterialColors");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lv2_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("lv2_ItemClick (option) ","option",2,option.mostCurrent.activityBA,option.mostCurrent,72);
if (RapidSub.canDelegate("lv2_itemclick")) return de.sclean.option.remoteMe.runUserSub(false, "option","lv2_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 72;BA.debugLine="Sub lv2_ItemClick (Position As Int, Value As Objec";
Debug.ShouldStop(128);
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private rfont As Typeface= rfont.LoadFromAssets(\"";
option._rfont = RemoteObject.createNew ("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
option._rfont.setObject(option._rfont.runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("Aldrich-Regular.ttf"))));
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}