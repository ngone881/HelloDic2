package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ROLE")
@DiscriminatorValue("EMPLOYE")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) //généré automatiquement par la base de données
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String telephone;

    private String adresse;

    private LocalDate dateNaissance;

    @ManyToOne
    private Pays paysNaissance;

    @ManyToMany
    private List<Pays> nationalites;

}
