package de.sclean;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends  android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "de.sclean", "de.sclean.starter");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "de.sclean.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
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
                    BA.LogInfo("** Service (starter) Create **");
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
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
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
        BA.LogInfo("** Service (starter) Destroy **");
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
public static anywheresoftware.b4a.cachecleaner.CacheCleaner _cb = null;
public static anywheresoftware.b4a.objects.Timer _t2 = null;
public static anywheresoftware.b4a.objects.Timer _t3 = null;
public static String _name = "";
public static String _apath = "";
public static String _l = "";
public static String[] _types = null;
public static String _packname = "";
public static Object[] _app = null;
public static int _counter = 0;
public static com.rootsoft.customtoast.CustomToast _cts = null;
public static anywheresoftware.b4a.objects.collections.List _piclist = null;
public static anywheresoftware.b4a.objects.collections.List _obj = null;
public static String _date = "";
public static String _time = "";
public static String _dir = "";
public static de.sclean.keyvaluestore _kvst = null;
public static de.sclean.keyvaluestore _kvsdata = null;
public static de.sclean.keyvaluestore _alist = null;
public static de.sclean.keyvaluestore _dbase = null;
public static de.sclean.keyvaluestore _abase = null;
public static anywheresoftware.b4a.objects.collections.List _apli = null;
public static anywheresoftware.b4a.phone.PackageManagerWrapper _pack = null;
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.info _info = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;
public static String  _cb_oncleancompleted(long _cachesize) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "cb_oncleancompleted"))
	return (String) Debug.delegate(processBA, "cb_oncleancompleted", new Object[] {_cachesize});
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Sub cb_onCleanCompleted(CacheSize As Long)";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="kvst.DeleteAll";
_kvst._deleteall(null);
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="info_remote";
_info_remote();
RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="CallSub(Main,\"dp_clear\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._main.getObject()),"dp_clear");
RDebugUtils.currentLine=5242884;
 //BA.debugLineNum = 5242884;BA.debugLine="CallSub(info,\"c_ready\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._info.getObject()),"c_ready");
RDebugUtils.currentLine=5242885;
 //BA.debugLineNum = 5242885;BA.debugLine="End Sub";
return "";
}
public static String  _info_remote() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "info_remote"))
	return (String) Debug.delegate(processBA, "info_remote", null);
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub info_remote";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="apli=pack.GetInstalledPackages";
_apli = _pack.GetInstalledPackages();
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="kvst.Put(\"ta\",apli.Size)";
_kvst._put(null,"ta",(Object)(_apli.getSize()));
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="Log(\"added: \"&kvst.Get(\"ta\"))";
anywheresoftware.b4a.keywords.Common.Log("added: "+BA.ObjectToString(_kvst._get(null,"ta")));
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="End Sub";
return "";
}
public static String  _cb_oncleanstarted() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "cb_oncleanstarted"))
	return (String) Debug.delegate(processBA, "cb_oncleanstarted", null);
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Sub cb_onCleanStarted";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="CallSub(Widget,\"rv_restart\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._widget.getObject()),"rv_restart");
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="Log(\"CleanStarted\")";
anywheresoftware.b4a.keywords.Common.Log("CleanStarted");
RDebugUtils.currentLine=5177347;
 //BA.debugLineNum = 5177347;BA.debugLine="End Sub";
return "";
}
public static String  _cb_onscancompleted(Object _appslist) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "cb_onscancompleted"))
	return (String) Debug.delegate(processBA, "cb_onscancompleted", new Object[] {_appslist});
long _totalsize = 0L;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _icon = null;
anywheresoftware.b4a.objects.collections.List _lu = null;
int _n = 0;
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Sub cb_onScanCompleted(AppsList As Object)";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="Dim totalsize As Long = 0";
_totalsize = (long) (0);
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="Private icon As BitmapDrawable";
_icon = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=5046277;
 //BA.debugLineNum = 5046277;BA.debugLine="piclist.Clear";
_piclist.Clear();
RDebugUtils.currentLine=5046278;
 //BA.debugLineNum = 5046278;BA.debugLine="obj.Clear";
_obj.Clear();
RDebugUtils.currentLine=5046279;
 //BA.debugLineNum = 5046279;BA.debugLine="alist.DeleteAll";
_alist._deleteall(null);
RDebugUtils.currentLine=5046280;
 //BA.debugLineNum = 5046280;BA.debugLine="Try";
