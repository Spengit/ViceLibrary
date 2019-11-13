
public class Book extends Media
{
	/*
	 * Book object based on Media.
	 * Contains Author, ISBN #, and Publisher variables.
	 * Edited by Jay-Rads Villanueva
	 * Ver 1.0
	 * Based on Media ver. 1.4
	 */
	  //Exclusive to Book
	  private String author;
	  public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	private String isbn;
	  private String publisher;

	  public Book(String type, String title, String pubYear, double price, String condition,
      boolean isNewRelease, String genre,String author, String isbn, String publisher)
	  {
		  super(type, title, pubYear, price, condition, isNewRelease, genre);
		  this.author=author;
		  this.isbn=isbn;
		  this.publisher=publisher;
	  }

}
