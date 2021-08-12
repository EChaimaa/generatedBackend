package com.cc.projetX.service.facade;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

import com.cc.projetX.bean.User;

public interface UserService extends UserDetailsService {

List<User> findAll();


    User findByUsername(String username);


    User findById(Long id);


    void deleteById(Long id);



    User save(User user);


    User update(User user);


    int delete(User user);


    User findByUsernameWithRoles(String username);


    int  deleteByUsername(String username);
    public UserDetails loadUserByUsername(String username)  ;



    }
