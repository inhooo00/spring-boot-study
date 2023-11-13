package com.example.justmakesomething.controller;

import com.example.justmakesomething.domain.Member;
import com.example.justmakesomething.dto.MemberDto;
import com.example.justmakesomething.dto.OrderSaveReqDto;
import com.example.justmakesomething.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("member/save")
    public ResponseEntity<String> memberSave(@RequestBody MemberDto memberDto){
        memberService.memberSave(memberDto);
        return new ResponseEntity<>("성공", HttpStatus.OK);
    }
    @GetMapping("member/{name}")
    public ResponseEntity<Member> findMember(@PathVariable("name") String name ){
        Member memberName = memberService.findOne(name);
        return new ResponseEntity<>(memberName,HttpStatus.OK);
    }
    @GetMapping("member/list")
    public ResponseEntity<List> memberList(){
        List<Member> members= memberService.findMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @PutMapping("member")
    public ResponseEntity<String> updateMember(@RequestBody MemberDto memberDto){
        memberService.updateMember(memberDto);
        return new ResponseEntity<>("업데이트 완료~", HttpStatus.OK);
    }
    @DeleteMapping("member")
    public ResponseEntity<String> deleteMember(@RequestBody MemberDto memberDto){
        memberService.deleteMember(memberDto.getName());
        return new ResponseEntity<>("삭제했슴당~", HttpStatus.OK);
    }

    @PostMapping("member/order")
    public ResponseEntity<String> memberOrder(@RequestBody OrderSaveReqDto orderSaveReqDto){
        memberService.orderSave(orderSaveReqDto);
        return new ResponseEntity<>("주문 완료~",HttpStatus.OK);
    }
}
