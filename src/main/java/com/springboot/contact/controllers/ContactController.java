package com.springboot.contact.controllers;

import com.springboot.contact.entities.Contact;
import com.springboot.contact.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return (List<Contact>) contactService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Contact> getContactById(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Integer id, @RequestBody Contact contact) {
        return contactService.update(id, contact);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Integer id) {
        contactService.delete(id);
    }
}
