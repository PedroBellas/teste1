package pojo;

public class Employee {
	private Integer id;
	private String name;
	
	public Employee() {}
	
	public Employee(Integer id, String name) {
		setId(id);
		setName(name);
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
}
