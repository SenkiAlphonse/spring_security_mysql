package com.springsecu.mysql.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails extends User implements UserDetails {
  //extending our user class to have access to all the users


  public CustomUserDetails(final User user) {
    super(user);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    //checks all the roles configured in the constructions, collects them and adds to Spring security to use it
    return getRoles()
        .stream()
        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
        .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return super.getPassword(); //directly from the User model
  }

  @Override
  public String getUsername() {
    return super.getName();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
