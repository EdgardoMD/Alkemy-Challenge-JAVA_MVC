package emd.alchemy.javachallenge.service;

import java.util.List;

import emd.alchemy.javachallenge.model.Course;


public interface ICourseService {
	
	Course save (Course course);
	Course edit (Course course);
	List<Course> listAll ();
	Course findById (Integer courseId);
	boolean delete (Integer courseId);
	
	List<Course> listAllCoursesOrderAsc();

}
