package bean.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import bean.service.AdminService;

@Controller
public class deliver {
	
	private AdminService service = new AdminService();
	//取件
	@RequestMapping(value="#")
	public String getClothes(Model model,@RequestParam("Oid")String Oid){
		service.selectOrderByOrderid(Oid);
		model.addAttribute("statue", "OK");
		return "deliver";
	}
}
