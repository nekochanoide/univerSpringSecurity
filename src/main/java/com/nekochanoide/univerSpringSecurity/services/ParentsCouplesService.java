package com.nekochanoide.univerSpringSecurity.services;

import com.nekochanoide.univerSpringSecurity.models.Address;
import com.nekochanoide.univerSpringSecurity.models.ParentsCouple;
import com.nekochanoide.univerSpringSecurity.repositories.ParentsCouplesRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentsCouplesService {
    private final ParentsCouplesRepository parentsCouplesRepository;
    private final AddressesService addressesService;

    public ParentsCouplesService(ParentsCouplesRepository parentsCouplesRepository, AddressesService addressesService) {
        this.parentsCouplesRepository = parentsCouplesRepository;
        this.addressesService = addressesService;
    }

    public ParentsCouple AddOrUpdateParentsCouple(ParentsCouple parentsCouple) {
        parentsCouplesRepository.save(parentsCouple);
        return parentsCouple;
    }

    public ParentsCouple addOrUpdateParentsCouple(ParentsCouple parentsCouple, long addressId) {
        if (addressId != -1) {
            Address address = addressesService.getById(addressId);
            if (address != null) {
                parentsCouple.setAddress(address);
            }
        }
        parentsCouplesRepository.save(parentsCouple);
        return parentsCouple;
    }

    public List<ParentsCouple> GetAllParents() {
        return parentsCouplesRepository.findAll();
    }

    public ParentsCouple GetById(long id) {
        return parentsCouplesRepository.getById(id);
    }
}
