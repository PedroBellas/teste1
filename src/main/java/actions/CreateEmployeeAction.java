package actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.EmployeeDaoImp;
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
	public String createEmployee() {
		try {
			// TODO: Create a class to form validations
			if (name == null || name.equals("")) {
				addFieldError("name", "O nome do funcionário é obrigatorio");
				return INPUT;
			}
			
			if (name.length() > 20) {
				addFieldError("name", "O nome do funcionário deve ser menor que 20 caracteres");
				return INPUT;
			}
			
			Employee employee = new Employee();
			
			employee.setName(name);
			
			EmployeeDaoImp.create(employee);
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
