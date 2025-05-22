package com.example.cadastro_pessoas.servicer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.ProdutoModel;
import com.example.cadastro_pessoas.repository.ProdutosRepository;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository repository;

    public List<ProdutoModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId (Long id){
        return repository.findById(id);
     }

    public ProdutoModel salvarProdutos (ProdutoModel produtoModel){
        return repository.save(produtoModel);
    } 

    public void deletarProdutos (Long id){
        repository.deleteById(id);
    }





}
