package com.springsecu.mysql.config;

import com.springsecu.mysql.repository.UserRepository;
import com.springsecu.mysql.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //enables spring security
@EnableJpaRepositories(basePackageClasses = UserRepository.class) //injects all the classes that we need from the JPArepo
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  //load the data from the database instead of
  // spring maintaining the username and password

  @Autowired
  private CustomUserDetailsService userDetailsService; //it is an interface, implemented here

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
    .passwordEncoder(getPasswordEncoder()); //connects to the database and gets the data
  }

  private PasswordEncoder getPasswordEncoder() {
    return new PasswordEncoder() {
      @Override
      public String encode(CharSequence charSequence) {
        return charSequence.toString();
      }

      @Override
      public boolean matches(CharSequence charSequence, String s) {
        return true;
      }
    };
  }
}
