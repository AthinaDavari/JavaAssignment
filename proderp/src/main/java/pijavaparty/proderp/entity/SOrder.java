package pijavaparty.proderp.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * SOrder.java - a class with the necessary getters and setters for a Supplier's
 * order
 *
 * @author athinaDavari
 */
public class SOrder {

    private int id;
    private Supplier supplier;
    private Status status;
    private Timestamp created_at;

    /**
     * A no-argument Constructor.
     */
    public SOrder() {
    }

    /**
     * A Constructor with arguments.
     *
     * @param supplier A Supplier data type object.
     */
    public SOrder(Supplier supplier) {
        this.supplier = supplier;
        this.status = Status.pending;
    }

    /**
     * A Constructor with arguments.
     *
     * @param id A variable of type int.
     * @param supplier A Supplier data type object.
     * @param status A variable of type String.
     * @param created_at A variable of type Timestamp.
     */
    public SOrder(int id, Supplier supplier, String status, Timestamp created_at) {
        this.id = id;
        this.supplier = supplier;
        this.status = Status.valueOf(status);
        this.created_at = created_at;
    }

    /**
     * A Constructor with arguments.
     *
     * @param supplier A Supplier data type object.
     * @param status A variable of type String.
     */
    public SOrder(Supplier supplier, String status) {
        this.supplier = supplier;
        this.status = Status.valueOf(status);
    }

    /**
     * Enable to status to be a set of predefined constants.
     */
    enum Status {
        delivered, pending;
    }

    /**
     * Retrieve the value of id.
     *
     * @return An int data type.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieve the value of supplier.
     *
     * @return A Supplier data type.
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Retrieve the value of status.
     *
     * @return A Status data type.
     */
    public String getStatus() {
        return status.name();
    }

    /**
     * Retrieve the value of created_at.
     *
     * @return A Timestamp data type.
     */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /**
     * Set the value of id.
     *
     * @param id A variable of type int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set the value of supplier.
     *
     * @param supplier A variable of type Supplier.
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Set the value of status.
     *
     * @param status A variable of type Status.
     */
    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    /**
     * Set the value of status.
     *
     * @param status A variable of type Status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Set the value of created_at.
     *
     * @param created_at A variable of type Timestamp.
     */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * Return the hash code value for this set.
     *
     * @return An int data type.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.supplier);
        hash = 97 * hash + Objects.hashCode(this.status);
        hash = 97 * hash + Objects.hashCode(this.created_at);
        return hash;
    }

    /**
     * Compares the specified object with this set for equality.
     *
     * @param obj A variable of type Object.
     * @return A boolean data type.
     */
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

    /**
     * Return a string representation of this collection.
     *
     * @return A String data type.
     */
    @Override
    public String toString() {
        return "SOrder{" + "id=" + id + ", supplier=" + supplier + ", status=" + status + ", created_at=" + created_at + '}';
    }

}
