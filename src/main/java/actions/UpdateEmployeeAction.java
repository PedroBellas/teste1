package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.EmployeeDaoImp;
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
	public String getSelectedExam() {
		try {
			String id = ServletActionContext.getRequest().getParameter("id");
			setEmployee(EmployeeDaoImp.findById(Integer.parseInt(id)));
			
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
	public String updateExam() {
		try {
			// TODO: Create a class to form validations
			if (employee.getName() == null || employee.getName().equals("")) {
				addFieldError("employee.name", "O nome do funcionário é obrigatorio");
				return INPUT;
			}
			
			if (employee.getName().length() > 20) {
				addFieldError("employee.name", "O nome do funcionário deve ser menor que 20 caracteres");
				return INPUT;
			}
			
			EmployeeDaoImp.update(employee);
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
