package bean.controller;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bean.service.AdminService;


@Controller
public class Login {
	@RequestMapping("/validLogin")
    public String login(@RequestParam("lname")String lname,@RequestParam("password")String password,Model model)
    {
		
		
		
    	return "login";//验证失败，跳转回登录界面
    }
    
    
} 