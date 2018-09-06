package auth;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import biz.BizFactory;
import biz.BookInfoBiz;
import biz.impl.BookInfoBizImpl;
import entity.BookInfo;

/**
 * 
 * @author BigAnnoy
 *Last_update	2018年9月6日下午4:13:41
 *
 */
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1349253358801135380L;
	private String name; //显示名称
	private String key;//对应权限配置文件中的key
	private List<String> permissions;//	权限集合 保存在配置文件中
	private BookInfoBiz bookInfoBiz;
	
	public Role() {
		setName("默认角色");
		setKey("Default");
		//bookInfoBiz = new BookInfoBizImpl();
		//改为工厂模式
		bookInfoBiz = (BookInfoBiz) BizFactory.getBiz("BookInfoBiz");
	}
	
	public Role(String name,String key) {
		setName(name);
		setKey(key);
		//读取配置文件
		Properties props = new Properties();
		try {
			props.load(Role.class.getResourceAsStream("Role_Permission.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strPermission = props.getProperty(key);
		if(null == permissions) permissions = new ArrayList<>();
		permissions.clear();
		String[] permissionArray = strPermission.split(",");
		for(String permission:permissionArray) {
			if("".equals(permission)) continue;
			permissions.add(permission.trim());
			
		}
	}
	 
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	public BookInfoBiz getBookInfoBiz() {
		return bookInfoBiz;
	}
	public void setBookInfoBiz(BookInfoBiz bookInfoBiz) {
		this.bookInfoBiz = bookInfoBiz;
	}
	
	
	
	
}
