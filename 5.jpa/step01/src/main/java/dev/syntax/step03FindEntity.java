package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class step03FindEntity {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
		
		EntityManager manager = factory.createEntityManager();
		
		try {
		Book book = manager.find(Book.class, 1); // id가 1인 Book 데이터 조회
		
		System.out.println(book);
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
