package rikkei.academy.service;

import java.util.List;

public interface IGenericService <T> {
    List<T> findALl();

    void save(T t);



}
