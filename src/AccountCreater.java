/**
 * 
 * Test Case : Account creation
 *
 */
import java.util.Random;
public class AccountCreater {
	public static final String Alphabet = "aAbBcCdDeEfFgGhHiIjJkKl"
			+ "LmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
	static Random r = new Random();
	public static String makeString(String s) { // Strings for testing creation
		StringBuilder ab = new StringBuilder();
		for(int i = 0; i < 5; ++i) {
			ab.append(Alphabet.charAt(r.nextInt(s.length())));
		}
		return ab.toString();
	}
	
	public static void printUsers() {
		Users.printUsers();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserLoader.loadUsers();
		printUsers();
		//Users.removeUser(2);
		System.out.println();
		printUsers();
		
		

	}

}
