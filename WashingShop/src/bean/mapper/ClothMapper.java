package bean.mapper;

import java.util.List;

import bean.daoclass.Cloth;

public interface ClothMapper {
	public void add(Cloth cloth);
	public List<Cloth> get(int statue);
}
