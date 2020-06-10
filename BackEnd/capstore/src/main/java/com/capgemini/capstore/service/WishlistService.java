package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.WishlistBean;

public interface WishlistService {

	public boolean addToWishlist(String email,ProductBean productBean);

	public boolean removeFromWishlist(String email, int productId);

	public List<WishlistBean> displayWishlist(String email);
}
