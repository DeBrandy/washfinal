package bean.service;


import java.text.SimpleDateFormat;
import java.util.List;

import bean.daoclass.Client;
import bean.mapper.*;
public interface MemberService {

	public  List<Client> findAll();
	public int update(String Cid_1,String Cid_2,String Cname,String Csex,String Cad);	//修改用户信息
	public  Client  findOne(String Cid);    //按手机号查找用户信息
	public  int  delete(String Cid);       //删除用户
	public  List<Client> sortByCid();     //按卡号排序
	public  List<Client> sortByCba();      //按余额排序
	public  List<Client> sortByCcost();   //按总消费排序
	public  int  invest(String Cid,double amount);  //充值
	public  int insert(String Cid, String Cname, String Csex,String Cad,double amount); //插入一个新的用户
	
}
