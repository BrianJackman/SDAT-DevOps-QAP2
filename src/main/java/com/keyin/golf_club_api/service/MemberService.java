package main.java.com.keyin.golf_club_api.service;

import main.java.com.keyin.golf_club_api.model.Member;
import main.java.com.keyin.golf_club_api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public List<Member> getMembersByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Member> getMembersByPhone(String phone) {
        return memberRepository.findByPhone(phone);
    }

    public List<Member> getMembersByStartDate(LocalDate startDate) {
        return memberRepository.findByStartDate(startDate);
    }

    public List<Member> getMembersByDuration(int duration) {
        return memberRepository.findByDuration(duration);
    }
}