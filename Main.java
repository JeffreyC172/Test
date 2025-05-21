import java.util.Scanner;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

public class Main extends ListenerAdapter
{
     BanList test = new BanList(); //Banlist
     char commandIdentifier='!';
    public static void main(String[] args) throws LoginException
    {
    
    JDABuilder builder = new JDABuilder(AccountType.BOT); //Discord Setup
    String token="";
    builder.setToken(token);
    builder.buildAsync();

    }


    public void onMessageRecieved(MessageRecievedEvent event) 
    {
    String incMessage=event.getMessage().getContentDisplay();
    System.out.println(event.getAuthor().getname()+"sent: "+incMessage);
    String close=event.getMessage().getContentRaw();
    Boolean ban=true;
    if (close.length()>0&&close.charAt(0)==commandIdentifier)
    {
     System.out.println("Enter word");
     if (close.contains("checkCurrentList")) 
     {
         System.out.println(test.current());
     }
     else if (close.contains("checkAllList"))
     {
          System.out.println(test.ever());
     }
     else if (close.contains("ban"))
     {
     test.banning(close.substring(5,close.length()));
     }
    }
    else
    {
     for (int i=0;i<test.currentLength();i++)
      {
         if (close.contains(test.wordAt(i)))
         {
            
         }
        }
    }
 }
}
