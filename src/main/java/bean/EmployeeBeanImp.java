package bean;

import java.util.List;

import javax.ejb.Stateless;

import business.EmployeeBusiness;
import pojo.Employee;

@Stateless
public class EmployeeBeanImp implements EmployeeBean {
	EmployeeBusiness employeeBusiness = new EmployeeBusiness();
	
	@Override
	public void createEmployee(Employee employee) throws Exception {
		employeeBusiness.createEmployee(employee);
	}

	@Override
	public List<Employee> listEmployees() throws Exception {
		return employeeBusiness.listEmployees();
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		employeeBusiness.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) throws Exception {
		employeeBusiness.deleteEmployee(employee);
	}

	@Override
	public Employee getSelectedEmployee(Employee employee) throws Exception {
		return employeeBusiness.getSelectedEmployee(employee);
	}
}
