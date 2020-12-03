package emd.alchemy.javachallenge.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import emd.alchemy.javachallenge.model.Course;



public interface ICourseRepo extends JpaRepository<Course, Integer> {
	
	@Query(value = "select * from courses order by course_name ASC", nativeQuery = true)
	List<Course> listAllCoursesOrderAsc();

}
