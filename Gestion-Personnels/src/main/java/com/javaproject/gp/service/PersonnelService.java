package com.javaproject.gp.service;

import com.javaproject.gp.entity.Personnel;
import com.javaproject.gp.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelService {

    @Autowired
    private PersonnelRepository personnelRepository;

    public List<Personnel> getPerso() {
        return personnelRepository.findAll();
    }

    public void savePerso(Personnel personnel) {
        personnelRepository.save(personnel);
    }

    public Optional<Personnel> findById(int id) {
        return personnelRepository.findById(id);
    }

    public void delete(Integer id) {
        personnelRepository.deleteById(id);
    }


}
