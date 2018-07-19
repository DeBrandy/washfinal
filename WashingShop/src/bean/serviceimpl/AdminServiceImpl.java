package bean.serviceimpl;

import java.math.BigInteger;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.NEW;

import bean.controller.Clothes;
import bean.daoclass.Client;
import bean.daoclass.Cloth;
import bean.daoclass.Order;
import bean.daoclass.Operator;
import bean.mapper.ClientMapper;
import bean.mapper.ClothMapper;
import bean.mapper.OrderMapper;
import bean.service.*;


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	public OrderMapper orderMapper ;
	@Autowired
	public ClothMapper clothMapper;
	@Autowired
	public ClientMapper clientMapper;

	private List<Cloth> clothes = new ArrayList<Cloth>();
	private Cloth cloth;
	//收件
	//根据电话号码查询 姓名,余额,等级,未取件单号,总消费,地址
	public Client selectInfoByNumber(String Cid){
		return clientMapper.selectClientById(Cid);
	}
	
	//创建衣物,输入服务类型,服务项目,材质,颜色,品牌,瑕疵,附件,价格,挂衣号,折扣不用手动输入,会自动检查
	//添加后显示折后价格,并清除文本框中内容,可以继续添加衣物
	public Cloth buildCloth(String Type,String Clo,String Mat,String Color,String Brand,String Flaw,String Add,double Price,
			double Discount,String Id){
		Cloth cloth = new Cloth();
		cloth.setAdd(Add);
		cloth.setBrand(Brand);
		cloth.setClo(Clo);
		cloth.setFlaw(Flaw);
		cloth.setId(Id);
		cloth.setMat(Mat);
		cloth.setPrice(Price);         
		cloth.setDprice(Price*Discount);
		cloth.setType(Type);
		cloth.setStatue(-1);
				
		return cloth;
	}
	//确认是否是今天的第一条单据,并生成单据号
	public String isToday(String applicationoid){
		//获取
		
		double ooid = 0;
		//BigInteger big=new BigInteger(applicationoid);
		
		String dateString = orderMapper.returnTopData();    //数据库中最大时间
		System.out.println(dateString+"数据库中最大时间");
		String oidString = orderMapper.returnTopOid();   //数据库中最大单据号
		System.out.println(oidString+"数据库中最大单据号");
		java.util.Date date = new java.util.Date();
		//得到YYYYMMDD的格式
		SimpleDateFormat sy1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sy2 = new SimpleDateFormat("yyyyMMdd");
		String dateFormat = sy1.format(date);                  //当前时间
		String dateFormat2 = sy2.format(date);                //当前时间的yyyymmdd格式
		if(!dateFormat.equals(dateString)){   //如果当前时间和数据库中最大时间不同,applicationoid变为当前日期+000,
			applicationoid = dateFormat2 + "000";
			//ooid = Integer.parseInt(applicationoid)*1000;
		}else{
			//System.out.println(ooid+"isToday()中返回的ooid++");
			ooid = Double.parseDouble(oidString);   //如果当前时间和数据库中最大时间相同,则给订单号+1
			ooid++;
			DecimalFormat df = new DecimalFormat("00000000000"); 
			applicationoid = df.format(ooid); 
			}
		System.out.println(ooid+"isToday()中返回的ooid");
		System.out.println(applicationoid+"isToday()中返回的application");
		System.out.println(dateFormat+"isToday()中返回的dateFormat");
		System.out.println(dateFormat2+"isToday()中返回的dateFormat2");
		             
		return applicationoid;
	}
	//结账创建单据,并把衣物写入数据库
	public Order buildOrder(String Cid,String applicationoid,int number,List<Cloth> clothes){
		Order order = new Order();
		//order = orderMapper.returnOrderInfo(applicationoid);
		
		order.setOid(applicationoid);
		order.setCid(Cid);
		order.setNumber(number);
		order.setStatue(0);
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sy1 = new SimpleDateFormat("yyyy-MM-dd");
		order.setTime(sy1.format(date));
		System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(date)+"buildOrder中的yyyy-MM-dd格式的日期");
		for(Cloth clothnow : clothes){
			order.setMoney(clothnow.getDprice()+order.getMoney());    //订单总价
			clothnow.setOid(applicationoid);              //添加单据号
			clothMapper.addCloth(clothnow);              //把衣物写入数据库
		}
		orderMapper.addOrders(order);    //把此订单写入数据库
		//更新等级
		Client client = new Client();
		client = clientMapper.selectClientById(Cid);  
		client.setCba(client.getCba()-order.getMoney());   //扣费
		client.setCcost(client.getCcost()+order.getMoney());   //累计消费
		String type = client.getCtype();     //获取当前等级
		double discount = 1;
		double cost = client.getCcost();    //获取累计消费
		if(cost>=3000){
			type = "超级";     //累计消费超过3000,更新为 超级
			discount = 0.8;
		}
		else if(cost>=2000 && cost<3000){
			if(!type.equals("超级")){
				type = "黄金";        //累计消费超过2000不到3000,且目前不是超级会员,更新为黄金
				discount = 0.9;
			} 
		}
		else if(cost>=800 && cost<2000){
			if(type.equals("普通")){
				type = "白银";             //普通会员消费超过800,更新为白银会员
				discount = 0.95;
			}
		}
		client.setCtype(type);
		client.setDiscount(discount);
		clientMapper.updateClientInfo(client); 
		
		return order;
	}
	
	
	//取件
	//将此单据状态改为已取,且把此订单中所有衣物状态改为已取(调用)
	public Order selectOrderByOrderid(String Orderid){
		int flag = 0;
		int number = 0;
		Order order = new Order();
		List<Cloth> clothes = orderMapper.returnAllClothInfo(Orderid);
		for (Cloth clothnow : clothes){
			if(clothnow.getStatue()==0){
				number++;
			}	
		}
		if(number == orderMapper.returnNum(Orderid)){
			flag = 1;
		}
		if(flag == 1){
			orderMapper.updateOrderStatue(Orderid);      //修改单据状态
			orderMapper.updateClothStatueByOid(Orderid);   //修改单据中所有衣物状态
		}
		order = orderMapper.returnOrderInfo(Orderid);
		return order;
	}
	public  Operator equal()
	{
		Operator operator= new Operator();
	     operator.setLname("快落洗衣");
	     operator.setPassword("123456");
		return operator;
	}
	
	
	//通过输入挂衣号ID修改衣物状态，当即修改
	public Cloth MoodifyClothStatueByID(String ID)
	{
		clothMapper.updateClothStatueById(ID);
		cloth=clothMapper.returnAllClothInfo(ID);
		return cloth;
	}
	
	//通过选择要查询的衣物的状态，显示当前状态的所有衣物
	public List<Cloth> ShowclothBystatus(int Statue)
	{
		if( Statue == 0)
		{
			clothes =clothMapper.returnClothInfoByStatue_0();		
		}    
		if(Statue == -1)
		{
			clothes =clothMapper.returnClothInfoByStatue_1();			
		}		
		return clothes ;			
	}
	public List<Cloth> showAllcloth()
	{
		clothes = clothMapper.returnClothInfo();
		return clothes;
	}
}
