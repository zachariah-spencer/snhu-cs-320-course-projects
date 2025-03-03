package appointment;

import java.util.Date;

public class Appointment {
	private String appointmentId;
	private Date appointmentDate;
	private String appointmentDescription;
	
	public Appointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
		setAppointmentId(appointmentId);
		setAppointmentDate(appointmentDate);
		setAppointmentDescription(appointmentDescription);
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public void setAppointmentId(String appointmentId) {
		if(appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid appointment id.");
		}
		
		this.appointmentId = appointmentId;
	}
	
	public void setAppointmentDate(Date appointmentDate) {
		if(appointmentDate == null) {
			throw new IllegalArgumentException("Invalid appointment date: date not set.");
		}
		
		if(appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment date: date cannot be before current date.");
		}
		
		this.appointmentDate = appointmentDate;
	}
	
	public void setAppointmentDescription(String appointmentDescription) {
		if(appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description");
		}
		
		this.appointmentDescription = appointmentDescription;
	}
}
