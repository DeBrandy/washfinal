package bean.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.daoclass.Client;
import bean.daoclass.Cloth;
import bean.daoclass.Order;
import bean.mapper.ClientMapper;
import bean.mapper.ClothMapper;
import bean.mapper.OrderMapper;
import bean.service.*;


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	public OrderMapper orderMapper ;
	public ClothMapper clothMapper;
	public ClientMapper clientMapper;

	private List<Cloth> clothes ;  
	//收件
	//根据电话号码查询 姓名,余额,等级,未取件单号,总消费,地址
	public Client selectInfoByNumber(String Cid){
		Client client = new Client();
		client = clientMapper.selectClientById(Cid);
		return client;
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
	public Order buildOrder(String Cid,List<Cloth> clothes,String applicationoid){
		
		Order order = new Order();
		order.setOid(applicationoid);
		order.setCid(Cid);
		order.setNumber(clothes.size());
		order.setStatue(0);
		long now=System.currentTimeMillis();
		order.setTime((new SimpleDateFormat("yyyy-mm-dd")).format(now));
		for (Cloth clothnow : clothes) {    //把衣物写入数据库
			clothnow.setOid(applicationoid);   //给每件衣服添加单据号
			clothMapper.addCloth(clothnow);            //写入数据库
			order.setMoney(clothnow.getDprice()+order.getMoney());    //订单总价
        }		
		orderMapper.addOrders(order);    //把此订单写入数据库
		
		//更新等级
		Client client = new Client();
		client = clientMapper.selectClientById(Cid);  
		client.setCba(client.getCba()-order.getMoney());   //扣费
		client.setCcost(client.getCcost()+order.getMoney());   //累计消费
		String type = client.getCtype();     //获取当前等级
		double cost = client.getCcost();    //获取累计消费
		if(cost>=3000){
			type = "超级";     //累计消费超过3000,更新为 超级
		}
		else if(cost>=2000 && cost<3000){
			if(!type.equals("超级")){
				type = "黄金";        //累计消费超过2000不到3000,且目前不是超级会员,更新为黄金
			} 
		}
		else if(cost>=800 && cost<2000){
			if(type.equals("普通")){
				type = "白银";             //普通会员消费超过800,更新为白银会员
			}
		}
		client.setCtype(type);
		
		return order;
	}
	
	//取件
	//将此单据状态改为已取,且把此订单中所有衣物状态改为已取(调用)
	public void selectOrderByOrderid(String Orderid){
		orderMapper.updateOrderStatue(Orderid);      //修改单据状态
		orderMapper.updateClothStatueByOid(Orderid);   //修改单据中所有衣物状态
	}
	
	//通过输入挂衣号ID修改衣物状态，当即修改
	public void MoodifyClothStatueByID(String ID)
	{
		clothMapper.updateClothStatueById(ID);		
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

}
