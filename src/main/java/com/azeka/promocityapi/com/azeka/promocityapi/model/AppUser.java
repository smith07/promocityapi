package com.azeka.promocityapi.com.azeka.promocityapi.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @Column(name = "mail")
    private String mail;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "user_mail")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Address> addresses;

    @OneToMany
    @JoinColumn(name = "user_mail")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<UserRole> userRoles;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
