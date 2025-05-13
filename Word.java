public class Word
{
private String bannedWord="";
private int timesBanned=1;
private int daysSinceBan=0;
private boolean banned = false;

public Word(String bannedWord)
 {
this.bannedWord=bannedWord;
banned=true;
 }

public int retTimesBanned()
 {
return timesBanned;
 }

public void ban(){
timesBanned++;
daysSinceBan=0;
banned=true;
 }

public void dayPass()
 {
daysSinceBan++;
 }

 public boolean isBanned(){
    return banned;
 }

public boolean doRemove()
 {
if (daysSinceBan>=7) {
    return true;
}
return false;
}

public String getWord()
 {
return bannedWord;
 }

public String wordData(){
return "Word: " + bannedWord + ". Is banned: " + banned + ". Banned:" + timesBanned + "times.";
}

public void earlyRemove(){
daysSinceBan=0;
banned=false;
}
}