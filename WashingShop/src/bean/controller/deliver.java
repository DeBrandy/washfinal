package bean.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import bean.daoclass.Order;
import bean.service.AdminService;

@Controller
public class deliver {
	@Autowired
	private AdminService service;
	//取件
	@RequestMapping(value="#")
	public String getClothes(Model model,@RequestParam("Oid")String Oid){
		Order order = service.selectOrderByOrderid(Oid);
		
		model.addAttribute("Order", order);
		return "deliver";
	}
}
