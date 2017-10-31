package de.sclean;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _about_click() throws Exception{
try {
		Debug.PushSubsStack("about_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,653);
if (RapidSub.canDelegate("about_click")) return de.sclean.main.remoteMe.runUserSub(false, "main","about_click");
RemoteObject _l1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _l2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _cs = RemoteObject.declareNull("anywheresoftware.b4a.objects.CSBuilder");
RemoteObject _infodia = RemoteObject.declareNull("de.amberhome.materialdialogs.MaterialDialogWrapper");
RemoteObject _inf = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _builder = RemoteObject.declareNull("de.amberhome.materialdialogs.MaterialDialogBuilderWrapper");
 BA.debugLineNum = 653;BA.debugLine="Sub about_click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 654;BA.debugLine="Dim l1,l2 As Label";
Debug.ShouldStop(8192);
_l1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l1", _l1);
_l2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l2", _l2);
 BA.debugLineNum = 655;BA.debugLine="l1.Initialize(\"\")";
Debug.ShouldStop(16384);
_l1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 656;BA.debugLine="l2.Initialize(\"\")";
Debug.ShouldStop(32768);
_l2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 657;BA.debugLine="l2.TextSize=15";
Debug.ShouldStop(65536);
_l2.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 658;BA.debugLine="l1.TextSize=13";
Debug.ShouldStop(131072);
_l1.runMethod(true,"setTextSize",BA.numberCast(float.class, 13));
 BA.debugLineNum = 659;BA.debugLine="l1.textcolor=mcl.md_white_1000";
Debug.ShouldStop(262144);
_l1.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_white_1000"));
 BA.debugLineNum = 660;BA.debugLine="l2.textcolor=mcl.md_white_1000";
Debug.ShouldStop(524288);
_l2.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_white_1000"));
 BA.debugLineNum = 661;BA.debugLine="l1.Gravity=Gravity.TOP";
Debug.ShouldStop(1048576);
_l1.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP"));
 BA.debugLineNum = 662;BA.debugLine="l1.Typeface=rfont";
Debug.ShouldStop(2097152);
_l1.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 663;BA.debugLine="l2.Typeface=rfont";
Debug.ShouldStop(4194304);
_l2.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 664;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(8388608);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 665;BA.debugLine="cs.Initialize.Append(\"App Ver: \"&pack.GetVersionN";
Debug.ShouldStop(16777216);
_cs.runMethod(false,"Initialize").runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("App Ver: "),main.mostCurrent._pack.runMethod(true,"GetVersionName",(Object)(main._package)),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Build Nr: "),main.mostCurrent._pack.runMethod(true,"GetVersionCode",(Object)(main._package)),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Code: D.Trojan"),main.mostCurrent.__c.getField(true,"CRLF"))))).runVoidMethod ("Append",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Published by Sulomedia"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("© 2017"),main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent.__c.getField(true,"CRLF")))));
 BA.debugLineNum = 666;BA.debugLine="cs.Append(CreateClickableWord(utext)).PopAll";
Debug.ShouldStop(33554432);
_cs.runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(_createclickableword(main._utext).getObject()))).runVoidMethod ("PopAll");
 BA.debugLineNum = 667;BA.debugLine="l2.Text=\"About \"&pack.GetApplicationLabel(package";
Debug.ShouldStop(67108864);
_l2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("About "),main.mostCurrent._pack.runMethod(true,"GetApplicationLabel",(Object)(main._package)))));
 BA.debugLineNum = 668;BA.debugLine="l1.Text=cs";
Debug.ShouldStop(134217728);
_l1.runMethod(true,"setText",BA.ObjectToCharSequence(_cs.getObject()));
 BA.debugLineNum = 669;BA.debugLine="Dim infodia As MaterialDialog";
Debug.ShouldStop(268435456);
_infodia = RemoteObject.createNew ("de.amberhome.materialdialogs.MaterialDialogWrapper");Debug.locals.put("infodia", _infodia);
 BA.debugLineNum = 670;BA.debugLine="Dim inf As BitmapDrawable";
Debug.ShouldStop(536870912);
_inf = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("inf", _inf);
 BA.debugLineNum = 671;BA.debugLine="inf.Initialize(LoadBitmap(File.DirAssets,\"smm_sma";
Debug.ShouldStop(1073741824);
_inf.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("smm_small_logo.png"))).getObject())));
 BA.debugLineNum = 672;BA.debugLine="Dim Builder As MaterialDialogBuilder";
Debug.ShouldStop(-2147483648);
_builder = RemoteObject.createNew ("de.amberhome.materialdialogs.MaterialDialogBuilderWrapper");Debug.locals.put("Builder", _builder);
 BA.debugLineNum = 673;BA.debugLine="Builder.Initialize(\"Dialog3\")";
Debug.ShouldStop(1);
_builder.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Dialog3")));
 BA.debugLineNum = 674;BA.debugLine="Builder.Title(l2.Text).TitleColor(mcl.md_black_10";
Debug.ShouldStop(2);
_builder.runMethod(false,"Title",(Object)(BA.ObjectToCharSequence(_l2.runMethod(true,"getText")))).runMethod(false,"TitleColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_black_1000"))).runMethod(false,"Icon",(Object)((_inf.getObject()))).runMethod(false,"LimitIconToDefaultSize").runMethod(false,"Theme",(Object)(_builder.getField(false,"THEME_DARK"))).runMethod(false,"Content",(Object)(BA.ObjectToCharSequence(_cs.getObject()))).runMethod(false,"ContentLineSpacing",(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))))).runMethod(false,"Typeface",(Object)((main._rfont.getObject())),(Object)((main._rfont.getObject()))).runMethod(false,"Cancelable",(Object)(main.mostCurrent.__c.getField(true,"True"))).runMethod(false,"NeutralText",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("close")))).runMethod(false,"NeutralColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_grey_400"))).runMethod(false,"ContentGravity",(Object)(_builder.getField(false,"GRAVITY_START"))).runVoidMethod ("ContentLineSpacing",(Object)(BA.numberCast(float.class, 2)));
 BA.debugLineNum = 675;BA.debugLine="infodia=Builder.Show";
Debug.ShouldStop(4);
_infodia = _builder.runMethod(false,"Show");Debug.locals.put("infodia", _infodia);
 BA.debugLineNum = 676;BA.debugLine="infodia.Show";
Debug.ShouldStop(8);
_infodia.runVoidMethod ("Show");
 BA.debugLineNum = 677;BA.debugLine="cs.EnableClickEvents(l1)";
Debug.ShouldStop(16);
_cs.runVoidMethod ("EnableClickEvents",(Object)((_l1.getObject())));
 BA.debugLineNum = 678;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,72);
if (RapidSub.canDelegate("activity_create")) return de.sclean.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
RemoteObject _lftmenu = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _offset = RemoteObject.createImmutable(0);
RemoteObject _la1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _la2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _ml = RemoteObject.declareNull("MLfiles.Fileslib.MLfiles");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 72;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="Activity.LoadLayout(\"1\")";
Debug.ShouldStop(256);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 74;BA.debugLine="Activity.TitleColor=mcl.md_black_1000";
Debug.ShouldStop(512);
main.mostCurrent._activity.runMethod(true,"setTitleColor",main.mostCurrent._mcl.runMethod(true,"getmd_black_1000"));
 BA.debugLineNum = 75;BA.debugLine="Activity.Title=pack.GetApplicationLabel(package)";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence(main.mostCurrent._pack.runMethod(true,"GetApplicationLabel",(Object)(main._package))));
 BA.debugLineNum = 76;BA.debugLine="Activity.Color=Colors.ARGB(255,65,66,67)";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 65)),(Object)(BA.numberCast(int.class, 66)),(Object)(BA.numberCast(int.class, 67))));
 BA.debugLineNum = 79;BA.debugLine="ABHelper.Initialize";
Debug.ShouldStop(16384);
main.mostCurrent._abhelper.runVoidMethod ("Initialize",main.mostCurrent.activityBA);
 BA.debugLineNum = 80;BA.debugLine="toolbar.SetAsActionBar";
Debug.ShouldStop(32768);
main.mostCurrent._toolbar.runVoidMethod ("SetAsActionBar",main.mostCurrent.activityBA);
 BA.debugLineNum = 81;BA.debugLine="toolbar.InitMenuListener";
Debug.ShouldStop(65536);
main.mostCurrent._toolbar.runVoidMethod ("InitMenuListener");
 BA.debugLineNum = 82;BA.debugLine="toolbar.PopupTheme=toolbar.THEME_DARK";
Debug.ShouldStop(131072);
main.mostCurrent._toolbar.runVoidMethod ("setPopupTheme",main.mostCurrent._toolbar.getField(true,"THEME_DARK"));
 BA.debugLineNum = 84;BA.debugLine="toolbar.SubTitle=\"V\"&pack.GetVersionName(package)";
Debug.ShouldStop(524288);
main.mostCurrent._toolbar.runMethod(true,"setSubTitle",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("V"),main.mostCurrent._pack.runMethod(true,"GetVersionName",(Object)(main._package)))));
 BA.debugLineNum = 85;BA.debugLine="ABHelper.ShowUpIndicator = True";
Debug.ShouldStop(1048576);
main.mostCurrent._abhelper.runVoidMethod ("setShowUpIndicator",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 86;BA.debugLine="ABHelper.HomeVisible=True";
Debug.ShouldStop(2097152);
main.mostCurrent._abhelper.runVoidMethod ("setHomeVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 87;BA.debugLine="DateTime.TimeFormat=\"HH:mm\"";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 BA.debugLineNum = 88;BA.debugLine="DateTime.DateFormat=\"dd-MM-yyyy\"";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd-MM-yyyy"));
 BA.debugLineNum = 89;BA.debugLine="date=DateTime.Date(DateTime.Now)";
Debug.ShouldStop(16777216);
main._date = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));
 BA.debugLineNum = 90;BA.debugLine="time=DateTime.Time(DateTime.Now)";
Debug.ShouldStop(33554432);
main._time = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));
 BA.debugLineNum = 91;BA.debugLine="xOSStats.Initialize(400, 50, Me, \"Stats\")";
Debug.ShouldStop(67108864);
main.mostCurrent._xosstats.runVoidMethod ("_initialize",main.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 400)),(Object)(BA.numberCast(int.class, 50)),(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("Stats")));
 BA.debugLineNum = 92;BA.debugLine="im1.Initialize(\"im1\")";
Debug.ShouldStop(134217728);
main.mostCurrent._im1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("im1")));
 BA.debugLineNum = 93;BA.debugLine="os.Initialize(\"os\")";
Debug.ShouldStop(268435456);
main._os.runVoidMethod ("Initialize",main.processBA,(Object)(RemoteObject.createImmutable("os")));
 BA.debugLineNum = 94;BA.debugLine="sm.Initialize(\"sm\")";
Debug.ShouldStop(536870912);
main.mostCurrent._sm.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sm")));
 BA.debugLineNum = 95;BA.debugLine="t1.Initialize(\"t1\",1000)";
Debug.ShouldStop(1073741824);
main._t1.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("t1")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 96;BA.debugLine="t2.Initialize(\"t2\",1000)";
Debug.ShouldStop(-2147483648);
main._t2.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("t2")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 97;BA.debugLine="sr.Initialize(\"sr\")";
Debug.ShouldStop(1);
main.mostCurrent._sr.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sr")));
 BA.debugLineNum = 98;BA.debugLine="ldim.Initialize(\"ldim\")";
Debug.ShouldStop(2);
main.mostCurrent._ldim.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ldim")));
 BA.debugLineNum = 99;BA.debugLine="pdim.Initialize(\"pdim\")";
Debug.ShouldStop(4);
main.mostCurrent._pdim.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("pdim")));
 BA.debugLineNum = 100;BA.debugLine="ready.Initialize(\"ready\")";
Debug.ShouldStop(8);
main.mostCurrent._ready.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ready")));
 BA.debugLineNum = 101;BA.debugLine="ldim.Visible=False";
Debug.ShouldStop(16);
main.mostCurrent._ldim.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 102;BA.debugLine="pdim.Visible=False";
Debug.ShouldStop(32);
main.mostCurrent._pdim.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 103;BA.debugLine="lolist.Initialize(\"lolist\")";
Debug.ShouldStop(64);
main.mostCurrent._lolist.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lolist")));
 BA.debugLineNum = 104;BA.debugLine="pdim.AddView(lolist,1%x,1%y,99%x,70%y)";
Debug.ShouldStop(128);
main.mostCurrent._pdim.runVoidMethod ("AddView",(Object)((main.mostCurrent._lolist.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 99)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 70)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 105;BA.debugLine="counter=0";
Debug.ShouldStop(256);
main._counter = BA.numberCast(int.class, 0);
 BA.debugLineNum = 106;BA.debugLine="t1.Enabled=False";
Debug.ShouldStop(512);
main._t1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 107;BA.debugLine="t2.Enabled=False";
Debug.ShouldStop(1024);
main._t2.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 108;BA.debugLine="Dim lftMenu As Panel";
Debug.ShouldStop(2048);
_lftmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("lftMenu", _lftmenu);
 BA.debugLineNum = 109;BA.debugLine="lftMenu.Initialize(\"\")";
Debug.ShouldStop(4096);
_lftmenu.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 110;BA.debugLine="lftMenu.LoadLayout(\"left\")";
Debug.ShouldStop(8192);
_lftmenu.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("left")),main.mostCurrent.activityBA);
 BA.debugLineNum = 111;BA.debugLine="Dim offset As Int = 20%x";
Debug.ShouldStop(16384);
_offset = main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA);Debug.locals.put("offset", _offset);Debug.locals.put("offset", _offset);
 BA.debugLineNum = 112;BA.debugLine="sm.BehindOffset = offset";
Debug.ShouldStop(32768);
main.mostCurrent._sm.runVoidMethod ("setBehindOffset",_offset);
 BA.debugLineNum = 113;BA.debugLine="sm.Menu.AddView(lftMenu, 0, 0, 100%x-offset, 100%";
Debug.ShouldStop(65536);
main.mostCurrent._sm.runMethod(false,"getMenu").runVoidMethod ("AddView",(Object)((_lftmenu.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA),_offset}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 114;BA.debugLine="sm.Mode = sm.LEFT";
Debug.ShouldStop(131072);
main.mostCurrent._sm.runMethod(true,"setMode",main.mostCurrent._sm.getField(true,"LEFT"));
 BA.debugLineNum = 115;BA.debugLine="Dim la1,la2 As Label";
Debug.ShouldStop(262144);
_la1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("la1", _la1);
_la2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("la2", _la2);
 BA.debugLineNum = 116;BA.debugLine="la2.Initialize(\"la2\")";
Debug.ShouldStop(524288);
_la2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("la2")));
 BA.debugLineNum = 117;BA.debugLine="la1.Initialize(\"la1\")";
Debug.ShouldStop(1048576);
_la1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("la1")));
 BA.debugLineNum = 118;BA.debugLine="la1=lv1.TwoLinesAndBitmap.Label";
Debug.ShouldStop(2097152);
_la1 = main.mostCurrent._lv1.runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label");Debug.locals.put("la1", _la1);
 BA.debugLineNum = 119;BA.debugLine="la2=lv1.TwoLinesAndBitmap.SecondLabel";
Debug.ShouldStop(4194304);
_la2 = main.mostCurrent._lv1.runMethod(false,"getTwoLinesAndBitmap").getField(false,"SecondLabel");Debug.locals.put("la2", _la2);
 BA.debugLineNum = 120;BA.debugLine="la1.TextSize=15";
Debug.ShouldStop(8388608);
_la1.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 121;BA.debugLine="la2.TextSize=13";
Debug.ShouldStop(16777216);
_la2.runMethod(true,"setTextSize",BA.numberCast(float.class, 13));
 BA.debugLineNum = 122;BA.debugLine="la1.Typeface=rfont";
