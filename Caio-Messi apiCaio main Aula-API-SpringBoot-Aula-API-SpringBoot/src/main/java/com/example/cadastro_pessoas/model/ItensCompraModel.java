package com.example.cadastro_pessoas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Itens_Compra")
@Getter
@Setter
@NoArgsConstructor

public class ItensCompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private Double preco;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;

    @ManyToOne
    @JoinColumn (name= "compra_id")
    private ComprasModel compra;



}
