package main.java.com.keyin.golf_club_api.controller;

import main.java.com.keyin.golf_club_api.model.Member;
import main.java.com.keyin.golf_club_api.model.Tournament;
import main.java.com.keyin.golf_club_api.service.TournamentService;
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

    @GetMapping("/{id}/members")
    public List<Member> getMembersInTournament(@PathVariable Long id) {
        return tournamentService.getMembersInTournament(id);
    }
}