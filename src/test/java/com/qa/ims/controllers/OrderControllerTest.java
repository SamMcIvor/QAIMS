package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao; 

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long id = 1L;
		final Order created = new Order(id);

		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L));

		Mockito.when(dao.readAll()).thenReturn(orders);
		
		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}


	@Test
	public void testDelete() {
		final long customer = 1L;

		Mockito.when(utils.getLong()).thenReturn(customer);
		Mockito.when(dao.delete(customer)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(customer);
	}

}