Debug.ShouldStop(33554432);
_la1.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 123;BA.debugLine="la2.Typeface=rfont";
Debug.ShouldStop(67108864);
_la2.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 124;BA.debugLine="la1.TextColor=mcl.md_grey_900";
Debug.ShouldStop(134217728);
_la1.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_grey_900"));
 BA.debugLineNum = 125;BA.debugLine="la2.TextColor=Colors.ARGB(190,255,255,255)";
Debug.ShouldStop(268435456);
_la2.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 190)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 126;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Height=32dip";
Debug.ShouldStop(536870912);
main.mostCurrent._lv1.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32))));
 BA.debugLineNum = 127;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Width=32dip";
Debug.ShouldStop(1073741824);
main.mostCurrent._lv1.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32))));
 BA.debugLineNum = 128;BA.debugLine="lv1.TwoLinesAndBitmap.ItemHeight=55dip";
Debug.ShouldStop(-2147483648);
main.mostCurrent._lv1.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"setItemHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55))));
 BA.debugLineNum = 129;BA.debugLine="kvst.Initialize(File.DirInternal,\"data_time\")";
Debug.ShouldStop(1);
main.mostCurrent._kvst.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",main.processBA,(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("data_time")));
 BA.debugLineNum = 130;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
Debug.ShouldStop(2);
main.mostCurrent._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",main.processBA,(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("data_data")));
 BA.debugLineNum = 131;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
Debug.ShouldStop(4);
main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",main.processBA,(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("adata_data")));
 BA.debugLineNum = 132;BA.debugLine="dbase.Initialize(File.DirInternal,\"dbase_data\")";
Debug.ShouldStop(8);
main.mostCurrent._dbase.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",main.processBA,(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("dbase_data")));
 BA.debugLineNum = 133;BA.debugLine="abase.Initialize(File.DirInternal,\"abase_data\")";
Debug.ShouldStop(16);
main.mostCurrent._abase.runClassMethod (de.sclean.keyvaluestore.class, "_initialize",main.processBA,(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("abase_data")));
 BA.debugLineNum = 134;BA.debugLine="prb.Typeface=rfont";
Debug.ShouldStop(32);
main.mostCurrent._prb.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 135;BA.debugLine="prb.Text=\"Scan\"";
Debug.ShouldStop(64);
main.mostCurrent._prb.runMethod(true,"setText",BA.ObjectToCharSequence("Scan"));
 BA.debugLineNum = 136;BA.debugLine="ss.Initialize(\"ss\")";
Debug.ShouldStop(128);
main.mostCurrent._ss.runVoidMethod ("Initialize",main.processBA,(Object)(RemoteObject.createImmutable("ss")));
 BA.debugLineNum = 137;BA.debugLine="Activity.AddView(ldim,0,10%y,100%x,100%y)";
Debug.ShouldStop(256);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._ldim.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 138;BA.debugLine="ldim.Color=Colors.ARGB(230,0,0,0)";
Debug.ShouldStop(512);
main.mostCurrent._ldim.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 230)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 139;BA.debugLine="pdim.Color=Colors.ARGB(230,0,0,0)";
Debug.ShouldStop(1024);
main.mostCurrent._pdim.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 230)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 140;BA.debugLine="pdim.Elevation=5dip";
Debug.ShouldStop(2048);
main.mostCurrent._pdim.runMethod(true,"setElevation",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))));
 BA.debugLineNum = 141;BA.debugLine="Activity.AddView(sr,25%x,10%y,150dip,150dip)";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._sr.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 BA.debugLineNum = 142;BA.debugLine="Activity.AddView(ready,25%x,40%y,150dip,150dip)";
Debug.ShouldStop(8192);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._ready.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 40)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));
 BA.debugLineNum = 143;BA.debugLine="Activity.AddView(pdim,0%x,45%y,100%x,70%y)";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._pdim.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 0)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 45)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 70)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 144;BA.debugLine="sr.Visible=False";
Debug.ShouldStop(32768);
main.mostCurrent._sr.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 145;BA.debugLine="tota.TextColor=mcl.md_grey_600";
Debug.ShouldStop(65536);
main.mostCurrent._tota.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_grey_600"));
 BA.debugLineNum = 146;BA.debugLine="tota.TextSize=22";
Debug.ShouldStop(131072);
main.mostCurrent._tota.runMethod(true,"setTextSize",BA.numberCast(float.class, 22));
 BA.debugLineNum = 147;BA.debugLine="tota.Typeface=rfont";
Debug.ShouldStop(262144);
main.mostCurrent._tota.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 148;BA.debugLine="pn.Initialize(\"\")";
Debug.ShouldStop(524288);
main.mostCurrent._pn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 149;BA.debugLine="pn.Color=Colors.ARGB(220,0,0,0)";
Debug.ShouldStop(1048576);
main.mostCurrent._pn.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 220)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 150;BA.debugLine="sl.Initialize(\"sl\")";
Debug.ShouldStop(2097152);
main.mostCurrent._sl.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("sl")));
 BA.debugLineNum = 151;BA.debugLine="sl.Text=\"Einen Moment bitte, Apps werden durchsuc";
Debug.ShouldStop(4194304);
main.mostCurrent._sl.runMethod(true,"setText",BA.ObjectToCharSequence("Einen Moment bitte, Apps werden durchsucht.."));
 BA.debugLineNum = 152;BA.debugLine="sl.Textsize=20";
Debug.ShouldStop(8388608);
main.mostCurrent._sl.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 153;BA.debugLine="sl.Typeface=rfont";
Debug.ShouldStop(16777216);
main.mostCurrent._sl.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 155;BA.debugLine="Activity.AddView(pn,0%x,1%y,100%x,100%y)";
Debug.ShouldStop(67108864);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._pn.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 0)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 156;BA.debugLine="pn.AddView(ss,10%x,15%y,250dip,250dip)";
Debug.ShouldStop(134217728);
main.mostCurrent._pn.runVoidMethod ("AddView",(Object)((main.mostCurrent._ss.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 15)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))));
 BA.debugLineNum = 157;BA.debugLine="pn.AddView(sl,10%x,15%y+250dip+20dip,300dip,300di";
Debug.ShouldStop(268435456);
main.mostCurrent._pn.runVoidMethod ("AddView",(Object)((main.mostCurrent._sl.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 15)),main.mostCurrent.activityBA),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 BA.debugLineNum = 158;BA.debugLine="pn.Visible=False";
Debug.ShouldStop(536870912);
main.mostCurrent._pn.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 159;BA.debugLine="ready.Visible=False";
Debug.ShouldStop(1073741824);
main.mostCurrent._ready.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 160;BA.debugLine="ready.Bitmap=LoadBitmap(File.DirAssets,\"Accept256";
Debug.ShouldStop(-2147483648);
main.mostCurrent._ready.runMethod(false,"setBitmap",(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Accept256.png"))).getObject()));
 BA.debugLineNum = 161;BA.debugLine="ready.Gravity=Gravity.FILL";
Debug.ShouldStop(1);
main.mostCurrent._ready.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 162;BA.debugLine="sr.Indeterminate=True";
Debug.ShouldStop(2);
main.mostCurrent._sr.runMethod(true,"setIndeterminate",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 163;BA.debugLine="ss.PrefixText=\"Scan: \"";
Debug.ShouldStop(4);
main.mostCurrent._ss.runMethod(true,"setPrefixText",BA.ObjectToString("Scan: "));
 BA.debugLineNum = 164;BA.debugLine="ss.SuffixText=\"/ \"&kvst.Get(\"ta\")&\" Apps\"";
Debug.ShouldStop(8);
main.mostCurrent._ss.runMethod(true,"setSuffixText",RemoteObject.concat(RemoteObject.createImmutable("/ "),main.mostCurrent._kvst.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("ta"))),RemoteObject.createImmutable(" Apps")));
 BA.debugLineNum = 165;BA.debugLine="ss.FinishedStrokeWidth=15dip";
Debug.ShouldStop(16);
main.mostCurrent._ss.runMethod(true,"setFinishedStrokeWidth",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))));
 BA.debugLineNum = 166;BA.debugLine="ss.UnfinishedStrokeWidth=10dip";
Debug.ShouldStop(32);
main.mostCurrent._ss.runMethod(true,"setUnfinishedStrokeWidth",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))));
 BA.debugLineNum = 167;BA.debugLine="ss.FinishedStrokeColor= mcl.md_amber_700";
Debug.ShouldStop(64);
main.mostCurrent._ss.runMethod(true,"setFinishedStrokeColor",main.mostCurrent._mcl.runMethod(true,"getmd_amber_700"));
 BA.debugLineNum = 168;BA.debugLine="ss.UnfinishedStrokeColor=mcl.md_grey_600";
Debug.ShouldStop(128);
main.mostCurrent._ss.runMethod(true,"setUnfinishedStrokeColor",main.mostCurrent._mcl.runMethod(true,"getmd_grey_600"));
 BA.debugLineNum = 169;BA.debugLine="ss.TextSize=30";
Debug.ShouldStop(256);
main.mostCurrent._ss.runMethod(true,"setTextSize",BA.numberCast(float.class, 30));
 BA.debugLineNum = 170;BA.debugLine="ss.Max=abase.ListKeys.Size";
Debug.ShouldStop(512);
main.mostCurrent._ss.runMethod(true,"setMax",main.mostCurrent._abase.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys").runMethod(true,"getSize"));
 BA.debugLineNum = 171;BA.debugLine="Dim ml As MLfiles";
Debug.ShouldStop(1024);
_ml = RemoteObject.createNew ("MLfiles.Fileslib.MLfiles");Debug.locals.put("ml", _ml);
 BA.debugLineNum = 172;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(2048);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 174;BA.debugLine="If ml.SdcardReady=\"mounted\" Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_ml.runMethod(true,"SdcardReady"),BA.ObjectToString("mounted"))) { 
 BA.debugLineNum = 175;BA.debugLine="File.MakeDir(ml.GetExtSd,\"S-Cleaner/tmp\")";
Debug.ShouldStop(16384);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("MakeDir",(Object)(_ml.runMethod(true,"GetExtSd")),(Object)(RemoteObject.createImmutable("S-Cleaner/tmp")));
 BA.debugLineNum = 176;BA.debugLine="ToastMessageShow(\"SD Karte erkannt: \"&ml.GetExt";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("SD Karte erkannt: "),_ml.runMethod(true,"GetExtSd")))),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 };
 BA.debugLineNum = 180;BA.debugLine="CallSubDelayed(Starter,\"info_remote\")";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.processBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("info_remote")));
 BA.debugLineNum = 181;BA.debugLine="l_stat";
Debug.ShouldStop(1048576);
_l_stat();
 BA.debugLineNum = 182;BA.debugLine="left";
Debug.ShouldStop(2097152);
_left();
 BA.debugLineNum = 183;BA.debugLine="p_button";
Debug.ShouldStop(4194304);
_p_button();
 BA.debugLineNum = 184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_createmenu(RemoteObject _menu) throws Exception{
try {
		Debug.PushSubsStack("Activity_CreateMenu (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,198);
if (RapidSub.canDelegate("activity_createmenu")) return de.sclean.main.remoteMe.runUserSub(false, "main","activity_createmenu", _menu);
RemoteObject _eim = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _fim1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _climg1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _item = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACMenuItemWrapper");
RemoteObject _item2 = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACMenuItemWrapper");
RemoteObject _item3 = RemoteObject.declareNull("de.amberhome.objects.appcompat.ACMenuItemWrapper");
Debug.locals.put("menu", _menu);
 BA.debugLineNum = 198;BA.debugLine="Sub Activity_CreateMenu(menu As ACMenu)";
Debug.ShouldStop(32);
 BA.debugLineNum = 199;BA.debugLine="Dim eim As BitmapDrawable";
Debug.ShouldStop(64);
_eim = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("eim", _eim);
 BA.debugLineNum = 200;BA.debugLine="eim.Initialize(LoadBitmap(File.DirAssets,\"ic_exit";
Debug.ShouldStop(128);
_eim.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ic_exit_to_app_white_48dp.png"))).getObject())));
 BA.debugLineNum = 201;BA.debugLine="Dim fim1,climg1 As BitmapDrawable";
Debug.ShouldStop(256);
_fim1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("fim1", _fim1);
_climg1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("climg1", _climg1);
 BA.debugLineNum = 202;BA.debugLine="fim1.Initialize(LoadBitmap(File.DirAssets,\"ic_set";
Debug.ShouldStop(512);
_fim1.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ic_settings_applications_white_36dp.png"))).getObject())));
 BA.debugLineNum = 203;BA.debugLine="climg1.Initialize(LoadBitmap(File.DirAssets,\"ic_a";
Debug.ShouldStop(1024);
_climg1.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ic_apps_white_36dp.png"))).getObject())));
 BA.debugLineNum = 204;BA.debugLine="menu.Clear";
Debug.ShouldStop(2048);
_menu.runVoidMethod ("Clear");
 BA.debugLineNum = 205;BA.debugLine="Dim item,item2,item3 As ACMenuItem";
Debug.ShouldStop(4096);
_item = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACMenuItemWrapper");Debug.locals.put("item", _item);
_item2 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACMenuItemWrapper");Debug.locals.put("item2", _item2);
_item3 = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACMenuItemWrapper");Debug.locals.put("item3", _item3);
 BA.debugLineNum = 206;BA.debugLine="item3=toolbar.Menu.Add2(0, 0, \"Menu\", climg1)";
Debug.ShouldStop(8192);
_item3 = main.mostCurrent._toolbar.runMethod(false,"getMenu").runMethod(false,"Add2",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.ObjectToCharSequence("Menu")),(Object)((_climg1.getObject())));Debug.locals.put("item3", _item3);
 BA.debugLineNum = 207;BA.debugLine="item=toolbar.Menu.Add2(1, 1, \"SMenu\", fim1)";
Debug.ShouldStop(16384);
_item = main.mostCurrent._toolbar.runMethod(false,"getMenu").runMethod(false,"Add2",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.ObjectToCharSequence("SMenu")),(Object)((_fim1.getObject())));Debug.locals.put("item", _item);
 BA.debugLineNum = 208;BA.debugLine="item2=toolbar.Menu.Add2(2, 2, \"Exit\", eim)";
Debug.ShouldStop(32768);
_item2 = main.mostCurrent._toolbar.runMethod(false,"getMenu").runMethod(false,"Add2",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.ObjectToCharSequence("Exit")),(Object)((_eim.getObject())));Debug.locals.put("item2", _item2);
 BA.debugLineNum = 209;BA.debugLine="item.ShowAsAction = item.SHOW_AS_ACTION_ALWAYS";
Debug.ShouldStop(65536);
_item.runVoidMethod ("setShowAsAction",_item.getField(true,"SHOW_AS_ACTION_ALWAYS"));
 BA.debugLineNum = 210;BA.debugLine="item2.ShowAsAction = item2.SHOW_AS_ACTION_ALWAYS";
Debug.ShouldStop(131072);
_item2.runVoidMethod ("setShowAsAction",_item2.getField(true,"SHOW_AS_ACTION_ALWAYS"));
 BA.debugLineNum = 211;BA.debugLine="item3.ShowAsAction = item3.SHOW_AS_ACTION_ALWAYS";
Debug.ShouldStop(262144);
_item3.runVoidMethod ("setShowAsAction",_item3.getField(true,"SHOW_AS_ACTION_ALWAYS"));
 BA.debugLineNum = 212;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,194);
if (RapidSub.canDelegate("activity_pause")) return de.sclean.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 194;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 196;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,186);
if (RapidSub.canDelegate("activity_resume")) return de.sclean.main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 186;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 187;BA.debugLine="xOSStats.StartStats";
Debug.ShouldStop(67108864);
main.mostCurrent._xosstats.runVoidMethod ("_startstats");
 BA.debugLineNum = 188;BA.debugLine="If pn.Visible=True Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main.mostCurrent._pn.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 189;BA.debugLine="pn.SetVisibleAnimated(300,False)";
