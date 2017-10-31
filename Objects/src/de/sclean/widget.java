package de.sclean;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class widget extends  android.app.Service{
	public static class widget_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, widget.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static widget mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return widget.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "de.sclean", "de.sclean.widget");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "de.sclean.widget", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (widget) Create ***");
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
                    BA.LogInfo("** Service (widget) Create **");
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
    	BA.LogInfo("** Service (widget) Start **");
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
        BA.LogInfo("** Service (widget) Destroy **");
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
public static anywheresoftware.b4a.objects.RemoteViewsWrapper _rv = null;
public static de.sclean.keyvaluestore _kvsdata = null;
public static de.sclean.keyvaluestore _alist = null;
public static com.rootsoft.customtoast.CustomToast _cts = null;
public static com.tchart.materialcolors.MaterialColors _mcl = null;
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.info _info = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;
public static String  _rv_restart() throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "rv_restart"))
	return (String) Debug.delegate(processBA, "rv_restart", null);
anywheresoftware.b4a.objects.drawable.BitmapDrawable _icon = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _icon2 = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pac = null;
int _sum = 0;
String _g = "";
RDebugUtils.currentLine=7274496;
 //BA.debugLineNum = 7274496;BA.debugLine="Sub rv_restart";
RDebugUtils.currentLine=7274497;
 //BA.debugLineNum = 7274497;BA.debugLine="Dim icon As BitmapDrawable";
_icon = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=7274498;
 //BA.debugLineNum = 7274498;BA.debugLine="Dim icon2 As Bitmap";
_icon2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=7274499;
 //BA.debugLineNum = 7274499;BA.debugLine="Dim pac As PackageManager";
_pac = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=7274500;
 //BA.debugLineNum = 7274500;BA.debugLine="rv.SetVisible(\"pb1\",False)";
_rv.SetVisible(processBA,"pb1",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7274501;
 //BA.debugLineNum = 7274501;BA.debugLine="rv.SetVisible(\"l2\",False)";
_rv.SetVisible(processBA,"l2",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7274502;
 //BA.debugLineNum = 7274502;BA.debugLine="rv.SetVisible(\"b1\",True)";
_rv.SetVisible(processBA,"b1",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7274503;
 //BA.debugLineNum = 7274503;BA.debugLine="Dim sum As Int=0";
_sum = (int) (0);
RDebugUtils.currentLine=7274504;
 //BA.debugLineNum = 7274504;BA.debugLine="For Each g As String In alist.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group8 = _alist._listkeys(null);
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_g = BA.ObjectToString(group8.Get(index8));
RDebugUtils.currentLine=7274505;
 //BA.debugLineNum = 7274505;BA.debugLine="Log(FormatFileSize(alist.Get(g)))";
anywheresoftware.b4a.keywords.Common.Log(_formatfilesize((float)(BA.ObjectToNumber(_alist._get(null,_g)))));
RDebugUtils.currentLine=7274506;
 //BA.debugLineNum = 7274506;BA.debugLine="sum=sum+alist.Get(g)";
_sum = (int) (_sum+(double)(BA.ObjectToNumber(_alist._get(null,_g))));
RDebugUtils.currentLine=7274507;
 //BA.debugLineNum = 7274507;BA.debugLine="icon=pac.GetApplicationIcon(g)";
_icon.setObject((android.graphics.drawable.BitmapDrawable)(_pac.GetApplicationIcon(_g)));
 }
};
RDebugUtils.currentLine=7274510;
 //BA.debugLineNum = 7274510;BA.debugLine="End Sub";
return "";
}
public static String  _rv_clean() throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "rv_clean"))
	return (String) Debug.delegate(processBA, "rv_clean", null);
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Sub rv_clean";
RDebugUtils.currentLine=7536641;
 //BA.debugLineNum = 7536641;BA.debugLine="CallSubDelayed(Starter,\"clean_start\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._starter.getObject()),"clean_start");
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="End Sub";
return "";
}
public static String  _prog_update() throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "prog_update"))
	return (String) Debug.delegate(processBA, "prog_update", null);
int _cc = 0;
int _c = 0;
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Sub prog_update";
RDebugUtils.currentLine=7405569;
 //BA.debugLineNum = 7405569;BA.debugLine="Dim cc,c As Int";
_cc = 0;
_c = 0;
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="c=kvsdata.Get(\"c\")";
_c = (int)(BA.ObjectToNumber(_kvsdata._get(null,"c")));
RDebugUtils.currentLine=7405571;
 //BA.debugLineNum = 7405571;BA.debugLine="cc=kvsdata.Get(\"to\")";
