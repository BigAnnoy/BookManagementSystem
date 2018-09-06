package biz;

import java.io.Serializable;
import java.util.Map;

/**
 * 所有业务的通用操作
 * @author BigAnnoy
 *Last_update	2018年9月6日下午2:37:20
 *
 */
public interface Biz<T> extends Serializable{
	/*
	 * 通用添加方法
	 */
	public boolean add(T t);
	
	public boolean del(T t);
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	public T update(T t);
	
	/**
	 * 查找
	 * @param id
	 * @return
	 */
	public T findById(String id);
	
	public Map<String,T> findAll();
}
