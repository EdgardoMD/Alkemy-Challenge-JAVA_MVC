package emd.alchemy.javachallenge.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import emd.alchemy.javachallenge.model.StudentCourse;

public interface IStudentCourseService {
	
	List<StudentCourse> listCoursesPerStudent(@Param("studentId") Integer studentId);

}
