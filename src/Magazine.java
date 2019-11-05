import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Magazine extends Media
{
	/*
	 * Magazine object based on Media.
	 * Contains variables based on publishing schedule, volume # and issue #.
	 * 
	 * Edited by Jay-Rads Villanueva
	 * Ver 1.0
	 * Based on Media 1.4
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
	  private String genre;
	  //Exclusive to Magazine
	  private String schedule;
	  private int volume;
	  private int issue;
	  
	  public Magazine(String type, String title, String pubYear, double price, String condition,
      boolean isNewRelease, String genre, String schedule, int volume, int issue)
	  {
		  super(type, title, pubYear, price, condition, isNewRelease, genre);
		  this.schedule = schedule;
		  this.volume = volume;
		  this.issue = issue;
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
		public String getSchedule()
		{
			return this.schedule;
		}
		public int getVolume()
		{
			return this.volume;
		}
		public int getIssue()
		{
			return this.issue;
		}
}
