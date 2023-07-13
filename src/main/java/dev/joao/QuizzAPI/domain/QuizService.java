package dev.joao.QuizzAPI.domain;

import java.util.List;
import java.util.Optional;

import dev.joao.QuizzAPI.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> list() {
        Sort sort = Sort.by(Direction.ASC, "id");

        return quizRepository.findAll(sort);
    }

    public Optional<Quiz> listById(Long id) {
        quizRepository.findById(id).ifPresentOrElse((existingQuiz) -> quizRepository.findById(id), () -> {
            throw new BadRequestException("Quiz referente ao ID não existe!");
        });
        return quizRepository.findById(id);
    }

    public List<Quiz> listByMateria(Materia materia) {
        return quizRepository.findByMateria(materia);
    }

    public List<Quiz> create(Quiz quiz) {
        quizRepository.save(quiz);
        return list();
    }

    public List<Quiz> update(Long id, Quiz quiz) {
        quizRepository.findById(id).ifPresentOrElse((existingQuiz) -> {
            quiz.setId(id);
            quizRepository.save(quiz);
        }, () -> {
            throw new BadRequestException("Quiz referente ao ID não existe!");
        });
        return list();
    }
    public List<Quiz> delete(Long id) {
        quizRepository.findById(id).ifPresentOrElse((existingQuiz) -> quizRepository.delete(existingQuiz), () -> {
            throw new BadRequestException("Quiz referente ao ID existe!");
        });
        return list();
    }

}
