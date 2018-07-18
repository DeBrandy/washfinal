package bean.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import bean.daoclass.Order;
import bean.service.AdminService;

@Controller
@RequestMapping(value="/deliver")
public class deliver {
	
	@Autowired
	private AdminService service;
	//取件  
	@RequestMapping(value="/do")
	public String getClothes(Model model,@RequestParam("Oid")String Oid){
		Order order = service.selectOrderByOrderid(Oid);
		
		model.addAttribute("Order", order);
		return "deliver";
	}
	@RequestMapping(value="/test")
	public String test(){
		
		return "deliver";
	}
}
