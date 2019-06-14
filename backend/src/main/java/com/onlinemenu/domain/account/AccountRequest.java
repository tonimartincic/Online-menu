package com.onlinemenu.domain.account;

import lombok.Data;

@Data
public class AccountRequest {

  private String username;

  private String password;

  public AccountRequest() {
  }

  public AccountRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public String toString() {
    return "AccountRequest{" +
      "username='" + username + '\'' +
      '}';
  }
}
