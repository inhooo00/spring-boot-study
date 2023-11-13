package com.example.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class Delivery { // 배달
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded // 내장 타입이기 때문에 사용.
    private Address address;

    @Enumerated(EnumType.STRING) // 새는 방벙을 기존 1,2,3 이 아닌 이름으로.
    private DeliveryStatus status; // 배송 상태. REDAY, CAMP
}
