
public class PersonalUser extends User {

	public PersonalUser(String name, String lastName, 
			String address, String email, String phoneNumber, double fines) {
		super(name, lastName, address, email, phoneNumber, fines);
		// TODO Auto-generated constructor stub
	}
	private static final int MAX_CHECKOUT = 10;
	private static int checkoutCount;
	private String type;




	public String getType() {
		return type;
	}

	public void setType() {
		this.type = "P";
	}

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


	public void rateMedia(Media m, double rating) {
		// TODO Auto-generated method stub
		m.rateMedia(this.getUserName(), rating);
	}


	
	public static int getCheckouts() {
		return checkoutCount;
	}

	
	public double payFine(double fine) {
		return super.payFine(fine);
	}





}
