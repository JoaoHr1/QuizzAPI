package dev.joao.QuizzAPI.domain.quiz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {
    @InjectMocks
    QuizService service;

    @Mock
    QuizRepository repository;

    Quiz quiz;

    @BeforeEach
    public void setUp() {
        quiz = new Quiz(5L, "Quanto é 2x2?", "4",  Materia.matematica);
    }

    @Test
    void deveBuscarPorMateria() {
        when(repository.findByMateria(quiz.getMateria())).thenReturn(Collections.singletonList(quiz));

        List<Quiz> quizzes = service.listByMateria(quiz.getMateria());

        assertEquals(Collections.singletonList(quiz), quizzes);

        verify(repository).findByMateria(quiz.getMateria());
        verifyNoMoreInteractions(repository);
    }

}
