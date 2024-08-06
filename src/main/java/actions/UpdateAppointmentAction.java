package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import bean.AppointmentBeanImp;
import pojo.Appointment;

public class UpdateAppointmentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Action(value="/revisarFormularioConsulta", 
		results = { 
			@Result(name="success", location="/consulta/form-update.jsp"),
			@Result(name="input", location="/listarConsultas", type="redirect"),
		}
	)
	public String getSelectedAppointment() {
		try {
			String id = ServletActionContext.getRequest().getParameter("id");
			Appointment appointment = new Appointment();
			appointment.setId(Integer.parseInt(id));
			
			AppointmentBeanImp abi = new AppointmentBeanImp();
			Appointment appoi = abi.getSelectedAppointment(appointment);
			
			setDate(appoi.getDate().toString());
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
	
	@Action(value="/atualizarConsulta", 
		results = { 
			@Result(name="success", location="/listarConsultas", type="redirect"),
			@Result(name="input", location="/consulta/form-update.jsp"),
		}
	)
	public String updateAppointment() {
		try {
			// EmployeeDaoImp.update(employee);
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
