package com.hitham.cruddemo.dao;

import com.hitham.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
