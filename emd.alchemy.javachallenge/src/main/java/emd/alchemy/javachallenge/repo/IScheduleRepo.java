package emd.alchemy.javachallenge.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import emd.alchemy.javachallenge.model.Schedule;


public interface IScheduleRepo extends JpaRepository<Schedule, Integer> {
	
	@Query("select s from Schedule s where s.course like %?1%")
	public List<Schedule> findByCourseId(Integer courseId);
	
	@Query(value ="select * from Schedules order by course_id ASC", nativeQuery = true)
	public List<Schedule> listAllOrderByCourseIdAsc();


}
