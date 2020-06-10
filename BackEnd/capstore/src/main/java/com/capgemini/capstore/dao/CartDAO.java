package com.capgemini.capstore.dao;

import java.util.List;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.ProductBean;

public interface CartDAO {

	public boolean addToCart(String email,ProductBean productBean,int productQuantity);

	public boolean removeFromCart(String email, int productId);

	public List<CartBean> displayCart(String email);
}
