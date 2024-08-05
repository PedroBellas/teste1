package pojo;

import java.sql.Date;

public class Appointment {
	private Integer id;
	private Exam exam;
	private Employee employee;
	private Date date;
	
	public Appointment() {}

	public Appointment(Integer id, Exam exam, Employee employee, Date date) {
		setId(id);
		setExam(exam);
		setEmployee(employee);
		setDate(date);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
