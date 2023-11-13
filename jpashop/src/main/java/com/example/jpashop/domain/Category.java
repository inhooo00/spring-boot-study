package com.example.jpashop.domain;

import com.example.jpashop.domain.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "categoty_item",
            joinColumns  = @JoinColumn(name = "categoty_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent") // 스스로 맵핑하는 거.
    private List<Category> child = new ArrayList<>();

    //==연관관계 메서드==// 양방향. 부모에도 들어가고 자식에도 들어가야 함.
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
