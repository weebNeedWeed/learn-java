package com.giaule.rungroop.controllers;

import com.giaule.rungroop.dtos.EventDto;
import com.giaule.rungroop.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") long clubId, Model model) {
        EventDto event = new EventDto();

        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);

        return "events-create";
    }

    @PostMapping("/events/{clubId}/new")
    public String createEvent(@PathVariable("clubId") long clubId,
                              @ModelAttribute("event") EventDto event) {
        eventService.createEvent(clubId, event);

        return "redirect:/clubs";
    }
}
