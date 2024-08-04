package actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExamDaoImp;
import pojo.Exam;
import pojo.Pagination;

@Namespace("/exame")
public class ListExamsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Pagination pagination = new Pagination();
	private Integer page;
	private List<Exam> exams;
	private Integer id;
	private String name;
	private String active;
	
	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Action(value="/listar", 
		results = { 
			@Result(name="success", location="/exame/list.jsp"),
			@Result(name="input", location="/"),
		}
	)
	public String listExams() {
		try {
			boolean haveParams = false;
			Exam examParams = new Exam();
			
			if (id != null) {
				examParams.setId(id);
				haveParams = true;
			}
			
			if (name != null) {
				examParams.setName(name.concat("%"));
				haveParams = true;
			}

			if (active != null) {
				haveParams = true;

				if (!active.equals("all")) {
					examParams.setActive(new Boolean(active));
				}
			}
			
			String currentPage = ServletActionContext.getRequest().getParameter("page");
			
			Integer page = Integer.parseInt(currentPage);
			Integer registries = ExamDaoImp.getQtyRegistries();
		
			this.pagination.setCurrentPage(page);
			this.pagination.setRegistries(registries);
			this.page = page;
			
			if (haveParams) {
				setExams(ExamDaoImp.findExamsByParams(examParams, pagination));
			} else {
				setExams(ExamDaoImp.find(pagination));
			}
			
			return SUCCESS;
		} catch (Exception ex) {
			System.out.println("erro: " + ex);
			return INPUT;
		}
	}
}
