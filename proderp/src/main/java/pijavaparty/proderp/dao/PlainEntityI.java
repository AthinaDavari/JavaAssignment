package pijavaparty.proderp.dao;

import java.util.List;

/**
 * A class containing basic methods for handling data of entities
 * with no more than one foreign key.
 * 
 * @author Natalia
 * @param <T> Entity class. 
 */
public interface PlainEntityI<T> extends DaoI<T>{
    
    /**
     * Delete with given id.
     * 
     * @param id
     */
    void delete(int id);
    
    /**
     * Retrieve a specific item with given id.
     * 
     * @param id
     * @return An object of type T.
     */
    T getById(int id);

}
