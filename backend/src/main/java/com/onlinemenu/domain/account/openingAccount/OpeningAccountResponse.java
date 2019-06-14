package com.onlinemenu.domain.account.openingAccount;

import lombok.Data;

@Data
public class OpeningAccountResponse {

    private Boolean success;

    private String description;

    private String password;

    public OpeningAccountResponse(Boolean success, String description, String password) {
        this.success = success;
        this.description = description;
        this.password = password;
    }
}
