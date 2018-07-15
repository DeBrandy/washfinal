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
	public void selectOrderByOrderid(String Orderid);
}
