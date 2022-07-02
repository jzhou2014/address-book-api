package com.cyberexplorer.addressbook.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactAddressRepository  extends JpaRepository<ContactAddress, Integer> {
    ContactAddress findByName(String name);

    List<ContactAddress> findAllByOrderByIdDesc();
}
