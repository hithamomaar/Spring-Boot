package com.hitham.cruddemo.dao;

import com.hitham.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO {

    //field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create a query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        //return query result
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create a query
        TypedQuery<Student> query = entityManager.createQuery(
                                        "FROM Student  WHERE lastName = :theData", Student.class);

        //set parameter
        query.setParameter("theData", lastName);

        //return query result
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve student
        Student student = entityManager.find(Student.class, id);

        //delete student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return rowsDeleted;
    }
}
