package actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class RedirectAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	@Action(value="/formularioExame", 
		results = { 
			@Result(name="success", location="/exame/form.jsp", type="redirect"), 
		}
	)
	public String renderFormCreateExam() {
		return SUCCESS;
	}
	
	@Action(value="/formularioFuncionario", 
		results = { 
			@Result(name="success", location="/funcionario/form.jsp", type="redirect"), 
		}
	)
	public String renderFormCreateEmployee() {
		return SUCCESS;
	}	
}
