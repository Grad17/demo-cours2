package pro.sky.democours2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.democours2.Question;
import pro.sky.democours2.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {

    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get")
    public Collection<Question> getQuestions(@RequestParam(name = "amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
