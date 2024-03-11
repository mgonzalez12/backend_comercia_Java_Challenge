package com.tech.apicomerciatech.infrastruture.adapter.entity;


import com.tech.apicomerciatech.infrastruture.adapter.enums.TipoJuego;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private TipoJuego type;
    private Double premiumPrice;
    private Double basicPrice;

}
