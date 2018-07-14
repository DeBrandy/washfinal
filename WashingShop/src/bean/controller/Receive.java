package bean.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.client.MultipartBodyBuilder.PublisherEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import bean.daoclass.Client;
import bean.daoclass.Cloth;
import bean.daoclass.Order;
import bean.service.AdminService;


@Controller
public class Receive {
	private AdminService service = new AdminService();
	private List<Cloth> clothes ;  
	java.util.Date date = new java.util.Date();
	private String applicationoid = new SimpleDateFormat("yyyyMMDD").format(date);
	private double Discount = 1;
	
	
	//根据输入的电话号码,获取信息:姓名,余额,等级,未取件单号,总消费,地址
	//返回到receive.jsp,填写信息
	@RequestMapping(value="#")
	public String selectById(@RequestParam("Cid")String Cid,Model model){
		Discount = 1;   //每次输入电话,将折扣设为1
		Client client;
		client = service.selectInfoByNumber(Cid);
		Discount = client.getDiscount();    //设置当前折扣
		model.addAttribute("client", client);
	    clothes.clear();    //每次输入电话时,清空衣物集合
		return "receive";
	}
	//创建一条衣物信息,并加入clothes集合
	//清空文本框内容(在jsp中实现)
	@RequestMapping(value="#")
	public String cloth(Model model,@RequestParam("Type") String Type,
			@RequestParam("Clo")String Clo,@RequestParam("Mat")String Mat,@RequestParam("Color")String Color,
			@RequestParam("Brand")String Brand,@RequestParam("Flaw")String Flaw,@RequestParam("Add")String Add,
			@RequestParam("Price")double Price,@RequestParam("Id")String Id){
		//Oid,Id,Type,Clo,Mat,Color,Brand,Flaw,Add
		
		Cloth cloth = service.buildCloth(Type, Clo, Mat, Color, Brand, Flaw, Add,Price,Discount,Id);   
		
		clothes.add(cloth);         //加入集合,但不写入数据库
		model.addAttribute("cloth", cloth);
		return "receive";
	}
	//创建订单
	@RequestMapping(value="#")
	public String order(Model model,@RequestParam("Cid") String Cid){
		applicationoid  = service.isToday(applicationoid);
		//System.out.println(Oid);
		Order order = service.buildOrder(Cid,clothes,applicationoid);
		return "receive";
	}
	//打印票据  手机号,单据号,衣服数量,日期
	@RequestMapping(value="#")
	public String sprintOrder(Model model,@RequestParam("Cid") String Cid){
		Order order = service.printOrder(Cid,applicationoid,clothes.size());
		
		model.addAttribute("order", order);
		return "receive";
	}
	//取件
	@RequestMapping(value="#")
	public String getClothes(Model model,@RequestParam("Oid")String Oid){
		service.selectOrderByOrderid(Oid);
		model.addAttribute("statue", "OK");
		return "deliver";
	}
	//这是一个测试类,试试能不能用浏览器打开,个人认为url是这样的,各位看看有没有错
	//localhost:8080/WashingShop/test
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(){
		
		return "receive";
	}

}
