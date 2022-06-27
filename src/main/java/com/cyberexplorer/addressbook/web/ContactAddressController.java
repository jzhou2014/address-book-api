package com.cyberexplorer.addressbook.web;

import com.cyberexplorer.addressbook.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContactAddressController {
    private final Logger log = LoggerFactory.getLogger(ContactAddressController.class);
    private ContactAddressRepository contactAddressRepository;

    public ContactAddressController(ContactAddressRepository contactAddressRepository) {
        this.contactAddressRepository = contactAddressRepository;
    }

    @GetMapping("/contacts")
    Collection<ContactAddress> contactaddresses() {
        return contactAddressRepository.findAll();
    }

    @GetMapping("/contact/{id}")
    ResponseEntity<?> getContactAddress(@PathVariable Long id) {
        Optional<ContactAddress> contactAddress = contactAddressRepository.findById(id);
        return contactAddress.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/contact")
    ResponseEntity<Contact> createContact(@Valid @RequestBody ContactAddress contactAddress) throws URISyntaxException {
        log.info("Request to create group: {}", contactAddress);
        ContactAddress result = contactAddressRepository.save(contactAddress);
        return ResponseEntity.created(new URI("/api/contact/" + result.getId()))
                .body(result);
    }

    @PutMapping("/contact/{id}")
    ResponseEntity<Contact> updateGroup(@Valid @RequestBody ContactAddress contactAddress) {
        log.info("Request to update group: {}", contactAddress);
        Contact result =contactAddressRepository.save(contactAddress);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete group: {}", id);
        contactAddressRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
