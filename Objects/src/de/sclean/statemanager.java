package de.sclean;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class statemanager {
private static statemanager mostCurrent = new statemanager();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.collections.Map _states = null;
public static int _listposition = 0;
public static String _statesfilename = "";
public static String _settingsfilename = "";
public static anywheresoftware.b4a.objects.collections.Map _settings = null;
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.info _info = null;
public de.sclean.widget _widget = null;
public de.sclean.animator _animator = null;
public static String  _savestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "savestate"))
	return (String) Debug.delegate(null, "savestate", new Object[] {_ba,_activity,_activityname});
anywheresoftware.b4a.objects.collections.List _list1 = null;
int _i = 0;
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Public Sub SaveState(Activity As Activity, Activit";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="If states.IsInitialized = False Then states.Initi";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_states.Initialize();};
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="list1.Initialize";
_list1.Initialize();
RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="list1.Add(DateTime.Now)";
_list1.Add((Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=8060933;
 //BA.debugLineNum = 8060933;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step5 = 1;
final int limit5 = (int) (_activity.getNumberOfViews()-1);
_i = (int) (0) ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
RDebugUtils.currentLine=8060934;
 //BA.debugLineNum = 8060934;BA.debugLine="innerSaveState(Activity.GetView(i), list1)";
_innersavestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=8060936;
 //BA.debugLineNum = 8060936;BA.debugLine="states.Put(ActivityName.ToLowerCase, list1)";
_states.Put((Object)(_activityname.toLowerCase()),(Object)(_list1.getObject()));
RDebugUtils.currentLine=8060937;
 //BA.debugLineNum = 8060937;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
RDebugUtils.currentLine=8060938;
 //BA.debugLineNum = 8060938;BA.debugLine="End Sub";
return "";
}
public static boolean  _restorestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname,int _validperiodinminutes) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "restorestate"))
	return (Boolean) Debug.delegate(null, "restorestate", new Object[] {_ba,_activity,_activityname,_validperiodinminutes});
anywheresoftware.b4a.objects.collections.List _list1 = null;
long _time = 0L;
int _i = 0;
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Public Sub RestoreState(Activity As Activity, Acti";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="Try";
try {RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="If states.IsInitialized = False Then";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=8388612;
 //BA.debugLineNum = 8388612;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=8388614;
 //BA.debugLineNum = 8388614;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8388615;
 //BA.debugLineNum = 8388615;BA.debugLine="list1 = states.Get(ActivityName.ToLowerCase)";
_list1.setObject((java.util.List)(_states.Get((Object)(_activityname.toLowerCase()))));
RDebugUtils.currentLine=8388616;
 //BA.debugLineNum = 8388616;BA.debugLine="If list1.IsInitialized = False Then Return False";
if (_list1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=8388617;
 //BA.debugLineNum = 8388617;BA.debugLine="Dim time As Long";
_time = 0L;
RDebugUtils.currentLine=8388618;
 //BA.debugLineNum = 8388618;BA.debugLine="time = list1.Get(0)";
_time = BA.ObjectToLongNumber(_list1.Get((int) (0)));
RDebugUtils.currentLine=8388619;
 //BA.debugLineNum = 8388619;BA.debugLine="If ValidPeriodInMinutes > 0 And time + ValidPeri";
if (_validperiodinminutes>0 && _time+_validperiodinminutes*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute<anywheresoftware.b4a.keywords.Common.DateTime.getNow()) { 
RDebugUtils.currentLine=8388620;
 //BA.debugLineNum = 8388620;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=8388622;
 //BA.debugLineNum = 8388622;BA.debugLine="listPosition = 0";
_listposition = (int) (0);
RDebugUtils.currentLine=8388623;
 //BA.debugLineNum = 8388623;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step15 = 1;
final int limit15 = (int) (_activity.getNumberOfViews()-1);
_i = (int) (0) ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
RDebugUtils.currentLine=8388624;
 //BA.debugLineNum = 8388624;BA.debugLine="innerRestoreState(Activity.GetView(i), list1)";
_innerrestorestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=8388626;
 //BA.debugLineNum = 8388626;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e20) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e20);RDebugUtils.currentLine=8388628;
 //BA.debugLineNum = 8388628;BA.debugLine="Log(\"Error loading state.\")";
anywheresoftware.b4a.keywords.Common.Log("Error loading state.");
RDebugUtils.currentLine=8388629;
 //BA.debugLineNum = 8388629;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage());
RDebugUtils.currentLine=8388630;
 //BA.debugLineNum = 8388630;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=8388632;
 //BA.debugLineNum = 8388632;BA.debugLine="End Sub";
return false;
}
public static Object[]  _getnextitem(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "getnextitem"))
	return (Object[]) Debug.delegate(null, "getnextitem", new Object[] {_ba,_list1});
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Private Sub getNextItem(list1 As List) As Object()";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="listPosition = listPosition + 1";
_listposition = (int) (_listposition+1);
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="Return list1.Get(listPosition)";
if (true) return (Object[])(_list1.Get(_listposition));
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="End Sub";
return null;
}
public static String  _getsetting(anywheresoftware.b4a.BA _ba,String _key) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "getsetting"))
	return (String) Debug.delegate(null, "getsetting", new Object[] {_ba,_key});
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Public Sub GetSetting(Key As String) As String";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="Return GetSetting2(Key, \"\")";
if (true) return _getsetting2(_ba,_key,"");
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="End Sub";
return "";
}
public static String  _getsetting2(anywheresoftware.b4a.BA _ba,String _key,String _defaultvalue) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "getsetting2"))
	return (String) Debug.delegate(null, "getsetting2", new Object[] {_ba,_key,_defaultvalue});
