package pro.sky.CourseWork_2.Service;

import pro.sky.CourseWork_2.Exception.AmountMoreThanRequiredException;
import pro.sky.CourseWork_2.Model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        Collection<Question> allQQuestion = service.getAll();
        if (service.getAll().size() < amount) {
            throw new AmountMoreThanRequiredException();
        }
        if (allQQuestion.size() == amount){
            return allQQuestion;
        }
        Set<Question> exam = new HashSet<>(amount);
        while (exam.size() != amount) {
            exam.add(service.getRandomQuestion());

        }
        return exam;
    }
}