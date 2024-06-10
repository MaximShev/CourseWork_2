package pro.sky.CourseWork_2.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;
import pro.sky.CourseWork_2.Exception.AmountMoreThanRequiredException;
import pro.sky.CourseWork_2.Model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void beforeEach() {
        Mockito.when(javaQuestionService.getAll()).thenReturn(
                List.of(
                        new Question("вопрос1", "ответ1"),
                        new Question("вопрос2", "ответ2"),
                        new Question("вопрос3", "ответ3")

                )
        );
    }

    @Test
    void getQuestion() {
        Assertions.assertThrows(AmountMoreThanRequiredException.class, () -> examinerService.getQuestion(4));
    }
}