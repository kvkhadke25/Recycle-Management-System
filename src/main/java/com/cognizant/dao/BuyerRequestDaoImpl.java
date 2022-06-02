package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.model.BuyerRequest;

@Component
public class BuyerRequestDaoImpl implements BuyerRequestDao {

	@Autowired
	JdbcTemplate template;

	public List<BuyerRequest> viewBuyerOrders() {
		String sql = "select * from buyer_request";
		List<BuyerRequest> orders = template.query(sql, new BeanPropertyRowMapper(BuyerRequest.class));
		return orders;
	}

	public int update(int requestId, String status) {
		String sql = "update buyer_request set status= '" + status + "' where request_id=" + requestId;
		return template.update(sql);
	}
}