String _v = "";
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Public Sub GetSetting2(Key As String, DefaultValue";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=7733251;
 //BA.debugLineNum = 7733251;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=7733252;
 //BA.debugLineNum = 7733252;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=7733254;
 //BA.debugLineNum = 7733254;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
 };
RDebugUtils.currentLine=7733257;
 //BA.debugLineNum = 7733257;BA.debugLine="Dim v As String";
_v = "";
RDebugUtils.currentLine=7733258;
 //BA.debugLineNum = 7733258;BA.debugLine="v = settings.GetDefault(Key.ToLowerCase, DefaultV";
_v = BA.ObjectToString(_settings.GetDefault((Object)(_key.toLowerCase()),(Object)(_defaultvalue)));
RDebugUtils.currentLine=7733259;
 //BA.debugLineNum = 7733259;BA.debugLine="Return v";
if (true) return _v;
RDebugUtils.currentLine=7733260;
 //BA.debugLineNum = 7733260;BA.debugLine="End Sub";
return "";
}
public static String  _innerrestorestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "innerrestorestate"))
	return (String) Debug.delegate(null, "innerrestorestate", new Object[] {_ba,_v,_list1});
Object[] _data = null;
anywheresoftware.b4a.objects.EditTextWrapper _edit = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spinner1 = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _check = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _toggle = null;
anywheresoftware.b4a.objects.SeekBarWrapper _seek = null;
anywheresoftware.b4a.objects.TabHostWrapper _th = null;
int _i = 0;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.PanelWrapper _tabparentpanel = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Private Sub innerRestoreState(v As View, list1 As";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="If v Is EditText Then";
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
RDebugUtils.currentLine=8257539;
 //BA.debugLineNum = 8257539;BA.debugLine="Dim edit As EditText";
_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=8257540;
 //BA.debugLineNum = 8257540;BA.debugLine="edit = v";
_edit.setObject((android.widget.EditText)(_v.getObject()));
RDebugUtils.currentLine=8257541;
 //BA.debugLineNum = 8257541;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=8257542;
 //BA.debugLineNum = 8257542;BA.debugLine="edit.Text = data(0)";
_edit.setText(BA.ObjectToCharSequence(_data[(int) (0)]));
RDebugUtils.currentLine=8257543;
 //BA.debugLineNum = 8257543;BA.debugLine="edit.SelectionStart = data(1)";
_edit.setSelectionStart((int)(BA.ObjectToNumber(_data[(int) (1)])));
 }else 
{RDebugUtils.currentLine=8257544;
 //BA.debugLineNum = 8257544;BA.debugLine="Else If v Is Spinner Then";
if (_v.getObjectOrNull() instanceof anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner) { 
RDebugUtils.currentLine=8257545;
 //BA.debugLineNum = 8257545;BA.debugLine="Dim spinner1 As Spinner";
_spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=8257546;
 //BA.debugLineNum = 8257546;BA.debugLine="spinner1 = v";
_spinner1.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=8257547;
 //BA.debugLineNum = 8257547;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=8257548;
 //BA.debugLineNum = 8257548;BA.debugLine="spinner1.SelectedIndex = data(0)";
_spinner1.setSelectedIndex((int)(BA.ObjectToNumber(_data[(int) (0)])));
 }else 
{RDebugUtils.currentLine=8257549;
 //BA.debugLineNum = 8257549;BA.debugLine="Else If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=8257550;
 //BA.debugLineNum = 8257550;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=8257551;
 //BA.debugLineNum = 8257551;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=8257552;
 //BA.debugLineNum = 8257552;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=8257553;
 //BA.debugLineNum = 8257553;BA.debugLine="check.Checked = data(0)";
_check.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=8257554;
 //BA.debugLineNum = 8257554;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=8257555;
 //BA.debugLineNum = 8257555;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=8257556;
 //BA.debugLineNum = 8257556;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=8257557;
 //BA.debugLineNum = 8257557;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=8257558;
 //BA.debugLineNum = 8257558;BA.debugLine="radio.Checked = data(0)";
_radio.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=8257559;
 //BA.debugLineNum = 8257559;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=8257560;
 //BA.debugLineNum = 8257560;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=8257561;
 //BA.debugLineNum = 8257561;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=8257562;
 //BA.debugLineNum = 8257562;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=8257563;
 //BA.debugLineNum = 8257563;BA.debugLine="toggle.Checked = data(0)";
_toggle.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=8257564;
 //BA.debugLineNum = 8257564;BA.debugLine="Else If v Is SeekBar Then";
if (_v.getObjectOrNull() instanceof android.widget.SeekBar) { 
RDebugUtils.currentLine=8257565;
 //BA.debugLineNum = 8257565;BA.debugLine="Dim seek As SeekBar";
_seek = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=8257566;
 //BA.debugLineNum = 8257566;BA.debugLine="seek = v";
_seek.setObject((android.widget.SeekBar)(_v.getObject()));
RDebugUtils.currentLine=8257567;
 //BA.debugLineNum = 8257567;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=8257568;
 //BA.debugLineNum = 8257568;BA.debugLine="seek.Value = data(0)";
_seek.setValue((int)(BA.ObjectToNumber(_data[(int) (0)])));
 }else 
{RDebugUtils.currentLine=8257569;
 //BA.debugLineNum = 8257569;BA.debugLine="Else If v Is TabHost Then";
if (_v.getObjectOrNull() instanceof android.widget.TabHost) { 
RDebugUtils.currentLine=8257570;
 //BA.debugLineNum = 8257570;BA.debugLine="Dim th As TabHost";
_th = new anywheresoftware.b4a.objects.TabHostWrapper();
RDebugUtils.currentLine=8257571;
 //BA.debugLineNum = 8257571;BA.debugLine="th = v";
_th.setObject((android.widget.TabHost)(_v.getObject()));
RDebugUtils.currentLine=8257572;
 //BA.debugLineNum = 8257572;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=8257573;
 //BA.debugLineNum = 8257573;BA.debugLine="For i = 0 To th.TabCount - 1";
{
final int step37 = 1;
final int limit37 = (int) (_th.getTabCount()-1);
_i = (int) (0) ;
for (;(step37 > 0 && _i <= limit37) || (step37 < 0 && _i >= limit37) ;_i = ((int)(0 + _i + step37))  ) {
RDebugUtils.currentLine=8257574;
 //BA.debugLineNum = 8257574;BA.debugLine="th.CurrentTab = i";
_th.setCurrentTab(_i);
 }
};
RDebugUtils.currentLine=8257576;
 //BA.debugLineNum = 8257576;BA.debugLine="th.CurrentTab = data(0)";
_th.setCurrentTab((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=8257577;
 //BA.debugLineNum = 8257577;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=8257578;
 //BA.debugLineNum = 8257578;BA.debugLine="r.Target = th";
_r.Target = (Object)(_th.getObject());
RDebugUtils.currentLine=8257579;
 //BA.debugLineNum = 8257579;BA.debugLine="Dim tabParentPanel As Panel";
_tabparentpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=8257580;
 //BA.debugLineNum = 8257580;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
_tabparentpanel.setObject((android.view.ViewGroup)(_r.RunMethod("getTabContentView")));
RDebugUtils.currentLine=8257581;
 //BA.debugLineNum = 8257581;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
{
final int step45 = 1;
final int limit45 = (int) (_tabparentpanel.getNumberOfViews()-1);
_i = (int) (0) ;
for (;(step45 > 0 && _i <= limit45) || (step45 < 0 && _i >= limit45) ;_i = ((int)(0 + _i + step45))  ) {
RDebugUtils.currentLine=8257582;
 //BA.debugLineNum = 8257582;BA.debugLine="innerRestoreState(tabParentPanel.GetView(i), li";
_innerrestorestate(_ba,_tabparentpanel.GetView(_i),_list1);
 }
};
 }else 
{RDebugUtils.currentLine=8257584;
 //BA.debugLineNum = 8257584;BA.debugLine="Else If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
RDebugUtils.currentLine=8257585;
 //BA.debugLineNum = 8257585;BA.debugLine="Dim sv As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=8257586;
 //BA.debugLineNum = 8257586;BA.debugLine="sv = v";
_sv.setObject((android.widget.ScrollView)(_v.getObject()));
RDebugUtils.currentLine=8257587;
 //BA.debugLineNum = 8257587;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=8257588;
 //BA.debugLineNum = 8257588;BA.debugLine="sv.ScrollPosition = data(0)";
_sv.setScrollPosition((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=8257589;
 //BA.debugLineNum = 8257589;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
RDebugUtils.currentLine=8257590;
 //BA.debugLineNum = 8257590;BA.debugLine="sv.ScrollPosition = data(0)";
_sv.setScrollPosition((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=8257591;
 //BA.debugLineNum = 8257591;BA.debugLine="innerRestoreState(sv.Panel, list1)";
_innerrestorestate(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_sv.getPanel().getObject())),_list1);
 }else 
{RDebugUtils.currentLine=8257592;
 //BA.debugLineNum = 8257592;BA.debugLine="Else If v Is Panel Then";
if (_v.getObjectOrNull() instanceof android.view.ViewGroup) { 
RDebugUtils.currentLine=8257593;
 //BA.debugLineNum = 8257593;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=8257594;
 //BA.debugLineNum = 8257594;BA.debugLine="panel1 = v";
_panel1.setObject((android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=8257595;
 //BA.debugLineNum = 8257595;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
{
final int step59 = 1;
final int limit59 = (int) (_panel1.getNumberOfViews()-1);
_i = (int) (0) ;
for (;(step59 > 0 && _i <= limit59) || (step59 < 0 && _i >= limit59) ;_i = ((int)(0 + _i + step59))  ) {
RDebugUtils.currentLine=8257596;
 //BA.debugLineNum = 8257596;BA.debugLine="innerRestoreState(panel1.GetView(i), list1)";
_innerrestorestate(_ba,_panel1.GetView(_i),_list1);
 }
};
 }}}}}}}}}
;
RDebugUtils.currentLine=8257599;
 //BA.debugLineNum = 8257599;BA.debugLine="End Sub";
return "";
}
public static String  _innersavestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "innersavestate"))
	return (String) Debug.delegate(null, "innersavestate", new Object[] {_ba,_v,_list1});
