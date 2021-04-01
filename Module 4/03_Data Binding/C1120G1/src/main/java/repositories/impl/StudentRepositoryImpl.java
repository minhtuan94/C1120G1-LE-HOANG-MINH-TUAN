package repositories.impl;

import models.Student;
import repositories.StudentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {
    private static Map<Integer, Student> listMap;

    static {
        listMap = new HashMap<>();
        listMap.put(1, new Student(1, "Sang", 24, "Java"));
        listMap.put(2, new Student(2, "Hoang", 24, "PHP"));
        listMap.put(3, new Student(3, "Vy", 24, "C#"));
        listMap.put(4, new Student(4, "Long", 24, "NodeJs"));
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(listMap.values());
    }

    @Override
    public void save(Student student) {
        listMap.put(student.getId(), student);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }
}
