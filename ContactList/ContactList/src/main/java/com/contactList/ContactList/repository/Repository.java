package com.contactList.ContactList.repository;

import com.contactList.ContactList.modal.ContactList;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<ContactList,Integer> {
    ContactList findByEmail(String email);
}
