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
	public boolean addToCart(String email, int productId) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String userEmailQuery = "from LoginBean where email = :email";
		Query query = entityManager.createQuery(userEmailQuery);
		query.setParameter("email", email);
		
		String productIdQuery = "from ProductBean where productId = :productId";
		Query query1 = entityManager.createQuery(productIdQuery);
		query1.setParameter("productId", productId);
		
		boolean isproductAdded = false;
		CartBean cartBean = new CartBean();
		cartBean.setEmail(email);
		cartBean.setProductId(productId);
		
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

	@Override
	public List<CartBean> displayCart(String email) {
		int productId=0;
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
	public List<ProductBean> displayCartProduct(String email) {
		int productId = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<CartBean> cartlist = null;
		List<ProductBean> cartProductlist = null;

		
		try {
			String jpql = "FROM CartBean WHERE email =: email";
			Query query2 = entityManager.createQuery(jpql);
			query2.setParameter("email", email);
			cartlist = query2.getResultList();
			for (CartBean bean : cartlist) {
				System.err.println(bean.getProductId());
				productId =bean.getProductId();
				cartProductlist= cartlist(productId);
				
			}
//			for (CartBean cartBean : cartlist) {
//				String jpql1= "FROM ProductBean WHERE productId =: productId";
//				Query query3=entityManager.createQuery(jpql1);
//				query3.setParameter("productId", cartBean.getProductId());
//				cartProductlist = query3.getResultList();
//			}
			
			entityManager.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartProductlist;
}

	@Override
	public List<ProductBean> cartlist(int productId) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<ProductBean> cartProductlist = null;

		String jpql1= "FROM ProductBean WHERE productId =: productId";
		Query query3=entityManager.createQuery(jpql1);
		query3.setParameter("productId", productId);
		cartProductlist = query3.getResultList();
		return cartProductlist;
	}
}
