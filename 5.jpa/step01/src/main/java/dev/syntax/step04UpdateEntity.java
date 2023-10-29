package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class step04UpdateEntity {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
		
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		try {
			
			Book book = manager.find(Book.class, 1); // id가 1인 Book 데이터 조회

			tx.begin(); // 실제 쿼리로 치면 BEGIN 프로시저 말하는건가?
			// book 데이터 수정
			book.updateBookName("컴퓨터 과학이 여는 세계");
			manager.persist(book);
			tx.commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();	// 작업이 끝나면 이렇게 닫아줘야 한다. (이런 코드 작성을 잊어버리는 경우가 많음)
			factory.close();	// 작업이 끝나면 이렇게 닫아줘야 한다. (이런 코드 작성을 잊어버리는 경우가 많음)
		}
	}
}
