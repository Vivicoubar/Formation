package fr.vivicoubar.test;

import org.bukkit.Bukkit;

public class Question {
// Paramètres

    private final String annonce;
    private final String answer;
//Constructeur

    public Question(String message, String rep){
        this.annonce = message;
        this.answer = rep;
        Bukkit.broadcastMessage("§b[Nouvelle Question]:§a " + message);
    }

//méthodes getter/setters

    public String getAnswer() {
        return answer;
    }

    public String getAnnonce() {
        return annonce;
    }
}
