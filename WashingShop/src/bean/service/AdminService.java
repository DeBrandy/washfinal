package bean.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import bean.daoclass.Client;
import bean.daoclass.Cloth;
import bean.daoclass.Order;
import bean.mapper.*;

public class AdminService {
	public OrderMapper orderMapper ;
	//收件
	//根据电话号码查询 姓名,余额,等级,未取件单号,总消费,地址
	public Client selectInfoByNumber(String Cid){
		Client client = new Client();
		return client;
	}
	
	//创建衣物,输入服务类型,服务项目,材质,颜色,品牌,瑕疵,附件,价格
	//添加后显示折后价格和总价,生成挂衣号,并清除文本框中内容,可以继续添加衣物
	public Cloth buildCloth(String Type,String Clo,String Mat,String Color,String Brand,String Flaw,String Add){
		Cloth cloth = new Cloth();
		return cloth;
	}
	//确认是否是今天的第一条单据,并生成单据号
	public String isToday(String applicationoid){
		//获取
		String Oid = null;
		int ooid = 0;
		int year = orderMapper.returnTopData().getYear();
		int month = orderMapper.returnTopData().getMonth();
		int day = orderMapper.returnTopData().getDay();
		String dateString = year + "" + month + "" + day + "";    //数据库中最大时间
		java.util.Date date = new java.util.Date();
		//得到YYYYMMDD的格式
		SimpleDateFormat sy1 = new SimpleDateFormat("yyyyMMDD");
		String dateFormat = sy1.format(date);                  //当前时间
		if(!dateFormat.equals(dateString)){   //如果当前时间和数据库中最大时间不同,applicationoid变为当前日期+000,
			applicationoid = dateFormat;
			ooid = Integer.parseInt(applicationoid)*1000;
		}else{
			ooid = Integer.parseInt(applicationoid) + 1;   //如果当前时间和数据库中最大时间相同,则给订单号+1
			}
		applicationoid = Integer.toString(ooid);              
		return applicationoid;
	}
	//结账后创建单据号,把单据号写入集合中的衣物对象,再将衣物对象们、单据对象写入数据库
	public Order buildOrder(Client client,List<Cloth> clothes,String applicationoid){
		//根据时间创建单据号
		Order order = new Order();
		return order;
	}
	//打印票据
	public void printOrder(Order order){
		
	}
	//取件
	//将此单据状态改为已取,且把此订单中所有衣物状态改为已取(调用)
	public void selectOrderByOrderid(String Orderid){
		
	}
}
