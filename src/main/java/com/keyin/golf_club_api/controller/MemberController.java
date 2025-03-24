package main.java.com.keyin.golf_club_api.controller;

import main.java.com.keyin.golf_club_api.model.Member;
import main.java.com.keyin.golf_club_api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/search")
    public List<Member> searchMembers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) Integer duration) {
        if (name != null) {
            return memberService.getMembersByName(name);
        } else if (phone != null) {
            return memberService.getMembersByPhone(phone);
        } else if (startDate != null) {
            return memberService.getMembersByStartDate(startDate);
        } else if (duration != null) {
            return memberService.getMembersByDuration(duration);
        } else {
            return memberService.getAllMembers();
        }
    }
}