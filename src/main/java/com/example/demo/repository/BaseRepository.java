package com.example.demo.repository;

import java.util.List;

public interface BaseRepository<E> {
    List<E> getAll();
    int add(E e);
    int update(E e);
    int delete(int id);
}
