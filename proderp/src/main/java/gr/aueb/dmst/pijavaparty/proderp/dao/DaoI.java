package gr.aueb.dmst.pijavaparty.proderp.dao;

import java.util.List;

/**
 * The most basic methods for handling database data
 * 
 * @author Natalia
 * @param <T> Entity class 
 */
public interface DaoI<T>{

    /**
     * Retrieve all T objects from database.
     * 
     * @return A List of type T objects.
     */
    List<T> getAll();
    
    /**
     * Insert an object
     * 
     * @param t An object of type T.
     */
    void insert(T t);
            
}
