package com.dev.controleGastos.controller;

import com.dev.controleGastos.model.CategoriaLancamento;
import com.dev.controleGastos.model.TipoCategoria;
import com.dev.controleGastos.service.CategoriaLancamentoService;
import com.dev.controleGastos.service.FornecedorService;
import com.dev.controleGastos.service.TipoCategoriaService;
import com.dev.controleGastos.service.exception.CategoriaJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private TipoCategoriaService tipoCategoriaService;

    @Autowired
    private CategoriaLancamentoService categoriaLancamentoService;

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ModelAndView categoriaLancamento(){
        ModelAndView mv = new ModelAndView("categoria/cadastro");
        mv.addObject("categoria", new CategoriaLancamento());
        mv.addObject("tipoCategorias", tipoCategoriaService.getTipoCategoria());
        mv.addObject("categorias", categoriaLancamentoService.getCategoriasLancamento());
        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute CategoriaLancamento categoriaLancamento){
        try {
            categoriaLancamentoService.salvar(categoriaLancamento);
        }catch (Exception e){
            System.out.println("Lançar o erro para a tela!!!!");
        }
        return "redirect:/categoria";
    }

    @RequestMapping(value = "/cadastro/rapido", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<?> cadastrarRapido(@RequestBody CategoriaLancamento categoria){
        try{
            categoria = categoriaLancamentoService.salvar(categoria);
        }catch (CategoriaJaCadastradoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(categoria);
    }

    @RequestMapping(value = "/buscar/categoria", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<?> buscarCategoriaPorTipo(@RequestBody TipoCategoria tipoCategoria){
        List<CategoriaLancamento> categorias = new ArrayList<>();
        try{
            categorias = categoriaLancamentoService.buscarCategoriaPorTipo(tipoCategoria);
        }catch (CategoriaJaCadastradoException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/tipo")
    public ModelAndView tipoCategoria(){
        ModelAndView mv = new ModelAndView("categoria/tipo_cadastro");
        mv.addObject("tipoCategorias", tipoCategoriaService.getTipoCategoria());
        return mv;
    }

    @PostMapping("/cadastro/tipo")
    public String cadastrar(@ModelAttribute TipoCategoria tipoCategoria){
        tipoCategoriaService.salvar(tipoCategoria);
        return "redirect:/categoria/tipo";
    }
}
