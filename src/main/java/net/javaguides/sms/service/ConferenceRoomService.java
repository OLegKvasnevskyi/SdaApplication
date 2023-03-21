package net.javaguides.sms.service;

import net.javaguides.sms.entity.ConferenceRoom;

import java.util.List;

public interface ConferenceRoomService {

    List<ConferenceRoom> getAllConferenceRooms();

    ConferenceRoom saveConferenceRoom(ConferenceRoom conferenceRoom);

    ConferenceRoom getConferenceRoomById(Integer id);

    ConferenceRoom updateConferenceRoom(ConferenceRoom conferenceRoom);

    void deleteConferenceRoomById(Integer id);
}
