package bean.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bean.daoclass.Cloth;
import bean.service.AdminService;

public class Clothes {
	
	//private List<Cloth> clothes ;	
	
	@Autowired
	private AdminService service;
    
	//show衣物：操作员通过查询衣物的状态（0：已经洗好 /1：未洗好），将衣物信息显示出来。
	@RequestMapping(value="/show")
	public String showClothes(Model model,@RequestParam("Statue")int Statue,List<Cloth> clothes)
	{	
		//int num,i;
		clothes= service.ShowclothBystatus(Statue );
		//num = clothes.size();
		
		//把最后得到的list对象传到jsp页面，jsp页面再用<c:forEach> </c:forEach>输出即可
		model.addAttribute(clothes);
		
		/*
		 * private String Oid,Id,Type,Clo,Mat,Color,Brand,Flaw,Add;//订单号,挂衣号,服务类型,服务项目,材质,颜色,品牌,瑕疵,备注要求
		   private double Price,Dprice;  //价格,折后价
		   private int Statue;  //衣物状态
		 * */
		/*
		for (i = 0; i < num; i++) {	
			clothes.get(i).getOid();			
			clothes.get(i).getId();	
			clothes.get(i).getType();	
			clothes.get(i).getClo();
			clothes.get(i).getMat();
			clothes.get(i).getColor();
			clothes.get(i).getBrand();
			clothes.get(i).getFlaw();
			clothes.get(i).getAdd();
			clothes.get(i).getPrice();
			clothes.get(i).getDprice();
			clothes.get(i).getStatue();								
	        }*/
		return "clothes";
    }
	
	//管理衣物：将已经洗好的衣服状态改为已洗好
	@RequestMapping(value="/manage")
	public String manageCloth(Model model,@RequestParam("Id")String Id)
	{
		service.MoodifyClothStatueByID(Id);		
		return "clothes";
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String text(){
		
		return "clothes";
	}
	

}
	
