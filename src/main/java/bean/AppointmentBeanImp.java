package bean;

import java.util.List;

import javax.ejb.Stateless;

import business.AppointmentBusiness;
import pojo.Appointment;

@Stateless
public class AppointmentBeanImp implements AppointmentBean {
	AppointmentBusiness appointmentBusiness = new AppointmentBusiness();

	@Override
	public void createAppointment(Appointment appointment) throws Exception {
		appointmentBusiness.createAppointment(appointment);
	}

	@Override
	public List<Appointment> listAppointment() throws Exception {
		return appointmentBusiness.listAppointments();
	}

	@Override
	public void updateAppointment(Appointment appointment) throws Exception {
		appointmentBusiness.updateAppointments(appointment);
	}

	@Override
	public void deleteAppointment(Appointment appointment) throws Exception {
		appointmentBusiness.deleteAppointments(appointment);
	}

	@Override
	public Appointment getSelectedAppointment(Appointment appointment) throws Exception {
		return appointmentBusiness.getSelectedAppointment(appointment);
	}
}
