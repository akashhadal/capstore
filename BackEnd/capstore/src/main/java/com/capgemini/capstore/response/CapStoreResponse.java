package com.capgemini.capstore.response;

import java.util.List;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.WishlistBean;
import com.fasterxml.jackson.annotation.JsonInclude;

import gherkin.lexer.Ca;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CapStoreResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<WishlistBean> displayWishlist;
	private List<CartBean> displayCartlist;
	private List<ProductBean> displayCartProductlist;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<WishlistBean> getDisplayWishlist() {
		return displayWishlist;
	}
	
	public List<CartBean> getDisplayCartlist() {
		return displayCartlist;
	}

	public void setDisplayWishlist(List<WishlistBean> displayWishlist) {
		this.displayWishlist = displayWishlist;
	}
	
	public void setDisplayCartlist(List<CartBean> displayCartlist) {
		this.displayCartlist = displayCartlist;
	}

	public List<ProductBean> getDisplayCartProductlist() {
		return displayCartProductlist;
	}

	public void setDisplayCartProductlist(List<ProductBean> displayCartProductlist) {
		this.displayCartProductlist = displayCartProductlist;
	}
	
	
}
