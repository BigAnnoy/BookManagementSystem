package entity;

import java.io.Serializable;

/**
 * 真实的图书对象
 * @author BigAnnoy
 *Last_update	2018年9月1日下午9:10:31
 *
 */
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 241828241514820628L;
	private String isbn;
	private String bookId;
	private BookState bookState;
	private BookInfo bookInfo;
	
	public boolean equals(Object obj) {
		if(null == obj) return false;
		if(!equals(obj instanceof Book)) return false;
		Book book = (Book)obj;
		return bookId.equals(book.getBookId());
	}
	
	
	


	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public BookState getBookState() {
		return bookState;
	}
	public void setBookState(BookState bookState) {
		this.bookState = bookState;
	}
	public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	
}

/**
 * 图书状态：可借 不可借 缺货 损坏
 * 
 * @author BigAnnoy
 *Last_update	2018年9月1日下午9:13:45
 *
 */
enum BookState{
	可借,不可借,缺货,损坏
}