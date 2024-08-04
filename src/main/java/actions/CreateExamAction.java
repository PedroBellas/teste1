package actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import dao.ExamDaoImp;
import pojo.Exam;

@Namespace("/exame")
@Validations(
	requiredStrings = {
		@RequiredStringValidator(type=ValidatorType.SIMPLE, fieldName="name", message="O nome do exame é obrigatorio")	
	}
)
public class CreateExamAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String name;
	private String descriptionExam;
	private String descriptionExam1;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescriptionExam() {
		return descriptionExam;
	}

	public void setDescriptionExam(String descriptionExam) {
		this.descriptionExam = descriptionExam;
	}

	public String getDescriptionExam1() {
		return descriptionExam1;
	}

	public void setDescriptionExam1(String descriptionExam1) {
		this.descriptionExam1 = descriptionExam1;
	}

	@Action(value="/create", 
		results = { 
			@Result(name="success", location="/exame/listar"), 
			@Result(name="input", location="/") 
		}
	)
	public String createExam() {
		try {
			Exam exam = new Exam(name, descriptionExam, descriptionExam1);
			
			ExamDaoImp.create(exam);
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
	
	@Override
	public void validate() {
		/*if (!password.equals(passwordConfirmation)) {
			addFieldError("passwordConfirmation", "As senhas não são iguais");
		}
		
		if (userDao.checkUsernameExists(username)) {
			addFieldError("username", "Nome de usuário já cadastrado");
		}*/
	}
}
