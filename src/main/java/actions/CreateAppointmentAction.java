package actions;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import bean.AppointmentBeanImp;
import bean.EmployeeBeanImp;
import bean.ExamBeanImp;
import pojo.Appointment;
import pojo.Employee;
import pojo.Exam;

public class CreateAppointmentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Employee> employees;
	private List<Exam> exams;
	private String date;
	private Integer idExam;
	private Integer idEmployee;
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getIdExam() {
		return idExam;
	}

	public void setIdExam(Integer idExam) {
		this.idExam = idExam;
	}

	public Integer getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}

	@Action(value="/formularioConsulta", 
		results = { 
			@Result(name="success", location="/consulta/form.jsp"), 
		}
	)
	public String renderFormCreateAppointment() throws Exception {
		ExamBeanImp ebi = new ExamBeanImp();
		setExams(ebi.listActiveExam());
		
		EmployeeBeanImp embi = new EmployeeBeanImp();
		setEmployees(embi.listEmployees());
		
		return SUCCESS;
	}

	@Action(value="/criarConsulta",
		results = { 
			@Result(name="success", location="/listarConsultas", type="redirect"), 
			@Result(name="input", location="/formularioConsulta", type="redirect") 
		}
	)
	@Override
	public String execute() {
		try {	
			Exam exam = new Exam();
			exam.setId(idExam);
			
			Employee employee = new Employee();
			employee.setId(idEmployee);
			
			Appointment appointement = new Appointment(null, exam, employee, Date.valueOf(date));

			AppointmentBeanImp abi = new AppointmentBeanImp();
			abi.createAppointment(appointement);
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
