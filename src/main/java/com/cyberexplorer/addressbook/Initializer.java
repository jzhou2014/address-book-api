package com.cyberexplorer.addressbook;

import com.cyberexplorer.addressbook.model.BusinessContactAddress;
import com.cyberexplorer.addressbook.model.ContactAddress;
import com.cyberexplorer.addressbook.model.ContactAddressRepository;
import com.cyberexplorer.addressbook.model.PersonalContactAddress;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
class Initializer implements CommandLineRunner {
    private final ContactAddressRepository contactAddressRepository;

    public Initializer(ContactAddressRepository contactAddressRepository) {
        this.contactAddressRepository = contactAddressRepository;
    }

    @Override
    public void run(String... strings) {
        List<ContactAddress> contactAddressList = Arrays.asList(new BusinessContactAddress("Jin Zhou", "636-349-7246", "jin_zhou@unigroup.com", "BUSINESS", true, "www.unigroup.com"), new PersonalContactAddress("Xinyi Zhou", "314-123-4567", "xinyizhou@hotmail.com", "PERSONAL", true, "@CindyZhou"));
        contactAddressList.forEach(contactAddress -> contactAddressRepository.save(contactAddress));
        contactAddressRepository.findAll().forEach(System.out::println);
    }
}
