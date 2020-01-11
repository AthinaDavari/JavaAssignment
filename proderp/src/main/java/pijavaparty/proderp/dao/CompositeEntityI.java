/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

/**
 *
 * @author Natalia
 * @param <T>
 */
public interface CompositeEntityI<T> extends DaoI<T>{
    
    /**
     *
     * @param id1
     * @param id2
     */
    void delete(int id1, int id2);
    
    /**
     *
     * @param id1
     * @param id2
     * @return
     */
    T getByIds(int id1, int id2);

}
