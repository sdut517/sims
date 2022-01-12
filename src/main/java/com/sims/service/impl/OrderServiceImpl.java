package com.sims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sims.dao.OrderMapper;
import com.sims.dao.StuffMapper;
import com.sims.dao.SupplierMapper;
import com.sims.dao.TypeMapper;
import com.sims.dao.UserMapper;
import com.sims.pojo.Order;
import com.sims.pojo.OrderExample;
import com.sims.pojo.Stuff;
import com.sims.pojo.Supplier;
import com.sims.pojo.Type;
import com.sims.pojo.User;
import com.sims.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private TypeMapper typeMapper;
	@Autowired
	private StuffMapper stuffMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public long countByExample(OrderExample example) {
		// TODO Auto-generated method stub
		return orderMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(OrderExample example) {
		// TODO Auto-generated method stub
		return orderMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return orderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.insert(record);
	}

	@Override
	public int insertSelective(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.insertSelective(record);
	}

	@Override
	public List<Order> selectByExample(OrderExample example) {
		// 查询所有订单信息
		List<Order> orders = orderMapper.selectByExample(example);
		Type type = null;
		Stuff stuff = null;
		Supplier supplier = null;
		User user = null;
		for (Order order : orders) {
			// 设置订单中的类别信息
			type = typeMapper.selectByPrimaryKey(order.getTypeId());
			order.setType(type);
			order.setTypeName(type.getType());

			// 设置订单中的供货商信息
			supplier = supplierMapper.selectByPrimaryKey(order.getSupplierId());
			order.setSupplier(supplier);
			order.setSupplierName(supplier.getName());

			// 设置订单中的商品信息
			stuff = stuffMapper.selectByPrimaryKey(order.getStuffId());
			order.setStuff(stuff);
			order.setStuffName(stuff.getName());

			// 设置订单中的人员细信息
			user = userMapper.selectByPrimaryKey(order.getUserId());
			order.setUser(user);
			order.setUserName(user.getName());
		}
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public Order selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Order record, OrderExample example) {
		// TODO Auto-generated method stub
		return orderMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Order record, OrderExample example) {
		// TODO Auto-generated method stub
		return orderMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKey(record);
	}

}
