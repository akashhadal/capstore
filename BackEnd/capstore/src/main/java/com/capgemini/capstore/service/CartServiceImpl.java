package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.dao.CartDAO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public boolean addToCart(String email, ProductBean productBean, int productQuantity) {
		return cartDAO.addToCart(email, productBean, productQuantity);
	}

	@Override
	public boolean removeFromCart(String email, int productId) {
		return cartDAO.removeFromCart(email, productId);
	}

	@Override
	public List<CartBean> displayCart(String email) {
		return cartDAO.displayCart(email);
	}


}
