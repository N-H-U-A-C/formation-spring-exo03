package dev.cb.students.business.service;

import dev.cb.students.business.domain.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
public class StudentServiceImpl implements StudentService {

    private final List<Student> students;

    public StudentServiceImpl() {
        this.students = new ArrayList<>();
        students.add(new Student(UUID.randomUUID(), "Michael", "Jackson", "micheal.jackson@gmail.com", LocalDate.parse("1958-08-29")));
        students.add(new Student(UUID.randomUUID(), "Billy", "Crawford", "billy.crawford@gmail.com", LocalDate.parse("1982-05-16")));
        students.add(new Student(UUID.randomUUID(), "Joey", "Starr", "joey.starr@gmail.com", LocalDate.parse("1967-10-27")));
    }

    @Override
    public boolean save(Student student) {
        student.setId(UUID.randomUUID());
        return this.students.add(student);
    }

    @Override
    public Optional<Student> getById(UUID id) {
        return this.students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    @Override
    public List<Student> getAllByLastName(String lastName) {
        if (lastName == null) {
            return students;
        } else {
            return students.stream()
                    .filter(student -> student.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                    .toList();
        }
    }

    @Override
    public void update(Student updatedStudent) {
        getById(updatedStudent.getId()).ifPresent(s -> s.update(updatedStudent));
    }

    @Override
    public boolean delete(UUID id) {
        return this.students.removeIf(student -> student.getId().equals(id));
    }
}
