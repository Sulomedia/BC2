package de.sclean;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _cb_oncleancompleted(RemoteObject _cachesize) throws Exception{
try {
		Debug.PushSubsStack("cb_onCleanCompleted (starter) ","starter",3,starter.processBA,starter.mostCurrent,148);
if (RapidSub.canDelegate("cb_oncleancompleted")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","cb_oncleancompleted", _cachesize);
Debug.locals.put("CacheSize", _cachesize);
 BA.debugLineNum = 148;BA.debugLine="Sub cb_onCleanCompleted(CacheSize As Long)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 149;BA.debugLine="kvst.DeleteAll";
Debug.ShouldStop(1048576);
starter._kvst.runClassMethod (de.sclean.keyvaluestore.class, "_deleteall");
 BA.debugLineNum = 150;BA.debugLine="info_remote";
Debug.ShouldStop(2097152);
_info_remote();
 BA.debugLineNum = 151;BA.debugLine="CallSub(Main,\"dp_clear\")";
Debug.ShouldStop(4194304);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("dp_clear")));
 BA.debugLineNum = 152;BA.debugLine="CallSub(info,\"c_ready\")";
Debug.ShouldStop(8388608);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._info.getObject())),(Object)(RemoteObject.createImmutable("c_ready")));
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cb_oncleanstarted() throws Exception{
try {
		Debug.PushSubsStack("cb_onCleanStarted (starter) ","starter",3,starter.processBA,starter.mostCurrent,143);
if (RapidSub.canDelegate("cb_oncleanstarted")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","cb_oncleanstarted");
 BA.debugLineNum = 143;BA.debugLine="Sub cb_onCleanStarted";
Debug.ShouldStop(16384);
 BA.debugLineNum = 144;BA.debugLine="CallSub(Widget,\"rv_restart\")";
Debug.ShouldStop(32768);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._widget.getObject())),(Object)(RemoteObject.createImmutable("rv_restart")));
 BA.debugLineNum = 145;BA.debugLine="Log(\"CleanStarted\")";
Debug.ShouldStop(65536);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("CleanStarted")));
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cb_onscancompleted(RemoteObject _appslist) throws Exception{
try {
		Debug.PushSubsStack("cb_onScanCompleted (starter) ","starter",3,starter.processBA,starter.mostCurrent,96);
if (RapidSub.canDelegate("cb_onscancompleted")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","cb_onscancompleted", _appslist);
RemoteObject _totalsize = RemoteObject.createImmutable(0L);
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _icon = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _lu = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _n = 0;
Debug.locals.put("AppsList", _appslist);
 BA.debugLineNum = 96;BA.debugLine="Sub cb_onScanCompleted(AppsList As Object)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Dim totalsize As Long = 0";
Debug.ShouldStop(1);
_totalsize = BA.numberCast(long.class, 0);Debug.locals.put("totalsize", _totalsize);Debug.locals.put("totalsize", _totalsize);
 BA.debugLineNum = 98;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(2);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 99;BA.debugLine="Private icon As BitmapDrawable";
Debug.ShouldStop(4);
_icon = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("icon", _icon);
 BA.debugLineNum = 101;BA.debugLine="piclist.Clear";
Debug.ShouldStop(16);
starter._piclist.runVoidMethod ("Clear");
 BA.debugLineNum = 102;BA.debugLine="obj.Clear";
Debug.ShouldStop(32);
starter._obj.runVoidMethod ("Clear");
 BA.debugLineNum = 103;BA.debugLine="alist.DeleteAll";
Debug.ShouldStop(64);
starter._alist.runClassMethod (de.sclean.keyvaluestore.class, "_deleteall");
 BA.debugLineNum = 104;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 105;BA.debugLine="Dim lu As List = AppsList";
Debug.ShouldStop(256);
_lu = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_lu.setObject(_appslist);Debug.locals.put("lu", _lu);
 BA.debugLineNum = 111;BA.debugLine="For n = 0 To lu.Size-1";
Debug.ShouldStop(16384);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_lu.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_n = 0 ;
for (;(step9 > 0 && _n <= limit9) || (step9 < 0 && _n >= limit9) ;_n = ((int)(0 + _n + step9))  ) {
Debug.locals.put("n", _n);
 BA.debugLineNum = 112;BA.debugLine="app= lu.Get(n)";
Debug.ShouldStop(32768);
starter._app = (_lu.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _n))));
 BA.debugLineNum = 113;BA.debugLine="If app(1) = \"com.android.systemui\"  Then  Conti";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",starter._app.getArrayElement(false,BA.numberCast(int.class, 1)),RemoteObject.createImmutable(("com.android.systemui")))) { 
if (true) continue;};
 BA.debugLineNum = 114;BA.debugLine="icon = pm.GetApplicationIcon(app(1))";
