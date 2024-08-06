package business;

import java.util.List;

import dao.AppointmentDaoImp;
import pojo.Appointment;

public class AppointmentBusiness {
	public void createAppointment(Appointment appointement) throws Exception {
		try {
			AppointmentDaoImp.create(appointement);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public List<Appointment> listAppointments() throws Exception {
		try {
			return AppointmentDaoImp.findAll();
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public Appointment getSelectedAppointment(Appointment appointement) throws Exception {
		try {
			return AppointmentDaoImp.findById(appointement.getId());
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public void updateAppointments(Appointment appointement) throws Exception {
		try {
			AppointmentDaoImp.update(appointement);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public void deleteAppointments(Appointment appointement) throws Exception {
		try {
			AppointmentDaoImp.delete(appointement.getId());
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public void validateAppointementFields(Appointment appointement) throws Exception {
		if (appointement.getEmployee().getId() == null) {
			throw new Exception("Selecione um funcionário para continuar");
		}
		
		if (appointement.getExam().getId() == null) {
			throw new Exception("Selecione um exame para continuar");
		}
	}
}
