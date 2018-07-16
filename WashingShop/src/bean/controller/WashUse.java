package bean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bean.service.WashUseService;;
@Controller

public class WashUse {
	@Autowired
	public WashUseService wash;
	
	//显示所有商品
	@RequestMapping(value="#")//表格的aciton是value的值
	public String findAll(Model model)
	{
		
		
		model.addAttribute("six",wash.findAll());
		return "tools";
		
	}
	
	//按名称查找一个商品
	@RequestMapping(value="#")
	public String findOne(@RequestParam("Uname")String Uname,Model model)
	{
		
		model.addAttribute("two",wash.findOne(Uname));
		return "tools";
		
	}
	
	//修改商品
	@RequestMapping(value="#")
	public String update(@RequestParam("Uname_1")String Uname_1,@RequestParam("Uname_2")String Uname_2,@RequestParam("num")int num)
	{
		wash.update(Uname_1, Uname_2, num);
		return "tools";
		
	}
	
	//插入一个新的商品
	@RequestMapping(value="#")
	public String insert(@RequestParam("Uname")String Uname,@RequestParam("num")int num)
	{
		
		wash.insert(Uname, num);
		return "tools";
	}
	
	//删除一个用户
	@RequestMapping(value="#")
	public String delete(@RequestParam("Uname")String Uname)
	{
		
		wash.delete(Uname);
		return "tools";
	}	
	
}
