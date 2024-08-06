package business;

import java.util.List;

import dao.AppointmentDaoImp;
import dao.EmployeeDaoImp;
import pojo.Employee;


public class EmployeeBusiness {
	public void createEmployee(Employee employee) throws Exception {
		try {
			validateEmployeeFields(employee);
			
			EmployeeDaoImp.create(employee);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public List<Employee> listEmployees() throws Exception {
		try {
			return EmployeeDaoImp.findAll();
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public void updateEmployee(Employee employee) throws Exception {
		try {
			validateEmployeeFields(employee);
			
			EmployeeDaoImp.update(employee);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public void deleteEmployee(Employee employee) throws Exception {
		try {
			EmployeeDaoImp.delete(employee.getId());
			AppointmentDaoImp.deleteByEmployee(employee.getId());
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public Employee getSelectedEmployee(Employee employee) throws Exception {
		try {
			return EmployeeDaoImp.findById(employee.getId());
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public void validateEmployeeFields(Employee employee) throws Exception {
		if (employee.getName() == null || employee.getName().equals("")) {
			throw new Exception("O nome do funcionário é obrigatorio");
		}
		
		if (employee.getName().length() > 20) {
			throw new Exception("O nome do funcionário deve ser menor que 20 caracteres");
		}
	}
}
