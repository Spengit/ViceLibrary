package library;
/* 
 * Davis Edwards
 * 2019.10.30
 */
import java.util.Scanner;
public class UserLogin {
	Scanner scan = new Scanner(System.in);
	public void login(int a) {
		switch(a) {
			case 1:	a = 1;
					print("Username:");
					String name = scan.next();
					print("Password:");
					String pass = scan.next();
					//consider hashing the password
					//login(name, pass);
					break;
			case 2:	a = 2;
					print("That feature is coming");
					//createAccount();
					break;
			case 3:	a = 3;
					print("That feature is coming");
					//search();
					break;
			default:print("Invalid option\nTry again");
					login(scan.nextInt());
					break;
		}
	}
	public static void print(String s) {
		System.out.println(s);
	}
}
