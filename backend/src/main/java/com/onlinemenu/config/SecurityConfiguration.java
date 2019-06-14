package com.onlinemenu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private CustomAuthenticationProvider authenticationProvider;

  @Autowired
  public SecurityConfiguration(CustomAuthenticationProvider authenticationProvider) {
    this.authenticationProvider = authenticationProvider;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(this.authenticationProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.headers().frameOptions().sameOrigin()
      .and()
      .authorizeRequests()
      .antMatchers("/favicon.ico", "/", "/login", "/api/account/validate", "/api/account", "/*.js").permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .usernameParameter("username")
      .passwordParameter("password")
      .loginPage("/login")
      .loginProcessingUrl("/api/account/validate")
      .and()
      .csrf().disable()
      .logout()
      .logoutSuccessUrl("/logout")
      .deleteCookies("JSESSIONID");
  }
}
