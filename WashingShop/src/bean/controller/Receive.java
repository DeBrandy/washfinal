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
	public String selectById(@RequestParam("Cid")String Cid,Model model){
		Client client;
		client = service.selectInfoByNumber(Cid);
		model.addAttribute("client", client);
	    clothes.clear();    //每次输入电话时,清空衣物集合
		return "receive";
	}
	//创建一条衣物信息,并加入clothes集合
	@RequestMapping(value="#")
	public String cloth(Model model,@RequestParam("Type") String Type,
			@RequestParam("Clo")String Clo,@RequestParam("Mat")String Mat,@RequestParam("Color")String Color,
			@RequestParam("Brand")String Brand,@RequestParam("Flaw")String Flaw,@RequestParam("Add")String Add){
		//Oid,Id,Type,Clo,Mat,Color,Brand,Flaw,Add
		
		Cloth cloth = new Cloth();
		service.buildCloth(Type, Clo, Mat, Color, Brand, Flaw, Add);
		clothes.add(cloth);
		model.addAttribute("cloth", cloth);
		return "receive";
	}
	//创建订单
	@RequestMapping(value="#")
	public String order(Model model){
		//service.buildOrder(client, clothes, date);
		return "receive";
	}
	//打印票据
	@RequestMapping(value="#")
	public String sprintOrder(Order order,Model model){
		service.printOrder(order);
		
		model.addAttribute("order", order);
		return "receive";
	}
	//取件
	@RequestMapping(value="#")
	public String getClothes(@RequestParam("Oid")String Oid){
		service.selectOrderByOrderid(Oid);
		return "deliver";
	}

}
