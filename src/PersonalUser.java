
public class PersonalUser extends User implements UserPermissions{

	public PersonalUser(String name, String lastName, 
			String address, String email, String phoneNumber, double fines) {
		super(name, lastName, address, email, phoneNumber, fines);
		// TODO Auto-generated constructor stub
	}
	private static final int MAX_CHECKOUT = 10;
	private static int checkoutCount;



	@Override
	public int checkoutLimit() {
		// TODO Auto-generated method stub
		if(this.isFlagged == true) {
			return 0;
		}
		return MAX_CHECKOUT;
	}
	
	public String toString() {
		return super.toString() + "\n Account Type: Personal";
	}

	
	public void checkout(Media m) {
		// TODO Auto-generated method stub
		
		checkoutCount = getCheckouts() + 1;
	
	
	}

	@Override
	public void rateMedia(Media m) {
		// TODO Auto-generated method stub
		
	}


	
	public static int getCheckouts() {
		return checkoutCount;
	}

	@Override
	public void checkout() {
		// TODO Auto-generated method stub
		
	}
	public double payFine(double fine) {
		return super.payFine(fine);
	}





}
