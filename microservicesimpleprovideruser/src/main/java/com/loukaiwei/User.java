package com.loukaiwei;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "lkw")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String username;

    @Column
    private String myname;

    @Column
    private int age;

    @Column
    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }



    public String getMyname() {
        return myname;
    }

//    public void setMyname(String myname) {
//        this.myname = myname;
//    }

    public int getAge() {
        return age;
    }

//    public void setAge(int age) {
//        this.age = age;
//    }

    public String getUsername() {
        return username;
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }
}
