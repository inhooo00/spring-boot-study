package com.example.jpashop.service;

import com.example.jpashop.domain.Member;
import com.example.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // final을 가지고 있는 필드만 가지고 생성자를 만들어 줌 (lombok)
public class MemberService {
    private final MemberRepository memberRepository; // final 추천.

    /**
     * 회원 가입
     */
    @Transactional // 쓰기 용이니 먹여준다.
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 감지.
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){ // 중복 회원 검증
       List<Member> findMembers =  memberRepository.findByName(member.getName());
       if(!findMembers.isEmpty()) {
           throw new IllegalStateException("이미 존재하는 회원입니다.");
       }
    }

    /**
     *  회원 전체 조회
     */
    public List<Member> findMembers(){
        return memberRepository.finAll();
    }

    /**
     * 회원 한 명 조회
     */
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

}
