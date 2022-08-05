package com.javaproject.gp.controller;

import com.javaproject.gp.service.MessageService;
import com.javaproject.gp.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private PersonnelService personnelService;

    @GetMapping(path = "/listMsg")
    public String listMessages(Model model) {
        model.addAttribute("listeMessages", messageService.getMessage());
        return "email-inbox";
    }

    @GetMapping(path = "/sendMsg")
    public String sendMessage(Model model) {
        model.addAttribute("listePerso", personnelService.getPerso());
        return "email-send";
    }

}
