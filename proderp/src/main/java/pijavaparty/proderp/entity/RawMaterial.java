package pijavaparty.proderp.entity;

import java.util.Objects;

/**
 * RawMaterial.java - a class with the necessary getters and setters for a
 * RawMaterial data type object.
 *
 * @author Natalia
 */
public class RawMaterial {

    private int id;
    private String name;
    private int quantity;
    private double price;
    private Supplier supplier;

    /**
     * A no-argument Constructor.
     */
    public RawMaterial() {
    }

    /**
     * A constructor with arguments.
     *
     * @param name A variable of type String.
     * @param quantity A variable of type int.
     * @param price A variable of type Double.
     * @param supplier A variable of type Supplier.
     */
    public RawMaterial(String name, int quantity, double price, Supplier supplier) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
    }

    /**
     * A constructor with arguments.
     *
     * @param id A variable of type int
     * @param name A variable of type String.
     * @param price A variable of type Double.
     * @param supplier A variable of type Supplier.
     */
    public RawMaterial(int id, String name, double price, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
    }

    /**
     * A constructor with arguments.
     *
     * @param id A variable of type int.
     * @param name A variable of type String.
     * @param quantity A variable of type int.
     * @param price A variable of type Double.
     * @param supplier A variable of type Supplier.
     */
    public RawMaterial(int id, String name, int quantity, double price, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
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
     * Retrieve the value of name.
     *
     * @return A String data type.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name.
     *
     * @param name A variable of type String.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the value of quantity.
     *
     * @return An int data type.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity.
     *
     * @param quantity A variable of type int.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Retrieve the value of price.
     *
     * @return A Double data type.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the value of price.
     *
     * @param price A variable of type Double.
     */
    public void setPrice(double price) {
        this.price = price;
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
     * Set the value of supplier.
     *
     * @param supplier A variable of type Supplier.
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Return the hash code value for this set.
     *
     * @return An int data type.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.quantity;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.supplier);
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
        final RawMaterial other = (RawMaterial) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.supplier, other.supplier)) {
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
        return "RawMaterial{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", supplier=" + supplier + '}';
    }

}
