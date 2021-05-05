package fr.vivicoubar.test;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private final TestMain main;

    public JoinListener(TestMain testMain) {
        this.main = testMain;
    }
    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent playerJoinEvent){
        Player joiner = playerJoinEvent.getPlayer();
        playerJoinEvent.setJoinMessage(ChatColor.YELLOW + joiner.getDisplayName() +" a rejoint la partie!");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent chatEvent){
        String message = chatEvent.getMessage();
        //On a nos questions qui sont posées
        //Quand un joueur envoie un message, il faut que on regarde dans toutes les questions posées
        // si son message est la réponde d'une des questions.
        //et si oui, lui dire bravo.
        for(Question question : main.getQuestionList()) {
            //faire quelque chose pour tous les élements d'une liste
            //Syntaxe : for(Objet nom : laliste){}
            if(question.getAnswer().equalsIgnoreCase(message)){
                chatEvent.getPlayer().sendMessage("§aBravo!");
                Bukkit.broadcastMessage("§e" + chatEvent.getPlayer().getDisplayName() + " a répondu correctement à la question!");
                Bukkit.broadcastMessage("§e" + question.getAnnonce());
                Bukkit.broadcastMessage("§e" + question.getAnswer());
                //Supprime la question de la liste
                main.getQuestionList().remove(question);
                //J'annule l'event (ici, je n'affiche pas le message du joueur)
                chatEvent.setCancelled(true);
                // ATTENTION, on a supprimé un élément de la liste qu'on parcourt dans la boucle for > on arrête la boucle break;
                break;
            }
        }
        for(Anagram anagram : main.getAnagramList()){
            if(anagram.getAnswer().equalsIgnoreCase(chatEvent.getMessage()) && anagram.isActive()){
                Bukkit.broadcastMessage("§e" + chatEvent.getPlayer().getDisplayName() + " a répondu correctement à l'anagramme");
                Bukkit.broadcastMessage("§eLa réponse était : " + anagram.getAnswer());
                main.getAnagramList().remove(anagram);
                chatEvent.setCancelled(true);
                break;
            }
        }
    }


}
