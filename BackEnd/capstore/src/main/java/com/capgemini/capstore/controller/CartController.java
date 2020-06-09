package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.WishlistBean;
import com.capgemini.capstore.response.CapStoreResponse;
import com.capgemini.capstore.service.CartService;

@RestController
//To connect rest with angular
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping(path = "/addToCart")
	public CapStoreResponse addToCart(@RequestParam String email, @RequestParam int productId) {
		boolean isAdded = cartService.addToCart(email, productId);
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if	 (isAdded) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Product added to cart !");

		} else {
			capStoreResponse.setStatusCode(401);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Enable to add product to cart !");
		}
		return capStoreResponse;
	}
	
	@DeleteMapping(path = "/removeFromCart")
	public CapStoreResponse removeFromCart(@RequestParam String email, @RequestParam int productId) {
		boolean isRemoved = cartService.removeFromCart(email, productId);
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if (isRemoved) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Product removed from cart !");
		} else {
			capStoreResponse.setStatusCode(401);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Unable to remove product from cart !");
		}
		return capStoreResponse;
	}
	
	@GetMapping(path = "/displayCartlist")
	public CapStoreResponse displayCartlist(@RequestParam String email) {
		List<CartBean> displayCartlist = cartService.displayCart(email);
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if (displayCartlist != null) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDisplayCartlist(displayCartlist);
			capStoreResponse.setDescription("Cartlist displayed !");
		} else {
			capStoreResponse.setStatusCode(401);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Unable to display Cartlist !");
		}
		return capStoreResponse;
	}
	
	@GetMapping(path = "/displayCartProductlist")
	public CapStoreResponse displayCartProductlist(@RequestParam String email) {
		List<ProductBean> displayCartProductList = cartService.displayCartProduct(email);
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if (displayCartProductList != null) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDisplayCartProductlist(displayCartProductList);
			//capStoreResponse.setDisplayWishlist(displayWishlist);
			capStoreResponse.setDescription("Cartlist displayed !");
		} else {
			capStoreResponse.setStatusCode(401);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Unable to display Cartlist !");
		}
		return capStoreResponse;
	}
}
