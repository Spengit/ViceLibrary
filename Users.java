import java.util.ArrayList;
public class Users {
private static ArrayList<User> users;

public static void addUser(User u) {
	if (users == null) {
		users = new ArrayList<User>();
		users.add(u);
	}
	users.add(u);
}
public static void printUsers() {
	for(int i = 1; i < users.size(); i++) {
		System.out.println(users.get(i).toString());
		System.out.println();
	}
}
}
