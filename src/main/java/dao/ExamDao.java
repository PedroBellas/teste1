package dao;

import pojo.Exam;

public interface ExamDao {
	void create(Exam exam) throws Exception;
	Exam findById(Exam exam) throws Exception;
	void update(Exam exam) throws Exception;
	void delete(Integer id) throws Exception;
}
