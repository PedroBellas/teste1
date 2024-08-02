package pojo;

public class Exam {
	private Integer id;
	private String name;
	private Character active;
	private String descriptionExame;
	private String descriptionExame1;
	
	public Exam() {}
	
	public Exam(Integer id, String name, Character active, String descriptionExame, String descriptionExame1) {
		setId(id);
		setName(name);
		setActive(active);
		setDescriptionExame(descriptionExame);
		setDescriptionExame1(descriptionExame1);
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

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	public String getDescriptionExame() {
		return descriptionExame;
	}

	public void setDescriptionExame(String descriptionExame) {
		this.descriptionExame = descriptionExame;
	}

	public String getDescriptionExame1() {
		return descriptionExame1;
	}

	public void setDescriptionExame1(String descriptionExame1) {
		this.descriptionExame1 = descriptionExame1;
	}
	
}
