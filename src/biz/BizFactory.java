package biz;

import biz.impl.BookInfoBizImpl;

/**
 * 
 * @author BigAnnoy
 *Last_update	2018年9月6日下午4:26:52
 *
 */
public class BizFactory {
	public static Biz getBiz(String bizname){
		switch (bizname.toLowerCase()) {
		case "bookinfobiz":
			return new BookInfoBizImpl();
		default:
			return null;
		}
		
		
	}
}
