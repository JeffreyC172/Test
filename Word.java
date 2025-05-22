package com.apcsa.democracybot;

public class Word
{
    @SuppressWarnings("FieldMayBeFinal")
    private String bannedWord;
    private int timesBanned=1;
    private int daysSinceBan=0;
    private boolean banned=true;

    public Word(String bannedWord)
    {
        this.bannedWord=bannedWord;
    }

    public int retTimesBanned()
    {
        return timesBanned;
    }

    public void ban(){
        timesBanned++;
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
        return daysSinceBan >= 7;
    }

    public String getWord()
    {
        return bannedWord;
    }

    public String wordData(){
        return "||"+"com.apcsa.democracybot.Word: " + bannedWord + ", Is banned: " + banned + ", Banned: " + timesBanned + " times.";
    }

    public void earlyRemove(){
        daysSinceBan=0;
        banned=false;
    }

    public String toString(){
        return bannedWord;
    }
}