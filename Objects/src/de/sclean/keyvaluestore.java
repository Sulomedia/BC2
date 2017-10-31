package de.sclean;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class keyvaluestore extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "de.sclean.keyvaluestore");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", de.sclean.keyvaluestore.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.sql.SQL _sql1 = null;
public anywheresoftware.b4a.randomaccessfile.B4XSerializator _ser = null;
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.info _info = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;
public String  _initialize(de.sclean.keyvaluestore __ref,anywheresoftware.b4a.BA _ba,String _dir,String _filename) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba,_dir,_filename});
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Public Sub Initialize (Dir As String, FileName As";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="If sql1.IsInitialized Then sql1.Close";
if (__ref._sql1.IsInitialized()) { 
__ref._sql1.Close();};
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="sql1.Initialize(Dir, FileName, True)";
__ref._sql1.Initialize(_dir,_filename,__c.True);
RDebugUtils.currentLine=5963783;
 //BA.debugLineNum = 5963783;BA.debugLine="CreateTable";
__ref._createtable(null);
RDebugUtils.currentLine=5963784;
 //BA.debugLineNum = 5963784;BA.debugLine="End Sub";
return "";
}
public Object  _get(de.sclean.keyvaluestore __ref,String _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "get"))
	return (Object) Debug.delegate(ba, "get", new Object[] {_key});
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
Object _result = null;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Public Sub Get(Key As String) As Object";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Dim rs As ResultSet = sql1.ExecQuery2(\"SELECT val";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs.setObject((android.database.Cursor)(__ref._sql1.ExecQuery2("SELECT value FROM main WHERE key = ?",new String[]{_key})));
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="Dim result As Object = Null";
_result = __c.Null;
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="If rs.NextRow Then";
if (_rs.NextRow()) { 
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="result = ser.ConvertBytesToObject(rs.GetBlob2(0)";
_result = __ref._ser.ConvertBytesToObject(_rs.GetBlob2((int) (0)));
 };
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="rs.Close";
_rs.Close();
RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _listkeys(de.sclean.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "listkeys"))
	return (anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "listkeys", null);
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _c = null;
anywheresoftware.b4a.objects.collections.List _res = null;
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Public Sub ListKeys As List";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="Dim c As ResultSet = sql1.ExecQuery(\"SELECT key F";
_c = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_c.setObject((android.database.Cursor)(__ref._sql1.ExecQuery("SELECT key FROM main")));
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="Do While c.NextRow";
while (_c.NextRow()) {
RDebugUtils.currentLine=6553605;
 //BA.debugLineNum = 6553605;BA.debugLine="res.Add(c.GetString2(0))";
_res.Add((Object)(_c.GetString2((int) (0))));
 }
;
RDebugUtils.currentLine=6553607;
 //BA.debugLineNum = 6553607;BA.debugLine="c.Close";
_c.Close();
RDebugUtils.currentLine=6553608;
 //BA.debugLineNum = 6553608;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=6553609;
 //BA.debugLineNum = 6553609;BA.debugLine="End Sub";
return null;
}
public String  _deleteall(de.sclean.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "deleteall"))
	return (String) Debug.delegate(ba, "deleteall", null);
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Public Sub DeleteAll";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="sql1.ExecNonQuery(\"DROP TABLE main\")";
__ref._sql1.ExecNonQuery("DROP TABLE main");
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="CreateTable";
__ref._createtable(null);
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="End Sub";
return "";
}
public boolean  _containskey(de.sclean.keyvaluestore __ref,String _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "containskey"))
	return (Boolean) Debug.delegate(ba, "containskey", new Object[] {_key});
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Public Sub ContainsKey(Key As String) As Boolean";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="Return sql1.ExecQuerySingleResult2(\"SELECT count(";
if (true) return (double)(Double.parseDouble(__ref._sql1.ExecQuerySingleResult2("SELECT count(key) FROM main WHERE key = ?",new String[]{_key})))>0;
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="End Sub";
return false;
}
public String  _put(de.sclean.keyvaluestore __ref,String _key,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "put"))
	return (String) Debug.delegate(ba, "put", new Object[] {_key,_value});
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Public Sub Put(Key As String, Value As Object)";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="sql1.ExecNonQuery2(\"INSERT OR REPLACE INTO main V";
__ref._sql1.ExecNonQuery2("INSERT OR REPLACE INTO main VALUES(?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_key),(Object)(__ref._ser.ConvertObjectToBytes(_value))}));
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="End Sub";
return "";
}
public String  _remove(de.sclean.keyvaluestore __ref,String _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "remove"))
	return (String) Debug.delegate(ba, "remove", new Object[] {_key});
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Public Sub Remove(Key As String)";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="sql1.ExecNonQuery2(\"DELETE FROM main WHERE key =";
__ref._sql1.ExecNonQuery2("DELETE FROM main WHERE key = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_key)}));
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="End Sub";
return "";
}
public String  _putbitmap(de.sclean.keyvaluestore __ref,String _key,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "putbitmap"))
	return (String) Debug.delegate(ba, "putbitmap", new Object[] {_key,_value});
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Public Sub PutBitmap(Key As String, Value As Bitma";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="out.InitializeToBytesArray(0)";
_out.InitializeToBytesArray((int) (0));
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="Value.WriteToStream(out, 100, \"PNG\")";
_value.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="Put(Key, out.ToBytesArray)";
__ref._put(null,_key,(Object)(_out.ToBytesArray()));
RDebugUtils.currentLine=6356997;
 //BA.debugLineNum = 6356997;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=6356998;
 //BA.debugLineNum = 6356998;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(de.sclean.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Private sql1 As SQL";
_sql1 = new anywheresoftware.b4a.sql.SQL();
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="Private ser As B4XSerializator";
_ser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="End Sub";
return "";
}
public String  _close(de.sclean.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "close"))
	return (String) Debug.delegate(ba, "close", null);
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Public Sub Close";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="sql1.Close";
__ref._sql1.Close();
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="End Sub";
return "";
}
public String  _createtable(de.sclean.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "createtable"))
	return (String) Debug.delegate(ba, "createtable", null);
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Private Sub CreateTable";
RDebugUtils.currentLine=6815745;
 //BA.debugLineNum = 6815745;BA.debugLine="sql1.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS mai";
