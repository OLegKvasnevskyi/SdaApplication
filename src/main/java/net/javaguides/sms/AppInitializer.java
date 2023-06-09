package net.javaguides.sms;


import net.javaguides.sms.entity.ConferenceRoom;
import net.javaguides.sms.entity.Organization;
import net.javaguides.sms.repository.ConferenceRoomRepository;
import net.javaguides.sms.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class AppInitializer {

    private final OrganizationRepository organizationRepository;
    private final ConferenceRoomRepository conferenceRoomRepository;


    @Autowired
    AppInitializer(OrganizationRepository organizationRepository, ConferenceRoomRepository conferenceRoomRepository) {
        this.organizationRepository = organizationRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
    }


    @PostConstruct
    void init() {
        organizationRepository.save(new Organization("Google"));
        organizationRepository.save(new Organization("Amazon"));
        organizationRepository.save(new Organization("Meta"));

        conferenceRoomRepository.save(new ConferenceRoom("Google Hall"));
        conferenceRoomRepository.save(new ConferenceRoom("Amazon Hall"));
        conferenceRoomRepository.save(new ConferenceRoom("Meta Hall"));


    }

}


