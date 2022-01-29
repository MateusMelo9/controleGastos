package com.dev.controleGastos.controller;

import com.dev.controleGastos.model.Lancamento;
import com.dev.controleGastos.model.TipoLancamento;
import com.dev.controleGastos.service.CategoriaService;
import com.dev.controleGastos.service.ContaService;
import com.dev.controleGastos.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService service;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ModelAndView categoria(){
        ModelAndView mv = new ModelAndView("lancamento/cadastro");
        mv.addObject("lancamento", new Lancamento());
        mv.addObject("lancamentos", service.getLancamentos());
        mv.addObject("tipos", TipoLancamento.values());
        mv.addObject("categorias", categoriaService.getCategoria());
        mv.addObject("contas", contaService.getContas());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Lancamento lancamento){
        service.salvar(lancamento);
        return "redirect:/lancamento";
    }
}
