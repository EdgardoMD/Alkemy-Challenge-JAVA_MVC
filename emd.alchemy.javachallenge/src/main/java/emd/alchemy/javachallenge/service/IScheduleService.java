package emd.alchemy.javachallenge.service;

import java.util.List;

import emd.alchemy.javachallenge.model.Schedule;

public interface IScheduleService {
	
	Schedule save (Schedule schedule);
	Schedule edit (Schedule schedule);
	List<Schedule> listAll ();
	Schedule findById (Integer scheduleId);
	boolean delete (Integer scheduleId);

}
