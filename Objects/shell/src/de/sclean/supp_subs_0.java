package de.sclean;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class supp_subs_0 {


public static RemoteObject  _acb1_click() throws Exception{
try {
		Debug.PushSubsStack("acb1_Click (supp) ","supp",1,supp.mostCurrent.activityBA,supp.mostCurrent,92);
if (RapidSub.canDelegate("acb1_click")) return de.sclean.supp.remoteMe.runUserSub(false, "supp","acb1_click");
RemoteObject _message = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.Email");
 BA.debugLineNum = 92;BA.debugLine="Sub acb1_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="Dim Message As Email";
Debug.ShouldStop(268435456);
_message = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");Debug.locals.put("Message", _message);
 BA.debugLineNum = 94;BA.debugLine="Message.To.Add(\"info@sulomedia.de\")";
Debug.ShouldStop(536870912);
_message.getField(false,"To").runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("info@sulomedia.de"))));
 BA.debugLineNum = 95;BA.debugLine="Message.Body=qbase.Get(\"text\")";
Debug.ShouldStop(1073741824);
_message.setField ("Body",BA.ObjectToString(supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("text")))));
 BA.debugLineNum = 98;BA.debugLine="StartActivity(Message.GetIntent)";
Debug.ShouldStop(2);
supp.mostCurrent.__c.runVoidMethod ("StartActivity",supp.processBA,(Object)((_message.runMethod(false,"GetIntent"))));
 BA.debugLineNum = 99;BA.debugLine="ToastMessageShow(\"Vielen Dank deine Anfrage wird";
Debug.ShouldStop(4);
supp.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Vielen Dank deine Anfrage wird verarbeitet, öffne E-mail Programm..")),(Object)(supp.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 100;BA.debugLine="qbase.DeleteAll";
Debug.ShouldStop(8);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_deleteall");
 BA.debugLineNum = 101;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
supp.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 102;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
Debug.ShouldStop(32);
supp.mostCurrent._animator.runVoidMethod ("_setanimati",supp.mostCurrent.activityBA,(Object)(BA.ObjectToString("extra_in")),(Object)(RemoteObject.createImmutable("extra_out")));
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ace_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("ace_TextChanged (supp) ","supp",1,supp.mostCurrent.activityBA,supp.mostCurrent,83);
if (RapidSub.canDelegate("ace_textchanged")) return de.sclean.supp.remoteMe.runUserSub(false, "supp","ace_textchanged", _old, _new);
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 83;BA.debugLine="Sub ace_TextChanged (Old As String, New As String)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="If qbase.ContainsKey(\"text\") Then";
Debug.ShouldStop(524288);
if (supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("text"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 85;BA.debugLine="qbase.Remove(\"text\")";
Debug.ShouldStop(1048576);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_remove",(Object)(RemoteObject.createImmutable("text")));
 BA.debugLineNum = 86;BA.debugLine="qbase.Put(\"text\",New)";
Debug.ShouldStop(2097152);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("text")),(Object)((_new)));
 }else {
 BA.debugLineNum = 88;BA.debugLine="qbase.Put(\"text\",New)";
Debug.ShouldStop(8388608);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("text")),(Object)((_new)));
 };
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Create (supp) ","supp",1,supp.mostCurrent.activityBA,supp.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) return de.sclean.supp.remoteMe.runUserSub(false, "supp","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"4\")";
Debug.ShouldStop(67108864);
supp.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("4")),supp.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="Label1.TextSize=15";
Debug.ShouldStop(268435456);
supp.mostCurrent._label1.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 30;BA.debugLine="Label1.Typeface=rfont";
Debug.ShouldStop(536870912);
supp.mostCurrent._label1.runMethod(false,"setTypeface",(supp._rfont.getObject()));
 BA.debugLineNum = 31;BA.debugLine="Label1.Gravity=Gravity.FILL";
Debug.ShouldStop(1073741824);
supp.mostCurrent._label1.runMethod(true,"setGravity",supp.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 32;BA.debugLine="Label1.Text=\"Teile uns Verbesserungen oder Vorsc";
Debug.ShouldStop(-2147483648);
supp.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence("Teile uns Verbesserungen oder Vorschläge mit um S-cleaner noch besser für dich zu machen! Wir Antworten so schnell wie möglich auf deine Anfrage und freuen uns über jeden neuen Vorschlag oder Hinweis."));
 BA.debugLineNum = 34;BA.debugLine="EditText1.Hint=\"Name\"";
Debug.ShouldStop(2);
supp.mostCurrent._edittext1.runMethod(true,"setHint",BA.ObjectToString("Name"));
 BA.debugLineNum = 35;BA.debugLine="EditText1.ForceDoneButton=True";
