package com.springsecu.mysql.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {

  @GetMapping("/all")
  public String hello(){
    return "Hello Youtube";
  }

  @PreAuthorize("hasAnyRole('ADMIN')") //this endpoint can be called when the user has admin role (+ annotiation in security config class)
  @GetMapping("/secured/all")
  public String securedHello() {
    return "Secured Hello";
  }
}
