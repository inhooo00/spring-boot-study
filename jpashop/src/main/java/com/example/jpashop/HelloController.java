package com.example.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") //맵핑으로 해당 단어가 뒤에 입력시 templates.html에 연동된 값 보여줌.
    public String Hello(Model model){
        model.addAttribute("data","hello!!!");
        return "hello";
    }
}
