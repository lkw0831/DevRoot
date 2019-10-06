package com.loukaiwei;

import java.math.BigDecimal;

public final class UserBuilder {
    private String username;
    private String myname;
    private int age;
    private BigDecimal balance;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withMyname(String myname) {
        this.myname = myname;
        return this;
    }

    public UserBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder withBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public User build() {
        User user = new User();
        user.setUsername(username);
        user.setMyname(myname);
        user.setAge(age);
        user.setBalance(balance);
        return user;
    }
}
