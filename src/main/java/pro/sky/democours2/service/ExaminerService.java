package pro.sky.democours2.service;

import pro.sky.democours2.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
