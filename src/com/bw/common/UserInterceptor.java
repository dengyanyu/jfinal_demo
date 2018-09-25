package com.bw.common;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class UserInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		Object userid = inv.getController().getSession().getAttribute("USERID");
		if (userid!=null) {
			inv.invoke();//交给下一个  如果没有调用就表明自己处理了
		}else {
			inv.getController().renderText("没有登陆");
		}
		
	}

}
