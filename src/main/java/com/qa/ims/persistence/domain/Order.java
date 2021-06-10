package com.qa.ims.persistence.domain;

public class Order {

	private String id;
	private String customerid;

	
	public Order(String id, String customerid) {
		super();
		this.id = id;
		this.customerid = customerid;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerID() {
		return customerid;
	}

	public void setCustomerID(String customerid) {
		this.customerid = customerid;
	}


	




	@Override
	public String toString() {
		return "id: " + id + ", customer id: " + customerid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerid == null) ? 0 : customerid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Order other = (Order) obj;
		if (getCustomerID() == null) {
			if (other.getCustomerID() != null)
				return false;
		} else if (!getCustomerID().equals(other.getCustomerID()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
