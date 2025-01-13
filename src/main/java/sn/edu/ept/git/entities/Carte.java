package sn.edu.ept.git.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "carte")
public class Carte {
  @Id //la valeur de l'id ne peut pas etre changé
  private String code;
  private Date dateCreation;
  private Date dateModification;
  private Date dateDebut;
  private Date dateFin;

  @OneToOne(cascade = CascadeType.PERSIST)// si Carte est persistée, Etudiant va etre persistée elle aussi
  private Etudiant etudiant;

  //exemple d'un intercepteur
  @PrePersist//avant de créer pour chaque objet enregistré il va d'abord  executer la methode. Avant qu'une nouvelle entité ne soit insérée dans la base de données
  @PreUpdate // mettre à jour la carte donc date de modification change. Avant qu'une entité existante ne soit mise à jour dans la base de données
  public void beforeCreate(){
    this.dateCreation = new Date();
    this.dateModification = new Date();
  }

  // il est préférable de mettre une autre methode pour update
}