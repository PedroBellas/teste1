package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamDaoImp;
import pojo.Exam;

@Namespace("/exame")
public class UpdateExamAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Exam exam;

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Action(value="/revisar", 
		results = { 
			@Result(name="success", location="/exame/form-update.jsp"),
			@Result(name="input", location="/"),
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
	
	@Action(value="/atualizar", 
			results = { 
				@Result(name="success", location="/exame/listar", type="redirect"),
				@Result(name="input", location="/exame/revisar"),
			}
		)
		public String updateExam() {
			try {
				ExamDaoImp.update(exam);
				
				return SUCCESS;
			} catch (Exception ex) {
				System.out.println("erro: " + ex);
				return INPUT;
			}
		}
}
