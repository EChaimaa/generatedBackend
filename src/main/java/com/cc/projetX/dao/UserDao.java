package com.cc.projetX.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cc.projetX.bean.User;

@Repository
public interface UserDao  extends JpaRepository<User, Long>{
User findByUsername(String username);
int deleteByUsername(String username);

User findByEmail(String email);

}
