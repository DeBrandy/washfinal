package bean.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import bean.daoclass.Client;

public interface ClientMapper {
	//用户查询:根据电话号码查询用户所有信息
	@Select("select * from info where Cid=#{Cid}")
	Client selectClientById(int Cid);
	
	//查询全部会员信息
	@Select("select * from info")
	List<Client> selectAllClient();
	
	//插入一个会员
	@Insert("insert into info values(#{Cid},#{Cname},#{Csex},#{Cad},#{Cba},#{Ccost},#{Ctype})")
	void addClient(Client client);
	
	//修改会员信息   按手机号查找，可以修改任意信息****用动态的待写
	@Update("update info set #{} where Cid=#{Cid}")
	void updateClientInfo(String Cid);
	
	//删除一个会员
	@Delete("delete from info where Cid=#{Cid}")
	void deleteClientInfo(String Cid);
}
