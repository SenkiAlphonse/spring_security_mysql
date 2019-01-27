package com.springsecu.mysql.service;

import com.springsecu.mysql.model.CustomUserDetails;
import com.springsecu.mysql.model.User;
import com.springsecu.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optionalUser = userRepository.findByName(username); //this way no nullcheck it needed

    optionalUser
        .orElseThrow(() -> new UsernameNotFoundException("Username not found")); //if no user is found, throw an exception

    return optionalUser
        .map(CustomUserDetails::new).get();
  }
}
