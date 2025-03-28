package com.keyin.golf_club_api.controller;

import com.keyin.golf_club_api.model.Member;
import com.keyin.golf_club_api.model.Tournament;
import com.keyin.golf_club_api.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @PostMapping("/{tournamentId}/members")
    public void addMemberToTournament(@PathVariable Long tournamentId, @RequestBody Long memberId) {
        tournamentService.addMemberToTournament(tournamentId, memberId);
    }

    @GetMapping("/search")
    public List<Tournament> searchTournaments(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) String location) {
        if (startDate != null) {
            return tournamentService.getTournamentsByStartDate(startDate);
        } else if (location != null) {
            return tournamentService.getTournamentsByLocation(location);
        } else {
            return tournamentService.getAllTournaments();
        }
    }

    @GetMapping("/{tournamentId}/members")
    public List<Member> getMembersInTournament(@PathVariable Long tournamentId) {
        return tournamentService.getMembersInTournament(tournamentId);
    }
}