package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import contact.Contact;
import task.Task;

class ContactTest {
	private Contact contact;
	
	@BeforeEach
	public void setupContactTests() {
		// Create test objects
		contact = new Contact("0000", "first", "last", "0123456789", "123 address street");
	}
	
	@Test
	void contactTestConstructor() {
		assertNotNull(contact.getContactId());
		assertNotNull(contact.getFirstName());
		assertNotNull(contact.getLastName());
		assertNotNull(contact.getNumber());
		assertNotNull(contact.getAddress());
	}
	
	@Test
	void contactTestGetters() {
		
		// Test getters
		assertTrue(contact.getContactId().equals("0000"));
		assertTrue(contact.getFirstName().equals("first"));
		assertTrue(contact.getLastName().equals("last"));
		assertTrue(contact.getNumber().equals("0123456789"));
		assertTrue(contact.getAddress().equals("123 address street"));
	}
	
	
	@Test
	void contactTestSettersAndGetters() {
		
		// Set new values
		contact.setFirstName("first2");
		contact.setLastName("last2");
		contact.setNumber("2222222222");
		contact.setAddress("222 address street");
		
		// Test setters
		assertTrue(contact.getFirstName().equals("first2"));
		assertTrue(contact.getLastName().equals("last2"));
		assertTrue(contact.getNumber().equals("2222222222"));
		assertTrue(contact.getAddress().equals("222 address street"));
	}
	
	@Test
	public void testNullId() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact(null, "fn", "ln", "1234567890", "address");});
		// assertDoesNotThrow(IllegalArgumentException.class, () -> {new Task("id", "name", "desc");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"0", "anidthatexceedsthecharacterlimit"})
	void testIdValidation(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> {new Contact(testValue, "fn", "ln", "1234567890", "address");});
	}
	
	@Test
	public void testNullFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("id", null, "ln", "1234567890", "address");});
		// assertDoesNotThrow(IllegalArgumentException.class, () -> {new Task("id", "name", "desc");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"0", "exceedsthecharacterlimit"})
	void testFirstNameValidation(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("id", testValue, "ln", "1234567890", "address");});
	}
	
	@Test
	public void testNullLastName() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("id", "fn", null, "1234567890", "address");});
		// assertDoesNotThrow(IllegalArgumentException.class, () -> {new Task("id", "name", "desc");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"0", "exceedsthecharacterlimit"})
	void testLastNameValidation(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("id", "fn", testValue, "1234567890", "address");});
	}
	
	@Test
	public void testNullLastNumber() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("id", "fn", "ln", null, "address");});
		// assertDoesNotThrow(IllegalArgumentException.class, () -> {new Task("id", "name", "desc");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"exceedsthecharacterlimit", "1234567890", "123"})
	void testNumberValidation(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("id", "fn", "ln", testValue, "address");});
	}
	
	@Test
	public void testNullAddress() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("id", "fn", "ln", "1234567890", null);});
		// assertDoesNotThrow(IllegalArgumentException.class, () -> {new Task("id", "name", "desc");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"0", "testcharacterlimittestcharacterlimittestcharacterlimittestcharacterlimittestcharacterlimit"})
	void testAddressValidation(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("id", "fn", "ln", "1234567890", testValue);});
	}
	/*
	
	
	*/

}
