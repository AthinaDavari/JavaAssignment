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
 * @author athinaDavari
 */
public class SOrder {

    private int id;
    private Supplier supplier;
    private Status status;
    private Timestamp created_at;

    public SOrder() {
    }

    public SOrder(Supplier supplier) {
        this.supplier = supplier;
        this.status = Status.pending;
    }

    public SOrder(int id, Supplier supplier_id, String status, Timestamp created_at) {
        this.id = id;
        this.supplier = supplier;
        this.status = Status.valueOf(status);
        this.created_at = created_at;
    }

    enum Status {
        delivered, pending;
    }

    public int getId() {
        return id;
    }

    public Supplier getSupplier() {
        return supplier;
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

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.supplier);
        hash = 37 * hash + Objects.hashCode(this.status);
        hash = 37 * hash + Objects.hashCode(this.created_at);
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
        if (!Objects.equals(this.supplier, other.supplier)) {
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
        return "SOrder{" + "id=" + id + ", supplier=" + supplier + ", status=" + status + ", created_at=" + created_at + '}';
    }

}
