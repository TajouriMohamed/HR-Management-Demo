package com.javaproject.gp.controller;

import com.javaproject.gp.entity.Admin;
import com.javaproject.gp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/listeAdmins")
    public String ListAdmins(Model model) {
        model.addAttribute("listeAdmins", adminService.getAdmins());
        return "liste-admin";
    }

    @GetMapping(path = "/addAdmin")
    public String addAdmin() {
        return "add-admin";
    }

    @PostMapping(path = "/admins/addNew")
    public String addNewAdmin(Admin admin) {
        adminService.saveAdmin(admin);
        return "redirect:/listeAdmins";
    }

    @RequestMapping(path = "/admins/findById")
    @ResponseBody
    public Optional<Admin> findAdminById(int id) {
        return adminService.findById(id);
    }

    @RequestMapping(value = "/admins/update", method = {RequestMethod.POST, RequestMethod.GET})
    public String updateAdmin(Admin admin) {
        adminService.saveAdmin(admin);
        return "redirect:/listeAdmins";
    }

    @RequestMapping(value = "/admins/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteAdmin(Integer id) {
        adminService.delete(id);
        return "redirect:/listeAdmins";
    }

}
