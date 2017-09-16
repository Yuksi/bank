package com.yuksi.repository;

import com.yuksi.specifications.Specification;

import java.util.List;

/**
 * Created by Yuksi on 14.09.2017.
 */
public interface IRepository<T> {

    boolean add(T item);
    boolean update(T item);
    boolean remove(T item);
    T getById(int id);
    List<T> query(Specification specification);

}
