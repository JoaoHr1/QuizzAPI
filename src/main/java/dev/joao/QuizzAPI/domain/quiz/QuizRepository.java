package dev.joao.QuizzAPI.domain.quiz;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

    List<Quiz> findByMateria(Materia materia);


}
