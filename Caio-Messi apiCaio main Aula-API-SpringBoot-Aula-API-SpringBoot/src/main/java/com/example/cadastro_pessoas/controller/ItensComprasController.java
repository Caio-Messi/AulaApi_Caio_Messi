package com.example.cadastro_pessoas.controller;

import com.example.cadastro_pessoas.model.ItensCompraModel;
import com.example.cadastro_pessoas.servicer.ItensCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/itensCompras")
public class ItensComprasController  {
    @Autowired
    private ItensCompraService service;

    @GetMapping
    public List <ItensCompraModel> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping ("/{id}")
    public ResponseEntity <ItensCompraModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ItensCompraModel salvarItens(@RequestBody ItensCompraModel itens){
        return service.salvatItens(itens);
    }
    @PutMapping ("/{id}")
    public ResponseEntity <ItensCompraModel> atualizarItens(@PathVariable Long id, @RequestBody ItensCompraModel itens){
        if(!service.buscarPorID(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        ItensCompraModel idItens = new ItensCompraModel();
        idItens.setId(id);

        return ResponseEntity.ok(service.salvatItens(itens));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        if(!service.buscarPorID(id).isPresent()){
            return ResponseEntity .notFound().build();
        }
        service.deletarItens(id);
        return ResponseEntity.noContent().build();
    }
}
