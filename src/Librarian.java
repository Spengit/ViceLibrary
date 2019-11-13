
public class Librarian extends User implements AdminPermissions{

	public Librarian(String name, String lastName, String address,
			String email, String phoneNumber, double fines) {
		super(name, lastName, address, email, phoneNumber, fines);
		
	}
	private static final int MAX_CHECKOUT = 10;
	
	public String toString() {
		return super.toString() + "Account type : Libaraian";
	}

	@Override
	public void flagUser(User u) {
		u.isFlagged = true;
		
	}

	@Override
	public void addFine(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkoutMedia(Media m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkoutLimit() {
		// TODO Auto-generated method stub
		return MAX_CHECKOUT;
	}

	@Override
	public void addMedia(Media m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMedia(Media m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkout() {
		// TODO Auto-generated method stub
		
	}
	
	public double payFine (double fine) {
		 return super.payFine(fine);
	}

}
