package repositories;

import java.util.List;

public interface CRUDRepository<T> {
    List<T> findAll();
    void save(T t);
    void deleteById(int id);
    T findById(int id);
}
