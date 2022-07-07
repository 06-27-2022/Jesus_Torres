/*
 * This is a limited test for accepting and storing user inputs until 
 * I have access to databases to create an actual log in program. 
 */
import java.util.Scanner;

public class userprofiles {

	/**
	 * User name for log in
	 */
	protected String user_name;
	/**
	 * User password for log in
	 */
	private String password;
	/**
	 * User type is either "Employee" or "Manager". 
	 * It defaults to "Employee"
	 */
	public String user_type = "Employee";
	
	/*
	 * Constructor to create new user profiles.
	 */
	private userprofiles(String user_name,String password){
		this.user_name = user_name;
		this.password = password;
	}
	/*
	 * Assuming passwords are meant to be functional we will be checking 
	 * if passwords match records. Since this might be called multiple 
	 * times through flow control to account for user error it is probably
	 * best to use a method.
	 */
	boolean password_chck(String password_input) {
		return this.password==password_input;
	}
	/*
	 * Inside this main method we will test program parts with 
	 * arrays and other available objects until we gain access to 
	 * databases.
	 */
	public static void main(String[] args) {
		/*
		 * Some test profiles combined using the top 4 most common 
		 * passwords of 2022.
		 */
		userprofiles user01 = new userprofiles("Hey", "qwerty");
		userprofiles user02 = new userprofiles("Dude12", "password");
		userprofiles user03 = new userprofiles("HowR", "12345");
		userprofiles user04 = new userprofiles("You?", "qwerty123");
		/*
		 * An array of user_names to simulate having things in an database
		 * with space for additional testing the creation of additional
		 * user profiles.
		 */
		String user_list[] = {user01.user_name, user02.user_name,user03.user_name ,user04.user_name, "", "", ""};
		
	}
}
