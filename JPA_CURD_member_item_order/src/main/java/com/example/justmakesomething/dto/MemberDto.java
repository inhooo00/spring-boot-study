package com.example.justmakesomething.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto extends AddressDto{

    private String name;

    private Long age;

}
