package org.spsystem.vo;

public class GoodsBean {
	private String name;
	private int id;
	private long inventory;
	private long salenum;
	private double profit;
	private String type;
	
	public GoodsBean(){}

	public GoodsBean(String name, int id, int inventory, int salenum,
			double profit, String type) {
		super();
		this.name = name;
		this.id = id;
		this.inventory = inventory;
		this.salenum = salenum;
		this.profit = profit;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getInventory() {
		return inventory;
	}

	public void setInventory(long inventory) {
		this.inventory = inventory;
	}

	public long getSalenum() {
		return salenum;
	}

	public void setSalenum(long salenum) {
		this.salenum = salenum;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	
}
