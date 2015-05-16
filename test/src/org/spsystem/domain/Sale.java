package org.spsystem.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="sale")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Sale implements Serializable{
	private static final long serialVersionUID = 48L;
	@Id 
	@Column(name="sale_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="work_day", nullable=false, length=50)
	private String workDay;
	
	@Column(name="sale_time")
	private Date saleTime;
	
	@Column(name="sale_num", nullable=false)
	private Integer num;
	
	@Column(name="sale_price", nullable=false)
	private Double price;
	
	@ManyToOne(targetEntity=Goods.class)
	@JoinColumn(name="goods_id", referencedColumnName="goods_id", nullable=false)
	private Goods goods;
	
	@ManyToOne(targetEntity=Shop.class)
	@JoinColumn(name="shop_id", referencedColumnName="shop_id", nullable=false)
	private Shop shop;
	
	@ManyToOne(targetEntity=Staff.class)
	@JoinColumn(name="staff_id", referencedColumnName="staff_id", nullable=false)
	private Staff staff;
	
	public Sale(){
		
	}

	public Sale(Integer id, String workDay, Date saleTime, Integer num,
			Double price, Goods goods, Shop shop, Staff staff) {
		super();
		this.id = id;
		this.workDay = workDay;
		this.saleTime = saleTime;
		this.num = num;
		this.price = price;
		this.goods = goods;
		this.shop = shop;
		this.staff = staff;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWorkDay() {
		return workDay;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	public Date getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result
				+ ((saleTime == null) ? 0 : saleTime.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
		result = prime * result + ((staff == null) ? 0 : staff.hashCode());
		result = prime * result + ((workDay == null) ? 0 : workDay.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (saleTime == null) {
			if (other.saleTime != null)
				return false;
		} else if (!saleTime.equals(other.saleTime))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		if (staff == null) {
			if (other.staff != null)
				return false;
		} else if (!staff.equals(other.staff))
			return false;
		if (workDay == null) {
			if (other.workDay != null)
				return false;
		} else if (!workDay.equals(other.workDay))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sale [workDay=" + workDay + ", saleTime=" + saleTime + ", num="
				+ num + ", price=" + price + ", goods=" + goods + ", shop="
				+ shop + ", staff=" + staff + "]";
	}

}
