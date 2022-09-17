package pro.sky.democours2.service;

import org.springframework.stereotype.Service;
import pro.sky.democours2.Question;
import pro.sky.democours2.exception.ThereAreNotEnoughQuestionsException;
import pro.sky.democours2.service.ExaminerService;
import pro.sky.democours2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Random random;
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> listQuestions = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new ThereAreNotEnoughQuestionsException();
        }
        while (listQuestions.size() < amount) {
            listQuestions.add(questionService.getRandomQuestion());
        }
        return listQuestions;
    }
}
