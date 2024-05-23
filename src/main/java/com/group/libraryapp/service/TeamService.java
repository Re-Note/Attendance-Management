package com.group.libraryapp.service;

import com.group.libraryapp.domain.Team;
import com.group.libraryapp.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }
}
