package com.lsz.code.code.api;

import com.lsz.code.code.service.FxjkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/fxjk")
public class FxjkApi {

    @Autowired
    private FxjkService fxjkService;

    @GetMapping("/code.php")
    public String code(Model model) {
        model.addAttribute("code", fxjkService.code());
        return "code/code";
    }

    @GetMapping("/fileDo")
    @ResponseBody
    public Map<String, String> fileDo(@RequestParam String fileName, Boolean killold) {

        Map map = fxjkService.fileDo(fileName, killold);
        return map;
    }

    @PostMapping("/sql2Java")
    @ResponseBody
    public Map<String, String> sql2Java(@RequestBody HashMap<String, Object> param) {
        Map map = fxjkService.sql2Java(param);
        return map;
    }
}