Debug.ShouldStop(268435456);
main.mostCurrent._pn.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 300)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 192;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _closedia_buttonpressed(RemoteObject _dialog,RemoteObject _action) throws Exception{
try {
		Debug.PushSubsStack("closedia_ButtonPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,732);
if (RapidSub.canDelegate("closedia_buttonpressed")) return de.sclean.main.remoteMe.runUserSub(false, "main","closedia_buttonpressed", _dialog, _action);
Debug.locals.put("Dialog", _dialog);
Debug.locals.put("Action", _action);
 BA.debugLineNum = 732;BA.debugLine="Sub closedia_ButtonPressed (Dialog As MaterialDial";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 733;BA.debugLine="Select Action";
Debug.ShouldStop(268435456);
switch (BA.switchObjectToInt(_action,_dialog.getField(true,"ACTION_POSITIVE"),_dialog.getField(true,"ACTION_NEGATIVE"),_dialog.getField(true,"ACTION_NEUTRAL"))) {
case 0: {
 BA.debugLineNum = 735;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
main.mostCurrent._activity.runVoidMethod ("Finish");
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
 BA.debugLineNum = 741;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createclickableword(RemoteObject _text) throws Exception{
try {
		Debug.PushSubsStack("CreateClickableWord (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,679);
if (RapidSub.canDelegate("createclickableword")) return de.sclean.main.remoteMe.runUserSub(false, "main","createclickableword", _text);
RemoteObject _cs = RemoteObject.declareNull("anywheresoftware.b4a.objects.CSBuilder");
Debug.locals.put("Text", _text);
 BA.debugLineNum = 679;BA.debugLine="Sub CreateClickableWord(Text As String) As CSBuild";
Debug.ShouldStop(64);
 BA.debugLineNum = 680;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(128);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 681;BA.debugLine="Return cs.Initialize.Underline.Color(0xFF00D0FF).";
Debug.ShouldStop(256);
if (true) return _cs.runMethod(false,"Initialize").runMethod(false,"Underline").runMethod(false,"Color",(Object)(BA.numberCast(int.class, 0xff00d0ff))).runMethod(false,"Clickable",main.processBA,(Object)(BA.ObjectToString("Word")),(Object)((_text))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(_text))).runMethod(false,"PopAll");
 BA.debugLineNum = 682;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dexa_buttonpressed(RemoteObject _dialog,RemoteObject _action) throws Exception{
try {
		Debug.PushSubsStack("dexa_ButtonPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,399);
if (RapidSub.canDelegate("dexa_buttonpressed")) return de.sclean.main.remoteMe.runUserSub(false, "main","dexa_buttonpressed", _dialog, _action);
Debug.locals.put("Dialog", _dialog);
Debug.locals.put("Action", _action);
 BA.debugLineNum = 399;BA.debugLine="Sub dexa_ButtonPressed (Dialog As MaterialDialog,";
Debug.ShouldStop(16384);
 BA.debugLineNum = 400;BA.debugLine="Select Action";
Debug.ShouldStop(32768);
switch (BA.switchObjectToInt(_action,_dialog.getField(true,"ACTION_POSITIVE"),_dialog.getField(true,"ACTION_NEGATIVE"),_dialog.getField(true,"ACTION_NEUTRAL"))) {
case 0: {
 BA.debugLineNum = 402;BA.debugLine="dbase.DeleteAll";
Debug.ShouldStop(131072);
main.mostCurrent._dbase.runClassMethod (de.sclean.keyvaluestore.class, "_deleteall");
 BA.debugLineNum = 403;BA.debugLine="ToastMessageShow(\"counter reset: erfolgreich\",F";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("counter reset: erfolgreich")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
 BA.debugLineNum = 409;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dialog3_buttonpressed(RemoteObject _dialog,RemoteObject _action) throws Exception{
try {
		Debug.PushSubsStack("Dialog3_ButtonPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,696);
if (RapidSub.canDelegate("dialog3_buttonpressed")) return de.sclean.main.remoteMe.runUserSub(false, "main","dialog3_buttonpressed", _dialog, _action);
RemoteObject _cts = RemoteObject.declareNull("com.rootsoft.customtoast.CustomToast");
Debug.locals.put("Dialog", _dialog);
Debug.locals.put("Action", _action);
 BA.debugLineNum = 696;BA.debugLine="Sub Dialog3_ButtonPressed (Dialog As MaterialDialo";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 697;BA.debugLine="Select Action";
Debug.ShouldStop(16777216);
switch (BA.switchObjectToInt(_action,_dialog.getField(true,"ACTION_POSITIVE"),_dialog.getField(true,"ACTION_NEGATIVE"),_dialog.getField(true,"ACTION_NEUTRAL"))) {
case 0: {
 break; }
case 1: {
 break; }
case 2: {
 BA.debugLineNum = 703;BA.debugLine="Dim cts As CustomToast";
Debug.ShouldStop(1073741824);
_cts = RemoteObject.createNew ("com.rootsoft.customtoast.CustomToast");Debug.locals.put("cts", _cts);
 BA.debugLineNum = 704;BA.debugLine="cts.Initialize";
Debug.ShouldStop(-2147483648);
_cts.runVoidMethod ("Initialize",main.processBA);
 BA.debugLineNum = 705;BA.debugLine="cts.ShowBitmap(\"© 2017\",3,0,0,Gravity.BOTTOM,Lo";
Debug.ShouldStop(1);
_cts.runVoidMethod ("ShowBitmap",(Object)(BA.ObjectToCharSequence("© 2017")),(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.getField(false,"Gravity").getField(true,"BOTTOM")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("smm_small_logo.png"))).getObject())));
 break; }
}
;
 BA.debugLineNum = 707;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dp_clean() throws Exception{
try {
		Debug.PushSubsStack("dp_clean (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,605);
if (RapidSub.canDelegate("dp_clean")) return de.sclean.main.remoteMe.runUserSub(false, "main","dp_clean");
RemoteObject _lu = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 605;BA.debugLine="Sub dp_clean";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 606;BA.debugLine="Dim lu As Label";
Debug.ShouldStop(536870912);
_lu = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lu", _lu);
 BA.debugLineNum = 607;BA.debugLine="lu.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_lu.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 608;BA.debugLine="lu.Typeface=rfont";
Debug.ShouldStop(-2147483648);
_lu.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 609;BA.debugLine="schredder(False)";
Debug.ShouldStop(1);
_schredder(main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 610;BA.debugLine="lu.Text=\"Start\"";
Debug.ShouldStop(2);
_lu.runMethod(true,"setText",BA.ObjectToCharSequence("Start"));
 BA.debugLineNum = 611;BA.debugLine="prb.Text=lu.Text";
Debug.ShouldStop(4);
main.mostCurrent._prb.runMethod(true,"setText",BA.ObjectToCharSequence(_lu.runMethod(true,"getText")));
 BA.debugLineNum = 612;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dp_clear() throws Exception{
try {
		Debug.PushSubsStack("dp_clear (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,628);
if (RapidSub.canDelegate("dp_clear")) return de.sclean.main.remoteMe.runUserSub(false, "main","dp_clear");
 BA.debugLineNum = 628;BA.debugLine="Sub dp_clear";
Debug.ShouldStop(524288);
 BA.debugLineNum = 629;BA.debugLine="ready.Visible=False";
Debug.ShouldStop(1048576);
main.mostCurrent._ready.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 630;BA.debugLine="xOSStats.StartStats";
Debug.ShouldStop(2097152);
main.mostCurrent._xosstats.runVoidMethod ("_startstats");
 BA.debugLineNum = 631;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dp_off() throws Exception{
try {
		Debug.PushSubsStack("dp_off (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,619);
if (RapidSub.canDelegate("dp_off")) return de.sclean.main.remoteMe.runUserSub(false, "main","dp_off");
 BA.debugLineNum = 619;BA.debugLine="Sub dp_off";
Debug.ShouldStop(1024);
 BA.debugLineNum = 621;BA.debugLine="pn.SetVisibleAnimated(450,False)";
Debug.ShouldStop(4096);
main.mostCurrent._pn.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 450)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 622;BA.debugLine="t1_start";
Debug.ShouldStop(8192);
_t1_start();
 BA.debugLineNum = 623;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dp_start() throws Exception{
try {
		Debug.PushSubsStack("dp_start (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,624);
if (RapidSub.canDelegate("dp_start")) return de.sclean.main.remoteMe.runUserSub(false, "main","dp_start");
 BA.debugLineNum = 624;BA.debugLine="Sub dp_start";
Debug.ShouldStop(32768);
 BA.debugLineNum = 626;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _exit_click() throws Exception{
try {
		Debug.PushSubsStack("exit_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,709);
if (RapidSub.canDelegate("exit_click")) return de.sclean.main.remoteMe.runUserSub(false, "main","exit_click");
RemoteObject _infodia = RemoteObject.declareNull("de.amberhome.materialdialogs.MaterialDialogWrapper");
RemoteObject _builder = RemoteObject.declareNull("de.amberhome.materialdialogs.MaterialDialogBuilderWrapper");
RemoteObject _inf = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _l1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _l2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 709;BA.debugLine="Sub exit_click";
Debug.ShouldStop(16);
 BA.debugLineNum = 710;BA.debugLine="Dim infodia As MaterialDialog";
Debug.ShouldStop(32);
_infodia = RemoteObject.createNew ("de.amberhome.materialdialogs.MaterialDialogWrapper");Debug.locals.put("infodia", _infodia);
 BA.debugLineNum = 711;BA.debugLine="Dim Builder As MaterialDialogBuilder";
Debug.ShouldStop(64);
_builder = RemoteObject.createNew ("de.amberhome.materialdialogs.MaterialDialogBuilderWrapper");Debug.locals.put("Builder", _builder);
 BA.debugLineNum = 712;BA.debugLine="Dim inf As BitmapDrawable";
Debug.ShouldStop(128);
_inf = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("inf", _inf);
 BA.debugLineNum = 713;BA.debugLine="inf.Initialize(LoadBitmap(File.DirAssets,\"ic_sms_";
Debug.ShouldStop(256);
_inf.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ic_sms_failed_white_36dp.png"))).getObject())));
 BA.debugLineNum = 714;BA.debugLine="Dim l1,l2 As Label";
Debug.ShouldStop(512);
_l1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l1", _l1);
_l2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l2", _l2);
 BA.debugLineNum = 715;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(1024);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 716;BA.debugLine="pnl.Initialize(\"pnl\")";
Debug.ShouldStop(2048);
_pnl.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("pnl")));
 BA.debugLineNum = 717;BA.debugLine="l1.Initialize(\"\")";
Debug.ShouldStop(4096);
_l1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 718;BA.debugLine="l2.Initialize(\"\")";
Debug.ShouldStop(8192);
_l2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 719;BA.debugLine="l2.TextSize=16";
Debug.ShouldStop(16384);
_l2.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 720;BA.debugLine="l1.TextSize=15";
Debug.ShouldStop(32768);
_l1.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 721;BA.debugLine="l1.textcolor=mcl.md_white_1000";
Debug.ShouldStop(65536);
_l1.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_white_1000"));
 BA.debugLineNum = 722;BA.debugLine="l1.Text=\"Scleaner schließen? *Der Service, wenn n";
Debug.ShouldStop(131072);
_l1.runMethod(true,"setText",BA.ObjectToCharSequence("Scleaner schließen? *Der Service, wenn nicht anders eingestellt, wird im Hintergrund weiter ausgeführt!"));
 BA.debugLineNum = 723;BA.debugLine="l2.textcolor=mcl.md_white_1000";
Debug.ShouldStop(262144);
_l2.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_white_1000"));
 BA.debugLineNum = 724;BA.debugLine="l1.Gravity=Gravity.TOP";
Debug.ShouldStop(524288);
_l1.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP"));
 BA.debugLineNum = 725;BA.debugLine="l1.Typeface=rfont";
Debug.ShouldStop(1048576);
_l1.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 726;BA.debugLine="l2.Typeface=rfont";
Debug.ShouldStop(2097152);
_l2.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 727;BA.debugLine="Builder.Initialize(\"closedia\")";
Debug.ShouldStop(4194304);
_builder.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("closedia")));
 BA.debugLineNum = 728;BA.debugLine="Builder.Title(\"Beenden?\").TitleColor(mcl.md_black";
Debug.ShouldStop(8388608);
_builder.runMethod(false,"Title",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Beenden?")))).runMethod(false,"TitleColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_black_1000"))).runMethod(false,"Icon",(Object)((_inf.getObject()))).runMethod(false,"LimitIconToDefaultSize").runMethod(false,"Theme",(Object)(_builder.getField(false,"THEME_DARK"))).runMethod(false,"Content",(Object)(BA.ObjectToCharSequence(_l1.runMethod(true,"getText")))).runMethod(false,"ContentLineSpacing",(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))))).runMethod(false,"Cancelable",(Object)(main.mostCurrent.__c.getField(true,"True"))).runMethod(false,"NeutralText",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Abbrechen")))).runMethod(false,"Typeface",(Object)((main._rfont.getObject())),(Object)((main._rfont.getObject()))).runMethod(false,"NeutralColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_grey_400"))).runMethod(false,"PositiveText",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Ja bitte")))).runMethod(false,"PositiveColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_amber_300"))).runVoidMethod ("ContentGravity",(Object)(_builder.getField(false,"GRAVITY_START")));
 BA.debugLineNum = 729;BA.debugLine="infodia=Builder.Show";
Debug.ShouldStop(16777216);
_infodia = _builder.runMethod(false,"Show");Debug.locals.put("infodia", _infodia);
 BA.debugLineNum = 730;BA.debugLine="infodia.Show";
Debug.ShouldStop(33554432);
_infodia.runVoidMethod ("Show");
 BA.debugLineNum = 731;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fexa_buttonpressed(RemoteObject _dialog,RemoteObject _action) throws Exception{
try {
		Debug.PushSubsStack("fexa_ButtonPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,262);
if (RapidSub.canDelegate("fexa_buttonpressed")) return de.sclean.main.remoteMe.runUserSub(false, "main","fexa_buttonpressed", _dialog, _action);
Debug.locals.put("Dialog", _dialog);
Debug.locals.put("Action", _action);
 BA.debugLineNum = 262;BA.debugLine="Sub fexa_ButtonPressed (Dialog As MaterialDialog,";
Debug.ShouldStop(32);
 BA.debugLineNum = 263;BA.debugLine="Select Action";
Debug.ShouldStop(64);
switch (BA.switchObjectToInt(_action,_dialog.getField(true,"ACTION_POSITIVE"),_dialog.getField(true,"ACTION_NEGATIVE"),_dialog.getField(true,"ACTION_NEUTRAL"))) {
case 0: {
 BA.debugLineNum = 265;BA.debugLine="alist.DeleteAll";
Debug.ShouldStop(256);
main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_deleteall");
 BA.debugLineNum = 266;BA.debugLine="lv1.Clear";
Debug.ShouldStop(512);
main.mostCurrent._lv1.runVoidMethod ("Clear");
 BA.debugLineNum = 267;BA.debugLine="Activity.Invalidate";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runVoidMethod ("Invalidate");
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
 BA.debugLineNum = 273;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("FormatFileSize (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,638);
if (RapidSub.canDelegate("formatfilesize")) return de.sclean.main.remoteMe.runUserSub(false, "main","formatfilesize", _bytes);
RemoteObject _unit = null;
RemoteObject _po = RemoteObject.createImmutable(0);
RemoteObject _si = RemoteObject.createImmutable(0);
RemoteObject _i = RemoteObject.createImmutable(0);
Debug.locals.put("Bytes", _bytes);
 BA.debugLineNum = 638;BA.debugLine="Sub FormatFileSize(Bytes As Float) As String";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 639;BA.debugLine="Private Unit() As String = Array As String(\" Byte";
Debug.ShouldStop(1073741824);
_unit = RemoteObject.createNewArray("String",new int[] {9},new Object[] {BA.ObjectToString(" Byte"),BA.ObjectToString(" KB"),BA.ObjectToString(" MB"),BA.ObjectToString(" GB"),BA.ObjectToString(" TB"),BA.ObjectToString(" PB"),BA.ObjectToString(" EB"),BA.ObjectToString(" ZB"),RemoteObject.createImmutable(" YB")});Debug.locals.put("Unit", _unit);Debug.locals.put("Unit", _unit);
 BA.debugLineNum = 640;BA.debugLine="If Bytes = 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_bytes,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 641;BA.debugLine="Return \"0 Bytes\"";
Debug.ShouldStop(1);
if (true) return BA.ObjectToString("0 Bytes");
 }else {
 BA.debugLineNum = 643;BA.debugLine="Private Po, Si As Double";
Debug.ShouldStop(4);
_po = RemoteObject.createImmutable(0);Debug.locals.put("Po", _po);
_si = RemoteObject.createImmutable(0);Debug.locals.put("Si", _si);
 BA.debugLineNum = 644;BA.debugLine="Private I As Int";
Debug.ShouldStop(8);
_i = RemoteObject.createImmutable(0);Debug.locals.put("I", _i);
 BA.debugLineNum = 645;BA.debugLine="Bytes = Abs(Bytes)";
Debug.ShouldStop(16);
_bytes = BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"Abs",(Object)(BA.numberCast(double.class, _bytes))));Debug.locals.put("Bytes", _bytes);
 BA.debugLineNum = 646;BA.debugLine="I = Floor(Logarithm(Bytes, 1024))";
Debug.ShouldStop(32);
_i = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Floor",(Object)(main.mostCurrent.__c.runMethod(true,"Logarithm",(Object)(BA.numberCast(double.class, _bytes)),(Object)(BA.numberCast(double.class, 1024))))));Debug.locals.put("I", _i);
 BA.debugLineNum = 647;BA.debugLine="Po = Power(1024, I)";
Debug.ShouldStop(64);
_po = main.mostCurrent.__c.runMethod(true,"Power",(Object)(BA.numberCast(double.class, 1024)),(Object)(BA.numberCast(double.class, _i)));Debug.locals.put("Po", _po);
 BA.debugLineNum = 648;BA.debugLine="Si = Bytes / Po";
Debug.ShouldStop(128);
_si = RemoteObject.solve(new RemoteObject[] {_bytes,_po}, "/",0, 0);Debug.locals.put("Si", _si);
 BA.debugLineNum = 649;BA.debugLine="Return NumberFormat(Si, 1, 2) & Unit(I)";
Debug.ShouldStop(256);
if (true) return RemoteObject.concat(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_si),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2))),_unit.getArrayElement(true,_i));
 };
 BA.debugLineNum = 651;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getsdk() throws Exception{
try {
		Debug.PushSubsStack("GetSDK (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,309);
if (RapidSub.canDelegate("getsdk")) return de.sclean.main.remoteMe.runUserSub(false, "main","getsdk");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
 BA.debugLineNum = 309;BA.debugLine="Sub GetSDK() As Int";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 310;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(2097152);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 311;BA.debugLine="Return p.SdkVersion";
Debug.ShouldStop(4194304);
if (true) return _p.runMethod(true,"getSdkVersion");
 BA.debugLineNum = 312;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getsdkversion() throws Exception{
try {
		Debug.PushSubsStack("GetSDKversion (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,313);
if (RapidSub.canDelegate("getsdkversion")) return de.sclean.main.remoteMe.runUserSub(false, "main","getsdkversion");
RemoteObject _versions = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
 BA.debugLineNum = 313;BA.debugLine="Sub GetSDKversion() As String";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 314;BA.debugLine="Dim versions As Map";
Debug.ShouldStop(33554432);
_versions = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("versions", _versions);
 BA.debugLineNum = 315;BA.debugLine="versions.Initialize";
Debug.ShouldStop(67108864);
_versions.runVoidMethod ("Initialize");
 BA.debugLineNum = 316;BA.debugLine="versions.Put(3,\"1.5\")";
Debug.ShouldStop(134217728);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((3))),(Object)((RemoteObject.createImmutable("1.5"))));
 BA.debugLineNum = 317;BA.debugLine="versions.Put(4,\"1.6\")";
Debug.ShouldStop(268435456);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((4))),(Object)((RemoteObject.createImmutable("1.6"))));
 BA.debugLineNum = 318;BA.debugLine="versions.Put(7,\"2.1\")";
Debug.ShouldStop(536870912);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((7))),(Object)((RemoteObject.createImmutable("2.1"))));
 BA.debugLineNum = 319;BA.debugLine="versions.Put(8,\"2.2\")";
Debug.ShouldStop(1073741824);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((8))),(Object)((RemoteObject.createImmutable("2.2"))));
 BA.debugLineNum = 320;BA.debugLine="versions.Put(10,\"2.3.3\")";
Debug.ShouldStop(-2147483648);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((10))),(Object)((RemoteObject.createImmutable("2.3.3"))));
 BA.debugLineNum = 321;BA.debugLine="versions.Put(11,\"3.0\")";
Debug.ShouldStop(1);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((11))),(Object)((RemoteObject.createImmutable("3.0"))));
 BA.debugLineNum = 322;BA.debugLine="versions.Put(12,\"3.1\")";
Debug.ShouldStop(2);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((12))),(Object)((RemoteObject.createImmutable("3.1"))));
 BA.debugLineNum = 323;BA.debugLine="versions.Put(13,\"3.2\")";
Debug.ShouldStop(4);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((13))),(Object)((RemoteObject.createImmutable("3.2"))));
 BA.debugLineNum = 324;BA.debugLine="versions.Put(14,\"4.0\")";
Debug.ShouldStop(8);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((14))),(Object)((RemoteObject.createImmutable("4.0"))));
 BA.debugLineNum = 325;BA.debugLine="versions.Put(15,\"4.0.3\")";
Debug.ShouldStop(16);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((15))),(Object)((RemoteObject.createImmutable("4.0.3"))));
 BA.debugLineNum = 326;BA.debugLine="versions.Put(16,\"4.1.2\")";
Debug.ShouldStop(32);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((16))),(Object)((RemoteObject.createImmutable("4.1.2"))));
 BA.debugLineNum = 327;BA.debugLine="versions.Put(17,\"4.2.2\")";
Debug.ShouldStop(64);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((17))),(Object)((RemoteObject.createImmutable("4.2.2"))));
 BA.debugLineNum = 328;BA.debugLine="versions.Put(18,\"4.3\")";
