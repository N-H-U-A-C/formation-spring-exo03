package dev.cb.students.business.service;

import dev.cb.students.business.domain.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {

    boolean save(Student student);

    List<Student> getAllByLastName(String lastName);

    Optional<Student> getById(UUID id);

    void update(Student student);

    boolean delete(UUID id);

}
