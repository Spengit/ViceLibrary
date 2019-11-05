import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DVD extends Media
{
	/*
	 * Dook object based on Media.
	 * Contains variables based on Director, media found on the DVD, actors, studio, and genre.
	 * Edited by Jay-Rads Villanueva
	 * Ver 1.0, based on Media ver 1.4
	 */
	 private String type;
	  private long ID;
	  private String title;
	  private String pubYear;
	  private double price;
	  private String condition;
	  private boolean isNewRelease;
	  private int numCopies;
	  private int numAvailable;
	  private HashMap<String, Double> ratings;
	  private ArrayList<String> waitList;
	  //Exclusive to DVD
	  private String director;
	  private String contains;
	  private String actors;
	  private String studio;
	  private String genre; //exclusive to Book and DVD
	  
	  public DVD(String type, String title, String pubYear, double price, String condition,
      boolean isNewRelease, String director, String contains, String actors, String studio, String genre)
	  {
		  super(type, title, pubYear, price, condition, isNewRelease);
		  this.director=director;
		  this.contains=contains;
		  this.actors=actors;
		  this.studio=studio;
		  this.genre=genre;
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
		  return Double.parseDouble(result);	}
		public String getDirector()
		{
			return this.director;
		}
		public String getContains()
		{
			return this.contains;
		}
		public String getActors()
		{
			return this.actors;
		}
		public String getStudio()
		{
			return this.studio;
		}
		public String getGenre()
		{
			return this.genre;
		}
}
