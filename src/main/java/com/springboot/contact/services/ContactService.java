package com.springboot.contact.services;

import com.springboot.contact.entities.Contact;
import com.springboot.contact.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Optional<Contact> findById(Integer id) {
        return contactRepository.findById(id);
    }

    public Contact create(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, Contact contact) {
        Contact contactDB = contactRepository.findById(id).orElseThrow();
        contactDB.setName(contact.getName());
        contactDB.setEmail(contact.getEmail());
        return contactRepository.save(contactDB);
    }

    public void delete(Integer id) {
        Contact contactDB = contactRepository.findById(id).orElseThrow();
        contactRepository.delete(contactDB);
    }
}
