
public abstract class User implements UserActions {
	// Account Information Requirement
private int id;
private String Firstname;
private String lastName;
public String getName() {
	return Firstname;
}
public void setName(String name) {
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
	public User(String name, String lastName,String address, String email, String phoneNumber) {
		this.Firstname = name;
		this.setLastName(lastName);
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public void checkout() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void returnMedia() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void payFine() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub
		
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
	
}
