package com.example.justmakesomething.repository;

import com.example.justmakesomething.domain.Member;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findMembersByName(String name);

    Member findMemberByName(String name);

}
