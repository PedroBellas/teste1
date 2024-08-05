package pojo;

public class Pagination {
	private Integer size = 25;
	private Integer currentPage;
	private Integer registries;
	
	public Pagination() {}
	
	public Pagination(Integer registries) {
		setCurrentPage(0);
		setRegistries(registries);
	}
	
	public Pagination(Integer size, Integer currentPage, Integer registries) {
		setSize(size);
		setCurrentPage(currentPage);
		setRegistries(registries);
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getRegistries() {
		return registries;
	}

	public void setRegistries(Integer registries) {
		this.registries = registries;
	}
	
	public Integer getQtypages() {
		return (getRegistries() / getSize()) + 1;
	}
	
	public Integer getMinRow() {
		return (getCurrentPage() - 1) * getSize();
	}
}
