import java.util.List;

public class GenericTestMedia extends Media {
  private String otherAttribute;
  
  public GenericTestMedia(String other, String type, String title, String pubYear, double price,
      String condition, boolean isNewRelease, List<Media> allMedia) {
    super(type, title, pubYear, price, condition, false, allMedia);
    this.otherAttribute = other;
  }
}
