package com.example.jpashop.domain.item;

import com.example.jpashop.domain.Category;
import com.example.jpashop.exception.NotEnoughStockExecption;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 전략을 짜야 함. 싱글 테이블 전략.
@DiscriminatorColumn(name = "dtype") // 상속관계 맵핑.
public abstract class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name; //이름

    private int price; // 가격

    private int stockQuantity; // 재고

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비즈니스 로직==//

    /**
     * 수량 증가.
     */
    public void addStock(int quentity){
        this.stockQuantity += quentity;
    }

    /**
     * 수량 감소
     */
    public void removeStock(int quentity){
        int restStock = this.stockQuantity -= quentity;
        if (restStock<0){
            throw new NotEnoughStockExecption("need more stock");
        }
        this.stockQuantity = restStock;
    }

}
