
/* 
 * Davis Edwards
 * 2019.11.13
 */
import java.util.Scanner;
import java.util.ArrayList;
public class UserLogin {
	Scanner scan = new Scanner(System.in);
	MediaLibrary m = MediaLibrary.getInstance();
	public static User curr;
	public void login(int a) {
		UserLoader.loadUsers();
		MediaLoader.loadMedia();
		switch(a) {
			case 1:	a = 1;
					print("Enter Username:");
					String name = scan.next();
					
					if(Users.findUser(name)!= null) {
					 curr = Users.findUser(name);
						print("Enter Password:");
						String pass = scan.next();
						if(curr.getPassword().equals(pass)) {
							print("Welcome back  " + curr.getFirstname());
							loggedIn(curr.getUserName());
						}
					}
					
					
					break;
			case 2:	a = 2;
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
					 print("Are You a teacher? Yes or no");
					 String teach = scan.nextLine();
					 if(teach.equalsIgnoreCase("yes")) {
						 Teacher t = new Teacher(name, 
								 lastName, adr, email, phone, 0);
						 print("Welcome to the library " +
								 t.getFirstname());
						 print("Please set a userName and password:");
						 print("Username:");
						 name = scan.nextLine();
						 t.setUserName(name);
						 print("Password: ");
						 String pass = scan.nextLine();
						 t.setPassword(pass);
						 print("Switching to log in screen");
						 Users.addUser(t);
						 done = true;
					
					 }
					 else {
					 PersonalUser pu = new PersonalUser(
							 name, lastName,adr,email,phone,0);
					 print("Welcome to the library "+ 
							 pu.getFirstName()+ "!");
					 print("Please set a userName and password:");
					 print("Username:");
					 name = scan.nextLine();
					 pu.setUserName(name);
					 print("Password: ");
					 String pass = scan.nextLine();
					 pu.setPassword(pass);
					 print("Switching to log in screen");
					 Users.addUser(pu);
					 done = true;
					 
					 }
					 login(1);
					
					}
					break;
			case 3:	a = 3;
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
	public void loggedIn(String user) {
		print("Would you like to \na: Search/Checkout"
				+ "\nb: pay a fine"
				+ "\nc: return an item"
				+ "\nd: Log Out");
		if(curr.getType().equalsIgnoreCase("L")) {
			print("\ne Add an item"
					+ "\nf Remove an item"
					+ "\ng Flag a User");
		}
	@SuppressWarnings("resource")
	Scanner read = new Scanner(System.in);
	
		String logg = read.nextLine();
		switch(logg) {
		case "a" :
			print("What would you like to checkout?");
			String check = read.nextLine();
			ArrayList<Media> mediaSearch = m.searchMedia(check);
			print("What would you like to check out? ");
			for(int i = 0; i < mediaSearch.size(); ++i) {
				System.out.println( (i+1) + " "+ mediaSearch.get(i).toString());
			}
			
			Scanner checkChoice = new Scanner(System.in);
			int choice = checkChoice.nextInt();
				if(curr.getFines() != 0) {
					System.out.println("Sorry you have a fine balance of " + curr.getFines());
					print("Pay the fines? : ");
					String fines = read.nextLine();
					if(fines.equalsIgnoreCase("yes")) {
						curr.payFine(curr.getFines());
						curr.checkout(mediaSearch.get(choice));
						System.out.println("You have checked out " + 
						mediaSearch.get(choice).toString());
					}
				}
			curr.checkout(mediaSearch.get(choice-1));
			System.out.println("You have checked out " + 
					mediaSearch.get(choice-1).toString());
			loggedIn(curr.getUserName());
			
			break;
		case "b" :
			System.out.println("Your fine balance is " + curr.getFines());
			curr.payFine(curr.getFines());
			print("Your balance is now paid\n");
			loggedIn(curr.getUserName());
			break;
		case "c":
			ArrayList<Media> items = curr.getItems();
			if(items== null) {
				print("You have no items to return\n");
				loggedIn(curr.getUserName());
			}
			for(int i =0; i < items.size(); ++i) {
				System.out.println(items.get(i).getTitle());
			}
			print("What would you like to return?");
			for(int i = 0; i < items.size(); ++i) {
				print("Are you returning ");
				System.out.println(items.get(i).toString() + " yes or no");
				String itemList = read.nextLine();
				if(itemList.equalsIgnoreCase("yes")) {
					print("Would you like to rate it? ");
					String rate = read.nextLine();
					if(rate.equalsIgnoreCase("yes")) {
						print("What is your rating?");
						double rating = read.nextDouble();
						curr.rateMedia(items.get(i), rating);
					}
					curr.returnMedia(items.get(i));
					
				}
			}
			print("You have no items to return");
			loggedIn(curr.getUserName());
			break;
		case "d" :
			print("\nBye");
			UserInterface.start();
			break;
		case "e":
			print("Enter the item title");
			String title = read.nextLine();
			print("what type of media is it");
			String media = read.nextLine();
			m.addCopy(media, title);
			loggedIn(curr.getUserName());
			break;
		case "f":
			print("Enter the item title");
			String rtitle = read.nextLine();
			print("what type of media is it");
			String rmedia = read.nextLine();
			m.removeCopy(rmedia, rtitle);
			loggedIn(curr.getUserName());
			break;
		default : 
			print("Invalid action");
			break;
		}
	}
	
}

