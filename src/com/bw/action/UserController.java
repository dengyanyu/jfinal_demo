package com.bw.action;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.bw.common.UserInterceptor;
import com.bw.model.MyVo;
import com.bw.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.upload.UploadFile;

public class UserController extends Controller{
	public void list() {
		setAttr("list", User.me.find("select * from b_user"));
	}
//	@Clear(value=UserInterceptor.class)
	@Before(value=UserInterceptor.class)
	public void page() {
//		pageNumber;			
//		pageSize;
//		Page pa = getBean(Page.class,"page");
		String fromsql=" from b_user where 1=1 ";
		String username = getPara("username");
		String password = getPara("password");
		ArrayList<String> params=new ArrayList<String>();
		if (username!=null&&!"".equals(username)) {
			fromsql+=" and username=? ";
			params.add(username);
		}
		if (password!=null&&!"".equals(password)) {
			fromsql+=" and password=? ";
			params.add(password);
		}
		
		setAttr("page", User.me.paginate(getParaToInt("pn",1), getParaToInt("ps",5),
				"select *", fromsql,params.toArray()));
		keepPara();//保持参数
	}
	
	public void toadd(){}
	public void add(){
		getModel(User.class).save();
		redirect("/user/list");
	}
	public void update(){
		//set put区别 set之后update可以更新 put只是当作map用用来放值
		User.me.findById(getPara("id")).set("username", getPara("username")).update();
//		renderFreeMarker("/user/success.ftl");
	}
	public void d(){///??图片下载失败
		
		getResponse().setContentType("application/msword");
		renderFile(new File("download/1.doc"));
	}
	
	public void toupload() {
		
	}
	
	public void upload() {
		List<UploadFile> fs = getFiles();
		ArrayList<String> filelist=new ArrayList();
		for (UploadFile f : fs) {
			filelist.add(f.getFile().getName());
		}
		setAttr("filelist", filelist);
		System.err.println(getPara("name"));
		
	}
	
	public void getvo() {
//		getRequest();
//		getSession();
//		getResponse();
//		getCookie("jseesionid");
//		getFile("f");
		MyVo vo = getBean(MyVo.class);
		renderJson(vo);
	}
	public void qr() {
		renderQrCode(getPara("nr"), 400, 400);
	}
	
	public void getUser() {
		User u = User.me.findById(getPara("id"));
		u.put("nofiled", Math.random()+"");
		renderJson(u);
	}
	
	
	public void update1(){
		//set put区别 set之后update可以更新 put只是当作map用用来放值
		User.me.findById(getPara("id")).set("username1", getPara("username")).update();
//		renderFreeMarker("/user/success.ftl");
	}
	
	
	public void getUser1() {
		User u = User.me.findById(getPara("id"));
		setAttr("code", 200);
		setAttr("msg", "操作成功");
		setAttr("data", u);
		renderJson();
	}
	
	public void teacherlist() {
		renderJson(Db.find("select * from i_teacher"));
	}
	
	
	public void list1() {
		setAttr("list", User.me.find("select * from b_user"));
		renderVelocity("list1.vm");
	}
	
	public void tologin() {
		
	}
	@Before(value=LoginValidator.class)
	public void login() {

	}
	public void screen() {
	}
	/*public void d2() throws AWTException, IOException{///??图片下载失败
		
		 //把截图写出去
		getResponse().setContentType("application/msword");
		
		//截图
		Robot robot = new Robot();
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的尺寸
		 BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, 
				 screenSize.width,screenSize.height));//截取整个屏幕的图像
//		 File f = new File("download/1.png");
		 ImageIO.write(image, "png", getResponse().getOutputStream());
		 
		
//		renderFile(f);
	}*/
	
	
}
