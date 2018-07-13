package bean.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import bean.daoclass.Cloth;
import bean.daoclass.Order;

public interface OrderMapper {
	//返回查询到的最大的订单日期
	@Select("select Max(Time) from orders")
	Date returnTopData();
	//添加订单
	@Insert("insert into orders values(#{Oid},#{Cid},#{Number},#{Time},#{Statue})")
	void addOrders(Order order);
	//根据订单号查询所有衣物信息
	@Select("select * from cloth where Oid=#{Oid}")
	List<Cloth> returnAllClothInfo(String Oid);
	//根据订单号修改订单状态为1(已取)
	@Update("update orders set statue=1 where Oid=#{Oid}")
	void updateOrderStatue(String Oid);
	//根据订单状态修改所有衣物状态
	@Update("update cloth set Statue=1 where Oid=#{Oid}")
	void updateClothStatueByOid(String Oid);
}
