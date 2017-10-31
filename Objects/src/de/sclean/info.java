package de.sclean;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class info extends  android.app.Service{
	public static class info_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, info.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static info mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return info.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "de.sclean", "de.sclean.info");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "de.sclean.info", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (info) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (info) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (info) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = new anywheresoftware.b4a.objects.IntentWrapper();
    			if (intent != null) {
    				if (intent.hasExtra("b4a_internal_intent"))
    					iw.setObject((android.content.Intent) intent.getParcelableExtra("b4a_internal_intent"));
    				else
    					iw.setObject(intent);
    			}
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        BA.LogInfo("** Service (info) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.NotificationWrapper _notify = null;
public static de.sclean.keyvaluestore _kvsdata = null;
public static de.sclean.keyvaluestore _alist = null;
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;
public static String  _c_ready() throws Exception{
RDebugUtils.currentModule="info";
if (Debug.shouldDelegate(processBA, "c_ready"))
	return (String) Debug.delegate(processBA, "c_ready", null);
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub c_ready";
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="notify.SetInfo(\"Fertig!\",alist.ListKeys.Size&\" Ap";
_notify.SetInfo(processBA,"Fertig!",BA.NumberToString(_alist._listkeys(null).getSize())+" Apps mit bereinigt!",(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="notify.Notify(1)";
_notify.Notify((int) (1));
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="End Sub";
return "";
}
public static String  _c_update() throws Exception{
RDebugUtils.currentModule="info";
if (Debug.shouldDelegate(processBA, "c_update"))
	return (String) Debug.delegate(processBA, "c_update", null);
int _cc = 0;
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub c_update";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Dim cc As Int";
_cc = 0;
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="cc=kvsdata.Get(\"c\")";
_cc = (int)(BA.ObjectToNumber(_kvsdata._get(null,"c")));
RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="notify.SetInfo(cc&\" durchsucht\",\"suche nach App c";
_notify.SetInfo(processBA,BA.NumberToString(_cc)+" durchsucht","suche nach App cache..",(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="notify.Notify(1)";
_notify.Notify((int) (1));
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="End Sub";
return "";
}
public static String  _c_start() throws Exception{
RDebugUtils.currentModule="info";
if (Debug.shouldDelegate(processBA, "c_start"))
	return (String) Debug.delegate(processBA, "c_start", null);
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Sub c_start";
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="notify.SetInfo(\"Suche gestartet:\",\"durchsuche App";
_notify.SetInfo(processBA,"Suche gestartet:","durchsuche Apps..",(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="notify.Notify(1)";
_notify.Notify((int) (1));
RDebugUtils.currentLine=5636099;
 //BA.debugLineNum = 5636099;BA.debugLine="End Sub";
return "";
}
public static String  _c_clean() throws Exception{
RDebugUtils.currentModule="info";
if (Debug.shouldDelegate(processBA, "c_clean"))
	return (String) Debug.delegate(processBA, "c_clean", null);
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub c_clean";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="notify.SetInfo(\"löche cache daten:\",\"einen Moment";
_notify.SetInfo(processBA,"löche cache daten:","einen Moment bitte..",(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="notify.Notify(1)";
_notify.Notify((int) (1));
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="info";
if (Debug.shouldDelegate(processBA, "service_create"))
	return (String) Debug.delegate(processBA, "service_create", null);
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
_kvsdata._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_data");
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
_alist._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"adata_data");
RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="notify.Initialize";
_notify.Initialize();
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="notify.Icon=\"icon\"";
_notify.setIcon("icon");
RDebugUtils.currentLine=5439493;
 //BA.debugLineNum = 5439493;BA.debugLine="notify.Number=1";
_notify.setNumber((int) (1));
RDebugUtils.currentLine=5439494;
 //BA.debugLineNum = 5439494;BA.debugLine="notify.AutoCancel=True";
_notify.setAutoCancel(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="notify.Light=False";
_notify.setLight(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439496;
 //BA.debugLineNum = 5439496;BA.debugLine="notify.Sound=False";
_notify.setSound(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439497;
 //BA.debugLineNum = 5439497;BA.debugLine="notify.Vibrate=False";
_notify.setVibrate(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439498;
 //BA.debugLineNum = 5439498;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="info";
if (Debug.shouldDelegate(processBA, "service_destroy"))
	return (String) Debug.delegate(processBA, "service_destroy", null);
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="notify.Cancel(1)";
_notify.Cancel((int) (1));
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="info";
if (Debug.shouldDelegate(processBA, "service_start"))
	return (String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent});
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="notify.SetInfo(\"Cleaner Service:\",\"der Cleaner Se";
_notify.SetInfo(processBA,"Cleaner Service:","der Cleaner Service wurde erfolgreich gestartet",(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="notify.Notify(1)";
_notify.Notify((int) (1));
RDebugUtils.currentLine=5505027;
 //BA.debugLineNum = 5505027;BA.debugLine="End Sub";
return "";
}
}