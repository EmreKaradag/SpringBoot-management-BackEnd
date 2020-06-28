package com.adc.issue.service.impl;

import com.adc.issue.entity.User;
import com.adc.issue.repository.UserRepository;
import com.adc.issue.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User save(User user) {

    if(user.getEmail()==null){

      throw new IllegalArgumentException("Username cannot be null");
    }

    user=userRepository.save(user);
    return user;
  }

  @Override
  public User getById(Long id) {
    return userRepository.getOne(id);
  }

  @Override
  public Page<User> getAllPageable(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @Override
  public User getByUsername(String username) {
    return userRepository.findByUsername(username);
  }
}
