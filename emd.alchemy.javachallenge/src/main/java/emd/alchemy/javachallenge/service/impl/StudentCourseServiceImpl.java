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
	public List<StudentCourse> findByStudentId(Integer studentId) {
		
		return repo.findByStudentId(studentId);
	}

	@Override
	public Integer register(Integer studentId, Integer courseId) {
		
		return repo.register(studentId, courseId);
	}

	@Override
	public StudentCourse save(StudentCourse studentCourse) {
		
		return repo.save(studentCourse);
	}

	@Override
	public StudentCourse findOnebyCourseId(Integer courseId) {
		
		return repo.findOnebyCourseId(courseId);
	}

}
