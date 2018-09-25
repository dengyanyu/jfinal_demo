package com.bw.action;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {
    protected void validate(Controller c) {
       validateRequiredString("username", "username_msg", "请输入用户名");
       validateRequiredString("password", "password_msg", "请输入密码");
    }
    protected void handleError(Controller c) {
       c.keepPara("username");
       c.keepPara("password");
       c.render("tologin.jsp");
    }
}