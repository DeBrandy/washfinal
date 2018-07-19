package bean.daoclass;

public class Client {
	private String cid,csex,cad,ctype; 
	private String cname;//手机号,姓名,性别,地址,会员类型
	private double cba,ccost,discount;  //卡内余额,总消费,折扣
	//无参构造函数
	public Client(){}
	//set和get方法
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCsex() {
		return csex;
	}
	public void setCsex(String csex) {
		this.csex = csex;
	}
	public String getCad() {
		return cad;
	}
	public void setCad(String cad) {
		this.cad = cad;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getCba() {
		return cba;
	}
	public void setCba(double cba) {
		this.cba = cba;
	}
	public double getCcost() {
		return ccost;
	}
	public void setCcost(double ccost) {
		this.ccost = ccost;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
