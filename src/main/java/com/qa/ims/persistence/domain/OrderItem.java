package com.qa.ims.persistence.domain;

public class OrderItem {
	
	protected String id, orderid, itemid;
	
	public OrderItem(String orderid, String itemid) {
		this.setOrderID(orderid);
		this.setItemID(itemid);
	}
	
	public OrderItem(String id, String orderid, String itemid) {
		this.setId(id);
		this.setOrderID(orderid);
		this.setItemID(itemid);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getOrderID() {
		return orderid;
	}
	
	public void setOrderID(String orderid) {
		this.orderid = orderid;
	}
	
	public String getItemID() {
		return itemid;
	}
	
	public void setItemID(String itemid) {
		this.itemid = itemid;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ", order id:" + orderid + ", item id:" + itemid;
	}
	
	@Override 
	public int hashCode() {
		final int prime = 5;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
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
