package com.example.jpashop.repository;

import com.example.jpashop.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.List;

@Repository
@RequiredArgsConstructor // final을 가지고 있는 필드만 가지고 생성자를 만들어 줌 (lombok)
public class MemberRepository {
    private final EntityManager em; // spring entitymanager를 만들어서 주입해줌.


    public void save(Member member){ // jpa가 member를 저장하는 로직.
        em.persist(member);
    }

    public Member findOne(Long id){ // member를 조회하는 매서드
        return em.find(Member.class, id);
    }

    public List<Member> finAll(){ // list로 찾아내는 매서드
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }

    public List<Member> findByName(String name){ // 개인을 이름으로 찾아내는 매서드. sql 문법과 비슷.
        return em.createQuery("select m from Member m where m.name = : name", Member.class)
                .setParameter("name",name)
                .getResultList();
    }
}
