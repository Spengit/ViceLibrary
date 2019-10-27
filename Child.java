
public class Child extends User implements UserPermissions{

	public Child(String name, String lastName, String address, String email, String phoneNumber) {
		super(name, lastName, address, email, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int checkoutLimit() {
		// TODO Auto-generated method stub
		return 3;
	}

}