Object[] _data = null;
anywheresoftware.b4a.objects.EditTextWrapper _edit = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spinner1 = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _check = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _toggle = null;
anywheresoftware.b4a.objects.SeekBarWrapper _seek = null;
anywheresoftware.b4a.objects.TabHostWrapper _th = null;
int _i = 0;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.PanelWrapper _tabparentpanel = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Private Sub innerSaveState(v As View, list1 As Lis";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="If v Is EditText Then";
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
RDebugUtils.currentLine=8192003;
 //BA.debugLineNum = 8192003;BA.debugLine="Dim edit As EditText";
_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="edit = v";
_edit.setObject((android.widget.EditText)(_v.getObject()));
RDebugUtils.currentLine=8192005;
 //BA.debugLineNum = 8192005;BA.debugLine="data = Array As Object(edit.Text, edit.Selection";
_data = new Object[]{(Object)(_edit.getText()),(Object)(_edit.getSelectionStart())};
 }else 
{RDebugUtils.currentLine=8192006;
 //BA.debugLineNum = 8192006;BA.debugLine="Else If v Is Spinner Then";
if (_v.getObjectOrNull() instanceof anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner) { 
RDebugUtils.currentLine=8192007;
 //BA.debugLineNum = 8192007;BA.debugLine="Dim spinner1 As Spinner";
_spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=8192008;
 //BA.debugLineNum = 8192008;BA.debugLine="spinner1 = v";
_spinner1.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=8192009;
 //BA.debugLineNum = 8192009;BA.debugLine="data = Array As Object(spinner1.SelectedIndex)";
_data = new Object[]{(Object)(_spinner1.getSelectedIndex())};
 }else 
{RDebugUtils.currentLine=8192010;
 //BA.debugLineNum = 8192010;BA.debugLine="Else If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=8192011;
 //BA.debugLineNum = 8192011;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=8192012;
 //BA.debugLineNum = 8192012;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=8192013;
 //BA.debugLineNum = 8192013;BA.debugLine="data = Array As Object(check.Checked)";
_data = new Object[]{(Object)(_check.getChecked())};
 }else 
{RDebugUtils.currentLine=8192014;
 //BA.debugLineNum = 8192014;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=8192015;
 //BA.debugLineNum = 8192015;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=8192016;
 //BA.debugLineNum = 8192016;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=8192017;
 //BA.debugLineNum = 8192017;BA.debugLine="data = Array As Object(radio.Checked)";
_data = new Object[]{(Object)(_radio.getChecked())};
 }else 
{RDebugUtils.currentLine=8192018;
 //BA.debugLineNum = 8192018;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=8192019;
 //BA.debugLineNum = 8192019;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=8192020;
 //BA.debugLineNum = 8192020;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=8192021;
 //BA.debugLineNum = 8192021;BA.debugLine="data = Array As Object(toggle.Checked)";
_data = new Object[]{(Object)(_toggle.getChecked())};
 }else 
{RDebugUtils.currentLine=8192022;
 //BA.debugLineNum = 8192022;BA.debugLine="Else If v Is SeekBar Then";
if (_v.getObjectOrNull() instanceof android.widget.SeekBar) { 
RDebugUtils.currentLine=8192023;
 //BA.debugLineNum = 8192023;BA.debugLine="Dim seek As SeekBar";
_seek = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=8192024;
 //BA.debugLineNum = 8192024;BA.debugLine="seek = v";
_seek.setObject((android.widget.SeekBar)(_v.getObject()));
RDebugUtils.currentLine=8192025;
 //BA.debugLineNum = 8192025;BA.debugLine="data = Array As Object(seek.Value)";
_data = new Object[]{(Object)(_seek.getValue())};
 }else 
{RDebugUtils.currentLine=8192026;
 //BA.debugLineNum = 8192026;BA.debugLine="Else If v Is TabHost Then";
if (_v.getObjectOrNull() instanceof android.widget.TabHost) { 
RDebugUtils.currentLine=8192027;
 //BA.debugLineNum = 8192027;BA.debugLine="Dim th As TabHost";
_th = new anywheresoftware.b4a.objects.TabHostWrapper();
RDebugUtils.currentLine=8192028;
 //BA.debugLineNum = 8192028;BA.debugLine="th = v";
_th.setObject((android.widget.TabHost)(_v.getObject()));
RDebugUtils.currentLine=8192029;
 //BA.debugLineNum = 8192029;BA.debugLine="data = Array As Object(th.CurrentTab)";
_data = new Object[]{(Object)(_th.getCurrentTab())};
RDebugUtils.currentLine=8192030;
 //BA.debugLineNum = 8192030;BA.debugLine="For i = 0 To th.TabCount - 1";
{
final int step30 = 1;
final int limit30 = (int) (_th.getTabCount()-1);
_i = (int) (0) ;
for (;(step30 > 0 && _i <= limit30) || (step30 < 0 && _i >= limit30) ;_i = ((int)(0 + _i + step30))  ) {
RDebugUtils.currentLine=8192031;
 //BA.debugLineNum = 8192031;BA.debugLine="th.CurrentTab = i";
_th.setCurrentTab(_i);
 }
};
RDebugUtils.currentLine=8192033;
 //BA.debugLineNum = 8192033;BA.debugLine="list1.Add(data)";
_list1.Add((Object)(_data));
RDebugUtils.currentLine=8192034;
 //BA.debugLineNum = 8192034;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=8192035;
 //BA.debugLineNum = 8192035;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=8192036;
 //BA.debugLineNum = 8192036;BA.debugLine="r.Target = th";
_r.Target = (Object)(_th.getObject());
RDebugUtils.currentLine=8192037;
 //BA.debugLineNum = 8192037;BA.debugLine="Dim tabParentPanel As Panel";
_tabparentpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=8192038;
 //BA.debugLineNum = 8192038;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
_tabparentpanel.setObject((android.view.ViewGroup)(_r.RunMethod("getTabContentView")));
RDebugUtils.currentLine=8192039;
 //BA.debugLineNum = 8192039;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
{
final int step39 = 1;
final int limit39 = (int) (_tabparentpanel.getNumberOfViews()-1);
_i = (int) (0) ;
for (;(step39 > 0 && _i <= limit39) || (step39 < 0 && _i >= limit39) ;_i = ((int)(0 + _i + step39))  ) {
RDebugUtils.currentLine=8192040;
 //BA.debugLineNum = 8192040;BA.debugLine="innerSaveState(tabParentPanel.GetView(i), list1";
_innersavestate(_ba,_tabparentpanel.GetView(_i),_list1);
 }
};
 }else 
{RDebugUtils.currentLine=8192042;
 //BA.debugLineNum = 8192042;BA.debugLine="Else If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
RDebugUtils.currentLine=8192043;
 //BA.debugLineNum = 8192043;BA.debugLine="Dim sv As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=8192044;
 //BA.debugLineNum = 8192044;BA.debugLine="sv = v";
_sv.setObject((android.widget.ScrollView)(_v.getObject()));
RDebugUtils.currentLine=8192045;
 //BA.debugLineNum = 8192045;BA.debugLine="data = Array As Object(sv.ScrollPosition)";
_data = new Object[]{(Object)(_sv.getScrollPosition())};
RDebugUtils.currentLine=8192046;
 //BA.debugLineNum = 8192046;BA.debugLine="list1.Add(data)";
_list1.Add((Object)(_data));
RDebugUtils.currentLine=8192047;
 //BA.debugLineNum = 8192047;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=8192048;
 //BA.debugLineNum = 8192048;BA.debugLine="innerSaveState(sv.Panel, list1)";
_innersavestate(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_sv.getPanel().getObject())),_list1);
 }else 
{RDebugUtils.currentLine=8192049;
 //BA.debugLineNum = 8192049;BA.debugLine="Else If v Is Panel Then";
if (_v.getObjectOrNull() instanceof android.view.ViewGroup) { 
RDebugUtils.currentLine=8192050;
 //BA.debugLineNum = 8192050;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=8192051;
 //BA.debugLineNum = 8192051;BA.debugLine="panel1 = v";
_panel1.setObject((android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=8192052;
 //BA.debugLineNum = 8192052;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
{
final int step52 = 1;
final int limit52 = (int) (_panel1.getNumberOfViews()-1);
_i = (int) (0) ;
for (;(step52 > 0 && _i <= limit52) || (step52 < 0 && _i >= limit52) ;_i = ((int)(0 + _i + step52))  ) {
RDebugUtils.currentLine=8192053;
 //BA.debugLineNum = 8192053;BA.debugLine="innerSaveState(panel1.GetView(i), list1)";
_innersavestate(_ba,_panel1.GetView(_i),_list1);
 }
};
 }}}}}}}}}
