package bean.service;


import java.text.SimpleDateFormat;
import java.util.List;

import bean.daoclass.Client;
import bean.daoclass.WashUse;
import bean.mapper.*;
public interface WashUseService {
	
	public  List<WashUse> findAll();//显示当前所有商品
	
	public int update(String Uname_1,String Uname_2,int Unum);	//修改商品
	public  WashUse findOne(String Uname);    //按查找商品
	public  int  delete(String Uname);       //删除商品
	public  int insert(String Uname,int Unum); //新增商品
	
	
	

}
