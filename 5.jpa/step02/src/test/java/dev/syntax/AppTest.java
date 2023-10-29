package dev.syntax;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dev.syntax.model.Major;
import dev.syntax.model.Student;

class AppTest {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step02");
	
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction tx = manager.getTransaction();
		
	
	@Test
	void testSave() {
		tx.begin();
		// 컴퓨터 공학과 생성 및 저장
		Major major1 = new Major("CS");
		manager.persist(major1);
		
		// 학생 2명 생성 및 저장
		Student student1 = new Student("Yoo");
		student1.setMajor(major1);
		manager.persist(student1);
		
		Student student2 = new Student("Kang");
		student2.setMajor(major1);
		manager.persist(student2);
		
		
		
		tx.commit();
	}
	
//	@Test
//	void testRead() {
//		int id = 1;
//		
//		Student student = manager.find(Student.class,id);
//		
//		System.out.println(student);
//	}
	
	@Test
	void testRead() {
		// id가 1인 학생 엔티티 조회
		Student student = manager.find(Student.class, 1);
		
		// 해당 학생의 전공 조회
		Major major = student.getMajor();
		System.out.println(major);
	}
	
	@Test
	void updateRelation() {
		// 한 명의 학생 조회 후 해당 학생의 전공을 다른 학과로 변경
		tx.begin();
		
		Student student = manager.find(Student.class, 1);
		
		Major newMajor = new Major("국문학과");
		manager.persist(newMajor);
		
		student.setMajor(newMajor);
		
		tx.commit();
	}
	
	@Test
	void deleteEntity() {
		// 한 명의 학생 조회 후 해당 학생의 전공을 제거(제적?)
		tx.begin();
		
		Student student = manager.find(Student.class, 1);
		student.setMajor(null); // 학생과 연관된 전공 제거
		
		Major major = manager.find(Major.class, 2); // 해당 전공 데이터도 제거
		manager.remove(major);
		
		tx.commit();
	}
	
}