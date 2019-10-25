package com.salon.domain;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table
public class User extends Person /*implements UserDetails*/{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    //@Column
    private String activateCode;
    //@Column
    private boolean active;
    //@Column
    private String password;
    //@Column
    private String userName;
    private String userId;


    @ManyToOne
    @JoinColumn(name = "authorityId",referencedColumnName = "id")
    private Authority authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
