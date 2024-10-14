package org.iut.mastermind.domain.partie;

import java.util.Objects;

public class Joueur {

    private final String nom;

    // constructeur
    public Joueur(String nom) {
        this.nom = nom;
    }

    // getter nom joueur
    public String getNom() {
        return nom;
    }

    // equals
    @Override
    public boolean equals(Object o) {
       if (o instanceof Joueur) {
           Joueur joueur = (Joueur) o;
           return this.nom.equals(joueur.nom);
       } else {
           return false;
       }
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
