package actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import bean.EmployeeBeanImp;
import pojo.Employee;

public class CreateEmployeeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Action(value="/criarFuncionario",
		results = { 
			@Result(name="success", location="/listarFuncionarios", type="redirect"), 
			@Result(name="input", location="/funcionario/form.jsp") 
		}
	)
	@Override
	public String execute() {
		try {
			Employee employee = new Employee();
			employee.setName(name);
			
			EmployeeBeanImp ebi = new EmployeeBeanImp();
			ebi.createEmployee(employee);
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
