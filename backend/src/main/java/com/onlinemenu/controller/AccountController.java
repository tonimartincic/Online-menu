package com.onlinemenu.controller;

import com.onlinemenu.domain.account.Account;
import com.onlinemenu.domain.account.openingAccount.OpeningAccountRequest;
import com.onlinemenu.domain.account.openingAccount.OpeningAccountResponse;
import com.onlinemenu.service.AccountService;
import org.apache.commons.lang.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AccountController {

  private AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
      this.accountService = accountService;
  }

  @PostMapping("/api/account")
  public OpeningAccountResponse openAccount(@RequestBody final OpeningAccountRequest openingAccountRequest) {
    if (openingAccountRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.accountService.openAccount(openingAccountRequest);
  }

  @GetMapping("/api/account")
  public Account getLoggedUser(Principal principal) {
    if (principal == null
      || principal.getName() == null
      || principal.getName().isEmpty()) {
      return null;
    }

    return this.accountService.getAccountByUsername(principal.getName());
  }
}
