package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.unmodifiableList;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();
    private int position;

    public Reponse(String mot) {
        this.motSecret = mot;
    }

    // on récupère la lettre à la position dans le résultat
    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai) {
        for (char c : essai.toCharArray()) {
            resultat.add(evaluationCaractere(c));
            position++;
        }
    }

    // si toutes les lettres sont placées
    public boolean lettresToutesPlacees() {
        return resultat.stream().allMatch(lettre -> lettre == Lettre.PLACEE);
    }

    public List<Lettre> lettresResultat() {
        return unmodifiableList(resultat);
    }

    // renvoie le statut du caractère
    private Lettre evaluationCaractere(char carCourant) {
        if (estPlace(carCourant)) return Lettre.PLACEE;
        else if (estPresent(carCourant)) return Lettre.NON_PLACEE;
        else return Lettre.INCORRECTE;
    }

    // le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant) {
        var resultat = motSecret.chars();
        return resultat.anyMatch(car -> car == carCourant);
    }

    // le caractère est placé dans le mot secret
    private boolean estPlace(char carCourant) {
        if (estPresent(carCourant)) {
            return motSecret.charAt(position) == carCourant;
        } else {
            return false;
        }

    }
}
