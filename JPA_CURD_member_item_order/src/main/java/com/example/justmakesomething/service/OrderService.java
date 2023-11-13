package com.example.justmakesomething.service;

import com.example.justmakesomething.domain.Member;
import com.example.justmakesomething.domain.Order;
import com.example.justmakesomething.dto.OrderResponseDto;
import com.example.justmakesomething.repository.MemberRepository;
import com.example.justmakesomething.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    // 주문 조회
    public List<OrderResponseDto> orderResponseDtoList(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow();
        List<Order> orderList = orderRepository.findByMember(member);

        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        for (Order order : orderList){
            OrderResponseDto orderResponseDto = new OrderResponseDto(
                    order.getMember().getAge(),
                    order.getItem().getName(),
                    order.getItem().getCount(),
                    order.getItem().getPrice());
            orderResponseDtos.add(orderResponseDto);
        }
        return orderResponseDtos;

    }
}
