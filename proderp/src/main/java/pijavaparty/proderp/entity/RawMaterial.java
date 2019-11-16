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
public class RawMaterial {
    
    private int id;
    private String name;
    private int quantity;
    private double price;
    private Supplier supplier;

    public RawMaterial() {
    }

    public RawMaterial(String name, int quantity, double price, Supplier supplier) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
    }

    public RawMaterial(int id, String name, int quantity, double price, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

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

    @Override
    public String toString() {
        return "RawMaterial{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", supplierid=" + supplier.getId() + '}';
    }
    
}
