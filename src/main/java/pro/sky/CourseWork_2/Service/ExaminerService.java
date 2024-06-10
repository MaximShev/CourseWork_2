package pro.sky.CourseWork_2.Service;

import pro.sky.CourseWork_2.Model.Question;
import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amound);
}