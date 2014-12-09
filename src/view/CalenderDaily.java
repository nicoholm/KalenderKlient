package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import utilities.ActionConstants;
import controls.EventHandler;

import javax.swing.JLabel;

import logik.Manager;
import events.Appointments;
import events.Calender;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class CalenderDaily extends JPanel{

	private EventHandler actionEventHandler;
	private JLabel lbldate;
	private JLabel lblAppointments;
	private JButton btnLogOut;
	private JButton btnDayOverview;
	private JButton btnM;
	private JButton btnOpret;
	private JLabel lblEvents;
	private JTextField textFieldTitle;
	private JTextField textFieldNote;
	private JTextField textFieldStartDate;
	private JTextField textFieldEndDate;
	private JTextField textFieldLocation;
	private JLabel labelStatus;
	
	   Font italicFont = new Font("Helvetica Neue", Font.ITALIC | Font.PLAIN, 14);
	   Font boldFont = new Font("Helvetica Neue", Font.BOLD | Font.PLAIN, 16);
	   Font plainFont = new Font("Helvetica Neue", Font.PLAIN | Font.PLAIN, 14);
	
	private JPanel panelDates;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JLabel lblNotes;
	private JLabel lblLocation_1;
	private JLabel lblNewLabel;
	private JLabel Bg; 
	  

	public CalenderDaily(EventHandler actionEventHandler) {
		
		this.actionEventHandler = actionEventHandler;
		setLayout(null);
		
		
		labelStatus = new JLabel("");
		labelStatus.setBounds(536, 351, 192, 16);
		labelStatus.setForeground(Color.black);
		labelStatus.setFont(plainFont);
		add(labelStatus);
		
		btnOpret = new JButton("Opret");
		btnOpret.setBounds(582, 310, 117, 29);
		btnOpret.addActionListener( this.actionEventHandler);
		btnOpret.setActionCommand(ActionConstants.CreateEvent);
		add(btnOpret);
		
		textFieldLocation = new JTextField("");
		textFieldLocation.setBounds(572, 264, 134, 28);
		add(textFieldLocation);
		
		textFieldEndDate = new JTextField("");
		textFieldEndDate.setBounds(572, 186, 134, 28);
		add(textFieldEndDate);
		
		textFieldStartDate = new JTextField("");
		textFieldStartDate.setBounds(572, 146, 134, 28);
		add(textFieldStartDate); 
		
		textFieldNote = new JTextField("");
		textFieldNote.setBounds(572, 226, 134, 28);
		add(textFieldNote);
		
		
		textFieldTitle = new JTextField("");
		textFieldTitle.setBounds(572, 106, 134, 28);
		add(textFieldTitle);
		
		
		btnDayOverview = new JButton("Kalenderoversigt");
		btnDayOverview.setBounds(289, 11, 149, 29);
		btnDayOverview.addActionListener( this.actionEventHandler);
		btnDayOverview.setActionCommand(ActionConstants.CalendarOverview);
		add(btnDayOverview);
		
		
		lblEvents = new JLabel("");
		lblEvents.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
		lblEvents.setHorizontalAlignment(SwingConstants.LEFT);
		lblEvents.setBounds(56, 141, 415, 167);
		//add(lblEvents);
		
		panelDates = new JPanel();
		panelDates.setBounds(234, 106, 250, 233);
		panelDates.setLayout(new BoxLayout(panelDates, BoxLayout.PAGE_AXIS));
		panelDates.setOpaque(false);
		add(panelDates);
	
		lbldate = new JLabel("");
		lbldate.setBounds(299, 19, 0, 0);
		add(lbldate);
		
		lblAppointments = new JLabel("Dine aftaler for i dag");
		lblAppointments.setBounds(0, 73, 728, 16);
		lblAppointments.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointments.setForeground(Color.white);
		lblAppointments.setFont(boldFont);
		add(lblAppointments);
		
		btnM = new JButton("Menu");
		btnM.setBounds(6, 11, 117, 29);
		btnM.addActionListener( this.actionEventHandler);
		btnM.setActionCommand(ActionConstants.MainMenu);
		add(btnM);
		
		
		// Standard Swing components
		
		btnLogOut = new JButton("Log af");
		btnLogOut.setBounds(605, 11, 117, 29);
		btnLogOut.addActionListener(this.actionEventHandler);
		btnLogOut.setActionCommand(ActionConstants.Logout);
		add(btnLogOut);
		
		label = new JLabel("");
		label.setBounds(38, 386, 225, 56);
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setForeground(Color.BLACK);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(0, 386, 225, 56);
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		add(label_1);
		
		JLabel lblTitleOnEvent = new JLabel("Title");
		lblTitleOnEvent.setBounds(499, 112, 61, 16);
		add(lblTitleOnEvent);
		
		lblStartDate = new JLabel("Start date");
		lblStartDate.setBounds(499, 152, 61, 16);
		add(lblStartDate);
		
		lblEndDate = new JLabel("End date");
		lblEndDate.setBounds(496, 192, 61, 16);
		add(lblEndDate);
		
		lblNotes = new JLabel("Notes");
		lblNotes.setBounds(496, 232, 61, 16);
		add(lblNotes);
		
		lblLocation_1 = new JLabel("Location");
		lblLocation_1.setBounds(496, 270, 61, 16);
		add(lblLocation_1);
		
	
		
		Bg = new JLabel("");
		Bg.setHorizontalAlignment(SwingConstants.TRAILING);
		Bg.setBounds(6, 424, 225, 56);
		Bg.setIcon(new ImageIcon("res/img/CopenhagenBusinessSchool.jpg"));
		add(Bg);
		
	}
	

	public void setDailyEve(String username)
	
	{

		lblEvents.setText(username);
			
	}
	
	public void setLblEvents(Calender[] calendars) {
				
		for(int i = 0; i< calendars.length; i++)
		{
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel lblTitle = new JLabel("Title:"+calendars[i].getTitle());
			panel.add(lblTitle);
			JLabel lblDate = new JLabel("Date:"+calendars[i].getStartDate()+" to "+calendars[i].getEndDate());
			panel.add(lblDate);
			JLabel lblNote = new JLabel("Note:"+calendars[i].getNote());
			panel.add(lblNote);
			JLabel lblLocation = new JLabel("Location:"+calendars[i].getLocation());
			panel.add(lblLocation);
			panelDates.add(panel);
		}		
	} 
	
	public String getTitle() {
		return textFieldTitle.getText();
	}
	public String getNote() {
		return textFieldNote.getText();
	}
	public String getStartDate() {

		return textFieldStartDate.getText();

	}
	public String getEndDate()  {
		return textFieldEndDate.getText();
	}
	
	public String getLokation() {
		return textFieldLocation.getText();
	}

	public void setStatus(String message) {
		labelStatus.setText(message);
	}
	public void setUserEvents(String events){
		lblEvents.setText(events);
	}
}