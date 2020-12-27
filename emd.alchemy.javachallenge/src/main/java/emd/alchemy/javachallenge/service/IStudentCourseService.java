package emd.alchemy.javachallenge.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import emd.alchemy.javachallenge.model.StudentCourse;

public interface IStudentCourseService {
	
	Integer register(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);
	
	List<StudentCourse> findByStudentId(@Param("studentId") Integer studentId);
	
	StudentCourse findOnebyCourseId(@Param("courseId") Integer courseId);
	
	StudentCourse findByCourseIdAndStudentId(@Param("courseId") Integer courseId, @Param("studentId") Integer studentId);
	
	StudentCourse save(StudentCourse studentCourse);
	
	

}
