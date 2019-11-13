import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
}
