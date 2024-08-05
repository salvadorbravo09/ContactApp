package com.springboot.contact;

import com.springboot.contact.entities.Contact;
import com.springboot.contact.repositories.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootContactApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootContactApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ContactRepository contactRepository) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                List<Contact> contacts = Arrays.asList(
                        new Contact("Carlos", "carlos@gmail.com", LocalDateTime.now()),
                        new Contact("Juan", "juan@gmail.com", LocalDateTime.now()),
                        new Contact("Marcelo", "marcelo@gmail.com", LocalDateTime.now()),
                        new Contact("Luis", "luis@gmail.com", LocalDateTime.now()),
                        new Contact("Erich", "erich@gmail.com", LocalDateTime.now())
                );
                contactRepository.saveAll(contacts);
            }
        };
    }

}
