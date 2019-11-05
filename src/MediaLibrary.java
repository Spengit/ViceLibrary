import java.util.ArrayList;
/*
 * Singleton class which holds the library's media library
 * 
 * @author Matt Kemp
 * @version 1.0
 */
public class MediaLibrary {
	private static ArrayList<Media> mediaLibrary;

	/**
	 * Add a new Media to the library.
	 * @param type The type of Media (book, movie, etc.)
	 * @param title The title of the Media
	 * @return True if the library has a copy already and no
	 * further info is needed. False if no copy is in the
	 * system and we need all of the Media's info
	 */
	public static boolean addCopy(String type, String title) {
		if (mediaLibrary == null) {
			mediaLibrary = new ArrayList<Media>();
		}
		for (Media m : mediaLibrary) {
			if (m.getTitle().equals(title) && m.getType().equals(type)) {
				m.addCopy();
				m.checkinMedia(); //increase # available
				return true;
			}
		}
		return false;
	}
	public static void addNewMedia(Media m) {
		if (mediaLibrary.isEmpty())
			m.setId(1);
		else
			m.setId(mediaLibrary.get(mediaLibrary.size()-1).getId() + 1);
		mediaLibrary.add(m);
	}
	public static void printMedia() {
		for(int i = 1; i < mediaLibrary.size(); i++) {
			System.out.println(mediaLibrary.get(i).toString());
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
}
