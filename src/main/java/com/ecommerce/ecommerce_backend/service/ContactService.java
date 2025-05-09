package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.dto.ContactRequest;
import com.ecommerce.ecommerce_backend.model.Contact;
import com.ecommerce.ecommerce_backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact createContact(ContactRequest request) {
        Contact contact = new Contact();
        contact.setName(request.getName());
        contact.setEmail(request.getEmail());
        contact.setMessage(request.getMessage());
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }



}