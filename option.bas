Type=Activity
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	Private rfont As Typeface= rfont.LoadFromAssets("Aldrich-Regular.ttf")
	Private package As String="de.sclean"
	Dim utext As String="www.sulomedia.de"
End Sub

Sub Globals
	Private acb1 As ACCheckBox
	Private Ctext As Label
	Private Mtext As Label
	Private Panel1 As Panel
	Private lv2 As ListView
	Private mcl As MaterialColors
	Private savedata As KeyValueStore
	Private pack As PackageManager
	Private ab1 As ACFlatButton
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("2")
	savedata.Initialize(File.DirInternal,"save_data")
	Mtext.Typeface=rfont
	Ctext.Typeface=rfont
	acb1.TextSize=12
	acb1.Typeface=rfont
	acb1.Text="Service Modul: Deaktiviert"
	ab1.Text="zurück"
	ab1.Typeface=rfont
	Dim cs As CSBuilder
	cs.Initialize.Alignment("ALIGN_CENTER").Append("Einstellungen").PopAll
	Mtext.Text=cs	
	If StateManager.RestoreState(Activity, "option", 0) = False Then
		acb1.Checked=False
	End If
	c_text
	l_text
End Sub

Sub Activity_Resume
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If KeyCode=KeyCodes.KEYCODE_BACK Then
		StateManager.SaveState(Activity,"option")
		Activity.Finish
		Animator.setanimati("extra_in", "extra_out")
	End If
	Return(True)
End Sub

Sub c_text
	Dim cs As CSBuilder
	cs.Initialize.Color(mcl.md_black_1000).Append("Hier wird das 'Cleaner Service Module' Aktiviert oder Deaktiviert").Pop.PopAll
	Ctext.Text=cs
End Sub

Sub acb1_CheckedChange(Checked As Boolean)
	Select Checked
		Case True 
			StartService(info)
			acb1.Text="Service: Aktiviert"
			save(True)
		Case False 
			acb1.Text="Service: Deaktiviert"
			StopService(info)
			save(False)
	End Select
End Sub

Sub save(sav As Boolean)
	If sav=True Then
		savedata.Put("sv",sav)
		Else 
			savedata.Remove("sv")
	End If
	
End Sub

Sub l_text
	Dim la1,la2 As Label
	la2.Initialize("la2")
	la1.Initialize("la1")
	la1=lv2.TwoLinesAndBitmap.Label
	la2=lv2.TwoLinesAndBitmap.SecondLabel
	lv2.TwoLinesAndBitmap.ImageView.Height=32dip
	lv2.TwoLinesAndBitmap.ImageView.Width=32dip
	lv2.TwoLinesAndBitmap.ItemHeight=50dip
	la1.TextSize=15
	la2.TextSize=11
	la1.Typeface=rfont
	la2.Typeface=rfont
	la1.TextColor=Colors.ARGB(255,36,220,238)
	la2.TextColor=Colors.ARGB(230,0,0,0)
	lv2.Clear
	lv2.AddTwoLinesAndBitmap2("About","alles über Scleaner",LoadBitmap(File.DirAssets,"ic_extension_white_36dp.png"),2)
End Sub

Sub lv2_ItemClick (Position As Int, Value As Object)
	Select Value
		Case 2 
			about_click
	End Select
End Sub


Sub about_click
	Dim l1,l2 As Label
	l1.Initialize("")
	l2.Initialize("")
	l2.TextSize=15
	l1.TextSize=13
	l1.textcolor=mcl.md_black_1000
	l2.textcolor=mcl.md_black_1000
	l1.Gravity=Gravity.TOP
	l1.Typeface=rfont
	l2.Typeface=rfont
	Dim cs As CSBuilder
	cs.Initialize.Append("App Ver: "&pack.GetVersionName(package)&CRLF&"Build Nr: "&pack.GetVersionCode(package)&CRLF&CRLF&"Code: D.Trojan"&CRLF).Append("Published by Sulomedia"&CRLF&"© 2017"&CRLF&CRLF)
	cs.Append(CreateClickableWord(utext)).PopAll
	l2.Text="About "&pack.GetApplicationLabel(package)
	l1.Text=cs
	Dim infodia As MaterialDialog
	Dim inf As BitmapDrawable
	inf.Initialize(LoadBitmap(File.DirAssets,"ic_android_black_36dp.png"))
	Dim Builder As MaterialDialogBuilder
	Builder.Initialize("Dialog3")
	Builder.Title(l2.Text).TitleColor(mcl.md_black_1000).Icon(inf).LimitIconToDefaultSize.Theme(Builder.THEME_LIGHT).Content(cs).ContentLineSpacing(1dip).Typeface(rfont,rfont).Cancelable(True).NeutralText("close").NeutralColor(mcl.md_grey_600).ContentGravity(Builder.GRAVITY_START).ContentLineSpacing(2)
	infodia=Builder.Show
	infodia.Show
	cs.EnableClickEvents(l1)
End Sub



Sub ab1_Click
	StateManager.SaveState(Activity,"option")
	Activity.Finish
	Animator.setanimati("extra_in", "extra_out")
End Sub


Sub CreateClickableWord(Text As String) As CSBuilder
	Dim cs As CSBuilder
	Return cs.Initialize.Underline.Color(0xFF00D0FF).Clickable("Word", Text).Append(Text).PopAll
End Sub
Sub Word_click(tag As Object)
	Log(tag)
	openurl

End Sub
Sub openurl
	Dim url As String="https://www.sulomedia.de"
	Dim i As Intent
	i.Initialize(i.ACTION_VIEW, url)
	i.SetType("text/html")
	i.AddCategory("android.intent.category.BROWSABLE")
	StartActivity(i)
End Sub