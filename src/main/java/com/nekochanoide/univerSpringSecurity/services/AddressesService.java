package com.nekochanoide.univerSpringSecurity.services;

import com.nekochanoide.univerSpringSecurity.models.Address;
import com.nekochanoide.univerSpringSecurity.repositories.AddressesRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressesService {
    private final AddressesRepository addressesRepository;

    public AddressesService(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    public List<Address> getAllAddresses() {
        return addressesRepository.findAll();
    }

    public Address getById(long id) {
        return addressesRepository.findById(id).orElse(null);
    }
}
