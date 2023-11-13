package com.example.justmakesomething.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderSaveReqDto {
    private Long price;
    private Long date;
    private Long memberId;
    private Long itemId;

}
