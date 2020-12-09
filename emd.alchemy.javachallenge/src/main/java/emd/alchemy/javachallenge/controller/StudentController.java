package emd.alchemy.javachallenge.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import emd.alchemy.javachallenge.model.Course;
import emd.alchemy.javachallenge.model.Schedule;
import emd.alchemy.javachallenge.model.Student;
import emd.alchemy.javachallenge.model.StudentCourse;
import emd.alchemy.javachallenge.repo.IUserRepo;
import emd.alchemy.javachallenge.service.ICourseService;
import emd.alchemy.javachallenge.service.IScheduleService;
import emd.alchemy.javachallenge.service.IStudentCourseService;
import emd.alchemy.javachallenge.service.IStudentService;

@Controller
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	@Autowired
	private ICourseService courseService;
	@Autowired
	private IStudentCourseService stcoService;
	@Autowired
	private IScheduleService scheduleService;
	@Autowired
	private IUserRepo userRepository;
	
	@GetMapping("/student/courses")
	public String coursesList(Model model) {
		List<Course> courselist = courseService.listAll();
		 //System.out.println(courselist);
		 model.addAttribute("courselist", courselist); 
		 return "courselistforstudents"; 
	}
	
	@GetMapping("/student/courses/showdescription/{courseId}")
	public ModelAndView courseShowDescription(@PathVariable(value = "courseId") Integer courseId) {
		 ModelAndView mav = new ModelAndView("showCourseDescription");
		 String course = courseService.findById(courseId).getDescription();
		 List<Schedule> schedules = scheduleService.findByCourse(courseId);
		// System.out.println(schedules);
			mav.addObject("course", course);
			mav.addObject("schedules", schedules);
			return mav;
	}
	
	@GetMapping("/student/courses/yourcourses/{userName}")
	public ModelAndView yourCourses(@PathVariable(value="userName") String userName) {
		ModelAndView mav = new ModelAndView("yourCourses");
		Integer studentId = studentService.findByDni(userName).getStudentId();
		System.out.println(studentId);
		System.out.println(stcoService.findByStudentId(studentId).toString());
		List<StudentCourse> courses = stcoService.findByStudentId(studentId);
		mav.addObject("courses", courses);
		
		return mav;	 
	}
	
	//****************************************************************************************
	@GetMapping("/student/courses/joinup/register/{courseId}/{userName}")
	public String joinNewCourse(@PathVariable(value = "courseId") Integer courseId, @PathVariable(value="userName") String userName) {
		
		Integer param1 = courseId;
		String param2 = userName;
		
		Course course = courseService.findById(param1);
		Student student = studentService.findByDni(param2);
		Integer studentId = student.getStudentId();
		StudentCourse exist = stcoService.findOnebyCourseId(param1);
		if(exist !=null ) {
		return "joinupException";
		}else{
			stcoService.register(studentId, courseId);
			return "redirect:/student/courses";
		}
	}
		
}
	
		
	



	


