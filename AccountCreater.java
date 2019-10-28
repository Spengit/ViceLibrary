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
	public static String makeString(String s) {
		StringBuilder ab = new StringBuilder();
		for(int i = 0; i < 5; ++i) {
			ab.append(Alphabet.charAt(r.nextInt(s.length())));
		}
		return ab.toString();
	}
	public static void fill(int param) {
		for (int i = 0; i < param; ++i) {
			if(i%2 == 0)
			Users.addUser(new Teacher(makeString(Alphabet),makeString(Alphabet),
					makeString(Alphabet),makeString(Alphabet),makeString(Alphabet)));
			Users.addUser(new PersonalUser(makeString(Alphabet),makeString(Alphabet),
					makeString(Alphabet),makeString(Alphabet),makeString(Alphabet)));
		}
	}
	public static void printUsers() {
		Users.printUsers();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creating accounts test: ");
		fill(10);
		System.out.println("Your users are: \n");
		printUsers();
		

	}

}
