/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.entity;

import java.util.Objects;

/**
 *
 * @author Athina P.
 */
public class COrderItem {

    private COrder corder;
    private Product product;
    private int quantity;

    public COrderItem() {
    }

    public COrderItem(COrder corder, Product product, int quantity) {
        this.corder = corder;
        this.product = product;
        this.quantity = quantity;
    }

    public COrder getCorder() {
        return corder;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCorder(COrder corder) {
        this.corder = corder;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.corder);
        hash = 11 * hash + Objects.hashCode(this.product);
        hash = 11 * hash + this.quantity;
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

    @Override
    public String toString() {
        return "COrderItem{" + "corder=" + corder + ", product=" + product + ", quantity=" + quantity + '}';
    }

    

}
