
public class PersonalUser extends User implements UserPermissions{

	public PersonalUser(String name, String lastName, 
			String address, String email, String phoneNumber, double fines) {
		super(name, lastName, address, email, phoneNumber, fines);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int checkoutLimit() {
		// TODO Auto-generated method stub
		return 10;
	}
	
	public String toString() {
		return super.toString() + "\n Account Type: Personal";
	}

	@Override
	public void rateMedia() {
		// TODO Auto-generated method stub
		
	}

}
