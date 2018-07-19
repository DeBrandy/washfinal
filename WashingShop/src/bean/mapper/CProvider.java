package bean.mapper;

import org.apache.ibatis.jdbc.SQL;

import bean.daoclass.Client;

public class CProvider {
	public String updateClientInfo(final Client client) 
	{
		return new SQL(){
			{
				UPDATE("info");
				if(client.getCname() != null)
					SET("Cname = #{cname}");
				if(client.getCsex() != null)
					SET("Csex = #{csex}");
				if(client.getCad() != null)
					SET("Cad = #{cad}");
				if(client.getCba() != 0)
					SET("Cba = #{cba}");
				if(client.getCcost() != 0)
					SET("Ccost = #{ccost}");
				if(client.getCtype() != null)
					SET("Ctype = #{ctype}");
				if(client.getDiscount() != 0)
					SET("Discount = #{discount}");
				WHERE("Cid = #{cid}");
			}
		}.toString();
	}
}
