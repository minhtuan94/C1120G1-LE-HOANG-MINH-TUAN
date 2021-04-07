package com.codegym.demojpa.services;

import com.codegym.demojpa.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Page<Student> findAll(Pageable pageable);
    Student findById(int id);
    void deleteById(int id);
    void save(Student student);
    List<Student> searchByName(String name);
}
