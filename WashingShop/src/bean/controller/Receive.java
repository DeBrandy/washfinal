package bean.controller;

import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value="/receive")
public class Receive {
	@Autowired
	private AdminService service;
	
	
	public List<Cloth> clothes = new ArrayList<Cloth>();  
	public String cidnow;
	public java.util.Date date = new java.util.Date();
	public String applicationoid = new SimpleDateFormat("yyyyMMdd").format(date) + "000";
	private double Discount = 1;
	private int number = 0;
	
	//根据输入的电话号码,获取信息:姓名,余额,等级,未取件单号,总消费,地址
	//返回到receive.jsp,填写信息
	@RequestMapping(value="/select")
	public String selectById(@RequestParam("Cid")String Cid,Model model){
		System.out.print(Cid);
		Discount = 1;   //每次输入电话,将折扣设为1
		number = 0;
		cidnow = Cid;
		Client client = new Client();
		client = service.selectInfoByNumber(Cid);
		
		Discount = client.getDiscount();    //设置当前折扣
		model.addAttribute("client", client);
	    clothes.clear();    //每次输入电话时,清空衣物集合
		System.out.println(applicationoid+"++++"+cidnow+"本次生成的单据号");
		return "receive";
	}
	
	//创建一条衣物信息,并加入clothes集合
	//清空文本框内容(在jsp中实现)
	@RequestMapping(value="/info")
	public String cloth(@RequestParam("Type") String Type,
			@RequestParam("Clo")String Clo,@RequestParam("Mat")String Mat,@RequestParam("Color")String Color,
			@RequestParam("Brand")String Brand,@RequestParam("Flaw")String Flaw,@RequestParam("Add")String Add,
			@RequestParam("Price")double Price,@RequestParam("Id")String Id,Model model){
		
		/*System.out.println("dfgdafgdsfg");
		System.out.println(Type);
		System.out.println(Clo);*/
		
		Cloth cloth = new Cloth();
		cloth = service.buildCloth(Type, Clo, Mat, Color, Brand, Flaw, Add,Price,Discount,Id);   
		number++;   //衣物数量+1
		clothes.add(cloth);         //加入集合,不加入数据库
		model.addAttribute("clothes", clothes);
		return "receive";
	}
	
	// 打印票据  手机号,单据号,衣服数量,日期
	@RequestMapping(value="/account")
	public String order(Model model){
		applicationoid  = service.isToday(applicationoid);
		System.out.println(applicationoid+"当前单据号");
		Order order = new Order();
		order = service.buildOrder(cidnow,applicationoid,number,clothes);
		model.addAttribute("order", order);
		return "receive";
	}	
	//直接跳转
	@RequestMapping(value="/test")
	public String test(){
		
		return "receive";
	}

}

