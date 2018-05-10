package io.github.jass2125.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.jass2125.domains.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
