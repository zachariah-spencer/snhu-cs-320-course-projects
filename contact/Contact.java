package contact;

public class Contact {
	private String contactId;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	// constructor
	public Contact(String contactId, String firstName, String lastName, String number, String address) {
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		setAddress(address);
	}
	
	// getters
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	// setters
	public void setContactId(String contactId) {
		if(contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact id.");
		}
		
		this.contactId = contactId;
	}
	
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid contact first name.");
		}
		
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid contact last name.");
		}
		
		this.lastName = lastName;
	}
	
	public void setNumber(String number) {
		if(number == null || number.length() != 10) {
			throw new IllegalArgumentException("Invalid contact phone number.");
		}
		
		this.number = number;
	}
	
	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid contact address.");
		}
		
		this.address = address;
	}
}
