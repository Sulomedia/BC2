package de.sclean;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class widget_subs_0 {


public static RemoteObject  _b1_click() throws Exception{
try {
		Debug.PushSubsStack("b1_Click (widget) ","widget",6,widget.processBA,widget.mostCurrent,64);
if (RapidSub.canDelegate("b1_click")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","b1_click");
 BA.debugLineNum = 64;BA.debugLine="Sub b1_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 65;BA.debugLine="CallSubDelayed(Starter,\"wid_start\")";
Debug.ShouldStop(1);
widget.mostCurrent.__c.runVoidMethod ("CallSubDelayed",widget.processBA,(Object)((widget.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("wid_start")));
 BA.debugLineNum = 66;BA.debugLine="rv.SetVisible(\"pb1\",True)";
Debug.ShouldStop(2);
widget._rv.runVoidMethod ("SetVisible",widget.processBA,(Object)(BA.ObjectToString("pb1")),(Object)(widget.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 67;BA.debugLine="rv.SetVisible(\"l2\",True)";
Debug.ShouldStop(4);
widget._rv.runVoidMethod ("SetVisible",widget.processBA,(Object)(BA.ObjectToString("l2")),(Object)(widget.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 68;BA.debugLine="rv.SetVisible(\"b1\",False)";
Debug.ShouldStop(8);
widget._rv.runVoidMethod ("SetVisible",widget.processBA,(Object)(BA.ObjectToString("b1")),(Object)(widget.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 69;BA.debugLine="rv_requestUpdate";
Debug.ShouldStop(16);
_rv_requestupdate();
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
public static RemoteObject  _formatfilesize(RemoteObject _bytes) throws Exception{
try {
		Debug.PushSubsStack("FormatFileSize (widget) ","widget",6,widget.processBA,widget.mostCurrent,92);
if (RapidSub.canDelegate("formatfilesize")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","formatfilesize", _bytes);
RemoteObject _unit = null;
RemoteObject _po = RemoteObject.createImmutable(0);
RemoteObject _si = RemoteObject.createImmutable(0);
RemoteObject _i = RemoteObject.createImmutable(0);
Debug.locals.put("Bytes", _bytes);
 BA.debugLineNum = 92;BA.debugLine="Sub FormatFileSize(Bytes As Float) As String";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="Private Unit() As String = Array As String(\" Byte";
Debug.ShouldStop(268435456);
_unit = RemoteObject.createNewArray("String",new int[] {9},new Object[] {BA.ObjectToString(" Byte"),BA.ObjectToString(" KB"),BA.ObjectToString(" MB"),BA.ObjectToString(" GB"),BA.ObjectToString(" TB"),BA.ObjectToString(" PB"),BA.ObjectToString(" EB"),BA.ObjectToString(" ZB"),RemoteObject.createImmutable(" YB")});Debug.locals.put("Unit", _unit);Debug.locals.put("Unit", _unit);
 BA.debugLineNum = 94;BA.debugLine="If Bytes = 0 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_bytes,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 95;BA.debugLine="Return \"0 Bytes\"";
Debug.ShouldStop(1073741824);
if (true) return BA.ObjectToString("0 Bytes");
 }else {
 BA.debugLineNum = 97;BA.debugLine="Private Po, Si As Double";
Debug.ShouldStop(1);
_po = RemoteObject.createImmutable(0);Debug.locals.put("Po", _po);
_si = RemoteObject.createImmutable(0);Debug.locals.put("Si", _si);
 BA.debugLineNum = 98;BA.debugLine="Private I As Int";
Debug.ShouldStop(2);
_i = RemoteObject.createImmutable(0);Debug.locals.put("I", _i);
 BA.debugLineNum = 99;BA.debugLine="Bytes = Abs(Bytes)";
Debug.ShouldStop(4);
_bytes = BA.numberCast(float.class, widget.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, _bytes))));Debug.locals.put("Bytes", _bytes);
 BA.debugLineNum = 100;BA.debugLine="I = Floor(Logarithm(Bytes, 1024))";
Debug.ShouldStop(8);
_i = BA.numberCast(int.class, widget.mostCurrent.__c.runMethod(true,"Floor",(Object)(widget.mostCurrent.__c.runMethod(true,"Logarithm",(Object)(BA.numberCast(double.class, _bytes)),(Object)(BA.numberCast(double.class, 1024))))));Debug.locals.put("I", _i);
 BA.debugLineNum = 101;BA.debugLine="Po = Power(1024, I)";
Debug.ShouldStop(16);
_po = widget.mostCurrent.__c.runMethod(true,"Power",(Object)(BA.numberCast(double.class, 1024)),(Object)(BA.numberCast(double.class, _i)));Debug.locals.put("Po", _po);
 BA.debugLineNum = 102;BA.debugLine="Si = Bytes / Po";
Debug.ShouldStop(32);
_si = RemoteObject.solve(new RemoteObject[] {_bytes,_po}, "/",0, 0);Debug.locals.put("Si", _si);
 BA.debugLineNum = 103;BA.debugLine="Return NumberFormat(Si, 1, 2) & Unit(I)";
Debug.ShouldStop(64);
if (true) return RemoteObject.concat(widget.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_si),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2))),_unit.getArrayElement(true,_i));
 };
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim rv As RemoteViews";
widget._rv = RemoteObject.createNew ("anywheresoftware.b4a.objects.RemoteViewsWrapper");
 //BA.debugLineNum = 10;BA.debugLine="Private kvsdata,alist As KeyValueStore";
widget._kvsdata = RemoteObject.createNew ("de.sclean.keyvaluestore");
widget._alist = RemoteObject.createNew ("de.sclean.keyvaluestore");
 //BA.debugLineNum = 11;BA.debugLine="Private cts As CustomToast";
widget._cts = RemoteObject.createNew ("com.rootsoft.customtoast.CustomToast");
 //BA.debugLineNum = 12;BA.debugLine="Private mcl As MaterialColors";
widget._mcl = RemoteObject.createNew ("com.tchart.materialcolors.MaterialColors");
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _prog_update() throws Exception{
try {
		Debug.PushSubsStack("prog_update (widget) ","widget",6,widget.processBA,widget.mostCurrent,72);
if (RapidSub.canDelegate("prog_update")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","prog_update");
RemoteObject _cc = RemoteObject.createImmutable(0);
RemoteObject _c = RemoteObject.createImmutable(0);
 BA.debugLineNum = 72;BA.debugLine="Sub prog_update";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="Dim cc,c As Int";
Debug.ShouldStop(256);
_cc = RemoteObject.createImmutable(0);Debug.locals.put("cc", _cc);
_c = RemoteObject.createImmutable(0);Debug.locals.put("c", _c);
 BA.debugLineNum = 74;BA.debugLine="c=kvsdata.Get(\"c\")";
Debug.ShouldStop(512);
_c = BA.numberCast(int.class, widget._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("c"))));Debug.locals.put("c", _c);
 BA.debugLineNum = 75;BA.debugLine="cc=kvsdata.Get(\"to\")";
Debug.ShouldStop(1024);
_cc = BA.numberCast(int.class, widget._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("to"))));Debug.locals.put("cc", _cc);
 BA.debugLineNum = 77;BA.debugLine="rv.SetText(\"l2\",c&CRLF&\"/\"&cc)";
Debug.ShouldStop(4096);
widget._rv.runVoidMethod ("SetText",widget.processBA,(Object)(BA.ObjectToString("l2")),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_c,widget.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("/"),_cc))));
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rv_clean() throws Exception{
try {
		Debug.PushSubsStack("rv_clean (widget) ","widget",6,widget.processBA,widget.mostCurrent,87);
if (RapidSub.canDelegate("rv_clean")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","rv_clean");
 BA.debugLineNum = 87;BA.debugLine="Sub rv_clean";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="CallSubDelayed(Starter,\"clean_start\")";
Debug.ShouldStop(8388608);
widget.mostCurrent.__c.runVoidMethod ("CallSubDelayed",widget.processBA,(Object)((widget.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("clean_start")));
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rv_disabled() throws Exception{
try {
		Debug.PushSubsStack("rv_Disabled (widget) ","widget",6,widget.processBA,widget.mostCurrent,40);
if (RapidSub.canDelegate("rv_disabled")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","rv_disabled");
 BA.debugLineNum = 40;BA.debugLine="Sub rv_Disabled";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="StopService(\"\")";
Debug.ShouldStop(256);
widget.mostCurrent.__c.runVoidMethod ("StopService",widget.processBA,(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rv_requestupdate() throws Exception{
try {
		Debug.PushSubsStack("rv_requestUpdate (widget) ","widget",6,widget.processBA,widget.mostCurrent,36);
if (RapidSub.canDelegate("rv_requestupdate")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","rv_requestupdate");
 BA.debugLineNum = 36;BA.debugLine="Sub rv_requestUpdate";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="rv.UpdateWidget";
Debug.ShouldStop(16);
widget._rv.runVoidMethod ("UpdateWidget",widget.processBA);
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rv_restart() throws Exception{
try {
		Debug.PushSubsStack("rv_restart (widget) ","widget",6,widget.processBA,widget.mostCurrent,48);
if (RapidSub.canDelegate("rv_restart")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","rv_restart");
RemoteObject _icon = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _icon2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _pac = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _sum = RemoteObject.createImmutable(0);
RemoteObject _g = RemoteObject.createImmutable("");
 BA.debugLineNum = 48;BA.debugLine="Sub rv_restart";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="Dim icon As BitmapDrawable";
Debug.ShouldStop(65536);
_icon = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("icon", _icon);
 BA.debugLineNum = 50;BA.debugLine="Dim icon2 As Bitmap";
Debug.ShouldStop(131072);
_icon2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("icon2", _icon2);
 BA.debugLineNum = 51;BA.debugLine="Dim pac As PackageManager";
Debug.ShouldStop(262144);
_pac = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pac", _pac);
 BA.debugLineNum = 52;BA.debugLine="rv.SetVisible(\"pb1\",False)";
Debug.ShouldStop(524288);
widget._rv.runVoidMethod ("SetVisible",widget.processBA,(Object)(BA.ObjectToString("pb1")),(Object)(widget.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 53;BA.debugLine="rv.SetVisible(\"l2\",False)";
Debug.ShouldStop(1048576);
widget._rv.runVoidMethod ("SetVisible",widget.processBA,(Object)(BA.ObjectToString("l2")),(Object)(widget.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 54;BA.debugLine="rv.SetVisible(\"b1\",True)";
Debug.ShouldStop(2097152);
widget._rv.runVoidMethod ("SetVisible",widget.processBA,(Object)(BA.ObjectToString("b1")),(Object)(widget.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 55;BA.debugLine="Dim sum As Int=0";
Debug.ShouldStop(4194304);
_sum = BA.numberCast(int.class, 0);Debug.locals.put("sum", _sum);Debug.locals.put("sum", _sum);
 BA.debugLineNum = 56;BA.debugLine="For Each g As String In alist.ListKeys";
Debug.ShouldStop(8388608);
{
final RemoteObject group8 = widget._alist.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys");
final int groupLen8 = group8.runMethod(true,"getSize").<Integer>get()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_g = BA.ObjectToString(group8.runMethod(false,"Get",index8));Debug.locals.put("g", _g);
Debug.locals.put("g", _g);
 BA.debugLineNum = 57;BA.debugLine="Log(FormatFileSize(alist.Get(g)))";
Debug.ShouldStop(16777216);
widget.mostCurrent.__c.runVoidMethod ("Log",(Object)(_formatfilesize(BA.numberCast(float.class, widget._alist.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(_g))))));
 BA.debugLineNum = 58;BA.debugLine="sum=sum+alist.Get(g)";
Debug.ShouldStop(33554432);
_sum = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_sum,BA.numberCast(double.class, widget._alist.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(_g)))}, "+",1, 0));Debug.locals.put("sum", _sum);
 BA.debugLineNum = 59;BA.debugLine="icon=pac.GetApplicationIcon(g)";
Debug.ShouldStop(67108864);
_icon.setObject(_pac.runMethod(false,"GetApplicationIcon",(Object)(_g)));
 }
}Debug.locals.put("g", _g);
;
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
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (widget) ","widget",6,widget.processBA,widget.mostCurrent,15);
if (RapidSub.canDelegate("service_create")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","service_create");
RemoteObject _ostat = RemoteObject.declareNull("b4a.example.osstats");
RemoteObject _mos = RemoteObject.declareNull("com.maximussoft.msos.MSOS");
 BA.debugLineNum = 15;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(16384);
 BA.debugLineNum = 16;BA.debugLine="rv= ConfigureHomeWidget(\"wv\",\"rv\",0,\"SBoost\",True";
Debug.ShouldStop(32768);
widget._rv = BA.rdebugUtils.runMethod(false, "createRemoteView", widget.processBA,"widget_layout", "wv",BA.ObjectToString("rv"));
 BA.debugLineNum = 17;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
Debug.ShouldStop(65536);
widget._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",widget.processBA,(Object)(widget.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("data_data")));
 BA.debugLineNum = 18;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
Debug.ShouldStop(131072);
widget._alist.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",widget.processBA,(Object)(widget.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("adata_data")));
 BA.debugLineNum = 19;BA.debugLine="cts.Initialize";
Debug.ShouldStop(262144);
widget._cts.runVoidMethod ("Initialize",widget.processBA);
 BA.debugLineNum = 20;BA.debugLine="Private ostat As OSStats";
Debug.ShouldStop(524288);
_ostat = RemoteObject.createNew ("b4a.example.osstats");Debug.locals.put("ostat", _ostat);
 BA.debugLineNum = 21;BA.debugLine="Private mos As MSOS";
Debug.ShouldStop(1048576);
_mos = RemoteObject.createNew ("com.maximussoft.msos.MSOS");Debug.locals.put("mos", _mos);
 BA.debugLineNum = 22;BA.debugLine="ostat.Initialize(400, 50, Me, \"Stats\")";
Debug.ShouldStop(2097152);
_ostat.runVoidMethod ("_initialize",widget.processBA,(Object)(BA.numberCast(int.class, 400)),(Object)(BA.numberCast(int.class, 50)),(Object)(widget.getObject()),(Object)(RemoteObject.createImmutable("Stats")));
 BA.debugLineNum = 23;BA.debugLine="ostat.StartStats";
Debug.ShouldStop(4194304);
_ostat.runVoidMethod ("_startstats");
 BA.debugLineNum = 24;BA.debugLine="rv.SetVisible(\"b1\",True)";
Debug.ShouldStop(8388608);
widget._rv.runVoidMethod ("SetVisible",widget.processBA,(Object)(BA.ObjectToString("b1")),(Object)(widget.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 25;BA.debugLine="rv.SetVisible(\"p1\",True)";
Debug.ShouldStop(16777216);
widget._rv.runVoidMethod ("SetVisible",widget.processBA,(Object)(BA.ObjectToString("p1")),(Object)(widget.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 26;BA.debugLine="rv.SetVisible(\"pb1\",False)";
Debug.ShouldStop(33554432);
widget._rv.runVoidMethod ("SetVisible",widget.processBA,(Object)(BA.ObjectToString("pb1")),(Object)(widget.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 27;BA.debugLine="rv.SetVisible(\"l2\",False)";
Debug.ShouldStop(67108864);
widget._rv.runVoidMethod ("SetVisible",widget.processBA,(Object)(BA.ObjectToString("l2")),(Object)(widget.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 28;BA.debugLine="rv.SetTextColor(\"l2\",mcl.md_amber_400)";
Debug.ShouldStop(134217728);
widget._rv.runVoidMethod ("SetTextColor",widget.processBA,(Object)(BA.ObjectToString("l2")),(Object)(widget._mcl.runMethod(true,"getmd_amber_400")));
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (widget) ","widget",6,widget.processBA,widget.mostCurrent,44);
if (RapidSub.canDelegate("service_destroy")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","service_destroy");
 BA.debugLineNum = 44;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (widget) ","widget",6,widget.processBA,widget.mostCurrent,31);
if (RapidSub.canDelegate("service_start")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 31;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="If rv.HandleWidgetEvents(StartingIntent) Then Ret";
Debug.ShouldStop(-2147483648);
if (widget._rv.runMethod(true,"HandleWidgetEvents",widget.processBA,(Object)((_startingintent.getObject()))).<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _stats_update(RemoteObject _cpuefficiency,RemoteObject _ramusage) throws Exception{
try {
		Debug.PushSubsStack("stats_Update (widget) ","widget",6,widget.processBA,widget.mostCurrent,80);
if (RapidSub.canDelegate("stats_update")) return de.sclean.widget.remoteMe.runUserSub(false, "widget","stats_update", _cpuefficiency, _ramusage);
Debug.locals.put("CPUEfficiency", _cpuefficiency);
Debug.locals.put("RAMUsage", _ramusage);
 BA.debugLineNum = 80;BA.debugLine="Sub stats_Update(CPUEfficiency() As Float, RAMUsag";
Debug.ShouldStop(32768);
 BA.debugLineNum = 82;BA.debugLine="rv.SetText(\"b1\",FormatFileSize(RAMUsage*1024*1024";
Debug.ShouldStop(131072);
widget._rv.runVoidMethod ("SetText",widget.processBA,(Object)(BA.ObjectToString("b1")),(Object)(BA.ObjectToCharSequence(_formatfilesize(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_ramusage,RemoteObject.createImmutable(1024),RemoteObject.createImmutable(1024),RemoteObject.createImmutable(10)}, "***",0, 0))))));
 BA.debugLineNum = 83;BA.debugLine="rv_requestUpdate";
Debug.ShouldStop(262144);
_rv_requestupdate();
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}