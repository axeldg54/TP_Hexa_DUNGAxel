package org.iut.mastermind.domain.partie;

import org.iut.mastermind.domain.proposition.Reponse;

public class Partie {
    private static final int NB_ESSAIS_MAX = 5;
    private final Joueur joueur;
    private final String motADeviner;
    private int nbEssais;
    private boolean partieTerminee;

    public Partie(Joueur joueur, String motADeviner, int nbEssais, boolean partieTerminee) {
        this.joueur = joueur;
        this.motADeviner = motADeviner;
        this.nbEssais = nbEssais;
        this.partieTerminee = partieTerminee;
    }

    public static Partie create(Joueur joueur, String motADeviner) {
        return new Partie(joueur, motADeviner, 0, false);
    }

    public static Partie create(Joueur joueur, String motADeviner, int nbEssais) {
        return new Partie(joueur, motADeviner, nbEssais, false);
    }

    public Joueur getJoueur() {
        return joueur;
    }
    public int getNbEssais() {return nbEssais;}
    public String getMot() {
        return motADeviner;
    }
    public boolean getPartieTerminee() {return partieTerminee;}
    public void setPartieTerminee(boolean partieTerminee) {this.partieTerminee = partieTerminee;}

    public Reponse tourDeJeu(String motPropose) {
        nbEssais++;
        Reponse reponse = new Reponse(motADeviner);
        if (nbEssais >= NB_ESSAIS_MAX) {
            partieTerminee = true;
        } else {
            reponse.compare(motPropose);
            partieTerminee = reponse.lettresToutesPlacees();
        }
        return reponse;
    }
}