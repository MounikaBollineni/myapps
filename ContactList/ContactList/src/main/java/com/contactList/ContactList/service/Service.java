package com.contactList.ContactList.service;

import com.contactList.ContactList.modal.ContactList;
import com.contactList.ContactList.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repository repository;

    public String getValidEmail(String email){
       ContactList contactList= repository.findByEmail(email);
       if(contactList!=null){
           throw new IllegalArgumentException("Email Already Exists");
       }
       return email;
    }
    public ContactList add(ContactList contactList) {
        contactList.setEmail(getValidEmail(contactList.getEmail()));
        return repository.save(contactList);
    }

    public List<ContactList> viewList() {
       return repository.findAll();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