Debug.ShouldStop(131072);
_icon.setObject(_pm.runMethod(false,"GetApplicationIcon",(Object)(BA.ObjectToString(starter._app.getArrayElement(false,BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 115;BA.debugLine="totalsize = totalsize+app(2)";
Debug.ShouldStop(262144);
_totalsize = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_totalsize,BA.numberCast(double.class, starter._app.getArrayElement(false,BA.numberCast(int.class, 2)))}, "+",1, 0));Debug.locals.put("totalsize", _totalsize);
 BA.debugLineNum = 116;BA.debugLine="kvst.PutBitmap(app(1),icon.Bitmap)";
Debug.ShouldStop(524288);
starter._kvst.runClassMethod (de.sclean.keyvaluestore.class, "_putbitmap",(Object)(BA.ObjectToString(starter._app.getArrayElement(false,BA.numberCast(int.class, 1)))),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), _icon.runMethod(false,"getBitmap")));
 BA.debugLineNum = 117;BA.debugLine="alist.Put(app(1),totalsize)";
Debug.ShouldStop(1048576);
starter._alist.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString(starter._app.getArrayElement(false,BA.numberCast(int.class, 1)))),(Object)((_totalsize)));
 BA.debugLineNum = 118;BA.debugLine="obj.Add(app(1))";
Debug.ShouldStop(2097152);
starter._obj.runVoidMethod ("Add",(Object)(starter._app.getArrayElement(false,BA.numberCast(int.class, 1))));
 BA.debugLineNum = 119;BA.debugLine="kvsdata.Put(\"cs\",FormatFileSize(totalsize))";
Debug.ShouldStop(4194304);
starter._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("cs")),(Object)((_formatfilesize(BA.numberCast(float.class, _totalsize)))));
 BA.debugLineNum = 120;BA.debugLine="kvsdata.Put(totalsize,totalsize)";
Debug.ShouldStop(8388608);
starter._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.NumberToString(_totalsize)),(Object)((_totalsize)));
 }
}Debug.locals.put("n", _n);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e21) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e21.toString()); BA.debugLineNum = 124;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(134217728);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage")));
 };
 BA.debugLineNum = 126;BA.debugLine="If lu.size>0 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean(">",_lu.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 127;BA.debugLine="CallSub(Widget,\"rv_clean\")";
Debug.ShouldStop(1073741824);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._widget.getObject())),(Object)(RemoteObject.createImmutable("rv_clean")));
 BA.debugLineNum = 128;BA.debugLine="CallSub(Main,\"dp_off\")";
Debug.ShouldStop(-2147483648);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("dp_off")));
 }else {
 BA.debugLineNum = 130;BA.debugLine="CallSub(Widget,\"rv_restart\")";
Debug.ShouldStop(2);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._widget.getObject())),(Object)(RemoteObject.createImmutable("rv_restart")));
 BA.debugLineNum = 131;BA.debugLine="CallSub(Widget,\"rv_restart\")";
Debug.ShouldStop(4);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._widget.getObject())),(Object)(RemoteObject.createImmutable("rv_restart")));
 BA.debugLineNum = 132;BA.debugLine="CallSub(Main,\"total_off\")";
