package com.example.cadastro_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cadastro_pessoas.model.ProdutoModel;
import com.example.cadastro_pessoas.servicer.ProdutosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController

@RequestMapping ("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutosService service;

    @GetMapping
    public List<ProdutoModel> listarTodos (){
        return service.listarTodos();
    }

    @GetMapping ("/{id}")
    public ResponseEntity <ProdutoModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProdutoModel salvarProduto (@RequestBody ProdutoModel produtoModel){
        return service.salvarProdutos(produtoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity <ProdutoModel> atualizarProduto (@PathVariable Long id,@RequestBody ProdutoModel produtoModel){
        if (!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        produtoModel.setIdProduto(id);
        return ResponseEntity.ok(service.salvarProdutos(produtoModel));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletarProduto (@PathVariable Long id){
        if(!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        service.deletarProdutos(id);
        return ResponseEntity.noContent().build();
    }
}
    

