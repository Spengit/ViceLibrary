
public class Teacher extends User {

	public Teacher(String name, String lastName,
			String address, String email, String phoneNumber, double fines) {
		super(name, lastName, address, email, phoneNumber, fines);
		// TODO Auto-generated constructor stub
		
	}
	private static final int MAX_CHECKOUT = 50;
	private static int checkouts;


	public int checkoutLimit() {
		// TODO Auto-generated method stub
		return MAX_CHECKOUT;
	}
	
	public String toString() {
		return super.toString() + "\nAccount Type: Teacher ";
	}

	@Override
	public void checkout(Media m) {
		// TODO Auto-generated method stub
		m.checkoutMedia();
		checkouts+=1;
	}

	public static int getCheckouts() {
		return checkouts;
	}

	
	public void rateMedia(Media m, double rating) {
		// TODO Auto-generated method stub
		
	}
	public double payFine(double fine) {
		return super.payFine(fine);
	}




}
