/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.entity;

import java.util.Objects;

/**
 *
 * @author athinaDavari
 */
public class Customer {

    private int id;
    private String fullName;
    private String address;
    private Long phonenumber;
    private String email;

    public Customer() {
    }

    public Customer(String fullName, String address, Long phonenumber, String email) {
        this.fullName = fullName;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public Customer(int id, String fullName, String address, Long phonenumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.fullName);
        hash = 29 * hash + Objects.hashCode(this.address);
        hash = 29 * hash + Objects.hashCode(this.phonenumber);
        hash = 29 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phonenumber, other.phonenumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", fullName=" + fullName + ", address=" + address + ", phonenumber=" + phonenumber + ", email=" + email + '}';
    }

}