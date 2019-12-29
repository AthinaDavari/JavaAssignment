package gr.aueb.dmst.pijavaparty.proderp.dao;

import java.util.List;

/**
 *
 * @author Natalia
 * @param <T>
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
