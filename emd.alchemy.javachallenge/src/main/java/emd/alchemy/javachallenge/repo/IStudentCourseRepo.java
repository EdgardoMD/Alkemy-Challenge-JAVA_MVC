package emd.alchemy.javachallenge.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import emd.alchemy.javachallenge.model.StudentCourse;


public interface IStudentCourseRepo extends JpaRepository<StudentCourse, Integer> {
	
	@Modifying
	@Query(value = "INSERT INTO students_courses(student_id, course_id) VALUES (:studentId, :courseId)", nativeQuery = true)
	@Transactional
	Integer register(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);
	
	@Query("select sc from StudentCourse sc where sc.student.studentId = :studentId")
	List<StudentCourse> findByStudentId(@Param("studentId") Integer studentId);
	
	@Query("select sc from StudentCourse sc where sc.course.courseId = :courseId")
	StudentCourse findOnebyCourseId(@Param("courseId") Integer courseId);


}
