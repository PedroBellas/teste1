package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import bean.ExamBeanImp;
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
	public String populateEmployee() {
		try {
			String id = ServletActionContext.getRequest().getParameter("id");
			
			Exam exam = new Exam();
			exam.setId(Integer.parseInt(id));
			
			ExamBeanImp ebi = new ExamBeanImp();
			setExam(ebi.getSelectedExam(exam));
			
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
	@Override
	public String execute() {
		try {
			ExamBeanImp ebi = new ExamBeanImp();
			ebi.updateExam(exam);
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
