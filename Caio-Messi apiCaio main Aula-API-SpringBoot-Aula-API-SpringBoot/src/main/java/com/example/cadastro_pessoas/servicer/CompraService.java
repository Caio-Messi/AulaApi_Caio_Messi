package com.example.cadastro_pessoas.servicer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.ComprasModel;
import com.example.cadastro_pessoas.model.PessoasModel;
import com.example.cadastro_pessoas.repository.ComprasRepository;

@Service
public class CompraService {
    @Autowired
    private ComprasRepository repository;
    
    @Autowired
    private PessoasService pessoasService;


    public List<ComprasModel> listarTodos(){
        return repository.findAll();
    }
    public Optional <ComprasModel> buscarPorId(Long id){
        return repository.findById(id);
    }
    
    public ComprasModel salvarCompras(ComprasModel compras){

        Optional<PessoasModel> pessoa = pessoasService.buscarPorId(compras.getPessoa_ID());

        if (pessoa.isPresent()) {
            return repository.save(compras); // ou outro atributo
        } else {
            throw new RuntimeException("Pessoa não encontrada");
        }

    }
    
    public void deletarCompras(Long id){
        repository.deleteById(id);
    }

}
