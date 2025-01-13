package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "filiere")
public class Filiere {
    @Id
    private String code;

    @Column(unique = true, nullable = false)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY) //si on charge Filiere depuis la base de donnés, Departement ne sera pas chargé immédiatement
    @JoinColumn(name = "DEPARTEMENT")
    private Departement departement;

    // Role de LAZY dans ce code
    //Quand vous chargez une Filière, son Département associé n'est PAS immédiatement chargé de la base de données
    //Le Département sera chargé UNIQUEMENT lorsque vous y accédez explicitement dans votre code via filiere.getDepartement()
}