package emd.alchemy.javachallenge.service;

import java.util.List;

import emd.alchemy.javachallenge.model.Professor;

public interface IProfessorService {
	
	Professor save (Professor professor);
	Professor edit (Professor professor);
	List<Professor> listAll ();
	Professor findById (Integer professorId);
	boolean delete (Integer professorId);

}