Debug.ShouldStop(8);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("total_off")));
 };
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cb_onscanprogress(RemoteObject _current,RemoteObject _total) throws Exception{
try {
		Debug.PushSubsStack("cb_onScanProgress (starter) ","starter",3,starter.processBA,starter.mostCurrent,86);
if (RapidSub.canDelegate("cb_onscanprogress")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","cb_onscanprogress", _current, _total);
Debug.locals.put("Current", _current);
Debug.locals.put("Total", _total);
 BA.debugLineNum = 86;BA.debugLine="Sub cb_onScanProgress(Current As Int , Total As In";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="kvsdata.Put(\"to\",Total)";
Debug.ShouldStop(4194304);
starter._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("to")),(Object)((_total)));
 BA.debugLineNum = 88;BA.debugLine="kvsdata.Put(\"c\",Current)";
Debug.ShouldStop(8388608);
starter._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("c")),(Object)((_current)));
 BA.debugLineNum = 89;BA.debugLine="CallSub(Widget,\"prog_update\")";
Debug.ShouldStop(16777216);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._widget.getObject())),(Object)(RemoteObject.createImmutable("prog_update")));
 BA.debugLineNum = 90;BA.debugLine="CallSubDelayed (Main,\"pb_update\")";
Debug.ShouldStop(33554432);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("pb_update")));
 BA.debugLineNum = 91;BA.debugLine="CallSub(info,\"c_update\")";
Debug.ShouldStop(67108864);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._info.getObject())),(Object)(RemoteObject.createImmutable("c_update")));
 BA.debugLineNum = 92;BA.debugLine="Log(\"Scan: \"&Current&\" /\"&Total)";
Debug.ShouldStop(134217728);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Scan: "),_current,RemoteObject.createImmutable(" /"),_total)));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cb_onscanstarted() throws Exception{
try {
		Debug.PushSubsStack("cb_OnScanStarted (starter) ","starter",3,starter.processBA,starter.mostCurrent,80);
if (RapidSub.canDelegate("cb_onscanstarted")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","cb_onscanstarted");
 BA.debugLineNum = 80;BA.debugLine="Sub cb_OnScanStarted";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="Log(\"Started\")";
Debug.ShouldStop(65536);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Started")));
 BA.debugLineNum = 82;BA.debugLine="CallSub(info,\"c_start\")";
Debug.ShouldStop(131072);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._info.getObject())),(Object)(RemoteObject.createImmutable("c_start")));
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clean_start() throws Exception{
try {
		Debug.PushSubsStack("clean_start (starter) ","starter",3,starter.processBA,starter.mostCurrent,137);
if (RapidSub.canDelegate("clean_start")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","clean_start");
 BA.debugLineNum = 137;BA.debugLine="Sub clean_start";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="cb.CleanCache";
Debug.ShouldStop(512);
starter._cb.runVoidMethod ("CleanCache");
 BA.debugLineNum = 139;BA.debugLine="CallSub(info,\"c_clean\")";
Debug.ShouldStop(1024);
starter.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",starter.processBA,(Object)((starter.mostCurrent._info.getObject())),(Object)(RemoteObject.createImmutable("c_clean")));
 BA.debugLineNum = 140;BA.debugLine="Log(\"start\")";
Debug.ShouldStop(2048);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("start")));
 BA.debugLineNum = 141;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("FormatFileSize (starter) ","starter",3,starter.processBA,starter.mostCurrent,155);
if (RapidSub.canDelegate("formatfilesize")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","formatfilesize", _bytes);
RemoteObject _unit = null;
RemoteObject _po = RemoteObject.createImmutable(0);
RemoteObject _si = RemoteObject.createImmutable(0);
RemoteObject _i = RemoteObject.createImmutable(0);
Debug.locals.put("Bytes", _bytes);
 BA.debugLineNum = 155;BA.debugLine="Sub FormatFileSize(Bytes As Float) As String";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 156;BA.debugLine="Private Unit() As String = Array As String(\" Byte";
Debug.ShouldStop(134217728);
_unit = RemoteObject.createNewArray("String",new int[] {9},new Object[] {BA.ObjectToString(" Byte"),BA.ObjectToString(" KB"),BA.ObjectToString(" MB"),BA.ObjectToString(" GB"),BA.ObjectToString(" TB"),BA.ObjectToString(" PB"),BA.ObjectToString(" EB"),BA.ObjectToString(" ZB"),RemoteObject.createImmutable(" YB")});Debug.locals.put("Unit", _unit);Debug.locals.put("Unit", _unit);
 BA.debugLineNum = 157;BA.debugLine="If Bytes = 0 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_bytes,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 158;BA.debugLine="Return \"0 Bytes\"";
Debug.ShouldStop(536870912);
if (true) return BA.ObjectToString("0 Bytes");
 }else {
 BA.debugLineNum = 160;BA.debugLine="Private Po, Si As Double";
Debug.ShouldStop(-2147483648);
_po = RemoteObject.createImmutable(0);Debug.locals.put("Po", _po);
_si = RemoteObject.createImmutable(0);Debug.locals.put("Si", _si);
 BA.debugLineNum = 161;BA.debugLine="Private I As Int";
Debug.ShouldStop(1);
_i = RemoteObject.createImmutable(0);Debug.locals.put("I", _i);
 BA.debugLineNum = 162;BA.debugLine="Bytes = Abs(Bytes)";
Debug.ShouldStop(2);
_bytes = BA.numberCast(float.class, starter.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, _bytes))));Debug.locals.put("Bytes", _bytes);
 BA.debugLineNum = 163;BA.debugLine="I = Floor(Logarithm(Bytes, 1024))";
