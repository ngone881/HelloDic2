package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("ELEVE-INGENIEUR") //inutile dans ce type d'héritage
public class Etudiant extends Personne{

    @OneToOne(mappedBy = "etudiant")
    private Carte carte;

    @OneToOne
    private Etudiant voisin;

    private Integer numeroChambre;

    @Column(nullable = false)
    private String pavillon;
}