;
RDebugUtils.currentLine=8192056;
 //BA.debugLineNum = 8192056;BA.debugLine="If data.Length > 0 Then list1.Add(data)";
if (_data.length>0) { 
_list1.Add((Object)(_data));};
RDebugUtils.currentLine=8192057;
 //BA.debugLineNum = 8192057;BA.debugLine="End Sub";
return "";
}
public static String  _loadstatefile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "loadstatefile"))
	return (String) Debug.delegate(null, "loadstatefile", new Object[] {_ba});
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Private Sub loadStateFile";
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="If states.IsInitialized Then Return";
if (_states.IsInitialized()) { 
if (true) return "";};
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="If File.Exists(File.DirInternal, statesFileName)";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename)) { 
RDebugUtils.currentLine=8454148;
 //BA.debugLineNum = 8454148;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=8454149;
 //BA.debugLineNum = 8454149;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8454150;
 //BA.debugLineNum = 8454150;BA.debugLine="states = raf.ReadObject(0)";
_states.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_raf.ReadObject((long) (0))));
RDebugUtils.currentLine=8454151;
 //BA.debugLineNum = 8454151;BA.debugLine="raf.Close";
_raf.Close();
 };
RDebugUtils.currentLine=8454153;
 //BA.debugLineNum = 8454153;BA.debugLine="End Sub";
