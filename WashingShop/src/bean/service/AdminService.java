package bean.service;

import java.util.List;

import bean.daoclass.Client;
import bean.daoclass.Cloth;
import bean.daoclass.Order;

public class AdminService {
	//收件
	//根据电话号码查询 姓名,余额,等级,未取件单号,总消费,地址
	public Client selectInfoByNumber(String number){
		Client client = new Client();
		return client;
	}
	
	//创建衣物,输入服务类型,服务项目,材质,颜色,品牌,瑕疵,附件,价格
	//添加后显示折后价格和总价,并清除文本框中内容,可以继续添加衣物
	public Cloth buildCloth(){
		Cloth cloth = new Cloth();
		return cloth;
	}
	
	//结账后创建单据号,把单据号写入集合中的衣物对象,再将衣物们、单据写入数据库
	//确认是否是今天的第一条单据,使用application
	public Order buildOrder(List<Cloth> clothes,boolean date){
		//根据时间创建单据号
		Order order = new Order();
		return order;
	}
	//打印票据
	public void printOrder(Order order){
		
	}
	//取件
	//将此单据状态改为已取,且把此订单中所有衣物状态改为已取
	public void selectOrderByOrderid(String Orderid){
		
	}
}
