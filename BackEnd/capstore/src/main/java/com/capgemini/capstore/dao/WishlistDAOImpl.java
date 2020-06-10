package com.capgemini.capstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.WishlistBean;

@Repository
@SuppressWarnings("unchecked")
public class WishlistDAOImpl implements WishlistDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addToWishlist(String email, ProductBean productBean) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String userEmailQuery = "from LoginBean where email = :email";
		Query query = entityManager.createQuery(userEmailQuery);
		query.setParameter("email", email);
		
		String productIdQuery = "from ProductBean where productId = :productId";
		Query query1 = entityManager.createQuery(productIdQuery);
		query1.setParameter("productId", productBean.getProductId());
		
		boolean isproductAdded = false;
		WishlistBean wishlistBean = new WishlistBean();
		wishlistBean.setEmail(email);
		wishlistBean.setProductId(productBean.getProductId());
		wishlistBean.setProductName(productBean.getProductName());
		wishlistBean.setProductImage(productBean.getProductImage());
		wishlistBean.setProductPrice(productBean.getProductPrice());
		wishlistBean.setBrandName(productBean.getProductBrandName());
		wishlistBean.setProductCategory(productBean.getProductCategory());
		wishlistBean.setProductDiscount(productBean.getProductDiscount());
		wishlistBean.setProductDiscountExpireDate(productBean.getProductDiscountExpiryDate());
		
		try {
			entityTransaction.begin();
			entityManager.persist(wishlistBean);
			entityTransaction.commit();
			isproductAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isproductAdded;
	}

	@Override
	public boolean removeFromWishlist(String email, int productId) {
		boolean isproductRemoved = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		String productIdQuery = "from WishlistBean where email = :email AND productId = :productId";
		Query query1 = entityManager.createQuery(productIdQuery);
		query1.setParameter("productId", productId);
		query1.setParameter("email", email);
		WishlistBean wishlistBean = (WishlistBean) query1.getSingleResult();

		try {
			entityTransaction.begin();
			entityManager.remove(wishlistBean);
			entityTransaction.commit();
			isproductRemoved = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isproductRemoved;
	}

	@Override
	public List<WishlistBean> displayWishlist(String email) {
		
		int productId = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<WishlistBean> wishlist = null;
		
		String userEmailQuery = "from LoginBean where email = :email";
		Query query = entityManager.createQuery(userEmailQuery);
		query.setParameter("email", email);
		
		String productIdQuery = "from ProductBean where productId = :productId";
		Query query1 = entityManager.createQuery(productIdQuery);
		query1.setParameter("productId", productId);
		
		try {
			String jpql = "FROM WishlistBean WHERE email =: email";
			Query query2 = entityManager.createQuery(jpql);
			query2.setParameter("email", email);
			wishlist = query2.getResultList();
			entityManager.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return wishlist;
	}

}
