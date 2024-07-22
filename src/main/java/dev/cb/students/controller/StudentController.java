package dev.cb.students.controller;

import dev.cb.students.business.domain.Student;
import dev.cb.students.business.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/save")
    public String getSaveForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping()
    public String getAllByLastName(@RequestParam(name = "lastName", required = false) String lastName,
                                   Model model) {
        model.addAttribute("students", studentService.getAllByLastName(lastName));
        if (lastName == null) {
            return "/students/list";
        } else {
            return "/students/search";
        }
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable UUID id, Model model) {
        model.addAttribute("student", studentService.getById(id));
        return "/students/detail";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable UUID id, Model model) {
        Optional<Student> optionalStudent = studentService.getById(id);
        optionalStudent.ifPresent(student -> model.addAttribute("student", student));
        return "students/form";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Student student) {
        studentService.update(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
