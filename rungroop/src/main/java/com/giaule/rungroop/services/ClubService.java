package com.giaule.rungroop.services;

import com.giaule.rungroop.dtos.ClubDto;
import com.giaule.rungroop.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> getAllClubs();

    void saveClub(Club club);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);

    void delete(long clubId);

    List<ClubDto> searchClubs(String query);
}

