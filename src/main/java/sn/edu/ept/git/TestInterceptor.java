package sn.edu.ept.git;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.ept.git.entities.Carte;
import sn.edu.ept.git.entities.Etudiant;
import sn.edu.ept.git.entities.Personne;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestInterceptor {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        EntityManagerFactory emf= Persistence
                .createEntityManagerFactory("dic2Pu");
        EntityManager em = emf.createEntityManager();

        Etudiant touba = Etudiant.builder()
                .numeroChambre(17)
                .nom("Fall")
                .prenom("Touba")
                .adresse("Pikine")
                .pavillon("H4")
                .build();

        Carte toubaCarte = Carte.builder()
                        .code("ddk")
                        .etudiant(touba)
                        .dateDebut(new GregorianCalendar(2024, Calendar.OCTOBER, 1).getTime())
                        .dateFin(new GregorianCalendar(2025, Calendar.DECEMBER, 8).getTime())
                        .build();
        System.out.println("####" + toubaCarte.getDateCreation()); //null car l'intercepteur @PrePersist n'a pas encore été appelé

        em.getTransaction().begin();
//        em.persist(touba); car si je persite carte, étudiant va etre forcement persister
        em.persist(toubaCarte);
        System.out.println("####" + toubaCarte.getDateCreation()); //L'intercepteur @PrePersist a été déclenché au moment de la persistance

//        Personne p = Personne.builder()
//                        .adresse("Pikine")
//                        .nom("Fall")
//                        .prenom("Touba")
//                        .build();
//
//        em.persist(p);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}