package bean.service;

import java.sql.Date;


import java.text.SimpleDateFormat;
import java.util.List;

import bean.daoclass.Client;
import bean.daoclass.Cloth;
import bean.daoclass.Order;
import bean.mapper.*;
public interface AdminService {
	
	public Client selectInfoByNumber(String Cid);
	public Cloth buildCloth(String Type,String Clo,String Mat,String Color,
			String Brand,String Flaw,String Add,double Price,double Discount,String Id);
	public String isToday(String applicationoid);
	public Order buildOrder(String Cid,List<Cloth> clothes,String applicationoid);
	public Order selectOrderByOrderid(String Orderid);
	
	//通过挂衣号ID修改衣物状态，当即修改
	public void MoodifyClothStatueByID(String ID);
	//通过选择要查询的衣物的状态，显示当前状态的所有衣物
	public List<Cloth> ShowclothBystatus(int Statue);
	//显示当前有的全部衣物，便于进行操作
	public List<Cloth> showAllcloth();
	
}
