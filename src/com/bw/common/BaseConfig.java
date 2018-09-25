package com.bw.common;


import com.bw.plugin.RocketPlugin;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public abstract class BaseConfig extends JFinalConfig {
//	public static void main(String[] args) {
//		JFinal.start("WebRoot", 8080, "/",3);
//	}
	
	
	//路由 controller配置
	@Override
	public void configRoute(Routes me) {
//		me.add("/user",UserController.class);
	}

	//常量配置  基本配置
	@Override
	public void configConstant(Constants me) {
		me.setViewType(ViewType.JSP);//如果没有指定模板  默认jsp
		me.setViewExtension(".jsp");
	}
	//插件配置  目前主要是数据库
	@Override
	public void configPlugin(Plugins me) {
		PropKit.use("config");
		//德鲁伊连接池
		DruidPlugin dp = new DruidPlugin(PropKit.get("jdbcUrl"),
				PropKit.get("jdbcUserName"), PropKit.get("jdbcPwd"));
	    me.add(dp);
	    
	    //orm映射
	    ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
	    arp.setShowSql(true);//打印sql
	    mapping(arp);
//	    arp.addMapping("f_user", User.class);
	    me.add(arp);
	    
	    me.add(new RocketPlugin());
	}
	

	
	public abstract void mapping(ActiveRecordPlugin arp);

	@Override
	public void configEngine(Engine me) {
		
	}

	

	@Override
	public void configInterceptor(Interceptors me) {
		
	}

	@Override
	public void configHandler(Handlers me) {
		
	}

}
