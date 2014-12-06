package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logik.Manager;
import utilities.ActionConstants;
import utilities.ViewConstants;
import view.Screen;

public class EventHandler implements ActionListener {
	/** The calendar controller. */
	private CalenderControls calenderControls;
	
	/** The screen. */
	private Screen screen;

	/**
	 * Instantiates a new action event handler.
	 *
	 * @param atmController the atm controller
	 * @param screen the screen
	 */
	public EventHandler(CalenderControls calendarController, Screen screen) {
		this.calenderControls = calenderControls;
		this.screen = screen;
	}
	
	public void actionPerformed(ActionEvent e) {
		//Find the actions id, as a different ActionCommand is set for each functionality
		String cmd = e.getActionCommand();

		if (cmd.equals(ActionConstants.Login)) {
			
			/*
			String inputUsername = textField.getText();
        	 String inputPassword = textField_1.getText();
        	 try {
				String loginResult = ServerManager.Login(inputUsername, inputPassword);
				labelResult.setText(loginResult);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				labelResult.setText(e1.getMessage());
			} */
			screen.show(ViewConstants.CalenderWeekly);
		}
		else if(cmd.equals(ActionConstants.Logout)){
			screen.show(ViewConstants.Login);
		}
		else if(cmd.equals(ActionConstants.CalenderDaily)){
			screen.show(ViewConstants.CalenderDaily);
		}
		else if(cmd.equals(ActionConstants.CalenderWeekly)){
			screen.show(ViewConstants.CalenderWeekly);
		}
	}

}