package com.example.cadastro_pessoas.repository;

import com.example.cadastro_pessoas.model.ItensCompraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensComprasRepository extends JpaRepository <ItensCompraModel, Long> {
}
