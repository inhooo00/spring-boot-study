package com.example.justmakesomething.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_price")
    private Long price;
    @Column(name = "item_count")
    private Long count;

    @OneToMany(mappedBy = "item")
    private List<Order> orders = new ArrayList<>();

    public void update(Item item){
        this.name = item.name;
        this.count = item.count;
    }
}
