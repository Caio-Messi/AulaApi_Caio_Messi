package com.example.cadastro_pessoas.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compras")
@Getter
@Setter
@NoArgsConstructor

public class ComprasModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_compra;

    @Column(nullable = false, updatable = false)
    private java.time.LocalDateTime dataCompra;

    @Column(nullable = false)
    private Long pessoa_ID;

     @PrePersist
    public void prePersist() {
        if (this.dataCompra == null) {
            this.dataCompra = java.time.LocalDateTime.now(); // Atribui apenas a data atual, sem hora
        }
    }
}
