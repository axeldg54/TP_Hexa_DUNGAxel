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

    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    public void compare(String essai) {
        for (char c : essai.toCharArray()) {
            resultat.add(evaluationCaractere(c));
            position++;
        }
    }

    public boolean lettresToutesPlacees() {
        return resultat.stream().allMatch(lettre -> lettre == Lettre.PLACEE);
    }

    public List<Lettre> lettresResultat() {
        return unmodifiableList(resultat);
    }

    private Lettre evaluationCaractere(char carCourant) {
        if (estPlace(carCourant)) return Lettre.PLACEE;
        else if (estPresent(carCourant)) return Lettre.NON_PLACEE;
        else return Lettre.INCORRECTE;
    }

    private boolean estPresent(char carCourant) {
        var resultat = motSecret.chars();
        return resultat.anyMatch(car -> car == carCourant);
    }

    private boolean estPlace(char carCourant) {
        return motSecret.charAt(position) == carCourant;
    }
}