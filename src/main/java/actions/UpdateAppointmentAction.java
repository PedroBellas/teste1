package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAppointmentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Action(value="/revisarFormularioConsulta", 
		results = { 
			@Result(name="success", location="/consulta/form-update.jsp"),
			@Result(name="input", location="/listarConsultas", type="redirect"),
		}
	)
	public String getSelectedAppointment() {
		try {
			String id = ServletActionContext.getRequest().getParameter("id");
			
			System.out.println("id: " + Integer.parseInt(id));
			
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
