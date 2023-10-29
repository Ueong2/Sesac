package dev.syntax.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String studentName;
	
	/*
	 * 하나의 전공(1)은 여러 명의 학생(N)을 포함할 수 있다.
	 * 여러 명의 학생(N)은 하나의 전공(1)에 속할 수 있다.
	 */
	@ManyToOne // 여러 명의 학생(N)은 하나의 전공(1)에 속할 수 있다. M:1 관계
	@JoinColumn(name = "MAJOR_ID")
	private Major major;

	public Student(int id, String studentName) {
		super();
		this.id = id;
		this.studentName = studentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}
	
	
	
}
