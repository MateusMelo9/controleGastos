package com.dev.controleGastos.controller;

import com.dev.controleGastos.model.Casa;
import com.dev.controleGastos.model.Conta;
import com.dev.controleGastos.service.BancoService;
import com.dev.controleGastos.service.CasaService;
import com.dev.controleGastos.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/casa")
public class CasaController {

    @Autowired
    private CasaService service;

    @Autowired
    private BancoService bancoService;

    @GetMapping
    public ModelAndView casa(){
        ModelAndView mv = new ModelAndView("casa/cadastro");
        mv.addObject("casa", new Casa());
        mv.addObject("casas", service.getCasas());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Casa casa){
        service.salvarCasa(casa);
        return "redirect:/casa";
    }
}
