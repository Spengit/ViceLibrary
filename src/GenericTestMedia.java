import java.util.List;

public class GenericTestMedia extends Media {
  private String otherAttribute;
  
  public GenericTestMedia(String other, String type, String title, String pubYear, double price,
      String condition, boolean isNewRelease, String genre) {
    super(type, title, pubYear, price, condition, false, genre);
    this.otherAttribute = other;
  }
}
