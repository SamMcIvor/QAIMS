package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qa.ims.persistence.domain.OrderItem;

public interface Dao<T> {

	List<T> readAll() throws SQLException;
	
	T read(Long id);

	T create(T t);

	T update(T t);

	int delete(Long id);

	T modelFromResultSet(ResultSet resultSet) throws SQLException;

	OrderItem additem(OrderItem orderItem);
}
