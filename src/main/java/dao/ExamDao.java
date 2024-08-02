package dao;

import java.util.List;
import pojo.Exam;

public interface ExamDao {
	void create(Exam user) throws Exception;
	List<Exam> findAll() throws Exception;
	List<Exam> findExamsByParams(Integer id) throws Exception;
	List<Exam> findActive() throws Exception;
	List<Exam> findUnactive() throws Exception;
	void update(Exam user) throws Exception;
	void delete(Integer id) throws Exception;
}
