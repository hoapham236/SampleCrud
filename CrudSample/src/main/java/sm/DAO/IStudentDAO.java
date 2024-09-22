package sm.DAO;

import java.util.List;

import sm.api.Student;

public interface IStudentDAO {
	List<Student> loadStudents();
	
	void saveStudent(Student student);
	
	Student getStudent(int id);

	void update(Student student);

	void deleteStudent(int id);
}
