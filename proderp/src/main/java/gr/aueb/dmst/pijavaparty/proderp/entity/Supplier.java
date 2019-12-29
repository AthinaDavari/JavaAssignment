package gr.aueb.dmst.pijavaparty.proderp.entity;

import java.util.Objects;

/**
 * Supplier.java - a class with the necessary getters and setters for a Supplier
 * data type object.
 *
 * @author Natalia
 */
public class Supplier {

    private int id;
    private String fullName;
    private String address;
    private Long phonenumber;
    private String email;

    /**
     * A no-argument Constructor.
     */
    public Supplier() {
    }

    /**
     * A Constructor with arguments.
     *
     * @param fullName A variable of type String.
     * @param address A variable of type String.
     * @param phonenumber A variable of type Long.
     * @param email A variable of type String.
     */
    public Supplier(String fullName, String address, Long phonenumber, String email) {
        this.fullName = fullName;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    /**
     * A Constructor with arguments.
     *
     * @param id A variable of type int.
     * @param fullName A variable of type String.
     * @param address A variable of type String.
     * @param phonenumber A variable of type Long.
     * @param email A variable of type String.
     */
    public Supplier(int id, String fullName, String address, Long phonenumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
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
     * Set the value of id.
     *
     * @param id A variable of type int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieve the value of fullName.
     *
     * @return A String data type.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Set the value of fullName.
     *
     * @param fullName A variable of type String.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Retrieve the value of address.
     *
     * @return A String data type.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address.
     *
     * @param address A variable of type String.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieve the value of phonenumber.
     *
     * @return A Long data type.
     */
    public Long getPhonenumber() {
        return phonenumber;
    }

    /**
     * Set the value of phonenumber.
     *
     * @param phonenumber A variable of type Long.
     */
    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * Retrieve the value of email.
     *
     * @return A String data type.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email.
     *
     * @param email A variable of type String.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return the hash code value for this set.
     *
     * @return An int data type.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.fullName);
        hash = 47 * hash + Objects.hashCode(this.address);
        hash = 47 * hash + Objects.hashCode(this.phonenumber);
        hash = 47 * hash + Objects.hashCode(this.email);
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
        final Supplier other = (Supplier) obj;
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

    /**
     * Returns a string representation of this collection.
     *
     * @return A String data type.
     */
    @Override
    public String toString() {
        return "Supplier{" + "id=" + id + ", fullName=" + fullName + ", address=" + address + ", phonenumber=" + phonenumber + ", email=" + email + '}';
    }

}
