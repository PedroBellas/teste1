package business;

import dao.ExamDaoImp;
import pojo.Exam;

public class ExamBusiness {
	public void createExam(Exam exam) throws Exception {
		try {
			validateExamFields(exam);

			ExamDaoImp.create(exam);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public Exam getSelectedExam(Exam exam) throws Exception  {
		try {
			return ExamDaoImp.findById(exam.getId());
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public void updateExam(Exam exam) throws Exception {
		try {
			validateExamFields(exam);
			
			if (exam.getActive() == null) {
				throw new Exception("O status do exame é obrigatorio");
			}
			
			ExamDaoImp.update(exam);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public void deleteExam(Exam exam) throws Exception {
		try {
			ExamDaoImp.delete(exam.getId());
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public void validateExamFields(Exam exam) throws Exception {
		if (exam.getName() == null || exam.getName().equals("")) {
			throw new Exception("O nome do exame é obrigatorio");
		}
		
		if (exam.getName().length() > 255) {
			throw new Exception("O nome do exame deve ser menor que 255 caracteres");
		}
	}
}
