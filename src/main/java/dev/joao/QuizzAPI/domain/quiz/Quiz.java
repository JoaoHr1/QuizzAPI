package dev.joao.QuizzAPI.domain.quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "quiz")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quiz {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
 
  @NotBlank
  private String questao;

  @NotBlank
  private String resposta;

  @Enumerated(EnumType.STRING)
  private Materia materia;


  public Quiz(String questao, String resposta, Materia materia) {
  }
}
