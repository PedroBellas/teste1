package bean;

import java.util.List;
import javax.ejb.Remote;

import pojo.Exam;

@Remote
public interface ExamBean {
	public void createExam(Exam exam) throws Exception;
	public List<Exam> listExam() throws Exception;
	public void updateExam(Exam exam) throws Exception;
	public void deleteExam(Exam exam) throws Exception;
	public Exam getSelectedExam(Exam exam) throws Exception;
}
