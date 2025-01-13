package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) //généré automatiquement par la base de données
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(name = "DATE_NAISSANCE")
    private LocalDate dateNaissance;

    private String lieuNaissance;

    private String adresse;

}
