package com.ormoneyomany.bootstrap;

import com.ormoneyomany.entity.Address;
import com.ormoneyomany.entity.Person;
import com.ormoneyomany.repositories.AddressRepository;
import com.ormoneyomany.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {

        Address a1 = new Address("Steet 1", "3423432");
        Address a2 = new Address("Steet 2", "3423432");
        Address a3 = new Address("Steet 3", "3423432");
        Address a4 = new Address("Steet 4", "3423432");
        Address a5 = new Address("Steet 5", "3423432");

        Person p1 = new Person("Vasy", "Vasy");
        Person p2 = new Person("Dima", "Dima");
        Person p3 = new Person("Ivan", "ivan");

//        p1.setAddress(Arrays.asList(a1, a2, a3));
//        p2.setAddress(Arrays.asList(a2, a3, a4, a5));
//        p3.setAddress(Arrays.asList(a2));

        personRepository.save(p1);
//        personRepository.saveAll(new ArrayList<>(Arrays.asList(p1, p2, p3)));


        a1.setPerson(p1);
        a2.setPerson(p1);
        a3.setPerson(p1);

        addressRepository.save(a1);
        addressRepository.save(a2);
        addressRepository.save(a3);
    }
}
