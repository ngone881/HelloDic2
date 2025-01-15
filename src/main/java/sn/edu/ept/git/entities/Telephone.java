package sn.edu.ept.git.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Telephone {
    @Id
    private int id;
    private String number;
    private String operateur;

    //sa ret lation avec Personne est supprimée car celle-ci a maintenant cette annotation : MappedSuperclass
}
