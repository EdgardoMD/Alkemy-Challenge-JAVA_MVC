package emd.alchemy.javachallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import emd.alchemy.javachallenge.model.Professor;


public interface IProfessorRepo extends JpaRepository<Professor, Integer> {

}
