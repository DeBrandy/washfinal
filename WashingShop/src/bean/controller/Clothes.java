package bean.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bean.daoclass.Client;
import bean.daoclass.Cloth;
import bean.service.AdminService;

@Controller
@RequestMapping(value="/Clothes")
public class Clothes {
	
	private List<Cloth> clothes ;
//	private List<Cloth> ccloth ;	
	//private Cloth clo;
	@Autowired
	private AdminService service;
    
	//在页面上显示所有衣物信息，便于管理
	@RequestMapping(value="/Show")
	public String ShowAll(Model model)
	{
		clothes= service.showAllcloth();		
	    model.addAttribute("cloth",clothes);
		return "clothes";
	}
	
	//show衣物 :操作员通过查询衣物的状态（0：已经洗好 /1：未洗好），将衣物信息显示出来。
	@RequestMapping(value="/showStatue")
	public String showClothes(Model model,@RequestParam("Statue")int Statue)
	{	
		//int num,i;
		clothes= service.ShowclothBystatus(Statue );
		//num = clothes.size();
		
		//把最后得到的list对象传到jsp页面，jsp页面再用<c:forEach> </c:forEach>输出即可
		model.addAttribute("cloth",clothes);		
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
	public String manageCloth(Model model,@RequestParam("id")String id)
	{
		List<Cloth> ccloth = new ArrayList<Cloth>();
		Cloth clo = new Cloth();
		clo=service.MoodifyClothStatueByID(id);	//得到返回的衣物对象实例		
		model.addAttribute("clo",clo);//将查询出的衣物实例存入数据模型中
		ccloth.add(clo);//将查询出的衣物实例存入一个list中,便于jsp界面统一显示(保持格式一致)
		model.addAttribute("cloth",ccloth);
		return "clothes";
		/*
		 * 
	  	
		List<Client> one = new ArrayList<Client>();
		model.addAttribute("two",client.findOne(Cid));
		one.add(client.findOne(Cid));
		model.addAttribute("client_1",one);
		return "member";
		
		 * 
		 * */
	}
	
	//直接跳转,用于测试
	@RequestMapping(value="/test")
	public String test(){
		
		return "clothes";
	}

}
	
