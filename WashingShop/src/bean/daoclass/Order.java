package bean.daoclass;

import java.util.Date;

public class Order {
	private String Oid,Cid,Time;//订单号，手机号,日期
	private int Number;//数量
<<<<<<< HEAD
=======
	private String Time;//日期
>>>>>>> 9a4e1f48faffa5b39defb0cf364fd5e413823fdd
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
		return Number;
	}
	public void setNumber(int number) {
		this.Number = number;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public int getStatue() {
		return Statue;
	}
	public void setStatue(int statue) {
		Statue = statue;
	}
}
