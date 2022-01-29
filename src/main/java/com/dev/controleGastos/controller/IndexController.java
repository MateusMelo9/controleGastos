package com.dev.controleGastos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping
    public String blank(){
        return "/inicio";
    }

    @GetMapping("/padrao")
    public String profile(){
        return "/layout/layout-padrao";
    }
}
