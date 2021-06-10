package com.qa.ims.persistence.domain;

public class Order {

	private String id;
	private String fk_customerid;
	private String fk_itemid;
	
	public Order(String id, String fk_customerid, String fk_itemid) {
		super();
		this.id = id;
		this.fk_customerid = fk_customerid;
		this.fk_itemid = fk_itemid;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFk_customerid() {
		return fk_customerid;
	}

	public void setFk_customerid(String fk_customerid) {
		this.fk_customerid = fk_customerid;
	}

	public String getFk_itemid() {
		return fk_itemid;
	}

	public void setFk_itemid(String fk_itemid) {
		this.fk_itemid = fk_itemid;
	}

	




	@Override
	public String toString() {
		return "id: " + id + ", customer id: " + fk_customerid + ", item id: " + fk_itemid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fk_customerid == null) ? 0 : fk_customerid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((fk_itemid == null) ? 0 : fk_itemid.hashCode());
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
		if (getFk_customerid() == null) {
			if (other.getFk_customerid() != null)
				return false;
		} else if (!getFk_customerid().equals(other.getFk_customerid()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (fk_itemid == null) {
			if (other.fk_itemid != null)
				return false;
		} else if (!fk_itemid.equals(other.fk_itemid))
			return false;
		return true;
	}

}
