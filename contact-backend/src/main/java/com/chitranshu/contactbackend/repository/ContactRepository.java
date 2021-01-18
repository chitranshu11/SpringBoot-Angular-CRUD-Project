package com.chitranshu.contactbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chitranshu.contactbackend.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

}
