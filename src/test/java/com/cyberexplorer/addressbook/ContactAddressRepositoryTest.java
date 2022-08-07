package com.cyberexplorer.addressbook;

import com.cyberexplorer.addressbook.model.BusinessContactAddress;
import com.cyberexplorer.addressbook.model.ContactAddress;
import com.cyberexplorer.addressbook.model.ContactAddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest(properties = "spring.profiles.active:test")
public class ContactAddressRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ContactAddressRepository contactAddressRepository;

    @Test
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public void testFindByName() {
        entityManager.persist(new BusinessContactAddress("James Chou", "636-172-7246", "james_chou@abc.com", "BUSINESS", true, "www.Sharkbeyond.com"));
        ContactAddress contactAddress = contactAddressRepository.findByName("James Chou");
        assertEquals("James Chou", contactAddress.getName());
    }
}

