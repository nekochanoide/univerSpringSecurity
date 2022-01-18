package com.nekochanoide.univerSpringSecurity.services;

import com.nekochanoide.univerSpringSecurity.models.Child;
import com.nekochanoide.univerSpringSecurity.models.EducationalEstablishment;
import com.nekochanoide.univerSpringSecurity.models.ParentsCouple;
import com.nekochanoide.univerSpringSecurity.repositories.ChildrenRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildrenService {
    private final ChildrenRepository childrenRepository;
    private final ParentsCouplesService parentsCouplesService;
    private final EducationalEstablishmentsService educationalEstablishmentsService;

    public ChildrenService(ChildrenRepository childrenRepository, ParentsCouplesService parentsCouplesService, EducationalEstablishmentsService educationalEstablishmentsService) {
        this.childrenRepository = childrenRepository;
        this.parentsCouplesService = parentsCouplesService;
        this.educationalEstablishmentsService = educationalEstablishmentsService;
    }

    public Child addChild(Child child, Long parentsId) {
        ParentsCouple parentsCouple = parentsCouplesService.GetById(parentsId);
        if (parentsCouple == null) {
            return null;
        }
        child.setParentsCouple(parentsCouple);
        childrenRepository.save(child);
        return child;
    }

    public List<Child> getAllChildren() {
        return childrenRepository.findAll();
    }

    public Child getById(long id) {
        return childrenRepository.findById(id).orElse(null);
    }

    public List<EducationalEstablishment> getEducationalEstablishments(Child child) {
        ParentsCouple parentsCouple = child.getParentsCouple();
        if (parentsCouple.getAddress() != null) {
            List<EducationalEstablishment> educationalEstablishments = educationalEstablishmentsService.getAllEducationalEstablishments();
            return educationalEstablishments.stream().filter(x -> parentsCouple.getAddress().getDistrict().getAddresses().stream().anyMatch(y -> y.getId() == x.getAddress().getId())).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public boolean setEducationalEstablishment(long childId, long educationalEstablishmentId) {
        Child child = this.getById(childId);
        if (child == null) {
            return false;
        }
        if (educationalEstablishmentId == -1) {
            child.setEducationalEstablishment(null);
        } else {
            EducationalEstablishment educationalEstablishment = educationalEstablishmentsService.getById(educationalEstablishmentId);
            if (educationalEstablishment == null) {
                return false;
            }
            child.setEducationalEstablishment(educationalEstablishment);
        }
        childrenRepository.save(child);
        return true;
    }
}
