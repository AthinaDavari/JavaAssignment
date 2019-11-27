/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.util.List;

/**
 *
 * @author Natalia
 */
public interface DaoI<T> {

    List<T> getAll();

    
    void insert(T t);
    
    void update(T t);
    
    void delete(int id);
    
    void deletePermanently(int id);

}
