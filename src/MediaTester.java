import java.util.ArrayList;

public class MediaTester {
  public static void main(String[] args) {
    ArrayList<Media> allMedia = new ArrayList<Media>();
    Media test = new GenericTestMedia("Other", "Book", "Test Title", "1984", 0.0, "Good", false, allMedia);
    Media test2 = new GenericTestMedia("Other", "Book", "Test Title", "1984", 0.0, "Good", false, allMedia);
    
    for (Media m : allMedia) {
      // test adding new copy and ratings
      System.out.println(m.getTitle() + ": " + m.getNumCopies() + " copies");
      m.rateMedia("Matt", 8.0);
      m.rateMedia("Bob", 4.0);
      System.out.println("Rating: " + m.getRating());
      m.rateMedia("Matt", 10.0);
      m.rateMedia("Bob", 10.0);
      System.out.println("Rating: " + m.getRating());
      m.rateMedia("Dave", 2.3);
      System.out.println("Rating: " + m.getRating() + "\n");
      
      //test checkout and wait list
      m.checkoutMedia();
      m.checkoutMedia();
      if (m.checkoutMedia())
    	  System.out.println("Checked out " + m.getTitle() + ".");
      else
    	  System.out.println("No copies available. There are " + m.waitListSize() + " people on the "
    	  		+ "wait list. Join wait list?");
      System.out.println(m.getNumAvailable() + " copies available");
      if (m.addToWaitList("Matt"))
        System.out.println("Added Matt to wait list for " + m.getTitle() + ".");
      else
        System.out.println("Matt is already on the wait list for " + m.getTitle() + ".");
      
      if (m.addToWaitList("Matt"))
        System.out.println("Added Matt to wait list for " + m.getTitle() + ".");
      else
        System.out.println("Matt is already on the wait list for " + m.getTitle() + ".");
    }
    
    
  }
  
  
}
