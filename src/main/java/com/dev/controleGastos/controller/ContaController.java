package com.dev.controleGastos.controller;

import com.dev.controleGastos.model.Conta;
import com.dev.controleGastos.service.BancoService;
import com.dev.controleGastos.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService service;

    @Autowired
    private BancoService bancoService;

    @GetMapping
    public ModelAndView categoria(){
        ModelAndView mv = new ModelAndView("conta/cadastro");
        mv.addObject("conta", new Conta());
        mv.addObject("contas", service.getContas());
        mv.addObject("bancos", bancoService.getBancos());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Conta conta){
        service.salvar(conta);
        return "redirect:/conta";
    }
}
