package com.codegym.demojpa.services;

import com.codegym.demojpa.models.Student;
import com.codegym.demojpa.models.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();

}