Debug.ShouldStop(128);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((18))),(Object)((RemoteObject.createImmutable("4.3"))));
 BA.debugLineNum = 329;BA.debugLine="versions.Put(19,\"4.4.2\")";
Debug.ShouldStop(256);
_versions.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable((19))),(Object)((RemoteObject.createImmutable("4.4.2"))));
 BA.debugLineNum = 330;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(512);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 331;BA.debugLine="Return versions.Get(p.SdkVersion)";
Debug.ShouldStop(1024);
if (true) return BA.ObjectToString(_versions.runMethod(false,"Get",(Object)((_p.runMethod(true,"getSdkVersion")))));
 BA.debugLineNum = 332;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 35;BA.debugLine="Private pack As PackageManager";
main.mostCurrent._pack = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private mcl As MaterialColors";
main.mostCurrent._mcl = RemoteObject.createNew ("com.tchart.materialcolors.MaterialColors");
 //BA.debugLineNum = 37;BA.debugLine="Private lv1 As ListView";
main.mostCurrent._lv1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private ac As AppCompat";
main.mostCurrent._ac = RemoteObject.createNew ("de.amberhome.objects.appcompat.AppCompatBase");
 //BA.debugLineNum = 39;BA.debugLine="Dim xMSOS As MSOS";
main.mostCurrent._xmsos = RemoteObject.createNew ("com.maximussoft.msos.MSOS");
 //BA.debugLineNum = 40;BA.debugLine="Dim xOSStats As OSStats";
main.mostCurrent._xosstats = RemoteObject.createNew ("b4a.example.osstats");
 //BA.debugLineNum = 41;BA.debugLine="Dim dir As String=File.DirInternal&\"/Bdata\"";
main.mostCurrent._dir = RemoteObject.concat(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"),RemoteObject.createImmutable("/Bdata"));
 //BA.debugLineNum = 42;BA.debugLine="Private kvst,kvsdata,alist,dbase,abase As KeyValu";
main.mostCurrent._kvst = RemoteObject.createNew ("de.sclean.keyvaluestore");
main.mostCurrent._kvsdata = RemoteObject.createNew ("de.sclean.keyvaluestore");
main.mostCurrent._alist = RemoteObject.createNew ("de.sclean.keyvaluestore");
main.mostCurrent._dbase = RemoteObject.createNew ("de.sclean.keyvaluestore");
main.mostCurrent._abase = RemoteObject.createNew ("de.sclean.keyvaluestore");
 //BA.debugLineNum = 44;BA.debugLine="Dim paths As Map";
main.mostCurrent._paths = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 45;BA.debugLine="Private im1 As ImageView";
main.mostCurrent._im1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private olist As List";
main.mostCurrent._olist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 47;BA.debugLine="Private leftlist As ListView";
main.mostCurrent._leftlist = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private sm As SlidingMenu";
main.mostCurrent._sm = RemoteObject.createNew ("anywheresoftware.b4a.objects.SlidingMenuWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private counter As Int";
main._counter = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 50;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Dim ABHelper As ACActionBar";
main.mostCurrent._abhelper = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACActionBar");
 //BA.debugLineNum = 52;BA.debugLine="Private toolbar As ACToolBarDark";
main.mostCurrent._toolbar = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACToolbarDarkWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Dim dia As MaterialDialog";
main.mostCurrent._dia = RemoteObject.createNew ("de.amberhome.materialdialogs.MaterialDialogWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private ipan2 As Panel";
main.mostCurrent._ipan2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Dim ss As DonutProgressMaster";
main.mostCurrent._ss = RemoteObject.createNew ("circleprogressmasterwrapper.donutProgressMasterWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private ldim,pdim As Panel";
main.mostCurrent._ldim = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._pdim = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Dim lolist As ListView";
main.mostCurrent._lolist = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private tota As Label";
main.mostCurrent._tota = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private extrapan,pn As Panel";
main.mostCurrent._extrapan = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._pn = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private pb1 As ArcProgressMaster";
main.mostCurrent._pb1 = RemoteObject.createNew ("circleprogressmasterwrapper.arcProgressMasterWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private pb2 As ArcProgressMaster";
main.mostCurrent._pb2 = RemoteObject.createNew ("circleprogressmasterwrapper.arcProgressMasterWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Dim args(1) As Object";
main.mostCurrent._args = RemoteObject.createNewArray ("Object", new int[] {1}, new Object[]{});
 //BA.debugLineNum = 63;BA.debugLine="Dim Obj1, Obj2, Obj3 As Reflector";
main.mostCurrent._obj1 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");
main.mostCurrent._obj2 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");
main.mostCurrent._obj3 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");
 //BA.debugLineNum = 64;BA.debugLine="Dim size,flags As Int";
main._size = RemoteObject.createImmutable(0);
main._flags = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 65;BA.debugLine="Private name,apath,l,Types(1),packName As String";
main.mostCurrent._name = RemoteObject.createImmutable("");
main.mostCurrent._apath = RemoteObject.createImmutable("");
main.mostCurrent._l = RemoteObject.createImmutable("");
main.mostCurrent._types = RemoteObject.createNewArray ("String", new int[] {1}, new Object[]{});
main.mostCurrent._packname = RemoteObject.createImmutable("");
 //BA.debugLineNum = 66;BA.debugLine="Private sl As Label";
main.mostCurrent._sl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Dim sr As ProgressBar";
main.mostCurrent._sr = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 68;BA.debugLine="Dim ready As ImageView";
main.mostCurrent._ready = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 69;BA.debugLine="Private prb As ACFlatButton";
main.mostCurrent._prb = RemoteObject.createNew ("de.amberhome.objects.appcompat.ACFlatButtonWrapper");
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _hexa_buttonpressed(RemoteObject _dialog,RemoteObject _action) throws Exception{
try {
		Debug.PushSubsStack("hexa_ButtonPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,519);
if (RapidSub.canDelegate("hexa_buttonpressed")) return de.sclean.main.remoteMe.runUserSub(false, "main","hexa_buttonpressed", _dialog, _action);
Debug.locals.put("Dialog", _dialog);
Debug.locals.put("Action", _action);
 BA.debugLineNum = 519;BA.debugLine="Sub hexa_ButtonPressed (Dialog As MaterialDialog,";
Debug.ShouldStop(64);
 BA.debugLineNum = 520;BA.debugLine="Select Action";
Debug.ShouldStop(128);
switch (BA.switchObjectToInt(_action,_dialog.getField(true,"ACTION_POSITIVE"),_dialog.getField(true,"ACTION_NEGATIVE"),_dialog.getField(true,"ACTION_NEUTRAL"))) {
case 0: {
 break; }
case 1: {
 break; }
case 2: {
 break; }
}
;
 BA.debugLineNum = 528;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _im_ad() throws Exception{
try {
		Debug.PushSubsStack("im_ad (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,552);
if (RapidSub.canDelegate("im_ad")) return de.sclean.main.remoteMe.runUserSub(false, "main","im_ad");
RemoteObject _icon = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _la1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _la2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _d = RemoteObject.createImmutable("");
RemoteObject _lt = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 552;BA.debugLine="Sub im_ad";
Debug.ShouldStop(128);
 BA.debugLineNum = 553;BA.debugLine="Dim icon As BitmapDrawable";
Debug.ShouldStop(256);
_icon = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("icon", _icon);
 BA.debugLineNum = 554;BA.debugLine="Dim la1,la2 As Label";
Debug.ShouldStop(512);
_la1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("la1", _la1);
_la2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("la2", _la2);
 BA.debugLineNum = 555;BA.debugLine="la2.Initialize(\"la2\")";
Debug.ShouldStop(1024);
_la2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("la2")));
 BA.debugLineNum = 556;BA.debugLine="la1.Initialize(\"la1\")";
Debug.ShouldStop(2048);
_la1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("la1")));
 BA.debugLineNum = 557;BA.debugLine="la1=lolist.TwoLinesAndBitmap.Label";
Debug.ShouldStop(4096);
_la1 = main.mostCurrent._lolist.runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label");Debug.locals.put("la1", _la1);
 BA.debugLineNum = 558;BA.debugLine="la2=lolist.TwoLinesAndBitmap.SecondLabel";
Debug.ShouldStop(8192);
_la2 = main.mostCurrent._lolist.runMethod(false,"getTwoLinesAndBitmap").getField(false,"SecondLabel");Debug.locals.put("la2", _la2);
 BA.debugLineNum = 559;BA.debugLine="la1.TextSize=15";
Debug.ShouldStop(16384);
_la1.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 560;BA.debugLine="la2.TextSize=13";
Debug.ShouldStop(32768);
_la2.runMethod(true,"setTextSize",BA.numberCast(float.class, 13));
 BA.debugLineNum = 561;BA.debugLine="la1.Typeface=rfont";
Debug.ShouldStop(65536);
_la1.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 562;BA.debugLine="la2.Typeface=rfont";
Debug.ShouldStop(131072);
_la2.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 563;BA.debugLine="la1.TextColor=mcl.md_white_1000";
Debug.ShouldStop(262144);
_la1.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_white_1000"));
 BA.debugLineNum = 564;BA.debugLine="la2.TextColor=mcl.md_amber_500";
Debug.ShouldStop(524288);
_la2.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_amber_500"));
 BA.debugLineNum = 565;BA.debugLine="lolist.TwoLinesAndBitmap.ImageView.Height=32dip";
Debug.ShouldStop(1048576);
main.mostCurrent._lolist.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32))));
 BA.debugLineNum = 566;BA.debugLine="lolist.TwoLinesAndBitmap.ImageView.Width=32dip";
Debug.ShouldStop(2097152);
main.mostCurrent._lolist.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32))));
 BA.debugLineNum = 567;BA.debugLine="lolist.TwoLinesAndBitmap.ItemHeight=55dip";
