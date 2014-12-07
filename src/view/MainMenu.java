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
	private JLabel lblCurrentuser;
	private JLabel lblWelcome;
	private JLabel lblSeedaily;
	private JLabel lblSeeWeekly;
	private JButton btnLogOut;
	private JButton btnUgeKalendar;
	private JButton btnIdag;
	private JLabel Bg;

	   Font italicFont = new Font("Helvetica Neue", Font.ITALIC | Font.PLAIN, 14);
	   Font boldFont = new Font("Helvetica Neue", Font.BOLD | Font.PLAIN, 16);
	   Font plainFont = new Font("Helvetica Neue", Font.PLAIN | Font.PLAIN, 14);
	   private JButton btnWeather;
	

	/**
	 * Create the panel.
	 */
	public MainMenu(EventHandler actionEventHandler) {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		
		this.actionEventHandler = actionEventHandler;
		setLayout(null);
		
		Bg = new JLabel("");
		Bg.setBounds(20, 283, 382, 144);
		Bg.setIcon(new ImageIcon("res/img/CopenhagenBusinessSchool.jpg"));
		add(Bg);
		
		
		lblWelcome = new JLabel("Welcome, you're now logged in");
		lblWelcome.setBackground(Color.BLACK);
		lblWelcome.setBounds(38, 27, 270, 16);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(Color.white);
		lblWelcome.setFont(boldFont);
		add(lblWelcome);
		
		btnIdag = new JButton("Daily");
		btnIdag.setBounds(20, 138, 117, 29);
		btnIdag.addActionListener( this.actionEventHandler);
		btnIdag.setActionCommand(ActionConstants.CalenderDaily);
		add(btnIdag);
		
		btnUgeKalendar = new JButton("Weekly");
		btnUgeKalendar.setBounds(20, 69, 117, 29);
		btnUgeKalendar.addActionListener( this.actionEventHandler);
		btnUgeKalendar.setActionCommand(ActionConstants.CalenderWeekly);
		add(btnUgeKalendar);
		
		lblSeedaily = new JLabel("See your appointments for the week");
		lblSeedaily.setBackground(Color.LIGHT_GRAY);
		lblSeedaily.setBounds(10, 110, 261, 16);
		lblSeedaily.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeedaily.setForeground(Color.white);
		lblSeedaily.setFont(italicFont);
		add(lblSeedaily);
		
		
		lblSeeWeekly = new JLabel("See you appointments for the day");
		lblSeeWeekly.setBackground(Color.LIGHT_GRAY);
		lblSeeWeekly.setBounds(20, 187, 225, 16);
		lblSeeWeekly.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeeWeekly.setForeground(Color.white);
		lblSeeWeekly.setFont(italicFont);
		add(lblSeeWeekly);
		
		lblCurrentuser = new JLabel("");
		lblCurrentuser.setBounds(300, 27, 165, 16);
		lblCurrentuser.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentuser.setForeground(Color.white);
		lblCurrentuser.setFont(boldFont);
		add(lblCurrentuser);
		
		// Standard Swing components
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(375, 406, 117, 29);
		btnLogOut.addActionListener(this.actionEventHandler);
		btnLogOut.setActionCommand(ActionConstants.Logout);
		add(btnLogOut);
		
		btnWeather = new JButton("Weather");
		btnWeather.setActionCommand("CalenderDaily");
		btnWeather.setBounds(20, 226, 117, 29);
		add(btnWeather);
		
		JLabel lblSeeTheWeather = new JLabel("See the weather forecast");
		lblSeeTheWeather.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeeTheWeather.setForeground(Color.WHITE);
		lblSeeTheWeather.setFont(new Font("Helvetica Neue", Font.ITALIC, 14));
		lblSeeTheWeather.setBackground(Color.LIGHT_GRAY);
		lblSeeTheWeather.setBounds(20, 267, 225, 16);
		add(lblSeeTheWeather);
		
		JButton btnQotd = new JButton("QOTD");
		btnQotd.setActionCommand("CalenderDaily");
		btnQotd.setBounds(20, 308, 117, 29);
		add(btnQotd);
		
		JLabel lblCheckQuoteOf = new JLabel("Check quote of the day");
		lblCheckQuoteOf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckQuoteOf.setForeground(Color.WHITE);
		lblCheckQuoteOf.setFont(new Font("Helvetica Neue", Font.ITALIC, 14));
		lblCheckQuoteOf.setBackground(Color.LIGHT_GRAY);
		lblCheckQuoteOf.setBounds(20, 359, 225, 16);
		add(lblCheckQuoteOf);
		

	}
	public void setWellcomeText(String username)
	
	{

		lblCurrentuser.setText(username);
			
	}
}