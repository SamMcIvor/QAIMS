package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.utils.Utils;


public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}


	@Override
	public Order create() {
		LOGGER.info("Please enter an customer id");
		Long customerid = utils.getLong();
		Order order = orderDAO.create(new Order(null, customerid));
		LOGGER.info("Order created");
		return order;
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

	@Override
	public Order update() {
		return null;
	}


	@Override
	public void additem() {
		// TODO Auto-generated method stub
	}


	@Override
	public void ordercost() {
		// TODO Auto-generated method stub
	}

}