package dev.cb.students.controller;

import dev.cb.students.business.domain.Student;
import dev.cb.students.business.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String save(@Valid @ModelAttribute Student student, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            studentService.save(student);
            return "redirect:/students";
        } else {
            return "students/form";
        }
    }

    @GetMapping()
    public String getAllByLastName(@RequestParam(name = "lastName", required = false) String lastName,
                                   Model model) {
        if (lastName == null) {
            model.addAttribute("students", studentService.getAll());
            return "/students/list";
        } else {
            model.addAttribute("students", studentService.getAllByLastName(lastName));
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
