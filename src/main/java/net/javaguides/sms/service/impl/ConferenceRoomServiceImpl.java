package net.javaguides.sms.service.impl;

import net.javaguides.sms.entity.ConferenceRoom;
import net.javaguides.sms.repository.ConferenceRoomRepository;
import net.javaguides.sms.service.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceRoomServiceImpl implements ConferenceRoomService {
    private ConferenceRoomRepository conferenceRoomRepository;

    @Autowired
    public ConferenceRoomServiceImpl(ConferenceRoomRepository conferenceRoomRepository) {
        this.conferenceRoomRepository = conferenceRoomRepository;
    }

    @Override
    public List<ConferenceRoom> getAllConferenceRooms() {
        return conferenceRoomRepository.findAll();
    }


    @Override
    public ConferenceRoom saveConferenceRoom(ConferenceRoom conferenceRoom) {
        return conferenceRoomRepository.save(conferenceRoom);
    }

    @Override
    public ConferenceRoom getConferenceRoomById(Integer id) {
        return conferenceRoomRepository.findById(id).get();

    }

    @Override
    public ConferenceRoom updateConferenceRoom(ConferenceRoom conferenceRoom) {
        return conferenceRoomRepository.save(conferenceRoom);
    }

    @Override
    public void deleteConferenceRoomById(Integer id) {
        conferenceRoomRepository.deleteById(id);
    }
}

