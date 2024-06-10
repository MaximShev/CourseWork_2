package pro.sky.CourseWork_2.Service;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.CourseWork_2.Exception.QuestionAlreadyAddedException;
import pro.sky.CourseWork_2.Exception.QuestionNotFoundException;
import pro.sky.CourseWork_2.Model.Question;

class JavaQuestionServiceTest {
    JavaQuestionService service = new JavaQuestionService();

    @Test
    public void add() {
        Question expected = new Question("вопрос 4", "ответ 4");
        Question actual = service.add("вопрос 4", "ответ 4");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAdd() {
        service.add("вопрос 1", "ответ 1");
        Assertions.assertThrows(QuestionAlreadyAddedException.class,
                () -> service.add(new Question("вопрос 1", "ответ 1")));
    }

    @Test
    void remove() {
        Assertions.assertThrows(QuestionNotFoundException.class,
                () -> service.remove(new Question("вопрос 4", "ответ 4")));
    }

    @Test
    void getAll() {
        Assertions.assertThrows(UnsupportedOperationException.class, () ->
                service.getAll().add(new Question("вопрос 1", "ответ 1")));
    }

    @Test
    public void getRandomQuestion() {
        Assertions.assertThrows(QuestionNotFoundException.class, () -> service.getRandomQuestion());
    }
}