Debug.ShouldStop(4);
_i = BA.numberCast(int.class, starter.mostCurrent.__c.runMethod(true,"Floor",(Object)(starter.mostCurrent.__c.runMethod(true,"Logarithm",(Object)(BA.numberCast(double.class, _bytes)),(Object)(BA.numberCast(double.class, 1024))))));Debug.locals.put("I", _i);
 BA.debugLineNum = 164;BA.debugLine="Po = Power(1024, I)";
Debug.ShouldStop(8);
_po = starter.mostCurrent.__c.runMethod(true,"Power",(Object)(BA.numberCast(double.class, 1024)),(Object)(BA.numberCast(double.class, _i)));Debug.locals.put("Po", _po);
 BA.debugLineNum = 165;BA.debugLine="Si = Bytes / Po";
Debug.ShouldStop(16);
_si = RemoteObject.solve(new RemoteObject[] {_bytes,_po}, "/",0, 0);Debug.locals.put("Si", _si);
 BA.debugLineNum = 166;BA.debugLine="Return NumberFormat(Si, 1, 2) & Unit(I)";
Debug.ShouldStop(32);
if (true) return RemoteObject.concat(starter.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_si),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2))),_unit.getArrayElement(true,_i));
 };
 BA.debugLineNum = 168;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _info_remote() throws Exception{
try {
		Debug.PushSubsStack("info_remote (starter) ","starter",3,starter.processBA,starter.mostCurrent,66);
if (RapidSub.canDelegate("info_remote")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","info_remote");
 BA.debugLineNum = 66;BA.debugLine="Sub info_remote";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="apli=pack.GetInstalledPackages";
Debug.ShouldStop(4);
starter._apli = starter._pack.runMethod(false,"GetInstalledPackages");
 BA.debugLineNum = 68;BA.debugLine="kvst.Put(\"ta\",apli.Size)";
Debug.ShouldStop(8);
starter._kvst.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("ta")),(Object)((starter._apli.runMethod(true,"getSize"))));
 BA.debugLineNum = 69;BA.debugLine="Log(\"added: \"&kvst.Get(\"ta\"))";
Debug.ShouldStop(16);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("added: "),starter._kvst.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("ta"))))));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private cb As CacheCleaner";
starter._cb = RemoteObject.createNew ("anywheresoftware.b4a.cachecleaner.CacheCleaner");
 //BA.debugLineNum = 9;BA.debugLine="Dim t2,t3 As Timer";
starter._t2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
starter._t3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 10;BA.debugLine="Private name,apath,l,Types(1),packName As String";
starter._name = RemoteObject.createImmutable("");
starter._apath = RemoteObject.createImmutable("");
starter._l = RemoteObject.createImmutable("");
starter._types = RemoteObject.createNewArray ("String", new int[] {1}, new Object[]{});
starter._packname = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="Dim app() As Object";
starter._app = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 12;BA.debugLine="Dim counter As Int";
starter._counter = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 13;BA.debugLine="Private cts As CustomToast";
starter._cts = RemoteObject.createNew ("com.rootsoft.customtoast.CustomToast");
 //BA.debugLineNum = 14;BA.debugLine="Dim piclist As List";
