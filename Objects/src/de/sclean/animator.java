package de.sclean;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class animator {
private static animator mostCurrent = new animator();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _setanimat = "";
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.info _info = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public static String  _setanimati(anywheresoftware.b4a.BA _ba,String _inanimation,String _outanimation) throws Exception{
RDebugUtils.currentModule="animator";
if (Debug.shouldDelegate(null, "setanimati"))
	return (String) Debug.delegate(null, "setanimati", new Object[] {_ba,_inanimation,_outanimation});
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
String _package = "";
int _in = 0;
int _out = 0;
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Sub SetAnimati(InAnimation As String, OutAnimation";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="Dim package As String";
_package = "";
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="Dim in, out As Int";
_in = 0;
_out = 0;
RDebugUtils.currentLine=8585220;
 //BA.debugLineNum = 8585220;BA.debugLine="package = r.GetStaticField(\"anywheresoftware.b4a.";
_package = BA.ObjectToString(_r.GetStaticField("anywheresoftware.b4a.BA","packageName"));
RDebugUtils.currentLine=8585221;
 //BA.debugLineNum = 8585221;BA.debugLine="in = r.GetStaticField(package & \".R$anim\", InAnim";
_in = (int)(BA.ObjectToNumber(_r.GetStaticField(_package+".R$anim",_inanimation)));
RDebugUtils.currentLine=8585222;
 //BA.debugLineNum = 8585222;BA.debugLine="out = r.GetStaticField(package & \".R$anim\", OutAn";
_out = (int)(BA.ObjectToNumber(_r.GetStaticField(_package+".R$anim",_outanimation)));
RDebugUtils.currentLine=8585223;
 //BA.debugLineNum = 8585223;BA.debugLine="r.Target = r.GetActivity";
_r.Target = (Object)(_r.GetActivity((_ba.processBA == null ? _ba : _ba.processBA)));
RDebugUtils.currentLine=8585224;
 //BA.debugLineNum = 8585224;BA.debugLine="r.RunMethod4(\"overridePendingTransition\", Array A";
_r.RunMethod4("overridePendingTransition",new Object[]{(Object)(_in),(Object)(_out)},new String[]{"java.lang.int","java.lang.int"});
RDebugUtils.currentLine=8585226;
 //BA.debugLineNum = 8585226;BA.debugLine="End Sub";
return "";
}
}