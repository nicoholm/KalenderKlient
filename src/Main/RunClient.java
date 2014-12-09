package Main;

import logik.Manager;
import controls.CalenderControls;


public class RunClient {
	
	public static void main(String[] args) {
		
		Manager sm = new Manager();
	//	System.out.println(sm.RequestCalendar("bruger@bruger.dk"));
		
		CalenderControls calendarController = new CalenderControls();
		//Run the program
		calendarController.run();
	}

}