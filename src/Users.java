import java.util.ArrayList;
public class Users {
private static ArrayList<User> users;

public static void addUser(User u) {
	if (users == null) {
		users = new ArrayList<User>();
		users.add(u);
	}
	users.add(u);
	u.setId(users.size());
}
public static void printUsers() {
	for(int i = 1; i < users.size(); i++) {
		System.out.println(users.get(i).toString());
		System.out.println();
	}
}

public static void removeUser(String name) {

	for(int i = 0; i < users.size(); ++i) {
		if (users.get(i).getFirstName() == name) {
			users.remove(i);
		}
		else {
			System.out.println("User not found ");
		}
	}
}

public static void removeUser(int index) {

	users.remove(index);
}

public static User findUser(User u) {
	for(int i = 0; i < users.size(); ++i) {
		if(users.get(i) == u) {
			return users.get(i);
		}
	}
	return null;

}

}
