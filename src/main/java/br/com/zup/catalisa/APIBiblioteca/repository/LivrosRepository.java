package br.com.zup.catalisa.APIBiblioteca.repository;


import br.com.zup.catalisa.APIBiblioteca.model.LivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<LivrosModel, Long> {
}
