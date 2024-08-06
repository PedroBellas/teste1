package bean;

import java.util.List;
import javax.ejb.Remote;

import pojo.Employee;

@Remote
public interface EmployeeBean {
	public void createEmployee(Employee employee) throws Exception;
	public List<Employee> listEmployees() throws Exception;
	public void updateEmployee(Employee employee) throws Exception;
	public void deleteEmployee(Employee employee) throws Exception;
	public Employee getSelectedEmployee(Employee employee) throws Exception;
}
