package pojo;

public class Exam {
	private Integer id;
	private String name;
	private Boolean active;
	private String descriptionExam;
	private String descriptionExam1;
	
	public Exam() {}
	
	public Exam(String name, String descriptionExam, String descriptionExam1) {
		setId(null);
		setName(name);
		setActive(true);
		setDescriptionExam(descriptionExam);
		setDescriptionExam1(descriptionExam1);
	}
	
	public Exam(Integer id, String name, Boolean active, String descriptionExam, String descriptionExam1) {
		setId(id);
		setName(name);
		setActive(active);
		setDescriptionExam(descriptionExam);
		setDescriptionExam1(descriptionExam1);
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDescriptionExam() {
		return descriptionExam;
	}

	public void setDescriptionExam(String descriptionExame) {
		this.descriptionExam = descriptionExame;
	}

	public String getDescriptionExam1() {
		return descriptionExam1;
	}

	public void setDescriptionExam1(String descriptionExame1) {
		this.descriptionExam1 = descriptionExame1;
	}
	
}
