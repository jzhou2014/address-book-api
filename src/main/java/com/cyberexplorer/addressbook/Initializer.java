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
        List<ContactAddress> contactAddressList = Arrays.asList(new BusinessContactAddress(null, "James Chou", "636-172-7246", "james_chou@abc.com", "BUSINESS", true, "www.Sharkbeyond.com"), new PersonalContactAddress(null, "Sandy Davis", "314-123-4567", "SandyDavis@hotmail.com", "PERSONAL", true, "@SandyDavis"));
        contactAddressList.forEach(contactAddress -> contactAddressRepository.save(contactAddress));
        contactAddressRepository.findAllByOrderByIdDesc().forEach(System.out::println);
    }
}
