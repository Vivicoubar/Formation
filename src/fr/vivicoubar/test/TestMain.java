package fr.vivicoubar.test;

import fr.vivicoubar.test.commands.CommandAnagram;
import fr.vivicoubar.test.commands.CommandHello;
import fr.vivicoubar.test.commands.CommandQuestion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class TestMain extends JavaPlugin {


    //Création d'une liste
    //portée final(on ne recréera jamais d'autre liste pour stocker des questions)
    // List<Objet> (ce sera une liste d'objets Objet.
    // nom de la variable
    //= new ArrayList() > création d'une nouvelle liste vide.
    private final List<Question> questionList = new ArrayList<>();

    private final List<Anagram> anagramList = new ArrayList<>();

    @Override
    public void onEnable() {
        System.out.println("Démarrage du plugin");

        PluginManager pluginManager = Bukkit.getPluginManager();
        getCommand("hello").setExecutor(new CommandHello());
        getCommand("question").setExecutor(new CommandQuestion(this));
        getCommand("anagram").setExecutor(new CommandAnagram(this));
        pluginManager.registerEvents(new JoinListener(this), this);



        anagramList.add(new Anagram("poulet"));
    }
    //getter portée, Un type de variable retour, nomdelaméthode(paramètres) {return la variable)
    public List<Question> getQuestionList() {
        return questionList;
    }
    public List<Anagram> getAnagramList() {
        return anagramList;
    }
    //setter
}

