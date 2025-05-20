import java.util.Scanner;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

public class Main extends ListenerAdapter
{
     BanList test = new BanList(); //Banlist
    public static void main(String[] args) throws LoginException
    {
    
    JDABuilder builder = new JDABuilder(AccountType.BOT); //Discord Setup
    String token="";
    builder.setToken(token);
    builder.buildAsync();

    }

    public void onMessageRecieved(MessageRecievedEvent event) {
    String incMessage=event.getMessage().getContentDisplay();
    System.out.println(event.getAuthor().getname()+"sent: "+incMessage);


    String close=event.getMessage().getContentRaw();

    Boolean ban=true;
    System.out.println("Enter word");
    if (incMessage.equals("checkCurrentList")) {
        System.out.println(test.current());
        ban=false;
    }
    if (incMessage.equals("checkAllList")){
         System.out.println(test.ever());
   ban=false;
    }
    if (ban)
    {
        test.banning(close);
    }
    }
}
