package com.example.justmakesomething.controller;

import com.example.justmakesomething.domain.Item;
import com.example.justmakesomething.dto.ItemDto;
import com.example.justmakesomething.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("item/save")
    public ResponseEntity<String> itemSave(@RequestBody ItemDto itemDto){
        itemService.itemSave(itemDto);
        return new ResponseEntity<>("상품 저장 성공!", HttpStatus.OK);
    }

    @GetMapping("item/list")
    public ResponseEntity<List> findAllItems(){
        List<Item> items = itemService.findItems();
        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @PutMapping("item")
    public ResponseEntity<String> updateItem(@RequestBody ItemDto itemDto){
        itemService.updateItem(itemDto);
        return new ResponseEntity<>("상품 개수 업데이트 완료!",HttpStatus.OK);
    }

    @DeleteMapping("item")
    public ResponseEntity<String> deleteItem(@RequestBody ItemDto itemDto){
        itemService.deleteItem(itemDto);
        return new ResponseEntity<>("상품 삭제 완료!",HttpStatus.OK);
    }

}
