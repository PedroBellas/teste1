package dao;

import pojo.Exam;

public interface ExamDao {
	void create(Exam user) throws Exception;
	// List<Exam> find() throws Exception;
	void update(Exam user) throws Exception;
	void delete(Integer id) throws Exception;
}
