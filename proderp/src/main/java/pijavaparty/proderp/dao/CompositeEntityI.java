package pijavaparty.proderp.dao;

/**
 * A class containing basic methods for handling data of entities
 * with two foreign keys.
 * 
 * @author Natalia
 * @param <T> Entity class. 
 */
public interface CompositeEntityI<T> extends DaoI<T>{
    
    /**
     * Delete with given ids.
     * 
     * @param id1
     * @param id2
     */
    void delete(int id1, int id2);
    
    /**
     * Retrieve a specific item with given ids. 
     *      
     * @param id1
     * @param id2
     * @return An object of type T.
     */
    T getByIds(int id1, int id2);

}
