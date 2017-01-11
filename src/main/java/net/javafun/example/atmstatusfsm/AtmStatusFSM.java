package net.javafun.example.atmstatusfsm;

import java.util.Collection;
import java.util.Set;

import org.apache.commons.scxml.env.AbstractStateMachine;
import org.apache.commons.scxml.model.State;

/**
 * Atm Status Finite State Machine Example
 * 
 * @see <a href="http://commons.apache.org/scxml/index.html "> Apache Commons Scxml Library </a>
 * @author ozkans
 *
 */
public class AtmStatusFSM extends AbstractStateMachine {

	/**
	 * State Machine uses this scmxml config file
	 */
	private static final String SCXML_CONFIG_ATM_STATUS = "atm_status.xml";


	/* ------------------------------------------------------------------------ */
	/* CONSTRUCTOR(S) */
	/* ------------------------------------------------------------------------ */
	
	public AtmStatusFSM() {
        	super(AtmStatusFSM.class.getClassLoader().getResource(SCXML_CONFIG_ATM_STATUS));
	}
	
	/* ------------------------------------------------------------------------ */
	/* HELPER METHOD(S) */
	/* ------------------------------------------------------------------------ */
	
	public void firePreDefinedEvent(AtmStatusEventEnum eventEnum){
		System.out.println("EVENT: " + eventEnum);
		this.fireEvent(eventEnum.getEventName());
	}
	
	public void callState(String name){
		this.invoke(name);
	}
	
	public String getCurrentStateId() {
		Set<?> states = getEngine().getCurrentStatus().getStates();
		State state = (State) states.iterator().next();
		return state.getId();
	}
	
	public State getCurrentState() {
		Set<?> states = getEngine().getCurrentStatus().getStates();
		return ( (State) states.iterator().next());
	}
	
	public Collection<?> getCurrentStateEvents() {
		return getEngine().getCurrentStatus().getEvents();
	}
	
	/* ------------------------------------------------------------------------ */
	// STATES
	// 
	// Each method below is the activity corresponding to a state in the
	// SCXML document (see class constructor for pointer to the document).
	/* ------------------------------------------------------------------------ */
	
	 public void idle() {
		System.out.println("STATE: idle");
	 }
	 
	 public void loading() {
		 System.out.println("STATE: loading");
	 }
	 
	 public void inService() {
		 System.out.println("STATE: inService");
	 }
	 
	 public void outOfService() {
		 System.out.println("STATE: outOfService");
	 }
	 
	 public void disconnected() {
		 System.out.println("STATE: disconnected");
	 }
}
