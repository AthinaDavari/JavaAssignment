/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.entity;

import java.util.Objects;

/**
 *
 * @author Natalia
 */
public class ProductRawMaterial {

    private int quantityOfRawMaterial;
    private Product product;
    private RawMaterial rawMaterial;

    public ProductRawMaterial() {
    }

    public ProductRawMaterial(Product product, RawMaterial rawMaterial, int quantityOfRawMaterial) {
        this.product = product;
        this.rawMaterial = rawMaterial;
        this.quantityOfRawMaterial = quantityOfRawMaterial;
    }

    public int getQuantityOfRawMaterial() {
        return quantityOfRawMaterial;
    }

    public void setQuantityOfRawMaterial(int quantityOfRawMaterial) {
        this.quantityOfRawMaterial = quantityOfRawMaterial;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.quantityOfRawMaterial;
        hash = 47 * hash + Objects.hashCode(this.product);
        hash = 47 * hash + Objects.hashCode(this.rawMaterial);
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

    @Override
    public String toString() {
        return "ProductRawMaterial{" + "quantityOfRawMaterial=" + quantityOfRawMaterial + ", product=" + product + ", rawMaterial=" + rawMaterial + '}';
    }
    
}
