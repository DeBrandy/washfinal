package bean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Receive {
	//根据输入的电话号码,获取信息:姓名,余额,等级,未取件单号,总消费,地址
	//返回到receive.jsp,填写信息
	@RequestMapping(value="#")
	public String selectById(String number){
		
		return "receive";
	}
	
	
	//打印票据
	@RequestMapping(value="#")
	public String sprintOrder(){
		return "";
	}
	//取件
	@RequestMapping(value="#")
	public String getClothes(String number){
		selectOrderByOrderid(number);
		return "";
	}

}
