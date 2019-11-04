import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Abstract media class from which to build books, movies, etc.
 * Contains variables for the attributes shared by all media.
 * Other media types can add additional attributes as needed.
 * 
 * @author Matt Kemp
 * @version 1.2
 */
public abstract class Media {
  private long ID;
  private String title;
  private String pubYear;
  private double price;
  private String condition;
  private boolean isCheckedOut;
  private int numCopies;
  private HashMap<String, Double> ratings;
	
  public Media(String title, String pubYear, double price, String condition,
      List<Media> allMedia) {
        /**
		 * Check if this title already exists, if it does do not create a new instance,
		 * just iterate number of copies
		 */
		for (Media m : allMedia) {
			if (m.getTitle().equals(title)) {
				m.addCopy();
				return;
			}
		}
		this.numCopies = 1;
		this.title= title;
		this.pubYear = pubYear;
		this.price = price;
		this.condition = condition;
		this.ratings = new HashMap<String, Double>();
		/*
		 * check if this is the first item to be added to the list
		 * if not, set to next available ID
		 */
		if(allMedia.isEmpty()) {
			this.ID = 1;
		} else {
			this.ID = allMedia.get(allMedia.size() - 1).getId() + 1;
		}
		allMedia.add(this);
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
		return true;
	}
	public int getNumCopies() {
		return this.numCopies;
	}
	public void addCopy() {
		this.numCopies += 1;
	}
	/**
	 * Adds (or adjusts) a rating for this title. Keeps only the most recent
	 * rating per user who rates it.
	 * 
	 * @param username The user who is rating the title
	 * @param rating Their rating, 0-10
	 * @return false if the rating is invalid, true otherwise
	 */
	public boolean rateMedia(String username, double rating) {
	  if (rating < 0.0 || rating > 10.0)
	    return false;
	  ratings.put(username, rating);
	  return true;
	}
	/**
	 * Averages the ratings for the current title.
	 * @return -1.0 if there are no ratings yet, otherwise return average
	 * of all ratings, formatted to one decimal place.
	 */
	public double getRating() {
	  if(this.ratings.isEmpty())
	    return -1.0;
	  double total = 0.0;
	  for (Map.Entry<String, Double> m : this.ratings.entrySet()) {
	    total += m.getValue();
	  }
	  DecimalFormat df = new DecimalFormat("0.0");
	  String result = df.format(total / this.ratings.size());
	  return Double.parseDouble(result);	}
}