
public class Child extends User {

	public Child(String name, String lastName, String address, 
			String email, String phoneNumber, double fines) {
		super(name, lastName, address, email, phoneNumber, fines);
		// TODO Auto-generated constructor stub
	}
	private static final int MAX_CHECKOUT = 3;


	public int checkoutLimit() {
		// TODO Auto-generated method stub
		return MAX_CHECKOUT;
	}


	@Override
	public void checkout(Media m) {
		// TODO Auto-generated method stub
		m.checkoutMedia();
		this.getItems().add(m);
	}



	public void rateMedia(Media m, double rating) {
		// TODO Auto-generated method stub
		
	}
	
	public double payFine(double fine) {
		return super.payFine(fine);
	}



}
