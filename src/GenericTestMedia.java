import java.util.List;

public class GenericTestMedia extends Media {
  private String otherAttribute;
  
  public GenericTestMedia(String other, String title, String pubYear, double price, String condition,
      List<Media> allMedia) {
    super(title, pubYear, price, condition, allMedia);
    this.otherAttribute = other;
  }
}
