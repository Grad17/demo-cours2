package pro.sky.democours2.service;

import org.springframework.stereotype.Service;
import pro.sky.democours2.Question;
import pro.sky.democours2.exception.QuestionAlreadyAddedException;
import pro.sky.democours2.exception.QuestionNotFoundException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    public List<Question> examQuestion = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        for (int i = 0; i < examQuestion.size(); i++) {
            if (newQuestion.equals(examQuestion.get(i))) {
                throw new QuestionAlreadyAddedException();
            }
        }
        examQuestion.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        for (int i = 0; i < examQuestion.size(); i++) {
            if (question.equals(examQuestion.get(i))) {
                throw new QuestionAlreadyAddedException();
            }
        }
        examQuestion.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        for (int i = 0; i < examQuestion.size(); i++) {
            if (question.equals(examQuestion.get(i))) {
                examQuestion.remove(question);
                return question;
            }
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return examQuestion;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int numberQuestion = random.nextInt(examQuestion.size());
        return examQuestion.get(numberQuestion);
    }
}
