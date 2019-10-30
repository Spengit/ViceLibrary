import java.util.List;

/*
 * Abstract media class from which to build books, movies, etc.
 * Contains variables for the attributes shared by all media.
 * Other media types can add additional attributes as needed.
 * 
 * @author Matt Kemp
 * @version 1.0
 */
public abstract class Media {
	private long ID;
	private String title;
	private String pubYear;
	private double price;
	private String condition;
	
	public Media(String title, String pubYear, double price, String condition,
			List<Media> allMedia) {
		this.= title;
		this.pubYear = pubYear;
		this.price = price;
		this.condition = condition;
		/*
		 * check if this is the first item to be added to the list
		 * if not, set to next available ID
		 */
		if(allMedia.isEmpty()) {
			this.ID = 1;
		} else {
			this.ID = allMedia.get(allMedia.size() - 1).getId() + 1;
		}
	}
	public long getId() {
		return this.ID;
	}
}