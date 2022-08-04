package com.example.restapi;

import com.example.restapi.data.ContactRepository;
import com.example.restapi.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactRest {
    @Autowired
    private ContactRepository repository;

    @GetMapping
    public List<Contact> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody Contact contact){
        repository.save(contact);
    }

    @PutMapping
    public void update(@RequestBody Contact contact){
        if (contact.getId() > 0)
            repository.save(contact);
    }

    @DeleteMapping
    public void delete(@RequestBody Contact contact){
        repository.delete(contact);
    }
}
