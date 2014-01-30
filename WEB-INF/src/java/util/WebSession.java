package util;

import com.opensymphony.xwork2.ActionContext;

public class WebSession {

	
	public static void put(String key, Object value){
		ActionContext.getContext().getSession().put(key, value);
	}
	
	public static Object get(String key){
		return ActionContext.getContext().getSession().get(key);
	}
	
	public static void remove(String key){
		ActionContext.getContext().getSession().remove(key);
	}
	
	public static boolean containsKey(String key){
		return ActionContext.getContext().getSession().containsKey(key);
	}
	
	public static void clear(){
		ActionContext.getContext().getSession().clear();
	}
}
	

