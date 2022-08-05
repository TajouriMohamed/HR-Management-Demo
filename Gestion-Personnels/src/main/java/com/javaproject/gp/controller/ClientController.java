package com.javaproject.gp.controller;

import com.javaproject.gp.entity.Client;
import com.javaproject.gp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(path = "/listeClients")
    public String ListClients(Model model) {
        model.addAttribute("listeClients", clientService.getClient());
        return "liste-client";
    }

    @RequestMapping("/addClient")
    public String createClient(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "add-client";
    }

    @RequestMapping(value = "/saveClient", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") Client client) {
        clientService.create(client);
        return "redirect:/listeClients";
    }

    @RequestMapping("clients/edit/{id}")
    public ModelAndView editClient(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit-client");
        Client client = clientService.updateId(id);
        mav.addObject("client", client);

        return mav;
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.POST, RequestMethod.GET})
    public String updateClient(Client client) {
        clientService.create(client);
        return "redirect:/listeClients";
    }


    @RequestMapping("/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") int id) {
        clientService.delete(id);
        return "redirect:/listeClients";
    }

}
