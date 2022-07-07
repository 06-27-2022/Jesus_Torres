/*
 * This is a limited test for accepting and storing user inputs until 
 * I have access to databases to create an actual log in program. 
 */
import java.util.Scanner;

public class userprofiles {

	/**
	 * User name for log in
	 */
	String user_name;
	/**
	 * User password for log in
	 */
	String password;
	/**
	 * User type is either "Employee" or "Manager". 
	 * It defaults to "Employee"
	 */
	String user_type = "Employee";
	
	/*
	 * Constructor to create new user profiles.
	 */
	userprofiles(String user_name,String password){
		this.user_name = user_name;
		this.password = password;
	}
	/*
	 * Assuming passwords are meant to be functional we will be checking 
	 * if passwords match records. Since this might be called multiple 
	 * times through flow control to account for user error it is probably
	 * best to use a method.
	 */
	
}
