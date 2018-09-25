package com.bw;


import com.bw.action.UserController;
import com.bw.common.BaseConfig;
import com.bw.common.UserInterceptor;
import com.bw.model.Card;
import com.bw.model.User;
import com.jfinal.config.Interceptors;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

public class B02Config extends BaseConfig{
	public static void main(String[] args) {
		JFinal.start("WebContent", 8080, "/",3);
	}
	
	@Override
	public void configRoute(Routes me) {
		me.add("/user",UserController.class);
	}

	@Override
	public void mapping(ActiveRecordPlugin arp) {//映射表关系
		arp.addMapping("b_user",User.class);
		arp.addMapping("b_card",Card.class);
	}
	//拦截配置
	@Override
	public void configInterceptor(Interceptors me) {
//		me.add(new UserInterceptor());
	}
}
