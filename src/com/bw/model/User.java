package com.bw.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
//model
public class User extends Model<User>{
	
	/*
	public String getPassword() {
		return this.get("password");
	}
	public void setPassword(String password) {
		this.set("password", password);
	}
	 */
	
	
	public static final User me=new User();//单例
	public List<Card> listCardList() {
		return Card.me.find("select * from b_card where userid=?",this.get("id")+"");
	}
}