try {RDebugUtils.currentLine=5046281;
 //BA.debugLineNum = 5046281;BA.debugLine="Dim lu As List = AppsList";
_lu = new anywheresoftware.b4a.objects.collections.List();
_lu.setObject((java.util.List)(_appslist));
RDebugUtils.currentLine=5046287;
 //BA.debugLineNum = 5046287;BA.debugLine="For n = 0 To lu.Size-1";
{
final int step9 = 1;
final int limit9 = (int) (_lu.getSize()-1);
_n = (int) (0) ;
for (;(step9 > 0 && _n <= limit9) || (step9 < 0 && _n >= limit9) ;_n = ((int)(0 + _n + step9))  ) {
RDebugUtils.currentLine=5046288;
 //BA.debugLineNum = 5046288;BA.debugLine="app= lu.Get(n)";
_app = (Object[])(_lu.Get(_n));
RDebugUtils.currentLine=5046289;
 //BA.debugLineNum = 5046289;BA.debugLine="If app(1) = \"com.android.systemui\"  Then  Conti";
if ((_app[(int) (1)]).equals((Object)("com.android.systemui"))) { 
if (true) continue;};
RDebugUtils.currentLine=5046290;
 //BA.debugLineNum = 5046290;BA.debugLine="icon = pm.GetApplicationIcon(app(1))";
_icon.setObject((android.graphics.drawable.BitmapDrawable)(_pm.GetApplicationIcon(BA.ObjectToString(_app[(int) (1)]))));
RDebugUtils.currentLine=5046291;
 //BA.debugLineNum = 5046291;BA.debugLine="totalsize = totalsize+app(2)";
_totalsize = (long) (_totalsize+(double)(BA.ObjectToNumber(_app[(int) (2)])));
RDebugUtils.currentLine=5046292;
 //BA.debugLineNum = 5046292;BA.debugLine="kvst.PutBitmap(app(1),icon.Bitmap)";
_kvst._putbitmap(null,BA.ObjectToString(_app[(int) (1)]),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_icon.getBitmap())));
RDebugUtils.currentLine=5046293;
 //BA.debugLineNum = 5046293;BA.debugLine="alist.Put(app(1),totalsize)";
_alist._put(null,BA.ObjectToString(_app[(int) (1)]),(Object)(_totalsize));
RDebugUtils.currentLine=5046294;
 //BA.debugLineNum = 5046294;BA.debugLine="obj.Add(app(1))";
_obj.Add(_app[(int) (1)]);
RDebugUtils.currentLine=5046295;
 //BA.debugLineNum = 5046295;BA.debugLine="kvsdata.Put(\"cs\",FormatFileSize(totalsize))";
_kvsdata._put(null,"cs",(Object)(_formatfilesize((float) (_totalsize))));
RDebugUtils.currentLine=5046296;
 //BA.debugLineNum = 5046296;BA.debugLine="kvsdata.Put(totalsize,totalsize)";
_kvsdata._put(null,BA.NumberToString(_totalsize),(Object)(_totalsize));
 }
};
 } 
       catch (Exception e21) {
			processBA.setLastException(e21);RDebugUtils.currentLine=5046300;
 //BA.debugLineNum = 5046300;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=5046302;
 //BA.debugLineNum = 5046302;BA.debugLine="If lu.size>0 Then";
if (_lu.getSize()>0) { 
RDebugUtils.currentLine=5046303;
 //BA.debugLineNum = 5046303;BA.debugLine="CallSub(Widget,\"rv_clean\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._widget.getObject()),"rv_clean");
RDebugUtils.currentLine=5046304;
 //BA.debugLineNum = 5046304;BA.debugLine="CallSub(Main,\"dp_off\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._main.getObject()),"dp_off");
 }else {
RDebugUtils.currentLine=5046306;
 //BA.debugLineNum = 5046306;BA.debugLine="CallSub(Widget,\"rv_restart\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._widget.getObject()),"rv_restart");
RDebugUtils.currentLine=5046307;
 //BA.debugLineNum = 5046307;BA.debugLine="CallSub(Widget,\"rv_restart\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._widget.getObject()),"rv_restart");
RDebugUtils.currentLine=5046308;
 //BA.debugLineNum = 5046308;BA.debugLine="CallSub(Main,\"total_off\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._main.getObject()),"total_off");
 };
RDebugUtils.currentLine=5046311;
 //BA.debugLineNum = 5046311;BA.debugLine="End Sub";
return "";
}
public static String  _formatfilesize(float _bytes) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "formatfilesize"))
	return (String) Debug.delegate(processBA, "formatfilesize", new Object[] {_bytes});
