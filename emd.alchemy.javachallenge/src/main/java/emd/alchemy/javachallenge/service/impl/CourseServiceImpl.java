package emd.alchemy.javachallenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emd.alchemy.javachallenge.model.Course;
import emd.alchemy.javachallenge.repo.ICourseRepo;
import emd.alchemy.javachallenge.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private ICourseRepo repo;
	
	@Override
	public Course save(Course course) {
		
		return repo.save(course);
	}

	@Override
	public Course edit(Course course) {
		
		return repo.save(course);
	}

	@Override
	public List<Course> listAll() {
		
		return repo.findAll();
	}

	@Override
	public Course findById(Integer courseId) {
		Optional<Course> op = repo.findById(courseId);
		return op.isPresent() ? op.get() : new Course();
	}

	@Override
	public boolean delete(Integer courseId) {
		
		repo.deleteById(courseId);
		return true;
	}

	@Override
	public List<Course> listAllCoursesOrderAsc() {
		
		return repo.listAllCoursesOrderAsc();
	}

}
