package bean.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;

import bean.daoclass.Cloth;

public interface ClothMapper {
	//添加衣物信息
	@Insert("insert into cloth values(#{Id},#{Cid},#{Type},#{Clo},#{Mat},#{Color},#{Brand},#{Flaw},#{Add},#{Statue},#{Price},#{Dprice})")
	public void addCloth(Cloth cloth);
	//
	public List<Cloth> get(int statue);
}
