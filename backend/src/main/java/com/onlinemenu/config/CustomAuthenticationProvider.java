package com.onlinemenu.config;

import com.onlinemenu.domain.account.Account;
import com.onlinemenu.domain.account.AccountRequest;
import com.onlinemenu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private AccountService accountService;

  @Autowired
  public CustomAuthenticationProvider(AccountService accountService) {
    this.accountService = accountService;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String name = authentication.getName();

    Object credentials = authentication.getCredentials();
    if (!(credentials instanceof String)) {
      return null;
    }
    String password = credentials.toString();

    Account account = this.accountService.validate(new AccountRequest(name, password));

    if (account == null) {
      throw new BadCredentialsException("Authentication failed for " + name);
    }

    return new UsernamePasswordAuthenticationToken(name, password, null);
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
