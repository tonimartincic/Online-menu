package com.onlinemenu.service.impl;

import com.onlinemenu.domain.account.Account;
import com.onlinemenu.domain.account.AccountRequest;
import com.onlinemenu.domain.account.openingAccount.OpeningAccountRequest;
import com.onlinemenu.domain.account.openingAccount.OpeningAccountResponse;
import com.onlinemenu.enumeration.OpeningAccountDescription;
import com.onlinemenu.repository.AccountRepository;
import com.onlinemenu.service.AccountService;
import com.onlinemenu.util.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  private AccountRepository accountRepository;

  @Autowired
  public AccountServiceImpl(AccountRepository accountRepository) {
      this.accountRepository = accountRepository;
  }

  @Override
  public OpeningAccountResponse openAccount(OpeningAccountRequest openingAccountRequest) {
    if(accountAlreadyExists(openingAccountRequest.getAccountId())) {
        return new OpeningAccountResponse(Boolean.FALSE, OpeningAccountDescription.ALREADY_EXISTS.getDescription(), null);
    }

    String password = PasswordGenerator.generatePassword();
    Account account = new Account(openingAccountRequest.getAccountId(), password);
    this.accountRepository.save(account);

    return new OpeningAccountResponse(Boolean.TRUE, OpeningAccountDescription.SUCCESS.getDescription(), password);
  }

  private boolean accountAlreadyExists(String AccountId) {
        return this.accountRepository.findByUsername(AccountId) != null;
  }

  @Override
  public Account validate(AccountRequest accountRequest) {
    Account accountFromDatabase =  this.accountRepository.findByUsername(accountRequest.getUsername());
    if(accountFromDatabase == null) {
      return null;
    }

    if(!passwordIsCorrect(accountRequest, accountFromDatabase)) {
      return null;
    }

    return accountFromDatabase;
  }

  @Override
  public Account getAccountByUsername(String username) {
    return this.accountRepository.findByUsername(username);
  }

  private boolean passwordIsCorrect(AccountRequest accountRequest, Account accountFromDatabase) {
    return Account.PASSWORD_ENCODER.matches(accountRequest.getPassword(), accountFromDatabase.getPassword());
  }
}
