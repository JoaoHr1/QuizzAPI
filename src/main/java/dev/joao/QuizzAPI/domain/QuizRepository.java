package dev.joao.QuizzAPI.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Long, Quiz>{
    
}
