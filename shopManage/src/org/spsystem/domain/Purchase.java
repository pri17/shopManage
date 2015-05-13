package org.spsystem.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="purchase")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Purchase implements Serializable{
	private static final long serialVersionUID = 48L;
	@Id
	@Column(name="purchase_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="purchase_num", nullable=false)
	private Integer num;
	
	@Column(name="purchase_price")
	private Double inprice;
	
	@Column(name="work_day", nullable=false, length=50)
	private String workDay;
	
	@Column(name="purchase_time")
	private Date purchaseTime;
	
	@ManyToOne(targetEntity=Shop.class)
	@JoinColumn(name="shop_id", nullable=false)
	private Shop shop;
	
	@ManyToOne(targetEntity=Staff.class)
	@JoinColumn(name="staff_id", nullable=false)
	private Staff staff;
	
	@ManyToOne(targetEntity=Goods.class)
	@JoinColumn(name="goods_id", nullable=false)
	private Goods goods;
	
	public Purchase(){
		
	}

	public Purchase(Integer id, Integer num, Double inprice,
			String workDay, Date purchaseTime, Shop shop, Staff staff,
			Goods goods) {
		super();
		this.id = id;
		this.num = num;
		this.inprice = inprice;
		this.workDay = workDay;
		this.purchaseTime = purchaseTime;
		this.shop = shop;
		this.staff = staff;
		this.goods = goods;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getInprice() {
		return inprice;
	}

	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}

	public String getWorkDay() {
		return workDay;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	public Date getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
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

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result
				+ ((purchaseTime == null) ? 0 : purchaseTime.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
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
		Purchase other = (Purchase) obj;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (purchaseTime == null) {
			if (other.purchaseTime != null)
				return false;
		} else if (!purchaseTime.equals(other.purchaseTime))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		if (workDay == null) {
			if (other.workDay != null)
				return false;
		} else if (!workDay.equals(other.workDay))
			return false;
		return true;
	}
	
	
}
