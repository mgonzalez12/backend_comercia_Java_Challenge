package com.tech.apicomerciatech.infrastruture.adapter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Client cliente;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_juego", nullable = false)
    private Games juego;

    @Min(1)
    private Integer diasAlquiladosSolicitados;
    private Integer diasAlquiladosReales;

    @NotNull
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private Double precioTotal;
    private Double recargoRetraso;
}
