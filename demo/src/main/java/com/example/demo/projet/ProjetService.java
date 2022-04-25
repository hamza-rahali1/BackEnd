package com.example.demo.projet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetService {

    private final ProjetRepository projetRepository;

    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    public List<Projet> findAllProjets() {
        return projetRepository.findAll();
    }

    public Projet updateProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    public Projet findProjetById(Long id) {
        return projetRepository.findProjetById(id)
                .orElseThrow(() -> new ProjetNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteProjet(Long id){
        projetRepository.deleteById(id);
    }
}
