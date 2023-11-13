package com.example.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable @Getter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 생성자
public class Address {
    private String city;
    private String street;
    private String zipcode;
    //setter 부분. 값 타입은 변경 불가능하게 해야 하기 때문. public 보다는 protected가 그나마 안전함.
//    protected Address() {
//    }
//    public Address(String city, String street, String zipcode) {
//        this.city = city;
//        this.street = street;
//        this.zipcode = zipcode;
//    }


}
