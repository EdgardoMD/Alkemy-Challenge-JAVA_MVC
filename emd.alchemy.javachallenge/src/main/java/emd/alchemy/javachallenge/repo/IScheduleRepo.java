package emd.alchemy.javachallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import emd.alchemy.javachallenge.model.Schedule;


public interface IScheduleRepo extends JpaRepository<Schedule, Integer> {

}
