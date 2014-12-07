package logik;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.CreateCalendar;
import model.Login;
import model.Appointments;
import model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Manager {

	
	public static User Login(String username, String password) throws Exception{
		Gson gson = new GsonBuilder().create();
		Login login = new Login();
		User user;
		
		// Krypter password før det sendes over netværk.
		String encryptedPassword = AesEncryption.encrypt(password);	
		
		login.setAuthUserPassword(encryptedPassword);
		login.setAuthUserEmail(username);

		String gsonString = gson.toJson(login);
		String result = GetJsonFromServer(gsonString);

		user = (User)gson.fromJson(result, User.class);
		if(user.isError())
		{
			throw new Exception(user.getErrorMessage());		
		}

		return user;
	}
	

	private static String GetJsonFromServer(String jsonInput){
	
		String result = "Error";
		try {
			Socket clientSocket = new Socket("localhost", 8888);
			DataOutputStream outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			byte[] input = jsonInput.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);

			System.out.println(encrypted);
			outToServer.write(encrypted);
			outToServer.flush();
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			result = inFromServer.readLine();
			clientSocket.close();
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}
	
	
	public static CreateEvent Appointment(String titel, String note, String startDate, String endDate, String location, String userName) {
		Gson gson = new GsonBuilder().create();
		//Appointment[] appointments = new Appointment[1];
	//	Appointment appointment = new Appointment();
	//	appointments[0] = appointment;
	
		
		
		Gson gsons = new GsonBuilder().create();
		Appointment appointment = new Appointment();
		//User user;
		CreateCalendar calendarDate;
		
		appointment.setTitle(titel);
		appointment.setNote(note);
		appointment.setStartDate(startDate);
		appointment.setEndDate(endDate);
		appointment.setLocation(location);
		appointment.setEmail(userName);
		
		String gsonString = gsons.toJson(appointment);
		String result = GetCalendar(gsonString);
		


		calendarDate = (CreateCalendar)gsons.fromJson(result, CreateCalendar.class);
		
		
		return calendarDate;
	}	
	
	private static String GetCalendar(String jsonInput){
		
		String result = "Error";
		try {
			Socket clientSocket = new Socket("localhost", 8888);
			DataOutputStream outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			byte[] input = jsonInput.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);

			System.out.println(encrypted);
			outToServer.write(encrypted);
			outToServer.flush();
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			result = inFromServer.readLine();
			clientSocket.close();
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	} 
}