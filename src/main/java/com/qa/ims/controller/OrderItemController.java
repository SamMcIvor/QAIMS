package com.qa.ims.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController<OrderItem> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderItemDAO orderItemDAO;
	private Utils utils;
	private String orderid;
	
	public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {
		super();
		this.orderItemDAO = orderItemDAO;
		this.utils = utils;
	}



	@Override 
	public List<OrderItem> readAll() {
		List<OrderItem> orderItems = orderItemDAO.readWhere(orderid);
		for (OrderItem orderItem : orderItems) {
			LOGGER.info(orderItem.toString());
		}
		return orderItems;
	}
	
	@Override
	public OrderItem create() {
		LOGGER.info("Please enter an Item id");
		String itemid = utils.getString();
		OrderItem orderItem = orderItemDAO.create(new OrderItem(this.orderid, itemid));
		return orderItem;
	}
	
	@Override
	public OrderItem update() {
		LOGGER.info("Please enter an item-id");
		String itemid = utils.getString();
		OrderItem order = orderItemDAO.update(new OrderItem(orderid, itemid));
		LOGGER.info("Order-Item updated");
		return order;
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		String id = utils.getString();
		LOGGER.info("Order-Item deleted.");
		return orderItemDAO.delete(id);
	}
	@Override
	public OrderItem additem() {
		LOGGER.info("Please enter an item id to add to the order");
		String itemid = utils.getString();
		OrderItem order = orderItemDAO.additem(new OrderItem(orderid, itemid));
		LOGGER.info("Item added to order");
		return order;

	}
	public OrderItem ordercost() {
		LOGGER.info("Please enter the id of the order you would like to read the cost of");
		String orderid = utils.getString();
		return ordercost();
	}
}