package gr.aueb.dmst.pijavaparty.proderp.entity;

import java.util.Objects;

/**
 * Product.java - a class with the necessary getters and setters for a Product
 * data type object.
 *
 * @author Athina P.
 */
public class Product {

    private int id;
    private String name;
    private int quantity;
    private double price;

    /**
     * A no-argument Constructor.
     */
    public Product() {

    }

    /**
     * A Constructor with arguments.
     *
     * @param name A variable of type String.
     * @param quantity A variable of type int.
     * @param price A variable of type Double.
     */
    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * A Constructor with arguments.
     *
     * @param id A variable of type int.
     * @param name A variable of type String.
     * @param price A variable of type Double.
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * A Constructor with arguments.
     *
     * @param id A variable of type int.
     * @param name A variable of type String.
     * @param quantity A variable of type int.
     * @param price A variable of type Double.
     */
    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Retrieve the value of id.
     *
     * @return An int data type .
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
     * @return An int data type .
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
     * Return the hash code value for this set.
     *
     * @return An int data type.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + this.quantity;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
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
        final Product other = (Product) obj;
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
        return true;
    }

    /**
     * Return a string representation of this collection.
     *
     * @return A String data type.
     */
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
