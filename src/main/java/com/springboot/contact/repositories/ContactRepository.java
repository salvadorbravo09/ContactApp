package com.springboot.contact.repositories;

import com.springboot.contact.entities.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {


}