Debug.ShouldStop(4194304);
main.mostCurrent._lolist.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"setItemHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55))));
 BA.debugLineNum = 568;BA.debugLine="lolist.Clear";
Debug.ShouldStop(8388608);
main.mostCurrent._lolist.runVoidMethod ("Clear");
 BA.debugLineNum = 569;BA.debugLine="For Each d As String In alist.ListKeys";
Debug.ShouldStop(16777216);
{
final RemoteObject group17 = main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys");
final int groupLen17 = group17.runMethod(true,"getSize").<Integer>get()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_d = BA.ObjectToString(group17.runMethod(false,"Get",index17));Debug.locals.put("d", _d);
Debug.locals.put("d", _d);
 BA.debugLineNum = 570;BA.debugLine="icon=pack.GetApplicationIcon(d)";
Debug.ShouldStop(33554432);
_icon.setObject(main.mostCurrent._pack.runMethod(false,"GetApplicationIcon",(Object)(_d)));
 BA.debugLineNum = 571;BA.debugLine="lolist.AddTwoLinesAndBitmap(pack.GetApplicationL";
Debug.ShouldStop(67108864);
main.mostCurrent._lolist.runVoidMethod ("AddTwoLinesAndBitmap",(Object)(BA.ObjectToCharSequence(main.mostCurrent._pack.runMethod(true,"GetApplicationLabel",(Object)(_d)))),(Object)(BA.ObjectToCharSequence(_formatfilesize(BA.numberCast(float.class, main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(_d)))))),(Object)(_icon.runMethod(false,"getBitmap")));
 }
}Debug.locals.put("d", _d);
;
 BA.debugLineNum = 573;BA.debugLine="Dim lt As Label";
Debug.ShouldStop(268435456);
_lt = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lt", _lt);
 BA.debugLineNum = 574;BA.debugLine="lt.Initialize(\"\")";
Debug.ShouldStop(536870912);
_lt.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 575;BA.debugLine="lt.Text=\"löche nicht mehr benötigte Daten\"";
Debug.ShouldStop(1073741824);
_lt.runMethod(true,"setText",BA.ObjectToCharSequence("löche nicht mehr benötigte Daten"));
 BA.debugLineNum = 576;BA.debugLine="lt.Typeface=rfont";
Debug.ShouldStop(-2147483648);
_lt.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 577;BA.debugLine="lt.TextSize=14";
Debug.ShouldStop(1);
_lt.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 578;BA.debugLine="lt.TextColor=mcl.md_white_1000";
Debug.ShouldStop(2);
_lt.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_white_1000"));
 BA.debugLineNum = 580;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _l_stat() throws Exception{
try {
		Debug.PushSubsStack("l_stat (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,334);
if (RapidSub.canDelegate("l_stat")) return de.sclean.main.remoteMe.runUserSub(false, "main","l_stat");
 BA.debugLineNum = 334;BA.debugLine="Sub l_stat";
Debug.ShouldStop(8192);
 BA.debugLineNum = 335;BA.debugLine="If kvsdata.ContainsKey(\"cs\") Then";
Debug.ShouldStop(16384);
if (main.mostCurrent._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("cs"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 336;BA.debugLine="l_sub";
Debug.ShouldStop(32768);
_l_sub();
 }else {
 BA.debugLineNum = 338;BA.debugLine="lv1.Clear";
Debug.ShouldStop(131072);
main.mostCurrent._lv1.runVoidMethod ("Clear");
 BA.debugLineNum = 339;BA.debugLine="lv1.AddTwoLinesAndBitmap2(\"Nicht ausgeführt..\",\"";
Debug.ShouldStop(262144);
main.mostCurrent._lv1.runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence("Nicht ausgeführt..")),(Object)(BA.ObjectToCharSequence("drücke den Scan Button um einen ersten Scan zu starten")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ic_sms_failed_white_36dp.png"))).getObject())),(Object)(RemoteObject.createImmutable((0))));
 };
 BA.debugLineNum = 341;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _l_sub() throws Exception{
try {
		Debug.PushSubsStack("l_sub (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,343);
if (RapidSub.canDelegate("l_sub")) return de.sclean.main.remoteMe.runUserSub(false, "main","l_sub");
RemoteObject _sum = RemoteObject.createImmutable(0);
RemoteObject _na = RemoteObject.createImmutable("");
RemoteObject _g = RemoteObject.createImmutable("");
 BA.debugLineNum = 343;BA.debugLine="Sub l_sub";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 344;BA.debugLine="Dim sum As Int=0";
Debug.ShouldStop(8388608);
_sum = BA.numberCast(int.class, 0);Debug.locals.put("sum", _sum);Debug.locals.put("sum", _sum);
 BA.debugLineNum = 345;BA.debugLine="Dim na As String";
Debug.ShouldStop(16777216);
_na = RemoteObject.createImmutable("");Debug.locals.put("na", _na);
 BA.debugLineNum = 346;BA.debugLine="For Each g As String In alist.ListKeys";
Debug.ShouldStop(33554432);
{
final RemoteObject group3 = main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys");
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_g = BA.ObjectToString(group3.runMethod(false,"Get",index3));Debug.locals.put("g", _g);
Debug.locals.put("g", _g);
 BA.debugLineNum = 347;BA.debugLine="Log(FormatFileSize(alist.Get(g)))";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_formatfilesize(BA.numberCast(float.class, main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(_g))))));
 BA.debugLineNum = 348;BA.debugLine="sum=sum+alist.Get(g)";
Debug.ShouldStop(134217728);
_sum = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_sum,BA.numberCast(double.class, main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(_g)))}, "+",1, 0));Debug.locals.put("sum", _sum);
 BA.debugLineNum = 349;BA.debugLine="na=g";
Debug.ShouldStop(268435456);
_na = _g;Debug.locals.put("na", _na);
 }
}Debug.locals.put("g", _g);
;
 BA.debugLineNum = 352;BA.debugLine="dbase.Put(sum,na)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._dbase.runClassMethod (de.sclean.keyvaluestore.class, "_put",(Object)(BA.NumberToString(_sum)),(Object)((_na)));
 BA.debugLineNum = 353;BA.debugLine="If dbase.ContainsKey(sum) Then";
Debug.ShouldStop(1);
if (main.mostCurrent._dbase.runClassMethod (de.sclean.keyvaluestore.class, "_containskey",(Object)(BA.NumberToString(_sum))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 354;BA.debugLine="tota_sub";
Debug.ShouldStop(2);
_tota_sub();
 };
 BA.debugLineNum = 356;BA.debugLine="lv1.Clear";
Debug.ShouldStop(8);
main.mostCurrent._lv1.runVoidMethod ("Clear");
 BA.debugLineNum = 357;BA.debugLine="lv1.AddTwoLinesAndBitmap2(FormatFileSize(sum)&\" b";
Debug.ShouldStop(16);
main.mostCurrent._lv1.runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_formatfilesize(BA.numberCast(float.class, _sum)),RemoteObject.createImmutable(" bereinigt")))),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys").runMethod(true,"getSize"),RemoteObject.createImmutable(" App(s) optimiert..")))),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ic_sms_failed_white_36dp.png"))).getObject())),(Object)(RemoteObject.createImmutable((2))));
 BA.debugLineNum = 358;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _left() throws Exception{
try {
		Debug.PushSubsStack("left (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,410);
if (RapidSub.canDelegate("left")) return de.sclean.main.remoteMe.runUserSub(false, "main","left");
RemoteObject _la1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _la2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 410;BA.debugLine="Sub left";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 411;BA.debugLine="Dim la1,la2 As Label";
Debug.ShouldStop(67108864);
_la1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("la1", _la1);
_la2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("la2", _la2);
 BA.debugLineNum = 412;BA.debugLine="la2.Initialize(\"la2\")";
Debug.ShouldStop(134217728);
_la2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("la2")));
 BA.debugLineNum = 413;BA.debugLine="la1.Initialize(\"la1\")";
Debug.ShouldStop(268435456);
_la1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("la1")));
 BA.debugLineNum = 414;BA.debugLine="la1=leftlist.TwoLinesAndBitmap.Label";
Debug.ShouldStop(536870912);
_la1 = main.mostCurrent._leftlist.runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label");Debug.locals.put("la1", _la1);
 BA.debugLineNum = 415;BA.debugLine="la2=leftlist.TwoLinesAndBitmap.SecondLabel";
Debug.ShouldStop(1073741824);
_la2 = main.mostCurrent._leftlist.runMethod(false,"getTwoLinesAndBitmap").getField(false,"SecondLabel");Debug.locals.put("la2", _la2);
 BA.debugLineNum = 416;BA.debugLine="leftlist.TwoLinesAndBitmap.ImageView.Height=32dip";
Debug.ShouldStop(-2147483648);
main.mostCurrent._leftlist.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32))));
 BA.debugLineNum = 417;BA.debugLine="leftlist.TwoLinesAndBitmap.ImageView.Width=32dip";
Debug.ShouldStop(1);
main.mostCurrent._leftlist.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32))));
 BA.debugLineNum = 418;BA.debugLine="leftlist.TwoLinesAndBitmap.ItemHeight=50dip";
Debug.ShouldStop(2);
main.mostCurrent._leftlist.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"setItemHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 419;BA.debugLine="la1.TextSize=15";
Debug.ShouldStop(4);
_la1.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 420;BA.debugLine="la2.TextSize=11";
Debug.ShouldStop(8);
_la2.runMethod(true,"setTextSize",BA.numberCast(float.class, 11));
 BA.debugLineNum = 421;BA.debugLine="la1.Typeface=rfont";
Debug.ShouldStop(16);
_la1.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 422;BA.debugLine="la2.Typeface=rfont";
Debug.ShouldStop(32);
_la2.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 423;BA.debugLine="la1.TextColor=mcl.md_black_1000";
Debug.ShouldStop(64);
_la1.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_black_1000"));
 BA.debugLineNum = 424;BA.debugLine="la2.TextColor=Colors.ARGB(180,255,255,255)";
Debug.ShouldStop(128);
_la2.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 180)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 425;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Height=32dip";
Debug.ShouldStop(256);
main.mostCurrent._lv1.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32))));
 BA.debugLineNum = 426;BA.debugLine="lv1.TwoLinesAndBitmap.ImageView.Width=32dip";
Debug.ShouldStop(512);
main.mostCurrent._lv1.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32))));
 BA.debugLineNum = 427;BA.debugLine="lv1.TwoLinesAndBitmap.ItemHeight=55dip";
Debug.ShouldStop(1024);
main.mostCurrent._lv1.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"setItemHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 55))));
 BA.debugLineNum = 428;BA.debugLine="leftlist.AddTwoLinesAndBitmap2(\"Einstellungen\",\"S";
Debug.ShouldStop(2048);
main.mostCurrent._leftlist.runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence("Einstellungen")),(Object)(BA.ObjectToCharSequence("Service,widget einstellungen etc..")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ic_settings_applications_white_36dp.png"))).getObject())),(Object)(RemoteObject.createImmutable((0))));
 BA.debugLineNum = 429;BA.debugLine="leftlist.AddTwoLinesAndBitmap2(\"Feedback\",\"Sende";
Debug.ShouldStop(4096);
main.mostCurrent._leftlist.runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence("Feedback")),(Object)(BA.ObjectToCharSequence("Sende uns Vorschläge")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ic_sms_failed_white_36dp.png"))).getObject())),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 430;BA.debugLine="leftlist.AddTwoLinesAndBitmap2(\"About\",\"alles übe";
Debug.ShouldStop(8192);
main.mostCurrent._leftlist.runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence("About")),(Object)(BA.ObjectToCharSequence("alles über Scleaner")),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ic_extension_white_36dp.png"))).getObject())),(Object)(RemoteObject.createImmutable((2))));
 BA.debugLineNum = 431;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return RemoteObject.createImmutable("");
 BA.debugLineNum = 432;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _leftlist_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("leftlist_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,434);
if (RapidSub.canDelegate("leftlist_itemclick")) return de.sclean.main.remoteMe.runUserSub(false, "main","leftlist_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 434;BA.debugLine="Sub leftlist_ItemClick (Position As Int, Value As";
Debug.ShouldStop(131072);
 BA.debugLineNum = 435;BA.debugLine="Select Value";
Debug.ShouldStop(262144);
switch (BA.switchObjectToInt(_value,RemoteObject.createImmutable((0)),RemoteObject.createImmutable((1)),RemoteObject.createImmutable((2)))) {
case 0: {
 BA.debugLineNum = 437;BA.debugLine="set_click";
Debug.ShouldStop(1048576);
_set_click();
 break; }
case 1: {
 BA.debugLineNum = 439;BA.debugLine="sm.HideMenus";
Debug.ShouldStop(4194304);
main.mostCurrent._sm.runVoidMethod ("HideMenus");
 BA.debugLineNum = 440;BA.debugLine="StartActivity(supp)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._supp.getObject())));
 BA.debugLineNum = 441;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
Debug.ShouldStop(16777216);
main.mostCurrent._animator.runVoidMethod ("_setanimati",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("extra_in")),(Object)(RemoteObject.createImmutable("extra_out")));
 break; }
case 2: {
 BA.debugLineNum = 445;BA.debugLine="sm.HideMenus";
Debug.ShouldStop(268435456);
main.mostCurrent._sm.runVoidMethod ("HideMenus");
 BA.debugLineNum = 446;BA.debugLine="about_click";
Debug.ShouldStop(536870912);
_about_click();
 break; }
}
;
 BA.debugLineNum = 448;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lo_tick() throws Exception{
try {
		Debug.PushSubsStack("lo_tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,484);
if (RapidSub.canDelegate("lo_tick")) return de.sclean.main.remoteMe.runUserSub(false, "main","lo_tick");
RemoteObject _sum = RemoteObject.createImmutable(0);
RemoteObject _g = RemoteObject.createImmutable("");
 BA.debugLineNum = 484;BA.debugLine="Sub lo_tick";
Debug.ShouldStop(8);
 BA.debugLineNum = 486;BA.debugLine="lolist.Clear";
Debug.ShouldStop(32);
main.mostCurrent._lolist.runVoidMethod ("Clear");
 BA.debugLineNum = 487;BA.debugLine="pdim.SetElevationAnimated(300,10dip)";
Debug.ShouldStop(64);
main.mostCurrent._pdim.runVoidMethod ("SetElevationAnimated",(Object)(BA.numberCast(int.class, 300)),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))))));
 BA.debugLineNum = 488;BA.debugLine="sr.Visible=False";
Debug.ShouldStop(128);
main.mostCurrent._sr.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 489;BA.debugLine="Dim sum As Int=0";
Debug.ShouldStop(256);
_sum = BA.numberCast(int.class, 0);Debug.locals.put("sum", _sum);Debug.locals.put("sum", _sum);
 BA.debugLineNum = 490;BA.debugLine="For Each g As String In alist.ListKeys";
Debug.ShouldStop(512);
{
final RemoteObject group5 = main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys");
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_g = BA.ObjectToString(group5.runMethod(false,"Get",index5));Debug.locals.put("g", _g);
Debug.locals.put("g", _g);
 BA.debugLineNum = 491;BA.debugLine="Log(FormatFileSize(alist.Get(g)))";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_formatfilesize(BA.numberCast(float.class, main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(_g))))));
 BA.debugLineNum = 492;BA.debugLine="sum=sum+alist.Get(g)";
