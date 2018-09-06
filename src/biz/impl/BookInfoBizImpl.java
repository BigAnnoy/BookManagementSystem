package biz.impl;

import java.util.Map;



import biz.BookInfoBiz;
import entity.BookInfo;
import util.FileUtil;

/**
 * 
 * @author BigAnnoy
 *Last_update	2018年9月6日下午2:57:12
 *
 */
public class BookInfoBizImpl implements BookInfoBiz{
	private static final long serialVersionUID = 9037837534982285936L;

	@Override
	public boolean add(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		//获得Map
		//向Map中添加Bookinfo
		//写回Map
		if (null == bookInfo) return false;
		Map<String,BookInfo> bookInfoMap = findAll();
		if(bookInfoMap.containsKey(bookInfo.getIsbn())) {
			return false;
		}
		bookInfoMap.put(bookInfo.getName(), bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public boolean del(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		if (null == bookInfo) return false;
		Map<String,BookInfo> bookInfoMap = findAll();
		if(!bookInfoMap.containsKey(bookInfo.getIsbn())) return false;
		bookInfoMap.remove(bookInfo.getIsbn());
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public BookInfo update(BookInfo bookInfo) {
		if (null == bookInfo) return null;
		Map<String,BookInfo> bookInfoMap = findAll();
		if(!bookInfoMap.containsKey(bookInfo.getIsbn())) return null;
		bookInfoMap.put(bookInfo.getIsbn(),bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return bookInfo;
	}

	@Override
	public BookInfo findById(String id) {
		throw new UnsupportedOperationException("BookInfoBiz不支持根据id查询操作");
	}

	@Override
	public Map<String, BookInfo> findAll() {
		return FileUtil.loadBookInfoMap();
	}

	@Override
	public boolean outStore(String isbn, int outCount) {
		
		BookInfo bookInfo = findById(isbn);
		if(bookInfo == null) return false;
		Map<String,BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		if(outCount>bookInfo.getInStoreCount()) return false;//出库数量大于库存
		bookInfo.setInStoreCount(bookInfo.getInStoreCount()-outCount);
		bookInfoMap.put(isbn, bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public boolean inStore(String isbn, int inCount) {
		BookInfo bookInfo = findById(isbn);
		if(bookInfo == null) return false;
		Map<String,BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		bookInfo.setInStoreCount(bookInfo.getInStoreCount()+inCount);
		bookInfoMap.put(isbn, bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public BookInfo findByIsbn(String isbn) {
		if(isbn==null|| isbn.equals("")) return null;
		Map<String,BookInfo> bookInfoMap = findAll();
		if(!bookInfoMap.containsKey(isbn)) return null;
		return bookInfoMap.get(isbn);
	}

}
