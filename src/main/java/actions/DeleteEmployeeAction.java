package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import bean.EmployeeBeanImp;
import pojo.Employee;

public class DeleteEmployeeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Action(value="/deletarFuncionario",
		results = { 
			@Result(name="success", location="/listarFuncionarios", type="redirect"),
			@Result(name="input", location="/listarFuncionarios"),
		}
	)
	public String deleteEmployee() {
		try {
			String id = ServletActionContext.getRequest().getParameter("id");
			
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(id));
			
			EmployeeBeanImp ebi = new EmployeeBeanImp();
			ebi.deleteEmployee(employee);
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