Debug.ShouldStop(4);
supp.mostCurrent._edittext1.runVoidMethod ("setForceDoneButton",supp.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 37;BA.debugLine="EditText2.hint=\"Email Adresse\"";
Debug.ShouldStop(16);
supp.mostCurrent._edittext2.runMethod(true,"setHint",BA.ObjectToString("Email Adresse"));
 BA.debugLineNum = 38;BA.debugLine="EditText2.ForceDoneButton=True";
Debug.ShouldStop(32);
supp.mostCurrent._edittext2.runVoidMethod ("setForceDoneButton",supp.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 39;BA.debugLine="EditText1.Typeface=rfont";
Debug.ShouldStop(64);
supp.mostCurrent._edittext1.runMethod(false,"setTypeface",(supp._rfont.getObject()));
 BA.debugLineNum = 40;BA.debugLine="EditText2.Typeface=rfont";
Debug.ShouldStop(128);
supp.mostCurrent._edittext2.runMethod(false,"setTypeface",(supp._rfont.getObject()));
 BA.debugLineNum = 41;BA.debugLine="acb1.Text=\"Senden\"";
Debug.ShouldStop(256);
supp.mostCurrent._acb1.runMethod(true,"setText",BA.ObjectToCharSequence("Senden"));
 BA.debugLineNum = 42;BA.debugLine="acb1.Typeface=rfont";
Debug.ShouldStop(512);
supp.mostCurrent._acb1.runMethod(false,"setTypeface",(supp._rfont.getObject()));
 BA.debugLineNum = 43;BA.debugLine="acb1.Gravity=Gravity.CENTER";
Debug.ShouldStop(1024);
supp.mostCurrent._acb1.runMethod(true,"setGravity",supp.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 45;BA.debugLine="ace.TextSize=15";
Debug.ShouldStop(4096);
supp.mostCurrent._ace.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 46;BA.debugLine="ace.Typeface=rfont";
Debug.ShouldStop(8192);
supp.mostCurrent._ace.runMethod(false,"setTypeface",(supp._rfont.getObject()));
 BA.debugLineNum = 47;BA.debugLine="ace.Gravity=Gravity.TOP";
Debug.ShouldStop(16384);
supp.mostCurrent._ace.runMethod(true,"setGravity",supp.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP"));
 BA.debugLineNum = 48;BA.debugLine="ace.Hint=\"Schreibe uns was du denkst..\"";
Debug.ShouldStop(32768);
supp.mostCurrent._ace.runMethod(true,"setHint",BA.ObjectToString("Schreibe uns was du denkst.."));
 BA.debugLineNum = 50;BA.debugLine="qbase.Initialize(File.DirInternal,\"qbase_data\")";
Debug.ShouldStop(131072);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",supp.processBA,(Object)(supp.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("qbase_data")));
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (supp) ","supp",1,supp.mostCurrent.activityBA,supp.mostCurrent,60);
if (RapidSub.canDelegate("activity_pause")) return de.sclean.supp.remoteMe.runUserSub(false, "supp","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 60;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Resume (supp) ","supp",1,supp.mostCurrent.activityBA,supp.mostCurrent,56);
if (RapidSub.canDelegate("activity_resume")) return de.sclean.supp.remoteMe.runUserSub(false, "supp","activity_resume");
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edittext1_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("EditText1_TextChanged (supp) ","supp",1,supp.mostCurrent.activityBA,supp.mostCurrent,74);
if (RapidSub.canDelegate("edittext1_textchanged")) return de.sclean.supp.remoteMe.runUserSub(false, "supp","edittext1_textchanged", _old, _new);
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 74;BA.debugLine="Sub EditText1_TextChanged (Old As String, New As S";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="If qbase.ContainsKey(\"mail\") Then";
Debug.ShouldStop(1024);
if (supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("mail"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 76;BA.debugLine="qbase.Remove(\"mail\")";
Debug.ShouldStop(2048);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_remove",(Object)(RemoteObject.createImmutable("mail")));
 BA.debugLineNum = 77;BA.debugLine="qbase.Put(\"mail\",New)";
Debug.ShouldStop(4096);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("mail")),(Object)((_new)));
 }else {
 BA.debugLineNum = 79;BA.debugLine="qbase.Put(\"mail\",New)";
Debug.ShouldStop(16384);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("mail")),(Object)((_new)));
 };
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edittext2_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("EditText2_TextChanged (supp) ","supp",1,supp.mostCurrent.activityBA,supp.mostCurrent,65);
if (RapidSub.canDelegate("edittext2_textchanged")) return de.sclean.supp.remoteMe.runUserSub(false, "supp","edittext2_textchanged", _old, _new);
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 65;BA.debugLine="Sub EditText2_TextChanged (Old As String, New As S";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="If qbase.ContainsKey(\"name\") Then";
Debug.ShouldStop(2);
if (supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("name"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 67;BA.debugLine="qbase.Remove(\"name\")";
Debug.ShouldStop(4);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_remove",(Object)(RemoteObject.createImmutable("name")));
 BA.debugLineNum = 68;BA.debugLine="qbase.Put(\"name\",New)";
Debug.ShouldStop(8);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("name")),(Object)((_new)));
 }else {
 BA.debugLineNum = 70;BA.debugLine="qbase.Put(\"name\",New)";
Debug.ShouldStop(32);
supp.mostCurrent._qbase.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("name")),(Object)((_new)));
 };
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private acb1 As ACFlatButton";
supp.mostCurrent._acb1 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACFlatButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private ace As ACEditText";
supp.mostCurrent._ace = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACEditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private EditText1 As EditText";
supp.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private EditText2 As EditText";
supp.mostCurrent._edittext2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private Label1 As Label";
supp.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private Panel1 As Panel";
supp.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private qbase As KeyValueStore";
supp.mostCurrent._qbase = RemoteObject.createNew ("de.sclean.keyvaluestore");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private rfont As Typeface= rfont.LoadFromAssets(\"";
supp._rfont = RemoteObject.createNew ("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
supp._rfont.setObject(supp._rfont.runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("Aldrich-Regular.ttf"))));
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}