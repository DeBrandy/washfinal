package bean.daoclass;

public class Cloth {
	private String Cid,Id,Type,Clo,Mat,Color,Brand,Flaw,Add;//订单号,挂衣号,服务类型,服务项目,材质,颜色,品牌,瑕疵,备注要求
	private double Price,Dprice;  //价格,折后价
	private int Statue;  //衣物状态
	//无参构造函数
	public Cloth(){}
	//get和set方法
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getClo() {
		return Clo;
	}
	public void setClo(String clo) {
		Clo = clo;
	}
	public String getMat() {
		return Mat;
	}
	public void setMat(String mat) {
		Mat = mat;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getFlaw() {
		return Flaw;
	}
	public void setFlaw(String flaw) {
		Flaw = flaw;
	}
	public String getAdd() {
		return Add;
	}
	public void setAdd(String add) {
		Add = add;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getDprice() {
		return Dprice;
	}
	public void setDprice(double dprice) {
		Dprice = dprice;
	}
	public int getStatue() {
		return Statue;
	}
	public void setStatue(int statue) {
		Statue = statue;
	}
}
