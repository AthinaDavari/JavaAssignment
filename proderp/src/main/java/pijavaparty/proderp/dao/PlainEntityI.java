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
public interface PlainEntityI<T> extends DaoI<T>{
    
    void delete(int id);
    
    T getById(int id);
    
    //int bringLastId();
    
}
