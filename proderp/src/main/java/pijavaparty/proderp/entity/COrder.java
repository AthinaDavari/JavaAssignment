/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.entity;

import java.sql.Timestamp;
import java.util.Objects;
import javafx.scene.media.MediaPlayer;
/**
 *
 * @author Athina P.
 */
public class COrder {
    private int id;
    private Customer customer;
    private Status status;
    private Timestamp created_at;
    
    public COrder() {
}
    
public COrder(Customer customer) {
    this.customer = customer;
    this.status = Status.pending;
}

public COrder(int id, Customer customer_id, String status, Timestamp created_at) {
    this.id = id;
    this.customer = customer;
    this.status = Status.valueOf(status);
    this.created_at = created_at;
}


 enum Status
    { 
        delivered, pending; 
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status.name();
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.customer);
        hash = 53 * hash + Objects.hashCode(this.status);
        hash = 53 * hash + Objects.hashCode(this.created_at);
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
        final COrder other = (COrder) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.created_at, other.created_at)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "COrder{" + "id=" + id + ", customer=" + customer + ", status=" + status + ", created_at=" + created_at + '}';
    }

    