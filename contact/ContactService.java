package contact;
import java.util.HashMap;
import java.util.Map;

import task.Task;


public class ContactService {
	private final Map<String, Contact> contacts;
	
	public ContactService() {
		contacts = new HashMap<>();
	}
	
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
	
	public boolean addContact(Contact contact) {
		if(contacts.putIfAbsent(contact.getContactId(), contact) == null) {
			return true;
		}
		
		return false;
	}
	
	public void deleteContact(String contactId) {
		contacts.remove(contactId);
	}
	
	public void updateContactFirstName(String firstName, String contactId) {
		contacts.get(contactId).setFirstName(firstName);
	}
	
	public void updateContactLastName(String lastName, String contactId) {
		contacts.get(contactId).setLastName(lastName);
	}
	
	public void updateContactNumber(String number, String contactId) {
		contacts.get(contactId).setNumber(number);
	}
	
	public void updateContactAddress(String address, String contactId) {
		contacts.get(contactId).setAddress(address);
	}
	
	
}