String[] _unit = null;
double _po = 0;
double _si = 0;
int _i = 0;
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Sub FormatFileSize(Bytes As Float) As String";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="Private Unit() As String = Array As String(\" Byte";
_unit = new String[]{" Byte"," KB"," MB"," GB"," TB"," PB"," EB"," ZB"," YB"};
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="If Bytes = 0 Then";
if (_bytes==0) { 
RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="Return \"0 Bytes\"";
if (true) return "0 Bytes";
 }else {
RDebugUtils.currentLine=5308421;
 //BA.debugLineNum = 5308421;BA.debugLine="Private Po, Si As Double";
_po = 0;
_si = 0;
RDebugUtils.currentLine=5308422;
 //BA.debugLineNum = 5308422;BA.debugLine="Private I As Int";
_i = 0;
RDebugUtils.currentLine=5308423;
 //BA.debugLineNum = 5308423;BA.debugLine="Bytes = Abs(Bytes)";
_bytes = (float) (anywheresoftware.b4a.keywords.Common.Abs(_bytes));
RDebugUtils.currentLine=5308424;
 //BA.debugLineNum = 5308424;BA.debugLine="I = Floor(Logarithm(Bytes, 1024))";
_i = (int) (anywheresoftware.b4a.keywords.Common.Floor(anywheresoftware.b4a.keywords.Common.Logarithm(_bytes,1024)));
RDebugUtils.currentLine=5308425;
 //BA.debugLineNum = 5308425;BA.debugLine="Po = Power(1024, I)";
_po = anywheresoftware.b4a.keywords.Common.Power(1024,_i);
RDebugUtils.currentLine=5308426;
 //BA.debugLineNum = 5308426;BA.debugLine="Si = Bytes / Po";
_si = _bytes/(double)_po;
RDebugUtils.currentLine=5308427;
 //BA.debugLineNum = 5308427;BA.debugLine="Return NumberFormat(Si, 1, 2) & Unit(I)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_si,(int) (1),(int) (2))+_unit[_i];
 };
RDebugUtils.currentLine=5308429;
 //BA.debugLineNum = 5308429;BA.debugLine="End Sub";
return "";
}
public static String  _cb_onscanprogress(int _current,int _total) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "cb_onscanprogress"))
	return (String) Debug.delegate(processBA, "cb_onscanprogress", new Object[] {_current,_total});
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub cb_onScanProgress(Current As Int , Total As In";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="kvsdata.Put(\"to\",Total)";
_kvsdata._put(null,"to",(Object)(_total));
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="kvsdata.Put(\"c\",Current)";
_kvsdata._put(null,"c",(Object)(_current));
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="CallSub(Widget,\"prog_update\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._widget.getObject()),"prog_update");
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="CallSubDelayed (Main,\"pb_update\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"pb_update");
RDebugUtils.currentLine=4980741;
 //BA.debugLineNum = 4980741;BA.debugLine="CallSub(info,\"c_update\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._info.getObject()),"c_update");
RDebugUtils.currentLine=4980742;
 //BA.debugLineNum = 4980742;BA.debugLine="Log(\"Scan: \"&Current&\" /\"&Total)";
anywheresoftware.b4a.keywords.Common.Log("Scan: "+BA.NumberToString(_current)+" /"+BA.NumberToString(_total));
RDebugUtils.currentLine=4980744;
 //BA.debugLineNum = 4980744;BA.debugLine="End Sub";
return "";
}
public static String  _cb_onscanstarted() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "cb_onscanstarted"))
	return (String) Debug.delegate(processBA, "cb_onscanstarted", null);
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub cb_OnScanStarted";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Log(\"Started\")";
anywheresoftware.b4a.keywords.Common.Log("Started");
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="CallSub(info,\"c_start\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._info.getObject()),"c_start");
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="End Sub";
return "";
}
public static String  _clean_start() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "clean_start"))
	return (String) Debug.delegate(processBA, "clean_start", null);
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Sub clean_start";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="cb.CleanCache";
_cb.CleanCache();
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="CallSub(info,\"c_clean\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._info.getObject()),"c_clean");
RDebugUtils.currentLine=5111811;
 //BA.debugLineNum = 5111811;BA.debugLine="Log(\"start\")";
anywheresoftware.b4a.keywords.Common.Log("start");
RDebugUtils.currentLine=5111812;
 //BA.debugLineNum = 5111812;BA.debugLine="End Sub";
