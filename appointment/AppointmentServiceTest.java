package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.AppointmentService;
import task.Task;

class AppointmentServiceTest {
	private AppointmentService appointmentService;
	private Appointment appointment;
	
	@BeforeEach
	public void setupAppointmentServiceTests() {
		appointmentService = new AppointmentService();
		appointment = new Appointment("id", new Date(), "desc");
	}
	
	@Test
	void appointmentServiceConstructorTest() {
		assertNotNull(appointmentService);
	}
	
	@Test
	void getAppointmentsTest() {
		appointmentService.addAppointment(new Appointment("id", new Date(), "desc"));
		
		assertNotNull(appointmentService.getAppointment("id"));
		assertFalse(appointmentService.addAppointment(new Appointment("id", new Date(), "desc")));
	}
	
	@Test
	void addAppointmentTest() {
		Appointment appointment = new Appointment("id", new Date(), "desc");
		
		appointmentService.addAppointment(appointment);
		assertNotNull(appointmentService.getAppointment(appointment.getAppointmentId()));
	}
	
	@Test
	void deleteAppointmentTest() {
		Appointment appointment = new Appointment("id", new Date(), "desc");
		
		appointmentService.addAppointment(appointment);
		appointmentService.deleteAppointment(appointment.getAppointmentId());
		
		assertNull(appointmentService.getAppointment(appointment.getAppointmentId()));
	}
}
