package sm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import sm.api.Student;
import sm.rowmapper.StudentRowMapper;

public class StudentDAOImpl implements IStudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Student> loadStudents() {
		
		
		String sql = "SELECT * FROM students";
		
		List<Student> theListOfStudent = jdbcTemplate.query(sql,new StudentRowMapper());

		
		return theListOfStudent;
	}


	@Override
	public void saveStudent(Student student) {
		
		Object[] sqlParameters = {student.getName(),student.getMobile(),student.getCountry()};
		
		String sql = "Insert into students(name,mobile,country) values (?,?,?)";
		
		jdbcTemplate.update(sql, sqlParameters);
		
		System.out.println("1 record inserted...");
		
	}


	@Override
	public Student getStudent(int id) {
		
		String sql = "Select * from STUDENTS where ID = ?";
	
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		
		return student;
	}


	@Override
	public void update(Student student) {
		String sql = "Update students set name = ?, mobile = ? , country = ? where id = ?";
		
		jdbcTemplate.update(sql,student.getName(),student.getMobile(),student.getCountry(),student.getId());
		
		System.out.println("1 record updated..");
	}


	@Override
	public void deleteStudent(int id) {
		String sql = "Delete from STUDENTS where id = ?";
		jdbcTemplate.update(sql,id);
	}

}
