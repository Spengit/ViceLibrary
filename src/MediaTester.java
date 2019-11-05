import java.util.ArrayList;

public class MediaTester {
  public static void main(String[] args) {
    MediaLibrary ml = MediaLibrary.getInstance();
    
    if(ml.addCopy("Book", "Book One"))
    	System.out.println("Found other copies of that item. Total number of copies updated.");
    else {
    	Media test = new GenericTestMedia("Other", "Book", "Book One", "1984", 0.0, "Good", false, "Horror");
    	ml.addNewMedia(test);
    	System.out.println("New book added.");
    }
    ml.printMedia();
    
    if(ml.addCopy("Book", "Book One"))
    	System.out.println("Found other copies of that item. Total number of copies updated.");
    else {
    	Media test = new GenericTestMedia("Other", "Book", "Book One", "1984", 0.0, "Good", false, "Horror");
    	ml.addNewMedia(test);
    	System.out.println("New book added.");
    }
    ml.printMedia();
    
    if(ml.addCopy("Book", "Book Two"))
    	System.out.println("Found other copies of that item. Total number of copies updated.");
    else {
    	Media test = new GenericTestMedia("Other", "Book", "Book Two", "1999", 0.0, "Good", false, "Sci-Fi");
    	ml.addNewMedia(test);
    	System.out.println("New book added.");
    }
    ml.printMedia();
      
    
  }
  
  
}
