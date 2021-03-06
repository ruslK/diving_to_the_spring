package com.restproject.controller;

import com.restproject.entity.Address;
import com.restproject.repository.AddressRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddresses() {
        HttpHeaders header = new HttpHeaders();
        header.set("Version", "1");
        header.set("Method", "Get All Addresses");
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(header)
                .body(addressRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id) {
        HttpHeaders header = new HttpHeaders();
        header.set("Version", "1");
        header.set("Method", "Get Addresses for " + id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(header)
                .body(addressRepository.findById(id).get());

    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable("id") Long id, @RequestBody Address address) throws Exception {
        Optional<Address> foundAddress = addressRepository.findById(id);
        if(!foundAddress.isPresent()) {
            throw new Exception("Address does not exists");
        }
        address.setCurrentTemperature(address.consumeTemp(address.getCity()));
        address.setId(foundAddress.get().getId());
        return addressRepository.save(address);
    }
}
