package br.com.zup.catalisa.APIBiblioteca.service;

import br.com.zup.catalisa.APIBiblioteca.model.LivrosModel;
import br.com.zup.catalisa.APIBiblioteca.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
    LivrosRepository livrosRepository;

    //método que busca todos os contatos no banco
    public List<LivrosModel> findAll(){
        return livrosRepository.findAll();
    }

    //método que busca um contato no banco pelo id
    public Optional<LivrosModel> findById(Long id){
        return livrosRepository.findById(id);
    }

    //método que cadastra um novo contato dentro do banco
    public LivrosModel register(LivrosModel livrosModel){
        return livrosRepository.save(livrosModel);
    }

    //método que altera um contato já existente no banco
    public LivrosModel change(Long id, LivrosModel livrosModel) {
        LivrosModel livro = findById(id).get();

        if(livrosModel.getNome() != null) {
            livro.setNome(livrosModel.getNome());
        }
        if(livrosModel.getDataLancamento() != null) {
            livro.setDataLancamento(livrosModel.getDataLancamento());
        }
        if (livrosModel.getCodigoLivro() != null){
            livro.setCodigoLivro(livrosModel.getCodigoLivro());
        }
        return livrosRepository.save(livro);
    }

    //método que deleta um contato já existente no banco
    public void delete(Long id){
        livrosRepository.deleteById(id);
    }

}
