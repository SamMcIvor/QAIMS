package com.qa.ims.persistence.domain;

public class OrderItem {
	
	protected Long id, orderid, itemid;
	
	
	
	public OrderItem(Long orderid, Long itemid) {
		this.orderid = orderid;
		this.itemid = itemid;
	}

	public OrderItem(Long id, Long orderid, Long itemid) {
		this.setId(id);
		this.setOrderID(orderid);
		this.setItemID(itemid);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getOrderID() {
		return orderid;
	}
	
	public void setOrderID(Long orderid) {
		this.orderid = orderid;
	}
	
	public Long getItemID() {
		return itemid;
	}
	
	public void setItemID(Long itemid) {
		this.itemid = itemid;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ", order id:" + orderid + ", item id:" + itemid;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (getId() == null) {
			if (other.getId() != null) 
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (getOrderID() == null) {
			if (other.getOrderID() != null)
				return false;
		} else if (!orderid.equals(other.getOrderID()))
				return false;
		if (getItemID() == null) {
			if (other.getItemID() != null) 
				return false;
		} else if (!itemid.equals(other.getItemID()))
			return false;
		return true;
	}
}
