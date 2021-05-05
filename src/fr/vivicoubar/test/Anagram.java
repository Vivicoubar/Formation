package fr.vivicoubar.test;

import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Anagram {
    private String anagramme;
    private String reponse;
    private boolean isActive;

    public Anagram(String rep){
        this.reponse = rep;

        List<Character> characterList = new ArrayList<>();
        for(char lettre : rep.toCharArray()){
            characterList.add(lettre);
        }
        anagramme = "";
        //Tant que ma liste n'est pas de taille 0, je supprime un élement pour l'ajouter à anagramme
        while(characterList.size() > 0){
            //Déclaration d'un nouveau générateur d'aléatoire
            Random random = new Random();
            //On récupère un entier aléatoire entre 0 et la taille maximum de la liste -1
            int entieraleatoire = random.nextInt(characterList.size());
            //On ajoute la lettre qu'on a récupérée
            anagramme += characterList.get(entieraleatoire);
            //On supprime la lettre(pour ne pas la répéter deux fois)
            characterList.remove(entieraleatoire);
        }
    }

    public String getAnswer(){
        return reponse;
    }
    public boolean isActive(){
        return isActive;
    }
    //Setter
    public void setActive(boolean bool){
        isActive = bool;
    }
}
