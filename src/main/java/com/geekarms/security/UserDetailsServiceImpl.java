package com.geekarms.security;

import com.geekarms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kaywer on 2016/12/28.
 */
@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Session session = sessionFactory.getCurrentSession();
        String hql = "From User Where login= :login";
        Query query = session.createQuery(hql);
        query.setParameter("login", login);
        User user = (User) query.uniqueResult();
        return user;
    }
}
