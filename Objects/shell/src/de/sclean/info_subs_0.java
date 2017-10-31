package de.sclean;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class info_subs_0 {


public static RemoteObject  _c_clean() throws Exception{
try {
		Debug.PushSubsStack("c_clean (info) ","info",4,info.processBA,info.mostCurrent,48);
if (RapidSub.canDelegate("c_clean")) return de.sclean.info.remoteMe.runUserSub(false, "info","c_clean");
 BA.debugLineNum = 48;BA.debugLine="Sub c_clean";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="notify.SetInfo(\"löche cache daten:\",\"einen Moment";
Debug.ShouldStop(65536);
info._notify.runVoidMethod ("SetInfo",info.processBA,(Object)(BA.ObjectToString("löche cache daten:")),(Object)(BA.ObjectToString("einen Moment bitte..")),(Object)((info.mostCurrent._main.getObject())));
 BA.debugLineNum = 50;BA.debugLine="notify.Notify(1)";
Debug.ShouldStop(131072);
info._notify.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _c_ready() throws Exception{
try {
		Debug.PushSubsStack("c_ready (info) ","info",4,info.processBA,info.mostCurrent,53);
if (RapidSub.canDelegate("c_ready")) return de.sclean.info.remoteMe.runUserSub(false, "info","c_ready");
 BA.debugLineNum = 53;BA.debugLine="Sub c_ready";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="notify.SetInfo(\"Fertig!\",alist.ListKeys.Size&\" Ap";
Debug.ShouldStop(4194304);
info._notify.runVoidMethod ("SetInfo",info.processBA,(Object)(BA.ObjectToString("Fertig!")),(Object)(RemoteObject.concat(info._alist.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys").runMethod(true,"getSize"),RemoteObject.createImmutable(" Apps mit bereinigt!"))),(Object)((info.mostCurrent._main.getObject())));
 BA.debugLineNum = 56;BA.debugLine="notify.Notify(1)";
Debug.ShouldStop(8388608);
info._notify.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
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
public static RemoteObject  _c_start() throws Exception{
try {
		Debug.PushSubsStack("c_start (info) ","info",4,info.processBA,info.mostCurrent,36);
if (RapidSub.canDelegate("c_start")) return de.sclean.info.remoteMe.runUserSub(false, "info","c_start");
 BA.debugLineNum = 36;BA.debugLine="Sub c_start";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="notify.SetInfo(\"Suche gestartet:\",\"durchsuche App";
Debug.ShouldStop(16);
info._notify.runVoidMethod ("SetInfo",info.processBA,(Object)(BA.ObjectToString("Suche gestartet:")),(Object)(BA.ObjectToString("durchsuche Apps..")),(Object)((info.mostCurrent._main.getObject())));
 BA.debugLineNum = 38;BA.debugLine="notify.Notify(1)";
Debug.ShouldStop(32);
info._notify.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _c_update() throws Exception{
try {
		Debug.PushSubsStack("c_update (info) ","info",4,info.processBA,info.mostCurrent,41);
if (RapidSub.canDelegate("c_update")) return de.sclean.info.remoteMe.runUserSub(false, "info","c_update");
RemoteObject _cc = RemoteObject.createImmutable(0);
 BA.debugLineNum = 41;BA.debugLine="Sub c_update";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="Dim cc As Int";
Debug.ShouldStop(512);
_cc = RemoteObject.createImmutable(0);Debug.locals.put("cc", _cc);
 BA.debugLineNum = 43;BA.debugLine="cc=kvsdata.Get(\"c\")";
Debug.ShouldStop(1024);
_cc = BA.numberCast(int.class, info._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("c"))));Debug.locals.put("cc", _cc);
 BA.debugLineNum = 44;BA.debugLine="notify.SetInfo(cc&\" durchsucht\",\"suche nach App c";
Debug.ShouldStop(2048);
info._notify.runVoidMethod ("SetInfo",info.processBA,(Object)(RemoteObject.concat(_cc,RemoteObject.createImmutable(" durchsucht"))),(Object)(BA.ObjectToString("suche nach App cache..")),(Object)((info.mostCurrent._main.getObject())));
 BA.debugLineNum = 45;BA.debugLine="notify.Notify(1)";
Debug.ShouldStop(4096);
info._notify.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private notify As Notification";
info._notify = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");
 //BA.debugLineNum = 10;BA.debugLine="Private kvsdata As KeyValueStore";
info._kvsdata = RemoteObject.createNew ("de.sclean.keyvaluestore");
 //BA.debugLineNum = 11;BA.debugLine="Private alist As KeyValueStore";
info._alist = RemoteObject.createNew ("de.sclean.keyvaluestore");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (info) ","info",4,info.processBA,info.mostCurrent,14);
if (RapidSub.canDelegate("service_create")) return de.sclean.info.remoteMe.runUserSub(false, "info","service_create");
 BA.debugLineNum = 14;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(8192);
 BA.debugLineNum = 15;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
Debug.ShouldStop(16384);
info._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",info.processBA,(Object)(info.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("data_data")));
 BA.debugLineNum = 16;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
Debug.ShouldStop(32768);
info._alist.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",info.processBA,(Object)(info.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("adata_data")));
 BA.debugLineNum = 17;BA.debugLine="notify.Initialize";
Debug.ShouldStop(65536);
info._notify.runVoidMethod ("Initialize");
 BA.debugLineNum = 18;BA.debugLine="notify.Icon=\"icon\"";
Debug.ShouldStop(131072);
info._notify.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 19;BA.debugLine="notify.Number=1";
Debug.ShouldStop(262144);
info._notify.runMethod(true,"setNumber",BA.numberCast(int.class, 1));
 BA.debugLineNum = 20;BA.debugLine="notify.AutoCancel=True";
Debug.ShouldStop(524288);
info._notify.runVoidMethod ("setAutoCancel",info.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 21;BA.debugLine="notify.Light=False";
Debug.ShouldStop(1048576);
info._notify.runVoidMethod ("setLight",info.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 22;BA.debugLine="notify.Sound=False";
Debug.ShouldStop(2097152);
info._notify.runVoidMethod ("setSound",info.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 23;BA.debugLine="notify.Vibrate=False";
Debug.ShouldStop(4194304);
info._notify.runVoidMethod ("setVibrate",info.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Service_Destroy (info) ","info",4,info.processBA,info.mostCurrent,31);
if (RapidSub.canDelegate("service_destroy")) return de.sclean.info.remoteMe.runUserSub(false, "info","service_destroy");
 BA.debugLineNum = 31;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="notify.Cancel(1)";
Debug.ShouldStop(-2147483648);
info._notify.runVoidMethod ("Cancel",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Service_Start (info) ","info",4,info.processBA,info.mostCurrent,26);
if (RapidSub.canDelegate("service_start")) return de.sclean.info.remoteMe.runUserSub(false, "info","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 26;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="notify.SetInfo(\"Cleaner Service:\",\"der Cleaner Se";
Debug.ShouldStop(67108864);
info._notify.runVoidMethod ("SetInfo",info.processBA,(Object)(BA.ObjectToString("Cleaner Service:")),(Object)(BA.ObjectToString("der Cleaner Service wurde erfolgreich gestartet")),(Object)((info.mostCurrent._main.getObject())));
 BA.debugLineNum = 28;BA.debugLine="notify.Notify(1)";
Debug.ShouldStop(134217728);
info._notify.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
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
}