_cc = (int)(BA.ObjectToNumber(_kvsdata._get(null,"to")));
RDebugUtils.currentLine=7405573;
 //BA.debugLineNum = 7405573;BA.debugLine="rv.SetText(\"l2\",c&CRLF&\"/\"&cc)";
_rv.SetText(processBA,"l2",BA.ObjectToCharSequence(BA.NumberToString(_c)+anywheresoftware.b4a.keywords.Common.CRLF+"/"+BA.NumberToString(_cc)));
RDebugUtils.currentLine=7405574;
 //BA.debugLineNum = 7405574;BA.debugLine="End Sub";
return "";
}
public static String  _b1_click() throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "b1_click"))
	return (String) Debug.delegate(processBA, "b1_click", null);
RDebugUtils.currentLine=7340032;
 //BA.debugLineNum = 7340032;BA.debugLine="Sub b1_Click";
RDebugUtils.currentLine=7340033;
 //BA.debugLineNum = 7340033;BA.debugLine="CallSubDelayed(Starter,\"wid_start\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._starter.getObject()),"wid_start");
RDebugUtils.currentLine=7340034;
 //BA.debugLineNum = 7340034;BA.debugLine="rv.SetVisible(\"pb1\",True)";
_rv.SetVisible(processBA,"pb1",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7340035;
 //BA.debugLineNum = 7340035;BA.debugLine="rv.SetVisible(\"l2\",True)";
_rv.SetVisible(processBA,"l2",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7340036;
 //BA.debugLineNum = 7340036;BA.debugLine="rv.SetVisible(\"b1\",False)";
_rv.SetVisible(processBA,"b1",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7340037;
 //BA.debugLineNum = 7340037;BA.debugLine="rv_requestUpdate";
_rv_requestupdate();
RDebugUtils.currentLine=7340038;
 //BA.debugLineNum = 7340038;BA.debugLine="End Sub";
return "";
}
public static String  _rv_requestupdate() throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "rv_requestupdate"))
	return (String) Debug.delegate(processBA, "rv_requestupdate", null);
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Sub rv_requestUpdate";
RDebugUtils.currentLine=7077889;
 //BA.debugLineNum = 7077889;BA.debugLine="rv.UpdateWidget";
_rv.UpdateWidget(processBA);
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="End Sub";
return "";
}
public static String  _formatfilesize(float _bytes) throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "formatfilesize"))
	return (String) Debug.delegate(processBA, "formatfilesize", new Object[] {_bytes});
String[] _unit = null;
double _po = 0;
double _si = 0;
int _i = 0;
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Sub FormatFileSize(Bytes As Float) As String";
RDebugUtils.currentLine=7602177;
 //BA.debugLineNum = 7602177;BA.debugLine="Private Unit() As String = Array As String(\" Byte";
_unit = new String[]{" Byte"," KB"," MB"," GB"," TB"," PB"," EB"," ZB"," YB"};
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="If Bytes = 0 Then";
if (_bytes==0) { 
RDebugUtils.currentLine=7602179;
 //BA.debugLineNum = 7602179;BA.debugLine="Return \"0 Bytes\"";
if (true) return "0 Bytes";
 }else {
RDebugUtils.currentLine=7602181;
 //BA.debugLineNum = 7602181;BA.debugLine="Private Po, Si As Double";
_po = 0;
_si = 0;
RDebugUtils.currentLine=7602182;
 //BA.debugLineNum = 7602182;BA.debugLine="Private I As Int";
_i = 0;
RDebugUtils.currentLine=7602183;
 //BA.debugLineNum = 7602183;BA.debugLine="Bytes = Abs(Bytes)";
_bytes = (float) (anywheresoftware.b4a.keywords.Common.Abs(_bytes));
RDebugUtils.currentLine=7602184;
 //BA.debugLineNum = 7602184;BA.debugLine="I = Floor(Logarithm(Bytes, 1024))";
_i = (int) (anywheresoftware.b4a.keywords.Common.Floor(anywheresoftware.b4a.keywords.Common.Logarithm(_bytes,1024)));
RDebugUtils.currentLine=7602185;
 //BA.debugLineNum = 7602185;BA.debugLine="Po = Power(1024, I)";
_po = anywheresoftware.b4a.keywords.Common.Power(1024,_i);
RDebugUtils.currentLine=7602186;
 //BA.debugLineNum = 7602186;BA.debugLine="Si = Bytes / Po";
_si = _bytes/(double)_po;
RDebugUtils.currentLine=7602187;
 //BA.debugLineNum = 7602187;BA.debugLine="Return NumberFormat(Si, 1, 2) & Unit(I)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_si,(int) (1),(int) (2))+_unit[_i];
 };
RDebugUtils.currentLine=7602189;
 //BA.debugLineNum = 7602189;BA.debugLine="End Sub";