Debug.ShouldStop(2048);
_sum = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_sum,BA.numberCast(double.class, main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(_g)))}, "+",1, 0));Debug.locals.put("sum", _sum);
 }
}Debug.locals.put("g", _g);
;
 BA.debugLineNum = 494;BA.debugLine="lolist.AddTwoLinesAndBitmap2(alist.ListKeys.Size&";
Debug.ShouldStop(8192);
main.mostCurrent._lolist.runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys").runMethod(true,"getSize"),RemoteObject.createImmutable(" App(s) gesäubert:")))),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("mit: "),_formatfilesize(BA.numberCast(float.class, _sum))))),(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ic_sms_failed_white_36dp.png"))).getObject())),(Object)(RemoteObject.createImmutable((0))));
 BA.debugLineNum = 495;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _log_list() throws Exception{
try {
		Debug.PushSubsStack("log_list (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,504);
if (RapidSub.canDelegate("log_list")) return de.sclean.main.remoteMe.runUserSub(false, "main","log_list");
RemoteObject _ll = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lk = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _builder = RemoteObject.declareNull("de.amberhome.materialdialogs.MaterialDialogBuilderWrapper");
 BA.debugLineNum = 504;BA.debugLine="Sub log_list";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 505;BA.debugLine="pn.SetVisibleAnimated(450,False)";
Debug.ShouldStop(16777216);
main.mostCurrent._pn.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 450)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 506;BA.debugLine="Dim ll,lk As Label";
Debug.ShouldStop(33554432);
_ll = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("ll", _ll);
_lk = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lk", _lk);
 BA.debugLineNum = 507;BA.debugLine="ll.Initialize(\"\")";
Debug.ShouldStop(67108864);
_ll.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 508;BA.debugLine="lk.Initialize(\"\")";
Debug.ShouldStop(134217728);
_lk.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 509;BA.debugLine="ll.Text=\"keine App-daten gefunden..\"";
Debug.ShouldStop(268435456);
_ll.runMethod(true,"setText",BA.ObjectToCharSequence("keine App-daten gefunden.."));
 BA.debugLineNum = 510;BA.debugLine="ll.Textsize=12";
Debug.ShouldStop(536870912);
_ll.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 511;BA.debugLine="ll.Typeface=rfont";
Debug.ShouldStop(1073741824);
_ll.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 512;BA.debugLine="Dim builder As MaterialDialogBuilder";
Debug.ShouldStop(-2147483648);
_builder = RemoteObject.createNew ("de.amberhome.materialdialogs.MaterialDialogBuilderWrapper");Debug.locals.put("builder", _builder);
 BA.debugLineNum = 513;BA.debugLine="builder.Initialize(\"hexa\")";
Debug.ShouldStop(1);
_builder.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("hexa")));
 BA.debugLineNum = 514;BA.debugLine="builder.ContentGravity(builder.GRAVITY_START)";
Debug.ShouldStop(2);
_builder.runVoidMethod ("ContentGravity",(Object)(_builder.getField(false,"GRAVITY_START")));
 BA.debugLineNum = 515;BA.debugLine="builder.Title(\"Clean!\").TitleColor(mcl.md_grey_50";
Debug.ShouldStop(4);
_builder.runMethod(false,"Title",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Clean!")))).runMethod(false,"TitleColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_grey_500"))).runMethod(false,"Content",(Object)(BA.ObjectToCharSequence(_ll.runMethod(true,"getText")))).runMethod(false,"ContentColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_amber_500"))).runMethod(false,"Theme",(Object)(_builder.getField(false,"THEME_DARK"))).runVoidMethod ("NeutralText",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Ok"))));
 BA.debugLineNum = 516;BA.debugLine="dia=builder.Show";
Debug.ShouldStop(8);
main.mostCurrent._dia = _builder.runMethod(false,"Show");
 BA.debugLineNum = 517;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lolist_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("lolist_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,496);
if (RapidSub.canDelegate("lolist_itemclick")) return de.sclean.main.remoteMe.runUserSub(false, "main","lolist_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 496;BA.debugLine="Sub lolist_ItemClick (Position As Int, Value As Ob";
Debug.ShouldStop(32768);
 BA.debugLineNum = 497;BA.debugLine="Select Value";
Debug.ShouldStop(65536);
switch (BA.switchObjectToInt(_value,RemoteObject.createImmutable((0)))) {
case 0: {
 break; }
}
;
 BA.debugLineNum = 501;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lv1_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("lv1_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,231);
if (RapidSub.canDelegate("lv1_itemclick")) return de.sclean.main.remoteMe.runUserSub(false, "main","lv1_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 231;BA.debugLine="Sub lv1_ItemClick (Position As Int, Value As Objec";
Debug.ShouldStop(64);
 BA.debugLineNum = 232;BA.debugLine="Select Value";
Debug.ShouldStop(128);
switch (BA.switchObjectToInt(_value,RemoteObject.createImmutable((2)))) {
case 0: {
 BA.debugLineNum = 234;BA.debugLine="sub_list";
Debug.ShouldStop(512);
_sub_list();
 break; }
}
;
 BA.debugLineNum = 236;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _openurl() throws Exception{
try {
		Debug.PushSubsStack("openurl (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,688);
if (RapidSub.canDelegate("openurl")) return de.sclean.main.remoteMe.runUserSub(false, "main","openurl");
RemoteObject _url = RemoteObject.createImmutable("");
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 688;BA.debugLine="Sub openurl";
Debug.ShouldStop(32768);
 BA.debugLineNum = 689;BA.debugLine="Dim url As String=\"https://www.sulomedia.de\"";
Debug.ShouldStop(65536);
_url = BA.ObjectToString("https://www.sulomedia.de");Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 690;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(131072);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 691;BA.debugLine="i.Initialize(i.ACTION_VIEW, url)";
Debug.ShouldStop(262144);
_i.runVoidMethod ("Initialize",(Object)(_i.getField(true,"ACTION_VIEW")),(Object)(_url));
 BA.debugLineNum = 692;BA.debugLine="i.SetType(\"text/html\")";
Debug.ShouldStop(524288);
_i.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("text/html")));
 BA.debugLineNum = 693;BA.debugLine="i.AddCategory(\"android.intent.category.BROWSABLE\"";
Debug.ShouldStop(1048576);
_i.runVoidMethod ("AddCategory",(Object)(RemoteObject.createImmutable("android.intent.category.BROWSABLE")));
 BA.debugLineNum = 694;BA.debugLine="StartActivity(i)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_i.getObject())));
 BA.debugLineNum = 695;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _p_button() throws Exception{
try {
		Debug.PushSubsStack("p_button (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,275);
if (RapidSub.canDelegate("p_button")) return de.sclean.main.remoteMe.runUserSub(false, "main","p_button");
RemoteObject _ml = RemoteObject.declareNull("MLfiles.Fileslib.MLfiles");
RemoteObject _used1 = RemoteObject.createImmutable(0L);
RemoteObject _used2 = RemoteObject.createImmutable(0L);
RemoteObject _summe1 = RemoteObject.createImmutable(0L);
RemoteObject _total = RemoteObject.createImmutable(0);
RemoteObject _summ2 = RemoteObject.createImmutable(0);
RemoteObject _div = RemoteObject.createImmutable(0);
 BA.debugLineNum = 275;BA.debugLine="Sub p_button";
Debug.ShouldStop(262144);
 BA.debugLineNum = 276;BA.debugLine="Dim ml As MLfiles";
Debug.ShouldStop(524288);
_ml = RemoteObject.createNew ("MLfiles.Fileslib.MLfiles");Debug.locals.put("ml", _ml);
 BA.debugLineNum = 277;BA.debugLine="pb1.BottomTextSize=18";
Debug.ShouldStop(1048576);
main.mostCurrent._pb1.runMethod(true,"setBottomTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 278;BA.debugLine="pb2.BottomTextSize=18";
Debug.ShouldStop(2097152);
main.mostCurrent._pb2.runMethod(true,"setBottomTextSize",BA.numberCast(float.class, 18));
 BA.debugLineNum = 279;BA.debugLine="pb1.TextSize=40";
Debug.ShouldStop(4194304);
main.mostCurrent._pb1.runMethod(true,"setTextSize",BA.numberCast(float.class, 40));
 BA.debugLineNum = 280;BA.debugLine="pb2.TextSize=40";
Debug.ShouldStop(8388608);
main.mostCurrent._pb2.runMethod(true,"setTextSize",BA.numberCast(float.class, 40));
 BA.debugLineNum = 281;BA.debugLine="pb1.TextColor=Colors.ARGB(150,255,255,255)";
Debug.ShouldStop(16777216);
main.mostCurrent._pb1.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 282;BA.debugLine="pb2.TextColor=Colors.ARGB(150,255,255,255)";
Debug.ShouldStop(33554432);
main.mostCurrent._pb2.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 283;BA.debugLine="pb2.SuffixText=\"% SD\"";
Debug.ShouldStop(67108864);
main.mostCurrent._pb2.runMethod(true,"setSuffixText",BA.ObjectToString("% SD"));
 BA.debugLineNum = 284;BA.debugLine="pb1.SuffixText=\"% RAM\"";
Debug.ShouldStop(134217728);
main.mostCurrent._pb1.runMethod(true,"setSuffixText",BA.ObjectToString("% RAM"));
 BA.debugLineNum = 285;BA.debugLine="pb2.SuffixTextSize=15";
Debug.ShouldStop(268435456);
main.mostCurrent._pb2.runMethod(true,"setSuffixTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 286;BA.debugLine="pb1.SuffixTextSize=15";
Debug.ShouldStop(536870912);
main.mostCurrent._pb1.runMethod(true,"setSuffixTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 287;BA.debugLine="Dim used1,used2,summe1 As Long";
Debug.ShouldStop(1073741824);
_used1 = RemoteObject.createImmutable(0L);Debug.locals.put("used1", _used1);
_used2 = RemoteObject.createImmutable(0L);Debug.locals.put("used2", _used2);
_summe1 = RemoteObject.createImmutable(0L);Debug.locals.put("summe1", _summe1);
 BA.debugLineNum = 288;BA.debugLine="used1=os.TotalExternalMemorySize-os.AvailableExte";
Debug.ShouldStop(-2147483648);
_used1 = RemoteObject.solve(new RemoteObject[] {main._os.runMethod(true,"getTotalExternalMemorySize"),main._os.runMethod(true,"getAvailableExternalMemorySize")}, "-",1, 2);Debug.locals.put("used1", _used1);
 BA.debugLineNum = 289;BA.debugLine="used2=os.TotalInternalMemorySize - os.AvailableIn";
Debug.ShouldStop(1);
_used2 = RemoteObject.solve(new RemoteObject[] {main._os.runMethod(true,"getTotalInternalMemorySize"),main._os.runMethod(true,"getAvailableInternalMemorySize")}, "-",1, 2);Debug.locals.put("used2", _used2);
 BA.debugLineNum = 290;BA.debugLine="summe1=used1+used2";
Debug.ShouldStop(2);
_summe1 = RemoteObject.solve(new RemoteObject[] {_used1,_used2}, "+",1, 2);Debug.locals.put("summe1", _summe1);
 BA.debugLineNum = 291;BA.debugLine="Dim total,summ2,div As Int";
Debug.ShouldStop(4);
_total = RemoteObject.createImmutable(0);Debug.locals.put("total", _total);
_summ2 = RemoteObject.createImmutable(0);Debug.locals.put("summ2", _summ2);
_div = RemoteObject.createImmutable(0);Debug.locals.put("div", _div);
 BA.debugLineNum = 292;BA.debugLine="total=os.TotalExternalMemorySize+os.TotalInternal";
Debug.ShouldStop(8);
_total = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._os.runMethod(true,"getTotalExternalMemorySize"),main._os.runMethod(true,"getTotalInternalMemorySize")}, "+",1, 2));Debug.locals.put("total", _total);
 BA.debugLineNum = 293;BA.debugLine="div=os.AvailableExternalMemorySize+os.AvailableIn";
Debug.ShouldStop(16);
_div = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._os.runMethod(true,"getAvailableExternalMemorySize"),main._os.runMethod(true,"getAvailableInternalMemorySize")}, "+",1, 2));Debug.locals.put("div", _div);
 BA.debugLineNum = 294;BA.debugLine="summ2=total-div";
Debug.ShouldStop(32);
_summ2 = RemoteObject.solve(new RemoteObject[] {_total,_div}, "-",1, 1);Debug.locals.put("summ2", _summ2);
 BA.debugLineNum = 295;BA.debugLine="pb2.BottomText=FormatFileSize(summe1)&\"/\"&FormatF";
Debug.ShouldStop(64);
main.mostCurrent._pb2.runMethod(true,"setBottomText",RemoteObject.concat(_formatfilesize(BA.numberCast(float.class, _summe1)),RemoteObject.createImmutable("/"),_formatfilesize(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {main._os.runMethod(true,"getTotalExternalMemorySize"),main._os.runMethod(true,"getTotalInternalMemorySize")}, "+",1, 2)))));
 BA.debugLineNum = 296;BA.debugLine="pb2.Max=os.TotalExternalMemorySize+os.TotalIntern";
Debug.ShouldStop(128);
main.mostCurrent._pb2.runMethod(true,"setMax",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._os.runMethod(true,"getTotalExternalMemorySize"),main._os.runMethod(true,"getTotalInternalMemorySize")}, "+",1, 2)));
 BA.debugLineNum = 297;BA.debugLine="pb2.Progress=100-((summ2)/(total)) * 100";
Debug.ShouldStop(256);
main.mostCurrent._pb2.runMethod(true,"setProgress",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(100),(RemoteObject.solve(new RemoteObject[] {(_summ2),(_total)}, "/",0, 0)),RemoteObject.createImmutable(100)}, "-*",1, 0)));
 BA.debugLineNum = 298;BA.debugLine="pb1.FinishedStrokeColor=mcl.md_amber_500";
Debug.ShouldStop(512);
main.mostCurrent._pb1.runMethod(true,"setFinishedStrokeColor",main.mostCurrent._mcl.runMethod(true,"getmd_amber_500"));
 BA.debugLineNum = 299;BA.debugLine="pb2.FinishedStrokeColor=mcl.md_amber_500";
Debug.ShouldStop(1024);
main.mostCurrent._pb2.runMethod(true,"setFinishedStrokeColor",main.mostCurrent._mcl.runMethod(true,"getmd_amber_500"));
 BA.debugLineNum = 300;BA.debugLine="pb1.UnfinishedStrokeColor=mcl.md_grey_400";
Debug.ShouldStop(2048);
main.mostCurrent._pb1.runMethod(true,"setUnfinishedStrokeColor",main.mostCurrent._mcl.runMethod(true,"getmd_grey_400"));
 BA.debugLineNum = 301;BA.debugLine="pb2.UnfinishedStrokeColor=mcl.md_grey_400";
Debug.ShouldStop(4096);
main.mostCurrent._pb2.runMethod(true,"setUnfinishedStrokeColor",main.mostCurrent._mcl.runMethod(true,"getmd_grey_400"));
 BA.debugLineNum = 302;BA.debugLine="pb1.StrokeWidth=8dip";
Debug.ShouldStop(8192);
main.mostCurrent._pb1.runMethod(true,"setStrokeWidth",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))));
 BA.debugLineNum = 303;BA.debugLine="pb2.StrokeWidth=8dip";
Debug.ShouldStop(16384);
main.mostCurrent._pb2.runMethod(true,"setStrokeWidth",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))));
 BA.debugLineNum = 304;BA.debugLine="pb1.ArcAngle=220";
Debug.ShouldStop(32768);
main.mostCurrent._pb1.runMethod(true,"setArcAngle",BA.numberCast(float.class, 220));
 BA.debugLineNum = 305;BA.debugLine="pb2.ArcAngle=220";
