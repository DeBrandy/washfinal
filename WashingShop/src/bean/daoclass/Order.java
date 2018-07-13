package bean.daoclass;

import java.util.Date;

public class Order {
	private String Oid,Cid;//订单号，手机号
	private int number;//数量
	private Date Time;//日期
	private int Statue;
	public Order(){}
	public String getOid() {
		return Oid;
	}
	public void setOid(String oid) {
		Oid = oid;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public int getStatue() {
		return Statue;
	}
	public void setStatue(int statue) {
		Statue = statue;
	}
}
