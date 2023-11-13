package com.example.jpashop.domain;

import com.example.jpashop.domain.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

@Entity @Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)// many에 외래키가 붙는다.
    @JoinColumn(name = "order_id") // 하나의 order가 여러개의 item을 가질 수 있음. 때문에 사용.
    private Order order;

    private int orderprice; // 주문 가격
    private int count; // 주문 수량


    // 생성 메서드 //
    public static OrderItem createOrderItem(Item item, int orderprice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderprice(orderprice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    // 비즈니스 로직 //
    public void cancel() {
        getItem().addStock(count);
    }

    // 조회 로직 //

    /**
     * 주문 상품 전체 가격 조회
     */
    public int getTotalprice() {
        return getOrderprice() * getCount();
    }
}
