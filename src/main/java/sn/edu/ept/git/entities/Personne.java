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

@MappedSuperclass//L'annotation @MappedSuperclass permet de définir une classe parent dont les champs et annotations seront hérités par ses sous-classes persistentes, sans créer de table distincte pour elle dans la base de données
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "ROLE")
@DiscriminatorValue("EMPLOYE")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String adresse;

    private LocalDate dateNaissance;
    @ManyToOne
    private Pays paysNaissance;

    @ManyToMany
    private List<Pays> nationalites;
}
