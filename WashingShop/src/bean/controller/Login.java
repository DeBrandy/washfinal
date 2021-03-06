package bean.controller;
import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.daoclass.Operator;
import bean.service.AdminService;
//import cn.itcast.a_hello.operator;

@Controller
@RequestMapping("/Login")
public class Login {
	

	@Autowired
	private AdminService service;

/*    
 	ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
 	operator ope =(operator) ac.getBean("ope");	
 */	

	@RequestMapping("/validLogin")
    public String login(@RequestParam("lname")String lname,@RequestParam("password")String password,Model model)
    {
		
	    Operator ope=service.equal();
		if(ope.getLname().equals(lname) && ope.getPassword().equals(password))
		{	
			model.addAttribute("ope", ope);  //加入到model数据类型中
			return "home";
		}
    	return "Login";//验证失败，跳转回登录界面
    }  
	
	//直接跳转
	@RequestMapping(value="/start")
	public String start(){
		
		return "Login";
	}

} 

