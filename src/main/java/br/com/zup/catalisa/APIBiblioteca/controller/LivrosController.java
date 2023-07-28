package br.com.zup.catalisa.APIBiblioteca.controller;

import br.com.zup.catalisa.APIBiblioteca.model.LivrosModel;
import br.com.zup.catalisa.APIBiblioteca.service.LivrosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/biblioteca", produces = {"application/json"})
@Tag(name = "API Biblioteca")
public class LivrosController {

    @Autowired
    LivrosService livrosService;

    //busca todos os livros
    @GetMapping(path = "/livros")
    @Operation(summary = " : Pega todos os livros do banco", method = "GET")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    public List<LivrosModel> fetchAllBooks(){
        return livrosService.findAll();
    }

    //busca livro pelo ID
    @GetMapping(path = "/livros/{id}")
    @Operation(summary = " : Busca um ID especifico dentro do banco de dados", method = "GET")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    public Optional<LivrosModel> searchForABookById(@PathVariable Long id){
        return livrosService.findById(id);
    }

    @PostMapping(path = "/livros")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = " : Cria um novo livro", method = "POST")
    @ApiResponse(responseCode = "201", description = "Livro criado com sucesso")
    public LivrosModel registerNewBook(@RequestBody LivrosModel livrosModel){
        return livrosService.register(livrosModel);
    }

    @PutMapping(path = "/livros/{id}")
    @Operation(summary = " : Altera um livro pelo ID", method = "PUT")
    @ApiResponse(responseCode = "200", description = "Livro alterado com sucesso")
    public LivrosModel changeBook(@PathVariable Long id, @RequestBody LivrosModel livrosModel) {
        return livrosService.change(id, livrosModel);
    }

    @DeleteMapping(path = "/livros/{id}")
    @Operation(summary = " : Deleta um livro pelo ID", method = "PUT")
    @ApiResponse(responseCode = "200", description = "Livro deletado com sucesso")
    public void deleteBook(@PathVariable Long id){
    }


}
