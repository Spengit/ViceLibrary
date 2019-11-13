import java.util.ArrayList;

import javax.print.attribute.standard.Media;
public abstract class User implements UserActions {
	// Account Information Requirement
private int id;
private String Firstname;
private String lastName;
private double fines;
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
		
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void checkout(Media m) {
		// TODO Auto-generated method stub
		

	}
	@Override
	public void returnMedia() {
		// TODO Auto-generated method stub
		
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
	public void rateMedia(Media m) {
		// TODO Auto-generated method stub
		
	}
}
