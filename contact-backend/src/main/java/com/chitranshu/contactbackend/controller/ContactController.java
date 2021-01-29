package com.chitranshu.contactbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitranshu.contactbackend.exception.ResourceNotFoundException;
import com.chitranshu.contactbackend.model.Contact;
import com.chitranshu.contactbackend.repository.ContactRepository;

@RestController
@RequestMapping("api")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@RequestMapping(value = "/contacts", method = RequestMethod.GET) 
	List<Contact> getAllContacts(){
		return contactRepository.findAll();
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST) 
	public Contact addContact(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id :" + id));
		return ResponseEntity.ok(contact);
	}
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteContact(@PathVariable Long id){
		 Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id :" + id));
		
		contactRepository.delete(contact);
		
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
}
