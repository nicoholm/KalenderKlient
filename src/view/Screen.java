package view;

import java.awt.CardLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utilities.ViewConstants;
import controls.EventHandler;
import controls.CalenderControls;


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
	public static final int WIDTH = 326;
	
	/** The Constant HEIGHT. */
	public static final int HEIGHT = 603;
	
	//Declare our JPanels
	///** The action event handler. */
	//private ActionEventHandler actionEventHandler;
	
	/** The login. */ // login
	private Login login;
	
	private CalenderWeekly calendarOverview;
	
	private CalenderDaily calendarDay;
	
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
		this.actionEventHandler = new ActionEventHandler(calendarController, this);
		
		//Instanser af JPanels
		calendarOverview = new CalendarOverview(actionEventHandler);
		login = new Login(actionEventHandler);
		calendarDay = new CalendarDay(actionEventHandler);
				
		//Add the panels to the rootPanel
		rootPanel.add(calendarOverview, ViewConstants.CalendarOverview);
		rootPanel.add(login, ViewConstants.Login);
		rootPanel.add(calendarDay, ViewConstants.CalendarDay);
		
		setContentPane(rootPanel);
		
		c = (CardLayout) getContentPane().getLayout();
	}
	
	/**
	 * Gets the mouse event handler.
	 *
	 * @return the mouse event handler
	 */
	public ActionEventHandler getActionEventHandler() {
		return actionEventHandler;
	}
	
	/**
	 * Sets the action event handler.
	 *
	 * @param actionEventHandler the new action event handler
	 */
	public void setActionEventHandler(ActionEventHandler actionEventHandler) {
		this.actionEventHandler = actionEventHandler;
	}
	
	public void show(String card) {
		c.show(rootPanel,  card);
	}

}