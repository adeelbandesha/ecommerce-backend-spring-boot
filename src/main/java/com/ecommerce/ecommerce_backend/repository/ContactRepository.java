package com.ecommerce.ecommerce_backend.repository;

import com.ecommerce.ecommerce_backend.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
