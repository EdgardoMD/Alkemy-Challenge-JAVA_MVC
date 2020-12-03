package emd.alchemy.javachallenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emd.alchemy.javachallenge.model.Student;
import emd.alchemy.javachallenge.repo.IStudentRepo;
import emd.alchemy.javachallenge.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepo repo;
	
	@Override
	public Student save(Student student) {
		
		return repo.save(student);
	}

	@Override
	public Student edit(Student student) {
		
		return repo.save(student);
	}

	@Override
	public List<Student> listAll() {
		
		return repo.findAll();
	}

	@Override
	public Student findById(Integer studentId) {
		
		return repo.getOne(studentId);
	}

	@Override
	public boolean delete(Integer studentId) {
		
		repo.deleteById(studentId);
		return true;
	}

}
