package pijavaparty.proderp.entity;

import java.util.Objects;

/**
 * SOrderItem.java - a class with the necessary getters and setters for a
 * SOrderItem data type object.
 *
 * @author athinaDavari
 */
public class SOrderItem {

    private SOrder sorder;
    private RawMaterial rawmaterial;
    private int quantity;

    /**
     * A no-argument Constructor.
     */
    public SOrderItem() {
    }

    /**
     * A constructor with arguments.
     *
     * @param sorder A variable of type SOrder.
     * @param rawmaterial A variable of type RawMaterial.
     * @param quantity A variable of type int.
     */
    public SOrderItem(SOrder sorder, RawMaterial rawmaterial, int quantity) {
        this.sorder = sorder;
        this.rawmaterial = rawmaterial;
        this.quantity = quantity;
    }

    /**
     * Retrieve the value of sorder.
     *
     * @return A SOrder data type.
     */
    public SOrder getSorder() {
        return sorder;
    }

    /**
     * Retrieve the value of rawmaterial.
     *
     * @return A RawMaterial data type.
     */
    public RawMaterial getRawmaterial() {
        return rawmaterial;
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
     * Set the value of sorder.
     *
     * @param sorder A variable of type SOrder.
     */
    public void setSorder(SOrder sorder) {
        this.sorder = sorder;
    }

    /**
     * Set the value of rawmaterial.
     *
     * @param rawmaterial A variable of type RawMaterial.
     */
    public void setRawmaterial(RawMaterial rawmaterial) {
        this.rawmaterial = rawmaterial;
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
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.sorder);
        hash = 37 * hash + Objects.hashCode(this.rawmaterial);
        hash = 37 * hash + this.quantity;
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
        final SOrderItem other = (SOrderItem) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.sorder, other.sorder)) {
            return false;
        }
        if (!Objects.equals(this.rawmaterial, other.rawmaterial)) {
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
        return "SOrderItems{" + "sorder=" + sorder + ", rawmaterial=" + rawmaterial + ", quantity=" + quantity + '}';
    }

}
