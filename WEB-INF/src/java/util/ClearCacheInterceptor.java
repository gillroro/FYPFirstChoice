package util;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import entity.Employee;

public class ClearCacheInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> sessionAttributes = invocation.getInvocationContext().getSession();
		Employee employee = (Employee) sessionAttributes.get("employee");
		if(employee == null){
			return Action.LOGIN;
		}
		else{
			return invocation.invoke();
		}
		
	}

}
