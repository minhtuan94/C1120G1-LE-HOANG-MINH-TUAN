package com.codegym.repository.impl;

import com.codegym.entity.Student;
import com.codegym.repository.StudentRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public List<Student> findAll() {
//        Query typedQuery =
//                BaseRepository.entityManager.createNativeQuery("select * from student", Student.class);
        TypedQuery<Student> typedQuery =
                BaseRepository.entityManager.createQuery("select s from student s", Student.class);

        return typedQuery.getResultList();
    }

    @Override
    public Student findById(Integer id) {
//        Query typedQuery =
//                BaseRepository.entityManager.createNativeQuery(
//                        "select * from student where id = ?", Student.class);
//        TypedQuery<Student> typedQuery =
//                BaseRepository.entityManager.createQuery(
//                        "select s from student s where id = :id", Student.class);
//        typedQuery.setParameter("id", id);

//        return (Student) typedQuery.getSingleResult();
        return BaseRepository.entityManager.find(Student.class, id);
    }

    @Override
    public void save(Student student) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(student);
        entityTransaction.commit();
    }
}
