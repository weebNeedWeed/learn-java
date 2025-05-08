package com.giaule.rungroop.services;

import com.giaule.rungroop.dtos.EventDto;
import com.giaule.rungroop.models.Event;

public interface EventService {
    void createEvent(long clubId, EventDto eventDto);
}