return "";
}
public static String  _remote_start() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "remote_start"))
	return (String) Debug.delegate(processBA, "remote_start", null);
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub remote_start";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="cb.ScanCache";
_cb.ScanCache();
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="End Sub";
return "";
}
public static String  _rv_off() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "rv_off"))
	return (String) Debug.delegate(processBA, "rv_off", null);
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub rv_off";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="StopService(info)";
anywheresoftware.b4a.keywords.Common.StopService(processBA,(Object)(mostCurrent._info.getObject()));
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="End Sub";
return "";
}
public static String  _rv_on() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "rv_on"))
	return (String) Debug.delegate(processBA, "rv_on", null);
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub rv_on";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="StartService(info)";
anywheresoftware.b4a.keywords.Common.StartService(processBA,(Object)(mostCurrent._info.getObject()));
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_create"))
	return (String) Debug.delegate(processBA, "service_create", null);
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="DateTime.TimeFormat=\"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="DateTime.DateFormat=\"dd.MM.yyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd.MM.yyy");
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="date=DateTime.Date(DateTime.Now)";
_date = anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="time=DateTime.Time(DateTime.Now)";
_time = anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="kvst.Initialize(File.DirInternal,\"data_time\")";
_kvst._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_time");
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
_kvsdata._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_data");
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
_alist._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"adata_data");
RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="dbase.Initialize(File.DirInternal,\"dbase_data\")";
_dbase._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"dbase_data");
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="abase.Initialize(File.DirInternal,\"abase_data\")";
_abase._initialize(null,processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"abase_data");
RDebugUtils.currentLine=4390924;
 //BA.debugLineNum = 4390924;BA.debugLine="piclist.Initialize";
_piclist.Initialize();
RDebugUtils.currentLine=4390925;
 //BA.debugLineNum = 4390925;BA.debugLine="obj.Initialize";
_obj.Initialize();
RDebugUtils.currentLine=4390926;
 //BA.debugLineNum = 4390926;BA.debugLine="cb.initialize(\"cb\")";
_cb.initialize("cb",processBA);
RDebugUtils.currentLine=4390927;
 //BA.debugLineNum = 4390927;BA.debugLine="cts.Initialize";
_cts.Initialize(processBA);
RDebugUtils.currentLine=4390928;
 //BA.debugLineNum = 4390928;BA.debugLine="apli.Initialize";
_apli.Initialize();
RDebugUtils.currentLine=4390929;
 //BA.debugLineNum = 4390929;BA.debugLine="apli=pack.GetInstalledPackages";
_apli = _pack.GetInstalledPackages();
RDebugUtils.currentLine=4390930;
 //BA.debugLineNum = 4390930;BA.debugLine="counter=0";
_counter = (int) (0);
RDebugUtils.currentLine=4390931;
 //BA.debugLineNum = 4390931;BA.debugLine="t2.Initialize(\"t2\",1000)";
_t2.Initialize(processBA,"t2",(long) (1000));
RDebugUtils.currentLine=4390932;
 //BA.debugLineNum = 4390932;BA.debugLine="t3.Initialize(\"t3\",1000)";
_t3.Initialize(processBA,"t3",(long) (1000));
RDebugUtils.currentLine=4390933;
 //BA.debugLineNum = 4390933;BA.debugLine="t3.Enabled=False";
_t3.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390934;
 //BA.debugLineNum = 4390934;BA.debugLine="If Not(File.IsDirectory(File.DirInternal,\"Bdata\")";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.File.IsDirectory(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"Bdata"))) { 
RDebugUtils.currentLine=4390935;
 //BA.debugLineNum = 4390935;BA.debugLine="File.MakeDir(File.DirInternal,\"Bdata/temp\")";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"Bdata/temp");
RDebugUtils.currentLine=4390936;
 //BA.debugLineNum = 4390936;BA.debugLine="File.WriteList(dir,\"clist.txt\",obj)";
anywheresoftware.b4a.keywords.Common.File.WriteList(_dir,"clist.txt",_obj);
 };
RDebugUtils.currentLine=4390938;
 //BA.debugLineNum = 4390938;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_destroy"))
	return (String) Debug.delegate(processBA, "service_destroy", null);
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="t2.Enabled=False";
_t2.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_start"))
	return (String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent});
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="End Sub";
return "";
}
public static String  _wid_start() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "wid_start"))
	return (String) Debug.delegate(processBA, "wid_start", null);
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub wid_start";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="cb.ScanCache";
_cb.ScanCache();
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="End Sub";
return "";
}
}