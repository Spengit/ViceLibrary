import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Abstract media class from which to build books, movies, etc.
 * Contains variables for the attributes shared by all media.
 * Other media types can add additional attributes as needed.
 * 
 * @author Matt Kemp
 * @version 1.5
 */
public abstract class Media {
  private String type;
  private long ID;
  private String title;
  private String pubYear;
  private double price;
  private String condition;
  private boolean isNewRelease;
  private String genre;
  private int numCopies;
  private int numAvailable;
  private HashMap<String, Double> ratings;
  private ArrayList<String> waitList;
	
  public Media(String type, String title, String pubYear, double price, String condition,
      boolean isNewRelease, String genre) {

		this.numCopies = 1;
		this.numAvailable = 1;
		this.type = type;
		this.title= title;
		this.pubYear = pubYear;
		this.price = price;
		this.condition = condition;
		this.isNewRelease = isNewRelease;
		this.genre = genre;
		this.ratings = new HashMap<String, Double>();
		this.waitList = new ArrayList<String>();
	}
    public String getType() {
      return this.type;
    }
	public long getId() {
		return this.ID;
	}
	public void setId(long id) {
		this.ID = id;
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
	public boolean isNewRelease() {
	  return this.isNewRelease;
	}
	public int getNumCopies() {
		return this.numCopies;
	}
	public int getNumAvailable() {
	  return this.numAvailable;
	}
	public void setNumCopies(int n) {
		this.numCopies = n;
	}
	public void setNumAvailable(int n) {
	  	this.numAvailable = n;
	}
	public boolean checkoutMedia() {
	  if (this.numAvailable == 0)
	    return false;
	  this.numAvailable -= 1;
	  return true;
	}
	public void checkinMedia() {
	  this.numAvailable += 1;
	}
	public void addCopy() {
		this.numCopies += 1;
	}
	public void setNewRelease(boolean isNewRelease) {
	  this.isNewRelease = isNewRelease;
	}
	public int waitListSize() {
	  return this.waitList.size();
	}
	public boolean addToWaitList(String username) {
	  //Check that user is not already on the wait list
	  for (String s : this.waitList) {
	    if (s.equals(username))
	      return false;
	  }
	  //Add user to wait list
	  this.waitList.add(username);
	  return true;
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
	  return Double.parseDouble(result);
	}
	public String toString() {
		String s = "";
		s += this.getTitle() + " (" + this.getType() + "):" + this.getNumAvailable() +
		    " copies available  Rating: " + this.getRating();
		return s;
	}
	/**
	 * Check attributes of this instance against a specified search parameter
	 * @param search String to compare this instance's attributes
	 * @return true if the search parameter matches title, publication year, or genre
	 *         false otherwise
	 */
	public boolean search(String search) {
	  String searchUpper = search.toUpperCase();
	  if (this.title.toUpperCase().contains(searchUpper) ||
	      this.pubYear.contains(searchUpper) ||
	      this.genre.toUpperCase().contains(searchUpper)) {
	    return true;
	  }
	  return false;
	}
}