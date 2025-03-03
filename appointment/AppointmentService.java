package appointment;

import java.util.HashMap;
import java.util.Map;

import task.Task;

public class AppointmentService {
	private final Map<String, Appointment> appointments;
	
	public AppointmentService() {
		appointments = new HashMap<>();
	}
	
	public Appointment getAppointment(String appointmentId) {
		return appointments.get(appointmentId);
	}
	
	public boolean addAppointment(Appointment appointment) {
		if(appointments.putIfAbsent(appointment.getAppointmentId(), appointment) == null) {
			return true;
		}
		
		return false;
	}
	
	
	public void deleteAppointment(String appointmentId) {
		appointments.remove(appointmentId);
	}

}
