package com.magnolia.dao;

import com.magnolia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *@author matas
 *@date  2020/9/6 16:52
 *@email   mataszhang@163.com
 */
public interface UserDao extends JpaRepository<User,Integer> {

}
