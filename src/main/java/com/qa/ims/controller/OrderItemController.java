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
	private Long orderid;

	public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {
		super();
		this.orderItemDAO = orderItemDAO;
		this.utils = utils;
	}

	@Override
	public List<OrderItem> readAll() {
		List<OrderItem> orderItems = orderItemDAO.readWhere(orderid);
		for (OrderItem orderItem : orderItems) {
			LOGGER.info(orderItem);
		}
		return orderItems;
	}

	@Override
	public OrderItem create() {
		LOGGER.info("Please enter an Item id");
		Long itemid = utils.getLong();
		OrderItem orderItem = orderItemDAO.create(new OrderItem(this.orderid, itemid));
		return orderItem;
	}

	@Override
	public OrderItem update() {
		LOGGER.info("Please enter an item-id");
		Long itemid = utils.getLong();
		OrderItem order = orderItemDAO.update(new OrderItem(orderid, itemid));
		LOGGER.info("Order-Item updated");
		return order;
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete from");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long itemId = utils.getLong();
		if (orderItemDAO.deleteIFO(orderId, itemId)) {
			LOGGER.info("Order-Item deleted.");
		} else {
			LOGGER.info("Order or Item ID doesn't exist.");
		}
		return -1;
	}

	@Override
	public void additem() {
		LOGGER.info("Please enter an order id to add to");
		Long orderid = utils.getLong();
		LOGGER.info("Please enter an item id to add to the order");
		Long itemid = utils.getLong();
		orderItemDAO.additem(new OrderItem(orderid, itemid));
		LOGGER.info("Item added to order");
		return;

	}

	@Override
	public void ordercost() {
		LOGGER.info("Please enter the id of the order you would like to read the cost of");
		Long orderid = utils.getLong();
		String value = orderItemDAO.calculateOrderCost(orderid);
		System.out.println("Price of order: " + orderid + " is: " + value);

	}
}