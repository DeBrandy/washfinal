package bean.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import bean.daoclass.Cloth;

public interface ClothMapper {
	
	//添加衣物信息
	@Insert("insert into cloth values(#{id},#{oid},#{type},#{clo},#{mat},#{color},#{brand},#{flaw},#{add},#{statue},#{price},#{dprice})")
	public void addCloth(Cloth cloth);
	
	//根据衣物状态0（已洗未取）返回衣物信息
	@Select("select * from cloth where Statue = 0")
	public List<Cloth> returnClothInfoByStatue_0();
	
	//根据衣物状态-1(未洗)返回衣物信息
	@Select("select * from cloth where Statue = -1")
	public List<Cloth> returnClothInfoByStatue_1();
	
	//根据挂件号修改衣物状态
	@Update("update cloth set Statue=0 where Id=#{Id}")
	void updateClothStatueById(String Id);
	
	//根据挂件号查找衣物信息
	@Select("select * from cloth where Id=#{Id}")
	List<Cloth> returnAllClothInfo(String Id);
	
	//返回衣物信息
	@Select("select * from cloth")
	public List<Cloth> returnClothInfo();	
	
}
