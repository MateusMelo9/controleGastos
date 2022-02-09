package com.dev.controleGastos.controller;

import com.dev.controleGastos.model.Fornecedor;
import com.dev.controleGastos.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ModelAndView fornecedor(){
        ModelAndView mv = new ModelAndView("fornecedor/cadastro");
        mv.addObject("fornecedor", new Fornecedor());
        mv.addObject("fornecedores",service.getForncedores());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Fornecedor fornecedor){
        service.salvarForncedor(fornecedor);
        return "redirect:/fornecedor";
    }
}
