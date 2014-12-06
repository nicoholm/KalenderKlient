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
	
	private CalenderWeekly calenderWeekly;
	
	private CalenderDaily calenderDaily;
	
	/** The root panel. */
	private JPanel rootPanel;

	private EventHandler actionEventHandler;
	
	/** The c. */
	CardLayout c;
	
	public Screen(CalenderControls calenderControls)
	{

		//Add the properties to the windows
		setTitle("Kalender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		
		rootPanel = new JPanel();
		rootPanel.setLayout(new CardLayout(0,0));
		
		//Initiate a new actionEventHandler
		this.actionEventHandler = new EventHandler(calenderControls, this);
		
		//Instanser af JPanels
		calenderWeekly = new CalenderWeekly(actionEventHandler);
		login = new Login(actionEventHandler);
		calenderDaily = new CalenderDaily(actionEventHandler);
				
		//Add the panels to the rootPanel
		rootPanel.add(calenderWeekly, ViewConstants.CalenderWeekly);
		rootPanel.add(login, ViewConstants.Login);
		rootPanel.add(calenderDaily, ViewConstants.CalenderDaily);
		
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

}