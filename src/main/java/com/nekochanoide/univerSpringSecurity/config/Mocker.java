package com.nekochanoide.univerSpringSecurity.config;

import com.nekochanoide.univerSpringSecurity.models.Address;
import com.nekochanoide.univerSpringSecurity.models.District;
import com.nekochanoide.univerSpringSecurity.models.EducationalEstablishment;
import com.nekochanoide.univerSpringSecurity.repositories.AddressesRepository;
import com.nekochanoide.univerSpringSecurity.repositories.DistrictsRepository;
import com.nekochanoide.univerSpringSecurity.repositories.EducationalEstablishmentsRepository;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Mocker {
    public Mocker(DistrictsRepository districtsRepository, AddressesRepository addressesRepository, EducationalEstablishmentsRepository educationalEstablishmentsRepository) {
        if (districtsRepository.count() > 0) {
            return;
        }
        ArrayList<District> districts = new ArrayList<>();
        districts.add(new District());
        districts.add(new District());
        districts.add(new District());
        districtsRepository.saveAll(districts);

        int i = 0;
        List<Address> addresses = new ArrayList<>(25);
        for (String addressName : new String[]{
                "76209 Blue Bill Park Center",
                "113 Lakewood Road",
                "164 Bunker Hill Hill",
                "36 Rutledge Circle",
                "15895 Summit Center",
                "414 Warrior Park",
                "155 Bartelt Crossing",
                "04 Sheridan Street",
                "43701 2nd Terrace",
                "3999 Fremont Parkway",
                "59571 Fordem Drive",
                "3576 Spohn Road",
                "16 Lotheville Plaza",
                "2642 Delaware Street",
                "28 Sage Plaza",
                "94 Moulton Parkway",
                "38 Johnson Drive",
                "548 Scott Drive",
                "4829 Bay Center",
                "83 Pepper Wood Junction",
                "8 Anthes Crossing",
                "826 Fairfield Park",
                "44 Dottie Terrace",
                "09502 Oakridge Court",
                "55 Armistice Center",
        }) {
            Address address = new Address(addressName);
            addresses.add(address);
            address.setDistrict(districts.get(i % 3));
            i++;
        }
        addressesRepository.saveAll(addresses);

        List<EducationalEstablishment> educationalEstablishments = new ArrayList<>(25);
        for (i = 0; i < 6; i++) {
            educationalEstablishments.add(new EducationalEstablishment("School #" + i, addresses.get(i)));
        }
        educationalEstablishmentsRepository.saveAll(educationalEstablishments);
    }
}
