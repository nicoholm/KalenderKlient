package view;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controls.EventHandler;

import javax.swing.JButton;

import utilities.ActionConstants;

import java.awt.Color;
import java.awt.Font;

public class Login extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private EventHandler actionEventHandler;
	private JPasswordField textFieldPassword;
	private JTextField textFieldUserName;
	private JLabel labelStatus;
	private JButton btnLogin;
	private JLabel lblEnterDetails;
	private JLabel Background;
	private JLabel lblEnterEmail;

	
	   Font italicFont = new Font("Helvetica Neue", Font.ITALIC | Font.PLAIN, 14);
	   Font boldFont = new Font("Helvetica Neue", Font.BOLD | Font.PLAIN, 16);
	   Font plainFont = new Font("Helvetica Neue", Font.PLAIN | Font.PLAIN, 14);
	
	
	public Login(EventHandler actionEventHandler) {
		
		this.actionEventHandler = actionEventHandler;
		setLayout(null);
		
		labelStatus = new JLabel("");
		labelStatus.setBounds(300, 241, 124, 16);
		labelStatus.setForeground(Color.white);
		labelStatus.setFont(plainFont);
		add(labelStatus);
		
	
		// Swing components
		
		lblEnterDetails = new JLabel("Indtast dine informationer");
		lblEnterDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDetails.setBounds(0, 52, 721, 16);
		lblEnterDetails.setForeground(Color.white);
		lblEnterDetails.setFont(boldFont);
		add(lblEnterDetails);
		
		lblEnterEmail = new JLabel();
		lblEnterEmail.setBounds(288, 19, 0, 0);
		lblEnterEmail.setForeground(Color.white);
		lblEnterEmail.setFont(italicFont);
		add(lblEnterEmail);
		
		
		btnLogin = new JButton("Log ind");
		btnLogin.setBounds(311, 200, 91, 29);
		btnLogin.addActionListener( this.actionEventHandler);
		btnLogin.setActionCommand(ActionConstants.Login);
		add(btnLogin);
		
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(290, 100, 134, 28);
		textFieldUserName.setToolTipText("Password");
		textFieldUserName.setColumns(10);
		add(textFieldUserName);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(290, 145, 134, 28);
		textFieldPassword.setToolTipText("Email");
		textFieldPassword.setColumns(10);
		add(textFieldPassword);
		
		
		// JLabel as background
		
		Background = new JLabel("");
		Background.setBackground(Color.BLACK);
		Background.setIcon(new ImageIcon("res/img/MainMenubg.png"));
		Background.setBounds(0, 0, 728, 400);
		add(Background);
		
					
		setTempDate();
	}
	
	private void setTempDate(){
		textFieldUserName.setText("bruger@bruger.dk");
		textFieldPassword.setText("1234");
	}

	public String getUserName() {
		return textFieldUserName.getText();
	}
	
	public String getPassword() {
		return textFieldPassword.getText();
	}
	
	public void setStatus(String message) {
		labelStatus.setText(message);
	}
	
	public void resetView(){
		labelStatus.setText("");
		textFieldPassword.setText("");
		textFieldUserName.setText("");
	}
}