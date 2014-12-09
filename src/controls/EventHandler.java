package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import logik.Manager;
import events.Appointments;
import events.Calender;
import events.User;
import utilities.ActionConstants;
import utilities.ViewConstants;
import view.CalenderDaily;
import view.Login;
import view.MainMenu;
import view.Screen;

public class EventHandler implements ActionListener {
	/** The calendar controller. */
	private CalenderControls calendarController;
	
	/** The screen. */
	private Screen screen;

	private User currentUser;

	/**
	 * Instantiates a new action event handler.
	 *
	 * @param atmController the atm controller
	 * @param screen the screen
	 */
	public EventHandler(CalenderControls calendarController, Screen screen) {
		this.calendarController = calendarController;
		this.screen = screen;
	}
	
	public void actionPerformed(ActionEvent e) {
		//Find the actions id, as a different ActionCommand is set for each functionality
		String cmd = e.getActionCommand();

		if (cmd.equals(ActionConstants.Login)) {
			
			String username = screen.getLoginView().getUserName();
			String password = screen.getLoginView().getPassword();
			
			try {
				screen.setCurrentUser(Manager.Login(username, password));
				screen.show(ViewConstants.MainMenu);
				screen.getMainMenu().setWellcomeText(username);
			} catch (Exception e1) {
				screen.getLoginView().setStatus(e1.getMessage());
			}		
		}
		else if(cmd.equals(ActionConstants.Logout)){
			screen.getLoginView().resetView();
			screen.setCurrentUser(null);
			
			screen.show(ViewConstants.Login);
		}
		else if(cmd.equals(ActionConstants.CalendarDay)){
			
			String userName = screen.getLoginView().getUserName();
			try {	
				Calender[] calendars = Manager.RequestCalendar(userName);
				screen.getCalendarDay().setLblEvents(calendars);
				
			} catch (Exception e1) {
				screen.getCalendarDay().setStatus(e1.getMessage());
			}
			
			
			
			screen.show(ViewConstants.CalendarDay);
		}
		else if(cmd.equals(ActionConstants.CalendarOverview)){
			screen.show(ViewConstants.CalendarOverview);
		}
		else if(cmd.equals(ActionConstants.MainMenu)){
			screen.show(ViewConstants.MainMenu);
		}
		else if(cmd.equals(ActionConstants.CreateEvent)){
			
			
			String titel = screen.getCalendarDay().getTitle();
			String note = screen.getCalendarDay().getNote();
			String lokation = screen.getCalendarDay().getLokation();
			String startDate = screen.getCalendarDay().getStartDate();
			String endDate = screen.getCalendarDay().getEndDate();
			String userName = screen.getLoginView().getUserName();
			try {		
				screen.setDailyEvents(Manager.CreateCalendar(titel, startDate, endDate, note, lokation, userName));
			} catch (Exception e1) {
				screen.getCalendarDay().setStatus(e1.getMessage());
			}
			
			
		}
		
	}

	public User getCurrentUser() {
		return currentUser;
	}
}