/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.entity;

import java.util.Objects;

/**
 *
 * @author athinaDavari
 */
public class SOrderItem {

    private SOrder sorder;
    private RawMaterial rawmaterial;
    private int quantity;

    public SOrderItem() {
    }

    public SOrderItem(SOrder sorder, RawMaterial rawmaterial, int quantity) {
        this.sorder = sorder;
        this.rawmaterial = rawmaterial;
        this.quantity = quantity;
    }

    public SOrder getSorder() {
        return sorder;
    }

    public RawMaterial getRawmaterial() {
        return rawmaterial;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setSorder(SOrder sorder) {
        this.sorder = sorder;
    }

    public void setRawmaterial(RawMaterial rawmaterial) {
        this.rawmaterial = rawmaterial;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.sorder);
        hash = 37 * hash + Objects.hashCode(this.rawmaterial);
        hash = 37 * hash + this.quantity;
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

    @Override
    public String toString() {
        return "SOrderItems{" + "sorder=" + sorder + ", rawmaterial=" + rawmaterial + ", quantity=" + quantity + '}';
    }

}