return "";
}
public static String  _rv_disabled() throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "rv_disabled"))
	return (String) Debug.delegate(processBA, "rv_disabled", null);
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Sub rv_Disabled";
RDebugUtils.currentLine=7143425;
 //BA.debugLineNum = 7143425;BA.debugLine="StopService(\"\")";
anywheresoftware.b4a.keywords.Common.StopService(processBA,(Object)(""));
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "service_create"))
	return (String) Debug.delegate(processBA, "service_create", null);
b4a.example.osstats _ostat = null;
com.maximussoft.msos.MSOS _mos = null;
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=6946817;
 //BA.debugLineNum = 6946817;BA.debugLine="rv= ConfigureHomeWidget(\"wv\",\"rv\",0,\"SBoost\",True";
_rv = anywheresoftware.b4a.objects.RemoteViewsWrapper.createRemoteViews(processBA, R.layout.widget_layout, "wv","rv");
RDebugUtils.currentLine=6946818;
 //BA.debugLineNum = 6946818;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
_kvsdata._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_data");
RDebugUtils.currentLine=6946819;
 //BA.debugLineNum = 6946819;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
_alist._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"adata_data");
RDebugUtils.currentLine=6946820;
 //BA.debugLineNum = 6946820;BA.debugLine="cts.Initialize";
_cts.Initialize(processBA);
RDebugUtils.currentLine=6946821;
 //BA.debugLineNum = 6946821;BA.debugLine="Private ostat As OSStats";
_ostat = new b4a.example.osstats();
RDebugUtils.currentLine=6946822;
 //BA.debugLineNum = 6946822;BA.debugLine="Private mos As MSOS";
_mos = new com.maximussoft.msos.MSOS();
RDebugUtils.currentLine=6946823;
 //BA.debugLineNum = 6946823;BA.debugLine="ostat.Initialize(400, 50, Me, \"Stats\")";
_ostat._initialize(processBA,(int) (400),(int) (50),widget.getObject(),"Stats");
RDebugUtils.currentLine=6946824;
 //BA.debugLineNum = 6946824;BA.debugLine="ostat.StartStats";
_ostat._startstats();
RDebugUtils.currentLine=6946825;
 //BA.debugLineNum = 6946825;BA.debugLine="rv.SetVisible(\"b1\",True)";
_rv.SetVisible(processBA,"b1",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6946826;
 //BA.debugLineNum = 6946826;BA.debugLine="rv.SetVisible(\"p1\",True)";
_rv.SetVisible(processBA,"p1",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6946827;
 //BA.debugLineNum = 6946827;BA.debugLine="rv.SetVisible(\"pb1\",False)";
_rv.SetVisible(processBA,"pb1",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6946828;
 //BA.debugLineNum = 6946828;BA.debugLine="rv.SetVisible(\"l2\",False)";
_rv.SetVisible(processBA,"l2",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6946829;
 //BA.debugLineNum = 6946829;BA.debugLine="rv.SetTextColor(\"l2\",mcl.md_amber_400)";
_rv.SetTextColor(processBA,"l2",_mcl.getmd_amber_400());
RDebugUtils.currentLine=6946830;
 //BA.debugLineNum = 6946830;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "service_destroy"))
	return (String) Debug.delegate(processBA, "service_destroy", null);
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "service_start"))
	return (String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent});
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=7012353;
 //BA.debugLineNum = 7012353;BA.debugLine="If rv.HandleWidgetEvents(StartingIntent) Then Ret";
if (_rv.HandleWidgetEvents(processBA,(android.content.Intent)(_startingintent.getObject()))) { 
if (true) return "";};
RDebugUtils.currentLine=7012355;
 //BA.debugLineNum = 7012355;BA.debugLine="End Sub";
return "";
}
public static String  _stats_update(float[] _cpuefficiency,float _ramusage) throws Exception{
RDebugUtils.currentModule="widget";
if (Debug.shouldDelegate(processBA, "stats_update"))
	return (String) Debug.delegate(processBA, "stats_update", new Object[] {_cpuefficiency,_ramusage});
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Sub stats_Update(CPUEfficiency() As Float, RAMUsag";
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="rv.SetText(\"b1\",FormatFileSize(RAMUsage*1024*1024";
_rv.SetText(processBA,"b1",BA.ObjectToCharSequence(_formatfilesize((float) (_ramusage*1024*1024*10))));
RDebugUtils.currentLine=7471107;
 //BA.debugLineNum = 7471107;BA.debugLine="rv_requestUpdate";
_rv_requestupdate();
RDebugUtils.currentLine=7471108;
 //BA.debugLineNum = 7471108;BA.debugLine="End Sub";
return "";
}
}