package biz;

import entity.BookInfo;

/**
 * 图书业务类接口
 * 增删改查
 * @author BigAnnoy
 *Last_update	2018年9月6日下午2:35:37
 */
public interface BookInfoBiz extends Biz<BookInfo>{
	/**
	 * 图书出库
	 * @param isbn
	 * @param outCount
	 * @return
	 */
	public boolean outStore(String isbn , int outCount);
	
	/**
	 * 图书入库
	 * @param isbn
	 * @param inCount
	 * @return
	 */
	public boolean inStore(String isbn , int inCount);
	public BookInfo findByIsbn (String isbn);
}

