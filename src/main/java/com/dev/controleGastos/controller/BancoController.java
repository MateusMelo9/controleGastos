package com.dev.controleGastos.controller;

import com.dev.controleGastos.model.Banco;
import com.dev.controleGastos.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/banco")
public class BancoController {

    @Autowired
    private BancoService service;

    @GetMapping
    public ModelAndView banco(){
        ModelAndView mv = new ModelAndView("banco/cadastro");
        mv.addObject("bancos", service.getBancos());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Banco banco){
        service.salvar(banco);
        return "redirect:/banco";
    }
}
