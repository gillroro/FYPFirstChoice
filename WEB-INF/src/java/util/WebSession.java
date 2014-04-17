package util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class WebSession {

	
	private static Map<String, Object> session;

	//Private constructor to prevent class being instantiated
	private WebSession(){

	}

	//Return session
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getWebSessionInstance(){
		session = ActionContext.getContext().getSession();
		return session;
	}

	
	@SuppressWarnings("unchecked")
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
	

