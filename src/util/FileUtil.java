package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import entity.BookInfo;

/**
 * 文件工具类
 * @author BigAnnoy
 *Last_update	2018年9月6日下午1:21:23
 *
 */
public class FileUtil {
	//	以对象流方式存储
	
	private static final String BookInfoFilePath = "BookInfo.dat";
	
	
	/**
	 * 将传入的BookInfo的map信息存储在文件中
	 * @param bookInfoMap
	 */
	public static void SaveBookInfoMap(Map<String, BookInfo> bookInfoMap) {
		SaveObj(bookInfoMap, BookInfoFilePath);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, BookInfo> loadBookInfoMap(){
		Object object = LoadObj(BookInfoFilePath);
		if(null == object) return null;
		return (Map<String, BookInfo>)object;
	}
	
	/**
	 * 通用对象保存方法
	 * @param obj
	 * @param filePath
	 */
	public static void SaveObj(Object obj,String filePath) {
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath,false))) {
		objectOutputStream.writeObject(obj);
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	/**
	 * 通用对象读取方法
	 * @param filePath
	 * @return
	 */
	public static Object LoadObj(String filePath) {
		try(FileInputStream fInputStream = new FileInputStream(filePath);
				ObjectInputStream inputStream = new ObjectInputStream(fInputStream);
						){
			return inputStream.readObject();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

