package com.geekarms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.geekarms.entity.User;

import java.util.List;


@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;


	public User getUserByLoginAndPassword(String login, String password){
		Session session = sessionFactory.getCurrentSession();
		String hql = "From User Where login =:login And password =:password";
		Query query = session.createQuery(hql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		return (User) query.uniqueResult();
	}

}