__ref._sql1.ExecNonQuery("CREATE TABLE IF NOT EXISTS main(key TEXT PRIMARY KEY, value NONE)");
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getbitmap(de.sclean.keyvaluestore __ref,String _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "getbitmap"))
	return (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "getbitmap", new Object[] {_key});
byte[] _b = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Public Sub GetBitmap(Key As String) As Bitmap";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="Dim b() As Byte = Get(Key)";
_b = (byte[])(__ref._get(null,_key));
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="If b = Null Then Return Null";
if (_b== null) { 
if (true) return (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(__c.Null));};
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="Dim in As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="in.InitializeFromBytesArray(b, 0, b.Length)";
_in.InitializeFromBytesArray(_b,(int) (0),_b.length);
RDebugUtils.currentLine=6422533;
 //BA.debugLineNum = 6422533;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=6422534;
 //BA.debugLineNum = 6422534;BA.debugLine="bmp.Initialize2(in)";
_bmp.Initialize2((java.io.InputStream)(_in.getObject()));
RDebugUtils.currentLine=6422535;
 //BA.debugLineNum = 6422535;BA.debugLine="in.Close";
_in.Close();
RDebugUtils.currentLine=6422536;
 //BA.debugLineNum = 6422536;BA.debugLine="Return bmp";
if (true) return _bmp;
RDebugUtils.currentLine=6422537;
 //BA.debugLineNum = 6422537;BA.debugLine="End Sub";
return null;
}
public Object  _getdefault(de.sclean.keyvaluestore __ref,String _key,Object _defaultvalue) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "getdefault"))
	return (Object) Debug.delegate(ba, "getdefault", new Object[] {_key,_defaultvalue});
Object _res = null;
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Public Sub GetDefault(Key As String, DefaultValue";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="Dim res As Object = Get(Key)";
_res = __ref._get(null,_key);
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="If res = Null Then Return DefaultValue";
if (_res== null) { 
if (true) return _defaultvalue;};
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="End Sub";
return null;
}
public Object  _getencrypted(de.sclean.keyvaluestore __ref,String _key,String _password) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "getencrypted"))
	return (Object) Debug.delegate(ba, "getencrypted", new Object[] {_key,_password});
anywheresoftware.b4a.object.B4XEncryption _cipher = null;
byte[] _b = null;
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Public Sub GetEncrypted (Key As String, Password A";
RDebugUtils.currentLine=6291460;
 //BA.debugLineNum = 6291460;BA.debugLine="Dim cipher As B4XCipher";
_cipher = new anywheresoftware.b4a.object.B4XEncryption();
RDebugUtils.currentLine=6291462;
 //BA.debugLineNum = 6291462;BA.debugLine="Dim b() As Byte = Get(Key)";
_b = (byte[])(__ref._get(null,_key));
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="If b = Null Then Return Null";
if (_b== null) { 
if (true) return __c.Null;};
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="Return ser.ConvertBytesToObject(cipher.Decrypt(b,";
if (true) return __ref._ser.ConvertBytesToObject(_cipher.Decrypt(_b,_password));
RDebugUtils.currentLine=6291465;
 //BA.debugLineNum = 6291465;BA.debugLine="End Sub";
return null;
}
public String  _putencrypted(de.sclean.keyvaluestore __ref,String _key,Object _value,String _password) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "putencrypted"))
	return (String) Debug.delegate(ba, "putencrypted", new Object[] {_key,_value,_password});
anywheresoftware.b4a.object.B4XEncryption _cipher = null;
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Public Sub PutEncrypted (Key As String, Value As O";
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="Dim cipher As B4XCipher";
_cipher = new anywheresoftware.b4a.object.B4XEncryption();
RDebugUtils.currentLine=6225926;
 //BA.debugLineNum = 6225926;BA.debugLine="Put(Key, cipher.Encrypt(ser.ConvertObjectToBytes(";
__ref._put(null,_key,(Object)(_cipher.Encrypt(__ref._ser.ConvertObjectToBytes(_value),_password)));
RDebugUtils.currentLine=6225927;
 //BA.debugLineNum = 6225927;BA.debugLine="End Sub";
return "";
}
}