package sm.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sm.api.Student;
import sm.service.IStudentService;

@Controller
public class StudentController {
	
	@Autowired
	private IStudentService studentService; 
		
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		
		List<Student> studentList = studentService.loadStudents();
		
		model.addAttribute("students",studentList);
		
		return "student-list";
		
		
	}
	
	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student",student);
		
		return "add-student";
		
		
	}
	

	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		
		System.out.println(student);
		
		// do a condition check 
		
		// if the user doesn't have an id then do a insert 
		if(student.getId() == 0) {
			
			//insert a new record
			studentService.saveStudent(student);
		}
		
		//if the user does have a id -> do a update 
		else {
			// do an update 
			studentService.update(student);
		}
		
		return "redirect:/showStudent";
	
	}
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id,Model model) {
		
		System.out.println("Looking data for user : " + id) ;
		
		Student theStudent = studentService.getStudent(id);
		
		System.out.println(theStudent);
		
		//setting the student infomation 
		model.addAttribute("student",theStudent);
		
		return "add-student";
		
		
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		
		// capture the id of the student whom you are trying to delete
		// once captured the id, do a service call to delete the student
		studentService.deleteStudent(id);
		
		return "redirect:/showStudent";
		
		
	}
	
}