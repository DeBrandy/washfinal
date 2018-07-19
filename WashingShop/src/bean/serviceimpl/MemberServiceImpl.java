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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	public ClientMapper client;
	//删除用户
	public int delete(String Cid) {
		// TODO Auto-generated method stub
		client.deleteClientInfo(Cid);
		return 0;
	}
	//查看所有用户
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		
		return client.selectAllClient();
	}
	//按照用户手机号查找用户
	public Client findOne(String Cid) {
		// TODO Auto-generated method stub
		
		return client.selectClientById(Cid);
	}
	//修改用户信息
	public int update(String Cid_1,String Cid_2,String Cname,String Csex,String Cad) {
		// TODO Auto-generated method stub
	 Client one = client.selectClientById(Cid_1);
	 one.setCid(Cid_2);
	 one.setCname(Cname);
	 one.setCsex(Csex);
	 one.setCad(Cad);
	 client.deleteClientInfo(Cid_1);
	 client.addClient(one);

		return 0;
	}
	//按照手机号排序
	public  List<Client> sortByCid()
	{
		List<Client> one = client.selectAllClient();
		Collections.sort(one, new Comparator<Client>() {
			 
			public int compare(Client o1, Client o2) {
				 long one = Long.parseLong(o1.getCid());
				 long two = Long.parseLong(o2.getCid());
				 if(one> two){
	                    return 1;
	                }
	                if(one ==two){
	                    return 0;
	                }
	                return -1;
			}
		});
		
		return one;
	}
	
	//按余额排序
	public  List<Client> sortByCba()     
	{
		List<Client> one = client.selectAllClient();
		Collections.sort(one, new Comparator<Client>() {
			 
			public int compare(Client o1, Client o2) {

				 if(o1.getCba()< o2.getCba()){
	                    return 1;
	                }
	                if(o1.getCba()==o2.getCba()){
	                    return 0;
	                }
	                return -1;
			}
		});
		
		return one;		
		
	}
	
	//按总消费排序
	public  List<Client> sortByCcost()
	{
		
		List<Client> one = client.selectAllClient();
		Collections.sort(one, new Comparator<Client>() {
				public int compare(Client o1, Client o2) {

					 if(o1.getCcost()< o2.getCcost()){
		                    return 1;
		                }
		                if(o1.getCcost()==o2.getCcost()){
		                    return 0;
		                }
		                return -1;
				}
			});
		
		return one;	
		
	}
	//充值
	public  int  invest(String Cid,double amount)
	{
		Client one = new Client();
		one = client.selectClientById(Cid);
		double amount_1= one.getCba();
		amount_1 = amount_1+amount;
		one.setCba(amount_1);
		if(amount<500)
		{
			
			
		}
				
		else if(amount<1000 && one.getDiscount()==1.0)
		{
			one.setCtype("白银");
			one.setDiscount(0.95);
			
		}
		else if(amount<1000 && one.getDiscount()<=0.95)
		{
			
		}
	
		else if(amount<2000 && one.getDiscount()>0.9)
		{
			one.setCtype("黄金");
			one.setDiscount(0.9);
			
		}
		else if(amount<2000 && one.getDiscount()<=0.9)
		{
			
		}
		else if(amount>=2000)
		{
			one.setCtype("超级");
			one.setDiscount(0.8);
			
		}

	
		client.updateClientInfo(one);
		return 0;
	}
	
	//插入新用户
	
	public int insert(String Cid, String Cname, String Csex,String Cad,double amount) {
		
		Client one = new Client() ;
		one.setCid(Cid);
		one.setCname(Cname);
		one.setCsex(Csex);
		one.setCad(Cad);
		one.setCba(amount);
		one.setCcost(0);
		if(amount <500)
		{
			
			one.setCtype("普通");
			one.setDiscount(1.00);
			
		}
		else if(amount <1000)
		{
			
			one.setCtype("白银");
			one.setDiscount(0.95);
			
		}
		else if(amount <2000)
		{
			
			one.setCtype("黄金");
			one.setDiscount(0.9);
			
		}
		else if(amount >=2000)
		{
			
			one.setCtype("超级");
			one.setDiscount(0.8);
			
		}
		client.addClient(one);
		// TODO Auto-generated method stub
		return 0;
	}

} 