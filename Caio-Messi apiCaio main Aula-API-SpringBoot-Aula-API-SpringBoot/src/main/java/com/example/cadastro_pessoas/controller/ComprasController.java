package com.example.cadastro_pessoas.controller;

import java.util.List; // Para lidar com listas de objetos

import com.example.cadastro_pessoas.model.ComprasModel;
import com.example.cadastro_pessoas.servicer.CompraService;
import org.springframework.beans.factory.annotation.Autowired; // Injeção de dependência
import org.springframework.http.ResponseEntity; // Representa respostas HTTP
import org.springframework.web.bind.annotation.DeleteMapping; // Mapeia requisições DELETE
import org.springframework.web.bind.annotation.GetMapping; // Mapeia requisições GET
import org.springframework.web.bind.annotation.PathVariable; // Captura parâmetros da URL
import org.springframework.web.bind.annotation.PostMapping; // Mapeia requisições POST
import org.springframework.web.bind.annotation.PutMapping; // Mapeia requisições PUT
import org.springframework.web.bind.annotation.RequestBody; // Indica que o corpo da requisição é o objeto
import org.springframework.web.bind.annotation.RequestMapping; // Mapeia o caminho base da API
import org.springframework.web.bind.annotation.RestController; // Indica que esta classe é um Controller REST


@RestController
@RequestMapping ("/api/compras")
public class ComprasController {
    @Autowired
    private CompraService service;

    @GetMapping 
    public List<ComprasModel> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping ("/{id}")
    public ResponseEntity <ComprasModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ComprasModel salvarCompras (@RequestBody ComprasModel compras){
        return service.salvarCompras(compras);  
    }

    @PutMapping ("/{id}")
    public ResponseEntity <ComprasModel> atualizar (@PathVariable Long id, @RequestBody ComprasModel compras){
        if(!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        ComprasModel compra = new ComprasModel();
        compra.setId_compra(id);

    return ResponseEntity.ok(service.salvarCompras(compras));
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        if(!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        service.deletarCompras(id);
        return ResponseEntity.noContent().build();
    }
}
