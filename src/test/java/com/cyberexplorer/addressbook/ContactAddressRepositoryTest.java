package com.cyberexplorer.addressbook;

import com.cyberexplorer.addressbook.model.BusinessContactAddress;
import com.cyberexplorer.addressbook.model.ContactAddress;
import com.cyberexplorer.addressbook.model.ContactAddressRepository;
import com.cyberexplorer.addressbook.model.PersonalContactAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest(properties = "spring.profiles.active:test")
public class ContactAddressRepositoryTest {

    @Autowired
    private ContactAddressRepository contactAddressRepository;

    @Test
    public void testFindByName() {
        contactAddressRepository.save(new BusinessContactAddress(null, "James Chou", "636-172-7246", "james_chou@abc.com", "BUSINESS", true, "www.Sharkbeyond.com"));
        ContactAddress contactAddress = contactAddressRepository.findByName("James Chou");
        assertEquals("James Chou", contactAddress.getName());
    }
    @Test
    public void testFindAllByOrderByIdDesc(){
        List<ContactAddress> contactAddressList = Arrays.asList(new BusinessContactAddress(null, "James Chou", "636-172-7246", "james_chou@abc.com", "BUSINESS", true, "www.Sharkbeyond.com"), new PersonalContactAddress(null, "Sandy Davis", "314-123-4567", "SandyDavis@hotmail.com", "PERSONAL", true, "@SandyDavis"));
        ContactAddress[] contactAddressArray = contactAddressList.toArray(new ContactAddress[0]);
        contactAddressList.forEach(contactAddress -> contactAddressRepository.save(contactAddress));
        List<ContactAddress> actualContactAddressList = contactAddressRepository.findAllByOrderByIdDesc();
        ContactAddress[] actualContactAddressesArray = actualContactAddressList.toArray(new ContactAddress[0]);
        List<ContactAddress> expectedContactAddressList = Arrays.asList(new BusinessContactAddress(1, "James Chou", "636-172-7246", "james_chou@abc.com", "BUSINESS", true, "www.Sharkbeyond.com"), new PersonalContactAddress(2, "Sandy Davis", "314-123-4567", "SandyDavis@hotmail.com", "PERSONAL", true, "@SandyDavis"));
        expectedContactAddressList.sort(Comparator.comparing(ContactAddress::getId).reversed());
        ContactAddress[] expectedContactAddressArray = expectedContactAddressList.toArray(new ContactAddress[0]);
        assertArrayEquals(expectedContactAddressArray, actualContactAddressesArray);
    }
}

