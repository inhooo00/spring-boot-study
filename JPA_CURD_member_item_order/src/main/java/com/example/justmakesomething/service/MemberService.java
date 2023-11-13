package com.example.justmakesomething.service;

import com.example.justmakesomething.domain.Address;
import com.example.justmakesomething.domain.Item;
import com.example.justmakesomething.domain.Member;
import com.example.justmakesomething.domain.Order;
import com.example.justmakesomething.dto.MemberDto;
import com.example.justmakesomething.dto.OrderSaveReqDto;
import com.example.justmakesomething.repository.ItemRepository;
import com.example.justmakesomething.repository.MemberRepository;
import com.example.justmakesomething.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    @Transactional //회원 저장
    public void memberSave(MemberDto memberDto) {
        validateDuplicateMember(memberDto);
        Address address = new Address(memberDto.getCity(), memberDto.getStreet(), memberDto.getZipcode());
        Member member = Member.builder()
                .name(memberDto.getName())
                .age(memberDto.getAge())
                .address(address)
                .build();
        memberRepository.save(member);
    }

    private void validateDuplicateMember(MemberDto memberDto) {
        List<Member> findMembers = memberRepository.findMembersByName(memberDto.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다,");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(String memberName) {
        return memberRepository.findMemberByName(memberName);
    }


    public void deleteMember(String name) {
        Member member = memberRepository.findMemberByName(name);
        memberRepository.delete(member);
    }


    public void updateMember(MemberDto memberDto) {
        Member member = findOne(memberDto.getName());
        Address address = new Address(memberDto.getCity(), memberDto.getStreet(), memberDto.getZipcode());
        if (member != null) {
            member.update(Member.builder()
                    .name(memberDto.getName())
                    .age(memberDto.getAge())
                    .address(address)
                    .build());
            memberRepository.save(member);

        }
    }


    public void orderSave(OrderSaveReqDto orderSaveReqDto) {
        Member member = memberRepository.findById(orderSaveReqDto.getMemberId()).orElseThrow();
        Item item = itemRepository.findById(orderSaveReqDto.getItemId()).orElseThrow();

        Order order = Order.builder()
                .date(orderSaveReqDto.getDate())
                .member(member)
                .item(item)
                .build();
        orderRepository.save(order);
    }
}
