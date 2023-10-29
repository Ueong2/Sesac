package dev.syntax;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.syntax.model.Book;

class step06PCLifeCycleTest {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
	
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction tx = manager.getTransaction();
	
	
	@Test
	@DisplayName("Persist를_수행할_경우_엔티티가_영속화되고_commit이_수행될_경우_DB에_저장된다")
	void Persist를_수행할_경우_엔티티가_영속화되고_commit이_수행될_경우_DB에_저장된다() {
		System.out.println("INSERT TEST");
		tx.begin();
		
		Book jpaBook = new Book("JPA", "무명", new Date());
		manager.persist(jpaBook);
		
		tx.commit();
		
		Book foundBook = manager.find(Book.class, jpaBook.getId());
		System.out.println(jpaBook == foundBook);
		assertEquals(jpaBook, foundBook);
	}
	
	@Test
	void 한번_영속화된_엔티티는_다시_조회시_DB가_아닌_영속성컨텍스트에서_조회된다() {
		System.out.println("SELECT TEST");
		int id = 6;
		
		Book foundBook = manager.find(Book.class,id);
		System.out.println(foundBook);
		
		Book foundBookTwice = manager.find(Book.class, id);
		assertEquals(foundBook, foundBookTwice);
	}
	
	@Test
	void 엔티티의_값을_수정하고_commit하면_변경감지가_발생되어_UPDATE쿼리가_수행된다() {
		System.out.println("UPDATE TEST1");
		int id = 6;
		tx.begin();
		Book foundBook = manager.find(Book.class, id);
		
		foundBook.updateBookName("ABC");
		
		tx.commit(); // flush() 수행 전 변경 감지(Dirty Checking)
	}
	
	@Test
	void 만약_엔티티를_detach할경우_필드의_값을_변경해도_UPDATE쿼리가_수행되지_않는다() {
		System.out.println("UPDATE TEST2");
		int id = 6;
		tx.begin();
		Book foundBook = manager.find(Book.class, id);
		
		foundBook.updateBookName("XYZ");
		manager.detach(foundBook);
		
		tx.commit();
		
		Book foundBookTwice = manager.find(Book.class, id);
		System.out.println(foundBook==foundBookTwice);
		
		assertNotEquals(foundBook,foundBookTwice);
	}
	
	@Test
	void remove를_수행할_경우_PC와_DB에서_데이터가_제거된다() {
		int id = 7;
		tx.begin();
		
		Book foundBook = manager.find(Book.class, id);
		manager.remove(foundBook);
		
		tx.commit(); // manager.flush()와의 차이
//		Book removedBook = manager.find(Book.class, foundBook);
//		
//		assertNull(removedBook);
		assertThrows(NullPointerException.class, () -> {
			Book jpaBook = manager.find(Book.class, foundBook.getId());
			jpaBook.updateBookName("Effective Unit Testing");
			
			assertFalse(foundBook == jpaBook);
			assertNull(jpaBook);
		});	
	}
	
	@Test
	void 영속성컨텍스트를_초기화할경우_모든_엔티티가_제거됨() {
		int id = 8;
		tx.begin();

		Book foundBook = manager.find(Book.class, id);
		manager.clear();
		Book foundBook2 = manager.find(Book.class, id);
		
		assertEquals(foundBook, foundBook2);
	}
	
	@Test
	void 엔티티매니저가_제거됨() {
		manager.close();
		EntityManager manager2 = factory.createEntityManager();
		assertEquals(manager, manager2);
		
	}
	
	@Test
	void 엔티티팩토리가_제거됨() {
		manager.close();
		factory.close();
		EntityManagerFactory factory2 = Persistence.createEntityManagerFactory("step01");
		
		assertEquals(factory,factory2);
	}
	
	@Test
	void 저장된_엔티티를_조회할_수_있는지_테스트() {
		tx.begin();
		
		Book newBook = new Book("새로운 책", "작가", new Date());
		manager.persist(newBook);
		
		tx.commit();
		
		int id = newBook.getId();
		Book foundBook = manager.find(Book.class, id);
		
		assertNotNull(foundBook);
		assertEquals("새로운 책", foundBook.getBookName());
	}
}
