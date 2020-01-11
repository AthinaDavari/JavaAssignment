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
 * @param <T>
 */
public interface PlainEntityI<T> extends DaoI<T>{
    
    /**
     *
     * @param id
     */
    void delete(int id);
    
    /**
     *
     * @param id
     * @return
     */
    T getById(int id);

}
