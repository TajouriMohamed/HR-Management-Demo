package com.javaproject.gp.controller;

import com.javaproject.gp.entity.Personnel;
import com.javaproject.gp.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PersonnelController {
    @Autowired
    private PersonnelService personnelService;

    @GetMapping(path = "/listePerso")
    public String ListPerso(Model model) {
        model.addAttribute("listePersonnels", personnelService.getPerso());
        return "liste-perso";
    }

    @GetMapping(path = "/addPerso")
    public String addPerso() {
        return "add-perso";
    }

    @PostMapping(path = "/perso/addNew")
    public String addNewPerso(Personnel personnel) {
        personnelService.savePerso(personnel);
        return "redirect:/listePerso";
    }

    @RequestMapping(path = "/perso/findById")
    @ResponseBody
    public Optional<Personnel> findAdminById(int id) {
        return personnelService.findById(id);
    }

    @RequestMapping(value = "/perso/update", method = {RequestMethod.POST, RequestMethod.GET})
    public String updatePerso(Personnel personnel) {
        personnelService.savePerso(personnel);
        return "redirect:/listePerso";
    }

    @RequestMapping(value = "/perso/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deletePerso(Integer id) {
        personnelService.delete(id);
        return "redirect:/listePerso";
    }
}
