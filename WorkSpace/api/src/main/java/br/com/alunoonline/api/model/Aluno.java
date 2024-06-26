package br.com.alunoonline.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // se torna tabela no bd
public class Aluno implements Serializable {
// serializable salva o estado do objeto e permite transmitir e compartilhar na rede
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
// indica a estratégia de geração de valores
//a estratégia GenerationType.IDENTITY indica que o bd gera os valores das chaves primárias
    private Long id;
    private String name;
    private String email;
}