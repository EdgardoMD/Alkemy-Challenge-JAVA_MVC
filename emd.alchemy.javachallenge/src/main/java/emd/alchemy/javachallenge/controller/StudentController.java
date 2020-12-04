package emd.alchemy.javachallenge.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import emd.alchemy.javachallenge.model.Course;
import emd.alchemy.javachallenge.model.Schedule;
import emd.alchemy.javachallenge.service.ICourseService;
import emd.alchemy.javachallenge.service.IScheduleService;

@Controller
public class StudentController {
	
	@Autowired
	private ICourseService courseService;
	@Autowired
	private IScheduleService scheduleService;
	
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
		 //List<Schedule> schedules = scheduleService.findByCourseId(courseId);
		 //System.out.println(schedules);
			mav.addObject("course", course);
			//mav.addObject("schedules", schedules);
			return mav;
	}
	
	
	@GetMapping("/student/courses/joinup/{courseId}")
	public ModelAndView courseJoinUp(@PathVariable(value = "courseId") Integer courseId) {
		ModelAndView mav = new ModelAndView("courseJoinup");
		Course courseSelected = courseService.findById(courseId);
		mav.addObject("courseSelected", courseSelected);
		return mav;
	}
}
