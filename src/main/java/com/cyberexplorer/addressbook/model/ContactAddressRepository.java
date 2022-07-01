package com.cyberexplorer.addressbook.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactAddressRepository  extends JpaRepository<ContactAddress, Integer> {
    ContactAddress findByName(String name);
}
