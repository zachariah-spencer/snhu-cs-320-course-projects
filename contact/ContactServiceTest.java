package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;
import task.Task;

class ContactServiceTest {
	@Test
	void contactServiceTestConstructor() {
		ContactService contactService = new ContactService();
		
		assertNotNull(contactService);
		
	}
	
	@Test void contactServiceTestGetContact() {
		ContactService contactService = new ContactService();
		
		contactService.addContact(new Contact("id", "fn", "ln", "0000000000", "address"));
		assertFalse(contactService.addContact(new Contact("id", "fn", "ln", "0000000000", "address")));
	}
	
	@Test
	void contactServiceTestAddContact() {
		// Create test object
		ContactService contactService = new ContactService();
		
		Contact contact = new Contact("id", "fn", "ln", "0000000000", "address");
		
		contactService.addContact(contact);
		assertNotNull(contactService.getContact(contact.getContactId()));
	}
	
	@Test
	void contactServiceTestDeleteContact() {
		// Create test object
		ContactService contactService = new ContactService();
		
		Contact contact = new Contact("id", "fn", "ln", "0000000000", "address");
		
		contactService.addContact(contact);
		
		contactService.deleteContact(contact.getContactId());
		
		assertNull(contactService.getContact(contact.getContactId()));
	}
	
	@Test
	void contactServiceTestUpdateContactFirstName() {
		// Create test object
		ContactService contactService = new ContactService();
		
		Contact contact = new Contact("id", "fn", "ln", "0000000000", "address");
		
		contactService.addContact(contact);
		
		contactService.updateContactFirstName("fn2", contact.getContactId());
		
		assertTrue(contactService.getContact(contact.getContactId()).getFirstName().equals("fn2"));
	}
	
	@Test
	void contactServiceTestUpdateContactLastName() {
		// Create test object
		ContactService contactService = new ContactService();
		
		Contact contact = new Contact("id", "fn", "ln", "0000000000", "address");
		
		contactService.addContact(contact);
		
		contactService.updateContactLastName("ln2", contact.getContactId());
		
		assertTrue(contactService.getContact(contact.getContactId()).getLastName().equals("ln2"));
	}
	
	@Test
	void contactServiceTestUpdateContactNumber() {
		// Create test object
		ContactService contactService = new ContactService();
		
		Contact contact = new Contact("id", "fn", "ln", "0000000000", "address");
		
		contactService.addContact(contact);
		
		contactService.updateContactNumber("1111111111", contact.getContactId());
		
		assertTrue(contactService.getContact(contact.getContactId()).getNumber().equals("1111111111"));
	}
	
	@Test
	void contactServiceTestUpdateContactAddress() {
		// Create test object
		ContactService contactService = new ContactService();
		
		Contact contact = new Contact("id", "fn", "ln", "0000000000", "address");
		
		contactService.addContact(contact);
		
		contactService.updateContactAddress("address2", contact.getContactId());
		
		assertTrue(contactService.getContact(contact.getContactId()).getAddress().equals("address2"));
	}
	
}
