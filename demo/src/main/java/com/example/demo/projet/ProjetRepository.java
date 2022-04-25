package com.example.demo.projet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ProjetRepository extends JpaRepository<Projet,Long> {

    Optional<Projet> findProjetById(Long id);

}
