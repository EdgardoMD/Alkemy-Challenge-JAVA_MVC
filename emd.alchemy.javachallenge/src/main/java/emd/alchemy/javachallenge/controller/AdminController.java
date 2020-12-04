package emd.alchemy.javachallenge.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import emd.alchemy.javachallenge.model.Course;
import emd.alchemy.javachallenge.model.Professor;
import emd.alchemy.javachallenge.model.Schedule;
import emd.alchemy.javachallenge.service.ICourseService;
import emd.alchemy.javachallenge.service.IProfessorService;
import emd.alchemy.javachallenge.service.IScheduleService;

@Controller
public class AdminController {
	
	@Autowired
	private ICourseService courseService;
	@Autowired
	private IProfessorService professorService;
	@Autowired
	private IScheduleService scheduleService;
	
	 @GetMapping("/admin/professors")
	 public String professorList(Model model) {
		 List<Professor> professorlist = professorService.listAll();
		 model.addAttribute("professorlist", professorlist);
		 return "professorList";
	 }
	 
	 @GetMapping("/admin/professors/new")
	 public String formNewProfessor(Map<String, Object> model) {
		 Professor professor = new Professor();
		 model.put("professor", professor);
		 return "professorForm";
		 
	 }
	 
	 @GetMapping("/admin/professors/edit/{professorId}")
	 public ModelAndView editProfessor(@PathVariable(value = "professorId") Integer professorId) {
		 ModelAndView mav = new ModelAndView("editProfessor");
		 Professor professor = professorService.findById(professorId);
		    System.out.println(professor);
			mav.addObject("professor", professor);
			return mav;
	 }
	 
	 
	 
	 @PostMapping("/admin/professors/save")
	    public String guardar(Professor professor) {
	        professorService.save(professor);
	        
	        return "redirect:/admin/professors";
	    }
	 
	 @GetMapping("/admin/professors/delete/{professorId}")
	 public String deleteProfessor (@PathVariable(value="professorId") Integer professorId) {
		 Professor professor = professorService.findById(professorId);
		 if(professor.isEnabled() == true) {
			 System.out.println("Professor cannot be delete");
			 return "redirect:/admin/professors";
		 }
		 
				 professorService.delete(professorId);
		 return "redirect:/admin/professors";
	 }
	 
	 @GetMapping("/admin/courses") 
	 public String courseList(Model model) {
	 List<Course> courselist = courseService.listAllCoursesOrderAsc();
	 System.out.println(courselist);
	 model.addAttribute("courselist", courselist); 
	 return "courseList"; 
	 }
	 
	 @GetMapping("/admin/courses/new")
	 public String formNewCourse(Map<String, Object> model) {
		 Course course = new Course();
		 model.put("course", course);
		 return "courseForm"; 
	 }
	 
	 @GetMapping("/admin/courses/edit/{courseId}")
	 public ModelAndView editCourse(@PathVariable(value = "courseId") Integer courseId) {
		 ModelAndView mav = new ModelAndView("editCourse");
		 Course course = courseService.findById(courseId);
		    System.out.println(course);
			mav.addObject("course", course);
			return mav;
	 }
	 
	 @PostMapping("/admin/courses/save")
	    public String save(Course course) {
	        courseService.save(course);
	        return "redirect:/admin/courses";
	    }
	 
	 @GetMapping("/admin/courses/delete/{courseId}")
	 public String deleteCourse (@PathVariable(value="courseId") Integer courseId) {
		 courseService.delete(courseId);
		 return "redirect:/admin/courses";
	 }
	 
	 @GetMapping("/admin/schedules") 
	 public String scheduleList(Model model) {
	 List<Schedule> schedulelist = scheduleService.listAllOrderByCourseIdAsc();
	 System.out.println(schedulelist);
	 model.addAttribute("schedulelist", schedulelist); 
	 return "scheduleList"; 
	 }
	 
	 @GetMapping("/admin/schedules/new")
	 public String formNewSchedule(Map<String, Object> model) {
		 Schedule schedule = new Schedule();
		 model.put("schedule", schedule);
		 return "scheduleForm"; 
	 }
	 
	 @GetMapping("/admin/schedules/edit/{scheduleId}")
	 public ModelAndView editSchedule(@PathVariable(value = "scheduleId") Integer scheduleId) {
		 ModelAndView mav = new ModelAndView("editSchedule");
		 Schedule schedule = scheduleService.findById(scheduleId);
		    System.out.println(schedule);
			mav.addObject("schedule", schedule);
			return mav;
	 }
	 
	 @PostMapping("/admin/schedules/save")
	    public String save(Schedule schedule) {
	        scheduleService.save(schedule);
	        return "redirect:/admin/schedules";
	    }
	 
	 @GetMapping("/admin/schedules/delete/{scheduleId}")
	 public String deleteSchedule (@PathVariable(value="scheduleId") Integer scheduleId) {
		 scheduleService.delete(scheduleId);
		 return "redirect:/admin/schedules";
	 }
	 
}
