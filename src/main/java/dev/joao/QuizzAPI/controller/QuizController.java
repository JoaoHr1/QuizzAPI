package dev.joao.QuizzAPI.controller;

import dev.joao.QuizzAPI.domain.Materia;
import dev.joao.QuizzAPI.domain.Quiz;
import dev.joao.QuizzAPI.domain.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> list() {
        return quizService.list();
    }

    @GetMapping("/{id}")
    public Optional<Quiz> listById(@PathVariable Long id) {
        return quizService.listById(id);
    }

    @PostMapping
    public ResponseEntity<List<Quiz>> create(@Valid @RequestBody Quiz quiz) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.create(quiz));
    }

    @GetMapping("/materia:{materia}")
    public List<Quiz> listByMateria(@PathVariable Materia materia) {
        return quizService.listByMateria(materia);
    }

    @PutMapping("{id}")
    public List<Quiz> update(@PathVariable Long id, @RequestBody Quiz quiz) {
        return quizService.update(id, quiz);
    }

    @DeleteMapping("{id}")
    public List<Quiz> delete(@PathVariable Long id) {
        return quizService.delete(id);
    }

}
