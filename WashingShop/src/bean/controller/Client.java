package bean.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bean.service.MemberService;
@Controller

public class Client {
	@Autowired
	public MemberService client;
	//查找所有用户
	@RequestMapping(value="#")//表格的aciton是value的值
	public String findAll(Model model)
	{
		
		
		model.addAttribute("one",client.findAll());
		return "member";
		
	}
	
	//按手机号查找一个用户
	@RequestMapping(value="#")
	public String findOne(@RequestParam("Cid")String Cid,Model model)
	{
		
		model.addAttribute("two",client.findOne(Cid));
		return "member";
		
	}
	
	//修改用户信息
	@RequestMapping(value="#")
	public String update(@RequestParam("Cid_1")String Cid_1,@RequestParam("Cid_2")String Cid_2,
			@RequestParam("Cname")String Cname,	@RequestParam("Csex")String Csex,@RequestParam("Cad")String Cad)
	{
		client.update(Cid_1, Cid_2, Cname, Csex, Cad);
		return "member";
		
	}
	
	//插入一个用户
	@RequestMapping(value="#")
	public String insert(@RequestParam("Cid")String Cid,@RequestParam("Cname")String Cname,	@RequestParam("Csex")String Csex,@RequestParam("Cad")String Cad,@RequestParam("amount")double amount)
	{
		
		client.insert(Cid, Cname, Csex, Cad, amount);
		return "member";
	}
	
	//删除一个用户
	@RequestMapping(value="#")
	public String delete(@RequestParam("Cid")String Cid)
	{
		
		client.delete(Cid);
		return "member";
	}	
	//充值
	@RequestMapping(value="#")
	public String invest(@RequestParam("Cid")String Cid,@RequestParam("amount")double amount)
	{
		
		client.invest(Cid, amount);
		return "member";
	}	
	//按照卡号排序
	@RequestMapping(value="#")
	public String sortByCid(Model model)
	{
		
		model.addAttribute("three",client.sortByCid());
		return "member";
	}
	//按照余额排序
	@RequestMapping(value="#")
	public String sortByCba(Model model)
	{
		
		model.addAttribute("four",client.sortByCba());
		return "member";
	}	
	//按照总消费排序
	@RequestMapping(value="#")
	public String sortByCcost(Model model)
	{
		
		model.addAttribute("five",client.sortByCcost());
		return "member";
	}	
	
	
}
