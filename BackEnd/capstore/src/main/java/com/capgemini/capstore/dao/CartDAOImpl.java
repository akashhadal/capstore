package com.capgemini.capstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.WishlistBean;

@Repository
@SuppressWarnings("unchecked")
public class CartDAOImpl implements CartDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addToCart(String email, ProductBean productBean, int productQuantity) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String userEmailQuery = "from LoginBean where email = :email";
		Query query = entityManager.createQuery(userEmailQuery);
		query.setParameter("email", email);

		String productIdQuery = "from ProductBean where productId = :productId";
		Query query1 = entityManager.createQuery(productIdQuery);
		query1.setParameter("productId", productBean.getProductId());

		boolean isproductAdded = false;
		CartBean cartBean = new CartBean();
		cartBean.setEmail(email);
		cartBean.setProductId(productBean.getProductId());
		cartBean.setProductName(productBean.getProductName());
		cartBean.setProductImage(productBean.getProductImage());
		cartBean.setProductPrice(productBean.getProductPrice());
		cartBean.setBrandName(productBean.getProductBrandName());
		cartBean.setProductCategory(productBean.getProductCategory());
		cartBean.setProductDiscount(productBean.getProductDiscount());
		cartBean.setProductDiscountExpireDate(productBean.getProductDiscountExpiryDate());
		cartBean.setPurchaseQuantity(productQuantity);

		try {
			entityTransaction.begin();
			entityManager.persist(cartBean);
			entityTransaction.commit();
			isproductAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isproductAdded;
	}

	@Override
	public List<CartBean> displayCart(String email) {
		int productId = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<CartBean> cartlist = null;

		String userEmailQuery = "from LoginBean where email = :email";
		Query query = entityManager.createQuery(userEmailQuery);
		query.setParameter("email", email);

		String productIdQuery = "from ProductBean where productId = :productId";
		Query query1 = entityManager.createQuery(productIdQuery);
		query1.setParameter("productId", productId);

		try {
			String jpql = "FROM CartBean WHERE email =: email";
			Query query2 = entityManager.createQuery(jpql);
			query2.setParameter("email", email);
			cartlist = query2.getResultList();
			entityManager.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartlist;
	}

	@Override
	public boolean removeFromCart(String email, int productId) {
		boolean isproductRemoved = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String productIdQuery = "from CartBean where email = :email AND productId = :productId";
		Query query1 = entityManager.createQuery(productIdQuery);
		query1.setParameter("productId", productId);
		query1.setParameter("email", email);
		CartBean cartBean = (CartBean) query1.getSingleResult();

		try {
			entityTransaction.begin();
			entityManager.remove(cartBean);
			entityTransaction.commit();
			isproductRemoved = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isproductRemoved;
	}
}
