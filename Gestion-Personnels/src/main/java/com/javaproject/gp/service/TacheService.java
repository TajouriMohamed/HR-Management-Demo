package com.javaproject.gp.service;

import com.javaproject.gp.entity.Tache;
import com.javaproject.gp.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheService {
    @Autowired
    private TacheRepository tacheRepository;

    public List<Tache> getTache() {
        return tacheRepository.findAll();
    }

    public void saveTache(Tache tache) {
        tacheRepository.save(tache);
    }

}
