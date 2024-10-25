package com.example.demo.service;

import java.util.List;

public interface BaseService<D,M> {
    List<D> getAll();
    int add(M m);
    int update(int id,M m);
    int delete(int id);
}
