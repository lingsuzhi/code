package com.lsz.code.code.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainApi {


    @GetMapping("/")
    public String code(Model model) {
        return "redirect:/fxjk/code.php";
    }
}
