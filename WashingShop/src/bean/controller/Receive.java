package bean.controller;

import java.util.List;

import org.springframework.http.client.MultipartBodyBuilder.PublisherEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.daoclass.Client;
import bean.daoclass.Cloth;
import bean.daoclass.Order;
import bean.service.AdminService;


@Controller
public class Receive {
	private AdminService service = new AdminService();
	private List<Cloth> clothes ;
	
	//根据输入的电话号码,获取信息:姓名,余额,等级,未取件单号,总消费,地址
	//返回到receive.jsp,填写信息
	@RequestMapping(value="#")
	public String selectById(String number,Model model){
		Client client;
		client = service.selectInfoByNumber(number);
		model.addAttribute("client", client);
	
		return "receive";
	}
	//创建一条衣物信息,并加入clothes集合
	@RequestMapping(value="#")
	public String cloth(Model model){
		//Oid,Id,Type,Clo,Mat,Color,Brand,Flaw,Add
		@RequestParam("type") String type;
		Cloth cloth = new Cloth();
		clothes.add(cloth);
		model.addAttribute("cloth", cloth);
		return "receive";
	}
	//打印票据
	@RequestMapping(value="#")
	public String sprintOrder(Order order,Model model){
		service.printOrder(order);
		
		model.addAttribute("order", order);
		return "";
	}
	//取件
	@RequestMapping(value="#")
	public String getClothes(String number){
		service.selectOrderByOrderid(number);
		return "";
	}

}
