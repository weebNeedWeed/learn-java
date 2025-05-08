package com.giaule.rungroop.services;

import com.giaule.rungroop.dtos.EventDto;
import com.giaule.rungroop.models.Club;
import com.giaule.rungroop.models.Event;
import com.giaule.rungroop.repositories.ClubRepository;
import com.giaule.rungroop.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private final ClubRepository clubRepository;
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(ClubRepository clubRepository, EventRepository eventRepository) {
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void createEvent(long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).orElse(null);
        if(club == null) {
            return;
        }

        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    private Event mapToEvent(EventDto eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setType(eventDto.getType());
        event.setEndTime(eventDto.getEndTime());
        event.setPhotoUrl(eventDto.getPhotoUrl());
        event.setStartTime(eventDto.getStartTime());
        return event;
    }
}
