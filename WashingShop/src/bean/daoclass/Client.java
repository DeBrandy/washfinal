package bean.daoclass;

public class Client {
	private String Cid,Cname,Csex,Cad,Ctype;  //手机号,姓名,性别,地址,会员类型
	private double Cba,Ccost,Discount;  //卡内余额,总消费
	//无参构造函数
	public Client(){}
	//set和get方法
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getCsex() {
		return Csex;
	}
	public void setCsex(String csex) {
		Csex = csex;
	}
	public String getCad() {
		return Cad;
	}
	public void setCad(String cad) {
		Cad = cad;
	}
	public String getCtype() {
		return Ctype;
	}
	public void setCtype(String ctype) {
		Ctype = ctype;
	}
	public double getCba() {
		return Cba;
	}
	public void setCba(double cba) {
		Cba = cba;
	}
	public double getCcost() {
		return Ccost;
	}
	public void setCcost(double ccost) {
		Ccost = ccost;
	}
	public double getDiscount() {
		return Discount;
	}
	public void setDiscount(double discount) {
		Discount = discount;
	}
}
