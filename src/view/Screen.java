package view;

import java.awt.CardLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import events.Appointments;
import events.CreateEvent;
import events.ShowCalender;
import utilities.ViewConstants;
import controls.EventHandler;
import controls.CalenderControls;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;


/**
 * The Class Screen.
 */
public class Screen extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Windows properties
	/** The Constant WIDTH. */
	public static final int WIDTH = 900;
	
	/** The Constant HEIGHT. */
	public static final int HEIGHT = 500;
	
	
	
	//Declare our JPanels
	///** The action event handler. */
	//private ActionEventHandler actionEventHandler;
	
	/** The login. */ // login
	private Login login;
	
	private MainMenu mainMenu;
	
	
	private CalenderDaily calendarDay;
	
	private events.User currentUser;
	
	private events.ShowCalender email;
		
	/** get events. */
	private Appointments calendarDate;
	

	
	/** The root panel. */
	private JPanel rootPanel;

	private EventHandler actionEventHandler;
	
	/** The c. */
	CardLayout c;
	
	public Screen(CalenderControls calendarController)
	{

		//Add the properties to the windows
		setTitle("Kalender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		
		rootPanel = new JPanel();
		rootPanel.setLayout(new CardLayout(0,0));
		
		//Initiate a new actionEventHandler
		this.actionEventHandler = new EventHandler(calendarController, this);
		
		//Instanser af JPanels
		login = new Login(actionEventHandler);
		login.setBackground(Color.BLACK);
		calendarDay = new CalenderDaily(actionEventHandler);
		mainMenu = new MainMenu(actionEventHandler);
				
		//Add the panels to the rootPanel
		rootPanel.add(login, ViewConstants.Login);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(81, 416, 225, 56);
		login.add(label);
		rootPanel.add(calendarDay, ViewConstants.CalendarDay);
		rootPanel.add(mainMenu, ViewConstants.MainMenu);
		
	
		
		setContentPane(rootPanel);
		
		c = (CardLayout) getContentPane().getLayout();
	}
	
	/**
	 * Gets the mouse event handler.
	 *
	 * @return the mouse event handler
	 */
	public EventHandler getActionEventHandler() {
		return actionEventHandler;
	}
	
	/**
	 * Sets the action event handler.
	 *
	 * @param actionEventHandler the new action event handler
	 */
	public void setActionEventHandler(EventHandler actionEventHandler) {
		this.actionEventHandler = actionEventHandler;
	}
	
	public void show(String card) {
		c.show(rootPanel,  card);
	}
	
	public Login getLoginView(){
		return login;
	}
	
	public MainMenu getMainMenu() {

		return mainMenu;
	}

	public CalenderDaily getCalendarDay() {

		return calendarDay;
	}

	public events.User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(events.User currentUser) {
		this.currentUser = currentUser;
	}

	public Appointments getDailyEvents () {
		return calendarDate;
	}

	public void setDailyEvents(Appointments calendarDate) {
		this.calendarDate = calendarDate;
	}
	public ShowCalender getRequest () {
		return email;
	}
	public void setRequest(ShowCalender email) {
		this.email = email;
	}
}