package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import bean.AppointmentBeanImp;
import pojo.Appointment;

public class DeleteAppointmentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Action(value="/deletarConsulta",
		results = { 
			@Result(name="success", location="/listarConsultas", type="redirect"),
			@Result(name="input", location="/listarConsultas"),
		}
	)
	public String deleteAppointment() {
		try {
			String id = ServletActionContext.getRequest().getParameter("id");

			Appointment appointment = new Appointment();
			appointment.setId(Integer.parseInt(id));
			
			AppointmentBeanImp abi = new AppointmentBeanImp();
			abi.deleteAppointment(appointment);
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
