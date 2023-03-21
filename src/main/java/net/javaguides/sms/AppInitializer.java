package net.javaguides.sms;


import net.javaguides.sms.entity.Organization;
import net.javaguides.sms.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class AppInitializer {

    private final OrganizationRepository organizationRepository;


    @Autowired
    AppInitializer(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
            }


    @PostConstruct
    void init() {
        organizationRepository.save(new Organization("Google"));
        organizationRepository.save(new Organization("Amazon"));
        organizationRepository.save(new Organization("Meta"));


    }

}


