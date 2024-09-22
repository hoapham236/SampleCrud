package sm.service;

import java.util.List;

import sm.api.Student;

public interface IStudentService {
	List<Student> loadStudents();
	
	void saveStudent(Student student);
	
	Student getStudent(int id);
	
	void update(Student student);

	void deleteStudent(int id);
}
