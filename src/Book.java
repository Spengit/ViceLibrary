import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Book extends Media
{
	/*
	 * Book object based on Media.
	 * Contains Author, ISBN #, and Publisher variables.
	 * Edited by Jay-Rads Villanueva
	 * Ver 1.0
	 * Based on Media ver. 1.4
	 */
	private String type;
	  //Exclusive to Book
	  private String author;
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
