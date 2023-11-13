package com.example.justmakesomething.service;

import com.example.justmakesomething.domain.Item;
import com.example.justmakesomething.dto.ItemDto;
import com.example.justmakesomething.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    // 상품 등록
    public void itemSave(ItemDto itemDto) {
        Item item = Item.builder()
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .count(itemDto.getCount())
                .build();
        itemRepository.save(item);
    }

    //단일 상품 조회

    public Item finditem(ItemDto itemDto) {
        return itemRepository.findItemByName(itemDto.getName());
    }

    //전체 상품 조회
    public List<Item> findItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    //상품 개수 변경
    public void updateItem(ItemDto itemDto) {
        Item item = finditem(itemDto);
        item.update(Item.builder()
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .count(itemDto.getCount()).build());
        itemRepository.save(item);
    }

    public void deleteItem(ItemDto itemDto) {
        Item item = itemRepository.findItemByName(itemDto.getName());
        itemRepository.delete(item);
    }
}
