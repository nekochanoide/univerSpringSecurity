package com.nekochanoide.univerSpringSecurity.services;

import com.nekochanoide.univerSpringSecurity.models.EducationalEstablishment;
import com.nekochanoide.univerSpringSecurity.repositories.EducationalEstablishmentsRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationalEstablishmentsService {
    private final EducationalEstablishmentsRepository educationalEstablishmentsRepository;

    public EducationalEstablishmentsService(EducationalEstablishmentsRepository educationalEstablishmentsRepository) {
        this.educationalEstablishmentsRepository = educationalEstablishmentsRepository;
    }

    public List<EducationalEstablishment> getAllEducationalEstablishments() {
        return educationalEstablishmentsRepository.findAll();
    }

    public EducationalEstablishment getById(long id) {
        return educationalEstablishmentsRepository.findById(id).orElse(null);
    }
}
