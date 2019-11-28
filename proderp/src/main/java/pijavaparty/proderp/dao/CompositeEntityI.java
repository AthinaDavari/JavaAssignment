/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

/**
 *
 * @author Natalia
 */
public interface CompositeEntityI<T> extends DaoI<T>{
    
    void delete(int id1, int id2);
    
    T getByIds(int id1, int id2);

}
