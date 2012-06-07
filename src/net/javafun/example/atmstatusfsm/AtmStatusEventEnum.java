package net.javafun.example.atmstatusfsm;

public enum AtmStatusEventEnum {

	CONNECT("atm.connected"), 
	
	CONNECTION_CLOSED("atm.connClosed"),
	
	CONNECTION_LOST("atm.connLost"),
	
	CONNECTION_RESTORED("atm.connRestored"),
	
	LOAD_SUCCESS("atm.loadSuccess"),
	
	LOAD_FAIL("atm.loadFail"),
	
	SHUTDOWN("atm.shutdown"),
	
	STARTUP("atm.startup"),

	;

	private final String eventName;

	private AtmStatusEventEnum(String eventName) {
		this.eventName = eventName;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public static String getNamesAsCsv(){
		StringBuilder sb = new StringBuilder();
		for (AtmStatusEventEnum e : AtmStatusEventEnum.values()) {
			sb.append(e.name());
			sb.append(",");
		}
		return sb.substring(0,sb.length()-2);
	}
	
}
