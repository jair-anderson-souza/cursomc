package io.github.jass2125.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.jass2125.domains.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
