package emd.alchemy.javachallenge.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import emd.alchemy.javachallenge.model.Course;
import emd.alchemy.javachallenge.service.ICourseService;

@Controller
public class StudentController {
	
	@Autowired
	private ICourseService courseService;
	
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
			mav.addObject("course", course);
			return mav;
	}
	

}
