package com.example.justmakesomething.controller;

import com.example.justmakesomething.dto.OrderResponseDto;
import com.example.justmakesomething.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("order/list")
    public ResponseEntity<List> findOrderList(@RequestParam("memberId") Long memberId){
        List<OrderResponseDto> orderList = orderService.orderResponseDtoList(memberId);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }
}
