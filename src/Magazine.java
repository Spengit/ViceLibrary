

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

	  //Exclusive to Magazine
	  private String schedule;
	  public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getIssue() {
		return issue;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}

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
