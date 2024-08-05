package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

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
			
			System.out.println("id: " + Integer.parseInt(id));
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
