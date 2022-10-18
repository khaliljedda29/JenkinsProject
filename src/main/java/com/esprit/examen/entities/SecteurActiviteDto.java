package com.esprit.examen.entities;
import lombok.Data;


import java.util.Set;


@Data
public class SecteurActiviteDto {
    private Long idSecteurActivite;
    private String codeSecteurActivite;
    private String libelleSecteurActivite;
    private Set<Fournisseur> fournisseurs;
}
