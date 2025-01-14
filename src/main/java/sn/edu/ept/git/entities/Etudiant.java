package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder //gère l'héritage alorsque Builder ne gère pas l'héritage
@Entity
@DiscriminatorValue("ELEVE-INGENIEUR")
public class Etudiant extends Personne {

    @OneToOne(mappedBy = "etudiant")
    private Carte carte;

    @OneToOne
    private Etudiant voisin;

    private Integer numeroChambre;

    @Column(nullable = false)
    private String pavillon;
}


