package com.javaproject.gp.controller;

import com.javaproject.gp.entity.Projet;
import com.javaproject.gp.service.ClientService;
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
public class ProjetController {
    @Autowired
    private ProjetService projetService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private PersonnelService personnelService;
    @Autowired
    private TacheService tacheService;

    @GetMapping(path = "/listeProjet")
    public String ListProjet(Model model) {
        model.addAttribute("listeProjets", projetService.getProjet());
        model.addAttribute("listePerso", personnelService.getPerso());
        model.addAttribute("listeTaches", tacheService.getTache());
        return "liste-projet";
    }

    @GetMapping(path = "/addProjet")
    public String addProjet(Model model) {
        model.addAttribute("listeClients", clientService.getClient());
        return "add-projet";
    }

    @PostMapping(path = "/projets/addNew")
    public String addNewAdmin(@ModelAttribute Projet projet) {
        projetService.saveProjet(projet);
        return "redirect:/listeProjet";
    }
}
