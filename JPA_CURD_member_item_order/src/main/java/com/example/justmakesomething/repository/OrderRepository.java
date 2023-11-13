package com.example.justmakesomething.repository;

import com.example.justmakesomething.domain.Member;
import com.example.justmakesomething.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByMember(Member member);
}
