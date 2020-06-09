package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.ProductBean;

public interface CartService {

	public boolean addToCart(String email, int productId);

	public boolean removeFromCart(String email, int productId);

	public List<CartBean> displayCart(String email);
	
	public List<ProductBean> displayCartProduct(String email);
}
