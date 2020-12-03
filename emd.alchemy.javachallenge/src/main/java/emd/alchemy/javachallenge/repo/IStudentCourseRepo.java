package emd.alchemy.javachallenge.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import emd.alchemy.javachallenge.model.StudentCourse;


public interface IStudentCourseRepo extends JpaRepository<StudentCourse, Integer> {
	
	@Modifying
	@Query(value = "INSERT INTO students_courses(student_id, course_id) VALUES (:studentId, :courseId)", nativeQuery = true)
	Integer register(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);
	
	@Query("from StudentCourse sc where sc.student.studentId = :studentId")
	List<StudentCourse> listCoursesPerStudent(@Param("studentId") Integer studentId);

}
