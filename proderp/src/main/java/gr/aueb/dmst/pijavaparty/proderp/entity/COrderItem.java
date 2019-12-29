package gr.aueb.dmst.pijavaparty.proderp.entity;

import java.util.Objects;

/**
 * COrderItem.java - a class with the necessary getters and setters for a
 * COrderItem data type object.
 *
 * @author Athina P.
 */
public class COrderItem {

    private COrder corder;
    private Product product;
    private int quantity;

    /**
     * A no-argument Constructor.
     */
    public COrderItem() {
    }

    /**
     * A constructor with arguments.
     *
     * @param corder A variable of type COrder.
     * @param product A variable of type Product.
     * @param quantity A variable of type int.
     */
    public COrderItem(COrder corder, Product product, int quantity) {
        this.corder = corder;
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Retrieve the value of corder.
     *
     * @return A COrder data type.
     */
    public COrder getCorder() {
        return corder;
    }

    /**
     * Retrieve the value of product.
     *
     * @return A Product data type.
     */
    public Product getProduct() {
        return product;
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
     * Set the value of corder.
     *
     * @param corder A variable of type COrder.
     */
    public void setCorder(COrder corder) {
        this.corder = corder;
    }

    /**
     * Set the value of product.
     *
     * @param product A variable of type Product.
     */
    public void setProduct(Product product) {
        this.product = product;
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
     * Return the hash code value for this set.
     *
     * @return An int data type.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.corder);
        hash = 11 * hash + Objects.hashCode(this.product);
        hash = 11 * hash + this.quantity;
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
        final COrderItem other = (COrderItem) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.corder, other.corder)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
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
        return "COrderItem{" + "corder=" + corder + ", product=" + product + ", quantity=" + quantity + '}';
    }

}
