package com.adc.issue.repository;

import com.adc.issue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Long> {


  User findByUsername(String username);
}
