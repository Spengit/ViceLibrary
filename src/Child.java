
public class Child extends User implements UserPermissions{

	public Child(String name, String lastName, String address, 
			String email, String phoneNumber, double fines) {
		super(name, lastName, address, email, phoneNumber, fines);
		// TODO Auto-generated constructor stub
	}
	private static final int MAX_CHECKOUT = 3;

	@Override
	public int checkoutLimit() {
		// TODO Auto-generated method stub
		return MAX_CHECKOUT;
	}


	@Override
	public void checkout() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void rateMedia(Media m) {
		// TODO Auto-generated method stub
		
	}
	
	public double payFine(double fine) {
		return super.payFine(fine);
	}



}
