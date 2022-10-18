package com.esprit.examen.entities;

import java.util.Date;
import java.util.Set;
import lombok.Data;

@Data
public class ProduitDto {
    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prix;
    private Date dateCreation;
    private Date dateDerniereModification;
    private Stock stock;
    private Set<DetailFacture> detailFacture;
    private CategorieProduit categorieProduit;
}
