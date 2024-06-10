package pro.sky.CourseWork_2.Controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.CourseWork_2.Model.Question;


import pro.sky.CourseWork_2.Service.ExaminerService;
import pro.sky.CourseWork_2.Service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {

        this.service = service;
    }

    @GetMapping()
    public Collection<Question> getQuestion(@PathVariable int amount) {
        return service.getQuestion(amount);
    }
}