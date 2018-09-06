package test;

import java.util.HashMap;
import java.util.Map;

import entity.Book;
import entity.BookInfo;
import util.FileUtil;

/**
 * 
 * @author BigAnnoy
 *Last_update	2018年9月6日下午1:05:30
 *
 */
public class testBook {
	public static void main(String[] args) {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123");
		bookInfo.setName("Java");
		
		Book book = new Book();
		book.setIsbn("123");
		
		bookInfo.addBook(book);
		
		Map<String, BookInfo> infoMap = new HashMap<>();
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(infoMap);
		System.out.println(book.getBookInfo().getName());
		
		infoMap = FileUtil.loadBookInfoMap();
		System.out.println("从文件中读取到到信息");
		for(String isbn:infoMap.keySet()) {
			System.out.println(isbn);
		}
	}
}
