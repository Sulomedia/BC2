package de.sclean.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_1{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[1/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="toolbar.SetTopAndBottom(0,10%y)"[1/General script]
views.get("toolbar").vw.setTop((int)(0d));
views.get("toolbar").vw.setHeight((int)((10d / 100 * height) - (0d)));
//BA.debugLineNum = 4;BA.debugLine="toolbar.SetLeftAndRight(0,100%x)"[1/General script]
views.get("toolbar").vw.setLeft((int)(0d));
views.get("toolbar").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 5;BA.debugLine="tota.SetTopAndBottom(85%y,98%y)"[1/General script]
views.get("tota").vw.setTop((int)((85d / 100 * height)));
views.get("tota").vw.setHeight((int)((98d / 100 * height) - ((85d / 100 * height))));
//BA.debugLineNum = 6;BA.debugLine="tota.SetLeftAndRight(30%x,70%x)"[1/General script]
views.get("tota").vw.setLeft((int)((30d / 100 * width)));
views.get("tota").vw.setWidth((int)((70d / 100 * width) - ((30d / 100 * width))));
//BA.debugLineNum = 7;BA.debugLine="prb.SetTopAndBottom(70%y,tota.Top-5dip)"[1/General script]
views.get("prb").vw.setTop((int)((70d / 100 * height)));
views.get("prb").vw.setHeight((int)((views.get("tota").vw.getTop())-(5d * scale) - ((70d / 100 * height))));
//BA.debugLineNum = 8;BA.debugLine="prb.SetLeftAndRight(35%x,65%x)"[1/General script]
views.get("prb").vw.setLeft((int)((35d / 100 * width)));
views.get("prb").vw.setWidth((int)((65d / 100 * width) - ((35d / 100 * width))));
//BA.debugLineNum = 9;BA.debugLine="ipan2.SetTopAndBottom(toolbar.Bottom,40%y)"[1/General script]
views.get("ipan2").vw.setTop((int)((views.get("toolbar").vw.getTop() + views.get("toolbar").vw.getHeight())));
views.get("ipan2").vw.setHeight((int)((40d / 100 * height) - ((views.get("toolbar").vw.getTop() + views.get("toolbar").vw.getHeight()))));
//BA.debugLineNum = 10;BA.debugLine="ipan2.SetLeftAndRight(0,100%x)"[1/General script]
views.get("ipan2").vw.setLeft((int)(0d));
views.get("ipan2").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 11;BA.debugLine="lv1.SetLeftAndRight(1%x,97%x)"[1/General script]
views.get("lv1").vw.setLeft((int)((1d / 100 * width)));
views.get("lv1").vw.setWidth((int)((97d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 12;BA.debugLine="lv1.SetTopAndBottom(1%y,13%y)"[1/General script]
views.get("lv1").vw.setTop((int)((1d / 100 * height)));
views.get("lv1").vw.setHeight((int)((13d / 100 * height) - ((1d / 100 * height))));
//BA.debugLineNum = 13;BA.debugLine="extrapan.SetLeftAndRight(1%x,99%x)"[1/General script]
views.get("extrapan").vw.setLeft((int)((1d / 100 * width)));
views.get("extrapan").vw.setWidth((int)((99d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 14;BA.debugLine="extrapan.SetTopAndBottom(54%y,99%y)"[1/General script]
views.get("extrapan").vw.setTop((int)((54d / 100 * height)));
views.get("extrapan").vw.setHeight((int)((99d / 100 * height) - ((54d / 100 * height))));
//BA.debugLineNum = 15;BA.debugLine="pb1.Top=toolbar.Bottom+5dip"[1/General script]
views.get("pb1").vw.setTop((int)((views.get("toolbar").vw.getTop() + views.get("toolbar").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 16;BA.debugLine="pb1.Left=3%x"[1/General script]
views.get("pb1").vw.setLeft((int)((3d / 100 * width)));
//BA.debugLineNum = 17;BA.debugLine="pb2.Top=toolbar.Bottom+27dip"[1/General script]
views.get("pb2").vw.setTop((int)((views.get("toolbar").vw.getTop() + views.get("toolbar").vw.getHeight())+(27d * scale)));
//BA.debugLineNum = 18;BA.debugLine="pb2.Right=97%x"[1/General script]
views.get("pb2").vw.setLeft((int)((97d / 100 * width) - (views.get("pb2").vw.getWidth())));
//BA.debugLineNum = 19;BA.debugLine="prb2.SetTopAndBottom(32%y,42%y)"[1/General script]
views.get("prb2").vw.setTop((int)((32d / 100 * height)));
views.get("prb2").vw.setHeight((int)((42d / 100 * height) - ((32d / 100 * height))));
//BA.debugLineNum = 20;BA.debugLine="prb3.SetTopAndBottom(32%y,42%y)"[1/General script]
views.get("prb3").vw.setTop((int)((32d / 100 * height)));
views.get("prb3").vw.setHeight((int)((42d / 100 * height) - ((32d / 100 * height))));
//BA.debugLineNum = 21;BA.debugLine="prb2.Left=58%x"[1/General script]
views.get("prb2").vw.setLeft((int)((58d / 100 * width)));
//BA.debugLineNum = 22;BA.debugLine="prb3.Left=8%x"[1/General script]
views.get("prb3").vw.setLeft((int)((8d / 100 * width)));
//BA.debugLineNum = 23;BA.debugLine="tool2.SetLeftAndRight(5%x,95%x)"[1/General script]
views.get("tool2").vw.setLeft((int)((5d / 100 * width)));
views.get("tool2").vw.setWidth((int)((95d / 100 * width) - ((5d / 100 * width))));
//BA.debugLineNum = 24;BA.debugLine="tool2.SetTopAndBottom(48%y,60%y)"[1/General script]
views.get("tool2").vw.setTop((int)((48d / 100 * height)));
views.get("tool2").vw.setHeight((int)((60d / 100 * height) - ((48d / 100 * height))));
//BA.debugLineNum = 25;BA.debugLine="tool2.Top=41%y"[1/General script]
views.get("tool2").vw.setTop((int)((41d / 100 * height)));
//BA.debugLineNum = 26;BA.debugLine="rb1.SetTopAndBottom(0%x,20%x)"[1/General script]
views.get("rb1").vw.setTop((int)((0d / 100 * width)));
views.get("rb1").vw.setHeight((int)((20d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 27;BA.debugLine="rb1.SetLeftAndRight(1%x,21%x)"[1/General script]
views.get("rb1").vw.setLeft((int)((1d / 100 * width)));
views.get("rb1").vw.setWidth((int)((21d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 28;BA.debugLine="rb2.SetLeftAndRight(rl1.Right+5dip,64%x)"[1/General script]
views.get("rb2").vw.setLeft((int)((views.get("rl1").vw.getLeft() + views.get("rl1").vw.getWidth())+(5d * scale)));
views.get("rb2").vw.setWidth((int)((64d / 100 * width) - ((views.get("rl1").vw.getLeft() + views.get("rl1").vw.getWidth())+(5d * scale))));
//BA.debugLineNum = 29;BA.debugLine="lvb1.SetLeftAndRight(rl1.Right+5dip,64%x)"[1/General script]
views.get("lvb1").vw.setLeft((int)((views.get("rl1").vw.getLeft() + views.get("rl1").vw.getWidth())+(5d * scale)));
views.get("lvb1").vw.setWidth((int)((64d / 100 * width) - ((views.get("rl1").vw.getLeft() + views.get("rl1").vw.getWidth())+(5d * scale))));
//BA.debugLineNum = 30;BA.debugLine="rb2.SetTopAndBottom(0%x,20%x)"[1/General script]
views.get("rb2").vw.setTop((int)((0d / 100 * width)));
views.get("rb2").vw.setHeight((int)((20d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 31;BA.debugLine="lvb1.SetTopAndBottom(0%x,20%x)"[1/General script]
views.get("lvb1").vw.setTop((int)((0d / 100 * width)));
views.get("lvb1").vw.setHeight((int)((20d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 32;BA.debugLine="rl1.SetLeftAndRight(rb1.Right+2dip,40%x)"[1/General script]
views.get("rl1").vw.setLeft((int)((views.get("rb1").vw.getLeft() + views.get("rb1").vw.getWidth())+(2d * scale)));
views.get("rl1").vw.setWidth((int)((40d / 100 * width) - ((views.get("rb1").vw.getLeft() + views.get("rb1").vw.getWidth())+(2d * scale))));
//BA.debugLineNum = 33;BA.debugLine="rl2.SetLeftAndRight(rb2.Right+2dip,85%x)"[1/General script]
views.get("rl2").vw.setLeft((int)((views.get("rb2").vw.getLeft() + views.get("rb2").vw.getWidth())+(2d * scale)));
views.get("rl2").vw.setWidth((int)((85d / 100 * width) - ((views.get("rb2").vw.getLeft() + views.get("rb2").vw.getWidth())+(2d * scale))));
//BA.debugLineNum = 34;BA.debugLine="rl1.Top=2%x"[1/General script]
views.get("rl1").vw.setTop((int)((2d / 100 * width)));
//BA.debugLineNum = 35;BA.debugLine="rl2.Top=2%x"[1/General script]
views.get("rl2").vw.setTop((int)((2d / 100 * width)));

}
}