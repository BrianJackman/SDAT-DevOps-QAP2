package com.keyin.golf_club_api.repository;

import com.keyin.golf_club_api.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
    List<Member> findByPhone(String phone);
    List<Member> findByStartDate(LocalDate startDate);
    List<Member> findByDuration(int duration);
}