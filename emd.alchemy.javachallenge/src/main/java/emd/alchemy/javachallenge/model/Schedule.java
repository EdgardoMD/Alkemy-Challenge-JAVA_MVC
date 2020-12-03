package emd.alchemy.javachallenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {
	
	@Id
	private Integer scheduleId;
	
	@Column(name = "time", nullable = false)
	private String time;
	
	@Column(name = "day", nullable = false)
	private String day;
	
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false, foreignKey = @ForeignKey(name = "FK_course_schedule"))
	private Course course;

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
