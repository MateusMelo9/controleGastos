package com.dev.controleGastos.controller;

import com.dev.controleGastos.model.Categoria;
import com.dev.controleGastos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ModelAndView categoria(){
        ModelAndView mv = new ModelAndView("categoria/cadastro");
        mv.addObject("categorias", service.getCategoria());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Categoria categoria){
        service.salvar(categoria);
        return "redirect:/categoria";
    }
}
