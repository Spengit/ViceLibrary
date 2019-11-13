
public interface AdminPermissions {
public void flagUser(User u);
public void addFine(User u, double fine);
public void checkoutMedia(Media m);
public int checkoutLimit();
public void addMedia(Media m);
public void removeMedia(Media m);
}
