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
					SET("Cname = #{Cname}");
				if(client.getCsex() != null)
					SET("Csex = #{Csex}");
				if(client.getCad() != null)
					SET("Cad = #{Cad}");
				if(client.getCba() != 0)
					SET("Cba = #{Cba}");
				if(client.getCcost() != 0)
					SET("Ccost = #{Ccost}");
				if(client.getCtype() != null)
					SET("Ctype = #{Ctype}");
				WHERE("Cid = #{Cid}");
			}
		}.toString();
	}
}
