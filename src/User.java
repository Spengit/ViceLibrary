import java.util.ArrayList;
public abstract class User implements UserActions {
	// Account Information Requirement
private int id;
private String Firstname;
private String lastName;
private double fines;
private String userName;
private String password;
private ArrayList<Media> items;
public ArrayList<Media> getItems() {
	return items;
}
public String getFirstname() {
	return Firstname;
}
public void setFirstname(String firstname) {
	Firstname = firstname;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstName() {
	return Firstname;
}
public void setFirstName(String name) {
	this.Firstname = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
private String address;
private String email;
private String phoneNumber;
protected boolean isFlagged;
	public User(String name, String lastName,String address,
			String email, String phoneNumber, double fines) {
		this.Firstname = name;
		this.setLastName(lastName);
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.setFines(fines);
		this.isFlagged = false;
		items = new ArrayList<Media>();
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void checkout(Media m) {
		// TODO Auto-generated method stub
		m.checkoutMedia();
		items.add(m);
	}
	@Override
	public void returnMedia(Media m) {
		// TODO Auto-generated method stub
		m.checkinMedia();
		items.remove(m);
	}
	public double payFine(double fine) {
		// TODO Auto-generated method stub
		//going to assume that the user has the option to pay a partial fine
		double newBal = this.getFines() - fine;
		if(this.getFines() - fine < 0) {
			double change  = newBal*-1;
			this.setFines(0);
			return change;
			
	
		}
		this.setFines(this.getFines() - fines);
		return 0.0;
	}
	@Override
	public void deleteAccount() {
		Users.removeUser(this.getFirstName());
		
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String toString() {
		return "First Name: " + this.Firstname + " Last Name: " + this.lastName;
	}
	public double getFines() {
		return fines;
	}
	public void setFines(double fines) {
		this.fines = fines;
	}
	public void rateMedia(Media m, double rating) {
		// TODO Auto-generated method stub
		m.rateMedia(this.getUserName(), rating);
	}
}
