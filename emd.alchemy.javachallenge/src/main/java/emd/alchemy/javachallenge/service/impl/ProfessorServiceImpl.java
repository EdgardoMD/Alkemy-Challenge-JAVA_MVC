package emd.alchemy.javachallenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emd.alchemy.javachallenge.model.Professor;
import emd.alchemy.javachallenge.repo.IProfessorRepo;
import emd.alchemy.javachallenge.service.IProfessorService;

@Service
public class ProfessorServiceImpl implements IProfessorService {

	@Autowired
	private IProfessorRepo repo;
	
	@Override
	public Professor save(Professor professor) {
		
		return repo.save(professor);
	}

	@Override
	public Professor edit(Professor professor) {
		
		return repo.save(professor);
	}

	@Override
	public List<Professor> listAll() {
		
		return repo.findAll();
	}

	@Override
	public Professor findById(Integer professorId) {
		Optional<Professor> op = repo.findById(professorId);
		return op.isPresent() ? op.get() : new Professor();
	}

	@Override
	public boolean delete(Integer professorId) {
		
		repo.deleteById(professorId);
		return true;
	}

}
