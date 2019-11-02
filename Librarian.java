
public class Librarian extends User implements AdminPermissions{

	public Librarian(String name, String lastName, String address,
			String email, String phoneNumber, double fines) {
		super(name, lastName, address, email, phoneNumber, fines);
		
	}
	
	public String toString() {
		return super.toString() + "Account type : Libaraian";
	}

	@Override
	public void flagUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkoutBook() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkoutLimit() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public void addBook() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBook() {
		// TODO Auto-generated method stub
		
	}

}
