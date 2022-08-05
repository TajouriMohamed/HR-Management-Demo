package com.javaproject.gp.service;

import com.javaproject.gp.entity.Projet;
import com.javaproject.gp.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    public List<Projet> getProjet() {
        return projetRepository.findAll();
    }

    public void saveProjet(Projet projet) {
        projetRepository.save(projet);
    }

}
