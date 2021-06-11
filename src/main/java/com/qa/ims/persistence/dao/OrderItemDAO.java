package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO implements Dao<OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long orderid = resultSet.getLong("orderid");
		Long itemid = resultSet.getLong("itemid");
		return new OrderItem(id, orderid, itemid);
	}

	@Override
	public List<OrderItem> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items;");) {
			List<OrderItem> orderItems = new ArrayList<>();
			while (resultSet.next()) {
				orderItems.add(modelFromResultSet(resultSet));
			}
			return orderItems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public List<OrderItem> readWhere(Long orderid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items WHERE oid = " + orderid + ";");) {
			List<OrderItem> orderItems = new ArrayList<>();
			while (resultSet.next()) {
				orderItems.add(modelFromResultSet(resultSet));
			}
			return orderItems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY id DESC LIMIT 1;");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public OrderItem create(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO order_items(orderid, itemid) VALUES(" 
				+ orderItem.getOrderID() + ", " + orderItem.getItemID() + ");");
			return readLatest();
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public OrderItem readOrderItem(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items WHERE orderid = " + id + ";");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	@Override
	public OrderItem additem(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO ORDER_ITEMS (orderid, itemid) VALUES (" + orderItem.getOrderID() + ", " + orderItem.getItemID() + ");");
			return readOrderItem(orderItem.getOrderID());
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}


    public boolean deleteIFO(Long orderId, Long itemId) {
        try (Connection connection = DBUtils.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            statement.executeUpdate("delete from order_items where orderid = " + orderId + " and itemid = " + itemId + ";");
            return true;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Generic Exception - Something went seriously wrong.");
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return false;
    }

	@Override
	public OrderItem read(Long id) {
		return null;
	}

	@Override
	public OrderItem update(OrderItem t) {
		// TODO Auto-generated method stub
		return null;
	}
	public String calculateOrderCost(Long orderid) {
        try (Connection connection = DBUtils.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement
                        .executeQuery("SELECT sum(items.value) as value FROM order_items, items WHERE order_items.orderid = "
                                + orderid + " and items.id = order_items.itemid;");) {
            if (resultSet.next()) {
                return resultSet.getString(1);        
            }
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Generic Exception - Something went seriously wrong.");
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return "-1";
    }

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}