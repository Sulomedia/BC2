
package de.sclean;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class keyvaluestore {
    public static RemoteObject myClass;
	public keyvaluestore() {
	}
    public static PCBA staticBA = new PCBA(null, keyvaluestore.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sql1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _ser = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.B4XSerializator");
public static de.sclean.main _main = null;
public static de.sclean.supp _supp = null;
public static de.sclean.option _option = null;
public static de.sclean.starter _starter = null;
public static de.sclean.info _info = null;
public static de.sclean.widget _widget = null;
public static de.sclean.statemanager _statemanager = null;
public static de.sclean.animator _animator = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"ser",_ref.getField(false, "_ser"),"sql1",_ref.getField(false, "_sql1")};
}
}