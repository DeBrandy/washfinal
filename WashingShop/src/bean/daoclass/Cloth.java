package bean.daoclass;

public class Cloth {
	private String oid,id,type,clo,mat,color,brand,flaw,add;//订单号,挂衣号,服务类型,服务项目,材质,颜色,品牌,瑕疵,备注要求
	private double price,dprice;  //价格,折后价
	private int statue;  //衣物状态
	//无参构造函数
	public Cloth(){}
	//get和set方法
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClo() {
		return clo;
	}
	public void setClo(String clo) {
		this.clo = clo;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getFlaw() {
		return flaw;
	}
	public void setFlaw(String flaw) {
		this.flaw = flaw;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDprice() {
		return dprice;
	}
	public void setDprice(double dprice) {
		this.dprice = dprice;
	}
	public int getStatue() {
		return statue;
	}
	public void setStatue(int statue) {
		this.statue = statue;
	}
}
