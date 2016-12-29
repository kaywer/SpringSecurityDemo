package com.geekarms.service;

import com.geekarms.dao.UserDao;
import com.geekarms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by kaywer on 2016/12/28.
 */
@Service
@Transactional
public class LoginService {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public void informSpringUser(User user){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        Authentication auth = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public User login(String login, String password){
        User user = userService.getUserByLoginAndPassword(login, password);
        if (user == null){
            throw new RuntimeException("账号密码出错");
        }
        informSpringUser(user);
        return user;
    }
}
