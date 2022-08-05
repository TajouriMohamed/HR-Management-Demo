package com.javaproject.gp.service;

import com.javaproject.gp.entity.Message;
import com.javaproject.gp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessage() {
        return messageRepository.findAll();
    }

    public void create(Message message) {
        messageRepository.save(message);
    }

}
