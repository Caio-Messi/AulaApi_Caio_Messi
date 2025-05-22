package com.example.cadastro_pessoas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "produtos")
@Getter
@Setter
@NoArgsConstructor
public class ProdutoModel {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idProduto;
  
    @Column (nullable = false)
    private String name; 
    
    @Column (nullable = false)
    private Double precoProduto;

    @Column (nullable = false)
    private int quantEstoque;

    @Column (nullable = false)
    private String descricao;
}

