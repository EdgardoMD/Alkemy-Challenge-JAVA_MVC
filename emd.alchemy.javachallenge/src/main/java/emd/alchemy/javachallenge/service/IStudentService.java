package emd.alchemy.javachallenge.service;

import java.util.List;

import emd.alchemy.javachallenge.model.Student;

public interface IStudentService {
	
	Student save (Student student);
	Student edit (Student student);
	List<Student> listAll ();
	Student findById (Integer studentId);
	boolean delete (Integer studentId);
	
	Student findByDni(String dni);

}