Debug.ShouldStop(65536);
main.mostCurrent._pb2.runMethod(true,"setArcAngle",BA.numberCast(float.class, 220));
 BA.debugLineNum = 306;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pb_update() throws Exception{
try {
		Debug.PushSubsStack("pb_update (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,598);
if (RapidSub.canDelegate("pb_update")) return de.sclean.main.remoteMe.runUserSub(false, "main","pb_update");
RemoteObject _cc = RemoteObject.createImmutable(0);
RemoteObject _tot = RemoteObject.createImmutable(0);
 BA.debugLineNum = 598;BA.debugLine="Sub pb_update";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 599;BA.debugLine="Dim cc,tot As Int";
Debug.ShouldStop(4194304);
_cc = RemoteObject.createImmutable(0);Debug.locals.put("cc", _cc);
_tot = RemoteObject.createImmutable(0);Debug.locals.put("tot", _tot);
 BA.debugLineNum = 600;BA.debugLine="tot=kvst.Get(\"ta\")";
Debug.ShouldStop(8388608);
_tot = BA.numberCast(int.class, main.mostCurrent._kvst.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("ta"))));Debug.locals.put("tot", _tot);
 BA.debugLineNum = 601;BA.debugLine="cc=kvsdata.Get(\"c\")";
Debug.ShouldStop(16777216);
_cc = BA.numberCast(int.class, main.mostCurrent._kvsdata.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("c"))));Debug.locals.put("cc", _cc);
 BA.debugLineNum = 602;BA.debugLine="ss.Progress=100+((cc)/(tot))*100";
Debug.ShouldStop(33554432);
main.mostCurrent._ss.runMethod(true,"setProgress",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(100),(RemoteObject.solve(new RemoteObject[] {(_cc),(_tot)}, "/",0, 0)),RemoteObject.createImmutable(100)}, "+*",1, 0)));
 BA.debugLineNum = 603;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _prb_click() throws Exception{
try {
		Debug.PushSubsStack("prb_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,582);
if (RapidSub.canDelegate("prb_click")) return de.sclean.main.remoteMe.runUserSub(false, "main","prb_click");
RemoteObject _lt = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 582;BA.debugLine="Sub prb_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 583;BA.debugLine="Dim lt As Label";
Debug.ShouldStop(64);
_lt = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lt", _lt);
 BA.debugLineNum = 584;BA.debugLine="lt.Initialize(\"\")";
Debug.ShouldStop(128);
_lt.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 585;BA.debugLine="lt.Typeface=rfont";
Debug.ShouldStop(256);
_lt.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 586;BA.debugLine="lt.Text=\"bitte warten..\"";
Debug.ShouldStop(512);
_lt.runMethod(true,"setText",BA.ObjectToCharSequence("bitte warten.."));
 BA.debugLineNum = 587;BA.debugLine="xOSStats.EndStats";
Debug.ShouldStop(1024);
main.mostCurrent._xosstats.runVoidMethod ("_endstats");
 BA.debugLineNum = 588;BA.debugLine="sm.HideMenus";
Debug.ShouldStop(2048);
main.mostCurrent._sm.runVoidMethod ("HideMenus");
 BA.debugLineNum = 589;BA.debugLine="lt.TextSize=11";
Debug.ShouldStop(4096);
_lt.runMethod(true,"setTextSize",BA.numberCast(float.class, 11));
 BA.debugLineNum = 590;BA.debugLine="prb.Text=lt.Text";
Debug.ShouldStop(8192);
main.mostCurrent._prb.runMethod(true,"setText",BA.ObjectToCharSequence(_lt.runMethod(true,"getText")));
 BA.debugLineNum = 591;BA.debugLine="prb.TextColor=mcl.md_white_1000";
Debug.ShouldStop(16384);
main.mostCurrent._prb.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_white_1000"));
 BA.debugLineNum = 592;BA.debugLine="CallSubDelayed(Starter,\"remote_start\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.processBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("remote_start")));
 BA.debugLineNum = 593;BA.debugLine="prb.SetVisibleAnimated(200,False)";
Debug.ShouldStop(65536);
main.mostCurrent._prb.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 594;BA.debugLine="pn.SetVisibleAnimated(250,True)";
Debug.ShouldStop(131072);
main.mostCurrent._pn.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 250)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 596;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
supp_subs_0._process_globals();
option_subs_0._process_globals();
starter_subs_0._process_globals();
info_subs_0._process_globals();
widget_subs_0._process_globals();
statemanager_subs_0._process_globals();
animator_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("de.sclean.main");
supp.myClass = BA.getDeviceClass ("de.sclean.supp");
option.myClass = BA.getDeviceClass ("de.sclean.option");
starter.myClass = BA.getDeviceClass ("de.sclean.starter");
info.myClass = BA.getDeviceClass ("de.sclean.info");
keyvaluestore.myClass = BA.getDeviceClass ("de.sclean.keyvaluestore");
widget.myClass = BA.getDeviceClass ("de.sclean.widget");
statemanager.myClass = BA.getDeviceClass ("de.sclean.statemanager");
animator.myClass = BA.getDeviceClass ("de.sclean.animator");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private os As OperatingSystem";
main._os = RemoteObject.createNew ("com.rootsoft.oslibrary.OSLibrary");
 //BA.debugLineNum = 27;BA.debugLine="Dim date,time As String";
main._date = RemoteObject.createImmutable("");
main._time = RemoteObject.createImmutable("");
 //BA.debugLineNum = 28;BA.debugLine="Private rfont As Typeface= rfont.LoadFromAssets(\"";
main._rfont = RemoteObject.createNew ("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");
main._rfont.setObject(main._rfont.runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("Aldrich-Regular.ttf"))));
 //BA.debugLineNum = 29;BA.debugLine="Private package As String=\"de.sclean\"";
main._package = BA.ObjectToString("de.sclean");
 //BA.debugLineNum = 30;BA.debugLine="Dim t1,t2 As Timer";
main._t1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
main._t2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 31;BA.debugLine="Dim utext As String=\"www.sulomedia.de\"";
main._utext = BA.ObjectToString("www.sulomedia.de");
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _r_schredder() throws Exception{
try {
		Debug.PushSubsStack("r_schredder (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,530);
if (RapidSub.canDelegate("r_schredder")) return de.sclean.main.remoteMe.runUserSub(false, "main","r_schredder");
 BA.debugLineNum = 530;BA.debugLine="Sub r_schredder";
Debug.ShouldStop(131072);
 BA.debugLineNum = 531;BA.debugLine="schredder(True)";
Debug.ShouldStop(262144);
_schredder(main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 532;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _schredder(RemoteObject _f) throws Exception{
try {
		Debug.PushSubsStack("schredder (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,534);
if (RapidSub.canDelegate("schredder")) return de.sclean.main.remoteMe.runUserSub(false, "main","schredder", _f);
Debug.locals.put("f", _f);
 BA.debugLineNum = 534;BA.debugLine="Sub schredder (f As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 535;BA.debugLine="If f=True Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_f,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 536;BA.debugLine="prb.SetVisibleAnimated(200,False)";
Debug.ShouldStop(8388608);
main.mostCurrent._prb.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 537;BA.debugLine="ldim.SetVisibleAnimated(200,True)";
Debug.ShouldStop(16777216);
main.mostCurrent._ldim.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 538;BA.debugLine="pdim.SetVisibleAnimated(200,True)";
Debug.ShouldStop(33554432);
main.mostCurrent._pdim.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 539;BA.debugLine="sr.SetVisibleAnimated(200,True)";
Debug.ShouldStop(67108864);
main.mostCurrent._sr.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 540;BA.debugLine="im_ad";
Debug.ShouldStop(134217728);
_im_ad();
 }else {
 BA.debugLineNum = 542;BA.debugLine="If f=False Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_f,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 543;BA.debugLine="prb.SetVisibleAnimated(200,True)";
Debug.ShouldStop(1073741824);
main.mostCurrent._prb.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 544;BA.debugLine="ldim.SetVisibleAnimated(300,False)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._ldim.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 300)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 545;BA.debugLine="pdim.SetVisibleAnimated(300,False)";
Debug.ShouldStop(1);
main.mostCurrent._pdim.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 300)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 546;BA.debugLine="sr.SetVisibleAnimated(300,False)";
Debug.ShouldStop(2);
main.mostCurrent._sr.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 300)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 };
 BA.debugLineNum = 550;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_click() throws Exception{
try {
		Debug.PushSubsStack("set_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,450);
if (RapidSub.canDelegate("set_click")) return de.sclean.main.remoteMe.runUserSub(false, "main","set_click");
 BA.debugLineNum = 450;BA.debugLine="Sub set_click";
Debug.ShouldStop(2);
 BA.debugLineNum = 451;BA.debugLine="sm.HideMenus";
Debug.ShouldStop(4);
main.mostCurrent._sm.runVoidMethod ("HideMenus");
 BA.debugLineNum = 452;BA.debugLine="StartActivity(option)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._option.getObject())));
 BA.debugLineNum = 453;BA.debugLine="Animator.setanimati(\"extra_in\", \"extra_out\")";
Debug.ShouldStop(16);
main.mostCurrent._animator.runVoidMethod ("_setanimati",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("extra_in")),(Object)(RemoteObject.createImmutable("extra_out")));
 BA.debugLineNum = 454;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Stats_Update (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,633);
if (RapidSub.canDelegate("stats_update")) return de.sclean.main.remoteMe.runUserSub(false, "main","stats_update", _cpuefficiency, _ramusage);
Debug.locals.put("CPUEfficiency", _cpuefficiency);
Debug.locals.put("RAMUsage", _ramusage);
 BA.debugLineNum = 633;BA.debugLine="Sub Stats_Update(CPUEfficiency() As Float, RAMUsag";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 634;BA.debugLine="pb1.Progress=RAMUsage";
Debug.ShouldStop(33554432);
main.mostCurrent._pb1.runMethod(true,"setProgress",BA.numberCast(int.class, _ramusage));
 BA.debugLineNum = 635;BA.debugLine="pb1.BottomText=FormatFileSize(RAMUsage*1024*1024*";
Debug.ShouldStop(67108864);
main.mostCurrent._pb1.runMethod(true,"setBottomText",RemoteObject.concat(_formatfilesize(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_ramusage,RemoteObject.createImmutable(1024),RemoteObject.createImmutable(1024),RemoteObject.createImmutable(10)}, "***",0, 0))),RemoteObject.createImmutable("/"),_formatfilesize(BA.numberCast(float.class, main.mostCurrent._xmsos.runMethod(true,"getSystemTotalMemorySize",main.mostCurrent.activityBA)))));
 BA.debugLineNum = 636;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sub_list() throws Exception{
try {
		Debug.PushSubsStack("sub_list (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,238);
if (RapidSub.canDelegate("sub_list")) return de.sclean.main.remoteMe.runUserSub(false, "main","sub_list");
RemoteObject _lo = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _mi = RemoteObject.declareNull("de.amberhome.materialdialogs.MaterialSimpleListItemWrapper");
RemoteObject _ll = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lk = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _builder = RemoteObject.declareNull("de.amberhome.materialdialogs.MaterialDialogBuilderWrapper");
RemoteObject _i = RemoteObject.createImmutable("");
 BA.debugLineNum = 238;BA.debugLine="Sub sub_list";
Debug.ShouldStop(8192);
 BA.debugLineNum = 239;BA.debugLine="Dim lo As List";
Debug.ShouldStop(16384);
_lo = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lo", _lo);
 BA.debugLineNum = 240;BA.debugLine="Dim mi As MaterialSimpleListItem";
Debug.ShouldStop(32768);
_mi = RemoteObject.createNew ("de.amberhome.materialdialogs.MaterialSimpleListItemWrapper");Debug.locals.put("mi", _mi);
 BA.debugLineNum = 241;BA.debugLine="lo.Initialize";
Debug.ShouldStop(65536);
_lo.runVoidMethod ("Initialize");
 BA.debugLineNum = 242;BA.debugLine="Dim ll,lk As Label";
Debug.ShouldStop(131072);
_ll = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("ll", _ll);
_lk = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lk", _lk);
 BA.debugLineNum = 243;BA.debugLine="ll.Initialize(\"\")";
Debug.ShouldStop(262144);
_ll.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 244;BA.debugLine="lk.Initialize(\"\")";
Debug.ShouldStop(524288);
_lk.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 245;BA.debugLine="ll.Textsize=12";
Debug.ShouldStop(1048576);
_ll.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 246;BA.debugLine="ll.Typeface=rfont";
Debug.ShouldStop(2097152);
_ll.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 247;BA.debugLine="ll.Text=alist.ListKeys.Size&\" Anwendungen:\"";
Debug.ShouldStop(4194304);
_ll.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys").runMethod(true,"getSize"),RemoteObject.createImmutable(" Anwendungen:"))));
 BA.debugLineNum = 248;BA.debugLine="Dim builder As MaterialDialogBuilder";
Debug.ShouldStop(8388608);
_builder = RemoteObject.createNew ("de.amberhome.materialdialogs.MaterialDialogBuilderWrapper");Debug.locals.put("builder", _builder);
 BA.debugLineNum = 249;BA.debugLine="builder.Initialize(\"fexa\")";
Debug.ShouldStop(16777216);
_builder.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("fexa")));
 BA.debugLineNum = 250;BA.debugLine="lo=File.ReadList(dir,\"clist.txt\")";
Debug.ShouldStop(33554432);
_lo = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent._dir),(Object)(RemoteObject.createImmutable("clist.txt")));Debug.locals.put("lo", _lo);
 BA.debugLineNum = 251;BA.debugLine="For Each i As String In alist.ListKeys";
Debug.ShouldStop(67108864);
{
final RemoteObject group13 = main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys");
final int groupLen13 = group13.runMethod(true,"getSize").<Integer>get()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_i = BA.ObjectToString(group13.runMethod(false,"Get",index13));Debug.locals.put("i", _i);
Debug.locals.put("i", _i);
 BA.debugLineNum = 252;BA.debugLine="Log(i)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_i));
 BA.debugLineNum = 253;BA.debugLine="mi.Initialize(pack.GetApplicationIcon(i),pack.Ge";
Debug.ShouldStop(268435456);
_mi.runVoidMethod ("Initialize",main.processBA,(Object)(main.mostCurrent._pack.runMethod(false,"GetApplicationIcon",(Object)(_i))),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._pack.runMethod(true,"GetApplicationLabel",(Object)(_i)),RemoteObject.createImmutable(" / "),_formatfilesize(BA.numberCast(float.class, main.mostCurrent._alist.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(_i))))))));
 BA.debugLineNum = 254;BA.debugLine="builder.AddSimpleItem(mi)";
Debug.ShouldStop(536870912);
_builder.runVoidMethod ("AddSimpleItem",(Object)(_mi));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 256;BA.debugLine="builder.ContentGravity(builder.GRAVITY_START)";
Debug.ShouldStop(-2147483648);
_builder.runVoidMethod ("ContentGravity",(Object)(_builder.getField(false,"GRAVITY_START")));
 BA.debugLineNum = 257;BA.debugLine="builder.Title(\"Clean Log:\").TitleColor(mcl.md_gre";
