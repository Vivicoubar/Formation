package fr.vivicoubar.test.commands;

import fr.vivicoubar.test.Question;
import fr.vivicoubar.test.TestMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandQuestion implements CommandExecutor {
    private TestMain main;

    public CommandQuestion(TestMain testMain) {
        this.main = testMain;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player sender = (Player) commandSender;
            sender.sendMessage("Question envoyée!");
            //UTILISATION DU CONSTRUCTEUR new = nouvel objet
            Question question = new Question("Quelle est la capitale de l'angleterre?", "Londres");
            //Je récupère la liste des questions et j'ajoute une autre question
            main.getQuestionList().add(question);
            return true;
        }
        return false;
    }
}
