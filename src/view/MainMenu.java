package view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import utilities.ActionConstants;
import controls.EventHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JPanel {
	
	private EventHandler actionEventHandler;

	
	private JLabel Background;
	private JLabel lblCurrentuser;
	private JLabel lblWelcome;
	private JLabel lblSeedaily;
	private JLabel lblSeeWeekly;
	private JButton btnLogOut;
	private JButton btnUgeKalendar;
	private JButton btnIdag;

	   Font italicFont = new Font("Helvetica Neue", Font.ITALIC | Font.PLAIN, 14);
	   Font boldFont = new Font("Helvetica Neue", Font.BOLD | Font.PLAIN, 16);
	   Font plainFont = new Font("Helvetica Neue", Font.PLAIN | Font.PLAIN, 14);
	

	/**
	 * Create the panel.
	 */
	public MainMenu(EventHandler actionEventHandler) {
		
		this.actionEventHandler = actionEventHandler;
		setLayout(null);
		
		
		lblWelcome = new JLabel("Welcome, you're now logged in");
		lblWelcome.setBackground(Color.BLACK);
		lblWelcome.setBounds(0, 52, 721, 16);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(Color.white);
		lblWelcome.setFont(boldFont);
		add(lblWelcome);
		
		btnIdag = new JButton("Weekly");
		btnIdag.setBounds(37, 177, 117, 29);
		btnIdag.addActionListener( this.actionEventHandler);
		btnIdag.setActionCommand(ActionConstants.CalenderDaily);
		add(btnIdag);
		
		btnUgeKalendar = new JButton("Daily");
		btnUgeKalendar.setBounds(37, 88, 117, 29);
		btnUgeKalendar.addActionListener( this.actionEventHandler);
		btnUgeKalendar.setActionCommand(ActionConstants.CalenderWeekly);
		add(btnUgeKalendar);
		
		lblSeedaily = new JLabel("See your appointments for today");
		lblSeedaily.setBounds(10, 129, 261, 16);
		lblSeedaily.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeedaily.setForeground(Color.white);
		lblSeedaily.setFont(italicFont);
		add(lblSeedaily);
		
		
		lblSeeWeekly = new JLabel("See you apointments for the week");
		lblSeeWeekly.setBounds(34, 218, 225, 16);
		lblSeeWeekly.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeeWeekly.setForeground(Color.white);
		lblSeeWeekly.setFont(italicFont);
		add(lblSeeWeekly);
		
		lblCurrentuser = new JLabel("");
		lblCurrentuser.setBounds(0, 101, 727, 16);
		lblCurrentuser.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentuser.setForeground(Color.white);
		lblCurrentuser.setFont(boldFont);
		add(lblCurrentuser);
		
		// Standard Swing components
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(605, 11, 117, 29);
		btnLogOut.addActionListener(this.actionEventHandler);
		btnLogOut.setActionCommand(ActionConstants.Logout);
		add(btnLogOut);
		
		Background = new JLabel("");
		Background.setBackground(Color.BLACK);
		Background.setBounds(10, 6, 728, 400);
		Background.setIcon(new ImageIcon("res/img/MainMenubg.png"));
		add(Background);

	}
	public void setWellcomeText(String username)
	
	{

		lblCurrentuser.setText(username);
			
	}
}