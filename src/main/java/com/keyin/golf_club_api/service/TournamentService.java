package com.keyin.golf_club_api.service;

import com.keyin.golf_club_api.model.Member;
import com.keyin.golf_club_api.model.Tournament;
import com.keyin.golf_club_api.repository.MemberRepository;
import com.keyin.golf_club_api.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public List<Tournament> getTournamentsByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public List<Tournament> getTournamentsByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }

    public List<Member> getMembersInTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElse(null);
        return tournament != null ? List.copyOf(tournament.getMembers()) : List.of();
    }

    public void addMemberToTournament(Long tournamentId, Long memberId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(() -> new RuntimeException("Tournament not found"));
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        tournament.getMembers().add(member);
        tournamentRepository.save(tournament);
    }
}