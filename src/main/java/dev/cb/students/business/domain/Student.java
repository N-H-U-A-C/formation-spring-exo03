package dev.cb.students.business.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

public class Student {

//    @Size(min = 36, max = 36)
    private UUID id;

    @NotBlank(message = "First name may not be null or blank")
    private String firstName;

    @NotBlank(message = "Last name may not be null or blank")
    private String lastName;

    @NotBlank(message = "Email may not be null")
//    @Email(message = "Must be a valid email")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date of birth may not be null")
    private LocalDate dateOfBirth;

    public Student() {
    }

    public Student(UUID id, String firstName, String lastName, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public void update(Student updatedStudent) {
        this.setFirstName(updatedStudent.getFirstName());
        this.setLastName(updatedStudent.getLastName());
        this.setEmail(updatedStudent.getEmail());
        this.setDateOfBirth(updatedStudent.getDateOfBirth());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
