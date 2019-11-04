
public class Child extends User implements UserPermissions{
	

	public Child(String name, String lastName, String address, 
			String email, String phoneNumber, double fines) {
		super(name, lastName, address, email, phoneNumber, fines);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public int checkoutLimit() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public void rateMedia() {
		// TODO Auto-generated method stub
		
	}

}
