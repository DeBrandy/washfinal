package bean.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import bean.daoclass.Client;
import bean.daoclass.Cloth;
import bean.daoclass.WashUse;

public interface WashUseMapper {
	//查找所有的商品
	@Select("select * from washuse")
	List<WashUse> returnAllWashuseInfo();
	
	//按名称查找商品
	@Select("select * from washuse where Uname=#{Uname}")
	WashUse returnWashuseInfoByName(String Uname);
	
	//添加商品
	@Insert("insert into washuse values(#{uname},#{unum})")
	public void addWashUse(WashUse washuse);
	
	//修改商品信息
	@Update("update washuse set Unum=#{unum} where Uname=#{uname}")
	void updateWashUseByName(WashUse wash);
	
	//删除商品信息
	@Delete("delete from washuse where Uname=#{Uname}")
	void deleteWashUse(String Uname);
}
