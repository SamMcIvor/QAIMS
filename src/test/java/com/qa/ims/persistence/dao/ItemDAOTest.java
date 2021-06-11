package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	
	private final ItemDAO DAO = new ItemDAO();
	
	@Before
	public void setup() {
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(2L, "1Item", 2.99);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Item", 1.99));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(ID, "Item", 1.99),
				DAO.readItem(ID));
	
	}
	
	@Test
	public void testToString() {
		final long ID = 1L;
		Item created = new Item(ID, "Item", 1.99);
		assertEquals(created.toString(), DAO.readItem(ID).toString());
	
	}
	
	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "Item1", 1.55);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1L, DAO.delete(1L));
	}
}