return "";
}
public static String  _resetstate(anywheresoftware.b4a.BA _ba,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "resetstate"))
	return (String) Debug.delegate(null, "resetstate", new Object[] {_ba,_activityname});
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Public Sub ResetState(ActivityName As String)";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="If states.IsInitialized Then";
if (_states.IsInitialized()) { 
RDebugUtils.currentLine=7995395;
 //BA.debugLineNum = 7995395;BA.debugLine="states.Remove(ActivityName.ToLowerCase)";
_states.Remove((Object)(_activityname.toLowerCase()));
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
 };
RDebugUtils.currentLine=7995398;
 //BA.debugLineNum = 7995398;BA.debugLine="End Sub";
return "";
}
public static String  _writestatetofile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "writestatetofile"))
	return (String) Debug.delegate(null, "writestatetofile", new Object[] {_ba});
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Private Sub writeStateToFile";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="raf.WriteObject(states, True, raf.CurrentPosition";
_raf.WriteObject((Object)(_states.getObject()),anywheresoftware.b4a.keywords.Common.True,_raf.CurrentPosition);
RDebugUtils.currentLine=8126468;
 //BA.debugLineNum = 8126468;BA.debugLine="raf.Close";
_raf.Close();
RDebugUtils.currentLine=8126469;
 //BA.debugLineNum = 8126469;BA.debugLine="End Sub";
return "";
}
public static String  _savesettings(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "savesettings"))
	return (String) Debug.delegate(null, "savesettings", new Object[] {_ba});
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Public Sub SaveSettings";
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="If settings.IsInitialized Then";
if (_settings.IsInitialized()) { 
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="File.WriteMap(File.DirInternal, settingsFileName";
anywheresoftware.b4a.keywords.Common.File.WriteMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename,_settings);
 };
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="End Sub";
return "";
}
public static String  _setsetting(anywheresoftware.b4a.BA _ba,String _key,String _value) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate(null, "setsetting"))
	return (String) Debug.delegate(null, "setsetting", new Object[] {_ba,_key,_value});
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Public Sub SetSetting(Key As String, Value As Stri";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=7864326;
 //BA.debugLineNum = 7864326;BA.debugLine="settings.Initialize";
_settings.Initialize();
 };
 };
RDebugUtils.currentLine=7864329;
 //BA.debugLineNum = 7864329;BA.debugLine="settings.Put(Key.ToLowerCase, Value)";
_settings.Put((Object)(_key.toLowerCase()),(Object)(_value));
RDebugUtils.currentLine=7864330;
 //BA.debugLineNum = 7864330;BA.debugLine="End Sub";
return "";
}
}