package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import appointment.Appointment;
import task.Task;

class AppointmentTest {
	
	private Appointment appointment;

	@BeforeEach
	public void setupAppointmentTests() {
		// Create test objects
		appointment = new Appointment("id", new Date(), "desc");
	}
	
	@Test
	void appointmentConstructorTest() {
		Appointment appointment2 = new Appointment("id", new Date(), "desc");
		assertNotNull(appointment2.getAppointmentId());
	}
	
	@Test
	void appointmentSettersAndGettersTest() {
		appointment.setAppointmentId("newid");
		appointment.setAppointmentDate(new Date());
		appointment.setAppointmentDescription("newdesc");
		
		assertTrue(appointment.getAppointmentId().equals("newid"));
	}
	
	@Test
	public void testNullId() {
		assertThrows(IllegalArgumentException.class, () -> {new Appointment(null, new Date(), "desc");});
		// assertDoesNotThrow(IllegalArgumentException.class, () -> {new Task("id", "name", "desc");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"0", "longerthan10characters"})
	void testIdValidation(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> {new Appointment(testValue, new Date(), "desc");});
	}
	
	@Test
	public void testNullDate() {
		assertThrows(IllegalArgumentException.class, () -> {new Appointment("id", null, "desc");});
		// assertDoesNotThrow(IllegalArgumentException.class, () -> {new Task("id", "name", "desc");});
	}
	
	@Test
	void testDateValidation() {
		assertThrows(IllegalArgumentException.class, () -> {new Appointment("id", new Date(0), "desc");});
	}
	
	@Test
	public void testNullDescription() {
		assertThrows(IllegalArgumentException.class, () -> {new Appointment("id", new Date(), null);});
		// assertDoesNotThrow(IllegalArgumentException.class, () -> {new Task("id", "name", "desc");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"0", "longerthan50testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"})
	void testDescriptionValidation(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> {new Appointment("id", new Date(), testValue);});
	}

}
