package com.example.demo.projet;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/projets")
@AllArgsConstructor
public class ProjetController {

    private final ProjetService projetService;

    @GetMapping("/all")
    public ResponseEntity<List<Projet>> getAllProjets () {
        List<Projet> projets = projetService.findAllProjets();
        return new ResponseEntity<>(projets, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Projet> getProjetById (@PathVariable("id") Long id) {
        Projet projet = projetService.findProjetById(id);
        return new ResponseEntity<>(projet, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Projet> addProjet(@RequestBody Projet projet) {
        projet.setCreatedAt(LocalDateTime.now());
        Projet newProjet = projetService.addProjet(projet);
        return new ResponseEntity<>(newProjet, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet) {
        projet.setUpdatedAt(LocalDateTime.now());
        Projet updateProjet = projetService.updateProjet(projet);
        return new ResponseEntity<>(updateProjet, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProjet(@PathVariable("id") Long id) {
        projetService.deleteProjet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
