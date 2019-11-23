package com.pakotzy.kurzgesagt.config.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Created by P. Kot on 23-Nov-19.
 */

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {
  @Bean
  public MapReactiveUserDetailsService userDetailsService() {
    UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
    UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("password").roles("ADMIN").build();

    return new MapReactiveUserDetailsService(user, admin);
  }

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
    return httpSecurity.authorizeExchange().anyExchange()
        .authenticated().and().httpBasic()
          .and()
        .csrf().disable().build();
  }
}
