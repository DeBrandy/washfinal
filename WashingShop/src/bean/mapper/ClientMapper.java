package bean.mapper;

import org.apache.ibatis.annotations.Select;

import bean.daoclass.Client;

public interface ClientMapper {
	//根据电话号码查询用户所有信息
	@Select("select * from info where Cid=#{Cid}")
	Client selectClientById(int Cid);
}
