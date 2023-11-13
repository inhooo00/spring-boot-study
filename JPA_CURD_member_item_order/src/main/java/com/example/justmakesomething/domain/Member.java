package com.example.justmakesomething.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "memeber_id")
    private Long id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_age")
    private Long age;

    @Embedded
    private Address address;


    @OneToMany(mappedBy = "member")
    @Column(name = "member_orders")
    private List<Order> orders = new ArrayList<>();

    public void update(Member member){
        this.name = member.name;
        this.address = member.address;
    }

}
