import java.util.List;

/*
 * Abstract media class from which to build books, movies, etc.
 * Contains variables for the attributes shared by all media.
 * Other media types can add additional attributes as needed.
 * 
 * @author Matt Kemp
 * @version 1.1
 */
public abstract class Media {
	private long ID;
	private String title;
	private String pubYear;
	private double price;
	private String condition;
	private boolean isCheckedOut;
	//private int numCopies;
	//private static HashMap<String, Integer> ratings = new HashMap<String, Integer>();
	
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
	public String getTitle() {
		return this.title;
	}
	public String getPubYear() { 
		return this.pubYear;
	}
	public double getPrice() {
		return this.price;
	}
	public String getCondition() {
		return this.condition;
	}
  private boolean isNewRelease() {
    //TODO determine new release
  }
}