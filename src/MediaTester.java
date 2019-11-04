import java.util.ArrayList;

public class MediaTester {
  public static void main(String[] args) {
    ArrayList<Media> allMedia = new ArrayList<Media>();
    Media test = new GenericTestMedia("Other", "Test Title", "1984", 0.0, "Good", allMedia);
    Media test2 = new GenericTestMedia("Other", "Test Title", "1984", 0.0, "Good", allMedia);
    
    for (Media m : allMedia) {
      System.out.println(m.getTitle() + ": " + m.getNumCopies() + " copies");
      m.rateMedia("Matt", 8.0);
      m.rateMedia("Bob", 4.0);
      System.out.println("Rating: " + m.getRating());
      m.rateMedia("Matt", 10.0);
      m.rateMedia("Bob", 10.0);
      System.out.println("Rating: " + m.getRating());
      m.rateMedia("Dave", 2.3);
      System.out.println("Rating: " + m.getRating());
    }
    
    
  }
  
  
}
