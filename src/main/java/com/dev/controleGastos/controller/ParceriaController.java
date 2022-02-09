package com.dev.controleGastos.controller;

import com.dev.controleGastos.model.Parceria;
import com.dev.controleGastos.service.ParceriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parceria")
public class ParceriaController {

    @Autowired
    private ParceriaService service;

    @GetMapping
    public ModelAndView parceria(){
        ModelAndView mv = new ModelAndView("parceria/cadastro");
        mv.addObject("parcerias", service.getParcerias());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Parceria parceria){
        service.salvar(parceria);
        return "redirect:/parceria";
    }
}
