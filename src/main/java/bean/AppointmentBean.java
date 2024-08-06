package bean;

import java.util.List;
import javax.ejb.Remote;

import pojo.Appointment;

@Remote
public interface AppointmentBean {
	public void createAppointment(Appointment appointment) throws Exception;
	public List<Appointment> listAppointment() throws Exception;
	public void updateAppointment(Appointment appointment) throws Exception;
	public void deleteAppointment(Appointment appointment) throws Exception;
	public Appointment getSelectedAppointment(Appointment appointment) throws Exception;
}
