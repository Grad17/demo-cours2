package pro.sky.democours2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.democours2.Question;
import pro.sky.democours2.exception.QuestionAlreadyAddedException;
import pro.sky.democours2.exception.QuestionNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.democours2.Constants.*;

class JavaQuestionServiceTest {

    private QuestionService questionService;
    private Question question1;
    private Question question2;

    @BeforeEach
    public void setUp() {
        questionService = new JavaQuestionService();
        question1 = new Question(QUESTION1, ANSWER1);
        question2 = new Question(QUESTION2, ANSWER2);
    }

    @Test
    void addQuestionOnQuestionAndAnswerTest() {
        Assertions.assertEquals(question1, questionService.add(QUESTION1, ANSWER1));
    }

    @Test
    void questionAlreadyAddedExceptionTest() {
        questionService.add(question1);
        Assertions.assertThrows(QuestionAlreadyAddedException.class,
                ()-> questionService.add(QUESTION1, ANSWER1));
    }

    @Test
    void testAddQuestionTest() {
        Assertions.assertEquals(question1, questionService.add(question1));
    }

    @Test
    void testQuestionAlreadyAddedExceptionTest() {
        questionService.add(question1);
        Assertions.assertThrows(QuestionAlreadyAddedException.class,
                ()-> questionService.add(question1));
    }

    @Test
    void removeTest() {
        questionService.add(question1);
        Assertions.assertEquals(question1, questionService.remove(question1));
    }

    @Test
    void questionNotFoundExceptionTest() {
        Assertions.assertThrows(QuestionNotFoundException.class,
                ()-> questionService.remove(question1));
    }

    @Test
    void getAllTest() {
        Collection<Question> actual = questionService.getAll();
        Collection<Question> expected = new ArrayList<>();
        expected.add(question1);
        expected.add(question2);
        questionService.add(question1);
        questionService.add(question2);
        Assertions.assertEquals(expected, questionService.getAll());
    }
}