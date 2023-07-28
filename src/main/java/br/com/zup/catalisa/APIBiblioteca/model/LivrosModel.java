package br.com.zup.catalisa.APIBiblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_LIVROS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do Livro", example = "1")
    private Long id;

    @Schema(description = "Nome do Livro", example = "Nome do Livro")
    @Column(length = 50, nullable = false)
    private String nome;

    @Schema(description = "Data de lançamento do livro", example = "YYYY-MM-DD")
    @Column(length = 10, nullable = false)
    private String dataLancamento;

    @Schema(description = "Código do livro", example = "999-99-99999-99-9")
    @Column(length = 17, nullable = false)
    private String codigoLivro;

}
