package pijavaparty.proderp.entity;

import java.util.Objects;

/**
 * ProductRawMaterial.java - a class with the necessary getters and setters for
 * a ProductRawMaterial data type object.  *
 * @author Natalia
 */
public class ProductRawMaterial {

    private int quantityOfRawMaterial;
    private Product product;
    private RawMaterial rawMaterial;

    /**
     * A no-argument Constructor.
     */
    public ProductRawMaterial() {
    }

    /**
     * A constructor with arguments.
     *
     * @param product A variable of type Product.
     * @param rawMaterial A variable of type RawMaterial.
     * @param quantityOfRawMaterial A variable of type int.
     */
    public ProductRawMaterial(Product product, RawMaterial rawMaterial, int quantityOfRawMaterial) {
        this.product = product;
        this.rawMaterial = rawMaterial;
        this.quantityOfRawMaterial = quantityOfRawMaterial;
    }

    /**
     * Retrieve the value of quantityOfRawMaterial.
     *
     * @return An int data type.
     */
    public int getQuantityOfRawMaterial() {
        return quantityOfRawMaterial;
    }

    /**
     * Set the value of quantityOfRawMaterial.
     *
     * @param quantityOfRawMaterial A variable of type int.
     */
    public void setQuantityOfRawMaterial(int quantityOfRawMaterial) {
        this.quantityOfRawMaterial = quantityOfRawMaterial;
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
     * Set the value of product.
     *
     * @param product A variable of type Product.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Retrieve the value of rawMaterial.
     *
     * @return A RawMaterial data type.
     */
    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    /**
     * Set the value of rawMaterial.
     *
     * @param rawMaterial A variable of type RawMaterial.
     */
    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    /**
     * Return the hash code value for this set.
     *
     * @return An int data type.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.quantityOfRawMaterial;
        hash = 47 * hash + Objects.hashCode(this.product);
        hash = 47 * hash + Objects.hashCode(this.rawMaterial);
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
        final ProductRawMaterial other = (ProductRawMaterial) obj;
        if (this.quantityOfRawMaterial != other.quantityOfRawMaterial) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.rawMaterial, other.rawMaterial)) {
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
        return "ProductRawMaterial{" + "quantityOfRawMaterial=" + quantityOfRawMaterial + ", product=" + product + ", rawMaterial=" + rawMaterial + '}';
    }

}
