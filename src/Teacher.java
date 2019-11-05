
public class Teacher extends User implements UserPermissions{

	public Teacher(String name, String lastName,
			String address, String email, String phoneNumber, double fines) {
		super(name, lastName, address, email, phoneNumber, fines);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int checkoutLimit() {
		// TODO Auto-generated method stub
		return 50;
	}
	
	public String toString() {
		return super.toString() + "\nAccount Type: Teacher ";
	}

	@Override
	public void checkout() {
		// TODO Auto-generated method stub
		
	}



}
