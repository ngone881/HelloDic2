package sn.edu.ept.git.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Etudiant {
    @Id
    private Integer id;

    private String nom;

    private String prenom;

    private String telephone;

    private String adresse;
}