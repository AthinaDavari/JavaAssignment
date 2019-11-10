/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author athina
 */
public class SOrder {
    private int id;
    private int supplier_id;
    private Status status;
    private Timestamp created_at;
    
    public SOrder() {
    }

    public SOrder(int supplier_id) {
        this.supplier_id = supplier_id;
        this.status = Status.pending;
    }

    
    public SOrder(int id, int supplier_id, String status, Timestamp created_at) {
        this.id = id;
        this.supplier_id = supplier_id;
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

    public int getSupplier_id() {
        return supplier_id;
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

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.supplier_id;
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
        final SOrder other = (SOrder) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.supplier_id != other.supplier_id) {
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
        return "SOrder{" + "id=" + id + ", supplier_id=" + supplier_id + ", status=" + status + ", created_at=" + created_at + '}';
    }
    
    
}
