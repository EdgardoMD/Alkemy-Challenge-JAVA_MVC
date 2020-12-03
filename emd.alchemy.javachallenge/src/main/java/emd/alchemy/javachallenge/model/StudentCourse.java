package emd.alchemy.javachallenge.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "students_courses")
@IdClass(StudentCoursePK.class)
public class StudentCourse {
	
	@Id
	private Student student;
	
	@Id
	private Course course;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
