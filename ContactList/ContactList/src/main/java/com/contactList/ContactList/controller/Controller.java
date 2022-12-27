package com.contactList.ContactList.controller;

import com.contactList.ContactList.modal.ContactList;
import com.contactList.ContactList.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contactList")
@CrossOrigin
@Validated
public class Controller {

    @Autowired
    Service service;

    @PostMapping("/addContact")
    public ResponseEntity<ContactList> addContact(@Valid  @RequestBody ContactList contactList){

       return new ResponseEntity<>(service.add(contactList), HttpStatus.CREATED);
    }

    @GetMapping("/viewContacts")
    public List<ContactList> viewContacts(){
        return service.viewList();
    }

    @DeleteMapping("/removeContact/{id}")
    public void deleteContact(@PathVariable int id){
        service.delete(id);
    }
}
