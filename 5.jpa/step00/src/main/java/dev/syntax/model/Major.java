package dev.syntax.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity // JPA 엔터티임을 나타냄
public class Major {
	@Id // id 필드가 엔터티의 주식별자(Primary key)임을 설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // id 값을 Sequence로 생성
	@JoinColumn(name = "MAJOR_ID")	// 외래키(조인 컬럼) 설정
	private int id;
	
	private String majorName;

	public Major(int id, String majorName) {
		super();
		this.id = id;
		this.majorName = majorName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", majorName=" + majorName + "]";
	}
	
	
}
