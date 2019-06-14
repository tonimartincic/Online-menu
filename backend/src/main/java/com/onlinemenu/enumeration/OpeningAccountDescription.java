package com.onlinemenu.enumeration;

public enum OpeningAccountDescription {

    SUCCESS(1L, "Your account is opened"),
    ALREADY_EXISTS(2L, "Account with that ID already exists");

    private final Long id;

    private final String description;

    OpeningAccountDescription(final Long id, final String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
