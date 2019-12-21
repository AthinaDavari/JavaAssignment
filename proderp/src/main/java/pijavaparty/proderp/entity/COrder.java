package pijavaparty.proderp.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * COrder.java - a class for interacting and modifying the fields of a
 * customer's order.
 *
 * @author Athina P.
 */
public class COrder {

    private int id;
    private Customer customer;
    private Status status;
    private Timestamp created_at;
    private User user;

    /**
     * A no-argument Constructor.
     */
    public COrder() {
    }

    /**
     * A constructor with arguments.
     *
     * @param customer A variable of type Customer.
     * @param user A variable of type User.
     */
    public COrder(Customer customer, User user) {
        this.customer = customer;
        this.status = Status.ready;
        this.user = user;
    }

    /**
     * A constructor with arguments.
     *
     * @param id A variable of type int.
     * @param customer A variable of type Customer.
     * @param status A variable of type String.
     * @param created_at A variable of type Timestamp.
     * @param user A variable of type User.
     */
    public COrder(int id, Customer customer, String status, Timestamp created_at, User user) {
        this.id = id;
        this.customer = customer;
        this.status = Status.valueOf(status);
        this.created_at = created_at;
        this.user = user;
    }

    /**
     * Enable to status to be a set of predefined constants.
     */
    enum Status {
        preparing, ready, delivered;
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
     * Retrieve the value of customer.
     *
     * @return A Customer data type.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Retrieve the value of status.
     *
     * @return A String data type.
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
     * Set the value of customer.
     *
     * @param customer A variable of type Customer.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
     * Set the value of status.
     *
     * @param status A variable of type String.
     */
    public void setStatus(String status) {
        this.status = Status.valueOf(status);
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
     * Retrieve the value of user.
     *
     * @return A User data type.
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user.
     *
     * @param user A variable of type User.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Return the hash code value for this set.
     *
     * @return An int data type.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.customer);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + Objects.hashCode(this.created_at);
        hash = 59 * hash + Objects.hashCode(this.user);
        return hash;
    }

    /**
     * Compare the specified object with this set for equality.
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
        if (!Objects.equals(this.user, other.user)) {
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
        return "COrder{" + "id=" + id + ", customer=" + customer + ", status=" + status + ", created_at=" + created_at + ", user=" + user + '}';
    }

}
