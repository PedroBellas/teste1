package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamDaoImp;
import pojo.Exam;

public class UpdateExamAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Exam exam;

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Action(value="/revisarFormularioExame", 
		results = { 
			@Result(name="success", location="/exame/form-update.jsp"),
			@Result(name="input", location="/listarExames", type="redirect"),
		}
	)
	public String getSelectedExam() {
		try {
			String id = ServletActionContext.getRequest().getParameter("id");
			
			setExam(ExamDaoImp.findById(Integer.parseInt(id)));
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
	
	@Action(value="/atualizarExame", 
		results = { 
			@Result(name="success", location="/listarExames", type="redirect"),
			@Result(name="input", location="/exame/form-update.jsp"),
		}
	)
	public String updateExam() {
		try {
			if (exam.getName() == null || exam.getName().equals("")) {
				addFieldError("exam.name", "O nome do exame é obrigatorio");
				return INPUT;
			}
			
			if (exam.getActive() == null) {
				addFieldError("exam.active", "O status do exame é obrigatorio");
				return INPUT;
			}
			
			ExamDaoImp.update(exam);
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
