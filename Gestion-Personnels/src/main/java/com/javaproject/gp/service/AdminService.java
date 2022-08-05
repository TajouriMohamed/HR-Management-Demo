package com.javaproject.gp.service;

import com.javaproject.gp.entity.Admin;
import com.javaproject.gp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    //Return List of Admins from DataBase
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    //Ajouter un administrateur
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    //Get AdminById
    public Optional<Admin> findById(int id) {
        return adminRepository.findById(id);
    }

    //delete admin by id
    public void delete(Integer id) {
        adminRepository.deleteById(id);
    }

}
