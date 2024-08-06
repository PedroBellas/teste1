package bean;

import java.util.List;

import javax.ejb.Stateless;

import business.ExamBusiness;
import pojo.Exam;

@Stateless
public class ExamBeanImp implements ExamBean {
	ExamBusiness examBusiness = new ExamBusiness();

	@Override
	public void createExam(Exam exam) throws Exception {
		examBusiness.createExam(exam);
	}

	@Override
	public List<Exam> listExam() throws Exception {
		// return examBusiness.createEmployee();
		return null;
	}

	@Override
	public void updateExam(Exam exam) throws Exception {
		examBusiness.updateExam(exam);
	}

	@Override
	public void deleteExam(Exam exam) throws Exception {
		examBusiness.deleteExam(exam);
	}

	@Override
	public Exam getSelectedExam(Exam exam) throws Exception {
		return examBusiness.getSelectedExam(exam);
	}
	
	

}
