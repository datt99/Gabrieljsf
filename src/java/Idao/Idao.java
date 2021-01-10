package Idao;

import java.util.List;

/**
 *
 * @author elDantru99
 */
public interface Idao<T,V> {
    boolean inserOne(T model);
    boolean deleteOne(V idModel);
    boolean updateOne(T model);
    T readOne(V idModel);
    List<T> readAllRecords();
    
}
