package dev.syntax.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(
        name="student_seq_gen", // 시퀀스 제너레이터 이름
        sequenceName="student_seq", // 시퀀스 이름
        initialValue=1, // 시작값
        allocationSize=1 // 메모리를 통해 할당할 범위 사이즈
        )
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="student_seq")
	private int id;
	
	private String studentName;
	
	/*
	 * 하나의 전공(1)은 여러 명의 학생(N)을 포함할 수 있다.
	 * 여러 명의 학생(N)은 하나의 전공(1)에 속할 수 있다.
	 */
	@ManyToOne // 여러 명의 학생(N)은 하나의 전공(1)에 속할 수 있다.
	@JoinColumn(name = "MAJOR_ID")
	private Major major;

	public Student(String studentName) {
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
