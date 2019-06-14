package com.onlinemenu.service;

import com.onlinemenu.domain.account.Account;
import com.onlinemenu.domain.account.AccountRequest;
import com.onlinemenu.domain.account.openingAccount.OpeningAccountRequest;
import com.onlinemenu.domain.account.openingAccount.OpeningAccountResponse;

public interface AccountService {

  OpeningAccountResponse openAccount(OpeningAccountRequest openingAccountRequest);

  Account validate(AccountRequest accountRequest);

  Account getAccountByUsername(String username);
}
