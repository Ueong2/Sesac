package dev.syntax.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // Book.java 클래스를 Book Table로 관리되도록 명시
@Table(name = "BOOKS")
public class Book {

	@Id // 이 필드를 Books 테이블의 기본키로 동작하도록 지정
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // My-sql은 IDENTITY Oracle은 SEQUENCE
	private int id;

	@Column(name = "book_name", nullable = false)
	private String bookName;

	private String author;

	@Temporal(TemporalType.TIMESTAMP) // util.date, util.Calendar 맵핑 시 사용
	/**
	 * TemporalType.DATE: 날짜, DB의 date 타입과 맵핑 (ex. 2022-03-03) TemporalType.DATE:
	 * 날짜, DB의 date 타입과 맵핑 (ex. 09:30:23) TemporalType.TIMESTAMP: 날짜와 시간, DB의
	 * timestamp 타입과 맵핑(ex.2022-12-27 09:53:34)
	 */
	@Column(name = "pub_date")
	private Date pubDate;

	// 기본 생성자는 public이 아닌 protected로
	protected Book() {
		super();
		System.out.println("Default Constructor book() called");
	}

	public Book(String bookName, String author, Date pubDate) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.pubDate = pubDate;
	}

	public int getId() {
		return id;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void updateBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", bookName=" + bookName + "]";
	}

}
