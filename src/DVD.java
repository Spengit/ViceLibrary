
public class DVD extends Media
{
	/*
	 * Dook object based on Media.
	 * Contains variables based on Director, media found on the DVD, actors, studio, and genre.
	 * Edited by Jay-Rads Villanueva
	 * Ver 1.0, based on Media ver 1.4
	 */
	  //Exclusive to DVD
	  private String director;
	  public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getContains() {
		return contains;
	}

	public void setContains(String contains) {
		this.contains = contains;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	private String contains;
	  private String actors;
	  private String studio;
	  
	  public DVD(String type, String title, String pubYear, double price, String condition,
      boolean isNewRelease, String director, String contains, String actors, String studio, String genre)
	  {
		  super(type, title, pubYear, price, condition, isNewRelease, genre);
		  this.director=director;
		  this.contains=contains;
		  this.actors=actors;
		  this.studio=studio;
	  }
}
