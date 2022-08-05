package com.javaproject.gp.controller;

import com.javaproject.gp.entity.Tache;
import com.javaproject.gp.service.PersonnelService;
import com.javaproject.gp.service.ProjetService;
import com.javaproject.gp.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TacheController {
    @Autowired
    private ProjetService projetService;
    @Autowired
    private TacheService tacheService;
    @Autowired
    private PersonnelService personnelService;


    @GetMapping(path = "/addTache")
    public String addTache(Model model) {
        model.addAttribute("listeProjets", projetService.getProjet());
        model.addAttribute("listePerso", personnelService.getPerso());
        model.addAttribute("listeTaches", tacheService.getTache());
        return "add-tache";
    }

    @PostMapping(path = "/taches/addNew")
    public String addNewTache(@ModelAttribute Tache tache) {
        tacheService.saveTache(tache);
        return "redirect:/listeProjet";
    }

}
