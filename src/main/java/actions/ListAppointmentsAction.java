package actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.AppointmentDaoImp;
import pojo.Appointment;

public class ListAppointmentsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Appointment> appointments;
	
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Action(value="/listarConsultas", 
		results = { 
			@Result(name="success", location="/consulta/index.jsp"),
			@Result(name="input", location="/"),
		}
	)
	public String listAppointments() {
		try {
			setAppointments(AppointmentDaoImp.findAll());
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
