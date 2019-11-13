
/* 
 * Davis Edwards
 * 2019.10.30
 */
import java.util.Scanner;
public class UserLogin {
	Scanner scan = new Scanner(System.in);
	MediaLibrary m = MediaLibrary.getInstance();
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
					boolean done = false;
					while(done != true) {
						print("First Name:");
					 name = scan.nextLine();
					 print("Last Name: ");
					 String lastName = scan.nextLine();
					 print("Address: ");
					 String adr = scan.nextLine();
					 print("Email: ");
					 String email = scan.nextLine();
					 print("Phone Number: ");
					 String phone = scan.nextLine();
					 //print("Are You a teacher? Yes or no");
					 PersonalUser pu = new PersonalUser(
							 name, lastName,adr,email,phone,0);
					 print("Welcome to the library "+ 
							 pu.getFirstName()+ "!");
					 done = true;
					
					
					}
					break;
			case 3:	a = 3;
					//print("That feature is coming");
					print("Enter the title: ");
					String nme = scan.nextLine();
					System.out.println(m.searchMedia(nme));
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
