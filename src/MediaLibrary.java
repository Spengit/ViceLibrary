import java.util.ArrayList;
/*
 * Singleton class which holds the library's media library
 * 
 * @author Matt Kemp
 * @version 1.0
 */
public class MediaLibrary {
	private static MediaLibrary ml;
	private static ArrayList<Media> mediaLibrary;

	private MediaLibrary() {
		mediaLibrary = new ArrayList<Media>();
	}
	public static MediaLibrary getInstance() {
		if (ml == null) {
			return new MediaLibrary();
		} else {
			return ml;
		}
	}
	
	/**
	 * Add a new Media to the library.
	 * @param type The type of Media (book, movie, etc.)
	 * @param title The title of the Media
	 * @return True if the library has a copy already and no
	 * further info is needed. False if no copy is in the
	 * system and we need all of the Media's info
	 */
	public boolean addCopy(String type, String title) {
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
	/**
	 * Adds a new Media to the library. The addCopy method should be used
	 * first to ensure duplicate entries are not made.
	 * @param m the Media object to be added
	 */
	public void addNewMedia(Media m) {
		if (mediaLibrary.isEmpty())
			m.setId(1);
		else
			m.setId(mediaLibrary.get(mediaLibrary.size()-1).getId() + 1);
		mediaLibrary.add(m);
	}
	public void printMedia() {
		for(Media m : mediaLibrary) {
			System.out.println(m.toString());
		}
	}
	
	/**
	 * Removes a copy of a Media from the library.
	 * @param type Book, magazine, etc.
	 * @param title Title of the media to be removed
	 * @return true if successful, false if the media type and
	 * 			title does not match any items in the library.
	 */
	public boolean removeCopy(String type, String title) {

		for (Media m : mediaLibrary) {
			if (m.getTitle().equals(title) && m.getType().equals(type)) {
				m.checkoutMedia();
				return true;
			}
		}
		return false;
	}
}
