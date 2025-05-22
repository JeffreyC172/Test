package com.apcsa.democracybot;

public class Users
{
private String username;
private String userid;
private int violations=1;
private int banDuration=1;

public Users(String username, String userid){
    this.username=username;
    this.userid=userid;

}

public void hourPass(){
banDuration--;
}

public boolean doUnmute(){
if (banDuration==0) return true;
return false;   
}

public void repeatOffense()
{
violations++;
}

public int getNumViolations(){
    return violations;
}

public String getId(){
    return userid;
}

 
}