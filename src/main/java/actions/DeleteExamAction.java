package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamDaoImp;
import pojo.Exam;

@Namespace("/exame")
public class DeleteExamAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Exam exam;

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	@Action(value="/deletar",
			results = { 
				@Result(name="success", location="/exame/listar", type="redirect"),
				@Result(name="input", location="/exame/listar"),
			}
		)
		public String updateExam() {
			try {
				String id = ServletActionContext.getRequest().getParameter("id");
				
				System.out.println("id: " + id);
				
				ExamDaoImp.delete(Integer.parseInt(id));
				
				System.out.println("bau: ");
				
				return SUCCESS;
			} catch (Exception ex) {
				System.out.println("erro: " + ex);
				return INPUT;
			}
		}
}
