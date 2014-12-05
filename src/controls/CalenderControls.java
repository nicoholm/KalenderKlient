package controls;

import javax.swing.JFrame;

import utilities.ViewConstants;
import view.Screen;


public class CalenderControls {

	/** The screen. */
	private Screen screen;
	
	public CalenderControls() {
		this.screen = new Screen(this);
	}

	public void run() {
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
		screen.setLocationRelativeTo(null);
		screen.show(ViewConstants.Login);
	}

}