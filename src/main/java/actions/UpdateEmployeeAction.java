package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import bean.EmployeeBeanImp;
import pojo.Employee;

public class UpdateEmployeeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Action(value="/revisarFormularioFuncionario", 
		results = {
			@Result(name="success", location="/funcionario/form-update.jsp"),
			@Result(name="input", location="/listarFuncionarios", type="redirect"),
		}
	)
	public String populateEmployee() {
		try {
			String id = ServletActionContext.getRequest().getParameter("id");

			Employee employee = new Employee();
			employee.setId(Integer.parseInt(id));
			
			EmployeeBeanImp ebi = new EmployeeBeanImp();
			setEmployee(ebi.getSelectedEmployee(employee));
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
	
	@Action(value="/atualizarFuncionario", 
		results = { 
			@Result(name="success", location="/listarFuncionarios", type="redirect"),
			@Result(name="input", location="/funcionario/form-update.jsp"),
		}
	)
	@Override
	public String execute() {
		try {	
			EmployeeBeanImp ebi = new EmployeeBeanImp();
			ebi.updateEmployee(employee);
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
