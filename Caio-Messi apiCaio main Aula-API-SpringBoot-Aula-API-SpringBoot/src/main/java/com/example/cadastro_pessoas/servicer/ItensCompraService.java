package com.example.cadastro_pessoas.servicer;

import com.example.cadastro_pessoas.model.ItensCompraModel;
import com.example.cadastro_pessoas.repository.ItensComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensCompraService {
@Autowired
    private ItensComprasRepository repository;

    public List <ItensCompraModel> listarTodos(){return repository.findAll();}
    public Optional <ItensCompraModel> buscarPorID(Long id){return repository.findById(id);}
    public ItensCompraModel salvatItens(ItensCompraModel itens){return repository.save(itens);}
    public void deletarItens(Long id){repository.deleteById(id);}
}
