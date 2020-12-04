package emd.alchemy.javachallenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emd.alchemy.javachallenge.model.Schedule;
import emd.alchemy.javachallenge.repo.IScheduleRepo;
import emd.alchemy.javachallenge.service.IScheduleService;

@Service
public class ScheduleServiceImpl implements IScheduleService{
	
	@Autowired
	private IScheduleRepo repo;

	@Override
	public Schedule save(Schedule schedule) {
		
		return repo.save(schedule);
	}

	@Override
	public Schedule edit(Schedule schedule) {
		
		return repo.save(schedule);
	}

	@Override
	public List<Schedule> listAll() {
		
		return repo.findAll();
	}

	@Override
	public Schedule findById(Integer scheduleId) {
		Optional<Schedule> op = repo.findById(scheduleId);
		return op.isPresent() ? op.get() : new Schedule();
	}

	@Override
	public boolean delete(Integer scheduleId) {
		
		repo.deleteById(scheduleId);
		return true;
	}

	@Override
	public List<Schedule> findByCourseId(Integer courseId) {
		
		return repo.findByCourseId(courseId);
	}

	@Override
	public List<Schedule> listAllOrderByCourseIdAsc() {
		
		return repo.listAllOrderByCourseIdAsc();
	}
	

}
