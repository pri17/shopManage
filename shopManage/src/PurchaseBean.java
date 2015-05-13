

import java.util.Date;

public class PurchaseBean {
	private int id;
	private String name;
	private String date;
	private double price;
	private int num;
	private String staff;
	
	public PurchaseBean(){}

	public PurchaseBean(int id, String name, String date,
			double price, int num, String staff) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.price = price;
		this.num = num;
		this.staff = staff;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}
	
}
