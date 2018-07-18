package bean.controller;
import java.util.ArrayList;
import java.util.List;

import bean.daoclass.Client;
import bean.daoclass.WashUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import bean.service.WashUseService;;
@Controller
@RequestMapping("/Tools")
@SessionAttributes({"six","seven","client_2"})
public class Tools {
	@Autowired
	public WashUseService wash;
	
	//显示所有商品
	@RequestMapping("/findAll")//表格的aciton是value的值
	public String findAll(Model model)
	{
		
		
		
		
		
		model.addAttribute("six",wash.findAll());
		
		model.addAttribute("client_2",wash.findAll());
		return "tools";
		
	}
	
	//按名称查找一个商品
	
	@RequestMapping("/findOne")
	public String findOne(@RequestParam("Uname")String Uname,Model model)
	{
		List<WashUse> one = new ArrayList<WashUse>();
		model.addAttribute("seven",wash.findOne(Uname));
		one.add(wash.findOne(Uname));
		model.addAttribute("client_2",one);
		return "tools";
		
	}
	
	//修改商品
	@RequestMapping("/update")
	public String update(@RequestParam("Uname_1")String Uname_1,@RequestParam("Uname_2")String Uname_2,@RequestParam("num")int num)
	{
		wash.update(Uname_1, Uname_2, num);
		return "tools";
		
	}
	
	//插入一个新的商品
	@RequestMapping("/insert")
	public String insert(@RequestParam("Uname")String Uname,@RequestParam("num")int num)
	{
		
		wash.insert(Uname, num);
		return "tools";
	}
	
	//删除一个用户
	@RequestMapping("/delete")
	public String delete(@RequestParam("Uname")String Uname)
	{
		
		wash.delete(Uname);
		return "tools";
	}
	@RequestMapping(value="/test")
	public String test(){
		
		return "tools";
	}
	
}
