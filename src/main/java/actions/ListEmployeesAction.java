package actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import bean.EmployeeBeanImp;
import pojo.Employee;

public class ListEmployeesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Employee> employees;
	private Integer id;
	private String name;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Action(value="/listarFuncionarios", 
		results = { 
			@Result(name="success", location="/funcionario/index.jsp"),
			@Result(name="input", location="/"),
		}
	)
	@Override
	public String execute() {
		try {
			EmployeeBeanImp ebi = new EmployeeBeanImp();
			setEmployees(ebi.listEmployees());
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
