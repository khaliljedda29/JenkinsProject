package com.esprit.examen.controllers;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private String libelleStock;
    private Integer qte;
    private Integer qteMin;
}
