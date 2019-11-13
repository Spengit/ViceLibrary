/*
 * Davis Edwards
 * 2019.11.13
 */
import java.util.Scanner;
public class UserInterface {
	public static void main(String[] args) {
		UserLoader.loadUsers();
		 User test = Users.getUser(1);
		 test.setUserName("Test");
		 test.setPassword("Test");
		 start();
	}
	public static void print(String s) {
		System.out.println(s);
	}
	public static void start() {
		UserLogin user = new UserLogin();
		
		print("Welcome to the library. What would you like to do?");
		print("1 Login");
		print("2 Create Account");
		print("3 Search");

		Scanner scan = new Scanner(System.in);
		String ans = scan.next();
		try {
			int a = Integer.valueOf(ans);
			user.login(a);
		} catch (NumberFormatException nfe) {
			print("Invalid input" + nfe.getMessage());
			start();
		}
	}
}
