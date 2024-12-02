package com.hitham.cruddemo.dao;

import com.hitham.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);
}
