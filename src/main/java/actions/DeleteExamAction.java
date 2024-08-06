package actions;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import bean.ExamBeanImp;
import pojo.Exam;

public class DeleteExamAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Action(value="/deletarExame",
		results = { 
			@Result(name="success", location="/listarExames", type="redirect"),
			@Result(name="input", location="/listarExames"),
		}
	)
	@Override
	public String execute() {
		try {
			String id = ServletActionContext.getRequest().getParameter("id");

			Exam exam = new Exam();
			exam.setId(Integer.parseInt(id));
			
			ExamBeanImp ebi = new ExamBeanImp();
			ebi.deleteExam(exam);
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
