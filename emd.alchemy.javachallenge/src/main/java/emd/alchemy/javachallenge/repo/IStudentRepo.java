package emd.alchemy.javachallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import emd.alchemy.javachallenge.model.Student;


public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
