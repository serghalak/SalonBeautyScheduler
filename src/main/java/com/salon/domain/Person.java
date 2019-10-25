package com.salon.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class Person {

    @NotBlank(message="First name cannot be empty")
    @Column(name="FIRST_NAME")
    private String firstName;

    @NotBlank(message="Last name cannot be empty")
    @Column(name="LAST_NAME")
    private String lastName;

    @NotBlank(message="Phone number cannot be empty")
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