starter._piclist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 15;BA.debugLine="Dim obj As List";
starter._obj = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 16;BA.debugLine="Dim date,time As String";
starter._date = RemoteObject.createImmutable("");
starter._time = RemoteObject.createImmutable("");
 //BA.debugLineNum = 17;BA.debugLine="Dim dir As String=File.DirInternal&\"/Bdata\"";
starter._dir = RemoteObject.concat(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"),RemoteObject.createImmutable("/Bdata"));
 //BA.debugLineNum = 18;BA.debugLine="Private kvst,kvsdata,alist,dbase,abase As KeyValu";
starter._kvst = RemoteObject.createNew ("de.sclean.keyvaluestore");
starter._kvsdata = RemoteObject.createNew ("de.sclean.keyvaluestore");
starter._alist = RemoteObject.createNew ("de.sclean.keyvaluestore");
starter._dbase = RemoteObject.createNew ("de.sclean.keyvaluestore");
starter._abase = RemoteObject.createNew ("de.sclean.keyvaluestore");
 //BA.debugLineNum = 19;BA.debugLine="Private apli As List";
starter._apli = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 20;BA.debugLine="Private pack As PackageManager";
starter._pack = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _remote_start() throws Exception{
try {
		Debug.PushSubsStack("remote_start (starter) ","starter",3,starter.processBA,starter.mostCurrent,72);
if (RapidSub.canDelegate("remote_start")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","remote_start");
 BA.debugLineNum = 72;BA.debugLine="Sub remote_start";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="cb.ScanCache";
Debug.ShouldStop(256);
starter._cb.runVoidMethod ("ScanCache");
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
public static RemoteObject  _rv_off() throws Exception{
try {
		Debug.PushSubsStack("rv_off (starter) ","starter",3,starter.processBA,starter.mostCurrent,62);
if (RapidSub.canDelegate("rv_off")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","rv_off");
 BA.debugLineNum = 62;BA.debugLine="Sub rv_off";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="StopService(info)";
Debug.ShouldStop(1073741824);
starter.mostCurrent.__c.runVoidMethod ("StopService",starter.processBA,(Object)((starter.mostCurrent._info.getObject())));
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rv_on() throws Exception{
try {
		Debug.PushSubsStack("rv_on (starter) ","starter",3,starter.processBA,starter.mostCurrent,59);
if (RapidSub.canDelegate("rv_on")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","rv_on");
 BA.debugLineNum = 59;BA.debugLine="Sub rv_on";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="StartService(info)";
Debug.ShouldStop(134217728);
starter.mostCurrent.__c.runVoidMethod ("StartService",starter.processBA,(Object)((starter.mostCurrent._info.getObject())));
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Service_Create (starter) ","starter",3,starter.processBA,starter.mostCurrent,23);
if (RapidSub.canDelegate("service_create")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","service_create");
 BA.debugLineNum = 23;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="DateTime.TimeFormat=\"HH:mm\"";
Debug.ShouldStop(16777216);
starter.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 BA.debugLineNum = 26;BA.debugLine="DateTime.DateFormat=\"dd.MM.yyy\"";
Debug.ShouldStop(33554432);
starter.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd.MM.yyy"));
 BA.debugLineNum = 27;BA.debugLine="date=DateTime.Date(DateTime.Now)";
Debug.ShouldStop(67108864);
starter._date = starter.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(starter.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));
 BA.debugLineNum = 28;BA.debugLine="time=DateTime.Time(DateTime.Now)";
Debug.ShouldStop(134217728);
starter._time = starter.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(starter.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));
 BA.debugLineNum = 29;BA.debugLine="kvst.Initialize(File.DirInternal,\"data_time\")";
Debug.ShouldStop(268435456);
starter._kvst.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",starter.processBA,(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("data_time")));
 BA.debugLineNum = 30;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
Debug.ShouldStop(536870912);
starter._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",starter.processBA,(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("data_data")));
 BA.debugLineNum = 31;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
Debug.ShouldStop(1073741824);
starter._alist.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",starter.processBA,(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("adata_data")));
 BA.debugLineNum = 32;BA.debugLine="dbase.Initialize(File.DirInternal,\"dbase_data\")";
Debug.ShouldStop(-2147483648);
starter._dbase.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",starter.processBA,(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("dbase_data")));
 BA.debugLineNum = 33;BA.debugLine="abase.Initialize(File.DirInternal,\"abase_data\")";
Debug.ShouldStop(1);
starter._abase.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",starter.processBA,(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("abase_data")));
 BA.debugLineNum = 35;BA.debugLine="piclist.Initialize";
Debug.ShouldStop(4);
starter._piclist.runVoidMethod ("Initialize");
 BA.debugLineNum = 36;BA.debugLine="obj.Initialize";
Debug.ShouldStop(8);
starter._obj.runVoidMethod ("Initialize");
 BA.debugLineNum = 37;BA.debugLine="cb.initialize(\"cb\")";
Debug.ShouldStop(16);
starter._cb.runVoidMethod ("initialize",(Object)(RemoteObject.createImmutable("cb")),starter.processBA);
 BA.debugLineNum = 38;BA.debugLine="cts.Initialize";
Debug.ShouldStop(32);
starter._cts.runVoidMethod ("Initialize",starter.processBA);
 BA.debugLineNum = 39;BA.debugLine="apli.Initialize";
Debug.ShouldStop(64);
starter._apli.runVoidMethod ("Initialize");
 BA.debugLineNum = 40;BA.debugLine="apli=pack.GetInstalledPackages";
Debug.ShouldStop(128);
starter._apli = starter._pack.runMethod(false,"GetInstalledPackages");
 BA.debugLineNum = 41;BA.debugLine="counter=0";
Debug.ShouldStop(256);
starter._counter = BA.numberCast(int.class, 0);
 BA.debugLineNum = 42;BA.debugLine="t2.Initialize(\"t2\",1000)";
Debug.ShouldStop(512);
starter._t2.runVoidMethod ("Initialize",starter.processBA,(Object)(BA.ObjectToString("t2")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 43;BA.debugLine="t3.Initialize(\"t3\",1000)";
Debug.ShouldStop(1024);
starter._t3.runVoidMethod ("Initialize",starter.processBA,(Object)(BA.ObjectToString("t3")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 44;BA.debugLine="t3.Enabled=False";
Debug.ShouldStop(2048);
starter._t3.runMethod(true,"setEnabled",starter.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 45;BA.debugLine="If Not(File.IsDirectory(File.DirInternal,\"Bdata\")";
Debug.ShouldStop(4096);
if (starter.mostCurrent.__c.runMethod(true,"Not",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"IsDirectory",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("Bdata"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 46;BA.debugLine="File.MakeDir(File.DirInternal,\"Bdata/temp\")";
Debug.ShouldStop(8192);
starter.mostCurrent.__c.getField(false,"File").runVoidMethod ("MakeDir",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("Bdata/temp")));
 BA.debugLineNum = 47;BA.debugLine="File.WriteList(dir,\"clist.txt\",obj)";
Debug.ShouldStop(16384);
starter.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(starter._dir),(Object)(BA.ObjectToString("clist.txt")),(Object)(starter._obj));
 };
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",3,starter.processBA,starter.mostCurrent,55);
if (RapidSub.canDelegate("service_destroy")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","service_destroy");
 BA.debugLineNum = 55;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="t2.Enabled=False";
Debug.ShouldStop(8388608);
starter._t2.runMethod(true,"setEnabled",starter.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Service_Start (starter) ","starter",3,starter.processBA,starter.mostCurrent,51);
if (RapidSub.canDelegate("service_start")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 51;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wid_start() throws Exception{
try {
		Debug.PushSubsStack("wid_start (starter) ","starter",3,starter.processBA,starter.mostCurrent,76);
if (RapidSub.canDelegate("wid_start")) return de.sclean.starter.remoteMe.runUserSub(false, "starter","wid_start");
 BA.debugLineNum = 76;BA.debugLine="Sub wid_start";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="cb.ScanCache";
Debug.ShouldStop(4096);
starter._cb.runVoidMethod ("ScanCache");
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
}