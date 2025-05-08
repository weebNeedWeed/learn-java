package com.giaule.rungroop.controllers;

import com.giaule.rungroop.dtos.ClubDto;
import com.giaule.rungroop.models.Club;
import com.giaule.rungroop.services.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {
    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String findClubs(Model model) {
        List<ClubDto> clubs = clubService.getAllClubs();
        model.addAttribute("clubs", clubs);

        return "clubs-list";
    }

    @GetMapping("/clubs/search")
    public String searchClubs(@RequestParam("query") String query, Model model) {
        List<ClubDto> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);

        return "clubs-create";
    }

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") long clubId) {
        clubService.delete(clubId);
        return "redirect:/clubs";
    }

    @PostMapping("/clubs/new")
    public String createClub(@ModelAttribute("club") Club club) {
        clubService.saveClub(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        if(club == null) {
            return "redirect:/clubs";
        }

        model.addAttribute("club", club);

        return "clubs-detail";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        if(club == null) {
            return "redirect:/clubs";
        }

        model.addAttribute("club", club);

        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String editClub(@PathVariable("clubId") long clubId,
                           @Valid @ModelAttribute("club") ClubDto club,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "clubs-edit";
        }

        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }
}
