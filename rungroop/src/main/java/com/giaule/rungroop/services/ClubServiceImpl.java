package com.giaule.rungroop.services;

import com.giaule.rungroop.dtos.ClubDto;
import com.giaule.rungroop.models.Club;
import com.giaule.rungroop.models.UserEntity;
import com.giaule.rungroop.repositories.ClubRepository;
import com.giaule.rungroop.repositories.UserRepository;
import com.giaule.rungroop.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService{
    private final ClubRepository clubRepository;
    private final UserRepository userRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository) {
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ClubDto> getAllClubs() {
        return clubRepository.findAll().stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    @Override
    public void saveClub(Club club) {
        String username = SecurityUtils.getSessionUser();
        UserEntity user = userRepository.findByUsername(username).get();
        club.setCreatedBy(user);
        clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).orElse(null);
        if(club == null) {
            return null;
        }

        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto dto) {
        Club club = mapToClub(dto);
        clubRepository.save(club);
    }

    @Override
    public void delete(long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        return clubRepository.searchClubs(query).stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto(Club club) {
        ClubDto dto = new ClubDto();
        dto.setId(club.getId());
        dto.setContent(club.getContent());
        dto.setTitle(club.getTitle());
        dto.setCreatedOn(club.getCreatedOn());
        dto.setUpdatedOn(club.getUpdatedOn());
        dto.setPhotoUrl(club.getPhotoUrl());
        return dto;
    }

    private Club mapToClub(ClubDto dto) {
        Club club = new Club();
        club.setId(dto.getId());
        club.setContent(dto.getContent());
        club.setTitle(dto.getTitle());
        club.setCreatedOn(dto.getCreatedOn());
        club.setUpdatedOn(dto.getUpdatedOn());
        club.setPhotoUrl(dto.getPhotoUrl());
        return club;
    }
}
