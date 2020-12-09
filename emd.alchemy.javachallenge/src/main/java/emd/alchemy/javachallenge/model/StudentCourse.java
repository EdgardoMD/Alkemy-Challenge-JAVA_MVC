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
	
	

	public StudentCourse() {
	}
	
	public StudentCourse(Student student, Course course) {
		this.student = student;
		this.course = course;
	}

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

	@Override
	public String toString() {
		return "StudentCourse [student=" + student + ", course=" + course + "]";
	}
}
