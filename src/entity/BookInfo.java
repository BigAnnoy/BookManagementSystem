package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 图书信息，以ISBN为主键的图书信息类。每个ISBN对应多个实际存在的图书对象。
 * @author BigAnnoy
 *Last_update	2018年9月1日下午9:01:34
 *
 */
public class BookInfo implements Serializable{
	
	private static final long serialVersionUID = 2874804143906647659L;
	private String isbn;
	private String type;
	private String publisher;
	private String author;
	private int inStoreCount;
	private Date publishDate;
	private double price;
	private String name;
	private List<Book> bookList;
	//构造方法 toString equals
	
	/**
	 * 向本ISBN图书中添加实体
	 * @param book
	 */
	public void addBook(Book book) {
		if(null == bookList) bookList = new ArrayList<>();
		if(null == book) return;
		if(!isbn.equals(book.getIsbn())) return;
		if(bookList.contains(book)) return;
		bookList.add(book);
		book.setBookInfo(this);
	}
	
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setType(String type) {
		this.type = type;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getInStoreCount() {
		return inStoreCount;
	}
	public void setInStoreCount(int inStoreCount) {
		this.inStoreCount = inStoreCount;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