Debug.ShouldStop(1);
_builder.runMethod(false,"Title",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Clean Log:")))).runMethod(false,"TitleColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_grey_500"))).runMethod(false,"Content",(Object)(BA.ObjectToCharSequence(_ll.runMethod(true,"getText")))).runMethod(false,"ContentColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_amber_600"))).runMethod(false,"Theme",(Object)(_builder.getField(false,"THEME_DARK"))).runMethod(false,"NegativeText",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Ok")))).runMethod(false,"PositiveColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_red_500"))).runVoidMethod ("PositiveText",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Clear log"))));
 BA.debugLineNum = 258;BA.debugLine="dia=builder.Show";
Debug.ShouldStop(2);
main.mostCurrent._dia = _builder.runMethod(false,"Show");
 BA.debugLineNum = 259;BA.debugLine="dia.Show";
Debug.ShouldStop(4);
main.mostCurrent._dia.runVoidMethod ("Show");
 BA.debugLineNum = 260;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _t1_start() throws Exception{
try {
		Debug.PushSubsStack("t1_start (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,457);
if (RapidSub.canDelegate("t1_start")) return de.sclean.main.remoteMe.runUserSub(false, "main","t1_start");
 BA.debugLineNum = 457;BA.debugLine="Sub t1_start";
Debug.ShouldStop(256);
 BA.debugLineNum = 458;BA.debugLine="t1.Enabled=True";
Debug.ShouldStop(512);
main._t1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 459;BA.debugLine="CallSubDelayed(Starter,\"clean_start\")";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.processBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("clean_start")));
 BA.debugLineNum = 460;BA.debugLine="r_schredder";
Debug.ShouldStop(2048);
_r_schredder();
 BA.debugLineNum = 461;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _t1_tick() throws Exception{
try {
		Debug.PushSubsStack("t1_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,462);
if (RapidSub.canDelegate("t1_tick")) return de.sclean.main.remoteMe.runUserSub(false, "main","t1_tick");
 BA.debugLineNum = 462;BA.debugLine="Sub t1_Tick";
Debug.ShouldStop(8192);
 BA.debugLineNum = 463;BA.debugLine="counter=counter+1";
Debug.ShouldStop(16384);
main._counter = RemoteObject.solve(new RemoteObject[] {main._counter,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 464;BA.debugLine="Log(\"tick\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("tick")));
 BA.debugLineNum = 465;BA.debugLine="If counter> 1 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean(">",main._counter,BA.numberCast(double.class, 1))) { 
 };
 BA.debugLineNum = 468;BA.debugLine="If counter>3 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(">",main._counter,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 469;BA.debugLine="sr.SetVisibleAnimated(100,False)";
Debug.ShouldStop(1048576);
main.mostCurrent._sr.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 470;BA.debugLine="pdim.SetVisibleAnimated(200,False)";
Debug.ShouldStop(2097152);
main.mostCurrent._pdim.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 471;BA.debugLine="ready.SetVisibleAnimated(150,True)";
Debug.ShouldStop(4194304);
main.mostCurrent._ready.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 150)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 472;BA.debugLine="lo_tick";
Debug.ShouldStop(8388608);
_lo_tick();
 };
 BA.debugLineNum = 474;BA.debugLine="If counter= 6 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",main._counter,BA.numberCast(double.class, 6))) { 
 BA.debugLineNum = 475;BA.debugLine="t1.Enabled=False";
Debug.ShouldStop(67108864);
main._t1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 476;BA.debugLine="counter=0";
Debug.ShouldStop(134217728);
main._counter = BA.numberCast(int.class, 0);
 BA.debugLineNum = 478;BA.debugLine="dp_clear";
Debug.ShouldStop(536870912);
_dp_clear();
 BA.debugLineNum = 479;BA.debugLine="dp_clean";
Debug.ShouldStop(1073741824);
_dp_clean();
 BA.debugLineNum = 480;BA.debugLine="l_sub";
Debug.ShouldStop(-2147483648);
_l_sub();
 };
 BA.debugLineNum = 482;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _toolbar_menuitemclick(RemoteObject _item) throws Exception{
try {
		Debug.PushSubsStack("toolbar_MenuItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,216);
if (RapidSub.canDelegate("toolbar_menuitemclick")) return de.sclean.main.remoteMe.runUserSub(false, "main","toolbar_menuitemclick", _item);
Debug.locals.put("Item", _item);
 BA.debugLineNum = 216;BA.debugLine="Sub toolbar_MenuItemClick (Item As ACMenuItem)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 217;BA.debugLine="Select Item.Id";
Debug.ShouldStop(16777216);
switch (BA.switchObjectToInt(_item.runMethod(true,"getId"),BA.numberCast(int.class, "0"),BA.numberCast(int.class, "1"),BA.numberCast(int.class, "2"))) {
case 0: {
 BA.debugLineNum = 219;BA.debugLine="sm.ShowMenu";
Debug.ShouldStop(67108864);
main.mostCurrent._sm.runVoidMethod ("ShowMenu");
 break; }
case 1: {
 BA.debugLineNum = 221;BA.debugLine="set_click";
Debug.ShouldStop(268435456);
_set_click();
 break; }
case 2: {
 BA.debugLineNum = 223;BA.debugLine="If sm.Visible=True Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sm.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 224;BA.debugLine="sm.HideMenus";
Debug.ShouldStop(-2147483648);
main.mostCurrent._sm.runVoidMethod ("HideMenus");
 }else {
 BA.debugLineNum = 226;BA.debugLine="sm.ShowMenu";
Debug.ShouldStop(2);
main.mostCurrent._sm.runVoidMethod ("ShowMenu");
 };
 break; }
}
;
 BA.debugLineNum = 229;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _toolbar_navigationitemclick() throws Exception{
try {
		Debug.PushSubsStack("toolbar_NavigationItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,213);
if (RapidSub.canDelegate("toolbar_navigationitemclick")) return de.sclean.main.remoteMe.runUserSub(false, "main","toolbar_navigationitemclick");
 BA.debugLineNum = 213;BA.debugLine="Sub toolbar_NavigationItemClick";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 214;BA.debugLine="exit_click";
Debug.ShouldStop(2097152);
_exit_click();
 BA.debugLineNum = 215;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tota_click() throws Exception{
try {
		Debug.PushSubsStack("tota_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,378);
if (RapidSub.canDelegate("tota_click")) return de.sclean.main.remoteMe.runUserSub(false, "main","tota_click");
RemoteObject _lo = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _mi = RemoteObject.declareNull("de.amberhome.materialdialogs.MaterialSimpleListItemWrapper");
RemoteObject _ll = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lk = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _builder = RemoteObject.declareNull("de.amberhome.materialdialogs.MaterialDialogBuilderWrapper");
RemoteObject _i = RemoteObject.createImmutable("");
 BA.debugLineNum = 378;BA.debugLine="Sub tota_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 379;BA.debugLine="Dim lo As List";
Debug.ShouldStop(67108864);
_lo = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lo", _lo);
 BA.debugLineNum = 380;BA.debugLine="Dim mi As MaterialSimpleListItem";
Debug.ShouldStop(134217728);
_mi = RemoteObject.createNew ("de.amberhome.materialdialogs.MaterialSimpleListItemWrapper");Debug.locals.put("mi", _mi);
 BA.debugLineNum = 381;BA.debugLine="lo.Initialize";
Debug.ShouldStop(268435456);
_lo.runVoidMethod ("Initialize");
 BA.debugLineNum = 382;BA.debugLine="Dim ll,lk As Label";
Debug.ShouldStop(536870912);
_ll = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("ll", _ll);
_lk = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lk", _lk);
 BA.debugLineNum = 383;BA.debugLine="ll.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_ll.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 384;BA.debugLine="lk.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_lk.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 385;BA.debugLine="ll.Textsize=10";
Debug.ShouldStop(1);
_ll.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 386;BA.debugLine="ll.Typeface=rfont";
Debug.ShouldStop(2);
_ll.runMethod(false,"setTypeface",(main._rfont.getObject()));
 BA.debugLineNum = 387;BA.debugLine="ll.Text=dbase.ListKeys.Size&\" Anwendungen:\"";
Debug.ShouldStop(4);
_ll.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._dbase.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys").runMethod(true,"getSize"),RemoteObject.createImmutable(" Anwendungen:"))));
 BA.debugLineNum = 388;BA.debugLine="Dim builder As MaterialDialogBuilder";
Debug.ShouldStop(8);
_builder = RemoteObject.createNew ("de.amberhome.materialdialogs.MaterialDialogBuilderWrapper");Debug.locals.put("builder", _builder);
 BA.debugLineNum = 389;BA.debugLine="builder.Initialize(\"dexa\")";
Debug.ShouldStop(16);
_builder.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("dexa")));
 BA.debugLineNum = 390;BA.debugLine="For Each i As String In dbase.ListKeys";
Debug.ShouldStop(32);
{
final RemoteObject group12 = main.mostCurrent._dbase.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys");
final int groupLen12 = group12.runMethod(true,"getSize").<Integer>get()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_i = BA.ObjectToString(group12.runMethod(false,"Get",index12));Debug.locals.put("i", _i);
Debug.locals.put("i", _i);
 BA.debugLineNum = 391;BA.debugLine="mi.Initialize2(\"tc32\",dbase.Get(i)&\" - \"&FormatF";
Debug.ShouldStop(64);
_mi.runVoidMethod ("Initialize2",main.processBA,(Object)(BA.ObjectToString("tc32")),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._dbase.runClassMethod (de.sclean.keyvaluestore.class, "_get",(Object)(_i)),RemoteObject.createImmutable(" - "),_formatfilesize(BA.numberCast(float.class, _i))))));
 BA.debugLineNum = 392;BA.debugLine="builder.AddSimpleItem(mi)";
Debug.ShouldStop(128);
_builder.runVoidMethod ("AddSimpleItem",(Object)(_mi));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 394;BA.debugLine="builder.ContentGravity(builder.GRAVITY_START)";
Debug.ShouldStop(512);
_builder.runVoidMethod ("ContentGravity",(Object)(_builder.getField(false,"GRAVITY_START")));
 BA.debugLineNum = 395;BA.debugLine="builder.Title(\"Total Clean Log:\").TitleColor(mcl.";
Debug.ShouldStop(1024);
_builder.runMethod(false,"Title",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Total Clean Log:")))).runMethod(false,"TitleColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_grey_500"))).runMethod(false,"Content",(Object)(BA.ObjectToCharSequence(_ll.runMethod(true,"getText")))).runMethod(false,"ContentColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_amber_600"))).runMethod(false,"Theme",(Object)(_builder.getField(false,"THEME_DARK"))).runMethod(false,"NegativeText",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Ok")))).runMethod(false,"PositiveColor",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_red_500"))).runVoidMethod ("PositiveText",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Clear log"))));
 BA.debugLineNum = 396;BA.debugLine="dia=builder.Show";
Debug.ShouldStop(2048);
main.mostCurrent._dia = _builder.runMethod(false,"Show");
 BA.debugLineNum = 397;BA.debugLine="dia.Show";
Debug.ShouldStop(4096);
main.mostCurrent._dia.runVoidMethod ("Show");
 BA.debugLineNum = 398;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tota_sub() throws Exception{
try {
		Debug.PushSubsStack("tota_sub (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,360);
if (RapidSub.canDelegate("tota_sub")) return de.sclean.main.remoteMe.runUserSub(false, "main","tota_sub");
RemoteObject _stext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _sum = RemoteObject.createImmutable(0);
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _cs = RemoteObject.declareNull("anywheresoftware.b4a.objects.CSBuilder");
 BA.debugLineNum = 360;BA.debugLine="Sub tota_sub";
Debug.ShouldStop(128);
 BA.debugLineNum = 361;BA.debugLine="Dim Stext As Label";
Debug.ShouldStop(256);
_stext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Stext", _stext);
 BA.debugLineNum = 362;BA.debugLine="Stext.Initialize(\"\")";
Debug.ShouldStop(512);
_stext.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 363;BA.debugLine="Stext.TextColor=mcl.md_amber_700";
Debug.ShouldStop(1024);
_stext.runMethod(true,"setTextColor",main.mostCurrent._mcl.runMethod(true,"getmd_amber_700"));
 BA.debugLineNum = 364;BA.debugLine="Stext.TextSize=30";
Debug.ShouldStop(2048);
_stext.runMethod(true,"setTextSize",BA.numberCast(float.class, 30));
 BA.debugLineNum = 365;BA.debugLine="Dim sum As Int=0";
Debug.ShouldStop(4096);
_sum = BA.numberCast(int.class, 0);Debug.locals.put("sum", _sum);Debug.locals.put("sum", _sum);
 BA.debugLineNum = 366;BA.debugLine="For Each s As String In dbase.ListKeys";
Debug.ShouldStop(8192);
{
final RemoteObject group6 = main.mostCurrent._dbase.runClassMethod (de.sclean.keyvaluestore.class, "_listkeys");
final int groupLen6 = group6.runMethod(true,"getSize").<Integer>get()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_s = BA.ObjectToString(group6.runMethod(false,"Get",index6));Debug.locals.put("s", _s);
Debug.locals.put("s", _s);
 BA.debugLineNum = 367;BA.debugLine="sum=sum+s";
Debug.ShouldStop(16384);
_sum = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_sum,BA.numberCast(double.class, _s)}, "+",1, 0));Debug.locals.put("sum", _sum);
 BA.debugLineNum = 368;BA.debugLine="Log(FormatFileSize(sum))";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_formatfilesize(BA.numberCast(float.class, _sum))));
 }
}Debug.locals.put("s", _s);
;
 BA.debugLineNum = 370;BA.debugLine="Dim cs As CSBuilder";
Debug.ShouldStop(131072);
_cs = RemoteObject.createNew ("anywheresoftware.b4a.objects.CSBuilder");Debug.locals.put("cs", _cs);
 BA.debugLineNum = 371;BA.debugLine="Stext.text=FormatFileSize(sum)";
Debug.ShouldStop(262144);
_stext.runMethod(true,"setText",BA.ObjectToCharSequence(_formatfilesize(BA.numberCast(float.class, _sum))));
 BA.debugLineNum = 372;BA.debugLine="cs.Initialize.Color(Colors.ARGB(190,255,255,255))";
Debug.ShouldStop(524288);
_cs.runMethod(false,"Initialize").runMethod(false,"Color",(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 190)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))))).runVoidMethod ("Append",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Total "),main.mostCurrent.__c.getField(true,"CRLF")))));
 BA.debugLineNum = 373;BA.debugLine="cs.Bold.Color(mcl.md_amber_700).Append(Stext.Text";
Debug.ShouldStop(1048576);
_cs.runMethod(false,"Bold").runMethod(false,"Color",(Object)(main.mostCurrent._mcl.runMethod(true,"getmd_amber_700"))).runMethod(false,"Append",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_stext.runMethod(true,"getText"),main.mostCurrent.__c.getField(true,"CRLF"))))).runMethod(false,"Pop").runVoidMethod ("PopAll");
 BA.debugLineNum = 374;BA.debugLine="tota.SetVisibleAnimated(300,True)";
Debug.ShouldStop(2097152);
main.mostCurrent._tota.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 300)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 375;BA.debugLine="tota.Text=cs";
Debug.ShouldStop(4194304);
main.mostCurrent._tota.runMethod(true,"setText",BA.ObjectToCharSequence(_cs.getObject()));
 BA.debugLineNum = 376;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _total_off() throws Exception{
try {
		Debug.PushSubsStack("total_off (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,613);
if (RapidSub.canDelegate("total_off")) return de.sclean.main.remoteMe.runUserSub(false, "main","total_off");
 BA.debugLineNum = 613;BA.debugLine="Sub total_off";
Debug.ShouldStop(16);
 BA.debugLineNum = 615;BA.debugLine="log_list";
Debug.ShouldStop(64);
_log_list();
 BA.debugLineNum = 616;BA.debugLine="prb.Text=\"scan\"";
Debug.ShouldStop(128);
main.mostCurrent._prb.runMethod(true,"setText",BA.ObjectToCharSequence("scan"));
 BA.debugLineNum = 617;BA.debugLine="xOSStats.StartStats";
Debug.ShouldStop(256);
main.mostCurrent._xosstats.runVoidMethod ("_startstats");
 BA.debugLineNum = 618;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _word_click(RemoteObject _tag) throws Exception{
try {
		Debug.PushSubsStack("Word_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,683);
if (RapidSub.canDelegate("word_click")) return de.sclean.main.remoteMe.runUserSub(false, "main","word_click", _tag);
Debug.locals.put("tag", _tag);
 BA.debugLineNum = 683;BA.debugLine="Sub Word_click(tag As Object)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 684;BA.debugLine="Log(tag)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_tag)));
 BA.debugLineNum = 685;BA.debugLine="openurl";
Debug.ShouldStop(4096);
_openurl();
 BA.debugLineNum = 687;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}