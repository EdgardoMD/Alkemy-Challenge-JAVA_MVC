package emd.alchemy.javachallenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emd.alchemy.javachallenge.model.StudentCourse;
import emd.alchemy.javachallenge.repo.IStudentCourseRepo;
import emd.alchemy.javachallenge.service.IStudentCourseService;


@Service
public class StudentCourseServiceImpl implements IStudentCourseService{

	@Autowired
	private IStudentCourseRepo repo;
	
	@Override
	public List<StudentCourse> listCoursesPerStudent(Integer studentId) {
		
		return repo.listCoursesPerStudent(studentId);
	}

}
