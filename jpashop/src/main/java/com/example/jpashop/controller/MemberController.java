package com.example.jpashop.controller;

import com.example.jpashop.domain.Address;
import com.example.jpashop.domain.Member;
import com.example.jpashop.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(@Valid MemberForm form, BindingResult result){ //굳이 Memberform을 만들어서 받는 이유 = 기존
        //Member 를 이용하면 그 엔티티가 너무 더러워짐.
        if (result.hasErrors()){ // 아무것도 입력하지 않을 시에, 오류 뜨면서 다시 입력하라고 뜸. html 파일에 해당 내용 있음.
            return "members/createMemberForm";
        }
        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("members")
    public String list(Model model){
        List<Member> members = memberService.findMembers(); // 가지고 와서
        model.addAttribute("members",members); // model에 담아서
        return "members/memberList"; // 화면에 넘기는 거
    }

}
