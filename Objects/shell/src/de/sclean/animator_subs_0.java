package de.sclean;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class animator_subs_0 {


public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Dim setanimat As String";
animator._setanimat = RemoteObject.createImmutable("");
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setanimati(RemoteObject _ba,RemoteObject _inanimation,RemoteObject _outanimation) throws Exception{
try {
		Debug.PushSubsStack("SetAnimati (animator) ","animator",8,_ba,animator.mostCurrent,9);
if (RapidSub.canDelegate("setanimati")) return de.sclean.animator.remoteMe.runUserSub(false, "animator","setanimati", _ba, _inanimation, _outanimation);
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _package = RemoteObject.createImmutable("");
RemoteObject _in = RemoteObject.createImmutable(0);
RemoteObject _out = RemoteObject.createImmutable(0);
;
Debug.locals.put("InAnimation", _inanimation);
Debug.locals.put("OutAnimation", _outanimation);
 BA.debugLineNum = 9;BA.debugLine="Sub SetAnimati(InAnimation As String, OutAnimation";
Debug.ShouldStop(256);
 BA.debugLineNum = 10;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(512);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 11;BA.debugLine="Dim package As String";
Debug.ShouldStop(1024);
_package = RemoteObject.createImmutable("");Debug.locals.put("package", _package);
 BA.debugLineNum = 12;BA.debugLine="Dim in, out As Int";
Debug.ShouldStop(2048);
_in = RemoteObject.createImmutable(0);Debug.locals.put("in", _in);
_out = RemoteObject.createImmutable(0);Debug.locals.put("out", _out);
 BA.debugLineNum = 13;BA.debugLine="package = r.GetStaticField(\"anywheresoftware.b4a.";
Debug.ShouldStop(4096);
_package = BA.ObjectToString(_r.runMethod(false,"GetStaticField",(Object)(BA.ObjectToString("anywheresoftware.b4a.BA")),(Object)(RemoteObject.createImmutable("packageName"))));Debug.locals.put("package", _package);
 BA.debugLineNum = 14;BA.debugLine="in = r.GetStaticField(package & \".R$anim\", InAnim";
Debug.ShouldStop(8192);
_in = BA.numberCast(int.class, _r.runMethod(false,"GetStaticField",(Object)(RemoteObject.concat(_package,RemoteObject.createImmutable(".R$anim"))),(Object)(_inanimation)));Debug.locals.put("in", _in);
 BA.debugLineNum = 15;BA.debugLine="out = r.GetStaticField(package & \".R$anim\", OutAn";
Debug.ShouldStop(16384);
_out = BA.numberCast(int.class, _r.runMethod(false,"GetStaticField",(Object)(RemoteObject.concat(_package,RemoteObject.createImmutable(".R$anim"))),(Object)(_outanimation)));Debug.locals.put("out", _out);
 BA.debugLineNum = 16;BA.debugLine="r.Target = r.GetActivity";
Debug.ShouldStop(32768);
_r.setField ("Target",(_r.runMethod(false,"GetActivity",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba))));
 BA.debugLineNum = 17;BA.debugLine="r.RunMethod4(\"overridePendingTransition\", Array A";
Debug.ShouldStop(65536);
_r.runVoidMethod ("RunMethod4",(Object)(BA.ObjectToString("overridePendingTransition")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_in),(_out)})),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("java.lang.int"),RemoteObject.createImmutable("java.lang.int")})));
 BA.debugLineNum = 19;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}